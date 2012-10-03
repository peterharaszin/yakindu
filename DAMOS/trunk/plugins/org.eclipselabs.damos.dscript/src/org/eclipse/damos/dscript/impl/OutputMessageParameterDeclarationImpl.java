/**
 */
package org.eclipse.damos.dscript.impl;

import org.eclipse.damos.dscript.DscriptPackage;
import org.eclipse.damos.dscript.OutputMessageParameterDeclaration;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;

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
	 * @see org.eclipse.damos.mscript.impl.CallableElementImpl#getName()
	 */
	@Override
	public String getName() {
		return "outputMessage";
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.damos.mscript.CallableElement#getNameFeature()
	 */
	public EStructuralFeature getNameFeature() {
		return null;
	}
	
} //OutputMessageParameterDeclarationImpl
