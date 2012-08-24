/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.mscript.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipselabs.damos.mscript.BuiltinDeclaration;
import org.eclipselabs.damos.mscript.MscriptPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Builtin Definition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class BuiltinDeclarationImpl extends TopLevelDeclarationImpl implements BuiltinDeclaration {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BuiltinDeclarationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MscriptPackage.Literals.BUILTIN_DECLARATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getQualifiedName() {
		return getName();
	}

} //BuiltinDefinitionImpl
