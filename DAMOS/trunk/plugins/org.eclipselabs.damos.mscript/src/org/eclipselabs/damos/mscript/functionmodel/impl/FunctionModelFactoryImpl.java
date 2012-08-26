/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.mscript.functionmodel.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipselabs.damos.mscript.functionmodel.ComputationCompound;
import org.eclipselabs.damos.mscript.functionmodel.EquationDescription;
import org.eclipselabs.damos.mscript.functionmodel.EquationPart;
import org.eclipselabs.damos.mscript.functionmodel.EquationSide;
import org.eclipselabs.damos.mscript.functionmodel.FunctionDescription;
import org.eclipselabs.damos.mscript.functionmodel.FunctionInstance;
import org.eclipselabs.damos.mscript.functionmodel.FunctionModelFactory;
import org.eclipselabs.damos.mscript.functionmodel.FunctionModelPackage;
import org.eclipselabs.damos.mscript.functionmodel.VariableDescription;
import org.eclipselabs.damos.mscript.functionmodel.VariableKind;
import org.eclipselabs.damos.mscript.functionmodel.VariableStep;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class FunctionModelFactoryImpl extends EFactoryImpl implements FunctionModelFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static FunctionModelFactory init() {
		try {
			FunctionModelFactory theFunctionModelFactory = (FunctionModelFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipselabs.org/damos/mscript/2011/FunctionModel"); 
			if (theFunctionModelFactory != null) {
				return theFunctionModelFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new FunctionModelFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FunctionModelFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case FunctionModelPackage.FUNCTION_DESCRIPTION: return createFunctionDescription();
			case FunctionModelPackage.EQUATION_DESCRIPTION: return createEquationDescription();
			case FunctionModelPackage.EQUATION_SIDE: return createEquationSide();
			case FunctionModelPackage.EQUATION_PART: return createEquationPart();
			case FunctionModelPackage.VARIABLE_DESCRIPTION: return createVariableDescription();
			case FunctionModelPackage.VARIABLE_STEP: return createVariableStep();
			case FunctionModelPackage.FUNCTION_INSTANCE: return createFunctionInstance();
			case FunctionModelPackage.COMPUTATION_COMPOUND: return createComputationCompound();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case FunctionModelPackage.VARIABLE_KIND:
				return createVariableKindFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case FunctionModelPackage.VARIABLE_KIND:
				return convertVariableKindToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FunctionDescription createFunctionDescription() {
		FunctionDescriptionImpl functionDescription = new FunctionDescriptionImpl();
		return functionDescription;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EquationDescription createEquationDescription() {
		EquationDescriptionImpl equationDescription = new EquationDescriptionImpl();
		return equationDescription;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EquationSide createEquationSide() {
		EquationSideImpl equationSide = new EquationSideImpl();
		return equationSide;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EquationPart createEquationPart() {
		EquationPartImpl equationPart = new EquationPartImpl();
		return equationPart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariableDescription createVariableDescription() {
		VariableDescriptionImpl variableDescription = new VariableDescriptionImpl();
		return variableDescription;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariableStep createVariableStep() {
		VariableStepImpl variableStep = new VariableStepImpl();
		return variableStep;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FunctionInstance createFunctionInstance() {
		FunctionInstanceImpl functionInstance = new FunctionInstanceImpl();
		return functionInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComputationCompound createComputationCompound() {
		ComputationCompoundImpl computationCompound = new ComputationCompoundImpl();
		return computationCompound;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariableKind createVariableKindFromString(EDataType eDataType, String initialValue) {
		VariableKind result = VariableKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertVariableKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FunctionModelPackage getFunctionModelPackage() {
		return (FunctionModelPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static FunctionModelPackage getPackage() {
		return FunctionModelPackage.eINSTANCE;
	}

} //FunctionModelFactoryImpl
