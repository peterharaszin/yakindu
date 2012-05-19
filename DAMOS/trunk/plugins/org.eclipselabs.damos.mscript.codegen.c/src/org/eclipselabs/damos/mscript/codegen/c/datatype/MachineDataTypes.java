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
import org.eclipselabs.damos.mscript.DataType;
import org.eclipselabs.damos.mscript.NumericType;
import org.eclipselabs.damos.mscript.StructMember;
import org.eclipselabs.damos.mscript.StructType;
import org.eclipselabs.damos.mscript.computationmodel.ComputationModel;
import org.eclipselabs.damos.mscript.util.TypeUtil;

/**
 * @author Andreas Unger
 * 
 */
public class MachineDataTypes {

	public static MachineDataType create(ComputationModel computationModel, DataType type) {
		if (type instanceof BooleanType) {
			return create(computationModel, (BooleanType) type);
		}
		if (type instanceof NumericType) {
			return create(computationModel, (NumericType) type);
		}
		if (type instanceof StructType) {
			return create(computationModel, (StructType) type);
		}
		if (type instanceof ArrayType) {
			return create(computationModel, (ArrayType) type);
		}
		throw new IllegalArgumentException("Unknown data type class " + type.getClass().getCanonicalName());
	}
	
	public static MachineBooleanType create(ComputationModel computationModel, BooleanType booleanType) {
		return new MachineBooleanType();
	}

	public static MachineNumericType create(ComputationModel computationModel, NumericType numericType) {
		return new MachineNumericType(computationModel.getNumberFormat(numericType));
	}

	public static MachineArrayType create(ComputationModel computationModel, ArrayType arrayType) {
		int[] dimensions = new int[arrayType.getDimensionality()];
		for (int i = 0; i < dimensions.length; ++i) {
			dimensions[i] = TypeUtil.getArrayDimensionSize(arrayType.getDimensions().get(i));
		}
		return new MachineArrayType(create(computationModel, arrayType.getElementType()), dimensions);
	}

	public static MachineStructType create(ComputationModel computationModel, StructType structType) {
		List<MachineStructMember> machineStructMembers = new ArrayList<MachineStructMember>();
		for (StructMember structMember : structType.getMembers()) {
			machineStructMembers.add(new MachineStructMember(structMember.getName(), create(computationModel,
					structMember.getTypeSpecifier().getType())));
		}
		return new MachineStructType(Collections.unmodifiableList(machineStructMembers));
	}

}
