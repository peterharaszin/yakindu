/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.mscript.il.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipselabs.damos.mscript.il.ComputationCompound;
import org.eclipselabs.damos.mscript.il.ILFactory;
import org.eclipselabs.damos.mscript.il.ILFunctionDefinition;
import org.eclipselabs.damos.mscript.il.ILPackage;
import org.eclipselabs.damos.mscript.il.InvalidExpression;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ILFactoryImpl extends EFactoryImpl implements ILFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ILFactory init() {
		try {
			ILFactory theILFactory = (ILFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipselabs.org/damos/mscript/2011/IL"); 
			if (theILFactory != null) {
				return theILFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ILFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ILFactoryImpl() {
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
			case ILPackage.IL_FUNCTION_DEFINITION: return createILFunctionDefinition();
			case ILPackage.COMPUTATION_COMPOUND: return createComputationCompound();
			case ILPackage.INVALID_EXPRESSION: return createInvalidExpression();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ILFunctionDefinition createILFunctionDefinition() {
		ILFunctionDefinitionImpl ilFunctionDefinition = new ILFunctionDefinitionImpl();
		return ilFunctionDefinition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComputationCompound createComputationCompound() {
		ComputationCompoundImpl computationCompound = new ComputationCompoundImpl();
		return computationCompound;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InvalidExpression createInvalidExpression() {
		InvalidExpressionImpl invalidExpression = new InvalidExpressionImpl();
		return invalidExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ILPackage getILPackage() {
		return (ILPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ILPackage getPackage() {
		return ILPackage.eINSTANCE;
	}

} //ILFactoryImpl
