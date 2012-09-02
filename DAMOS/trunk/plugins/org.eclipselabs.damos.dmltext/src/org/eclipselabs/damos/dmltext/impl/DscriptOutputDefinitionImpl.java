/**
 */
package org.eclipselabs.damos.dmltext.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipselabs.damos.dml.DMLPackage;
import org.eclipselabs.damos.dml.impl.OutputDefinitionImpl;
import org.eclipselabs.damos.dmltext.DMLTextPackage;
import org.eclipselabs.damos.dmltext.DscriptOutputDefinition;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Dscript Output Definition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class DscriptOutputDefinitionImpl extends OutputDefinitionImpl implements DscriptOutputDefinition {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DscriptOutputDefinitionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DMLTextPackage.Literals.DSCRIPT_OUTPUT_DEFINITION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getQualifiedName() {
		return getName();
	}

	public EStructuralFeature getNameFeature() {
		return DMLPackage.eINSTANCE.getInoutputDefinition_Name();
	}

} //DscriptOutputDefinitionImpl
