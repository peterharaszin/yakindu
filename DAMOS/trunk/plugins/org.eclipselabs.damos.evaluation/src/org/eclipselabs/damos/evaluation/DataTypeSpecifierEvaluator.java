/****************************************************************************
 * Copyright (c) 2008, 2010 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipselabs.damos.evaluation;

import org.eclipselabs.damos.evaluation.internal.InvalidUnitExpressionOperandException;
import org.eclipselabs.damos.evaluation.internal.UnitExpressionHelper;
import org.eclipselabs.damos.scripting.mscript.BooleanTypeSpecifier;
import org.eclipselabs.damos.scripting.mscript.IntegerTypeSpecifier;
import org.eclipselabs.damos.scripting.mscript.RealTypeSpecifier;
import org.eclipselabs.damos.scripting.mscript.util.MscriptSwitch;
import org.eclipselabs.damos.typesystem.DataType;
import org.eclipselabs.damos.typesystem.IntegerType;
import org.eclipselabs.damos.typesystem.RealType;
import org.eclipselabs.damos.typesystem.TypeSystemFactory;
import org.eclipselabs.damos.typesystem.util.TypeSystemUtil;

/**
 * @author Andreas Unger
 *
 */
public class DataTypeSpecifierEvaluator extends MscriptSwitch<DataType> {
	
//	private IEvaluationContext context;
	
	/**
	 * 
	 */
	public DataTypeSpecifierEvaluator(IEvaluationContext context) {
//		this.context = context;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.scripting.mscript.util.MscriptSwitch#caseRealTypeSpecifier(org.eclipselabs.damos.scripting.mscript.RealTypeSpecifier)
	 */
	@Override
	public DataType caseRealTypeSpecifier(RealTypeSpecifier object) {
		RealType realType = (RealType) TypeSystemFactory.eINSTANCE.createRealType();
		try {
			if (object.getUnit() != null) {
				realType.setUnit(new UnitExpressionHelper().evaluate(object.getUnit()));
			} else {
				realType.setUnit(TypeSystemUtil.createUnit());
			}
		} catch (InvalidUnitExpressionOperandException e) {
			return TypeSystemFactory.eINSTANCE.createInvalidDataType();
		}
		return realType;
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.scripting.mscript.util.MscriptSwitch#caseIntegerTypeSpecifier(org.eclipselabs.damos.scripting.mscript.IntegerTypeSpecifier)
	 */
	@Override
	public DataType caseIntegerTypeSpecifier(IntegerTypeSpecifier object) {
		IntegerType integerType = (IntegerType) TypeSystemFactory.eINSTANCE.createIntegerType();
		try {
			if (object.getUnit() != null) {
				integerType.setUnit(new UnitExpressionHelper().evaluate(object.getUnit()));
			} else {
				integerType.setUnit(TypeSystemUtil.createUnit());
			}
		} catch (InvalidUnitExpressionOperandException e) {
			return TypeSystemFactory.eINSTANCE.createInvalidDataType();
		}
		return integerType;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.scripting.mscript.util.MscriptSwitch#caseBooleanTypeSpecifier(org.eclipselabs.damos.scripting.mscript.BooleanTypeSpecifier)
	 */
	@Override
	public DataType caseBooleanTypeSpecifier(BooleanTypeSpecifier object) {
		return TypeSystemFactory.eINSTANCE.createBooleanType();
	}

}
