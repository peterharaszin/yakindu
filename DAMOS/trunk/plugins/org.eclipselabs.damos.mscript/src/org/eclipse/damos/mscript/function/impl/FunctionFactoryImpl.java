/**
 */
package org.eclipse.damos.mscript.function.impl;

import org.eclipse.damos.mscript.function.ComputationCompound;
import org.eclipse.damos.mscript.function.EquationDescription;
import org.eclipse.damos.mscript.function.EquationPart;
import org.eclipse.damos.mscript.function.EquationSide;
import org.eclipse.damos.mscript.function.FunctionDescription;
import org.eclipse.damos.mscript.function.FunctionFactory;
import org.eclipse.damos.mscript.function.FunctionInstance;
import org.eclipse.damos.mscript.function.FunctionPackage;
import org.eclipse.damos.mscript.function.VariableDescription;
import org.eclipse.damos.mscript.function.VariableKind;
import org.eclipse.damos.mscript.function.VariableStep;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class FunctionFactoryImpl extends EFactoryImpl implements FunctionFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static FunctionFactory init() {
		try {
			FunctionFactory theFunctionFactory = (FunctionFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipse.org/damos/mscript/2011/Function"); 
			if (theFunctionFactory != null) {
				return theFunctionFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new FunctionFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FunctionFactoryImpl() {
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
			case FunctionPackage.FUNCTION_DESCRIPTION: return createFunctionDescription();
			case FunctionPackage.EQUATION_DESCRIPTION: return createEquationDescription();
			case FunctionPackage.EQUATION_SIDE: return createEquationSide();
			case FunctionPackage.EQUATION_PART: return createEquationPart();
			case FunctionPackage.VARIABLE_DESCRIPTION: return createVariableDescription();
			case FunctionPackage.VARIABLE_STEP: return createVariableStep();
			case FunctionPackage.FUNCTION_INSTANCE: return createFunctionInstance();
			case FunctionPackage.COMPUTATION_COMPOUND: return createComputationCompound();
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
			case FunctionPackage.VARIABLE_KIND:
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
			case FunctionPackage.VARIABLE_KIND:
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
	public FunctionPackage getFunctionPackage() {
		return (FunctionPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static FunctionPackage getPackage() {
		return FunctionPackage.eINSTANCE;
	}

} //FunctionFactoryImpl
