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
package statemachine.diagram.providers;

import java.util.Iterator;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import statemachine.FinalState;
import statemachine.Node;
import statemachine.PseudoTypes;
import statemachine.Pseudostate;
import statemachine.Region;
import statemachine.State;
import statemachine.Statechart;
import statemachine.StatemachinePackage;
import statemachine.Transition;
import statemachine.diagram.expressions.StatemachineAbstractExpression;
import statemachine.diagram.expressions.StatemachineOCLFactory;
import statemachine.diagram.part.StatemachineDiagramEditorPlugin;

/**
 * @generated
 */
public class ElementInitializers {
	/**
	 * @generated
	 */
	public static void init_State_3001(State instance) {
		try {
			Object value_0 = id_State_3001(instance);

			value_0 = StatemachineAbstractExpression.performCast(value_0,
					EcorePackage.eINSTANCE.getEInt());
			instance.setId(((java.lang.Integer) value_0).intValue());
		} catch (RuntimeException e) {
			StatemachineDiagramEditorPlugin.getInstance().logError(
					"Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_Pseudostate_3003(Pseudostate instance) {
		try {
			Object value_0 = StatemachineOCLFactory.getExpression(
					"PseudoTypes::initial",
					StatemachinePackage.eINSTANCE.getPseudostate()).evaluate(
					instance);

			value_0 = StatemachineAbstractExpression.performCast(value_0,
					StatemachinePackage.eINSTANCE.getPseudoTypes());
			instance.setPseudoType((PseudoTypes) value_0);
			Object value_1 = id_Pseudostate_3003(instance);

			value_1 = StatemachineAbstractExpression.performCast(value_1,
					EcorePackage.eINSTANCE.getEInt());
			instance.setId(((java.lang.Integer) value_1).intValue());
		} catch (RuntimeException e) {
			StatemachineDiagramEditorPlugin.getInstance().logError(
					"Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_FinalState_3004(FinalState instance) {
		try {
			Object value_0 = StatemachineOCLFactory.getExpression(
					"\'FinalState\'",
					StatemachinePackage.eINSTANCE.getFinalState()).evaluate(
					instance);
			instance.setName((String) value_0);
			Object value_1 = id_FinalState_3004(instance);

			value_1 = StatemachineAbstractExpression.performCast(value_1,
					EcorePackage.eINSTANCE.getEInt());
			instance.setId(((java.lang.Integer) value_1).intValue());
		} catch (RuntimeException e) {
			StatemachineDiagramEditorPlugin.getInstance().logError(
					"Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_Pseudostate_3005(Pseudostate instance) {
		try {
			Object value_0 = StatemachineOCLFactory.getExpression(
					"PseudoTypes::choice",
					StatemachinePackage.eINSTANCE.getPseudostate()).evaluate(
					instance);

			value_0 = StatemachineAbstractExpression.performCast(value_0,
					StatemachinePackage.eINSTANCE.getPseudoTypes());
			instance.setPseudoType((PseudoTypes) value_0);
			Object value_1 = id_Pseudostate_3005(instance);

			value_1 = StatemachineAbstractExpression.performCast(value_1,
					EcorePackage.eINSTANCE.getEInt());
			instance.setId(((java.lang.Integer) value_1).intValue());
		} catch (RuntimeException e) {
			StatemachineDiagramEditorPlugin.getInstance().logError(
					"Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_Pseudostate_3006(Pseudostate instance) {
		try {
			Object value_0 = StatemachineOCLFactory.getExpression(
					"PseudoTypes::deepHistory",
					StatemachinePackage.eINSTANCE.getPseudostate()).evaluate(
					instance);

			value_0 = StatemachineAbstractExpression.performCast(value_0,
					StatemachinePackage.eINSTANCE.getPseudoTypes());
			instance.setPseudoType((PseudoTypes) value_0);
			Object value_1 = id_Pseudostate_3006(instance);

			value_1 = StatemachineAbstractExpression.performCast(value_1,
					EcorePackage.eINSTANCE.getEInt());
			instance.setId(((java.lang.Integer) value_1).intValue());
		} catch (RuntimeException e) {
			StatemachineDiagramEditorPlugin.getInstance().logError(
					"Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_Pseudostate_3007(Pseudostate instance) {
		try {
			Object value_0 = StatemachineOCLFactory.getExpression(
					"PseudoTypes::shallowHistory",
					StatemachinePackage.eINSTANCE.getPseudostate()).evaluate(
					instance);

			value_0 = StatemachineAbstractExpression.performCast(value_0,
					StatemachinePackage.eINSTANCE.getPseudoTypes());
			instance.setPseudoType((PseudoTypes) value_0);
			Object value_1 = id_Pseudostate_3007(instance);

			value_1 = StatemachineAbstractExpression.performCast(value_1,
					EcorePackage.eINSTANCE.getEInt());
			instance.setId(((java.lang.Integer) value_1).intValue());
		} catch (RuntimeException e) {
			StatemachineDiagramEditorPlugin.getInstance().logError(
					"Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_Pseudostate_3008(Pseudostate instance) {
		try {
			Object value_0 = StatemachineOCLFactory.getExpression(
					"PseudoTypes::junction",
					StatemachinePackage.eINSTANCE.getPseudostate()).evaluate(
					instance);

			value_0 = StatemachineAbstractExpression.performCast(value_0,
					StatemachinePackage.eINSTANCE.getPseudoTypes());
			instance.setPseudoType((PseudoTypes) value_0);
			Object value_1 = id_Pseudostate_3008(instance);

			value_1 = StatemachineAbstractExpression.performCast(value_1,
					EcorePackage.eINSTANCE.getEInt());
			instance.setId(((java.lang.Integer) value_1).intValue());
		} catch (RuntimeException e) {
			StatemachineDiagramEditorPlugin.getInstance().logError(
					"Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_Transition_4001(Transition instance) {
		try {
			Object value_0 = id_Transition_4001(instance);

			value_0 = StatemachineAbstractExpression.performCast(value_0,
					EcorePackage.eINSTANCE.getEInt());
			instance.setId(((java.lang.Integer) value_0).intValue());
			Object value_1 = priority_Transition_4001(instance);

			value_1 = StatemachineAbstractExpression.performCast(value_1,
					EcorePackage.eINSTANCE.getEInt());
			instance.setPriority(((java.lang.Integer) value_1).intValue());
		} catch (RuntimeException e) {
			StatemachineDiagramEditorPlugin.getInstance().logError(
					"Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	private static java.lang.Integer id_State_3001(State self) {
		return getNextNodeID(self);
	}

	/**
	 * generated as part of state/state initializer
	 */
	private static java.lang.Integer getNextNodeID(Node self) {
		int biggestId = 0;
		EObject parent = self.eContainer();
		while (parent != null && !(parent instanceof Statechart)) {
			parent = parent.eContainer();
		}
		if (parent == null) {
			return new Integer(0);
		}
		for (Iterator<EObject> iter = parent.eAllContents(); iter.hasNext();) {
			EObject e = iter.next();
			if (e instanceof Node) {
				Node n = (Node) e;
				if (n != self && n.getId() > biggestId) {
					biggestId = n.getId();
				}
			}
		}
		return new Integer(biggestId + 1);
	}

	/**
	 * @generated
	 */
	private static java.lang.Integer id_Pseudostate_3003(Pseudostate self) {
		return getNextNodeID(self);
	}

	/**
	 * @generated
	 */
	private static java.lang.Integer id_FinalState_3004(FinalState self) {
		return getNextNodeID(self);
	}

	/**
	 * @generated
	 */
	private static java.lang.Integer id_Pseudostate_3005(Pseudostate self) {
		return getNextNodeID(self);
	}

	/**
	 * @generated
	 */
	private static java.lang.Integer id_Pseudostate_3006(Pseudostate self) {
		return getNextNodeID(self);
	}

	/**
	 * @generated
	 */
	private static java.lang.Integer id_Pseudostate_3007(Pseudostate self) {
		return getNextNodeID(self);
	}

	/**
	 * @generated
	 */
	private static java.lang.Integer id_Pseudostate_3008(Pseudostate self) {
		return getNextNodeID(self);
	}

	/**
	 * @generated
	 */
	private static java.lang.Integer id_Transition_4001(Transition self) {
		int biggestId = 0;
		for (Transition t : ((Statechart) self.eContainer()).getTransition()) {
			if (t.getId() > biggestId) {
				biggestId = t.getId();
			}
		}
		return new Integer(biggestId + 1);
	}

	/**
	 * @generated
	 */
	private static java.lang.Integer priority_Transition_4001(Transition self) {
		int biggestPriority = 0;
		for (Transition t : ((Statechart) self.eContainer()).getTransition()) {
			if (t.getSourceNode() == self.getSourceNode()
					&& t.getId() > biggestPriority) {
				biggestPriority = t.getPriority();
			}
		}
		return new Integer(biggestPriority + 1);
	}

}
