/**
 * Copyright (c) 2006-2009 committers of mda4e and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of mda4e (http://www.mda4e.org/) - initial API and implementation
 *
 */
package statemachine.diagram.part;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import statemachine.StatemachinePackage;

/**
 * @generated
 */
public class StatemachineDomainModelElementTester extends PropertyTester {

	/**
	 * @generated
	 */
	public boolean test(Object receiver, String method, Object[] args,
			Object expectedValue) {
		if (false == receiver instanceof EObject) {
			return false;
		}
		EObject eObject = (EObject) receiver;
		EClass eClass = eObject.eClass();
		if (eClass == StatemachinePackage.eINSTANCE.getRegion()) {
			return true;
		}
		if (eClass == StatemachinePackage.eINSTANCE.getNode()) {
			return true;
		}
		if (eClass == StatemachinePackage.eINSTANCE.getTransition()) {
			return true;
		}
		if (eClass == StatemachinePackage.eINSTANCE.getState()) {
			return true;
		}
		if (eClass == StatemachinePackage.eINSTANCE.getPseudostate()) {
			return true;
		}
		if (eClass == StatemachinePackage.eINSTANCE.getDataElement()) {
			return true;
		}
		if (eClass == StatemachinePackage.eINSTANCE.getVariable()) {
			return true;
		}
		if (eClass == StatemachinePackage.eINSTANCE.getEvent()) {
			return true;
		}
		if (eClass == StatemachinePackage.eINSTANCE.getStatechart()) {
			return true;
		}
		if (eClass == StatemachinePackage.eINSTANCE.getFinalState()) {
			return true;
		}
		return false;
	}

}
