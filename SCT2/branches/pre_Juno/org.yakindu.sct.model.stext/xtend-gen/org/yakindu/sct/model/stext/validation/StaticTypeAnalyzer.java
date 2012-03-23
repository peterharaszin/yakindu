package org.yakindu.sct.model.stext.validation;

import com.google.common.base.Objects;
import java.io.Serializable;
import java.util.Arrays;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.yakindu.base.base.NamedElement;
import org.yakindu.base.types.Feature;
import org.yakindu.base.types.Type;
import org.yakindu.sct.model.sgraph.Statement;
import org.yakindu.sct.model.stext.stext.AdditiveOperator;
import org.yakindu.sct.model.stext.stext.AssignmentExpression;
import org.yakindu.sct.model.stext.stext.BitwiseAndExpression;
import org.yakindu.sct.model.stext.stext.BitwiseOrExpression;
import org.yakindu.sct.model.stext.stext.BitwiseXorExpression;
import org.yakindu.sct.model.stext.stext.BoolLiteral;
import org.yakindu.sct.model.stext.stext.ConditionalExpression;
import org.yakindu.sct.model.stext.stext.EventDefinition;
import org.yakindu.sct.model.stext.stext.EventRaisingExpression;
import org.yakindu.sct.model.stext.stext.EventValueReferenceExpression;
import org.yakindu.sct.model.stext.stext.Expression;
import org.yakindu.sct.model.stext.stext.FeatureCall;
import org.yakindu.sct.model.stext.stext.IntLiteral;
import org.yakindu.sct.model.stext.stext.Literal;
import org.yakindu.sct.model.stext.stext.LogicalAndExpression;
import org.yakindu.sct.model.stext.stext.LogicalNotExpression;
import org.yakindu.sct.model.stext.stext.LogicalOrExpression;
import org.yakindu.sct.model.stext.stext.LogicalRelationExpression;
import org.yakindu.sct.model.stext.stext.MultiplicativeOperator;
import org.yakindu.sct.model.stext.stext.NumericalAddSubtractExpression;
import org.yakindu.sct.model.stext.stext.NumericalMultiplyDivideExpression;
import org.yakindu.sct.model.stext.stext.NumericalUnaryExpression;
import org.yakindu.sct.model.stext.stext.PrimitiveValueExpression;
import org.yakindu.sct.model.stext.stext.RealLiteral;
import org.yakindu.sct.model.stext.stext.RelationalOperator;
import org.yakindu.sct.model.stext.stext.ShiftExpression;
import org.yakindu.sct.model.stext.stext.TypedElementReferenceExpression;
import org.yakindu.sct.model.stext.stext.UnaryOperator;
import org.yakindu.sct.model.stext.stext.VariableDefinition;
import org.yakindu.sct.model.stext.validation.TypeCheckException;

/**
 * The Static type analyzer checks an expression AST for type conformance
 * 
 * @author andreas muelder - Initial contribution and API
 */
@SuppressWarnings("all")
public class StaticTypeAnalyzer {
  public boolean isBoolean(final Type type) {
    boolean _and = false;
    boolean _notEquals = (!Objects.equal(type, null));
    if (!_notEquals) {
      _and = false;
    } else {
      String _name = type.getName();
      boolean _equals = Objects.equal(_name, "boolean");
      _and = (_notEquals && _equals);
    }
    return _and;
  }
  
  public boolean isInteger(final Type type) {
    boolean _and = false;
    boolean _notEquals = (!Objects.equal(type, null));
    if (!_notEquals) {
      _and = false;
    } else {
      boolean _or = false;
      String _name = type.getName();
      boolean _equals = Objects.equal(_name, "integer");
      if (_equals) {
        _or = true;
      } else {
        String _name_1 = type.getName();
        boolean _equals_1 = Objects.equal(_name_1, "int");
        _or = (_equals || _equals_1);
      }
      _and = (_notEquals && _or);
    }
    return _and;
  }
  
  public boolean isReal(final Type type) {
    boolean _and = false;
    boolean _notEquals = (!Objects.equal(type, null));
    if (!_notEquals) {
      _and = false;
    } else {
      String _name = type.getName();
      boolean _equals = Objects.equal(_name, "real");
      _and = (_notEquals && _equals);
    }
    return _and;
  }
  
