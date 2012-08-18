/****************************************************************************
 * Copyright (c) 2008, 2011 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipselabs.damos.mscript.internal.operations;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipselabs.damos.mscript.BaseUnitDeclaration;
import org.eclipselabs.damos.mscript.MscriptFactory;
import org.eclipselabs.damos.mscript.OperatorKind;
import org.eclipselabs.damos.mscript.Unit;
import org.eclipselabs.damos.mscript.UnitFactor;
import org.eclipselabs.damos.mscript.UnitSymbol;

/**
 * @author Andreas Unger
 *
 */
public class UnitOperations {
	
	public static Unit getNormalized(Unit unit) {
		Unit result = MscriptFactory.eINSTANCE.createUnit();
		result.setNumerator(MscriptFactory.eINSTANCE.createUnitNumerator());
		
		try {
			if (unit.getNumerator() != null) {
				for (UnitFactor factor : unit.getNumerator().getFactors()) {
					evaluateFactor(factor, false, result);
				}
			}
			if (unit.getDenominator() != null) {
				for (UnitFactor factor : unit.getDenominator().getFactors()) {
					evaluateFactor(factor, true, result);
				}
			}
		} catch (InvalidUnitExpressionOperandException e) {
			return null;
		}

		return result;
	}

	private static void evaluateFactor(UnitFactor factor, boolean reciprocal, Unit result) throws InvalidUnitExpressionOperandException {
		int scale = 0;
		List<UnitFactor> factors = new ArrayList<UnitFactor>();

		expandFactor(factor, factors);
				
		int exponent = factor.getExponent();
		
		if (reciprocal) {
			exponent = -exponent;
		}
		
		if (result != null) {
			result.setScale(result.getScale() + scale * exponent);
			addFactorsToUnit(result, factors, exponent);
		}
	}
	
	private static void expandFactor(UnitFactor factor, List<UnitFactor> factors) throws InvalidUnitExpressionOperandException {
		if (factor.getSymbol() == null) {
			throw new InvalidUnitExpressionOperandException(factor);
		}
		if (factor.getSymbol().getOwner() instanceof BaseUnitDeclaration) {
			UnitFactor newFactor = MscriptFactory.eINSTANCE.createUnitFactor();
			newFactor.setSymbol(factor.getSymbol());
			factors.add(newFactor);
		}
	}
	
	private static void addFactorsToUnit(Unit unit, List<UnitFactor> factors, int exponent) {
		for (UnitFactor factor : factors) {
			UnitFactor existingFactor = unit.getNumerator().getFactor(factor.getSymbol());
			int newExponent = exponent * factor.getExponent();
			if (existingFactor != null) {
				newExponent += existingFactor.getExponent();
				if (newExponent != 0) {
					existingFactor.setExponent(newExponent);
				} else {
					unit.getNumerator().getFactors().remove(existingFactor);
				}
			} else if (newExponent != 0){
				UnitFactor newFactor = MscriptFactory.eINSTANCE.createUnitFactor();
				newFactor.setSymbol(factor.getSymbol());
				newFactor.setExponent(newExponent);
				unit.getNumerator().getFactors().add(newFactor);
			}
		}
	}

