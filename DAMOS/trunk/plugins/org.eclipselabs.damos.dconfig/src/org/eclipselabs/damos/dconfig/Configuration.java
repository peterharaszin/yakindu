/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.dconfig;

import org.eclipse.emf.common.util.EList;
import org.eclipselabs.damos.dml.Fragment;
import org.eclipselabs.damos.dml.util.SystemPath;
import org.eclipselabs.damos.mscript.Expression;
import org.eclipselabs.damos.mscript.ImportDeclaration;
import org.eclipselabs.damos.mscript.computationmodel.ComputationModel;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.dconfig.Configuration#getPackageName <em>Package Name</em>}</li>
 *   <li>{@link org.eclipselabs.damos.dconfig.Configuration#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipselabs.damos.dconfig.Configuration#getBaseConfiguration <em>Base Configuration</em>}</li>
 *   <li>{@link org.eclipselabs.damos.dconfig.Configuration#getImportDeclarations <em>Import Declarations</em>}</li>
 *   <li>{@link org.eclipselabs.damos.dconfig.Configuration#getRootSystemConfiguration <em>Root System Configuration</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.damos.dconfig.DconfigPackage#getConfiguration()
 * @model
 * @generated
 */
public interface Configuration extends PropertyContainer {
	/**
	 * Returns the value of the '<em><b>Package Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Package Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Package Name</em>' attribute.
	 * @see #setPackageName(String)
	 * @see org.eclipselabs.damos.dconfig.DconfigPackage#getConfiguration_PackageName()
	 * @model
	 * @generated
	 */
	String getPackageName();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.dconfig.Configuration#getPackageName <em>Package Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Package Name</em>' attribute.
	 * @see #getPackageName()
	 * @generated
	 */
	void setPackageName(String value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.eclipselabs.damos.dconfig.DconfigPackage#getConfiguration_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.dconfig.Configuration#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Base Configuration</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Extended Configuration</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Configuration</em>' reference.
	 * @see #setBaseConfiguration(Configuration)
	 * @see org.eclipselabs.damos.dconfig.DconfigPackage#getConfiguration_BaseConfiguration()
	 * @model
	 * @generated
	 */
	Configuration getBaseConfiguration();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.dconfig.Configuration#getBaseConfiguration <em>Base Configuration</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Configuration</em>' reference.
	 * @see #getBaseConfiguration()
	 * @generated
	 */
	void setBaseConfiguration(Configuration value);

	/**
	 * Returns the value of the '<em><b>Import Declarations</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipselabs.damos.mscript.ImportDeclaration}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Import Declarations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Import Declarations</em>' containment reference list.
	 * @see org.eclipselabs.damos.dconfig.DconfigPackage#getConfiguration_ImportDeclarations()
	 * @model containment="true"
	 * @generated
	 */
	EList<ImportDeclaration> getImportDeclarations();

	/**
	 * Returns the value of the '<em><b>Root System Configuration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Root System Configuration</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Root System Configuration</em>' containment reference.
	 * @see #setRootSystemConfiguration(RootSystemConfiguration)
	 * @see org.eclipselabs.damos.dconfig.DconfigPackage#getConfiguration_RootSystemConfiguration()
	 * @model containment="true"
	 * @generated
	 */
	RootSystemConfiguration getRootSystemConfiguration();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.dconfig.Configuration#getRootSystemConfiguration <em>Root System Configuration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Root System Configuration</em>' containment reference.
	 * @see #getRootSystemConfiguration()
	 * @generated
	 */
	void setRootSystemConfiguration(RootSystemConfiguration value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	Fragment getContextFragment();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model propertyIdRequired="true"
	 * @generated
	 */
	Expression getPropertyValue(String propertyId);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model pathDataType="org.eclipselabs.damos.dconfig.SystemPath" pathRequired="true" propertyIdRequired="true"
	 * @generated
	 */
	Expression getPropertyValue(SystemPath path, String propertyId);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model propertyIdRequired="true"
	 * @generated
	 */
	String getPropertySelectionName(String propertyId);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model pathDataType="org.eclipselabs.damos.dconfig.SystemPath" pathRequired="true" propertyIdRequired="true"
	 * @generated
	 */
	String getPropertySelectionName(SystemPath path, String propertyId);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model propertyIdRequired="true" sourcePathDataType="org.eclipselabs.damos.dconfig.SystemPath" sourcePathRequired="true"
	 * @generated
	 */
	BindingResourceReference getBindingTarget(String propertyId, SystemPath sourcePath);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model pathDataType="org.eclipselabs.damos.dconfig.SystemPath" pathRequired="true"
	 * @generated
	 */
	ComputationModel getComputationModel(SystemPath path);

} // Configuration
