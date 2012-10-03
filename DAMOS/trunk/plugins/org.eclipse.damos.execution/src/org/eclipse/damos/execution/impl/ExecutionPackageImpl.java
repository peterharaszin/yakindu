/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.damos.execution.impl;

import org.eclipse.damos.dml.DMLPackage;
import org.eclipse.damos.dml.util.SystemPath;
import org.eclipse.damos.execution.ActionNode;
import org.eclipse.damos.execution.ComponentNode;
import org.eclipse.damos.execution.CompoundNode;
import org.eclipse.damos.execution.ConnectorInfo;
import org.eclipse.damos.execution.DataFlow;
import org.eclipse.damos.execution.DataFlowEnd;
import org.eclipse.damos.execution.DataFlowSourceEnd;
import org.eclipse.damos.execution.DataFlowTargetEnd;
import org.eclipse.damos.execution.Edge;
import org.eclipse.damos.execution.ExecutionFactory;
import org.eclipse.damos.execution.ExecutionFlow;
import org.eclipse.damos.execution.ExecutionPackage;
import org.eclipse.damos.execution.Graph;
import org.eclipse.damos.execution.LatchNode;
import org.eclipse.damos.execution.Node;
import org.eclipse.damos.execution.PortInfo;
import org.eclipse.damos.execution.Subgraph;
import org.eclipse.damos.execution.SubsystemNode;
import org.eclipse.damos.execution.TaskGraph;
import org.eclipse.damos.execution.TaskInputNode;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ExecutionPackageImpl extends EPackageImpl implements ExecutionPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass executionFlowEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass graphEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass subgraphEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass componentNodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass latchNodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass compoundNodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass actionNodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass subsystemNodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass taskGraphEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass taskInputNodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass edgeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataFlowEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataFlowEndEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataFlowSourceEndEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataFlowTargetEndEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass connectorInfoEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass portInfoEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType systemPathEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType iterableEDataType = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.eclipse.damos.execution.ExecutionPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ExecutionPackageImpl() {
		super(eNS_URI, ExecutionFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link ExecutionPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ExecutionPackage init() {
		if (isInited) return (ExecutionPackage)EPackage.Registry.INSTANCE.getEPackage(ExecutionPackage.eNS_URI);

		// Obtain or create and register package
		ExecutionPackageImpl theExecutionPackage = (ExecutionPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ExecutionPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ExecutionPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		DMLPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theExecutionPackage.createPackageContents();

		// Initialize created meta-data
		theExecutionPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theExecutionPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ExecutionPackage.eNS_URI, theExecutionPackage);
		return theExecutionPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExecutionFlow() {
		return executionFlowEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExecutionFlow_TopLevelFragment() {
		return (EReference)executionFlowEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExecutionFlow_Graph() {
		return (EReference)executionFlowEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExecutionFlow_DataFlows() {
		return (EReference)executionFlowEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExecutionFlow_AsynchronousZoneCount() {
		return (EAttribute)executionFlowEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExecutionFlow_TaskGraphs() {
		return (EReference)executionFlowEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExecutionFlow_FundamentalSampleTime() {
		return (EAttribute)executionFlowEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGraph() {
		return graphEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGraph_Nodes() {
		return (EReference)graphEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGraph_InitialNodes() {
		return (EReference)graphEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGraph_Edges() {
		return (EReference)graphEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNode() {
		return nodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNode_Graph() {
		return (EReference)nodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNode_IncomingEdges() {
		return (EReference)nodeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNode_OutgoingEdges() {
		return (EReference)nodeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNode_IncomingDataFlows() {
		return (EReference)nodeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNode_OutgoingDataFlows() {
		return (EReference)nodeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNode_SystemPath() {
		return (EAttribute)nodeEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSubgraph() {
		return subgraphEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getComponentNode() {
		return componentNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComponentNode_Component() {
		return (EReference)componentNodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getComponentNode_SampleTime() {
		return (EAttribute)componentNodeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getComponentNode_AsynchronousZone() {
		return (EAttribute)componentNodeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLatchNode() {
		return latchNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLatchNode_TaskNodes() {
		return (EReference)latchNodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCompoundNode() {
		return compoundNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCompoundNode_Compound() {
		return (EReference)compoundNodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getActionNode() {
		return actionNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getActionNode_ChoiceNode() {
		return (EReference)actionNodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSubsystemNode() {
		return subsystemNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSubsystemNode_Subsystem() {
		return (EReference)subsystemNodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTaskGraph() {
		return taskGraphEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTaskGraph_InputNodes() {
		return (EReference)taskGraphEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTaskGraph_LatchNodes() {
		return (EReference)taskGraphEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTaskInputNode() {
		return taskInputNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTaskInputNode_TaskGraph() {
		return (EReference)taskInputNodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEdge() {
		return edgeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEdge_Graph() {
		return (EReference)edgeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEdge_Source() {
		return (EReference)edgeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEdge_Target() {
		return (EReference)edgeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDataFlow() {
		return dataFlowEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDataFlow_TargetEnds() {
		return (EReference)dataFlowEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDataFlow_SourceEnd() {
		return (EReference)dataFlowEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDataFlowEnd() {
		return dataFlowEndEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDataFlowEnd_ConnectorInfo() {
		return (EReference)dataFlowEndEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDataFlowSourceEnd() {
		return dataFlowSourceEndEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDataFlowSourceEnd_Node() {
		return (EReference)dataFlowSourceEndEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDataFlowSourceEnd_DataFlow() {
		return (EReference)dataFlowSourceEndEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDataFlowSourceEnd_Connector() {
		return (EReference)dataFlowSourceEndEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDataFlowTargetEnd() {
		return dataFlowTargetEndEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDataFlowTargetEnd_Node() {
		return (EReference)dataFlowTargetEndEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDataFlowTargetEnd_DataFlow() {
		return (EReference)dataFlowTargetEndEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDataFlowTargetEnd_Connector() {
		return (EReference)dataFlowTargetEndEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConnectorInfo() {
		return connectorInfoEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPortInfo() {
		return portInfoEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPortInfo_InoutputIndex() {
		return (EAttribute)portInfoEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPortInfo_PortIndex() {
		return (EAttribute)portInfoEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getSystemPath() {
		return systemPathEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getIterable() {
		return iterableEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExecutionFactory getExecutionFactory() {
		return (ExecutionFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		executionFlowEClass = createEClass(EXECUTION_FLOW);
		createEReference(executionFlowEClass, EXECUTION_FLOW__TOP_LEVEL_FRAGMENT);
		createEReference(executionFlowEClass, EXECUTION_FLOW__GRAPH);
		createEReference(executionFlowEClass, EXECUTION_FLOW__DATA_FLOWS);
		createEAttribute(executionFlowEClass, EXECUTION_FLOW__ASYNCHRONOUS_ZONE_COUNT);
		createEReference(executionFlowEClass, EXECUTION_FLOW__TASK_GRAPHS);
		createEAttribute(executionFlowEClass, EXECUTION_FLOW__FUNDAMENTAL_SAMPLE_TIME);

		graphEClass = createEClass(GRAPH);
		createEReference(graphEClass, GRAPH__NODES);
		createEReference(graphEClass, GRAPH__INITIAL_NODES);
		createEReference(graphEClass, GRAPH__EDGES);

		nodeEClass = createEClass(NODE);
		createEReference(nodeEClass, NODE__GRAPH);
		createEReference(nodeEClass, NODE__INCOMING_EDGES);
		createEReference(nodeEClass, NODE__OUTGOING_EDGES);
		createEReference(nodeEClass, NODE__INCOMING_DATA_FLOWS);
		createEReference(nodeEClass, NODE__OUTGOING_DATA_FLOWS);
		createEAttribute(nodeEClass, NODE__SYSTEM_PATH);

		subgraphEClass = createEClass(SUBGRAPH);

		componentNodeEClass = createEClass(COMPONENT_NODE);
		createEReference(componentNodeEClass, COMPONENT_NODE__COMPONENT);
		createEAttribute(componentNodeEClass, COMPONENT_NODE__SAMPLE_TIME);
		createEAttribute(componentNodeEClass, COMPONENT_NODE__ASYNCHRONOUS_ZONE);

		latchNodeEClass = createEClass(LATCH_NODE);
		createEReference(latchNodeEClass, LATCH_NODE__TASK_NODES);

		compoundNodeEClass = createEClass(COMPOUND_NODE);
		createEReference(compoundNodeEClass, COMPOUND_NODE__COMPOUND);

		actionNodeEClass = createEClass(ACTION_NODE);
		createEReference(actionNodeEClass, ACTION_NODE__CHOICE_NODE);

		subsystemNodeEClass = createEClass(SUBSYSTEM_NODE);
		createEReference(subsystemNodeEClass, SUBSYSTEM_NODE__SUBSYSTEM);

		taskGraphEClass = createEClass(TASK_GRAPH);
		createEReference(taskGraphEClass, TASK_GRAPH__INPUT_NODES);
		createEReference(taskGraphEClass, TASK_GRAPH__LATCH_NODES);

		taskInputNodeEClass = createEClass(TASK_INPUT_NODE);
		createEReference(taskInputNodeEClass, TASK_INPUT_NODE__TASK_GRAPH);

		edgeEClass = createEClass(EDGE);
		createEReference(edgeEClass, EDGE__GRAPH);
		createEReference(edgeEClass, EDGE__SOURCE);
		createEReference(edgeEClass, EDGE__TARGET);

		dataFlowEClass = createEClass(DATA_FLOW);
		createEReference(dataFlowEClass, DATA_FLOW__TARGET_ENDS);
		createEReference(dataFlowEClass, DATA_FLOW__SOURCE_END);

		dataFlowEndEClass = createEClass(DATA_FLOW_END);
		createEReference(dataFlowEndEClass, DATA_FLOW_END__CONNECTOR_INFO);

		dataFlowSourceEndEClass = createEClass(DATA_FLOW_SOURCE_END);
		createEReference(dataFlowSourceEndEClass, DATA_FLOW_SOURCE_END__NODE);
		createEReference(dataFlowSourceEndEClass, DATA_FLOW_SOURCE_END__DATA_FLOW);
		createEReference(dataFlowSourceEndEClass, DATA_FLOW_SOURCE_END__CONNECTOR);

		dataFlowTargetEndEClass = createEClass(DATA_FLOW_TARGET_END);
		createEReference(dataFlowTargetEndEClass, DATA_FLOW_TARGET_END__NODE);
		createEReference(dataFlowTargetEndEClass, DATA_FLOW_TARGET_END__DATA_FLOW);
		createEReference(dataFlowTargetEndEClass, DATA_FLOW_TARGET_END__CONNECTOR);

		connectorInfoEClass = createEClass(CONNECTOR_INFO);

		portInfoEClass = createEClass(PORT_INFO);
		createEAttribute(portInfoEClass, PORT_INFO__INOUTPUT_INDEX);
		createEAttribute(portInfoEClass, PORT_INFO__PORT_INDEX);

		// Create data types
		systemPathEDataType = createEDataType(SYSTEM_PATH);
		iterableEDataType = createEDataType(ITERABLE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		DMLPackage theDMLPackage = (DMLPackage)EPackage.Registry.INSTANCE.getEPackage(DMLPackage.eNS_URI);

		// Create type parameters
		addETypeParameter(iterableEDataType, "E");

		// Set bounds for type parameters

		// Add supertypes to classes
		subgraphEClass.getESuperTypes().add(this.getGraph());
		subgraphEClass.getESuperTypes().add(this.getNode());
		componentNodeEClass.getESuperTypes().add(this.getNode());
		latchNodeEClass.getESuperTypes().add(this.getComponentNode());
		compoundNodeEClass.getESuperTypes().add(this.getSubgraph());
		actionNodeEClass.getESuperTypes().add(this.getCompoundNode());
		subsystemNodeEClass.getESuperTypes().add(this.getSubgraph());
		taskGraphEClass.getESuperTypes().add(this.getGraph());
		taskInputNodeEClass.getESuperTypes().add(this.getNode());
		dataFlowSourceEndEClass.getESuperTypes().add(this.getDataFlowEnd());
		dataFlowTargetEndEClass.getESuperTypes().add(this.getDataFlowEnd());
		portInfoEClass.getESuperTypes().add(this.getConnectorInfo());

		// Initialize classes and features; add operations and parameters
		initEClass(executionFlowEClass, ExecutionFlow.class, "ExecutionFlow", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getExecutionFlow_TopLevelFragment(), theDMLPackage.getFragment(), null, "topLevelFragment", null, 1, 1, ExecutionFlow.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getExecutionFlow_Graph(), this.getGraph(), null, "graph", null, 1, 1, ExecutionFlow.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getExecutionFlow_DataFlows(), this.getDataFlow(), null, "dataFlows", null, 0, -1, ExecutionFlow.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getExecutionFlow_AsynchronousZoneCount(), ecorePackage.getEInt(), "asynchronousZoneCount", null, 1, 1, ExecutionFlow.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getExecutionFlow_TaskGraphs(), this.getTaskGraph(), null, "taskGraphs", null, 0, -1, ExecutionFlow.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getExecutionFlow_FundamentalSampleTime(), ecorePackage.getEDouble(), "fundamentalSampleTime", null, 0, 1, ExecutionFlow.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		EOperation op = addEOperation(executionFlowEClass, null, "getAllNodesIterator", 1, 1, IS_UNIQUE, IS_ORDERED);
		EGenericType g1 = createEGenericType(ecorePackage.getETreeIterator());
		EGenericType g2 = createEGenericType(this.getNode());
		g1.getETypeArguments().add(g2);
		initEOperation(op, g1);

		op = addEOperation(executionFlowEClass, null, "getAllNodes", 1, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(this.getIterable());
		g2 = createEGenericType(this.getNode());
		g1.getETypeArguments().add(g2);
		initEOperation(op, g1);

		initEClass(graphEClass, Graph.class, "Graph", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getGraph_Nodes(), this.getNode(), this.getNode_Graph(), "nodes", null, 0, -1, Graph.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getGraph_InitialNodes(), this.getNode(), null, "initialNodes", null, 0, -1, Graph.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getGraph_Edges(), this.getEdge(), this.getEdge_Graph(), "edges", null, 0, -1, Graph.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(graphEClass, null, "getAllNodesIterator", 1, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getETreeIterator());
		g2 = createEGenericType(this.getNode());
		g1.getETypeArguments().add(g2);
		initEOperation(op, g1);

		op = addEOperation(graphEClass, null, "getAllNodes", 1, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(this.getIterable());
		g2 = createEGenericType(this.getNode());
		g1.getETypeArguments().add(g2);
		initEOperation(op, g1);

		initEClass(nodeEClass, Node.class, "Node", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getNode_Graph(), this.getGraph(), this.getGraph_Nodes(), "graph", null, 0, 1, Node.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNode_IncomingEdges(), this.getEdge(), this.getEdge_Target(), "incomingEdges", null, 0, -1, Node.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNode_OutgoingEdges(), this.getEdge(), this.getEdge_Source(), "outgoingEdges", null, 0, -1, Node.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNode_IncomingDataFlows(), this.getDataFlowTargetEnd(), this.getDataFlowTargetEnd_Node(), "incomingDataFlows", null, 0, -1, Node.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNode_OutgoingDataFlows(), this.getDataFlowSourceEnd(), this.getDataFlowSourceEnd_Node(), "outgoingDataFlows", null, 0, -1, Node.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getNode_SystemPath(), this.getSystemPath(), "systemPath", null, 0, 1, Node.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(nodeEClass, this.getDataFlowTargetEnd(), "getIncomingDataFlow", 1, 1, IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, theDMLPackage.getInputConnector(), "target", 1, 1, IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(nodeEClass, this.getDataFlowSourceEnd(), "getOutgoingDataFlow", 1, 1, IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, theDMLPackage.getOutputConnector(), "source", 1, 1, IS_UNIQUE, !IS_ORDERED);

		addEOperation(nodeEClass, this.getNode(), "getDrivingNodes", 0, -1, IS_UNIQUE, IS_ORDERED);

		addEOperation(nodeEClass, this.getNode(), "getDrivenNodes", 0, -1, IS_UNIQUE, IS_ORDERED);

		addEOperation(nodeEClass, this.getDataFlowSourceEnd(), "getDrivingEnds", 0, -1, IS_UNIQUE, IS_ORDERED);

		addEOperation(nodeEClass, this.getDataFlowTargetEnd(), "getDrivenEnds", 0, -1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(nodeEClass, ecorePackage.getEBoolean(), "isEnclosedBy", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getGraph(), "graph", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(subgraphEClass, Subgraph.class, "Subgraph", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(componentNodeEClass, ComponentNode.class, "ComponentNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getComponentNode_Component(), theDMLPackage.getComponent(), null, "component", null, 1, 1, ComponentNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getComponentNode_SampleTime(), ecorePackage.getEDouble(), "sampleTime", null, 1, 1, ComponentNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getComponentNode_AsynchronousZone(), ecorePackage.getEInt(), "asynchronousZone", "-1", 0, 1, ComponentNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(latchNodeEClass, LatchNode.class, "LatchNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLatchNode_TaskNodes(), this.getTaskGraph(), this.getTaskGraph_LatchNodes(), "taskNodes", null, 0, -1, LatchNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(compoundNodeEClass, CompoundNode.class, "CompoundNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCompoundNode_Compound(), theDMLPackage.getCompound(), null, "compound", null, 1, 1, CompoundNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(actionNodeEClass, ActionNode.class, "ActionNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getActionNode_ChoiceNode(), this.getComponentNode(), null, "choiceNode", null, 0, 1, ActionNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(subsystemNodeEClass, SubsystemNode.class, "SubsystemNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSubsystemNode_Subsystem(), theDMLPackage.getSubsystem(), null, "subsystem", null, 1, 1, SubsystemNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(taskGraphEClass, TaskGraph.class, "TaskGraph", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTaskGraph_InputNodes(), this.getTaskInputNode(), this.getTaskInputNode_TaskGraph(), "inputNodes", null, 0, -1, TaskGraph.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTaskGraph_LatchNodes(), this.getLatchNode(), this.getLatchNode_TaskNodes(), "latchNodes", null, 0, -1, TaskGraph.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(taskInputNodeEClass, TaskInputNode.class, "TaskInputNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTaskInputNode_TaskGraph(), this.getTaskGraph(), this.getTaskGraph_InputNodes(), "taskGraph", null, 1, 1, TaskInputNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(edgeEClass, Edge.class, "Edge", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEdge_Graph(), this.getGraph(), this.getGraph_Edges(), "graph", null, 1, 1, Edge.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEdge_Source(), this.getNode(), this.getNode_OutgoingEdges(), "source", null, 1, 1, Edge.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getEdge_Target(), this.getNode(), this.getNode_IncomingEdges(), "target", null, 1, 1, Edge.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(dataFlowEClass, DataFlow.class, "DataFlow", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDataFlow_TargetEnds(), this.getDataFlowTargetEnd(), this.getDataFlowTargetEnd_DataFlow(), "targetEnds", null, 1, -1, DataFlow.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDataFlow_SourceEnd(), this.getDataFlowSourceEnd(), this.getDataFlowSourceEnd_DataFlow(), "sourceEnd", null, 1, 1, DataFlow.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(dataFlowEndEClass, DataFlowEnd.class, "DataFlowEnd", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDataFlowEnd_ConnectorInfo(), this.getConnectorInfo(), null, "connectorInfo", null, 0, 1, DataFlowEnd.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(dataFlowEndEClass, this.getNode(), "getNode", 1, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(dataFlowEndEClass, this.getDataFlow(), "getDataFlow", 1, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(dataFlowEndEClass, theDMLPackage.getConnector(), "getConnector", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(dataFlowSourceEndEClass, DataFlowSourceEnd.class, "DataFlowSourceEnd", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDataFlowSourceEnd_Node(), this.getNode(), this.getNode_OutgoingDataFlows(), "node", null, 1, 1, DataFlowSourceEnd.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getDataFlowSourceEnd_DataFlow(), this.getDataFlow(), this.getDataFlow_SourceEnd(), "dataFlow", null, 1, 1, DataFlowSourceEnd.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getDataFlowSourceEnd_Connector(), theDMLPackage.getOutputConnector(), null, "connector", null, 0, 1, DataFlowSourceEnd.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		addEOperation(dataFlowSourceEndEClass, this.getDataFlowTargetEnd(), "getTargetEnds", 1, -1, IS_UNIQUE, IS_ORDERED);

		initEClass(dataFlowTargetEndEClass, DataFlowTargetEnd.class, "DataFlowTargetEnd", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDataFlowTargetEnd_Node(), this.getNode(), this.getNode_IncomingDataFlows(), "node", null, 1, 1, DataFlowTargetEnd.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getDataFlowTargetEnd_DataFlow(), this.getDataFlow(), this.getDataFlow_TargetEnds(), "dataFlow", null, 1, 1, DataFlowTargetEnd.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getDataFlowTargetEnd_Connector(), theDMLPackage.getInputConnector(), null, "connector", null, 0, 1, DataFlowTargetEnd.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		addEOperation(dataFlowTargetEndEClass, this.getDataFlowSourceEnd(), "getSourceEnd", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(connectorInfoEClass, ConnectorInfo.class, "ConnectorInfo", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(portInfoEClass, PortInfo.class, "PortInfo", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPortInfo_InoutputIndex(), ecorePackage.getEInt(), "inoutputIndex", null, 1, 1, PortInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPortInfo_PortIndex(), ecorePackage.getEInt(), "portIndex", null, 1, 1, PortInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize data types
		initEDataType(systemPathEDataType, SystemPath.class, "SystemPath", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(iterableEDataType, Iterable.class, "Iterable", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //ExecutionPackageImpl
