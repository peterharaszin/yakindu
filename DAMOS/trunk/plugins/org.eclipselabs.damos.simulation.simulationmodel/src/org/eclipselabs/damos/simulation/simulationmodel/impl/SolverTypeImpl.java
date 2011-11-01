/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.simulation.simulationmodel.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipselabs.damos.simulation.simulationmodel.SimulationModelPackage;
import org.eclipselabs.damos.simulation.simulationmodel.SolverConfigurationDefinition;
import org.eclipselabs.damos.simulation.simulationmodel.SolverType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Solver Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.simulation.simulationmodel.impl.SolverTypeImpl#getQualifiedName <em>Qualified Name</em>}</li>
 *   <li>{@link org.eclipselabs.damos.simulation.simulationmodel.impl.SolverTypeImpl#getConfigurationDefinition <em>Configuration Definition</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SolverTypeImpl extends EObjectImpl implements SolverType {
	/**
	 * The default value of the '{@link #getQualifiedName() <em>Qualified Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQualifiedName()
	 * @generated
	 * @ordered
	 */
	protected static final String QUALIFIED_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getQualifiedName() <em>Qualified Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQualifiedName()
	 * @generated
	 * @ordered
	 */
	protected String qualifiedName = QUALIFIED_NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getConfigurationDefinition() <em>Configuration Definition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConfigurationDefinition()
	 * @generated
	 * @ordered
	 */
	protected SolverConfigurationDefinition configurationDefinition;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SolverTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SimulationModelPackage.Literals.SOLVER_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getQualifiedName() {
		return qualifiedName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setQualifiedName(String newQualifiedName) {
		String oldQualifiedName = qualifiedName;
		qualifiedName = newQualifiedName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SimulationModelPackage.SOLVER_TYPE__QUALIFIED_NAME, oldQualifiedName, qualifiedName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SolverConfigurationDefinition getConfigurationDefinition() {
		if (configurationDefinition != null && configurationDefinition.eIsProxy()) {
			InternalEObject oldConfigurationDefinition = (InternalEObject)configurationDefinition;
			configurationDefinition = (SolverConfigurationDefinition)eResolveProxy(oldConfigurationDefinition);
			if (configurationDefinition != oldConfigurationDefinition) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SimulationModelPackage.SOLVER_TYPE__CONFIGURATION_DEFINITION, oldConfigurationDefinition, configurationDefinition));
			}
		}
		return configurationDefinition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SolverConfigurationDefinition basicGetConfigurationDefinition() {
		return configurationDefinition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConfigurationDefinition(SolverConfigurationDefinition newConfigurationDefinition) {
		SolverConfigurationDefinition oldConfigurationDefinition = configurationDefinition;
		configurationDefinition = newConfigurationDefinition;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SimulationModelPackage.SOLVER_TYPE__CONFIGURATION_DEFINITION, oldConfigurationDefinition, configurationDefinition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SimulationModelPackage.SOLVER_TYPE__QUALIFIED_NAME:
				return getQualifiedName();
			case SimulationModelPackage.SOLVER_TYPE__CONFIGURATION_DEFINITION:
				if (resolve) return getConfigurationDefinition();
				return basicGetConfigurationDefinition();
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
			case SimulationModelPackage.SOLVER_TYPE__QUALIFIED_NAME:
				setQualifiedName((String)newValue);
				return;
			case SimulationModelPackage.SOLVER_TYPE__CONFIGURATION_DEFINITION:
				setConfigurationDefinition((SolverConfigurationDefinition)newValue);
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
			case SimulationModelPackage.SOLVER_TYPE__QUALIFIED_NAME:
				setQualifiedName(QUALIFIED_NAME_EDEFAULT);
				return;
			case SimulationModelPackage.SOLVER_TYPE__CONFIGURATION_DEFINITION:
				setConfigurationDefinition((SolverConfigurationDefinition)null);
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
			case SimulationModelPackage.SOLVER_TYPE__QUALIFIED_NAME:
				return QUALIFIED_NAME_EDEFAULT == null ? qualifiedName != null : !QUALIFIED_NAME_EDEFAULT.equals(qualifiedName);
			case SimulationModelPackage.SOLVER_TYPE__CONFIGURATION_DEFINITION:
				return configurationDefinition != null;
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
		result.append(" (qualifiedName: ");
		result.append(qualifiedName);
		result.append(')');
		return result.toString();
	}

} //SolverTypeImpl
