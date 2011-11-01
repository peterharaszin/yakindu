/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.codegen.c.cgenmodel;

import org.eclipse.emf.ecore.EObject;
import org.eclipselabs.damos.execution.executionmodel.ExecutionModel;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Gen Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.codegen.c.cgenmodel.GenModel#getQualifiedName <em>Qualified Name</em>}</li>
 *   <li>{@link org.eclipselabs.damos.codegen.c.cgenmodel.GenModel#getExecutionModel <em>Execution Model</em>}</li>
 *   <li>{@link org.eclipselabs.damos.codegen.c.cgenmodel.GenModel#getGenTopLevelSystem <em>Gen Top Level System</em>}</li>
 *   <li>{@link org.eclipselabs.damos.codegen.c.cgenmodel.GenModel#getSourceDirectory <em>Source Directory</em>}</li>
 *   <li>{@link org.eclipselabs.damos.codegen.c.cgenmodel.GenModel#getHeaderDirectory <em>Header Directory</em>}</li>
 *   <li>{@link org.eclipselabs.damos.codegen.c.cgenmodel.GenModel#getMainSourceFile <em>Main Source File</em>}</li>
 *   <li>{@link org.eclipselabs.damos.codegen.c.cgenmodel.GenModel#getMainHeaderFile <em>Main Header File</em>}</li>
 *   <li>{@link org.eclipselabs.damos.codegen.c.cgenmodel.GenModel#isSingleton <em>Singleton</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.damos.codegen.c.cgenmodel.CGenModelPackage#getGenModel()
 * @model
 * @generated
 */
public interface GenModel extends EObject {
	/**
	 * Returns the value of the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Qualified Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Qualified Name</em>' attribute.
	 * @see #setQualifiedName(String)
	 * @see org.eclipselabs.damos.codegen.c.cgenmodel.CGenModelPackage#getGenModel_QualifiedName()
	 * @model
	 * @generated
	 */
	String getQualifiedName();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.codegen.c.cgenmodel.GenModel#getQualifiedName <em>Qualified Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Qualified Name</em>' attribute.
	 * @see #getQualifiedName()
	 * @generated
	 */
	void setQualifiedName(String value);

	/**
	 * Returns the value of the '<em><b>Gen Top Level System</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Gen Top Level System</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Gen Top Level System</em>' containment reference.
	 * @see #setGenTopLevelSystem(GenTopLevelSystem)
	 * @see org.eclipselabs.damos.codegen.c.cgenmodel.CGenModelPackage#getGenModel_GenTopLevelSystem()
	 * @model containment="true"
	 * @generated
	 */
	GenTopLevelSystem getGenTopLevelSystem();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.codegen.c.cgenmodel.GenModel#getGenTopLevelSystem <em>Gen Top Level System</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Gen Top Level System</em>' containment reference.
	 * @see #getGenTopLevelSystem()
	 * @generated
	 */
	void setGenTopLevelSystem(GenTopLevelSystem value);

	/**
	 * Returns the value of the '<em><b>Execution Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Execution Model</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Execution Model</em>' reference.
	 * @see #setExecutionModel(ExecutionModel)
	 * @see org.eclipselabs.damos.codegen.c.cgenmodel.CGenModelPackage#getGenModel_ExecutionModel()
	 * @model
	 * @generated
	 */
	ExecutionModel getExecutionModel();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.codegen.c.cgenmodel.GenModel#getExecutionModel <em>Execution Model</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Execution Model</em>' reference.
	 * @see #getExecutionModel()
	 * @generated
	 */
	void setExecutionModel(ExecutionModel value);

	/**
	 * Returns the value of the '<em><b>Source Directory</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source Directory</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Directory</em>' attribute.
	 * @see #setSourceDirectory(String)
	 * @see org.eclipselabs.damos.codegen.c.cgenmodel.CGenModelPackage#getGenModel_SourceDirectory()
	 * @model
	 * @generated
	 */
	String getSourceDirectory();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.codegen.c.cgenmodel.GenModel#getSourceDirectory <em>Source Directory</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source Directory</em>' attribute.
	 * @see #getSourceDirectory()
	 * @generated
	 */
	void setSourceDirectory(String value);

	/**
	 * Returns the value of the '<em><b>Header Directory</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Header Directory</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Header Directory</em>' attribute.
	 * @see #setHeaderDirectory(String)
	 * @see org.eclipselabs.damos.codegen.c.cgenmodel.CGenModelPackage#getGenModel_HeaderDirectory()
	 * @model
	 * @generated
	 */
	String getHeaderDirectory();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.codegen.c.cgenmodel.GenModel#getHeaderDirectory <em>Header Directory</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Header Directory</em>' attribute.
	 * @see #getHeaderDirectory()
	 * @generated
	 */
	void setHeaderDirectory(String value);

	/**
	 * Returns the value of the '<em><b>Main Source File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Main Source File</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Main Source File</em>' attribute.
	 * @see #setMainSourceFile(String)
	 * @see org.eclipselabs.damos.codegen.c.cgenmodel.CGenModelPackage#getGenModel_MainSourceFile()
	 * @model
	 * @generated
	 */
	String getMainSourceFile();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.codegen.c.cgenmodel.GenModel#getMainSourceFile <em>Main Source File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Main Source File</em>' attribute.
	 * @see #getMainSourceFile()
	 * @generated
	 */
	void setMainSourceFile(String value);

	/**
	 * Returns the value of the '<em><b>Main Header File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Main Header File</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Main Header File</em>' attribute.
	 * @see #setMainHeaderFile(String)
	 * @see org.eclipselabs.damos.codegen.c.cgenmodel.CGenModelPackage#getGenModel_MainHeaderFile()
	 * @model
	 * @generated
	 */
	String getMainHeaderFile();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.codegen.c.cgenmodel.GenModel#getMainHeaderFile <em>Main Header File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Main Header File</em>' attribute.
	 * @see #getMainHeaderFile()
	 * @generated
	 */
	void setMainHeaderFile(String value);

	/**
	 * Returns the value of the '<em><b>Singleton</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Singleton</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Singleton</em>' attribute.
	 * @see #setSingleton(boolean)
	 * @see org.eclipselabs.damos.codegen.c.cgenmodel.CGenModelPackage#getGenModel_Singleton()
	 * @model
	 * @generated
	 */
	boolean isSingleton();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.codegen.c.cgenmodel.GenModel#isSingleton <em>Singleton</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Singleton</em>' attribute.
	 * @see #isSingleton()
	 * @generated
	 */
	void setSingleton(boolean value);

} // GenModel
