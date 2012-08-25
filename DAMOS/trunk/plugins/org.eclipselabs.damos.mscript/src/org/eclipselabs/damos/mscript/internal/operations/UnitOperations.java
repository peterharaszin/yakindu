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

import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipselabs.damos.mscript.BaseUnitDeclaration;
import org.eclipselabs.damos.mscript.DerivedUnitDeclaration;
import org.eclipselabs.damos.mscript.MscriptFactory;
import org.eclipselabs.damos.mscript.OperatorKind;
import org.eclipselabs.damos.mscript.Unit;
import org.eclipselabs.damos.mscript.UnitFactor;
import org.eclipselabs.damos.mscript.UnitPrefix;
import org.eclipselabs.damos.mscript.UnitSymbol;

/**
 * @author Andreas Unger
 *
 */
public class UnitOperations {
	
	public static Unit getNormalized(Unit unit) {
		Unit normalizedUnit = MscriptFactory.eINSTANCE.createUnit();
		normalizedUnit.setScale(unit.getScale());
		try {
			expandUnit(normalizedUnit, unit, 1, new HashSet<Unit>());
		} catch (InvalidUnitExpressionOperandException e) {
			return null;
		}
		return normalizedUnit;
	}
	
	private static void expandUnit(Unit normalizedUnit, Unit unit, int exponent, Set<Unit> visitedUnits) throws InvalidUnitExpressionOperandException {
		if (!visitedUnits.add(unit)) {
			// Break cycle
			throw new InvalidUnitExpressionOperandException(null);
		}
		for (UnitFactor factor : unit.getFactors()) {
			if (factor.getSymbol() == null) {
				throw new InvalidUnitExpressionOperandException(factor);
			}

			int newExponent = exponent * factor.getExponent();
			normalizedUnit.setScale(normalizedUnit.getScale() + newExponent * factor.getSymbol().getScale());

			if (factor.getSymbol().getOwner() instanceof BaseUnitDeclaration) {
				UnitSymbol symbol = factor.getSymbol().getOwner().getSymbol(UnitPrefix.NONE);
				addFactor(normalizedUnit, symbol, newExponent);
			} else if (factor.getSymbol().getOwner() instanceof DerivedUnitDeclaration) {
				DerivedUnitDeclaration derivedUnitDeclaration = (DerivedUnitDeclaration) factor.getSymbol().getOwner();
				expandUnit(normalizedUnit, derivedUnitDeclaration.getDefinition(), newExponent, new HashSet<Unit>(visitedUnits));
			}
		}
	}

	private static void addFactor(Unit unit, UnitSymbol symbol, int exponent) {
		UnitFactor existingFactor = unit.getFactor(symbol);
		if (existingFactor != null) {
			exponent += existingFactor.getExponent();
			if (exponent != 0) {
				existingFactor.setExponent(exponent);
			} else {
				unit.getFactors().remove(existingFactor);
			}
		} else if (exponent != 0){
			UnitFactor newFactor = MscriptFactory.eINSTANCE.createUnitFactor();
			newFactor.setSymbol(symbol);
			newFactor.setExponent(exponent);
			unit.getFactors().add(newFactor);
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
			for (UnitFactor otherFactor : other.getFactors()) {
				UnitFactor factor = unit.getFactor(otherFactor.getSymbol());
				if (factor != null) {
					factor.setExponent(factor.getExponent() + otherFactor.getExponent());
				} else {
					factor = createUnitFactor(otherFactor.getSymbol(), otherFactor.getExponent());
					unit.getFactors().add(factor);
				}
			}
			return unit;
		case DIVIDE:
		case ELEMENT_WISE_DIVIDE:
			unit = unit.getNormalized();
			other = other.getNormalized();
			unit.setScale(unit.getScale() - other.getScale());
			for (UnitFactor otherFactor : other.getFactors()) {
				UnitFactor factor = unit.getFactor(otherFactor.getSymbol());
				if (factor != null) {
					factor.setExponent(factor.getExponent() - otherFactor.getExponent());
				} else {
					factor = createUnitFactor(otherFactor.getSymbol(), -otherFactor.getExponent());
					unit.getFactors().add(factor);
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
			for (UnitFactor factor : unit.getFactors()) {
				factor.setExponent(factor.getExponent() * n);
			}
			
			return unit;
		case ROOT:
			unit = unit.getNormalized();
			
			if (unit.getScale() % n != 0) {
				return null;
			}
			unit.setScale(unit.getScale() / n);
			for (UnitFactor factor : unit.getFactors()) {
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
		EList<UnitFactor> factors = unit.getFactors();
		EList<UnitFactor> otherFactors = other.getFactors();
		if (factors.size() != otherFactors.size()) {
			return false;
		}
		for (UnitFactor factor : factors) {
			UnitFactor otherFactor = other.getFactor(factor.getSymbol());
			if (otherFactor == null || otherFactor.getExponent() != factor.getExponent()) {
				return false;
			}
		}
		return true;
	}

	private static boolean isLongerThan(Unit unit, Unit other) {
		return unit.getFactors().size() > other.getFactors().size();
	}

	private static UnitFactor createUnitFactor(UnitSymbol symbol, int exponent) {
		UnitFactor factor = MscriptFactory.eINSTANCE.createUnitFactor();
		factor.setSymbol(symbol);
		factor.setExponent(exponent);
		return factor;
	}

}
