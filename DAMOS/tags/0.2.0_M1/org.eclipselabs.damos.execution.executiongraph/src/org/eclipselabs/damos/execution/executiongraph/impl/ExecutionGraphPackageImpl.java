/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.execution.executiongraph.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipselabs.damos.dml.DMLPackage;
import org.eclipselabs.damos.execution.executiongraph.DataFlow;
import org.eclipselabs.damos.execution.executiongraph.DataFlowEnd;
import org.eclipselabs.damos.execution.executiongraph.DataFlowSourceEnd;
import org.eclipselabs.damos.execution.executiongraph.DataFlowTargetEnd;
import org.eclipselabs.damos.execution.executiongraph.ExecutionGraph;
import org.eclipselabs.damos.execution.executiongraph.ExecutionGraphFactory;
import org.eclipselabs.damos.execution.executiongraph.ExecutionGraphPackage;
import org.eclipselabs.damos.execution.executiongraph.Link;
import org.eclipselabs.damos.execution.executiongraph.Node;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ExecutionGraphPackageImpl extends EPackageImpl implements ExecutionGraphPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass executionGraphEClass = null;

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
	private EClass linkEClass = null;

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
	private EClass dataFlowEndEClass = null;

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
	private EClass dataFlowTargetEndEClass = null;

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
	 * @see org.eclipselabs.damos.execution.executiongraph.ExecutionGraphPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ExecutionGraphPackageImpl() {
		super(eNS_URI, ExecutionGraphFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link ExecutionGraphPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ExecutionGraphPackage init() {
		if (isInited) return (ExecutionGraphPackage)EPackage.Registry.INSTANCE.getEPackage(ExecutionGraphPackage.eNS_URI);

		// Obtain or create and register package
		ExecutionGraphPackageImpl theExecutionGraphPackage = (ExecutionGraphPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ExecutionGraphPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ExecutionGraphPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		DMLPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theExecutionGraphPackage.createPackageContents();

		// Initialize created meta-data
		theExecutionGraphPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theExecutionGraphPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ExecutionGraphPackage.eNS_URI, theExecutionGraphPackage);
		return theExecutionGraphPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExecutionGraph() {
		return executionGraphEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExecutionGraph_Nodes() {
		return (EReference)executionGraphEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExecutionGraph_InitialNodes() {
		return (EReference)executionGraphEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExecutionGraph_Links() {
		return (EReference)executionGraphEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExecutionGraph_TopLevelFragment() {
		return (EReference)executionGraphEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExecutionGraph_DataFlows() {
		return (EReference)executionGraphEClass.getEStructuralFeatures().get(4);
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
	public EReference getNode_IncomingLinks() {
		return (EReference)nodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNode_OutgoingLinks() {
		return (EReference)nodeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNode_Component() {
		return (EReference)nodeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNode_OutgoingDataFlows() {
		return (EReference)nodeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNode_IncomingDataFlows() {
		return (EReference)nodeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNode_EnclosingSubsystems() {
		return (EReference)nodeEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLink() {
		return linkEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLink_SourceNode() {
		return (EReference)linkEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLink_TargetNode() {
		return (EReference)linkEClass.getEStructuralFeatures().get(1);
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
	public EReference getDataFlowSourceEnd_Port() {
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
	public EReference getDataFlowSourceEnd_Node() {
		return (EReference)dataFlowSourceEndEClass.getEStructuralFeatures().get(2);
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
	public EAttribute getDataFlowEnd_InoutputIndex() {
		return (EAttribute)dataFlowEndEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDataFlowEnd_PortIndex() {
		return (EAttribute)dataFlowEndEClass.getEStructuralFeatures().get(1);
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
	public EReference getDataFlow_SourceEnd() {
		return (EReference)dataFlowEClass.getEStructuralFeatures().get(1);
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
	public EReference getDataFlowTargetEnd_Port() {
		return (EReference)dataFlowTargetEndEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDataFlowTargetEnd_DataFlow() {
		return (EReference)dataFlowTargetEndEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExecutionGraphFactory getExecutionGraphFactory() {
		return (ExecutionGraphFactory)getEFactoryInstance();
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
		executionGraphEClass = createEClass(EXECUTION_GRAPH);
		createEReference(executionGraphEClass, EXECUTION_GRAPH__NODES);
		createEReference(executionGraphEClass, EXECUTION_GRAPH__INITIAL_NODES);
		createEReference(executionGraphEClass, EXECUTION_GRAPH__LINKS);
		createEReference(executionGraphEClass, EXECUTION_GRAPH__TOP_LEVEL_FRAGMENT);
		createEReference(executionGraphEClass, EXECUTION_GRAPH__DATA_FLOWS);

		nodeEClass = createEClass(NODE);
		createEReference(nodeEClass, NODE__INCOMING_LINKS);
		createEReference(nodeEClass, NODE__OUTGOING_LINKS);
		createEReference(nodeEClass, NODE__COMPONENT);
		createEReference(nodeEClass, NODE__OUTGOING_DATA_FLOWS);
		createEReference(nodeEClass, NODE__INCOMING_DATA_FLOWS);
		createEReference(nodeEClass, NODE__ENCLOSING_SUBSYSTEMS);

		linkEClass = createEClass(LINK);
		createEReference(linkEClass, LINK__SOURCE_NODE);
		createEReference(linkEClass, LINK__TARGET_NODE);

		dataFlowSourceEndEClass = createEClass(DATA_FLOW_SOURCE_END);
		createEReference(dataFlowSourceEndEClass, DATA_FLOW_SOURCE_END__PORT);
		createEReference(dataFlowSourceEndEClass, DATA_FLOW_SOURCE_END__DATA_FLOW);
		createEReference(dataFlowSourceEndEClass, DATA_FLOW_SOURCE_END__NODE);

		dataFlowEndEClass = createEClass(DATA_FLOW_END);
		createEAttribute(dataFlowEndEClass, DATA_FLOW_END__INOUTPUT_INDEX);
		createEAttribute(dataFlowEndEClass, DATA_FLOW_END__PORT_INDEX);

		dataFlowEClass = createEClass(DATA_FLOW);
		createEReference(dataFlowEClass, DATA_FLOW__TARGET_ENDS);
		createEReference(dataFlowEClass, DATA_FLOW__SOURCE_END);

		dataFlowTargetEndEClass = createEClass(DATA_FLOW_TARGET_END);
		createEReference(dataFlowTargetEndEClass, DATA_FLOW_TARGET_END__NODE);
		createEReference(dataFlowTargetEndEClass, DATA_FLOW_TARGET_END__PORT);
		createEReference(dataFlowTargetEndEClass, DATA_FLOW_TARGET_END__DATA_FLOW);
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

		// Set bounds for type parameters

		// Add supertypes to classes
		dataFlowSourceEndEClass.getESuperTypes().add(this.getDataFlowEnd());
		dataFlowTargetEndEClass.getESuperTypes().add(this.getDataFlowEnd());

		// Initialize classes and features; add operations and parameters
		initEClass(executionGraphEClass, ExecutionGraph.class, "ExecutionGraph", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getExecutionGraph_Nodes(), this.getNode(), null, "nodes", null, 0, -1, ExecutionGraph.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getExecutionGraph_InitialNodes(), this.getNode(), null, "initialNodes", null, 0, -1, ExecutionGraph.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getExecutionGraph_Links(), this.getLink(), null, "links", null, 0, -1, ExecutionGraph.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getExecutionGraph_TopLevelFragment(), theDMLPackage.getFragment(), null, "topLevelFragment", null, 1, 1, ExecutionGraph.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getExecutionGraph_DataFlows(), this.getDataFlow(), null, "dataFlows", null, 0, -1, ExecutionGraph.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(nodeEClass, Node.class, "Node", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getNode_IncomingLinks(), this.getLink(), this.getLink_TargetNode(), "incomingLinks", null, 0, -1, Node.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNode_OutgoingLinks(), this.getLink(), this.getLink_SourceNode(), "outgoingLinks", null, 0, -1, Node.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNode_Component(), theDMLPackage.getComponent(), null, "component", null, 1, 1, Node.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getNode_OutgoingDataFlows(), this.getDataFlowSourceEnd(), this.getDataFlowSourceEnd_Node(), "outgoingDataFlows", null, 0, -1, Node.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNode_IncomingDataFlows(), this.getDataFlowTargetEnd(), this.getDataFlowTargetEnd_Node(), "incomingDataFlows", null, 0, -1, Node.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNode_EnclosingSubsystems(), theDMLPackage.getSubsystem(), null, "enclosingSubsystems", null, 0, -1, Node.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		EOperation op = addEOperation(nodeEClass, this.getDataFlowTargetEnd(), "getIncomingDataFlow", 1, 1, IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, theDMLPackage.getInputPort(), "inputPort", 1, 1, IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(nodeEClass, this.getDataFlowSourceEnd(), "getOutgoingDataFlow", 1, 1, IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, theDMLPackage.getOutputPort(), "outputPort", 1, 1, IS_UNIQUE, !IS_ORDERED);

		initEClass(linkEClass, Link.class, "Link", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLink_SourceNode(), this.getNode(), this.getNode_OutgoingLinks(), "sourceNode", null, 1, 1, Link.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getLink_TargetNode(), this.getNode(), this.getNode_IncomingLinks(), "targetNode", null, 1, 1, Link.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(dataFlowSourceEndEClass, DataFlowSourceEnd.class, "DataFlowSourceEnd", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDataFlowSourceEnd_Port(), theDMLPackage.getOutputPort(), null, "port", null, 1, 1, DataFlowSourceEnd.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getDataFlowSourceEnd_DataFlow(), this.getDataFlow(), this.getDataFlow_SourceEnd(), "dataFlow", null, 1, 1, DataFlowSourceEnd.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getDataFlowSourceEnd_Node(), this.getNode(), this.getNode_OutgoingDataFlows(), "node", null, 1, 1, DataFlowSourceEnd.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(dataFlowEndEClass, DataFlowEnd.class, "DataFlowEnd", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDataFlowEnd_InoutputIndex(), ecorePackage.getEInt(), "inoutputIndex", null, 1, 1, DataFlowEnd.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getDataFlowEnd_PortIndex(), ecorePackage.getEInt(), "portIndex", null, 1, 1, DataFlowEnd.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(dataFlowEClass, DataFlow.class, "DataFlow", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDataFlow_TargetEnds(), this.getDataFlowTargetEnd(), this.getDataFlowTargetEnd_DataFlow(), "targetEnds", null, 1, -1, DataFlow.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDataFlow_SourceEnd(), this.getDataFlowSourceEnd(), this.getDataFlowSourceEnd_DataFlow(), "sourceEnd", null, 1, 1, DataFlow.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(dataFlowTargetEndEClass, DataFlowTargetEnd.class, "DataFlowTargetEnd", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDataFlowTargetEnd_Node(), this.getNode(), this.getNode_IncomingDataFlows(), "node", null, 1, 1, DataFlowTargetEnd.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getDataFlowTargetEnd_Port(), theDMLPackage.getInputPort(), null, "port", null, 1, 1, DataFlowTargetEnd.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getDataFlowTargetEnd_DataFlow(), this.getDataFlow(), this.getDataFlow_TargetEnds(), "dataFlow", null, 1, 1, DataFlowTargetEnd.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //ExecutionGraphPackageImpl