  protected Class<? extends Object> _check(final Statement statement) throws TypeCheckException {
    return null;
  }
  
  /**
   * Check Variable assignments
   */
  protected Class<? extends Object> _check(final AssignmentExpression assignment) throws TypeCheckException {
    Expression _expression = assignment.getExpression();
    Class<? extends Object> valueType = this.check(_expression);
    Expression _varRef = assignment.getVarRef();
    Class<? extends Object> type = this.check(_varRef);
    boolean _and = false;
    boolean _equals = Objects.equal(type, Boolean.class);
    if (!_equals) {
      _and = false;
    } else {
      boolean _equals_1 = Objects.equal(valueType, Boolean.class);
      boolean _not = (!_equals_1);
      _and = (_equals && _not);
    }
    if (_and) {
      String _simpleName = valueType.getSimpleName();
      String _plus = ("Can not assign a value of type " + _simpleName);
      String _plus_1 = (_plus + " to a variable of type ");
      String _plus_2 = (_plus_1 + type);
      this.error(_plus_2);
    } else {
      boolean _and_1 = false;
      boolean _equals_2 = Objects.equal(type, Number.class);
      if (!_equals_2) {
        _and_1 = false;
      } else {
        boolean _equals_3 = Objects.equal(valueType, Number.class);
        boolean _not_1 = (!_equals_3);
        _and_1 = (_equals_2 && _not_1);
      }
      if (_and_1) {
        String _simpleName_1 = valueType.getSimpleName();
        String _plus_3 = ("Can not assign a value of type " + _simpleName_1);
        String _plus_4 = (_plus_3 + " to a variable of type ");
        String _plus_5 = (_plus_4 + type);
        this.error(_plus_5);
      }
    }
    return null;
  }
  
  /**
   * Check Event value assignments
   */
  protected Class<? extends Object> _check(final EventRaisingExpression eventRaising) throws TypeCheckException {
    Expression _value = eventRaising.getValue();
    Class<? extends Object> valueType = this.check(_value);
    Expression _event = eventRaising.getEvent();
    Class<? extends Object> type = this.check(_event);
    boolean _and = false;
    boolean _equals = Objects.equal(type, Boolean.class);
    if (!_equals) {
      _and = false;
    } else {
      boolean _equals_1 = Objects.equal(valueType, Boolean.class);
      boolean _not = (!_equals_1);
      _and = (_equals && _not);
    }
    if (_and) {
      String _simpleName = valueType.getSimpleName();
      String _plus = ("Can not assign a value of type " + _simpleName);
      String _plus_1 = (_plus + " to an event of type ");
      String _plus_2 = (_plus_1 + type);
      this.error(_plus_2);
    } else {
      boolean _and_1 = false;
      boolean _equals_2 = Objects.equal(type, Number.class);
      if (!_equals_2) {
        _and_1 = false;
      } else {
        boolean _equals_3 = Objects.equal(valueType, Number.class);
        boolean _not_1 = (!_equals_3);
        _and_1 = (_equals_2 && _not_1);
      }
      if (_and_1) {
        String _simpleName_1 = valueType.getSimpleName();
        String _plus_3 = ("Can not assign a value of type " + _simpleName_1);
        String _plus_4 = (_plus_3 + " to an event of type ");
        String _plus_5 = (_plus_4 + type);
        this.error(_plus_5);
      }
    }
    return null;
  }
  
  protected Class<? extends Object> _check(final LogicalAndExpression expression) throws TypeCheckException {
    Class<Boolean> _xblockexpression = null;
    {
      Expression _leftOperand = expression.getLeftOperand();
      Class<? extends Object> _check = this.check(_leftOperand);
      this.assertIsBoolean(_check, "&&");
      Expression _rightOperand = expression.getRightOperand();
      Class<? extends Object> _check_1 = this.check(_rightOperand);
      this.assertIsBoolean(_check_1, "&&");
      _xblockexpression = (Boolean.class);
    }
    return _xblockexpression;
  }
  
