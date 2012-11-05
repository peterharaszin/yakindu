/*******************************************************************************
 * Copyright (c) 2008, 2012 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Andreas Unger - initial API and implementation
 *******************************************************************************/
package org.eclipse.damos.mscript.computation;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Fixed Point Format</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.damos.mscript.computation.FixedPointFormat#getPredefinedKind <em>Predefined Kind</em>}</li>
 *   <li>{@link org.eclipse.damos.mscript.computation.FixedPointFormat#isUnsigned <em>Unsigned</em>}</li>
 *   <li>{@link org.eclipse.damos.mscript.computation.FixedPointFormat#getIntegerLength <em>Integer Length</em>}</li>
 *   <li>{@link org.eclipse.damos.mscript.computation.FixedPointFormat#getFractionLength <em>Fraction Length</em>}</li>
 *   <li>{@link org.eclipse.damos.mscript.computation.FixedPointFormat#getWordSize <em>Word Size</em>}</li>
 *   <li>{@link org.eclipse.damos.mscript.computation.FixedPointFormat#getSlope <em>Slope</em>}</li>
 *   <li>{@link org.eclipse.damos.mscript.computation.FixedPointFormat#getBias <em>Bias</em>}</li>
 *   <li>{@link org.eclipse.damos.mscript.computation.FixedPointFormat#isSaturate <em>Saturate</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.damos.mscript.computation.ComputationPackage#getFixedPointFormat()
 * @model
 * @generated
 */
public interface FixedPointFormat extends NumberFormat {
	/**
	 * Returns the value of the '<em><b>Predefined Kind</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.damos.mscript.computation.PredefinedFixedPointFormatKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Predefined Kind</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Predefined Kind</em>' attribute.
	 * @see org.eclipse.damos.mscript.computation.PredefinedFixedPointFormatKind
	 * @see #setPredefinedKind(PredefinedFixedPointFormatKind)
	 * @see org.eclipse.damos.mscript.computation.ComputationPackage#getFixedPointFormat_PredefinedKind()
	 * @model transient="true" volatile="true" derived="true"
	 * @generated
	 */
	PredefinedFixedPointFormatKind getPredefinedKind();

	/**
	 * Sets the value of the '{@link org.eclipse.damos.mscript.computation.FixedPointFormat#getPredefinedKind <em>Predefined Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Predefined Kind</em>' attribute.
	 * @see org.eclipse.damos.mscript.computation.PredefinedFixedPointFormatKind
	 * @see #getPredefinedKind()
	 * @generated
	 */
	void setPredefinedKind(PredefinedFixedPointFormatKind value);

	/**
	 * Returns the value of the '<em><b>Unsigned</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unsigned</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unsigned</em>' attribute.
	 * @see #setUnsigned(boolean)
	 * @see org.eclipse.damos.mscript.computation.ComputationPackage#getFixedPointFormat_Unsigned()
	 * @model
	 * @generated
	 */
	boolean isUnsigned();

	/**
	 * Sets the value of the '{@link org.eclipse.damos.mscript.computation.FixedPointFormat#isUnsigned <em>Unsigned</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unsigned</em>' attribute.
	 * @see #isUnsigned()
	 * @generated
	 */
	void setUnsigned(boolean value);

	/**
	 * Returns the value of the '<em><b>Integer Length</b></em>' attribute.
	 * The default value is <code>"1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Integer Length</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Integer Length</em>' attribute.
	 * @see #setIntegerLength(int)
	 * @see org.eclipse.damos.mscript.computation.ComputationPackage#getFixedPointFormat_IntegerLength()
	 * @model default="1" required="true" ordered="false"
	 * @generated
	 */
	int getIntegerLength();

	/**
	 * Sets the value of the '{@link org.eclipse.damos.mscript.computation.FixedPointFormat#getIntegerLength <em>Integer Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Integer Length</em>' attribute.
	 * @see #getIntegerLength()
	 * @generated
	 */
	void setIntegerLength(int value);

	/**
	 * Returns the value of the '<em><b>Fraction Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fraction Length</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fraction Length</em>' attribute.
	 * @see #setFractionLength(int)
	 * @see org.eclipse.damos.mscript.computation.ComputationPackage#getFixedPointFormat_FractionLength()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	int getFractionLength();

	/**
	 * Sets the value of the '{@link org.eclipse.damos.mscript.computation.FixedPointFormat#getFractionLength <em>Fraction Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fraction Length</em>' attribute.
	 * @see #getFractionLength()
	 * @generated
	 */
	void setFractionLength(int value);

	/**
	 * Returns the value of the '<em><b>Word Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Word Size</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Word Size</em>' attribute.
	 * @see org.eclipse.damos.mscript.computation.ComputationPackage#getFixedPointFormat_WordSize()
	 * @model required="true" transient="true" changeable="false" volatile="true" derived="true" ordered="false"
	 * @generated
	 */
	int getWordSize();

	/**
	 * Returns the value of the '<em><b>Slope</b></em>' attribute.
	 * The default value is <code>"1.0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Slope</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Slope</em>' attribute.
	 * @see #setSlope(double)
	 * @see org.eclipse.damos.mscript.computation.ComputationPackage#getFixedPointFormat_Slope()
	 * @model default="1.0" required="true" ordered="false"
	 * @generated
	 */
	double getSlope();

	/**
	 * Sets the value of the '{@link org.eclipse.damos.mscript.computation.FixedPointFormat#getSlope <em>Slope</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Slope</em>' attribute.
	 * @see #getSlope()
	 * @generated
	 */
	void setSlope(double value);

	/**
	 * Returns the value of the '<em><b>Bias</b></em>' attribute.
	 * The default value is <code>"0.0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bias</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bias</em>' attribute.
	 * @see #setBias(double)
	 * @see org.eclipse.damos.mscript.computation.ComputationPackage#getFixedPointFormat_Bias()
	 * @model default="0.0" required="true" ordered="false"
	 * @generated
	 */
	double getBias();

	/**
	 * Sets the value of the '{@link org.eclipse.damos.mscript.computation.FixedPointFormat#getBias <em>Bias</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bias</em>' attribute.
	 * @see #getBias()
	 * @generated
	 */
	void setBias(double value);

	/**
	 * Returns the value of the '<em><b>Saturate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Saturate</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Saturate</em>' attribute.
	 * @see #setSaturate(boolean)
	 * @see org.eclipse.damos.mscript.computation.ComputationPackage#getFixedPointFormat_Saturate()
	 * @model
	 * @generated
	 */
	boolean isSaturate();

	/**
	 * Sets the value of the '{@link org.eclipse.damos.mscript.computation.FixedPointFormat#isSaturate <em>Saturate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Saturate</em>' attribute.
	 * @see #isSaturate()
	 * @generated
	 */
	void setSaturate(boolean value);

} // FixedPointFormat
