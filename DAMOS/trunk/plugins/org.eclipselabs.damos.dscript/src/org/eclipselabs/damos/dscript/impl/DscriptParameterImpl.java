/**
 */
package org.eclipselabs.damos.dscript.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipselabs.damos.dml.DMLPackage;
import org.eclipselabs.damos.dml.impl.ParameterImpl;
import org.eclipselabs.damos.dscript.DscriptBlockType;
import org.eclipselabs.damos.dscript.DscriptPackage;
import org.eclipselabs.damos.dscript.DscriptParameter;
import org.eclipselabs.damos.dscript.DscriptValueSpecification;
import org.eclipselabs.damos.mscript.Expression;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Dscript Parameter</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class DscriptParameterImpl extends ParameterImpl implements DscriptParameter {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DscriptParameterImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DscriptPackage.Literals.DSCRIPT_PARAMETER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean isConstant() {
		return true;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.mscript.InputParameterDeclaration#getDefaultExpression()
	 */
	public Expression getDefaultExpression() {
		if (eContainer() instanceof DscriptBlockType && getDefaultValue() instanceof DscriptValueSpecification) {
			return ((DscriptValueSpecification) getDefaultValue()).getExpression();
		}
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
		return DMLPackage.eINSTANCE.getParameter_Name();
	}

} //DscriptParameterImpl
