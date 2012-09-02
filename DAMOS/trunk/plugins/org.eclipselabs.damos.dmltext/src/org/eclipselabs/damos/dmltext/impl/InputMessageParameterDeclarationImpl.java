/**
 */
package org.eclipselabs.damos.dmltext.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipselabs.damos.dmltext.DMLTextPackage;
import org.eclipselabs.damos.dmltext.InputMessageParameterDeclaration;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Input Message Parameter Declaration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class InputMessageParameterDeclarationImpl extends ImplicitInputParameterDeclarationImpl implements InputMessageParameterDeclaration {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InputMessageParameterDeclarationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DMLTextPackage.Literals.INPUT_MESSAGE_PARAMETER_DECLARATION;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.mscript.impl.CallableElementImpl#getName()
	 */
	@Override
	public String getName() {
		return "inputMessage";
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.mscript.impl.InputParameterDeclarationImpl#isConstant()
	 */
	@Override
	public boolean isConstant() {
		return false;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.mscript.CallableElement#getNameFeature()
	 */
	public EStructuralFeature getNameFeature() {
		return null;
	}

} //InputMessageParameterDeclarationImpl
