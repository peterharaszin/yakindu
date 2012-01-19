/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.dconfig;

import org.eclipse.emf.ecore.EObject;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Runner Specifier</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.dconfig.RunnerSpecifier#isAuto <em>Auto</em>}</li>
 *   <li>{@link org.eclipselabs.damos.dconfig.RunnerSpecifier#getRunnerDeclaration <em>Runner Declaration</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.damos.dconfig.DconfigPackage#getRunnerSpecifier()
 * @model
 * @generated
 */
public interface RunnerSpecifier extends EObject {
	/**
	 * Returns the value of the '<em><b>Auto</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Auto</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Auto</em>' attribute.
	 * @see #setAuto(boolean)
	 * @see org.eclipselabs.damos.dconfig.DconfigPackage#getRunnerSpecifier_Auto()
	 * @model
	 * @generated
	 */
	boolean isAuto();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.dconfig.RunnerSpecifier#isAuto <em>Auto</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Auto</em>' attribute.
	 * @see #isAuto()
	 * @generated
	 */
	void setAuto(boolean value);

	/**
	 * Returns the value of the '<em><b>Runner Declaration</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Runner Declaration</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Runner Declaration</em>' reference.
	 * @see #setRunnerDeclaration(RunnerDeclaration)
	 * @see org.eclipselabs.damos.dconfig.DconfigPackage#getRunnerSpecifier_RunnerDeclaration()
	 * @model
	 * @generated
	 */
	RunnerDeclaration getRunnerDeclaration();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.dconfig.RunnerSpecifier#getRunnerDeclaration <em>Runner Declaration</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Runner Declaration</em>' reference.
	 * @see #getRunnerDeclaration()
	 * @generated
	 */
	void setRunnerDeclaration(RunnerDeclaration value);

} // RunnerSpecifier
