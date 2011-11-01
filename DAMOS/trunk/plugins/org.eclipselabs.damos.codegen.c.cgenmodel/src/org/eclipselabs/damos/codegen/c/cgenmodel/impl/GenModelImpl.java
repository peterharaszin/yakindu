/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.codegen.c.cgenmodel.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipselabs.damos.codegen.c.cgenmodel.CGenModelPackage;
import org.eclipselabs.damos.codegen.c.cgenmodel.GenModel;
import org.eclipselabs.damos.codegen.c.cgenmodel.GenTopLevelSystem;
import org.eclipselabs.damos.execution.executionmodel.ExecutionModel;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Gen Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.codegen.c.cgenmodel.impl.GenModelImpl#getQualifiedName <em>Qualified Name</em>}</li>
 *   <li>{@link org.eclipselabs.damos.codegen.c.cgenmodel.impl.GenModelImpl#getExecutionModel <em>Execution Model</em>}</li>
 *   <li>{@link org.eclipselabs.damos.codegen.c.cgenmodel.impl.GenModelImpl#getGenTopLevelSystem <em>Gen Top Level System</em>}</li>
 *   <li>{@link org.eclipselabs.damos.codegen.c.cgenmodel.impl.GenModelImpl#getSourceDirectory <em>Source Directory</em>}</li>
 *   <li>{@link org.eclipselabs.damos.codegen.c.cgenmodel.impl.GenModelImpl#getHeaderDirectory <em>Header Directory</em>}</li>
 *   <li>{@link org.eclipselabs.damos.codegen.c.cgenmodel.impl.GenModelImpl#getMainSourceFile <em>Main Source File</em>}</li>
 *   <li>{@link org.eclipselabs.damos.codegen.c.cgenmodel.impl.GenModelImpl#getMainHeaderFile <em>Main Header File</em>}</li>
 *   <li>{@link org.eclipselabs.damos.codegen.c.cgenmodel.impl.GenModelImpl#isSingleton <em>Singleton</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class GenModelImpl extends EObjectImpl implements GenModel {
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
	 * The cached value of the '{@link #getExecutionModel() <em>Execution Model</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExecutionModel()
	 * @generated
	 * @ordered
	 */
	protected ExecutionModel executionModel;

	/**
	 * The cached value of the '{@link #getGenTopLevelSystem() <em>Gen Top Level System</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGenTopLevelSystem()
	 * @generated
	 * @ordered
	 */
	protected GenTopLevelSystem genTopLevelSystem;

	/**
	 * The default value of the '{@link #getSourceDirectory() <em>Source Directory</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceDirectory()
	 * @generated
	 * @ordered
	 */
	protected static final String SOURCE_DIRECTORY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSourceDirectory() <em>Source Directory</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceDirectory()
	 * @generated
	 * @ordered
	 */
	protected String sourceDirectory = SOURCE_DIRECTORY_EDEFAULT;

	/**
	 * The default value of the '{@link #getHeaderDirectory() <em>Header Directory</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHeaderDirectory()
	 * @generated
	 * @ordered
	 */
	protected static final String HEADER_DIRECTORY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getHeaderDirectory() <em>Header Directory</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHeaderDirectory()
	 * @generated
	 * @ordered
	 */
	protected String headerDirectory = HEADER_DIRECTORY_EDEFAULT;

	/**
	 * The default value of the '{@link #getMainSourceFile() <em>Main Source File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMainSourceFile()
	 * @generated
	 * @ordered
	 */
	protected static final String MAIN_SOURCE_FILE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMainSourceFile() <em>Main Source File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMainSourceFile()
	 * @generated
	 * @ordered
	 */
	protected String mainSourceFile = MAIN_SOURCE_FILE_EDEFAULT;

	/**
	 * The default value of the '{@link #getMainHeaderFile() <em>Main Header File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMainHeaderFile()
	 * @generated
	 * @ordered
	 */
	protected static final String MAIN_HEADER_FILE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMainHeaderFile() <em>Main Header File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMainHeaderFile()
	 * @generated
	 * @ordered
	 */
	protected String mainHeaderFile = MAIN_HEADER_FILE_EDEFAULT;

	/**
	 * The default value of the '{@link #isSingleton() <em>Singleton</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSingleton()
	 * @generated
	 * @ordered
	 */
	protected static final boolean SINGLETON_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isSingleton() <em>Singleton</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSingleton()
	 * @generated
	 * @ordered
	 */
	protected boolean singleton = SINGLETON_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GenModelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CGenModelPackage.Literals.GEN_MODEL;
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
			eNotify(new ENotificationImpl(this, Notification.SET, CGenModelPackage.GEN_MODEL__QUALIFIED_NAME, oldQualifiedName, qualifiedName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenTopLevelSystem getGenTopLevelSystem() {
		return genTopLevelSystem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetGenTopLevelSystem(GenTopLevelSystem newGenTopLevelSystem, NotificationChain msgs) {
		GenTopLevelSystem oldGenTopLevelSystem = genTopLevelSystem;
		genTopLevelSystem = newGenTopLevelSystem;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CGenModelPackage.GEN_MODEL__GEN_TOP_LEVEL_SYSTEM, oldGenTopLevelSystem, newGenTopLevelSystem);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGenTopLevelSystem(GenTopLevelSystem newGenTopLevelSystem) {
		if (newGenTopLevelSystem != genTopLevelSystem) {
			NotificationChain msgs = null;
			if (genTopLevelSystem != null)
				msgs = ((InternalEObject)genTopLevelSystem).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CGenModelPackage.GEN_MODEL__GEN_TOP_LEVEL_SYSTEM, null, msgs);
			if (newGenTopLevelSystem != null)
				msgs = ((InternalEObject)newGenTopLevelSystem).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CGenModelPackage.GEN_MODEL__GEN_TOP_LEVEL_SYSTEM, null, msgs);
			msgs = basicSetGenTopLevelSystem(newGenTopLevelSystem, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CGenModelPackage.GEN_MODEL__GEN_TOP_LEVEL_SYSTEM, newGenTopLevelSystem, newGenTopLevelSystem));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExecutionModel getExecutionModel() {
		if (executionModel != null && executionModel.eIsProxy()) {
			InternalEObject oldExecutionModel = (InternalEObject)executionModel;
			executionModel = (ExecutionModel)eResolveProxy(oldExecutionModel);
			if (executionModel != oldExecutionModel) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CGenModelPackage.GEN_MODEL__EXECUTION_MODEL, oldExecutionModel, executionModel));
			}
		}
		return executionModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExecutionModel basicGetExecutionModel() {
		return executionModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExecutionModel(ExecutionModel newExecutionModel) {
		ExecutionModel oldExecutionModel = executionModel;
		executionModel = newExecutionModel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CGenModelPackage.GEN_MODEL__EXECUTION_MODEL, oldExecutionModel, executionModel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSourceDirectory() {
		return sourceDirectory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSourceDirectory(String newSourceDirectory) {
		String oldSourceDirectory = sourceDirectory;
		sourceDirectory = newSourceDirectory;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CGenModelPackage.GEN_MODEL__SOURCE_DIRECTORY, oldSourceDirectory, sourceDirectory));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getHeaderDirectory() {
		return headerDirectory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHeaderDirectory(String newHeaderDirectory) {
		String oldHeaderDirectory = headerDirectory;
		headerDirectory = newHeaderDirectory;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CGenModelPackage.GEN_MODEL__HEADER_DIRECTORY, oldHeaderDirectory, headerDirectory));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMainSourceFile() {
		return mainSourceFile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMainSourceFile(String newMainSourceFile) {
		String oldMainSourceFile = mainSourceFile;
		mainSourceFile = newMainSourceFile;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CGenModelPackage.GEN_MODEL__MAIN_SOURCE_FILE, oldMainSourceFile, mainSourceFile));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMainHeaderFile() {
		return mainHeaderFile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMainHeaderFile(String newMainHeaderFile) {
		String oldMainHeaderFile = mainHeaderFile;
		mainHeaderFile = newMainHeaderFile;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CGenModelPackage.GEN_MODEL__MAIN_HEADER_FILE, oldMainHeaderFile, mainHeaderFile));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSingleton() {
		return singleton;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSingleton(boolean newSingleton) {
		boolean oldSingleton = singleton;
		singleton = newSingleton;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CGenModelPackage.GEN_MODEL__SINGLETON, oldSingleton, singleton));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CGenModelPackage.GEN_MODEL__GEN_TOP_LEVEL_SYSTEM:
				return basicSetGenTopLevelSystem(null, msgs);
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
			case CGenModelPackage.GEN_MODEL__QUALIFIED_NAME:
				return getQualifiedName();
			case CGenModelPackage.GEN_MODEL__EXECUTION_MODEL:
				if (resolve) return getExecutionModel();
				return basicGetExecutionModel();
			case CGenModelPackage.GEN_MODEL__GEN_TOP_LEVEL_SYSTEM:
				return getGenTopLevelSystem();
			case CGenModelPackage.GEN_MODEL__SOURCE_DIRECTORY:
				return getSourceDirectory();
			case CGenModelPackage.GEN_MODEL__HEADER_DIRECTORY:
				return getHeaderDirectory();
			case CGenModelPackage.GEN_MODEL__MAIN_SOURCE_FILE:
				return getMainSourceFile();
			case CGenModelPackage.GEN_MODEL__MAIN_HEADER_FILE:
				return getMainHeaderFile();
			case CGenModelPackage.GEN_MODEL__SINGLETON:
				return isSingleton();
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
			case CGenModelPackage.GEN_MODEL__QUALIFIED_NAME:
				setQualifiedName((String)newValue);
				return;
			case CGenModelPackage.GEN_MODEL__EXECUTION_MODEL:
				setExecutionModel((ExecutionModel)newValue);
				return;
			case CGenModelPackage.GEN_MODEL__GEN_TOP_LEVEL_SYSTEM:
				setGenTopLevelSystem((GenTopLevelSystem)newValue);
				return;
			case CGenModelPackage.GEN_MODEL__SOURCE_DIRECTORY:
				setSourceDirectory((String)newValue);
				return;
			case CGenModelPackage.GEN_MODEL__HEADER_DIRECTORY:
				setHeaderDirectory((String)newValue);
				return;
			case CGenModelPackage.GEN_MODEL__MAIN_SOURCE_FILE:
				setMainSourceFile((String)newValue);
				return;
			case CGenModelPackage.GEN_MODEL__MAIN_HEADER_FILE:
				setMainHeaderFile((String)newValue);
				return;
			case CGenModelPackage.GEN_MODEL__SINGLETON:
				setSingleton((Boolean)newValue);
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
			case CGenModelPackage.GEN_MODEL__QUALIFIED_NAME:
				setQualifiedName(QUALIFIED_NAME_EDEFAULT);
				return;
			case CGenModelPackage.GEN_MODEL__EXECUTION_MODEL:
				setExecutionModel((ExecutionModel)null);
				return;
			case CGenModelPackage.GEN_MODEL__GEN_TOP_LEVEL_SYSTEM:
				setGenTopLevelSystem((GenTopLevelSystem)null);
				return;
			case CGenModelPackage.GEN_MODEL__SOURCE_DIRECTORY:
				setSourceDirectory(SOURCE_DIRECTORY_EDEFAULT);
				return;
			case CGenModelPackage.GEN_MODEL__HEADER_DIRECTORY:
				setHeaderDirectory(HEADER_DIRECTORY_EDEFAULT);
				return;
			case CGenModelPackage.GEN_MODEL__MAIN_SOURCE_FILE:
				setMainSourceFile(MAIN_SOURCE_FILE_EDEFAULT);
				return;
			case CGenModelPackage.GEN_MODEL__MAIN_HEADER_FILE:
				setMainHeaderFile(MAIN_HEADER_FILE_EDEFAULT);
				return;
			case CGenModelPackage.GEN_MODEL__SINGLETON:
				setSingleton(SINGLETON_EDEFAULT);
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
			case CGenModelPackage.GEN_MODEL__QUALIFIED_NAME:
				return QUALIFIED_NAME_EDEFAULT == null ? qualifiedName != null : !QUALIFIED_NAME_EDEFAULT.equals(qualifiedName);
			case CGenModelPackage.GEN_MODEL__EXECUTION_MODEL:
				return executionModel != null;
			case CGenModelPackage.GEN_MODEL__GEN_TOP_LEVEL_SYSTEM:
				return genTopLevelSystem != null;
			case CGenModelPackage.GEN_MODEL__SOURCE_DIRECTORY:
				return SOURCE_DIRECTORY_EDEFAULT == null ? sourceDirectory != null : !SOURCE_DIRECTORY_EDEFAULT.equals(sourceDirectory);
			case CGenModelPackage.GEN_MODEL__HEADER_DIRECTORY:
				return HEADER_DIRECTORY_EDEFAULT == null ? headerDirectory != null : !HEADER_DIRECTORY_EDEFAULT.equals(headerDirectory);
			case CGenModelPackage.GEN_MODEL__MAIN_SOURCE_FILE:
				return MAIN_SOURCE_FILE_EDEFAULT == null ? mainSourceFile != null : !MAIN_SOURCE_FILE_EDEFAULT.equals(mainSourceFile);
			case CGenModelPackage.GEN_MODEL__MAIN_HEADER_FILE:
				return MAIN_HEADER_FILE_EDEFAULT == null ? mainHeaderFile != null : !MAIN_HEADER_FILE_EDEFAULT.equals(mainHeaderFile);
			case CGenModelPackage.GEN_MODEL__SINGLETON:
				return singleton != SINGLETON_EDEFAULT;
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
		result.append(", sourceDirectory: ");
		result.append(sourceDirectory);
		result.append(", headerDirectory: ");
		result.append(headerDirectory);
		result.append(", mainSourceFile: ");
		result.append(mainSourceFile);
		result.append(", mainHeaderFile: ");
		result.append(mainHeaderFile);
		result.append(", singleton: ");
		result.append(singleton);
		result.append(')');
		return result.toString();
	}

} //GenModelImpl
