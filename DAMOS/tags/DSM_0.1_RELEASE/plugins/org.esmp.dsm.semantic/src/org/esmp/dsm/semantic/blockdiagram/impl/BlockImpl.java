/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.esmp.dsm.semantic.blockdiagram.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.esmp.dsm.semantic.blockdiagram.Block;
import org.esmp.dsm.semantic.blockdiagram.BlockDiagram;
import org.esmp.dsm.semantic.blockdiagram.BlockDiagramPackage;
import org.esmp.dsm.semantic.blockdiagram.BlockType;
import org.esmp.dsm.semantic.blockdiagram.Input;
import org.esmp.dsm.semantic.blockdiagram.InputPort;
import org.esmp.dsm.semantic.blockdiagram.Output;
import org.esmp.dsm.semantic.blockdiagram.OutputPort;
import org.esmp.dsm.semantic.blockdiagram.Parameter;
import org.esmp.dsm.semantic.blockdiagram.ParameterableElement;
import org.esmp.dsm.semantic.blockdiagram.internal.operations.ParameterableElementOperations;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Block</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.esmp.dsm.semantic.blockdiagram.impl.BlockImpl#getParameters <em>Parameters</em>}</li>
 *   <li>{@link org.esmp.dsm.semantic.blockdiagram.impl.BlockImpl#getInputPorts <em>Input Ports</em>}</li>
 *   <li>{@link org.esmp.dsm.semantic.blockdiagram.impl.BlockImpl#getOutputs <em>Outputs</em>}</li>
 *   <li>{@link org.esmp.dsm.semantic.blockdiagram.impl.BlockImpl#getInputs <em>Inputs</em>}</li>
 *   <li>{@link org.esmp.dsm.semantic.blockdiagram.impl.BlockImpl#getOutputPorts <em>Output Ports</em>}</li>
 *   <li>{@link org.esmp.dsm.semantic.blockdiagram.impl.BlockImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.esmp.dsm.semantic.blockdiagram.impl.BlockImpl#isVirtual <em>Virtual</em>}</li>
 *   <li>{@link org.esmp.dsm.semantic.blockdiagram.impl.BlockImpl#getBlockDiagram <em>Block Diagram</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BlockImpl extends NamedElementImpl implements Block {
	/**
	 * The cached value of the '{@link #getParameters() <em>Parameters</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameters()
	 * @generated
	 * @ordered
	 */
	protected EList<Parameter> parameters;
	/**
	 * The cached value of the '{@link #getOutputs() <em>Outputs</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputs()
	 * @generated
	 * @ordered
	 */
	protected EList<Output> outputs;
	/**
	 * The cached value of the '{@link #getInputs() <em>Inputs</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputs()
	 * @generated
	 * @ordered
	 */
	protected EList<Input> inputs;
	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected BlockType type;

	/**
	 * The default value of the '{@link #isVirtual() <em>Virtual</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isVirtual()
	 * @generated
	 * @ordered
	 */
	protected static final boolean VIRTUAL_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isVirtual() <em>Virtual</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isVirtual()
	 * @generated
	 * @ordered
	 */
	protected boolean virtual = VIRTUAL_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BlockImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BlockDiagramPackage.Literals.BLOCK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Parameter> getParameters() {
		if (parameters == null) {
			parameters = new EObjectContainmentEList<Parameter>(Parameter.class, this, BlockDiagramPackage.BLOCK__PARAMETERS);
		}
		return parameters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<InputPort> getInputPorts() {
		EList<InputPort> inputPorts = new BasicEList<InputPort>();
		for (Input input : getInputs()) {
			inputPorts.addAll(input.getPorts());
		}
		return inputPorts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Output> getOutputs() {
		if (outputs == null) {
			outputs = new EObjectContainmentWithInverseEList<Output>(Output.class, this, BlockDiagramPackage.BLOCK__OUTPUTS, BlockDiagramPackage.OUTPUT__BLOCK);
		}
		return outputs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Input> getInputs() {
		if (inputs == null) {
			inputs = new EObjectContainmentWithInverseEList<Input>(Input.class, this, BlockDiagramPackage.BLOCK__INPUTS, BlockDiagramPackage.INPUT__BLOCK);
		}
		return inputs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<OutputPort> getOutputPorts() {
		EList<OutputPort> outputPorts = new BasicEList<OutputPort>();
		for (Output output : getOutputs()) {
			outputPorts.addAll(output.getPorts());
		}
		return outputPorts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BlockType getType() {
		if (type != null && type.eIsProxy()) {
			InternalEObject oldType = (InternalEObject)type;
			type = (BlockType)eResolveProxy(oldType);
			if (type != oldType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BlockDiagramPackage.BLOCK__TYPE, oldType, type));
			}
		}
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BlockType basicGetType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(BlockType newType) {
		BlockType oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BlockDiagramPackage.BLOCK__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isVirtual() {
		return virtual;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVirtual(boolean newVirtual) {
		boolean oldVirtual = virtual;
		virtual = newVirtual;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BlockDiagramPackage.BLOCK__VIRTUAL, oldVirtual, virtual));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BlockDiagram getBlockDiagram() {
		if (eContainerFeatureID() != BlockDiagramPackage.BLOCK__BLOCK_DIAGRAM) return null;
		return (BlockDiagram)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBlockDiagram(BlockDiagram newBlockDiagram, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newBlockDiagram, BlockDiagramPackage.BLOCK__BLOCK_DIAGRAM, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBlockDiagram(BlockDiagram newBlockDiagram) {
		if (newBlockDiagram != eInternalContainer() || (eContainerFeatureID() != BlockDiagramPackage.BLOCK__BLOCK_DIAGRAM && newBlockDiagram != null)) {
			if (EcoreUtil.isAncestor(this, newBlockDiagram))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newBlockDiagram != null)
				msgs = ((InternalEObject)newBlockDiagram).eInverseAdd(this, BlockDiagramPackage.BLOCK_DIAGRAM__BLOCKS, BlockDiagram.class, msgs);
			msgs = basicSetBlockDiagram(newBlockDiagram, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BlockDiagramPackage.BLOCK__BLOCK_DIAGRAM, newBlockDiagram, newBlockDiagram));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Parameter getParameter(String name) {
		return ParameterableElementOperations.getParameter(this, name);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getParameterValue(String name) {
		return ParameterableElementOperations.getParameterValue(this, name);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Input getInput(String name) {
		for (Input input : getInputs()) {
			if (name.equals(input.getSpecification().getName())) {
				return input;
			}
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Output getOutput(String name) {
		for (Output output : getOutputs()) {
			if (name.equals(output.getSpecification().getName())) {
				return output;
			}
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case BlockDiagramPackage.BLOCK__OUTPUTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOutputs()).basicAdd(otherEnd, msgs);
			case BlockDiagramPackage.BLOCK__INPUTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getInputs()).basicAdd(otherEnd, msgs);
			case BlockDiagramPackage.BLOCK__BLOCK_DIAGRAM:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetBlockDiagram((BlockDiagram)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case BlockDiagramPackage.BLOCK__PARAMETERS:
				return ((InternalEList<?>)getParameters()).basicRemove(otherEnd, msgs);
			case BlockDiagramPackage.BLOCK__OUTPUTS:
				return ((InternalEList<?>)getOutputs()).basicRemove(otherEnd, msgs);
			case BlockDiagramPackage.BLOCK__INPUTS:
				return ((InternalEList<?>)getInputs()).basicRemove(otherEnd, msgs);
			case BlockDiagramPackage.BLOCK__BLOCK_DIAGRAM:
				return basicSetBlockDiagram(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case BlockDiagramPackage.BLOCK__BLOCK_DIAGRAM:
				return eInternalContainer().eInverseRemove(this, BlockDiagramPackage.BLOCK_DIAGRAM__BLOCKS, BlockDiagram.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case BlockDiagramPackage.BLOCK__PARAMETERS:
				return getParameters();
			case BlockDiagramPackage.BLOCK__INPUT_PORTS:
				return getInputPorts();
			case BlockDiagramPackage.BLOCK__OUTPUTS:
				return getOutputs();
			case BlockDiagramPackage.BLOCK__INPUTS:
				return getInputs();
			case BlockDiagramPackage.BLOCK__OUTPUT_PORTS:
				return getOutputPorts();
			case BlockDiagramPackage.BLOCK__TYPE:
				if (resolve) return getType();
				return basicGetType();
			case BlockDiagramPackage.BLOCK__VIRTUAL:
				return isVirtual();
			case BlockDiagramPackage.BLOCK__BLOCK_DIAGRAM:
				return getBlockDiagram();
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
			case BlockDiagramPackage.BLOCK__PARAMETERS:
				getParameters().clear();
				getParameters().addAll((Collection<? extends Parameter>)newValue);
				return;
			case BlockDiagramPackage.BLOCK__OUTPUTS:
				getOutputs().clear();
				getOutputs().addAll((Collection<? extends Output>)newValue);
				return;
			case BlockDiagramPackage.BLOCK__INPUTS:
				getInputs().clear();
				getInputs().addAll((Collection<? extends Input>)newValue);
				return;
			case BlockDiagramPackage.BLOCK__TYPE:
				setType((BlockType)newValue);
				return;
			case BlockDiagramPackage.BLOCK__VIRTUAL:
				setVirtual((Boolean)newValue);
				return;
			case BlockDiagramPackage.BLOCK__BLOCK_DIAGRAM:
				setBlockDiagram((BlockDiagram)newValue);
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
			case BlockDiagramPackage.BLOCK__PARAMETERS:
				getParameters().clear();
				return;
			case BlockDiagramPackage.BLOCK__OUTPUTS:
				getOutputs().clear();
				return;
			case BlockDiagramPackage.BLOCK__INPUTS:
				getInputs().clear();
				return;
			case BlockDiagramPackage.BLOCK__TYPE:
				setType((BlockType)null);
				return;
			case BlockDiagramPackage.BLOCK__VIRTUAL:
				setVirtual(VIRTUAL_EDEFAULT);
				return;
			case BlockDiagramPackage.BLOCK__BLOCK_DIAGRAM:
				setBlockDiagram((BlockDiagram)null);
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
			case BlockDiagramPackage.BLOCK__PARAMETERS:
				return parameters != null && !parameters.isEmpty();
			case BlockDiagramPackage.BLOCK__INPUT_PORTS:
				return !getInputPorts().isEmpty();
			case BlockDiagramPackage.BLOCK__OUTPUTS:
				return outputs != null && !outputs.isEmpty();
			case BlockDiagramPackage.BLOCK__INPUTS:
				return inputs != null && !inputs.isEmpty();
			case BlockDiagramPackage.BLOCK__OUTPUT_PORTS:
				return !getOutputPorts().isEmpty();
			case BlockDiagramPackage.BLOCK__TYPE:
				return type != null;
			case BlockDiagramPackage.BLOCK__VIRTUAL:
				return virtual != VIRTUAL_EDEFAULT;
			case BlockDiagramPackage.BLOCK__BLOCK_DIAGRAM:
				return getBlockDiagram() != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == ParameterableElement.class) {
			switch (derivedFeatureID) {
				case BlockDiagramPackage.BLOCK__PARAMETERS: return BlockDiagramPackage.PARAMETERABLE_ELEMENT__PARAMETERS;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == ParameterableElement.class) {
			switch (baseFeatureID) {
				case BlockDiagramPackage.PARAMETERABLE_ELEMENT__PARAMETERS: return BlockDiagramPackage.BLOCK__PARAMETERS;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (virtual: ");
		result.append(virtual);
		result.append(')');
		return result.toString();
	}

} //BlockImpl
