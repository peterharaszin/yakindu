/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.dmltext.util;

import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;
import org.eclipselabs.damos.dml.BlockType;
import org.eclipselabs.damos.dml.CategorizedElement;
import org.eclipselabs.damos.dml.DataTypeSpecification;
import org.eclipselabs.damos.dml.INamedElement;
import org.eclipselabs.damos.dml.InoutputDefinition;
import org.eclipselabs.damos.dml.InputDefinition;
import org.eclipselabs.damos.dml.OutputDefinition;
import org.eclipselabs.damos.dml.Parameter;
import org.eclipselabs.damos.dml.ParameterableElement;
import org.eclipselabs.damos.dml.QualifiedElement;
import org.eclipselabs.damos.dml.SystemInterface;
import org.eclipselabs.damos.dml.ValueSpecification;
import org.eclipselabs.damos.dmltext.*;
import org.eclipselabs.damos.mscript.CallableElement;
import org.eclipselabs.damos.mscript.Evaluable;
import org.eclipselabs.damos.mscript.FunctionDeclaration;
import org.eclipselabs.damos.mscript.InputParameterDeclaration;
import org.eclipselabs.damos.mscript.OutputParameterDeclaration;
import org.eclipselabs.damos.mscript.ParameterDeclaration;
import org.eclipselabs.damos.dmltext.DMLTextPackage;
import org.eclipselabs.damos.dmltext.MscriptBlockType;
import org.eclipselabs.damos.dmltext.MscriptDataTypeSpecification;
import org.eclipselabs.damos.dmltext.MscriptSystemInterface;
import org.eclipselabs.damos.dmltext.MscriptValueSpecification;
import org.eclipselabs.damos.dmltext.Root;
import org.eclipselabs.damos.mscript.TopLevelContainer;
import org.eclipselabs.damos.mscript.VariableDeclaration;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.eclipselabs.damos.dmltext.DMLTextPackage
 * @generated
 */
