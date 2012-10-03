/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.damos.dml.impl;

import org.eclipse.damos.dml.ChoiceInput;
import org.eclipse.damos.dml.DMLFactory;
import org.eclipse.damos.dml.DMLPackage;
import org.eclipse.damos.dml.InputPort;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Choice Input</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class ChoiceInputImpl extends InputImpl implements ChoiceInput {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ChoiceInputImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DMLPackage.Literals.CHOICE_INPUT;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.damos.dml.impl.InputImpl#createPort()
	 */
	@Override
	public InputPort createPort() {
		InputPort port = DMLFactory.eINSTANCE.createChoiceInputPort();
		getPorts().add(port);
		return port;
	}

} //ChoiceInputImpl
