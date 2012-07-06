/**
 */
package org.eclipselabs.damos.mscript.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipselabs.damos.mscript.ConstantTemplateSegment;
import org.eclipselabs.damos.mscript.MscriptPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Constant Template Segment</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.mscript.impl.ConstantTemplateSegmentImpl#getText <em>Text</em>}</li>
 *   <li>{@link org.eclipselabs.damos.mscript.impl.ConstantTemplateSegmentImpl#getNormalizedText <em>Normalized Text</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConstantTemplateSegmentImpl extends TemplateSegmentImpl implements ConstantTemplateSegment {
	/**
	 * The default value of the '{@link #getText() <em>Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getText()
	 * @generated
	 * @ordered
	 */
	protected static final String TEXT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getText() <em>Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getText()
	 * @generated
	 * @ordered
	 */
	protected String text = TEXT_EDEFAULT;

	/**
	 * The default value of the '{@link #getNormalizedText() <em>Normalized Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNormalizedText()
	 * @generated
	 * @ordered
	 */
	protected static final String NORMALIZED_TEXT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNormalizedText() <em>Normalized Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNormalizedText()
	 * @generated
	 * @ordered
	 */
	protected String normalizedText = NORMALIZED_TEXT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConstantTemplateSegmentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MscriptPackage.Literals.CONSTANT_TEMPLATE_SEGMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getText() {
		return text;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setText(String newText) {
		String oldText = text;
		text = newText;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MscriptPackage.CONSTANT_TEMPLATE_SEGMENT__TEXT, oldText, text));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getNormalizedText() {
		return normalizedText;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNormalizedText(String newNormalizedText) {
		String oldNormalizedText = normalizedText;
		normalizedText = newNormalizedText;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MscriptPackage.CONSTANT_TEMPLATE_SEGMENT__NORMALIZED_TEXT, oldNormalizedText, normalizedText));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MscriptPackage.CONSTANT_TEMPLATE_SEGMENT__TEXT:
				return getText();
			case MscriptPackage.CONSTANT_TEMPLATE_SEGMENT__NORMALIZED_TEXT:
				return getNormalizedText();
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
			case MscriptPackage.CONSTANT_TEMPLATE_SEGMENT__TEXT:
				setText((String)newValue);
				return;
			case MscriptPackage.CONSTANT_TEMPLATE_SEGMENT__NORMALIZED_TEXT:
				setNormalizedText((String)newValue);
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
			case MscriptPackage.CONSTANT_TEMPLATE_SEGMENT__TEXT:
				setText(TEXT_EDEFAULT);
				return;
			case MscriptPackage.CONSTANT_TEMPLATE_SEGMENT__NORMALIZED_TEXT:
				setNormalizedText(NORMALIZED_TEXT_EDEFAULT);
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
			case MscriptPackage.CONSTANT_TEMPLATE_SEGMENT__TEXT:
				return TEXT_EDEFAULT == null ? text != null : !TEXT_EDEFAULT.equals(text);
			case MscriptPackage.CONSTANT_TEMPLATE_SEGMENT__NORMALIZED_TEXT:
				return NORMALIZED_TEXT_EDEFAULT == null ? normalizedText != null : !NORMALIZED_TEXT_EDEFAULT.equals(normalizedText);
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
		result.append(" (text: ");
		result.append(text);
		result.append(", normalizedText: ");
		result.append(normalizedText);
		result.append(')');
		return result.toString();
	}

} //ConstantTemplateSegmentImpl