public class DMLTextSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static DMLTextPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DMLTextSwitch() {
		if (modelPackage == null) {
			modelPackage = DMLTextPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @parameter ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case DMLTextPackage.ROOT: {
				Root root = (Root)theEObject;
				T result = caseRoot(root);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DMLTextPackage.MSCRIPT_BLOCK_TYPE: {
				MscriptBlockType mscriptBlockType = (MscriptBlockType)theEObject;
				T result = caseMscriptBlockType(mscriptBlockType);
				if (result == null) result = caseBlockType(mscriptBlockType);
				if (result == null) result = caseTopLevelContainer(mscriptBlockType);
				if (result == null) result = caseEModelElement(mscriptBlockType);
				if (result == null) result = caseQualifiedElement(mscriptBlockType);
				if (result == null) result = caseCategorizedElement(mscriptBlockType);
				if (result == null) result = caseParameterableElement(mscriptBlockType);
				if (result == null) result = caseINamedElement(mscriptBlockType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DMLTextPackage.DSCRIPT_INPUT_DEFINITION: {
				DscriptInputDefinition dscriptInputDefinition = (DscriptInputDefinition)theEObject;
				T result = caseDscriptInputDefinition(dscriptInputDefinition);
				if (result == null) result = caseInputDefinition(dscriptInputDefinition);
				if (result == null) result = caseInputParameterDeclaration(dscriptInputDefinition);
				if (result == null) result = caseInoutputDefinition(dscriptInputDefinition);
				if (result == null) result = caseParameterDeclaration(dscriptInputDefinition);
				if (result == null) result = caseParameterableElement(dscriptInputDefinition);
				if (result == null) result = caseINamedElement(dscriptInputDefinition);
				if (result == null) result = caseVariableDeclaration(dscriptInputDefinition);
				if (result == null) result = caseCallableElement(dscriptInputDefinition);
				if (result == null) result = caseEvaluable(dscriptInputDefinition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DMLTextPackage.DSCRIPT_OUTPUT_DEFINITION: {
				DscriptOutputDefinition dscriptOutputDefinition = (DscriptOutputDefinition)theEObject;
				T result = caseDscriptOutputDefinition(dscriptOutputDefinition);
				if (result == null) result = caseOutputDefinition(dscriptOutputDefinition);
				if (result == null) result = caseOutputParameterDeclaration(dscriptOutputDefinition);
				if (result == null) result = caseInoutputDefinition(dscriptOutputDefinition);
				if (result == null) result = caseParameterDeclaration(dscriptOutputDefinition);
				if (result == null) result = caseParameterableElement(dscriptOutputDefinition);
				if (result == null) result = caseINamedElement(dscriptOutputDefinition);
				if (result == null) result = caseVariableDeclaration(dscriptOutputDefinition);
				if (result == null) result = caseCallableElement(dscriptOutputDefinition);
				if (result == null) result = caseEvaluable(dscriptOutputDefinition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DMLTextPackage.DSCRIPT_PARAMETER: {
				DscriptParameter dscriptParameter = (DscriptParameter)theEObject;
				T result = caseDscriptParameter(dscriptParameter);
				if (result == null) result = caseParameter(dscriptParameter);
				if (result == null) result = caseInputParameterDeclaration(dscriptParameter);
				if (result == null) result = caseINamedElement(dscriptParameter);
				if (result == null) result = caseParameterDeclaration(dscriptParameter);
				if (result == null) result = caseVariableDeclaration(dscriptParameter);
				if (result == null) result = caseCallableElement(dscriptParameter);
				if (result == null) result = caseEvaluable(dscriptParameter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DMLTextPackage.BEHAVIOR_DECLARATION: {
				BehaviorDeclaration behaviorDeclaration = (BehaviorDeclaration)theEObject;
				T result = caseBehaviorDeclaration(behaviorDeclaration);
				if (result == null) result = caseFunctionDeclaration(behaviorDeclaration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DMLTextPackage.IMPLICIT_INPUT_PARAMETER_DECLARATION: {
				ImplicitInputParameterDeclaration implicitInputParameterDeclaration = (ImplicitInputParameterDeclaration)theEObject;
				T result = caseImplicitInputParameterDeclaration(implicitInputParameterDeclaration);
				if (result == null) result = caseInputParameterDeclaration(implicitInputParameterDeclaration);
				if (result == null) result = caseParameterDeclaration(implicitInputParameterDeclaration);
				if (result == null) result = caseVariableDeclaration(implicitInputParameterDeclaration);
				if (result == null) result = caseCallableElement(implicitInputParameterDeclaration);
				if (result == null) result = caseEvaluable(implicitInputParameterDeclaration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DMLTextPackage.IMPLICIT_OUTPUT_PARAMETER_DECLARATION: {
				ImplicitOutputParameterDeclaration implicitOutputParameterDeclaration = (ImplicitOutputParameterDeclaration)theEObject;
				T result = caseImplicitOutputParameterDeclaration(implicitOutputParameterDeclaration);
				if (result == null) result = caseOutputParameterDeclaration(implicitOutputParameterDeclaration);
				if (result == null) result = caseParameterDeclaration(implicitOutputParameterDeclaration);
				if (result == null) result = caseVariableDeclaration(implicitOutputParameterDeclaration);
				if (result == null) result = caseCallableElement(implicitOutputParameterDeclaration);
				if (result == null) result = caseEvaluable(implicitOutputParameterDeclaration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DMLTextPackage.INPUT_MESSAGE_PARAMETER_DECLARATION: {
				InputMessageParameterDeclaration inputMessageParameterDeclaration = (InputMessageParameterDeclaration)theEObject;
				T result = caseInputMessageParameterDeclaration(inputMessageParameterDeclaration);
				if (result == null) result = caseImplicitInputParameterDeclaration(inputMessageParameterDeclaration);
				if (result == null) result = caseInputParameterDeclaration(inputMessageParameterDeclaration);
				if (result == null) result = caseParameterDeclaration(inputMessageParameterDeclaration);
				if (result == null) result = caseVariableDeclaration(inputMessageParameterDeclaration);
				if (result == null) result = caseCallableElement(inputMessageParameterDeclaration);
				if (result == null) result = caseEvaluable(inputMessageParameterDeclaration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DMLTextPackage.OUTPUT_MESSAGE_PARAMETER_DECLARATION: {
				OutputMessageParameterDeclaration outputMessageParameterDeclaration = (OutputMessageParameterDeclaration)theEObject;
				T result = caseOutputMessageParameterDeclaration(outputMessageParameterDeclaration);
				if (result == null) result = caseImplicitOutputParameterDeclaration(outputMessageParameterDeclaration);
				if (result == null) result = caseOutputParameterDeclaration(outputMessageParameterDeclaration);
				if (result == null) result = caseParameterDeclaration(outputMessageParameterDeclaration);
				if (result == null) result = caseVariableDeclaration(outputMessageParameterDeclaration);
				if (result == null) result = caseCallableElement(outputMessageParameterDeclaration);
				if (result == null) result = caseEvaluable(outputMessageParameterDeclaration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DMLTextPackage.MSCRIPT_SYSTEM_INTERFACE: {
				MscriptSystemInterface mscriptSystemInterface = (MscriptSystemInterface)theEObject;
				T result = caseMscriptSystemInterface(mscriptSystemInterface);
				if (result == null) result = caseSystemInterface(mscriptSystemInterface);
				if (result == null) result = caseQualifiedElement(mscriptSystemInterface);
				if (result == null) result = caseINamedElement(mscriptSystemInterface);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DMLTextPackage.MSCRIPT_DATA_TYPE_SPECIFICATION: {
				MscriptDataTypeSpecification mscriptDataTypeSpecification = (MscriptDataTypeSpecification)theEObject;
				T result = caseMscriptDataTypeSpecification(mscriptDataTypeSpecification);
				if (result == null) result = caseDataTypeSpecification(mscriptDataTypeSpecification);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DMLTextPackage.MSCRIPT_VALUE_SPECIFICATION: {
				MscriptValueSpecification mscriptValueSpecification = (MscriptValueSpecification)theEObject;
				T result = caseMscriptValueSpecification(mscriptValueSpecification);
				if (result == null) result = caseValueSpecification(mscriptValueSpecification);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Root</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Root</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRoot(Root object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Mscript Block Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mscript Block Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMscriptBlockType(MscriptBlockType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Dscript Input Definition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Dscript Input Definition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDscriptInputDefinition(DscriptInputDefinition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Dscript Output Definition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Dscript Output Definition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDscriptOutputDefinition(DscriptOutputDefinition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Dscript Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Dscript Parameter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDscriptParameter(DscriptParameter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Behavior Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Behavior Declaration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBehaviorDeclaration(BehaviorDeclaration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Implicit Input Parameter Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Implicit Input Parameter Declaration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseImplicitInputParameterDeclaration(ImplicitInputParameterDeclaration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Implicit Output Parameter Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Implicit Output Parameter Declaration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseImplicitOutputParameterDeclaration(ImplicitOutputParameterDeclaration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Input Message Parameter Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Input Message Parameter Declaration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInputMessageParameterDeclaration(InputMessageParameterDeclaration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Output Message Parameter Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Output Message Parameter Declaration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOutputMessageParameterDeclaration(OutputMessageParameterDeclaration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Mscript System Interface</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mscript System Interface</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMscriptSystemInterface(MscriptSystemInterface object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Mscript Data Type Specification</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mscript Data Type Specification</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMscriptDataTypeSpecification(MscriptDataTypeSpecification object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Mscript Value Specification</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mscript Value Specification</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMscriptValueSpecification(MscriptValueSpecification object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EModel Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EModel Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEModelElement(EModelElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>INamed Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>INamed Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseINamedElement(INamedElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Qualified Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Qualified Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseQualifiedElement(QualifiedElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Categorized Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Categorized Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCategorizedElement(CategorizedElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Parameterable Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Parameterable Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseParameterableElement(ParameterableElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Block Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Block Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBlockType(BlockType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Top Level Container</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Top Level Container</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTopLevelContainer(TopLevelContainer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Inoutput Definition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Inoutput Definition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInoutputDefinition(InoutputDefinition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Input Definition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Input Definition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInputDefinition(InputDefinition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Evaluable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Evaluable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEvaluable(Evaluable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Callable Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Callable Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCallableElement(CallableElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Variable Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Variable Declaration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVariableDeclaration(VariableDeclaration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Parameter Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Parameter Declaration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseParameterDeclaration(ParameterDeclaration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Input Parameter Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Input Parameter Declaration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInputParameterDeclaration(InputParameterDeclaration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Output Definition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Output Definition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOutputDefinition(OutputDefinition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Output Parameter Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Output Parameter Declaration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOutputParameterDeclaration(OutputParameterDeclaration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Parameter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseParameter(Parameter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Function Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Function Declaration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFunctionDeclaration(FunctionDeclaration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>System Interface</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>System Interface</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSystemInterface(SystemInterface object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Data Type Specification</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Data Type Specification</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDataTypeSpecification(DataTypeSpecification object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Value Specification</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Value Specification</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseValueSpecification(ValueSpecification object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //DMLTextSwitch
