/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.mscript.functionmodel.impl;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipselabs.damos.mscript.InputParameterDeclaration;
import org.eclipselabs.damos.mscript.OutputParameterDeclaration;
import org.eclipselabs.damos.mscript.VariableDeclaration;
import org.eclipselabs.damos.mscript.functionmodel.ComputationCompound;
import org.eclipselabs.damos.mscript.functionmodel.FunctionModelPackage;
import org.eclipselabs.damos.mscript.impl.CompoundImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Computation Compound</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.mscript.functionmodel.impl.ComputationCompoundImpl#getInputs <em>Inputs</em>}</li>
 *   <li>{@link org.eclipselabs.damos.mscript.functionmodel.impl.ComputationCompoundImpl#getOutputs <em>Outputs</em>}</li>
 *   <li>{@link org.eclipselabs.damos.mscript.functionmodel.impl.ComputationCompoundImpl#getDerivatives <em>Derivatives</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ComputationCompoundImpl extends CompoundImpl implements ComputationCompound {
	/**
	 * The cached value of the '{@link #getInputs() <em>Inputs</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputs()
	 * @generated
	 * @ordered
	 */
	protected EList<InputParameterDeclaration> inputs;

	/**
	 * The cached value of the '{@link #getOutputs() <em>Outputs</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputs()
	 * @generated
	 * @ordered
	 */
	protected EList<OutputParameterDeclaration> outputs;

	/**
	 * The cached value of the '{@link #getDerivatives() <em>Derivatives</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDerivatives()
	 * @generated
	 * @ordered
	 */
	protected EList<VariableDeclaration> derivatives;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComputationCompoundImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FunctionModelPackage.Literals.COMPUTATION_COMPOUND;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<InputParameterDeclaration> getInputs() {
		if (inputs == null) {
			inputs = new EObjectResolvingEList<InputParameterDeclaration>(InputParameterDeclaration.class, this, FunctionModelPackage.COMPUTATION_COMPOUND__INPUTS);
		}
		return inputs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<OutputParameterDeclaration> getOutputs() {
		if (outputs == null) {
			outputs = new EObjectResolvingEList<OutputParameterDeclaration>(OutputParameterDeclaration.class, this, FunctionModelPackage.COMPUTATION_COMPOUND__OUTPUTS);
		}
		return outputs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<VariableDeclaration> getDerivatives() {
		if (derivatives == null) {
			derivatives = new EObjectResolvingEList<VariableDeclaration>(VariableDeclaration.class, this, FunctionModelPackage.COMPUTATION_COMPOUND__DERIVATIVES);
		}
		return derivatives;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case FunctionModelPackage.COMPUTATION_COMPOUND__INPUTS:
				return getInputs();
			case FunctionModelPackage.COMPUTATION_COMPOUND__OUTPUTS:
				return getOutputs();
			case FunctionModelPackage.COMPUTATION_COMPOUND__DERIVATIVES:
				return getDerivatives();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case FunctionModelPackage.COMPUTATION_COMPOUND__INPUTS:
				getInputs().clear();
				getInputs().addAll((Collection<? extends InputParameterDeclaration>)newValue);
				return;
			case FunctionModelPackage.COMPUTATION_COMPOUND__OUTPUTS:
				getOutputs().clear();
				getOutputs().addAll((Collection<? extends OutputParameterDeclaration>)newValue);
				return;
			case FunctionModelPackage.COMPUTATION_COMPOUND__DERIVATIVES:
				getDerivatives().clear();
				getDerivatives().addAll((Collection<? extends VariableDeclaration>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case FunctionModelPackage.COMPUTATION_COMPOUND__INPUTS:
				getInputs().clear();
				return;
			case FunctionModelPackage.COMPUTATION_COMPOUND__OUTPUTS:
				getOutputs().clear();
				return;
			case FunctionModelPackage.COMPUTATION_COMPOUND__DERIVATIVES:
				getDerivatives().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case FunctionModelPackage.COMPUTATION_COMPOUND__INPUTS:
				return inputs != null && !inputs.isEmpty();
			case FunctionModelPackage.COMPUTATION_COMPOUND__OUTPUTS:
				return outputs != null && !outputs.isEmpty();
			case FunctionModelPackage.COMPUTATION_COMPOUND__DERIVATIVES:
				return derivatives != null && !derivatives.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ComputationCompoundImpl
