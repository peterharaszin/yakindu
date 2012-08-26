/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.mscript.functionmodel;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipselabs.damos.mscript.CompoundStatement;
import org.eclipselabs.damos.mscript.FunctionDeclaration;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Function Instance</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.mscript.functionmodel.FunctionInstance#getDeclaration <em>Declaration</em>}</li>
 *   <li>{@link org.eclipselabs.damos.mscript.functionmodel.FunctionInstance#getInitializationCompound <em>Initialization Compound</em>}</li>
 *   <li>{@link org.eclipselabs.damos.mscript.functionmodel.FunctionInstance#getComputationCompounds <em>Computation Compounds</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.damos.mscript.functionmodel.FunctionModelPackage#getFunctionInstance()
 * @model
 * @generated
 */
public interface FunctionInstance extends EObject {
	/**
	 * Returns the value of the '<em><b>Declaration</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Function Definition</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Declaration</em>' reference.
	 * @see #setDeclaration(FunctionDeclaration)
	 * @see org.eclipselabs.damos.mscript.functionmodel.FunctionModelPackage#getFunctionInstance_Declaration()
	 * @model required="true"
	 * @generated
	 */
	FunctionDeclaration getDeclaration();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.mscript.functionmodel.FunctionInstance#getDeclaration <em>Declaration</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Declaration</em>' reference.
	 * @see #getDeclaration()
	 * @generated
	 */
	void setDeclaration(FunctionDeclaration value);

	/**
	 * Returns the value of the '<em><b>Initialization Compound</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Initialization Compound</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Initialization Compound</em>' containment reference.
	 * @see #setInitializationCompound(CompoundStatement)
	 * @see org.eclipselabs.damos.mscript.functionmodel.FunctionModelPackage#getFunctionInstance_InitializationCompound()
	 * @model containment="true"
	 * @generated
	 */
	CompoundStatement getInitializationCompound();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.mscript.functionmodel.FunctionInstance#getInitializationCompound <em>Initialization Compound</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Initialization Compound</em>' containment reference.
	 * @see #getInitializationCompound()
	 * @generated
	 */
	void setInitializationCompound(CompoundStatement value);

	/**
	 * Returns the value of the '<em><b>Computation Compounds</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipselabs.damos.mscript.functionmodel.ComputationCompound}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Computation Compounds</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Computation Compounds</em>' containment reference list.
	 * @see org.eclipselabs.damos.mscript.functionmodel.FunctionModelPackage#getFunctionInstance_ComputationCompounds()
	 * @model containment="true"
	 * @generated
	 */
	EList<ComputationCompound> getComputationCompounds();

} // FunctionInstance
