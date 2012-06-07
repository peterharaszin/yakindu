/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.execution.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipselabs.damos.dml.util.SystemPath;
import org.eclipselabs.damos.execution.ActionNode;
import org.eclipselabs.damos.execution.ComponentNode;
import org.eclipselabs.damos.execution.CompoundNode;
import org.eclipselabs.damos.execution.DataFlow;
import org.eclipselabs.damos.execution.DataFlowSourceEnd;
import org.eclipselabs.damos.execution.DataFlowTargetEnd;
import org.eclipselabs.damos.execution.Edge;
import org.eclipselabs.damos.execution.ExecutionFactory;
import org.eclipselabs.damos.execution.ExecutionFlow;
import org.eclipselabs.damos.execution.ExecutionPackage;
import org.eclipselabs.damos.execution.Graph;
import org.eclipselabs.damos.execution.LatchNode;
import org.eclipselabs.damos.execution.PortInfo;
import org.eclipselabs.damos.execution.SubsystemNode;
import org.eclipselabs.damos.execution.TaskGraph;
import org.eclipselabs.damos.execution.TaskInputNode;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ExecutionFactoryImpl extends EFactoryImpl implements ExecutionFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ExecutionFactory init() {
		try {
			ExecutionFactory theExecutionFactory = (ExecutionFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipselabs.org/damos/2011/Execution"); 
			if (theExecutionFactory != null) {
				return theExecutionFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ExecutionFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExecutionFactoryImpl() {
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
			case ExecutionPackage.EXECUTION_FLOW: return createExecutionFlow();
			case ExecutionPackage.GRAPH: return createGraph();
			case ExecutionPackage.COMPONENT_NODE: return createComponentNode();
			case ExecutionPackage.LATCH_NODE: return createLatchNode();
			case ExecutionPackage.COMPOUND_NODE: return createCompoundNode();
			case ExecutionPackage.ACTION_NODE: return createActionNode();
			case ExecutionPackage.SUBSYSTEM_NODE: return createSubsystemNode();
			case ExecutionPackage.TASK_GRAPH: return createTaskGraph();
			case ExecutionPackage.TASK_INPUT_NODE: return createTaskInputNode();
			case ExecutionPackage.EDGE: return createEdge();
			case ExecutionPackage.DATA_FLOW: return createDataFlow();
			case ExecutionPackage.DATA_FLOW_SOURCE_END: return createDataFlowSourceEnd();
			case ExecutionPackage.DATA_FLOW_TARGET_END: return createDataFlowTargetEnd();
			case ExecutionPackage.PORT_INFO: return createPortInfo();
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
			case ExecutionPackage.SYSTEM_PATH:
				return createSystemPathFromString(eDataType, initialValue);
			case ExecutionPackage.ITERABLE:
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
			case ExecutionPackage.SYSTEM_PATH:
				return convertSystemPathToString(eDataType, instanceValue);
			case ExecutionPackage.ITERABLE:
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
	public ExecutionPackage getExecutionPackage() {
		return (ExecutionPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ExecutionPackage getPackage() {
		return ExecutionPackage.eINSTANCE;
	}

} //ExecutionFactoryImpl
