/**
 */
package org.eclipselabs.damos.dscript.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipselabs.damos.dscript.DscriptPackage;
import org.eclipselabs.damos.dscript.OutputMessageParameterDeclaration;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Output Message Parameter Declaration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class OutputMessageParameterDeclarationImpl extends ImplicitOutputParameterDeclarationImpl implements OutputMessageParameterDeclaration {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OutputMessageParameterDeclarationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DscriptPackage.Literals.OUTPUT_MESSAGE_PARAMETER_DECLARATION;
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.mscript.impl.CallableElementImpl#getName()
	 */
	@Override
	public String getName() {
		return "outputMessage";
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.mscript.CallableElement#getNameFeature()
	 */
	public EStructuralFeature getNameFeature() {
		return null;
	}
	
} //OutputMessageParameterDeclarationImpl
