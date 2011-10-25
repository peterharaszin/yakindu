/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.mscript.computationmodel;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipselabs.damos.mscript.computationmodel.ComputationModelFactory
 * @model kind="package"
 * @generated
 */
public interface ComputationModelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "computationmodel";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipselabs.org/damos/mscript/ComputationModel";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "computationmodel";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ComputationModelPackage eINSTANCE = org.eclipselabs.damos.mscript.computationmodel.impl.ComputationModelPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.mscript.computationmodel.impl.NumberFormatImpl <em>Number Format</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.mscript.computationmodel.impl.NumberFormatImpl
	 * @see org.eclipselabs.damos.mscript.computationmodel.impl.ComputationModelPackageImpl#getNumberFormat()
	 * @generated
	 */
	int NUMBER_FORMAT = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMBER_FORMAT__NAME = 0;

	/**
	 * The number of structural features of the '<em>Number Format</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMBER_FORMAT_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.mscript.computationmodel.impl.FloatingPointFormatImpl <em>Floating Point Format</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.mscript.computationmodel.impl.FloatingPointFormatImpl
	 * @see org.eclipselabs.damos.mscript.computationmodel.impl.ComputationModelPackageImpl#getFloatingPointFormat()
	 * @generated
	 */
	int FLOATING_POINT_FORMAT = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOATING_POINT_FORMAT__NAME = NUMBER_FORMAT__NAME;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOATING_POINT_FORMAT__KIND = NUMBER_FORMAT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Floating Point Format</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOATING_POINT_FORMAT_FEATURE_COUNT = NUMBER_FORMAT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.mscript.computationmodel.impl.FixedPointFormatImpl <em>Fixed Point Format</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.mscript.computationmodel.impl.FixedPointFormatImpl
	 * @see org.eclipselabs.damos.mscript.computationmodel.impl.ComputationModelPackageImpl#getFixedPointFormat()
	 * @generated
	 */
	int FIXED_POINT_FORMAT = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIXED_POINT_FORMAT__NAME = NUMBER_FORMAT__NAME;

	/**
	 * The feature id for the '<em><b>Integer Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIXED_POINT_FORMAT__INTEGER_LENGTH = NUMBER_FORMAT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Fraction Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIXED_POINT_FORMAT__FRACTION_LENGTH = NUMBER_FORMAT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Word Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIXED_POINT_FORMAT__WORD_SIZE = NUMBER_FORMAT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Operations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIXED_POINT_FORMAT__OPERATIONS = NUMBER_FORMAT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Fixed Point Format</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIXED_POINT_FORMAT_FEATURE_COUNT = NUMBER_FORMAT_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.mscript.computationmodel.impl.FixedPointOperationImpl <em>Fixed Point Operation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.mscript.computationmodel.impl.FixedPointOperationImpl
	 * @see org.eclipselabs.damos.mscript.computationmodel.impl.ComputationModelPackageImpl#getFixedPointOperation()
	 * @generated
	 */
	int FIXED_POINT_OPERATION = 3;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIXED_POINT_OPERATION__KIND = 0;

	/**
	 * The feature id for the '<em><b>Intermediate Word Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIXED_POINT_OPERATION__INTERMEDIATE_WORD_SIZE = 1;

	/**
	 * The feature id for the '<em><b>Saturate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIXED_POINT_OPERATION__SATURATE = 2;

	/**
	 * The number of structural features of the '<em>Fixed Point Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIXED_POINT_OPERATION_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.mscript.computationmodel.impl.ComputationModelImpl <em>Computation Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.mscript.computationmodel.impl.ComputationModelImpl
	 * @see org.eclipselabs.damos.mscript.computationmodel.impl.ComputationModelPackageImpl#getComputationModel()
	 * @generated
	 */
	int COMPUTATION_MODEL = 4;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTATION_MODEL__QUALIFIED_NAME = 0;

	/**
	 * The feature id for the '<em><b>Number Formats</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTATION_MODEL__NUMBER_FORMATS = 1;

	/**
	 * The feature id for the '<em><b>Number Format Mappings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTATION_MODEL__NUMBER_FORMAT_MAPPINGS = 2;

	/**
	 * The number of structural features of the '<em>Computation Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTATION_MODEL_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.mscript.computationmodel.impl.NumberFormatMappingImpl <em>Number Format Mapping</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.mscript.computationmodel.impl.NumberFormatMappingImpl
	 * @see org.eclipselabs.damos.mscript.computationmodel.impl.ComputationModelPackageImpl#getNumberFormatMapping()
	 * @generated
	 */
	int NUMBER_FORMAT_MAPPING = 5;

	/**
	 * The feature id for the '<em><b>Type Specifier</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMBER_FORMAT_MAPPING__TYPE_SPECIFIER = 0;

	/**
	 * The feature id for the '<em><b>Number Format</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMBER_FORMAT_MAPPING__NUMBER_FORMAT = 1;

	/**
	 * The number of structural features of the '<em>Number Format Mapping</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMBER_FORMAT_MAPPING_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.mscript.computationmodel.FloatingPointFormatKind <em>Floating Point Format Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.mscript.computationmodel.FloatingPointFormatKind
	 * @see org.eclipselabs.damos.mscript.computationmodel.impl.ComputationModelPackageImpl#getFloatingPointFormatKind()
	 * @generated
	 */
	int FLOATING_POINT_FORMAT_KIND = 6;

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.mscript.computationmodel.FixedPointOperationKind <em>Fixed Point Operation Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.mscript.computationmodel.FixedPointOperationKind
	 * @see org.eclipselabs.damos.mscript.computationmodel.impl.ComputationModelPackageImpl#getFixedPointOperationKind()
	 * @generated
	 */
	int FIXED_POINT_OPERATION_KIND = 7;


	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.mscript.computationmodel.FloatingPointFormat <em>Floating Point Format</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Floating Point Format</em>'.
	 * @see org.eclipselabs.damos.mscript.computationmodel.FloatingPointFormat
	 * @generated
	 */
	EClass getFloatingPointFormat();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.damos.mscript.computationmodel.FloatingPointFormat#getKind <em>Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Kind</em>'.
	 * @see org.eclipselabs.damos.mscript.computationmodel.FloatingPointFormat#getKind()
	 * @see #getFloatingPointFormat()
	 * @generated
	 */
	EAttribute getFloatingPointFormat_Kind();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.mscript.computationmodel.NumberFormat <em>Number Format</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Number Format</em>'.
	 * @see org.eclipselabs.damos.mscript.computationmodel.NumberFormat
	 * @generated
	 */
	EClass getNumberFormat();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.damos.mscript.computationmodel.NumberFormat#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipselabs.damos.mscript.computationmodel.NumberFormat#getName()
	 * @see #getNumberFormat()
	 * @generated
	 */
	EAttribute getNumberFormat_Name();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.mscript.computationmodel.FixedPointFormat <em>Fixed Point Format</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Fixed Point Format</em>'.
	 * @see org.eclipselabs.damos.mscript.computationmodel.FixedPointFormat
	 * @generated
	 */
	EClass getFixedPointFormat();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.damos.mscript.computationmodel.FixedPointFormat#getIntegerLength <em>Integer Length</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Integer Length</em>'.
	 * @see org.eclipselabs.damos.mscript.computationmodel.FixedPointFormat#getIntegerLength()
	 * @see #getFixedPointFormat()
	 * @generated
	 */
	EAttribute getFixedPointFormat_IntegerLength();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.damos.mscript.computationmodel.FixedPointFormat#getFractionLength <em>Fraction Length</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Fraction Length</em>'.
	 * @see org.eclipselabs.damos.mscript.computationmodel.FixedPointFormat#getFractionLength()
	 * @see #getFixedPointFormat()
	 * @generated
	 */
	EAttribute getFixedPointFormat_FractionLength();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.damos.mscript.computationmodel.FixedPointFormat#getWordSize <em>Word Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Word Size</em>'.
	 * @see org.eclipselabs.damos.mscript.computationmodel.FixedPointFormat#getWordSize()
	 * @see #getFixedPointFormat()
	 * @generated
	 */
	EAttribute getFixedPointFormat_WordSize();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipselabs.damos.mscript.computationmodel.FixedPointFormat#getOperations <em>Operations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Operations</em>'.
	 * @see org.eclipselabs.damos.mscript.computationmodel.FixedPointFormat#getOperations()
	 * @see #getFixedPointFormat()
	 * @generated
	 */
	EReference getFixedPointFormat_Operations();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.mscript.computationmodel.FixedPointOperation <em>Fixed Point Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Fixed Point Operation</em>'.
	 * @see org.eclipselabs.damos.mscript.computationmodel.FixedPointOperation
	 * @generated
	 */
	EClass getFixedPointOperation();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.damos.mscript.computationmodel.FixedPointOperation#getKind <em>Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Kind</em>'.
	 * @see org.eclipselabs.damos.mscript.computationmodel.FixedPointOperation#getKind()
	 * @see #getFixedPointOperation()
	 * @generated
	 */
	EAttribute getFixedPointOperation_Kind();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.damos.mscript.computationmodel.FixedPointOperation#getIntermediateWordSize <em>Intermediate Word Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Intermediate Word Size</em>'.
	 * @see org.eclipselabs.damos.mscript.computationmodel.FixedPointOperation#getIntermediateWordSize()
	 * @see #getFixedPointOperation()
	 * @generated
	 */
	EAttribute getFixedPointOperation_IntermediateWordSize();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.damos.mscript.computationmodel.FixedPointOperation#isSaturate <em>Saturate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Saturate</em>'.
	 * @see org.eclipselabs.damos.mscript.computationmodel.FixedPointOperation#isSaturate()
	 * @see #getFixedPointOperation()
	 * @generated
	 */
	EAttribute getFixedPointOperation_Saturate();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.mscript.computationmodel.ComputationModel <em>Computation Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Computation Model</em>'.
	 * @see org.eclipselabs.damos.mscript.computationmodel.ComputationModel
	 * @generated
	 */
	EClass getComputationModel();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipselabs.damos.mscript.computationmodel.ComputationModel#getNumberFormats <em>Number Formats</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Number Formats</em>'.
	 * @see org.eclipselabs.damos.mscript.computationmodel.ComputationModel#getNumberFormats()
	 * @see #getComputationModel()
	 * @generated
	 */
	EReference getComputationModel_NumberFormats();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipselabs.damos.mscript.computationmodel.ComputationModel#getNumberFormatMappings <em>Number Format Mappings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Number Format Mappings</em>'.
	 * @see org.eclipselabs.damos.mscript.computationmodel.ComputationModel#getNumberFormatMappings()
	 * @see #getComputationModel()
	 * @generated
	 */
	EReference getComputationModel_NumberFormatMappings();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.damos.mscript.computationmodel.ComputationModel#getQualifiedName <em>Qualified Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Qualified Name</em>'.
	 * @see org.eclipselabs.damos.mscript.computationmodel.ComputationModel#getQualifiedName()
	 * @see #getComputationModel()
	 * @generated
	 */
	EAttribute getComputationModel_QualifiedName();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.mscript.computationmodel.NumberFormatMapping <em>Number Format Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Number Format Mapping</em>'.
	 * @see org.eclipselabs.damos.mscript.computationmodel.NumberFormatMapping
	 * @generated
	 */
	EClass getNumberFormatMapping();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipselabs.damos.mscript.computationmodel.NumberFormatMapping#getTypeSpecifier <em>Type Specifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Type Specifier</em>'.
	 * @see org.eclipselabs.damos.mscript.computationmodel.NumberFormatMapping#getTypeSpecifier()
	 * @see #getNumberFormatMapping()
	 * @generated
	 */
	EReference getNumberFormatMapping_TypeSpecifier();

	/**
	 * Returns the meta object for the reference '{@link org.eclipselabs.damos.mscript.computationmodel.NumberFormatMapping#getNumberFormat <em>Number Format</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Number Format</em>'.
	 * @see org.eclipselabs.damos.mscript.computationmodel.NumberFormatMapping#getNumberFormat()
	 * @see #getNumberFormatMapping()
	 * @generated
	 */
	EReference getNumberFormatMapping_NumberFormat();

	/**
	 * Returns the meta object for enum '{@link org.eclipselabs.damos.mscript.computationmodel.FloatingPointFormatKind <em>Floating Point Format Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Floating Point Format Kind</em>'.
	 * @see org.eclipselabs.damos.mscript.computationmodel.FloatingPointFormatKind
	 * @generated
	 */
	EEnum getFloatingPointFormatKind();

	/**
	 * Returns the meta object for enum '{@link org.eclipselabs.damos.mscript.computationmodel.FixedPointOperationKind <em>Fixed Point Operation Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Fixed Point Operation Kind</em>'.
	 * @see org.eclipselabs.damos.mscript.computationmodel.FixedPointOperationKind
	 * @generated
	 */
	EEnum getFixedPointOperationKind();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ComputationModelFactory getComputationModelFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipselabs.damos.mscript.computationmodel.impl.FloatingPointFormatImpl <em>Floating Point Format</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.mscript.computationmodel.impl.FloatingPointFormatImpl
		 * @see org.eclipselabs.damos.mscript.computationmodel.impl.ComputationModelPackageImpl#getFloatingPointFormat()
		 * @generated
		 */
		EClass FLOATING_POINT_FORMAT = eINSTANCE.getFloatingPointFormat();

		/**
		 * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FLOATING_POINT_FORMAT__KIND = eINSTANCE.getFloatingPointFormat_Kind();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.damos.mscript.computationmodel.impl.NumberFormatImpl <em>Number Format</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.mscript.computationmodel.impl.NumberFormatImpl
		 * @see org.eclipselabs.damos.mscript.computationmodel.impl.ComputationModelPackageImpl#getNumberFormat()
		 * @generated
		 */
		EClass NUMBER_FORMAT = eINSTANCE.getNumberFormat();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NUMBER_FORMAT__NAME = eINSTANCE.getNumberFormat_Name();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.damos.mscript.computationmodel.impl.FixedPointFormatImpl <em>Fixed Point Format</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.mscript.computationmodel.impl.FixedPointFormatImpl
		 * @see org.eclipselabs.damos.mscript.computationmodel.impl.ComputationModelPackageImpl#getFixedPointFormat()
		 * @generated
		 */
		EClass FIXED_POINT_FORMAT = eINSTANCE.getFixedPointFormat();

		/**
		 * The meta object literal for the '<em><b>Integer Length</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FIXED_POINT_FORMAT__INTEGER_LENGTH = eINSTANCE.getFixedPointFormat_IntegerLength();

		/**
		 * The meta object literal for the '<em><b>Fraction Length</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FIXED_POINT_FORMAT__FRACTION_LENGTH = eINSTANCE.getFixedPointFormat_FractionLength();

		/**
		 * The meta object literal for the '<em><b>Word Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FIXED_POINT_FORMAT__WORD_SIZE = eINSTANCE.getFixedPointFormat_WordSize();

		/**
		 * The meta object literal for the '<em><b>Operations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FIXED_POINT_FORMAT__OPERATIONS = eINSTANCE.getFixedPointFormat_Operations();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.damos.mscript.computationmodel.impl.FixedPointOperationImpl <em>Fixed Point Operation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.mscript.computationmodel.impl.FixedPointOperationImpl
		 * @see org.eclipselabs.damos.mscript.computationmodel.impl.ComputationModelPackageImpl#getFixedPointOperation()
		 * @generated
		 */
		EClass FIXED_POINT_OPERATION = eINSTANCE.getFixedPointOperation();

		/**
		 * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FIXED_POINT_OPERATION__KIND = eINSTANCE.getFixedPointOperation_Kind();

		/**
		 * The meta object literal for the '<em><b>Intermediate Word Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FIXED_POINT_OPERATION__INTERMEDIATE_WORD_SIZE = eINSTANCE.getFixedPointOperation_IntermediateWordSize();

		/**
		 * The meta object literal for the '<em><b>Saturate</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FIXED_POINT_OPERATION__SATURATE = eINSTANCE.getFixedPointOperation_Saturate();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.damos.mscript.computationmodel.impl.ComputationModelImpl <em>Computation Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.mscript.computationmodel.impl.ComputationModelImpl
		 * @see org.eclipselabs.damos.mscript.computationmodel.impl.ComputationModelPackageImpl#getComputationModel()
		 * @generated
		 */
		EClass COMPUTATION_MODEL = eINSTANCE.getComputationModel();

		/**
		 * The meta object literal for the '<em><b>Number Formats</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPUTATION_MODEL__NUMBER_FORMATS = eINSTANCE.getComputationModel_NumberFormats();

		/**
		 * The meta object literal for the '<em><b>Number Format Mappings</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPUTATION_MODEL__NUMBER_FORMAT_MAPPINGS = eINSTANCE.getComputationModel_NumberFormatMappings();

		/**
		 * The meta object literal for the '<em><b>Qualified Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPUTATION_MODEL__QUALIFIED_NAME = eINSTANCE.getComputationModel_QualifiedName();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.damos.mscript.computationmodel.impl.NumberFormatMappingImpl <em>Number Format Mapping</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.mscript.computationmodel.impl.NumberFormatMappingImpl
		 * @see org.eclipselabs.damos.mscript.computationmodel.impl.ComputationModelPackageImpl#getNumberFormatMapping()
		 * @generated
		 */
		EClass NUMBER_FORMAT_MAPPING = eINSTANCE.getNumberFormatMapping();

		/**
		 * The meta object literal for the '<em><b>Type Specifier</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NUMBER_FORMAT_MAPPING__TYPE_SPECIFIER = eINSTANCE.getNumberFormatMapping_TypeSpecifier();

		/**
		 * The meta object literal for the '<em><b>Number Format</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NUMBER_FORMAT_MAPPING__NUMBER_FORMAT = eINSTANCE.getNumberFormatMapping_NumberFormat();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.damos.mscript.computationmodel.FloatingPointFormatKind <em>Floating Point Format Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.mscript.computationmodel.FloatingPointFormatKind
		 * @see org.eclipselabs.damos.mscript.computationmodel.impl.ComputationModelPackageImpl#getFloatingPointFormatKind()
		 * @generated
		 */
		EEnum FLOATING_POINT_FORMAT_KIND = eINSTANCE.getFloatingPointFormatKind();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.damos.mscript.computationmodel.FixedPointOperationKind <em>Fixed Point Operation Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.mscript.computationmodel.FixedPointOperationKind
		 * @see org.eclipselabs.damos.mscript.computationmodel.impl.ComputationModelPackageImpl#getFixedPointOperationKind()
		 * @generated
		 */
		EEnum FIXED_POINT_OPERATION_KIND = eINSTANCE.getFixedPointOperationKind();

	}

} //ComputationModelPackage