  protected Class<? extends Object> _check(final LogicalOrExpression expression) throws TypeCheckException {
    Class<Boolean> _xblockexpression = null;
    {
      Expression _leftOperand = expression.getLeftOperand();
      Class<? extends Object> _check = this.check(_leftOperand);
      this.assertIsBoolean(_check, "||");
      Expression _rightOperand = expression.getRightOperand();
      Class<? extends Object> _check_1 = this.check(_rightOperand);
      this.assertIsBoolean(_check_1, "||");
      _xblockexpression = (Boolean.class);
    }
    return _xblockexpression;
  }
  
  protected Class<? extends Object> _check(final LogicalNotExpression expression) throws TypeCheckException {
    Class<Boolean> _xblockexpression = null;
    {
      Expression _operand = expression.getOperand();
      Class<? extends Object> _check = this.check(_operand);
      this.assertIsBoolean(_check, "!");
      _xblockexpression = (Boolean.class);
    }
    return _xblockexpression;
  }
  
  protected Class<? extends Object> _check(final BitwiseAndExpression expression) throws TypeCheckException {
    Class<Number> _xblockexpression = null;
    {
      Expression _leftOperand = expression.getLeftOperand();
      Class<? extends Object> _check = this.check(_leftOperand);
      this.assertIsNumber(_check, "&");
      Expression _rightOperand = expression.getRightOperand();
      Class<? extends Object> _check_1 = this.check(_rightOperand);
      this.assertIsNumber(_check_1, "&");
      _xblockexpression = (Number.class);
    }
    return _xblockexpression;
  }
  
  protected Class<? extends Object> _check(final BitwiseOrExpression expression) throws TypeCheckException {
    Class<Number> _xblockexpression = null;
    {
      Expression _leftOperand = expression.getLeftOperand();
      Class<? extends Object> _check = this.check(_leftOperand);
      this.assertIsNumber(_check, "|");
      Expression _rightOperand = expression.getRightOperand();
      Class<? extends Object> _check_1 = this.check(_rightOperand);
      this.assertIsNumber(_check_1, "|");
      _xblockexpression = (Number.class);
    }
    return _xblockexpression;
  }
  
  protected Class<? extends Object> _check(final BitwiseXorExpression expression) throws TypeCheckException {
    Class<Number> _xblockexpression = null;
    {
      Expression _leftOperand = expression.getLeftOperand();
      Class<? extends Object> _check = this.check(_leftOperand);
      this.assertIsNumber(_check, "^");
      Expression _rightOperand = expression.getRightOperand();
      Class<? extends Object> _check_1 = this.check(_rightOperand);
      this.assertIsNumber(_check_1, "^");
      _xblockexpression = (Number.class);
    }
    return _xblockexpression;
  }
  
  protected Class<? extends Object> _check(final LogicalRelationExpression expression) throws TypeCheckException {
    Expression _leftOperand = expression.getLeftOperand();
    Class<? extends Object> leftType = this.check(_leftOperand);
    Expression _rightOperand = expression.getRightOperand();
    Class<? extends Object> rightType = this.check(_rightOperand);
    boolean _notEquals = (!Objects.equal(leftType, rightType));
    if (_notEquals) {
      String _name = leftType.getName();
      String _plus = ("Incompatible operands " + _name);
      String _plus_1 = (_plus + " and ");
      String _name_1 = rightType.getName();
      String _plus_2 = (_plus_1 + _name_1);
      String _plus_3 = (_plus_2 + " for operator \'");
      RelationalOperator _operator = expression.getOperator();
      String _literal = _operator.getLiteral();
      String _plus_4 = (_plus_3 + _literal);
      String _plus_5 = (_plus_4 + "\'");
      this.error(_plus_5);
    }
    boolean _and = false;
    boolean _equals = Objects.equal(leftType, Boolean.class);
    if (!_equals) {
      _and = false;
    } else {
      boolean _equals_1 = Objects.equal(rightType, Boolean.class);
      _and = (_equals && _equals_1);
    }
    if (_and) {
      boolean _and_1 = false;
      RelationalOperator _operator_1 = expression.getOperator();
      boolean _notEquals_1 = (!Objects.equal(_operator_1, RelationalOperator.EQUALS));
      if (!_notEquals_1) {
        _and_1 = false;
      } else {
        RelationalOperator _operator_2 = expression.getOperator();
        boolean _notEquals_2 = (!Objects.equal(_operator_2, RelationalOperator.NOT_EQUALS));
        _and_1 = (_notEquals_1 && _notEquals_2);
      }
      if (_and_1) {
        RelationalOperator _operator_3 = expression.getOperator();
        String _literal_1 = _operator_3.getLiteral();
        String _plus_6 = ("operator \'" + _literal_1);
        String _plus_7 = (_plus_6 + "\' can not be applied to boolean values!");
        this.error(_plus_7);
      }
    }
    return Boolean.class;
  }
  
