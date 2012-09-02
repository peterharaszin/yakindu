/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.mscript.computation.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipselabs.damos.mscript.computation.ComputationPackage;
import org.eclipselabs.damos.mscript.computation.FixedPointFormat;
import org.eclipselabs.damos.mscript.computation.NumberFormat;
import org.eclipselabs.damos.mscript.computation.PredefinedFixedPointFormatKind;
import org.eclipselabs.damos.mscript.internal.computation.operations.FixedPointFormatOperations;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Fixed Point Format</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.mscript.computation.impl.FixedPointFormatImpl#getPredefinedKind <em>Predefined Kind</em>}</li>
 *   <li>{@link org.eclipselabs.damos.mscript.computation.impl.FixedPointFormatImpl#isUnsigned <em>Unsigned</em>}</li>
 *   <li>{@link org.eclipselabs.damos.mscript.computation.impl.FixedPointFormatImpl#getIntegerLength <em>Integer Length</em>}</li>
 *   <li>{@link org.eclipselabs.damos.mscript.computation.impl.FixedPointFormatImpl#getFractionLength <em>Fraction Length</em>}</li>
 *   <li>{@link org.eclipselabs.damos.mscript.computation.impl.FixedPointFormatImpl#getWordSize <em>Word Size</em>}</li>
 *   <li>{@link org.eclipselabs.damos.mscript.computation.impl.FixedPointFormatImpl#getSlope <em>Slope</em>}</li>
 *   <li>{@link org.eclipselabs.damos.mscript.computation.impl.FixedPointFormatImpl#getBias <em>Bias</em>}</li>
 *   <li>{@link org.eclipselabs.damos.mscript.computation.impl.FixedPointFormatImpl#isSaturate <em>Saturate</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FixedPointFormatImpl extends NumberFormatImpl implements FixedPointFormat {
	/**
	 * The default value of the '{@link #getPredefinedKind() <em>Predefined Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPredefinedKind()
	 * @generated
	 * @ordered
	 */
	protected static final PredefinedFixedPointFormatKind PREDEFINED_KIND_EDEFAULT = PredefinedFixedPointFormatKind.NONE;

	/**
	 * The default value of the '{@link #isUnsigned() <em>Unsigned</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isUnsigned()
	 * @generated
	 * @ordered
	 */
	protected static final boolean UNSIGNED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isUnsigned() <em>Unsigned</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isUnsigned()
	 * @generated
	 * @ordered
	 */
	protected boolean unsigned = UNSIGNED_EDEFAULT;

	/**
	 * The default value of the '{@link #getIntegerLength() <em>Integer Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIntegerLength()
	 * @generated
	 * @ordered
	 */
	protected static final int INTEGER_LENGTH_EDEFAULT = 1;

	/**
	 * The cached value of the '{@link #getIntegerLength() <em>Integer Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIntegerLength()
	 * @generated
	 * @ordered
	 */
	protected int integerLength = INTEGER_LENGTH_EDEFAULT;

	/**
	 * The default value of the '{@link #getFractionLength() <em>Fraction Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFractionLength()
	 * @generated
	 * @ordered
	 */
	protected static final int FRACTION_LENGTH_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getFractionLength() <em>Fraction Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFractionLength()
	 * @generated
	 * @ordered
	 */
	protected int fractionLength = FRACTION_LENGTH_EDEFAULT;

	/**
	 * The default value of the '{@link #getWordSize() <em>Word Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWordSize()
	 * @generated
	 * @ordered
	 */
	protected static final int WORD_SIZE_EDEFAULT = 0;

	/**
	 * The default value of the '{@link #getSlope() <em>Slope</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSlope()
	 * @generated
	 * @ordered
	 */
	protected static final double SLOPE_EDEFAULT = 1.0;

	/**
	 * The cached value of the '{@link #getSlope() <em>Slope</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSlope()
	 * @generated
	 * @ordered
	 */
	protected double slope = SLOPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getBias() <em>Bias</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBias()
	 * @generated
	 * @ordered
	 */
	protected static final double BIAS_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getBias() <em>Bias</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBias()
	 * @generated
	 * @ordered
	 */
	protected double bias = BIAS_EDEFAULT;

	/**
	 * The default value of the '{@link #isSaturate() <em>Saturate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSaturate()
	 * @generated
	 * @ordered
	 */
	protected static final boolean SATURATE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isSaturate() <em>Saturate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSaturate()
	 * @generated
	 * @ordered
	 */
	protected boolean saturate = SATURATE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FixedPointFormatImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ComputationPackage.Literals.FIXED_POINT_FORMAT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public PredefinedFixedPointFormatKind getPredefinedKind() {
		return FixedPointFormatOperations.getPredefinedKind(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setPredefinedKind(PredefinedFixedPointFormatKind newPredefinedKind) {
		FixedPointFormatOperations.setPredefinedKind(this, newPredefinedKind);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isUnsigned() {
		return unsigned;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnsigned(boolean newUnsigned) {
		boolean oldUnsigned = unsigned;
		unsigned = newUnsigned;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComputationPackage.FIXED_POINT_FORMAT__UNSIGNED, oldUnsigned, unsigned));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getIntegerLength() {
		return integerLength;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIntegerLength(int newIntegerLength) {
		int oldIntegerLength = integerLength;
		integerLength = newIntegerLength;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComputationPackage.FIXED_POINT_FORMAT__INTEGER_LENGTH, oldIntegerLength, integerLength));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getFractionLength() {
		return fractionLength;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFractionLength(int newFractionLength) {
		int oldFractionLength = fractionLength;
		fractionLength = newFractionLength;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComputationPackage.FIXED_POINT_FORMAT__FRACTION_LENGTH, oldFractionLength, fractionLength));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public int getWordSize() {
		return getIntegerLength() + getFractionLength();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getSlope() {
		return slope;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSlope(double newSlope) {
		double oldSlope = slope;
		slope = newSlope;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComputationPackage.FIXED_POINT_FORMAT__SLOPE, oldSlope, slope));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getBias() {
		return bias;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBias(double newBias) {
		double oldBias = bias;
		bias = newBias;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComputationPackage.FIXED_POINT_FORMAT__BIAS, oldBias, bias));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSaturate() {
		return saturate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSaturate(boolean newSaturate) {
		boolean oldSaturate = saturate;
		saturate = newSaturate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComputationPackage.FIXED_POINT_FORMAT__SATURATE, oldSaturate, saturate));
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.mscript.computation.impl.NumberFormatImpl#isEquivalentTo(org.eclipselabs.damos.mscript.computation.NumberFormat)
	 */
	@Override
	public boolean isEquivalentTo(NumberFormat other) {
		return FixedPointFormatOperations.isEquivalentTo(this, other);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ComputationPackage.FIXED_POINT_FORMAT__PREDEFINED_KIND:
				return getPredefinedKind();
			case ComputationPackage.FIXED_POINT_FORMAT__UNSIGNED:
				return isUnsigned();
			case ComputationPackage.FIXED_POINT_FORMAT__INTEGER_LENGTH:
				return getIntegerLength();
			case ComputationPackage.FIXED_POINT_FORMAT__FRACTION_LENGTH:
				return getFractionLength();
			case ComputationPackage.FIXED_POINT_FORMAT__WORD_SIZE:
				return getWordSize();
			case ComputationPackage.FIXED_POINT_FORMAT__SLOPE:
				return getSlope();
			case ComputationPackage.FIXED_POINT_FORMAT__BIAS:
				return getBias();
			case ComputationPackage.FIXED_POINT_FORMAT__SATURATE:
				return isSaturate();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ComputationPackage.FIXED_POINT_FORMAT__PREDEFINED_KIND:
				setPredefinedKind((PredefinedFixedPointFormatKind)newValue);
				return;
			case ComputationPackage.FIXED_POINT_FORMAT__UNSIGNED:
				setUnsigned((Boolean)newValue);
				return;
			case ComputationPackage.FIXED_POINT_FORMAT__INTEGER_LENGTH:
				setIntegerLength((Integer)newValue);
				return;
			case ComputationPackage.FIXED_POINT_FORMAT__FRACTION_LENGTH:
				setFractionLength((Integer)newValue);
				return;
			case ComputationPackage.FIXED_POINT_FORMAT__SLOPE:
				setSlope((Double)newValue);
				return;
			case ComputationPackage.FIXED_POINT_FORMAT__BIAS:
				setBias((Double)newValue);
				return;
			case ComputationPackage.FIXED_POINT_FORMAT__SATURATE:
				setSaturate((Boolean)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ComputationPackage.FIXED_POINT_FORMAT__PREDEFINED_KIND:
				setPredefinedKind(PREDEFINED_KIND_EDEFAULT);
				return;
			case ComputationPackage.FIXED_POINT_FORMAT__UNSIGNED:
				setUnsigned(UNSIGNED_EDEFAULT);
				return;
			case ComputationPackage.FIXED_POINT_FORMAT__INTEGER_LENGTH:
				setIntegerLength(INTEGER_LENGTH_EDEFAULT);
				return;
			case ComputationPackage.FIXED_POINT_FORMAT__FRACTION_LENGTH:
				setFractionLength(FRACTION_LENGTH_EDEFAULT);
				return;
			case ComputationPackage.FIXED_POINT_FORMAT__SLOPE:
				setSlope(SLOPE_EDEFAULT);
				return;
			case ComputationPackage.FIXED_POINT_FORMAT__BIAS:
				setBias(BIAS_EDEFAULT);
				return;
			case ComputationPackage.FIXED_POINT_FORMAT__SATURATE:
				setSaturate(SATURATE_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ComputationPackage.FIXED_POINT_FORMAT__PREDEFINED_KIND:
				return getPredefinedKind() != PREDEFINED_KIND_EDEFAULT;
			case ComputationPackage.FIXED_POINT_FORMAT__UNSIGNED:
				return unsigned != UNSIGNED_EDEFAULT;
			case ComputationPackage.FIXED_POINT_FORMAT__INTEGER_LENGTH:
				return integerLength != INTEGER_LENGTH_EDEFAULT;
			case ComputationPackage.FIXED_POINT_FORMAT__FRACTION_LENGTH:
				return fractionLength != FRACTION_LENGTH_EDEFAULT;
			case ComputationPackage.FIXED_POINT_FORMAT__WORD_SIZE:
				return getWordSize() != WORD_SIZE_EDEFAULT;
			case ComputationPackage.FIXED_POINT_FORMAT__SLOPE:
				return slope != SLOPE_EDEFAULT;
			case ComputationPackage.FIXED_POINT_FORMAT__BIAS:
				return bias != BIAS_EDEFAULT;
			case ComputationPackage.FIXED_POINT_FORMAT__SATURATE:
				return saturate != SATURATE_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (unsigned: ");
		result.append(unsigned);
		result.append(", integerLength: ");
		result.append(integerLength);
		result.append(", fractionLength: ");
		result.append(fractionLength);
		result.append(", slope: ");
		result.append(slope);
		result.append(", bias: ");
		result.append(bias);
		result.append(", saturate: ");
		result.append(saturate);
		result.append(')');
		return result.toString();
	}

} //FixedPointFormatImpl
