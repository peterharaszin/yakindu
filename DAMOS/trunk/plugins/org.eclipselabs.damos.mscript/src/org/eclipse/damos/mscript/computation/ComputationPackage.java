/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.damos.mscript.computation;

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
 * @see org.eclipse.damos.mscript.computation.ComputationFactory
 * @model kind="package"
 * @generated
 */
public interface ComputationPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "computation";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/damos/mscript/2011/Computation";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "computation";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ComputationPackage eINSTANCE = org.eclipse.damos.mscript.computation.impl.ComputationPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.damos.mscript.computation.impl.NumberFormatImpl <em>Number Format</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.damos.mscript.computation.impl.NumberFormatImpl
	 * @see org.eclipse.damos.mscript.computation.impl.ComputationPackageImpl#getNumberFormat()
	 * @generated
	 */
	int NUMBER_FORMAT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.damos.mscript.computation.impl.FloatingPointFormatImpl <em>Floating Point Format</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.damos.mscript.computation.impl.FloatingPointFormatImpl
	 * @see org.eclipse.damos.mscript.computation.impl.ComputationPackageImpl#getFloatingPointFormat()
	 * @generated
	 */
	int FLOATING_POINT_FORMAT = 4;

	/**
	 * The meta object id for the '{@link org.eclipse.damos.mscript.computation.PredefinedFixedPointFormatKind <em>Predefined Fixed Point Format Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.damos.mscript.computation.PredefinedFixedPointFormatKind
	 * @see org.eclipse.damos.mscript.computation.impl.ComputationPackageImpl#getPredefinedFixedPointFormatKind()
	 * @generated
	 */
	int PREDEFINED_FIXED_POINT_FORMAT_KIND = 5;

	/**
	 * The meta object id for the '{@link org.eclipse.damos.mscript.computation.impl.FixedPointFormatImpl <em>Fixed Point Format</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.damos.mscript.computation.impl.FixedPointFormatImpl
	 * @see org.eclipse.damos.mscript.computation.impl.ComputationPackageImpl#getFixedPointFormat()
	 * @generated
	 */
	int FIXED_POINT_FORMAT = 3;

	/**
	 * The meta object id for the '{@link org.eclipse.damos.mscript.computation.impl.ComputationModelImpl <em>Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.damos.mscript.computation.impl.ComputationModelImpl
	 * @see org.eclipse.damos.mscript.computation.impl.ComputationPackageImpl#getComputationModel()
	 * @generated
	 */
	int COMPUTATION_MODEL = 0;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTATION_MODEL__QUALIFIED_NAME = 0;

	/**
	 * The feature id for the '<em><b>Number Format Mappings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTATION_MODEL__NUMBER_FORMAT_MAPPINGS = 1;

	/**
	 * The number of structural features of the '<em>Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTATION_MODEL_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.damos.mscript.computation.impl.NumberFormatMappingImpl <em>Number Format Mapping</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.damos.mscript.computation.impl.NumberFormatMappingImpl
	 * @see org.eclipse.damos.mscript.computation.impl.ComputationPackageImpl#getNumberFormatMapping()
	 * @generated
	 */
	int NUMBER_FORMAT_MAPPING = 1;

	/**
	 * The feature id for the '<em><b>Type Specifier</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMBER_FORMAT_MAPPING__TYPE_SPECIFIER = 0;

	/**
	 * The feature id for the '<em><b>Number Format</b></em>' containment reference.
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
	 * The number of structural features of the '<em>Number Format</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMBER_FORMAT_FEATURE_COUNT = 0;

	/**
	 * The feature id for the '<em><b>Predefined Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIXED_POINT_FORMAT__PREDEFINED_KIND = NUMBER_FORMAT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Unsigned</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIXED_POINT_FORMAT__UNSIGNED = NUMBER_FORMAT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Integer Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIXED_POINT_FORMAT__INTEGER_LENGTH = NUMBER_FORMAT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Fraction Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIXED_POINT_FORMAT__FRACTION_LENGTH = NUMBER_FORMAT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Word Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIXED_POINT_FORMAT__WORD_SIZE = NUMBER_FORMAT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Slope</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIXED_POINT_FORMAT__SLOPE = NUMBER_FORMAT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Bias</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIXED_POINT_FORMAT__BIAS = NUMBER_FORMAT_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Saturate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIXED_POINT_FORMAT__SATURATE = NUMBER_FORMAT_FEATURE_COUNT + 7;

	/**
	 * The number of structural features of the '<em>Fixed Point Format</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIXED_POINT_FORMAT_FEATURE_COUNT = NUMBER_FORMAT_FEATURE_COUNT + 8;

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
	 * The meta object id for the '{@link org.eclipse.damos.mscript.computation.FloatingPointFormatKind <em>Floating Point Format Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.damos.mscript.computation.FloatingPointFormatKind
	 * @see org.eclipse.damos.mscript.computation.impl.ComputationPackageImpl#getFloatingPointFormatKind()
	 * @generated
	 */
	int FLOATING_POINT_FORMAT_KIND = 6;

	/**
	 * Returns the meta object for class '{@link org.eclipse.damos.mscript.computation.FloatingPointFormat <em>Floating Point Format</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Floating Point Format</em>'.
	 * @see org.eclipse.damos.mscript.computation.FloatingPointFormat
	 * @generated
	 */
	EClass getFloatingPointFormat();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.damos.mscript.computation.FloatingPointFormat#getKind <em>Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Kind</em>'.
	 * @see org.eclipse.damos.mscript.computation.FloatingPointFormat#getKind()
	 * @see #getFloatingPointFormat()
	 * @generated
	 */
	EAttribute getFloatingPointFormat_Kind();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.damos.mscript.computation.PredefinedFixedPointFormatKind <em>Predefined Fixed Point Format Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Predefined Fixed Point Format Kind</em>'.
	 * @see org.eclipse.damos.mscript.computation.PredefinedFixedPointFormatKind
	 * @generated
	 */
	EEnum getPredefinedFixedPointFormatKind();

	/**
	 * Returns the meta object for class '{@link org.eclipse.damos.mscript.computation.NumberFormat <em>Number Format</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Number Format</em>'.
	 * @see org.eclipse.damos.mscript.computation.NumberFormat
	 * @generated
	 */
	EClass getNumberFormat();

	/**
	 * Returns the meta object for class '{@link org.eclipse.damos.mscript.computation.FixedPointFormat <em>Fixed Point Format</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Fixed Point Format</em>'.
	 * @see org.eclipse.damos.mscript.computation.FixedPointFormat
	 * @generated
	 */
	EClass getFixedPointFormat();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.damos.mscript.computation.FixedPointFormat#getPredefinedKind <em>Predefined Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Predefined Kind</em>'.
	 * @see org.eclipse.damos.mscript.computation.FixedPointFormat#getPredefinedKind()
	 * @see #getFixedPointFormat()
	 * @generated
	 */
	EAttribute getFixedPointFormat_PredefinedKind();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.damos.mscript.computation.FixedPointFormat#isUnsigned <em>Unsigned</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Unsigned</em>'.
	 * @see org.eclipse.damos.mscript.computation.FixedPointFormat#isUnsigned()
	 * @see #getFixedPointFormat()
	 * @generated
	 */
	EAttribute getFixedPointFormat_Unsigned();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.damos.mscript.computation.FixedPointFormat#getIntegerLength <em>Integer Length</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Integer Length</em>'.
	 * @see org.eclipse.damos.mscript.computation.FixedPointFormat#getIntegerLength()
	 * @see #getFixedPointFormat()
	 * @generated
	 */
	EAttribute getFixedPointFormat_IntegerLength();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.damos.mscript.computation.FixedPointFormat#getFractionLength <em>Fraction Length</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Fraction Length</em>'.
	 * @see org.eclipse.damos.mscript.computation.FixedPointFormat#getFractionLength()
	 * @see #getFixedPointFormat()
	 * @generated
	 */
	EAttribute getFixedPointFormat_FractionLength();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.damos.mscript.computation.FixedPointFormat#getWordSize <em>Word Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Word Size</em>'.
	 * @see org.eclipse.damos.mscript.computation.FixedPointFormat#getWordSize()
	 * @see #getFixedPointFormat()
	 * @generated
	 */
	EAttribute getFixedPointFormat_WordSize();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.damos.mscript.computation.FixedPointFormat#getSlope <em>Slope</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Slope</em>'.
	 * @see org.eclipse.damos.mscript.computation.FixedPointFormat#getSlope()
	 * @see #getFixedPointFormat()
	 * @generated
	 */
	EAttribute getFixedPointFormat_Slope();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.damos.mscript.computation.FixedPointFormat#getBias <em>Bias</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Bias</em>'.
	 * @see org.eclipse.damos.mscript.computation.FixedPointFormat#getBias()
	 * @see #getFixedPointFormat()
	 * @generated
	 */
	EAttribute getFixedPointFormat_Bias();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.damos.mscript.computation.FixedPointFormat#isSaturate <em>Saturate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Saturate</em>'.
	 * @see org.eclipse.damos.mscript.computation.FixedPointFormat#isSaturate()
	 * @see #getFixedPointFormat()
	 * @generated
	 */
	EAttribute getFixedPointFormat_Saturate();

	/**
	 * Returns the meta object for class '{@link org.eclipse.damos.mscript.computation.ComputationModel <em>Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model</em>'.
	 * @see org.eclipse.damos.mscript.computation.ComputationModel
	 * @generated
	 */
	EClass getComputationModel();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.damos.mscript.computation.ComputationModel#getNumberFormatMappings <em>Number Format Mappings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Number Format Mappings</em>'.
	 * @see org.eclipse.damos.mscript.computation.ComputationModel#getNumberFormatMappings()
	 * @see #getComputationModel()
	 * @generated
	 */
	EReference getComputationModel_NumberFormatMappings();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.damos.mscript.computation.ComputationModel#getQualifiedName <em>Qualified Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Qualified Name</em>'.
	 * @see org.eclipse.damos.mscript.computation.ComputationModel#getQualifiedName()
	 * @see #getComputationModel()
	 * @generated
	 */
	EAttribute getComputationModel_QualifiedName();

	/**
	 * Returns the meta object for class '{@link org.eclipse.damos.mscript.computation.NumberFormatMapping <em>Number Format Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Number Format Mapping</em>'.
	 * @see org.eclipse.damos.mscript.computation.NumberFormatMapping
	 * @generated
	 */
	EClass getNumberFormatMapping();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.damos.mscript.computation.NumberFormatMapping#getTypeSpecifier <em>Type Specifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Type Specifier</em>'.
	 * @see org.eclipse.damos.mscript.computation.NumberFormatMapping#getTypeSpecifier()
	 * @see #getNumberFormatMapping()
	 * @generated
	 */
	EReference getNumberFormatMapping_TypeSpecifier();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.damos.mscript.computation.NumberFormatMapping#getNumberFormat <em>Number Format</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Number Format</em>'.
	 * @see org.eclipse.damos.mscript.computation.NumberFormatMapping#getNumberFormat()
	 * @see #getNumberFormatMapping()
	 * @generated
	 */
	EReference getNumberFormatMapping_NumberFormat();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.damos.mscript.computation.FloatingPointFormatKind <em>Floating Point Format Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Floating Point Format Kind</em>'.
	 * @see org.eclipse.damos.mscript.computation.FloatingPointFormatKind
	 * @generated
	 */
	EEnum getFloatingPointFormatKind();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ComputationFactory getComputationFactory();

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
		 * The meta object literal for the '{@link org.eclipse.damos.mscript.computation.impl.FloatingPointFormatImpl <em>Floating Point Format</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.damos.mscript.computation.impl.FloatingPointFormatImpl
		 * @see org.eclipse.damos.mscript.computation.impl.ComputationPackageImpl#getFloatingPointFormat()
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
		 * The meta object literal for the '{@link org.eclipse.damos.mscript.computation.PredefinedFixedPointFormatKind <em>Predefined Fixed Point Format Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.damos.mscript.computation.PredefinedFixedPointFormatKind
		 * @see org.eclipse.damos.mscript.computation.impl.ComputationPackageImpl#getPredefinedFixedPointFormatKind()
		 * @generated
		 */
		EEnum PREDEFINED_FIXED_POINT_FORMAT_KIND = eINSTANCE.getPredefinedFixedPointFormatKind();

		/**
		 * The meta object literal for the '{@link org.eclipse.damos.mscript.computation.impl.NumberFormatImpl <em>Number Format</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.damos.mscript.computation.impl.NumberFormatImpl
		 * @see org.eclipse.damos.mscript.computation.impl.ComputationPackageImpl#getNumberFormat()
		 * @generated
		 */
		EClass NUMBER_FORMAT = eINSTANCE.getNumberFormat();

		/**
		 * The meta object literal for the '{@link org.eclipse.damos.mscript.computation.impl.FixedPointFormatImpl <em>Fixed Point Format</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.damos.mscript.computation.impl.FixedPointFormatImpl
		 * @see org.eclipse.damos.mscript.computation.impl.ComputationPackageImpl#getFixedPointFormat()
		 * @generated
		 */
		EClass FIXED_POINT_FORMAT = eINSTANCE.getFixedPointFormat();

		/**
		 * The meta object literal for the '<em><b>Predefined Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FIXED_POINT_FORMAT__PREDEFINED_KIND = eINSTANCE.getFixedPointFormat_PredefinedKind();

		/**
		 * The meta object literal for the '<em><b>Unsigned</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FIXED_POINT_FORMAT__UNSIGNED = eINSTANCE.getFixedPointFormat_Unsigned();

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
		 * The meta object literal for the '<em><b>Slope</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FIXED_POINT_FORMAT__SLOPE = eINSTANCE.getFixedPointFormat_Slope();

		/**
		 * The meta object literal for the '<em><b>Bias</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FIXED_POINT_FORMAT__BIAS = eINSTANCE.getFixedPointFormat_Bias();

		/**
		 * The meta object literal for the '<em><b>Saturate</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FIXED_POINT_FORMAT__SATURATE = eINSTANCE.getFixedPointFormat_Saturate();

		/**
		 * The meta object literal for the '{@link org.eclipse.damos.mscript.computation.impl.ComputationModelImpl <em>Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.damos.mscript.computation.impl.ComputationModelImpl
		 * @see org.eclipse.damos.mscript.computation.impl.ComputationPackageImpl#getComputationModel()
		 * @generated
		 */
		EClass COMPUTATION_MODEL = eINSTANCE.getComputationModel();

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
		 * The meta object literal for the '{@link org.eclipse.damos.mscript.computation.impl.NumberFormatMappingImpl <em>Number Format Mapping</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.damos.mscript.computation.impl.NumberFormatMappingImpl
		 * @see org.eclipse.damos.mscript.computation.impl.ComputationPackageImpl#getNumberFormatMapping()
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
		 * The meta object literal for the '<em><b>Number Format</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NUMBER_FORMAT_MAPPING__NUMBER_FORMAT = eINSTANCE.getNumberFormatMapping_NumberFormat();

		/**
		 * The meta object literal for the '{@link org.eclipse.damos.mscript.computation.FloatingPointFormatKind <em>Floating Point Format Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.damos.mscript.computation.FloatingPointFormatKind
		 * @see org.eclipse.damos.mscript.computation.impl.ComputationPackageImpl#getFloatingPointFormatKind()
		 * @generated
		 */
		EEnum FLOATING_POINT_FORMAT_KIND = eINSTANCE.getFloatingPointFormatKind();

	}

} //ComputationModelPackage
