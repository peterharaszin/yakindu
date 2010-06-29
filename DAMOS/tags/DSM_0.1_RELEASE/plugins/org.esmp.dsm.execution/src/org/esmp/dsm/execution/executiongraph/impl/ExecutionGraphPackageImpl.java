/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.esmp.dsm.execution.executiongraph.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.esmp.dsm.execution.executiongraph.ExecutionEdge;
import org.esmp.dsm.execution.executiongraph.ExecutionGraph;
import org.esmp.dsm.execution.executiongraph.ExecutionGraphFactory;
import org.esmp.dsm.execution.executiongraph.ExecutionGraphPackage;
import org.esmp.dsm.execution.executiongraph.ExecutionNode;
import org.esmp.dsm.semantic.blockdiagram.BlockDiagramPackage;

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
	private EClass executionNodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass executionEdgeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType uriEDataType = null;

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
	 * @see org.esmp.dsm.execution.executiongraph.ExecutionGraphPackage#eNS_URI
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
		BlockDiagramPackage.eINSTANCE.eClass();

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
	public EReference getExecutionGraph_Edges() {
		return (EReference)executionGraphEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExecutionGraph_BlockDiagram() {
		return (EReference)executionGraphEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExecutionNode() {
		return executionNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExecutionNode_IncomingEdges() {
		return (EReference)executionNodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExecutionNode_OutgoingEdges() {
		return (EReference)executionNodeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExecutionNode_Block() {
		return (EReference)executionNodeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExecutionEdge() {
		return executionEdgeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExecutionEdge_Source() {
		return (EReference)executionEdgeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExecutionEdge_Target() {
		return (EReference)executionEdgeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getURI() {
		return uriEDataType;
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
		createEReference(executionGraphEClass, EXECUTION_GRAPH__EDGES);
		createEReference(executionGraphEClass, EXECUTION_GRAPH__BLOCK_DIAGRAM);

		executionNodeEClass = createEClass(EXECUTION_NODE);
		createEReference(executionNodeEClass, EXECUTION_NODE__INCOMING_EDGES);
		createEReference(executionNodeEClass, EXECUTION_NODE__OUTGOING_EDGES);
		createEReference(executionNodeEClass, EXECUTION_NODE__BLOCK);

		executionEdgeEClass = createEClass(EXECUTION_EDGE);
		createEReference(executionEdgeEClass, EXECUTION_EDGE__SOURCE);
		createEReference(executionEdgeEClass, EXECUTION_EDGE__TARGET);

		// Create data types
		uriEDataType = createEDataType(URI);
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
		BlockDiagramPackage theBlockDiagramPackage = (BlockDiagramPackage)EPackage.Registry.INSTANCE.getEPackage(BlockDiagramPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes and features; add operations and parameters
		initEClass(executionGraphEClass, ExecutionGraph.class, "ExecutionGraph", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getExecutionGraph_Nodes(), this.getExecutionNode(), null, "nodes", null, 0, -1, ExecutionGraph.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getExecutionGraph_InitialNodes(), this.getExecutionNode(), null, "initialNodes", null, 0, -1, ExecutionGraph.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getExecutionGraph_Edges(), this.getExecutionEdge(), null, "edges", null, 0, -1, ExecutionGraph.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getExecutionGraph_BlockDiagram(), theBlockDiagramPackage.getBlockDiagram(), null, "blockDiagram", null, 1, 1, ExecutionGraph.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		EOperation op = addEOperation(executionGraphEClass, this.getExecutionNode(), "getNode", 1, 1, IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, this.getURI(), "blockURI", 1, 1, IS_UNIQUE, !IS_ORDERED);

		initEClass(executionNodeEClass, ExecutionNode.class, "ExecutionNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getExecutionNode_IncomingEdges(), this.getExecutionEdge(), this.getExecutionEdge_Target(), "incomingEdges", null, 0, -1, ExecutionNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getExecutionNode_OutgoingEdges(), this.getExecutionEdge(), this.getExecutionEdge_Source(), "outgoingEdges", null, 0, -1, ExecutionNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getExecutionNode_Block(), theBlockDiagramPackage.getBlock(), null, "block", null, 1, 1, ExecutionNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(executionEdgeEClass, ExecutionEdge.class, "ExecutionEdge", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getExecutionEdge_Source(), this.getExecutionNode(), this.getExecutionNode_OutgoingEdges(), "source", null, 1, 1, ExecutionEdge.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getExecutionEdge_Target(), this.getExecutionNode(), this.getExecutionNode_IncomingEdges(), "target", null, 1, 1, ExecutionEdge.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		// Initialize data types
		initEDataType(uriEDataType, org.eclipse.emf.common.util.URI.class, "URI", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //ExecutionGraphPackageImpl
