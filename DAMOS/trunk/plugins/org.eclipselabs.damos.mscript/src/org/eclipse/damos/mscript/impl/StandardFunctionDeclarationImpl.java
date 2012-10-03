/**
 */
package org.eclipse.damos.mscript.impl;

import java.util.Collection;

import org.eclipse.damos.mscript.FunctionKind;
import org.eclipse.damos.mscript.InputParameterDeclaration;
import org.eclipse.damos.mscript.MscriptPackage;
import org.eclipse.damos.mscript.OutputParameterDeclaration;
import org.eclipse.damos.mscript.StandardFunctionDeclaration;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Standard Function Declaration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.damos.mscript.impl.StandardFunctionDeclarationImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.damos.mscript.impl.StandardFunctionDeclarationImpl#getKind <em>Kind</em>}</li>
 *   <li>{@link org.eclipse.damos.mscript.impl.StandardFunctionDeclarationImpl#getInputParameterDeclarations <em>Input Parameter Declarations</em>}</li>
 *   <li>{@link org.eclipse.damos.mscript.impl.StandardFunctionDeclarationImpl#getOutputParameterDeclarations <em>Output Parameter Declarations</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StandardFunctionDeclarationImpl extends FunctionDeclarationImpl implements StandardFunctionDeclaration {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKind()
	 * @generated
	 * @ordered
	 */
	protected static final FunctionKind KIND_EDEFAULT = FunctionKind.STANDARD;

	/**
	 * The cached value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKind()
	 * @generated
	 * @ordered
	 */
	protected FunctionKind kind = KIND_EDEFAULT;

	/**
	 * The cached value of the '{@link #getInputParameterDeclarations() <em>Input Parameter Declarations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputParameterDeclarations()
	 * @generated
	 * @ordered
	 */
	protected EList<InputParameterDeclaration> inputParameterDeclarations;

	/**
	 * The cached value of the '{@link #getOutputParameterDeclarations() <em>Output Parameter Declarations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputParameterDeclarations()
	 * @generated
	 * @ordered
	 */
	protected EList<OutputParameterDeclaration> outputParameterDeclarations;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StandardFunctionDeclarationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MscriptPackage.Literals.STANDARD_FUNCTION_DECLARATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MscriptPackage.STANDARD_FUNCTION_DECLARATION__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FunctionKind getKind() {
		return kind;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setKind(FunctionKind newKind) {
		FunctionKind oldKind = kind;
		kind = newKind == null ? KIND_EDEFAULT : newKind;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MscriptPackage.STANDARD_FUNCTION_DECLARATION__KIND, oldKind, kind));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<InputParameterDeclaration> getInputParameterDeclarations() {
		if (inputParameterDeclarations == null) {
			inputParameterDeclarations = new EObjectContainmentEList<InputParameterDeclaration>(InputParameterDeclaration.class, this, MscriptPackage.STANDARD_FUNCTION_DECLARATION__INPUT_PARAMETER_DECLARATIONS);
		}
		return inputParameterDeclarations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<OutputParameterDeclaration> getOutputParameterDeclarations() {
		if (outputParameterDeclarations == null) {
			outputParameterDeclarations = new EObjectContainmentEList<OutputParameterDeclaration>(OutputParameterDeclaration.class, this, MscriptPackage.STANDARD_FUNCTION_DECLARATION__OUTPUT_PARAMETER_DECLARATIONS);
		}
		return outputParameterDeclarations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getQualifiedName() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}
	
	public EStructuralFeature getNameFeature() {
		return MscriptPackage.eINSTANCE.getStandardFunctionDeclaration_Name();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MscriptPackage.STANDARD_FUNCTION_DECLARATION__INPUT_PARAMETER_DECLARATIONS:
				return ((InternalEList<?>)getInputParameterDeclarations()).basicRemove(otherEnd, msgs);
			case MscriptPackage.STANDARD_FUNCTION_DECLARATION__OUTPUT_PARAMETER_DECLARATIONS:
				return ((InternalEList<?>)getOutputParameterDeclarations()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MscriptPackage.STANDARD_FUNCTION_DECLARATION__NAME:
				return getName();
			case MscriptPackage.STANDARD_FUNCTION_DECLARATION__KIND:
				return getKind();
			case MscriptPackage.STANDARD_FUNCTION_DECLARATION__INPUT_PARAMETER_DECLARATIONS:
				return getInputParameterDeclarations();
			case MscriptPackage.STANDARD_FUNCTION_DECLARATION__OUTPUT_PARAMETER_DECLARATIONS:
				return getOutputParameterDeclarations();
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
			case MscriptPackage.STANDARD_FUNCTION_DECLARATION__NAME:
				setName((String)newValue);
				return;
			case MscriptPackage.STANDARD_FUNCTION_DECLARATION__KIND:
				setKind((FunctionKind)newValue);
				return;
			case MscriptPackage.STANDARD_FUNCTION_DECLARATION__INPUT_PARAMETER_DECLARATIONS:
				getInputParameterDeclarations().clear();
				getInputParameterDeclarations().addAll((Collection<? extends InputParameterDeclaration>)newValue);
				return;
			case MscriptPackage.STANDARD_FUNCTION_DECLARATION__OUTPUT_PARAMETER_DECLARATIONS:
				getOutputParameterDeclarations().clear();
				getOutputParameterDeclarations().addAll((Collection<? extends OutputParameterDeclaration>)newValue);
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
			case MscriptPackage.STANDARD_FUNCTION_DECLARATION__NAME:
				setName(NAME_EDEFAULT);
				return;
			case MscriptPackage.STANDARD_FUNCTION_DECLARATION__KIND:
				setKind(KIND_EDEFAULT);
				return;
			case MscriptPackage.STANDARD_FUNCTION_DECLARATION__INPUT_PARAMETER_DECLARATIONS:
				getInputParameterDeclarations().clear();
				return;
			case MscriptPackage.STANDARD_FUNCTION_DECLARATION__OUTPUT_PARAMETER_DECLARATIONS:
				getOutputParameterDeclarations().clear();
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
			case MscriptPackage.STANDARD_FUNCTION_DECLARATION__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case MscriptPackage.STANDARD_FUNCTION_DECLARATION__KIND:
				return kind != KIND_EDEFAULT;
			case MscriptPackage.STANDARD_FUNCTION_DECLARATION__INPUT_PARAMETER_DECLARATIONS:
				return inputParameterDeclarations != null && !inputParameterDeclarations.isEmpty();
			case MscriptPackage.STANDARD_FUNCTION_DECLARATION__OUTPUT_PARAMETER_DECLARATIONS:
				return outputParameterDeclarations != null && !outputParameterDeclarations.isEmpty();
		}
		return super.eIsSet(featureID);
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
		result.append(" (name: ");
		result.append(name);
		result.append(", kind: ");
		result.append(kind);
		result.append(')');
		return result.toString();
	}

} //StandardFunctionDeclarationImpl
