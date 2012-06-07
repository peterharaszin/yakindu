/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.dconfig.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipselabs.damos.dconfig.DconfigPackage;
import org.eclipselabs.damos.dconfig.DeclaredProperty;
import org.eclipselabs.damos.dconfig.PropertyDeclaration;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Declared Property</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public abstract class DeclaredPropertyImpl extends PropertyImpl implements DeclaredProperty {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DeclaredPropertyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DconfigPackage.Literals.DECLARED_PROPERTY;
	}
	
	@Override
	public String getId() {
		PropertyDeclaration declaration = getDeclaration();
		return declaration != null ? declaration.getQualifiedName() : null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public PropertyDeclaration getDeclaration() {
		throw new UnsupportedOperationException();
	}

} //DeclaredPropertyImpl
