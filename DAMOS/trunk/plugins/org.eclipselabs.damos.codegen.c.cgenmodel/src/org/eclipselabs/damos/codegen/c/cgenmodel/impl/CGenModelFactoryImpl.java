/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.codegen.c.cgenmodel.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipselabs.damos.codegen.c.cgenmodel.CGenModelFactory;
import org.eclipselabs.damos.codegen.c.cgenmodel.CGenModelPackage;
import org.eclipselabs.damos.codegen.c.cgenmodel.GenModel;
import org.eclipselabs.damos.codegen.c.cgenmodel.GenSubsystem;
import org.eclipselabs.damos.codegen.c.cgenmodel.GenTopLevelSystem;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CGenModelFactoryImpl extends EFactoryImpl implements CGenModelFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static CGenModelFactory init() {
		try {
			CGenModelFactory theCGenModelFactory = (CGenModelFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipselabs.org/damos/CGenModel/1.0.0"); 
			if (theCGenModelFactory != null) {
				return theCGenModelFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new CGenModelFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CGenModelFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case CGenModelPackage.GEN_MODEL: return createGenModel();
			case CGenModelPackage.GEN_TOP_LEVEL_SYSTEM: return createGenTopLevelSystem();
			case CGenModelPackage.GEN_SUBSYSTEM: return createGenSubsystem();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenModel createGenModel() {
		GenModelImpl genModel = new GenModelImpl();
		return genModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenTopLevelSystem createGenTopLevelSystem() {
		GenTopLevelSystemImpl genTopLevelSystem = new GenTopLevelSystemImpl();
		return genTopLevelSystem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenSubsystem createGenSubsystem() {
		GenSubsystemImpl genSubsystem = new GenSubsystemImpl();
		return genSubsystem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CGenModelPackage getCGenModelPackage() {
		return (CGenModelPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static CGenModelPackage getPackage() {
		return CGenModelPackage.eINSTANCE;
	}

} //CGenModelFactoryImpl
