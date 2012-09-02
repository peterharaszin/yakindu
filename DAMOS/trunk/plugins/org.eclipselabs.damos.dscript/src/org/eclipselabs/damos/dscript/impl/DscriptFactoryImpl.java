/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.dscript.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipselabs.damos.dscript.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class DscriptFactoryImpl extends EFactoryImpl implements DscriptFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static DscriptFactory init() {
		try {
			DscriptFactory theDscriptFactory = (DscriptFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipselabs.org/damos/2011/Dscript"); 
			if (theDscriptFactory != null) {
				return theDscriptFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new DscriptFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DscriptFactoryImpl() {
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
			case DscriptPackage.DSCRIPT_BLOCK_TYPE: return createDscriptBlockType();
			case DscriptPackage.DSCRIPT_INPUT_DEFINITION: return createDscriptInputDefinition();
			case DscriptPackage.DSCRIPT_OUTPUT_DEFINITION: return createDscriptOutputDefinition();
			case DscriptPackage.DSCRIPT_PARAMETER: return createDscriptParameter();
			case DscriptPackage.BEHAVIOR_DECLARATION: return createBehaviorDeclaration();
			case DscriptPackage.INPUT_MESSAGE_PARAMETER_DECLARATION: return createInputMessageParameterDeclaration();
			case DscriptPackage.OUTPUT_MESSAGE_PARAMETER_DECLARATION: return createOutputMessageParameterDeclaration();
			case DscriptPackage.DSCRIPT_SYSTEM_INTERFACE: return createDscriptSystemInterface();
			case DscriptPackage.DSCRIPT_DATA_TYPE_SPECIFICATION: return createDscriptDataTypeSpecification();
			case DscriptPackage.DSCRIPT_VALUE_SPECIFICATION: return createDscriptValueSpecification();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DscriptBlockType createDscriptBlockType() {
		DscriptBlockTypeImpl dscriptBlockType = new DscriptBlockTypeImpl();
		return dscriptBlockType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DscriptInputDefinition createDscriptInputDefinition() {
		DscriptInputDefinitionImpl dscriptInputDefinition = new DscriptInputDefinitionImpl();
		return dscriptInputDefinition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DscriptOutputDefinition createDscriptOutputDefinition() {
		DscriptOutputDefinitionImpl dscriptOutputDefinition = new DscriptOutputDefinitionImpl();
		return dscriptOutputDefinition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DscriptParameter createDscriptParameter() {
		DscriptParameterImpl dscriptParameter = new DscriptParameterImpl();
		return dscriptParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BehaviorDeclaration createBehaviorDeclaration() {
		BehaviorDeclarationImpl behaviorDeclaration = new BehaviorDeclarationImpl();
		return behaviorDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InputMessageParameterDeclaration createInputMessageParameterDeclaration() {
		InputMessageParameterDeclarationImpl inputMessageParameterDeclaration = new InputMessageParameterDeclarationImpl();
		return inputMessageParameterDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OutputMessageParameterDeclaration createOutputMessageParameterDeclaration() {
		OutputMessageParameterDeclarationImpl outputMessageParameterDeclaration = new OutputMessageParameterDeclarationImpl();
		return outputMessageParameterDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DscriptSystemInterface createDscriptSystemInterface() {
		DscriptSystemInterfaceImpl dscriptSystemInterface = new DscriptSystemInterfaceImpl();
		return dscriptSystemInterface;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DscriptDataTypeSpecification createDscriptDataTypeSpecification() {
		DscriptDataTypeSpecificationImpl dscriptDataTypeSpecification = new DscriptDataTypeSpecificationImpl();
		return dscriptDataTypeSpecification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DscriptValueSpecification createDscriptValueSpecification() {
		DscriptValueSpecificationImpl dscriptValueSpecification = new DscriptValueSpecificationImpl();
		return dscriptValueSpecification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DscriptPackage getDscriptPackage() {
		return (DscriptPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static DscriptPackage getPackage() {
		return DscriptPackage.eINSTANCE;
	}

} //DscriptFactoryImpl
