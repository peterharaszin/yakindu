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
import org.eclipselabs.damos.mscript.il.Assignment;
import org.eclipselabs.damos.mscript.il.Compound;
import org.eclipselabs.damos.mscript.il.CompoundStatement;
import org.eclipselabs.damos.mscript.il.ComputationCompound;
import org.eclipselabs.damos.mscript.il.ILFactory;
import org.eclipselabs.damos.mscript.il.ILFunctionDefinition;
import org.eclipselabs.damos.mscript.il.ILPackage;
import org.eclipselabs.damos.mscript.il.InputVariableDeclaration;
import org.eclipselabs.damos.mscript.il.InstanceVariableDeclaration;
import org.eclipselabs.damos.mscript.il.InvalidExpression;
import org.eclipselabs.damos.mscript.il.OutputVariableDeclaration;
import org.eclipselabs.damos.mscript.il.TemplateVariableDeclaration;
import org.eclipselabs.damos.mscript.il.VariableReference;

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
			case ILPackage.COMPOUND: return createCompound();
			case ILPackage.COMPUTATION_COMPOUND: return createComputationCompound();
			case ILPackage.TEMPLATE_VARIABLE_DECLARATION: return createTemplateVariableDeclaration();
			case ILPackage.INPUT_VARIABLE_DECLARATION: return createInputVariableDeclaration();
			case ILPackage.OUTPUT_VARIABLE_DECLARATION: return createOutputVariableDeclaration();
			case ILPackage.INSTANCE_VARIABLE_DECLARATION: return createInstanceVariableDeclaration();
			case ILPackage.COMPOUND_STATEMENT: return createCompoundStatement();
			case ILPackage.ASSIGNMENT: return createAssignment();
			case ILPackage.VARIABLE_REFERENCE: return createVariableReference();
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
	public Compound createCompound() {
		CompoundImpl compound = new CompoundImpl();
		return compound;
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
	public TemplateVariableDeclaration createTemplateVariableDeclaration() {
		TemplateVariableDeclarationImpl templateVariableDeclaration = new TemplateVariableDeclarationImpl();
		return templateVariableDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InputVariableDeclaration createInputVariableDeclaration() {
		InputVariableDeclarationImpl inputVariableDeclaration = new InputVariableDeclarationImpl();
		return inputVariableDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OutputVariableDeclaration createOutputVariableDeclaration() {
		OutputVariableDeclarationImpl outputVariableDeclaration = new OutputVariableDeclarationImpl();
		return outputVariableDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InstanceVariableDeclaration createInstanceVariableDeclaration() {
		InstanceVariableDeclarationImpl instanceVariableDeclaration = new InstanceVariableDeclarationImpl();
		return instanceVariableDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompoundStatement createCompoundStatement() {
		CompoundStatementImpl compoundStatement = new CompoundStatementImpl();
		return compoundStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Assignment createAssignment() {
		AssignmentImpl assignment = new AssignmentImpl();
		return assignment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariableReference createVariableReference() {
		VariableReferenceImpl variableReference = new VariableReferenceImpl();
		return variableReference;
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
