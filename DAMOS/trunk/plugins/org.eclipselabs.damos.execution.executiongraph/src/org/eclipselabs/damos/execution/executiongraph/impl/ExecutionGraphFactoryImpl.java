/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.execution.executiongraph.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipselabs.damos.execution.executiongraph.DataFlow;
import org.eclipselabs.damos.execution.executiongraph.DataFlowSourceEnd;
import org.eclipselabs.damos.execution.executiongraph.DataFlowTargetEnd;
import org.eclipselabs.damos.execution.executiongraph.ExecutionGraph;
import org.eclipselabs.damos.execution.executiongraph.ExecutionGraphFactory;
import org.eclipselabs.damos.execution.executiongraph.ExecutionGraphPackage;
import org.eclipselabs.damos.execution.executiongraph.Link;
import org.eclipselabs.damos.execution.executiongraph.Node;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ExecutionGraphFactoryImpl extends EFactoryImpl implements ExecutionGraphFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ExecutionGraphFactory init() {
		try {
			ExecutionGraphFactory theExecutionGraphFactory = (ExecutionGraphFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipselabs.org/damos/ExecutionGraph/1.0.0"); 
			if (theExecutionGraphFactory != null) {
				return theExecutionGraphFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ExecutionGraphFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExecutionGraphFactoryImpl() {
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
			case ExecutionGraphPackage.EXECUTION_GRAPH: return createExecutionGraph();
			case ExecutionGraphPackage.NODE: return createNode();
			case ExecutionGraphPackage.LINK: return createLink();
			case ExecutionGraphPackage.DATA_FLOW_SOURCE_END: return createDataFlowSourceEnd();
			case ExecutionGraphPackage.DATA_FLOW: return createDataFlow();
			case ExecutionGraphPackage.DATA_FLOW_TARGET_END: return createDataFlowTargetEnd();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExecutionGraph createExecutionGraph() {
		ExecutionGraphImpl executionGraph = new ExecutionGraphImpl();
		return executionGraph;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Node createNode() {
		NodeImpl node = new NodeImpl();
		return node;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Link createLink() {
		LinkImpl link = new LinkImpl();
		return link;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataFlowSourceEnd createDataFlowSourceEnd() {
		DataFlowSourceEndImpl dataFlowSourceEnd = new DataFlowSourceEndImpl();
		return dataFlowSourceEnd;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataFlow createDataFlow() {
		DataFlowImpl dataFlow = new DataFlowImpl();
		return dataFlow;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataFlowTargetEnd createDataFlowTargetEnd() {
		DataFlowTargetEndImpl dataFlowTargetEnd = new DataFlowTargetEndImpl();
		return dataFlowTargetEnd;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExecutionGraphPackage getExecutionGraphPackage() {
		return (ExecutionGraphPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ExecutionGraphPackage getPackage() {
		return ExecutionGraphPackage.eINSTANCE;
	}

} //ExecutionGraphFactoryImpl
