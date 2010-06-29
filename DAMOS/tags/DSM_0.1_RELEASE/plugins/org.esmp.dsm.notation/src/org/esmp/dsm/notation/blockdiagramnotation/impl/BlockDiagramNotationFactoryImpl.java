/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.esmp.dsm.notation.blockdiagramnotation.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.esmp.dsm.notation.blockdiagramnotation.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class BlockDiagramNotationFactoryImpl extends EFactoryImpl implements BlockDiagramNotationFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static BlockDiagramNotationFactory init() {
		try {
			BlockDiagramNotationFactory theBlockDiagramNotationFactory = (BlockDiagramNotationFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.esmp.org/dsm/BlockDiagramNotation/1.0.0"); 
			if (theBlockDiagramNotationFactory != null) {
				return theBlockDiagramNotationFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new BlockDiagramNotationFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BlockDiagramNotationFactoryImpl() {
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
			case BlockDiagramNotationPackage.BLOCK_LAYOUT_CONSTRAINT: return createBlockLayoutConstraint();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BlockLayoutConstraint createBlockLayoutConstraint() {
		BlockLayoutConstraintImpl blockLayoutConstraint = new BlockLayoutConstraintImpl();
		return blockLayoutConstraint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BlockDiagramNotationPackage getBlockDiagramNotationPackage() {
		return (BlockDiagramNotationPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static BlockDiagramNotationPackage getPackage() {
		return BlockDiagramNotationPackage.eINSTANCE;
	}

} //BlockDiagramNotationFactoryImpl
