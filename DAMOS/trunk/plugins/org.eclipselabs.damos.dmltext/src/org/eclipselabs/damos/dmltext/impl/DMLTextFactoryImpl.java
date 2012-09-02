/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.dmltext.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipselabs.damos.dmltext.*;
import org.eclipselabs.damos.dmltext.DMLTextFactory;
import org.eclipselabs.damos.dmltext.DMLTextPackage;
import org.eclipselabs.damos.dmltext.MscriptBlockType;
import org.eclipselabs.damos.dmltext.MscriptDataTypeSpecification;
import org.eclipselabs.damos.dmltext.MscriptSystemInterface;
import org.eclipselabs.damos.dmltext.MscriptValueSpecification;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class DMLTextFactoryImpl extends EFactoryImpl implements DMLTextFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static DMLTextFactory init() {
		try {
			DMLTextFactory theDMLTextFactory = (DMLTextFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipselabs.org/damos/2011/DMLText"); 
			if (theDMLTextFactory != null) {
				return theDMLTextFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new DMLTextFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DMLTextFactoryImpl() {
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
			case DMLTextPackage.MSCRIPT_BLOCK_TYPE: return createMscriptBlockType();
			case DMLTextPackage.DSCRIPT_INPUT_DEFINITION: return createDscriptInputDefinition();
			case DMLTextPackage.DSCRIPT_OUTPUT_DEFINITION: return createDscriptOutputDefinition();
			case DMLTextPackage.DSCRIPT_PARAMETER: return createDscriptParameter();
			case DMLTextPackage.BEHAVIOR_DECLARATION: return createBehaviorDeclaration();
			case DMLTextPackage.INPUT_MESSAGE_PARAMETER_DECLARATION: return createInputMessageParameterDeclaration();
			case DMLTextPackage.OUTPUT_MESSAGE_PARAMETER_DECLARATION: return createOutputMessageParameterDeclaration();
			case DMLTextPackage.MSCRIPT_SYSTEM_INTERFACE: return createMscriptSystemInterface();
			case DMLTextPackage.MSCRIPT_DATA_TYPE_SPECIFICATION: return createMscriptDataTypeSpecification();
			case DMLTextPackage.MSCRIPT_VALUE_SPECIFICATION: return createMscriptValueSpecification();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MscriptBlockType createMscriptBlockType() {
		MscriptBlockTypeImpl mscriptBlockType = new MscriptBlockTypeImpl();
		return mscriptBlockType;
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
	public MscriptSystemInterface createMscriptSystemInterface() {
		MscriptSystemInterfaceImpl mscriptSystemInterface = new MscriptSystemInterfaceImpl();
		return mscriptSystemInterface;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MscriptDataTypeSpecification createMscriptDataTypeSpecification() {
		MscriptDataTypeSpecificationImpl mscriptDataTypeSpecification = new MscriptDataTypeSpecificationImpl();
		return mscriptDataTypeSpecification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MscriptValueSpecification createMscriptValueSpecification() {
		MscriptValueSpecificationImpl mscriptValueSpecification = new MscriptValueSpecificationImpl();
		return mscriptValueSpecification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DMLTextPackage getDMLTextPackage() {
		return (DMLTextPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static DMLTextPackage getPackage() {
		return DMLTextPackage.eINSTANCE;
	}

} //DMLTextFactoryImpl