  protected Class<? extends Object> _check(final NumericalAddSubtractExpression expression) {
    try {
      Class<Number> _xblockexpression = null;
      {
        Expression _leftOperand = expression.getLeftOperand();
        Class<? extends Object> _check = this.check(_leftOperand);
        AdditiveOperator _operator = expression.getOperator();
        String _literal = _operator.getLiteral();
        this.assertIsNumber(_check, _literal);
        Expression _rightOperand = expression.getRightOperand();
        Class<? extends Object> _check_1 = this.check(_rightOperand);
        AdditiveOperator _operator_1 = expression.getOperator();
        String _literal_1 = _operator_1.getLiteral();
        this.assertIsNumber(_check_1, _literal_1);
        _xblockexpression = (Number.class);
      }
      return _xblockexpression;
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected Class<? extends Object> _check(final NumericalMultiplyDivideExpression expression) {
    try {
      Class<Number> _xblockexpression = null;
      {
        Expression _leftOperand = expression.getLeftOperand();
        Class<? extends Object> _check = this.check(_leftOperand);
        MultiplicativeOperator _operator = expression.getOperator();
        String _literal = _operator.getLiteral();
        this.assertIsNumber(_check, _literal);
        Expression _rightOperand = expression.getRightOperand();
        Class<? extends Object> _check_1 = this.check(_rightOperand);
        MultiplicativeOperator _operator_1 = expression.getOperator();
        String _literal_1 = _operator_1.getLiteral();
        this.assertIsNumber(_check_1, _literal_1);
        _xblockexpression = (Number.class);
      }
      return _xblockexpression;
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected Class<? extends Object> _check(final NumericalUnaryExpression expression) {
    try {
      Class<Number> _xblockexpression = null;
      {
        Expression _operand = expression.getOperand();
        Class<? extends Object> _check = this.check(_operand);
        UnaryOperator _operator = expression.getOperator();
        String _literal = _operator.getLiteral();
        this.assertIsNumber(_check, _literal);
        _xblockexpression = (Number.class);
      }
      return _xblockexpression;
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected Class<? extends Object> _check(final PrimitiveValueExpression expression) {
    Literal _value = expression.getValue();
    Class<? extends Serializable> _type = this.type(_value);
    return _type;
  }
  
  protected Class<? extends Object> _check(final ShiftExpression expression) {
    return null;
  }
  
  protected Class<? extends Object> _check(final ConditionalExpression expression) {
    return null;
  }
  
  protected Class<? extends Object> _check(final FeatureCall featureCall) {
    Feature _feature = featureCall.getFeature();
    Type _type = _feature.getType();
    return this.toJavaType(_type);
  }
  
  protected Class<? extends Object> _check(final TypedElementReferenceExpression expression) {
    Class<? extends Object> _xblockexpression = null;
    {
      NamedElement reference = expression.getReference();
      if ((reference instanceof VariableDefinition)) {
        Type _type = ((VariableDefinition) reference).getType();
        return this.toJavaType(_type);
      }
      if ((reference instanceof EventDefinition)) {
        return Boolean.class;
      }
      _xblockexpression = (null);
    }
    return _xblockexpression;
  }
  
  protected Class<? extends Object> _check(final EventValueReferenceExpression expression) {
    return null;
  }
  
  protected Class<? extends Serializable> _type(final IntLiteral literal) {
    return Number.class;
  }
  
  protected Class<? extends Serializable> _type(final BoolLiteral bool) {
    return Boolean.class;
  }
  
  protected Class<? extends Serializable> _type(final RealLiteral literal) {
    return Number.class;
  }
  
  public Class<? extends Object> toJavaType(final Type type) {
    boolean _isBoolean = this.isBoolean(type);
    if (_isBoolean) {
      return Boolean.class;
    } else {
      boolean _isInteger = this.isInteger(type);
      if (_isInteger) {
        return Number.class;
      } else {
        boolean _isReal = this.isReal(type);
        if (_isReal) {
          return Number.class;
        }
      }
    }
    return Void.class;
  }
  
  public void assertIsNumber(final Object object, final String operator) throws TypeCheckException {
    boolean _equals = Objects.equal(object, Number.class);
    boolean _not = (!_equals);
    if (_not) {
      String _plus = ("operator \'" + operator);
      String _plus_1 = (_plus + "\' can only be applied to numbers!");
      this.error(_plus_1);
    }
  }
  
  public void assertIsBoolean(final Object object, final String operator) throws TypeCheckException {
    boolean _equals = Objects.equal(object, Boolean.class);
    boolean _not = (!_equals);
    if (_not) {
      String _plus = ("operator \'" + operator);
      String _plus_1 = (_plus + "\' can only be applied to boolean values!");
      this.error(_plus_1);
    }
  }
  
  public void error(final String msg) throws TypeCheckException {
    TypeCheckException _typeCheckException = new TypeCheckException(msg);
    throw _typeCheckException;
  }
  
  public Class<? extends Object> check(final Statement assignment) throws TypeCheckException {
    if (assignment instanceof AssignmentExpression) {
      return _check((AssignmentExpression)assignment);
    } else if (assignment instanceof BitwiseAndExpression) {
      return _check((BitwiseAndExpression)assignment);
    } else if (assignment instanceof BitwiseOrExpression) {
      return _check((BitwiseOrExpression)assignment);
    } else if (assignment instanceof BitwiseXorExpression) {
      return _check((BitwiseXorExpression)assignment);
    } else if (assignment instanceof ConditionalExpression) {
      return _check((ConditionalExpression)assignment);
    } else if (assignment instanceof EventRaisingExpression) {
      return _check((EventRaisingExpression)assignment);
    } else if (assignment instanceof EventValueReferenceExpression) {
      return _check((EventValueReferenceExpression)assignment);
    } else if (assignment instanceof FeatureCall) {
      return _check((FeatureCall)assignment);
    } else if (assignment instanceof LogicalAndExpression) {
      return _check((LogicalAndExpression)assignment);
    } else if (assignment instanceof LogicalNotExpression) {
      return _check((LogicalNotExpression)assignment);
    } else if (assignment instanceof LogicalOrExpression) {
      return _check((LogicalOrExpression)assignment);
    } else if (assignment instanceof LogicalRelationExpression) {
      return _check((LogicalRelationExpression)assignment);
    } else if (assignment instanceof NumericalAddSubtractExpression) {
      return _check((NumericalAddSubtractExpression)assignment);
    } else if (assignment instanceof NumericalMultiplyDivideExpression) {
      return _check((NumericalMultiplyDivideExpression)assignment);
    } else if (assignment instanceof NumericalUnaryExpression) {
      return _check((NumericalUnaryExpression)assignment);
    } else if (assignment instanceof PrimitiveValueExpression) {
      return _check((PrimitiveValueExpression)assignment);
    } else if (assignment instanceof ShiftExpression) {
      return _check((ShiftExpression)assignment);
    } else if (assignment instanceof TypedElementReferenceExpression) {
      return _check((TypedElementReferenceExpression)assignment);
    } else if (assignment != null) {
      return _check(assignment);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(assignment).toString());
    }
  }
  
  public Class<? extends Serializable> type(final Literal bool) {
    if (bool instanceof BoolLiteral) {
      return _type((BoolLiteral)bool);
    } else if (bool instanceof IntLiteral) {
      return _type((IntLiteral)bool);
    } else if (bool instanceof RealLiteral) {
      return _type((RealLiteral)bool);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(bool).toString());
    }
  }
}
