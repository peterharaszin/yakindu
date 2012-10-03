/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.damos.dconfig;

import org.eclipse.damos.common.util.NumberedList;
import org.eclipse.damos.dconfig.util.PropertyPath;
import org.eclipse.damos.dml.Fragment;
import org.eclipse.damos.dml.util.SystemPath;
import org.eclipse.damos.mscript.Expression;
import org.eclipse.damos.mscript.ImportDeclaration;
import org.eclipse.damos.mscript.computation.ComputationModel;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.damos.dconfig.Configuration#getPackageName <em>Package Name</em>}</li>
 *   <li>{@link org.eclipse.damos.dconfig.Configuration#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.damos.dconfig.Configuration#getBaseConfiguration <em>Base Configuration</em>}</li>
 *   <li>{@link org.eclipse.damos.dconfig.Configuration#getImportDeclarations <em>Import Declarations</em>}</li>
 *   <li>{@link org.eclipse.damos.dconfig.Configuration#getRootSystemConfiguration <em>Root System Configuration</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.damos.dconfig.DconfigPackage#getConfiguration()
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
	 * @see org.eclipse.damos.dconfig.DconfigPackage#getConfiguration_PackageName()
	 * @model
	 * @generated
	 */
	String getPackageName();

	/**
	 * Sets the value of the '{@link org.eclipse.damos.dconfig.Configuration#getPackageName <em>Package Name</em>}' attribute.
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
	 * @see org.eclipse.damos.dconfig.DconfigPackage#getConfiguration_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.damos.dconfig.Configuration#getName <em>Name</em>}' attribute.
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
	 * @see org.eclipse.damos.dconfig.DconfigPackage#getConfiguration_BaseConfiguration()
	 * @model
	 * @generated
	 */
	Configuration getBaseConfiguration();

	/**
	 * Sets the value of the '{@link org.eclipse.damos.dconfig.Configuration#getBaseConfiguration <em>Base Configuration</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Configuration</em>' reference.
	 * @see #getBaseConfiguration()
	 * @generated
	 */
	void setBaseConfiguration(Configuration value);

	/**
	 * Returns the value of the '<em><b>Import Declarations</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.damos.mscript.ImportDeclaration}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Import Declarations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Import Declarations</em>' containment reference list.
	 * @see org.eclipse.damos.dconfig.DconfigPackage#getConfiguration_ImportDeclarations()
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
	 * @see org.eclipse.damos.dconfig.DconfigPackage#getConfiguration_RootSystemConfiguration()
	 * @model containment="true"
	 * @generated
	 */
	RootSystemConfiguration getRootSystemConfiguration();

	/**
	 * Sets the value of the '{@link org.eclipse.damos.dconfig.Configuration#getRootSystemConfiguration <em>Root System Configuration</em>}' containment reference.
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
	 * @model propertyPathDataType="org.eclipse.damos.dconfig.PropertyPath" propertyPathRequired="true"
	 * @generated
	 */
	Expression getPropertyValue(PropertyPath propertyPath);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model systemPathDataType="org.eclipse.damos.dconfig.SystemPath" systemPathRequired="true" propertyPathDataType="org.eclipse.damos.dconfig.PropertyPath" propertyPathRequired="true"
	 * @generated
	 */
	Expression getPropertyValue(SystemPath systemPath, PropertyPath propertyPath);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model propertyPathDataType="org.eclipse.damos.dconfig.PropertyPath" propertyPathRequired="true"
	 * @generated
	 */
	String getPropertySelectionName(PropertyPath propertyPath);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model systemPathDataType="org.eclipse.damos.dconfig.SystemPath" systemPathRequired="true" propertyPathDataType="org.eclipse.damos.dconfig.PropertyPath" propertyPathRequired="true"
	 * @generated
	 */
	String getPropertySelectionName(SystemPath systemPath, PropertyPath propertyPath);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model dataType="org.eclipse.damos.dconfig.NumberedList<org.eclipse.emf.ecore.EString>" propertyPathDataType="org.eclipse.damos.dconfig.PropertyPath" propertyPathRequired="true"
	 * @generated
	 */
	NumberedList<String> getPropertySelectionNames(PropertyPath propertyPath);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model dataType="org.eclipse.damos.dconfig.NumberedList<org.eclipse.emf.ecore.EString>" systemPathDataType="org.eclipse.damos.dconfig.SystemPath" systemPathRequired="true" propertyPathDataType="org.eclipse.damos.dconfig.PropertyPath" propertyPathRequired="true"
	 * @generated
	 */
	NumberedList<String> getPropertySelectionNames(SystemPath systemPath, PropertyPath propertyPath);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model propertyPathDataType="org.eclipse.damos.dconfig.PropertyPath" propertyPathRequired="true" sourcePathDataType="org.eclipse.damos.dconfig.SystemPath" sourcePathRequired="true"
	 * @generated
	 */
	Binding getBinding(PropertyPath propertyPath, SystemPath sourcePath);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model systemPathDataType="org.eclipse.damos.dconfig.SystemPath" systemPathRequired="true"
	 * @generated
	 */
	ComputationModel getComputationModel(SystemPath systemPath);

} // Configuration
