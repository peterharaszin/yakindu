/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.dml.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipselabs.damos.dml.ChoiceInput;
import org.eclipselabs.damos.dml.DMLFactory;
import org.eclipselabs.damos.dml.DMLPackage;
import org.eclipselabs.damos.dml.InputPort;

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
	 * @see org.eclipselabs.damos.dml.impl.InputImpl#createPort()
	 */
	@Override
	public InputPort createPort() {
		InputPort port = DMLFactory.eINSTANCE.createChoiceInputPort();
		getPorts().add(port);
		return port;
	}

} //ChoiceInputImpl
