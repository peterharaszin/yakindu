/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.dml.internal.operations;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipselabs.damos.dml.Component;
import org.eclipselabs.damos.dml.Connection;
import org.eclipselabs.damos.dml.DMLPackage;
import org.eclipselabs.damos.dml.Fragment;
import org.eclipselabs.damos.dml.internal.util.CrossReferencerUtil;

/**
 * <!-- begin-user-doc -->
 * A static utility class that provides operations related to '<em><b>Fragment</b></em>' model objects.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following operations are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.dml.Fragment#getChildren() <em>Get Children</em>}</li>
 *   <li>{@link org.eclipselabs.damos.dml.Fragment#getAllComponents() <em>Get All Components</em>}</li>
 *   <li>{@link org.eclipselabs.damos.dml.Fragment#getAllConnections() <em>Get All Connections</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FragmentOperations {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FragmentOperations() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public static  EList<Fragment> getChildren(Fragment fragment) {
		EList<Fragment> fragments = new UniqueEList.FastCompare<Fragment>();
		for (EStructuralFeature.Setting nonNavigableInverseReference : CrossReferencerUtil.getNonNavigableInverseReferences(fragment)) {
			if (nonNavigableInverseReference.getEStructuralFeature() == DMLPackage.Literals.FRAGMENT__PARENT) {
				EObject referenceEObject = nonNavigableInverseReference.getEObject();
				if (referenceEObject instanceof Fragment) {
					fragments.add((Fragment) referenceEObject);
				}
			}
		}
		return fragments;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public static  EList<Component> getAllComponents(Fragment fragment) {
		EList<Component> components = new BasicEList<Component>(fragment.getComponents());
		while (fragment.getParent() != null) {
			fragment = fragment.getParent();
			components.addAll(fragment.getComponents());
		}
		return components;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public static  EList<Connection> getAllConnections(Fragment fragment) {
		EList<Connection> connections = new BasicEList<Connection>(fragment.getConnections());
		while (fragment.getParent() != null) {
			fragment = fragment.getParent();
			connections.addAll(fragment.getConnections());
		}
		return connections;
	}

} // FragmentOperations