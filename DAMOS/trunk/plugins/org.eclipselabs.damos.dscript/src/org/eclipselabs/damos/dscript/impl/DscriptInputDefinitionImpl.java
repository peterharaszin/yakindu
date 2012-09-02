/**
 */
package org.eclipselabs.damos.dscript.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipselabs.damos.dml.DMLPackage;
import org.eclipselabs.damos.dml.impl.InputDefinitionImpl;
import org.eclipselabs.damos.dscript.DscriptPackage;
import org.eclipselabs.damos.dscript.DscriptInputDefinition;
import org.eclipselabs.damos.mscript.Expression;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Dscript Input Definition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class DscriptInputDefinitionImpl extends InputDefinitionImpl implements DscriptInputDefinition {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DscriptInputDefinitionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DscriptPackage.Literals.DSCRIPT_INPUT_DEFINITION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean isConstant() {
		return false;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.mscript.InputParameterDeclaration#getDefaultExpression()
	 */
	public Expression getDefaultExpression() {
		return null;
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

} //DscriptInputDefinitionImpl
