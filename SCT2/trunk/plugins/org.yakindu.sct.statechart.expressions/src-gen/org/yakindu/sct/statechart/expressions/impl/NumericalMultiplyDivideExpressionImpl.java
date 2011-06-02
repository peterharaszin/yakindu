/**
 * <copyright>
 * </copyright>
 *

 */
package org.yakindu.sct.statechart.expressions.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.yakindu.sct.statechart.expressions.Expression;
import org.yakindu.sct.statechart.expressions.ExpressionsPackage;
import org.yakindu.sct.statechart.expressions.MultiplicativeOperator;
import org.yakindu.sct.statechart.expressions.NumericalMultiplyDivideExpression;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Numerical Multiply Divide Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.yakindu.sct.statechart.expressions.impl.NumericalMultiplyDivideExpressionImpl#getLeftOperand <em>Left Operand</em>}</li>
 *   <li>{@link org.yakindu.sct.statechart.expressions.impl.NumericalMultiplyDivideExpressionImpl#getOperator <em>Operator</em>}</li>
 *   <li>{@link org.yakindu.sct.statechart.expressions.impl.NumericalMultiplyDivideExpressionImpl#getRightOperand <em>Right Operand</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NumericalMultiplyDivideExpressionImpl extends ExpressionImpl implements NumericalMultiplyDivideExpression
{
  /**
   * The cached value of the '{@link #getLeftOperand() <em>Left Operand</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLeftOperand()
   * @generated
   * @ordered
   */
  protected Expression leftOperand;

  /**
   * The default value of the '{@link #getOperator() <em>Operator</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOperator()
   * @generated
   * @ordered
   */
  protected static final MultiplicativeOperator OPERATOR_EDEFAULT = MultiplicativeOperator.MUL;

  /**
   * The cached value of the '{@link #getOperator() <em>Operator</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOperator()
   * @generated
   * @ordered
   */
  protected MultiplicativeOperator operator = OPERATOR_EDEFAULT;

  /**
   * The cached value of the '{@link #getRightOperand() <em>Right Operand</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRightOperand()
   * @generated
   * @ordered
   */
  protected Expression rightOperand;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected NumericalMultiplyDivideExpressionImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return ExpressionsPackage.Literals.NUMERICAL_MULTIPLY_DIVIDE_EXPRESSION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expression getLeftOperand()
  {
    return leftOperand;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetLeftOperand(Expression newLeftOperand, NotificationChain msgs)
  {
    Expression oldLeftOperand = leftOperand;
    leftOperand = newLeftOperand;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ExpressionsPackage.NUMERICAL_MULTIPLY_DIVIDE_EXPRESSION__LEFT_OPERAND, oldLeftOperand, newLeftOperand);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setLeftOperand(Expression newLeftOperand)
  {
    if (newLeftOperand != leftOperand)
    {
      NotificationChain msgs = null;
      if (leftOperand != null)
        msgs = ((InternalEObject)leftOperand).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ExpressionsPackage.NUMERICAL_MULTIPLY_DIVIDE_EXPRESSION__LEFT_OPERAND, null, msgs);
      if (newLeftOperand != null)
        msgs = ((InternalEObject)newLeftOperand).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ExpressionsPackage.NUMERICAL_MULTIPLY_DIVIDE_EXPRESSION__LEFT_OPERAND, null, msgs);
      msgs = basicSetLeftOperand(newLeftOperand, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.NUMERICAL_MULTIPLY_DIVIDE_EXPRESSION__LEFT_OPERAND, newLeftOperand, newLeftOperand));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MultiplicativeOperator getOperator()
  {
    return operator;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setOperator(MultiplicativeOperator newOperator)
  {
    MultiplicativeOperator oldOperator = operator;
    operator = newOperator == null ? OPERATOR_EDEFAULT : newOperator;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.NUMERICAL_MULTIPLY_DIVIDE_EXPRESSION__OPERATOR, oldOperator, operator));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expression getRightOperand()
  {
    return rightOperand;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetRightOperand(Expression newRightOperand, NotificationChain msgs)
  {
    Expression oldRightOperand = rightOperand;
    rightOperand = newRightOperand;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ExpressionsPackage.NUMERICAL_MULTIPLY_DIVIDE_EXPRESSION__RIGHT_OPERAND, oldRightOperand, newRightOperand);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRightOperand(Expression newRightOperand)
  {
    if (newRightOperand != rightOperand)
    {
      NotificationChain msgs = null;
      if (rightOperand != null)
        msgs = ((InternalEObject)rightOperand).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ExpressionsPackage.NUMERICAL_MULTIPLY_DIVIDE_EXPRESSION__RIGHT_OPERAND, null, msgs);
      if (newRightOperand != null)
        msgs = ((InternalEObject)newRightOperand).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ExpressionsPackage.NUMERICAL_MULTIPLY_DIVIDE_EXPRESSION__RIGHT_OPERAND, null, msgs);
      msgs = basicSetRightOperand(newRightOperand, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.NUMERICAL_MULTIPLY_DIVIDE_EXPRESSION__RIGHT_OPERAND, newRightOperand, newRightOperand));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case ExpressionsPackage.NUMERICAL_MULTIPLY_DIVIDE_EXPRESSION__LEFT_OPERAND:
        return basicSetLeftOperand(null, msgs);
      case ExpressionsPackage.NUMERICAL_MULTIPLY_DIVIDE_EXPRESSION__RIGHT_OPERAND:
        return basicSetRightOperand(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case ExpressionsPackage.NUMERICAL_MULTIPLY_DIVIDE_EXPRESSION__LEFT_OPERAND:
        return getLeftOperand();
      case ExpressionsPackage.NUMERICAL_MULTIPLY_DIVIDE_EXPRESSION__OPERATOR:
        return getOperator();
      case ExpressionsPackage.NUMERICAL_MULTIPLY_DIVIDE_EXPRESSION__RIGHT_OPERAND:
        return getRightOperand();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case ExpressionsPackage.NUMERICAL_MULTIPLY_DIVIDE_EXPRESSION__LEFT_OPERAND:
        setLeftOperand((Expression)newValue);
        return;
      case ExpressionsPackage.NUMERICAL_MULTIPLY_DIVIDE_EXPRESSION__OPERATOR:
        setOperator((MultiplicativeOperator)newValue);
        return;
      case ExpressionsPackage.NUMERICAL_MULTIPLY_DIVIDE_EXPRESSION__RIGHT_OPERAND:
        setRightOperand((Expression)newValue);
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
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case ExpressionsPackage.NUMERICAL_MULTIPLY_DIVIDE_EXPRESSION__LEFT_OPERAND:
        setLeftOperand((Expression)null);
        return;
      case ExpressionsPackage.NUMERICAL_MULTIPLY_DIVIDE_EXPRESSION__OPERATOR:
        setOperator(OPERATOR_EDEFAULT);
        return;
      case ExpressionsPackage.NUMERICAL_MULTIPLY_DIVIDE_EXPRESSION__RIGHT_OPERAND:
        setRightOperand((Expression)null);
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
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case ExpressionsPackage.NUMERICAL_MULTIPLY_DIVIDE_EXPRESSION__LEFT_OPERAND:
        return leftOperand != null;
      case ExpressionsPackage.NUMERICAL_MULTIPLY_DIVIDE_EXPRESSION__OPERATOR:
        return operator != OPERATOR_EDEFAULT;
      case ExpressionsPackage.NUMERICAL_MULTIPLY_DIVIDE_EXPRESSION__RIGHT_OPERAND:
        return rightOperand != null;
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (operator: ");
    result.append(operator);
    result.append(')');
    return result.toString();
  }

} //NumericalMultiplyDivideExpressionImpl
