/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.execution.executionflow.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipselabs.damos.dml.util.SystemPath;
import org.eclipselabs.damos.execution.executionflow.ActionNode;
import org.eclipselabs.damos.execution.executionflow.ComponentNode;
import org.eclipselabs.damos.execution.executionflow.CompoundNode;
import org.eclipselabs.damos.execution.executionflow.DataFlow;
import org.eclipselabs.damos.execution.executionflow.DataFlowSourceEnd;
import org.eclipselabs.damos.execution.executionflow.DataFlowTargetEnd;
import org.eclipselabs.damos.execution.executionflow.Edge;
import org.eclipselabs.damos.execution.executionflow.ExecutionFlow;
import org.eclipselabs.damos.execution.executionflow.ExecutionFlowFactory;
import org.eclipselabs.damos.execution.executionflow.ExecutionFlowPackage;
import org.eclipselabs.damos.execution.executionflow.Graph;
import org.eclipselabs.damos.execution.executionflow.LatchNode;
import org.eclipselabs.damos.execution.executionflow.PortInfo;
import org.eclipselabs.damos.execution.executionflow.SubsystemNode;
import org.eclipselabs.damos.execution.executionflow.TaskGraph;
import org.eclipselabs.damos.execution.executionflow.TaskInputNode;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ExecutionFlowFactoryImpl extends EFactoryImpl implements ExecutionFlowFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ExecutionFlowFactory init() {
		try {
			ExecutionFlowFactory theExecutionFlowFactory = (ExecutionFlowFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipselabs.org/damos/2011/ExecutionFlow"); 
			if (theExecutionFlowFactory != null) {
				return theExecutionFlowFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ExecutionFlowFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExecutionFlowFactoryImpl() {
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
			case ExecutionFlowPackage.EXECUTION_FLOW: return createExecutionFlow();
			case ExecutionFlowPackage.GRAPH: return createGraph();
			case ExecutionFlowPackage.COMPONENT_NODE: return createComponentNode();
			case ExecutionFlowPackage.LATCH_NODE: return createLatchNode();
			case ExecutionFlowPackage.COMPOUND_NODE: return createCompoundNode();
			case ExecutionFlowPackage.ACTION_NODE: return createActionNode();
			case ExecutionFlowPackage.SUBSYSTEM_NODE: return createSubsystemNode();
			case ExecutionFlowPackage.TASK_GRAPH: return createTaskGraph();
			case ExecutionFlowPackage.TASK_INPUT_NODE: return createTaskInputNode();
			case ExecutionFlowPackage.EDGE: return createEdge();
			case ExecutionFlowPackage.DATA_FLOW: return createDataFlow();
			case ExecutionFlowPackage.DATA_FLOW_SOURCE_END: return createDataFlowSourceEnd();
			case ExecutionFlowPackage.DATA_FLOW_TARGET_END: return createDataFlowTargetEnd();
			case ExecutionFlowPackage.PORT_INFO: return createPortInfo();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case ExecutionFlowPackage.SYSTEM_PATH:
				return createSystemPathFromString(eDataType, initialValue);
			case ExecutionFlowPackage.ITERABLE:
				return createIterableFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case ExecutionFlowPackage.SYSTEM_PATH:
				return convertSystemPathToString(eDataType, instanceValue);
			case ExecutionFlowPackage.ITERABLE:
				return convertIterableToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExecutionFlow createExecutionFlow() {
		ExecutionFlowImpl executionFlow = new ExecutionFlowImpl();
		return executionFlow;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Graph createGraph() {
		GraphImpl graph = new GraphImpl();
		return graph;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComponentNode createComponentNode() {
		ComponentNodeImpl componentNode = new ComponentNodeImpl();
		return componentNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LatchNode createLatchNode() {
		LatchNodeImpl latchNode = new LatchNodeImpl();
		return latchNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompoundNode createCompoundNode() {
		CompoundNodeImpl compoundNode = new CompoundNodeImpl();
		return compoundNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActionNode createActionNode() {
		ActionNodeImpl actionNode = new ActionNodeImpl();
		return actionNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SubsystemNode createSubsystemNode() {
		SubsystemNodeImpl subsystemNode = new SubsystemNodeImpl();
		return subsystemNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TaskGraph createTaskGraph() {
		TaskGraphImpl taskGraph = new TaskGraphImpl();
		return taskGraph;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TaskInputNode createTaskInputNode() {
		TaskInputNodeImpl taskInputNode = new TaskInputNodeImpl();
		return taskInputNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Edge createEdge() {
		EdgeImpl edge = new EdgeImpl();
		return edge;
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
	public DataFlowSourceEnd createDataFlowSourceEnd() {
		DataFlowSourceEndImpl dataFlowSourceEnd = new DataFlowSourceEndImpl();
		return dataFlowSourceEnd;
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
	public PortInfo createPortInfo() {
		PortInfoImpl portInfo = new PortInfoImpl();
		return portInfo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SystemPath createSystemPathFromString(EDataType eDataType, String initialValue) {
		return (SystemPath)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertSystemPathToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Iterable<?> createIterableFromString(EDataType eDataType, String initialValue) {
		return (Iterable<?>)super.createFromString(initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIterableToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExecutionFlowPackage getExecutionFlowPackage() {
		return (ExecutionFlowPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ExecutionFlowPackage getPackage() {
		return ExecutionFlowPackage.eINSTANCE;
	}

} //ExecutionFlowFactoryImpl
