/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.dconfig.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipselabs.damos.dconfig.DconfigPackage;
import org.eclipselabs.damos.dconfig.RunnerDeclaration;
import org.eclipselabs.damos.dconfig.RunnerSpecifier;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Runner Specifier</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.dconfig.impl.RunnerSpecifierImpl#isAuto <em>Auto</em>}</li>
 *   <li>{@link org.eclipselabs.damos.dconfig.impl.RunnerSpecifierImpl#getRunnerDeclaration <em>Runner Declaration</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RunnerSpecifierImpl extends EObjectImpl implements RunnerSpecifier {
	/**
	 * The default value of the '{@link #isAuto() <em>Auto</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAuto()
	 * @generated
	 * @ordered
	 */
	protected static final boolean AUTO_EDEFAULT = false;
	/**
	 * The cached value of the '{@link #isAuto() <em>Auto</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAuto()
	 * @generated
	 * @ordered
	 */
	protected boolean auto = AUTO_EDEFAULT;
	/**
	 * The cached value of the '{@link #getRunnerDeclaration() <em>Runner Declaration</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRunnerDeclaration()
	 * @generated
	 * @ordered
	 */
	protected RunnerDeclaration runnerDeclaration;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RunnerSpecifierImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DconfigPackage.Literals.RUNNER_SPECIFIER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isAuto() {
		return auto;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAuto(boolean newAuto) {
		boolean oldAuto = auto;
		auto = newAuto;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DconfigPackage.RUNNER_SPECIFIER__AUTO, oldAuto, auto));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RunnerDeclaration getRunnerDeclaration() {
		if (runnerDeclaration != null && runnerDeclaration.eIsProxy()) {
			InternalEObject oldRunnerDeclaration = (InternalEObject)runnerDeclaration;
			runnerDeclaration = (RunnerDeclaration)eResolveProxy(oldRunnerDeclaration);
			if (runnerDeclaration != oldRunnerDeclaration) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DconfigPackage.RUNNER_SPECIFIER__RUNNER_DECLARATION, oldRunnerDeclaration, runnerDeclaration));
			}
		}
		return runnerDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RunnerDeclaration basicGetRunnerDeclaration() {
		return runnerDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRunnerDeclaration(RunnerDeclaration newRunnerDeclaration) {
		RunnerDeclaration oldRunnerDeclaration = runnerDeclaration;
		runnerDeclaration = newRunnerDeclaration;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DconfigPackage.RUNNER_SPECIFIER__RUNNER_DECLARATION, oldRunnerDeclaration, runnerDeclaration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DconfigPackage.RUNNER_SPECIFIER__AUTO:
				return isAuto();
			case DconfigPackage.RUNNER_SPECIFIER__RUNNER_DECLARATION:
				if (resolve) return getRunnerDeclaration();
				return basicGetRunnerDeclaration();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case DconfigPackage.RUNNER_SPECIFIER__AUTO:
				setAuto((Boolean)newValue);
				return;
			case DconfigPackage.RUNNER_SPECIFIER__RUNNER_DECLARATION:
				setRunnerDeclaration((RunnerDeclaration)newValue);
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
			case DconfigPackage.RUNNER_SPECIFIER__AUTO:
				setAuto(AUTO_EDEFAULT);
				return;
			case DconfigPackage.RUNNER_SPECIFIER__RUNNER_DECLARATION:
				setRunnerDeclaration((RunnerDeclaration)null);
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
			case DconfigPackage.RUNNER_SPECIFIER__AUTO:
				return auto != AUTO_EDEFAULT;
			case DconfigPackage.RUNNER_SPECIFIER__RUNNER_DECLARATION:
				return runnerDeclaration != null;
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
		result.append(" (auto: ");
		result.append(auto);
		result.append(')');
		return result.toString();
	}

} //RunnerSpecifierImpl