	public static Unit evaluate(Unit unit, OperatorKind operator, Unit other) {
		switch (operator) {
		case ADD:
		case SUBTRACT:
		case MODULO:
		case ELEMENT_WISE_ADD:
		case ELEMENT_WISE_SUBTRACT:
		case ELEMENT_WISE_MODULO:
			if (unit.isEquivalentTo(other, false)) {
				if (isLongerThan(unit, other)) {
					return EcoreUtil.copy(other); 
				}
				return EcoreUtil.copy(unit);
			}
			return null;
		case MULTIPLY:
		case ELEMENT_WISE_MULTIPLY:
			unit = unit.getNormalized();
			other = other.getNormalized();
			unit.setScale(unit.getScale() + other.getScale());
			for (UnitFactor otherFactor : other.getNumerator().getFactors()) {
				UnitFactor factor = unit.getNumerator().getFactor(otherFactor.getSymbol());
				if (factor != null) {
					factor.setExponent(factor.getExponent() + otherFactor.getExponent());
				} else {
					factor = createUnitFactor(otherFactor.getSymbol(), otherFactor.getExponent());
					unit.getNumerator().getFactors().add(factor);
				}
			}
			return unit;
		case DIVIDE:
		case ELEMENT_WISE_DIVIDE:
			unit = unit.getNormalized();
			other = other.getNormalized();
			unit.setScale(unit.getScale() - other.getScale());
			for (UnitFactor otherFactor : other.getNumerator().getFactors()) {
				UnitFactor factor = unit.getNumerator().getFactor(otherFactor.getSymbol());
				if (factor != null) {
					factor.setExponent(factor.getExponent() - otherFactor.getExponent());
				} else {
					factor = createUnitFactor(otherFactor.getSymbol(), -otherFactor.getExponent());
					unit.getNumerator().getFactors().add(factor);
				}
			}
			return unit;
		case NEGATE:
			return EcoreUtil.copy(unit);
		default:
			break;
		}
		return null;
	}
	
	public static Unit evaluate(Unit unit, OperatorKind operator, int n) {
		switch (operator) {
		case POWER:
		case ELEMENT_WISE_POWER:
			unit = unit.getNormalized();
			
			unit.setScale(unit.getScale() * n);
			for (UnitFactor factor : unit.getNumerator().getFactors()) {
				factor.setExponent(factor.getExponent() * n);
			}
			
			return unit;
		case ROOT:
			unit = unit.getNormalized();
			
			if (unit.getScale() % n != 0) {
				return null;
			}
			unit.setScale(unit.getScale() / n);
			for (UnitFactor factor : unit.getNumerator().getFactors()) {
				int exponent = factor.getExponent();
				if (exponent % n != 0) {
					return null;
				}
				factor.setExponent(exponent / n);
			}
			
			return unit;
		default:
			break;
		}
		return null;
	}

	public static boolean isEquivalentTo(Unit unit, Unit other, boolean ignoreScale) {
		unit = unit.getNormalized();
		other = other.getNormalized();
		if (unit == null || other == null) {
			return false;
		}
		if (!ignoreScale && unit.getScale() != other.getScale()) {
			return false;
		}
		EList<UnitFactor> factors = unit.getNumerator().getFactors();
		EList<UnitFactor> otherFactors = other.getNumerator().getFactors();
		if (factors.size() != otherFactors.size()) {
			return false;
		}
		for (UnitFactor factor : factors) {
			UnitFactor otherFactor = other.getNumerator().getFactor(factor.getSymbol());
			if (otherFactor == null || otherFactor.getExponent() != factor.getExponent()) {
				return false;
			}
		}
		return true;
	}

	private static boolean isLongerThan(Unit unit, Unit other) {
		int numeratorSize = unit.getNumerator().getFactors().size();
		int denominatorSize = unit.getDenominator() != null ? unit.getDenominator().getFactors().size() : 0;
		int size = numeratorSize + denominatorSize;
		
		int otherNumeratorSize = other.getNumerator().getFactors().size();
		int otherDenominatorSize = other.getDenominator() != null ? other.getDenominator().getFactors().size() : 0;
		int otherSize = otherNumeratorSize + otherDenominatorSize;
		
		if (size < otherSize) {
			return false;
		}
		
		if (size > otherSize) {
			return true;
		}
		
		if (numeratorSize >= otherNumeratorSize) {
			return false;
		}
		
		return true;
	}

	private static UnitFactor createUnitFactor(UnitSymbol symbol, int exponent) {
		UnitFactor factor = MscriptFactory.eINSTANCE.createUnitFactor();
		factor.setSymbol(symbol);
		factor.setExponent(exponent);
		return factor;
	}

}
