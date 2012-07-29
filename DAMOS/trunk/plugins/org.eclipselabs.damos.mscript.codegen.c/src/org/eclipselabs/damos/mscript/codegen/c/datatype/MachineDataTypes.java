/****************************************************************************
 * Copyright (c) 2008, 2012 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipselabs.damos.mscript.codegen.c.datatype;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipselabs.damos.mscript.ArrayType;
import org.eclipselabs.damos.mscript.BooleanType;
import org.eclipselabs.damos.mscript.CompositeTypeMember;
import org.eclipselabs.damos.mscript.NumericType;
import org.eclipselabs.damos.mscript.RecordType;
import org.eclipselabs.damos.mscript.StringType;
import org.eclipselabs.damos.mscript.Type;
import org.eclipselabs.damos.mscript.UnionType;
import org.eclipselabs.damos.mscript.codegen.c.IMscriptGeneratorConfiguration;
import org.eclipselabs.damos.mscript.util.TypeUtil;

/**
 * @author Andreas Unger
 * 
 */
public class MachineDataTypes {

	public static MachineDataType create(IMscriptGeneratorConfiguration configuration, Type type) {
		if (type instanceof BooleanType) {
			return create(configuration, (BooleanType) type);
		}
		if (type instanceof NumericType) {
			return create(configuration, (NumericType) type);
		}
		if (type instanceof StringType) {
			return create(configuration, (StringType) type);
		}
		if (type instanceof RecordType) {
			return create(configuration, (RecordType) type);
		}
		if (type instanceof UnionType) {
			return create(configuration, (UnionType) type);
		}
		if (type instanceof ArrayType) {
			return create(configuration, (ArrayType) type);
		}
		throw new IllegalArgumentException("Unknown data type class " + type.getClass().getCanonicalName());
	}
	
	public static MachineBooleanType create(IMscriptGeneratorConfiguration configuration, BooleanType booleanType) {
		return new MachineBooleanType();
	}

	public static MachineNumericType create(IMscriptGeneratorConfiguration configuration, NumericType numericType) {
		return new MachineNumericType(configuration.getComputationModel().getNumberFormat(numericType));
	}

	public static MachineStringType create(IMscriptGeneratorConfiguration configuration, StringType booleanType) {
		return new MachineStringType(configuration.getStringBufferSize());
	}

	public static MachineArrayType create(IMscriptGeneratorConfiguration configuration, ArrayType arrayType) {
		int[] dimensionSizes = new int[arrayType.getDimensionality()];
		for (int i = 0; i < dimensionSizes.length; ++i) {
			dimensionSizes[i] = TypeUtil.getArrayDimensionSize(arrayType.getDimensions().get(i));
		}
		return new MachineArrayType(create(configuration, arrayType.getElementType()), dimensionSizes);
	}

	public static MachineRecordType create(IMscriptGeneratorConfiguration configuration, RecordType recordType) {
		List<MachineCompositeTypeMember> machineCompositeTypeMembers = new ArrayList<MachineCompositeTypeMember>();
		for (CompositeTypeMember compositeTypeMember : recordType.getMembers()) {
			machineCompositeTypeMembers.add(new MachineCompositeTypeMember(compositeTypeMember.getName(), create(configuration, compositeTypeMember.getType())));
		}
		return new MachineRecordType(Collections.unmodifiableList(machineCompositeTypeMembers));
	}

	public static MachineUnionType create(IMscriptGeneratorConfiguration configuration, UnionType unionType) {
		List<MachineCompositeTypeMember> machineCompositeTypeMembers = new ArrayList<MachineCompositeTypeMember>();
		for (CompositeTypeMember compositeTypeMember : unionType.getMembers()) {
			machineCompositeTypeMembers.add(new MachineCompositeTypeMember(compositeTypeMember.getName(), create(configuration, compositeTypeMember.getType())));
		}
		return new MachineUnionType(Collections.unmodifiableList(machineCompositeTypeMembers));
	}

}
