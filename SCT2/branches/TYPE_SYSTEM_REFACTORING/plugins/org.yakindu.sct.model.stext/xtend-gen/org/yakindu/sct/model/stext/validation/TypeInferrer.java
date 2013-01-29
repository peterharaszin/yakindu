package org.yakindu.sct.model.stext.validation;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.yakindu.base.types.EnumerationType;
import org.yakindu.base.types.Event;
import org.yakindu.base.types.Feature;
import org.yakindu.base.types.ITypeSystemAccess;
import org.yakindu.base.types.PrimitiveType;
import org.yakindu.base.types.Property;
import org.yakindu.base.types.Type;
import org.yakindu.sct.model.sgraph.Statement;
import org.yakindu.sct.model.stext.stext.ActiveStateReferenceExpression;
import org.yakindu.sct.model.stext.stext.AdditiveOperator;
import org.yakindu.sct.model.stext.stext.AssignmentExpression;
import org.yakindu.sct.model.stext.stext.BitwiseAndExpression;
import org.yakindu.sct.model.stext.stext.BitwiseOrExpression;
import org.yakindu.sct.model.stext.stext.BitwiseXorExpression;
import org.yakindu.sct.model.stext.stext.BoolLiteral;
import org.yakindu.sct.model.stext.stext.ConditionalExpression;
import org.yakindu.sct.model.stext.stext.ElementReferenceExpression;
import org.yakindu.sct.model.stext.stext.EnumLiteral;
import org.yakindu.sct.model.stext.stext.EventRaisingExpression;
import org.yakindu.sct.model.stext.stext.EventValueReferenceExpression;
import org.yakindu.sct.model.stext.stext.Expression;
import org.yakindu.sct.model.stext.stext.FeatureCall;
import org.yakindu.sct.model.stext.stext.HexLiteral;
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
import org.yakindu.sct.model.stext.stext.OperationDefinition;
import org.yakindu.sct.model.stext.stext.ParenthesizedExpression;
import org.yakindu.sct.model.stext.stext.PrimitiveValueExpression;
import org.yakindu.sct.model.stext.stext.RealLiteral;
import org.yakindu.sct.model.stext.stext.RelationalOperator;
import org.yakindu.sct.model.stext.stext.ShiftExpression;
import org.yakindu.sct.model.stext.stext.ShiftOperator;
import org.yakindu.sct.model.stext.stext.StringLiteral;
import org.yakindu.sct.model.stext.stext.UnaryOperator;
import org.yakindu.sct.model.stext.validation.ITypeInferrer;
import org.yakindu.sct.model.stext.validation.TypeCheckException;
import org.yakindu.sct.model.stext.validation.TypeInferrerCache;
import org.yakindu.sct.model.stext.validation.TypeInferrerCache.ICacheableTypeAnalyzer;

/**
 * The TypeInferrer checks an expression AST for type conformance
 * 
 * @author andreas muelder - Initial contribution and API
 * @author Alexander Nyßen - Adopted to changes in type system
 */
@SuppressWarnings("all")
public class TypeInferrer implements ITypeInferrer, ICacheableTypeAnalyzer {
  @Inject
  protected ITypeSystemAccess ts;
  
  @Inject
  private TypeInferrerCache cache;
  
  public Collection<? extends Type> getTypes(final Statement stmt) {
    Collection<? extends Type> _xblockexpression = null;
    {
      boolean _equals = Objects.equal(stmt, null);
      if (_equals) {
        return CollectionLiterals.<Type>newArrayList();
      }
      Collection<? extends Type> _get = this.cache.get(stmt, this);
      _xblockexpression = (_get);
    }
    return _xblockexpression;
  }
  
  protected Collection<? extends Type> _inferType(final Expression expr) {
    String _plus = ("Unsupported expression type" + expr);
    RuntimeException _runtimeException = new RuntimeException(_plus);
    throw _runtimeException;
  }
  
  protected Collection<? extends Type> _inferType(final Statement stmt) {
    String _plus = ("Unsupported statement type" + stmt);
    RuntimeException _runtimeException = new RuntimeException(_plus);
    throw _runtimeException;
  }
  
  protected Collection<? extends Type> _inferType(final AssignmentExpression assignment) {
    Expression _expression = assignment.getExpression();
    Collection<? extends Type> valueTypes = this.getTypes(_expression);
    Expression _varRef = assignment.getVarRef();
    Collection<? extends Type> varTypes = this.getTypes(_varRef);
    Collection<Type> types = this.ts.assign(varTypes, valueTypes);
    boolean _isEmpty = types.isEmpty();
    if (_isEmpty) {
      final Function1<Type,String> _function = new Function1<Type,String>() {
          public String apply(final Type t) {
            String _name = t.getName();
            return _name;
          }
        };
      Iterable<String> _map = IterableExtensions.map(valueTypes, _function);
      String _join = IterableExtensions.join(_map, ",");
      String _plus = ("Can not assign a value of type " + _join);
      String _plus_1 = (_plus + " to a variable of type ");
      final Function1<Type,String> _function_1 = new Function1<Type,String>() {
          public String apply(final Type t) {
            String _name = t.getName();
            return _name;
          }
        };
      Iterable<String> _map_1 = IterableExtensions.map(varTypes, _function_1);
      String _join_1 = IterableExtensions.join(_map_1, ",");
      String _plus_2 = (_plus_1 + _join_1);
      this.error(_plus_2);
      return CollectionLiterals.<Type>newArrayList();
    }
    return types;
  }
  
  /**
   * Check Event value assignments
   */
  protected Collection<? extends Type> _inferType(final EventRaisingExpression eventRaising) {
    Expression _event = eventRaising.getEvent();
    Collection<? extends Type> eventTypes = this.getTypes(_event);
    Expression _value = eventRaising.getValue();
    boolean _equals = Objects.equal(_value, null);
    if (_equals) {
      List<PrimitiveType> _voidTypes = this.ts.getVoidTypes(eventTypes);
      boolean _isEmpty = _voidTypes.isEmpty();
      if (_isEmpty) {
        final Function1<Type,String> _function = new Function1<Type,String>() {
            public String apply(final Type t) {
              String _name = t.getName();
              return _name;
            }
          };
        Iterable<String> _map = IterableExtensions.map(eventTypes, _function);
        String _join = IterableExtensions.join(_map, ",");
        String _plus = ("Need to assign a value to an event of type " + _join);
        this.error(_plus);
        return CollectionLiterals.<Type>newArrayList();
      }
      return this.getVoidTypes();
    }
    Expression _value_1 = eventRaising.getValue();
    Collection<? extends Type> valueTypes = this.getTypes(_value_1);
    Collection<Type> types = this.ts.assign(eventTypes, valueTypes);
    boolean _isEmpty_1 = types.isEmpty();
    if (_isEmpty_1) {
      final Function1<Type,String> _function_1 = new Function1<Type,String>() {
          public String apply(final Type t) {
            String _name = t.getName();
            return _name;
          }
        };
      Iterable<String> _map_1 = IterableExtensions.map(valueTypes, _function_1);
      String _join_1 = IterableExtensions.join(_map_1, ",");
      String _plus_1 = ("Can not assign a value of type " + _join_1);
      String _plus_2 = (_plus_1 + " to an event of type ");
      final Function1<Type,String> _function_2 = new Function1<Type,String>() {
          public String apply(final Type t) {
            String _name = t.getName();
            return _name;
          }
        };
      Iterable<String> _map_2 = IterableExtensions.map(eventTypes, _function_2);
      String _join_2 = IterableExtensions.join(_map_2, ",");
      String _plus_3 = (_plus_2 + _join_2);
      this.error(_plus_3);
      return CollectionLiterals.<Type>newArrayList();
    }
    return types;
  }
  
  protected Collection<? extends Type> _inferType(final LogicalAndExpression expression) {
    Expression _leftOperand = expression.getLeftOperand();
    Collection<? extends Type> _types = this.getTypes(_leftOperand);
    Expression _rightOperand = expression.getRightOperand();
    Collection<? extends Type> _types_1 = this.getTypes(_rightOperand);
    return this.assertBooleanTypes(_types, _types_1, "&&");
  }
  
  protected Collection<? extends Type> _inferType(final LogicalOrExpression expression) {
    Expression _leftOperand = expression.getLeftOperand();
    Collection<? extends Type> _types = this.getTypes(_leftOperand);
    Expression _rightOperand = expression.getRightOperand();
    Collection<? extends Type> _types_1 = this.getTypes(_rightOperand);
    return this.assertBooleanTypes(_types, _types_1, "||");
  }
  
  public Collection<Type> assertBooleanTypes(final Collection<? extends Type> left, final Collection<? extends Type> right, final String operator) {
    Collection<? extends Type> _assertBooleanTypes = this.assertBooleanTypes(left, operator);
    Collection<? extends Type> _assertBooleanTypes_1 = this.assertBooleanTypes(right, operator);
    return this.ts.combine(_assertBooleanTypes, _assertBooleanTypes_1);
  }
  
  protected Collection<? extends Type> _inferType(final LogicalNotExpression expression) {
    Expression _operand = expression.getOperand();
    final Collection<? extends Type> types = this.getTypes(_operand);
    return this.assertBooleanTypes(types, "!");
  }
  
  protected Collection<? extends Type> _inferType(final BitwiseAndExpression expression) {
    Expression _leftOperand = expression.getLeftOperand();
    Collection<? extends Type> _types = this.getTypes(_leftOperand);
    Collection<? extends Type> _assertIntegerTypes = this.assertIntegerTypes(_types, "&");
    Expression _rightOperand = expression.getRightOperand();
    Collection<? extends Type> _types_1 = this.getTypes(_rightOperand);
    Collection<? extends Type> _assertIntegerTypes_1 = this.assertIntegerTypes(_types_1, "&");
    return this.ts.combine(_assertIntegerTypes, _assertIntegerTypes_1);
  }
  
  protected Collection<? extends Type> _inferType(final BitwiseOrExpression expression) {
    Expression _leftOperand = expression.getLeftOperand();
    Collection<? extends Type> _types = this.getTypes(_leftOperand);
    Collection<? extends Type> _assertIntegerTypes = this.assertIntegerTypes(_types, "|");
    Expression _rightOperand = expression.getRightOperand();
    Collection<? extends Type> _types_1 = this.getTypes(_rightOperand);
    Collection<? extends Type> _assertIntegerTypes_1 = this.assertIntegerTypes(_types_1, "|");
    return this.ts.combine(_assertIntegerTypes, _assertIntegerTypes_1);
  }
  
  protected Collection<? extends Type> _inferType(final BitwiseXorExpression expression) {
    Expression _leftOperand = expression.getLeftOperand();
    Collection<? extends Type> _types = this.getTypes(_leftOperand);
    Collection<? extends Type> _assertIntegerTypes = this.assertIntegerTypes(_types, "^");
    Expression _rightOperand = expression.getRightOperand();
    Collection<? extends Type> _types_1 = this.getTypes(_rightOperand);
    Collection<? extends Type> _assertIntegerTypes_1 = this.assertIntegerTypes(_types_1, "^");
    return this.ts.combine(_assertIntegerTypes, _assertIntegerTypes_1);
  }
  
  protected Collection<? extends Type> _inferType(final LogicalRelationExpression expression) {
    Expression _leftOperand = expression.getLeftOperand();
    final Collection<? extends Type> leftTypes = this.getTypes(_leftOperand);
    Expression _rightOperand = expression.getRightOperand();
    final Collection<? extends Type> rightTypes = this.getTypes(_rightOperand);
    final Collection<Type> combined = this.ts.combine(leftTypes, rightTypes);
    Collection<? extends Type> _booleanTypes = this.getBooleanTypes(combined);
    boolean _isEmpty = _booleanTypes.isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      boolean _and = false;
      RelationalOperator _operator = expression.getOperator();
      boolean _notEquals = (!Objects.equal(_operator, RelationalOperator.EQUALS));
      if (!_notEquals) {
        _and = false;
      } else {
        RelationalOperator _operator_1 = expression.getOperator();
        boolean _notEquals_1 = (!Objects.equal(_operator_1, RelationalOperator.NOT_EQUALS));
        _and = (_notEquals && _notEquals_1);
      }
      if (_and) {
        RelationalOperator _operator_2 = expression.getOperator();
        String _literal = _operator_2==null?(String)null:_operator_2.getLiteral();
        String _plus = ("operator \'" + _literal);
        String _plus_1 = (_plus + "\' can not be applied to boolean values!");
        this.error(_plus_1);
        return CollectionLiterals.<Type>newArrayList();
      } else {
        return combined;
      }
    } else {
      boolean _isEmpty_1 = combined.isEmpty();
      if (_isEmpty_1) {
        final Function1<Type,String> _function = new Function1<Type,String>() {
            public String apply(final Type t) {
              String _name = t.getName();
              return _name;
            }
          };
        Iterable<String> _map = IterableExtensions.map(leftTypes, _function);
        String _join = IterableExtensions.join(_map, ",");
        String _plus_2 = ("Incompatible operands " + _join);
        String _plus_3 = (_plus_2 + " and ");
        final Function1<Type,String> _function_1 = new Function1<Type,String>() {
            public String apply(final Type t) {
              String _name = t.getName();
              return _name;
            }
          };
        Iterable<String> _map_1 = IterableExtensions.map(rightTypes, _function_1);
        String _join_1 = IterableExtensions.join(_map_1, ",");
        String _plus_4 = (_plus_3 + _join_1);
        String _plus_5 = (_plus_4 + " for operator \'");
        RelationalOperator _operator_3 = expression.getOperator();
        String _literal_1 = _operator_3.getLiteral();
        String _plus_6 = (_plus_5 + _literal_1);
        String _plus_7 = (_plus_6 + "\'");
        this.error(_plus_7);
        return CollectionLiterals.<Type>newArrayList();
      }
      return this.getBooleanTypes();
    }
  }
  
  public Collection<Type> assertNumericalTypes(final Collection<? extends Type> left, final Collection<? extends Type> right, final String operator) {
    Collection<? extends Type> _assertNumericalTypes = this.assertNumericalTypes(left, operator);
    Collection<? extends Type> _assertNumericalTypes_1 = this.assertNumericalTypes(right, operator);
    return this.ts.combine(_assertNumericalTypes, _assertNumericalTypes_1);
  }
  
  protected Collection<? extends Type> _inferType(final NumericalAddSubtractExpression expression) {
    Expression _leftOperand = expression.getLeftOperand();
    Collection<? extends Type> _types = this.getTypes(_leftOperand);
    Expression _rightOperand = expression.getRightOperand();
    Collection<? extends Type> _types_1 = this.getTypes(_rightOperand);
    AdditiveOperator _operator = expression.getOperator();
    String _literal = _operator.getLiteral();
    return this.assertNumericalTypes(_types, _types_1, _literal);
  }
  
  protected Collection<? extends Type> _inferType(final NumericalMultiplyDivideExpression expression) {
    Expression _leftOperand = expression.getLeftOperand();
    Collection<? extends Type> _types = this.getTypes(_leftOperand);
    Expression _rightOperand = expression.getRightOperand();
    Collection<? extends Type> _types_1 = this.getTypes(_rightOperand);
    MultiplicativeOperator _operator = expression.getOperator();
    String _literal = _operator.getLiteral();
    return this.assertNumericalTypes(_types, _types_1, _literal);
  }
  
  protected Collection<? extends Type> _inferType(final NumericalUnaryExpression expression) {
    Expression _operand = expression.getOperand();
    final Collection<? extends Type> types = this.getTypes(_operand);
    UnaryOperator _operator = expression.getOperator();
    boolean _equals = Objects.equal(_operator, UnaryOperator.COMPLEMENT);
    if (_equals) {
      UnaryOperator _operator_1 = expression.getOperator();
      String _literal = _operator_1.getLiteral();
      return this.assertIntegerTypes(types, _literal);
    }
    UnaryOperator _operator_2 = expression.getOperator();
    String _literal_1 = _operator_2.getLiteral();
    return this.assertNumericalTypes(types, _literal_1);
  }
  
  protected Collection<? extends Type> _inferType(final PrimitiveValueExpression expression) {
    Literal _value = expression.getValue();
    return this.getLiteralTypes(_value);
  }
  
  protected Collection<? extends Type> _inferType(final ActiveStateReferenceExpression expression) {
    return this.getBooleanTypes();
  }
  
  protected Collection<? extends Type> _inferType(final ShiftExpression expression) {
    Expression _leftOperand = expression.getLeftOperand();
    Collection<? extends Type> _types = this.getTypes(_leftOperand);
    ShiftOperator _operator = expression.getOperator();
    String _literal = _operator.getLiteral();
    final Collection<? extends Type> leftTypes = this.assertIntegerTypes(_types, _literal);
    Expression _rightOperand = expression.getRightOperand();
    Collection<? extends Type> _types_1 = this.getTypes(_rightOperand);
    ShiftOperator _operator_1 = expression.getOperator();
    String _literal_1 = _operator_1.getLiteral();
    final Collection<? extends Type> rightTypes = this.assertIntegerTypes(_types_1, _literal_1);
    return this.ts.combine(leftTypes, rightTypes);
  }
  
  protected Collection<? extends Type> _inferType(final ConditionalExpression expression) {
    Expression _condition = expression.getCondition();
    Collection<? extends Type> _types = this.getTypes(_condition);
    this.assertBooleanTypes(_types, "?");
    Expression _trueCase = expression.getTrueCase();
    final Collection<? extends Type> trueTypes = this.getTypes(_trueCase);
    Expression _falseCase = expression.getFalseCase();
    final Collection<? extends Type> falseTypes = this.getTypes(_falseCase);
    final Collection<Type> types = this.ts.combine(trueTypes, falseTypes);
    boolean _isEmpty = types.isEmpty();
    if (_isEmpty) {
      this.error("True and false case of a conditional have to be of compatible types!");
    }
    return types;
  }
  
  protected Collection<? extends Type> _inferType(final FeatureCall featureCall) {
    boolean _and = false;
    boolean _and_1 = false;
    EObject _feature = featureCall.getFeature();
    if (!(_feature instanceof Event)) {
      _and_1 = false;
    } else {
      EObject _eContainer = featureCall.eContainer();
      boolean _not = (!(_eContainer instanceof EventRaisingExpression));
      _and_1 = ((_feature instanceof Event) && _not);
    }
    if (!_and_1) {
      _and = false;
    } else {
      EObject _eContainer_1 = featureCall.eContainer();
      boolean _not_1 = (!(_eContainer_1 instanceof EventValueReferenceExpression));
      _and = (_and_1 && _not_1);
    }
    if (_and) {
      return this.getBooleanTypes();
    }
    EObject _feature_1 = featureCall.getFeature();
    if ((_feature_1 instanceof Feature)) {
      EObject _feature_2 = featureCall.getFeature();
      final Type type = ((Feature) _feature_2).getType();
      boolean _notEquals = (!Objects.equal(type, null));
      if (_notEquals) {
        return CollectionLiterals.<Type>newArrayList(type);
      }
      return this.getVoidTypes();
    } else {
      EObject _feature_3 = featureCall.getFeature();
      boolean _notEquals_1 = (!Objects.equal(_feature_3, null));
      if (_notEquals_1) {
        String _plus = ("Type of FeatureCall is unknown: " + featureCall);
        this.error(_plus);
        return CollectionLiterals.<Type>newArrayList();
      }
    }
    return this.getVoidTypes();
  }
  
  protected Collection<? extends Type> _inferType(final ElementReferenceExpression expression) {
    EObject _reference = expression.getReference();
    return this.inferType(_reference, expression);
  }
  
  protected Collection<? extends Type> _inferType(final EObject object, final ElementReferenceExpression expression) {
    return this.getVoidTypes();
  }
  
  protected Collection<? extends Type> _inferType(final Property definition, final ElementReferenceExpression expression) {
    Type _type = definition.getType();
    boolean _notEquals = (!Objects.equal(_type, null));
    if (_notEquals) {
      Type _type_1 = definition.getType();
      return CollectionLiterals.<Type>newArrayList(_type_1);
    }
    return this.getVoidTypes();
  }
  
  protected Collection<? extends Type> _inferType(final Event definition, final ElementReferenceExpression expression) {
    boolean _or = false;
    EObject _eContainer = expression.eContainer();
    if ((_eContainer instanceof EventRaisingExpression)) {
      _or = true;
    } else {
      EObject _eContainer_1 = expression.eContainer();
      _or = ((_eContainer instanceof EventRaisingExpression) || (_eContainer_1 instanceof EventValueReferenceExpression));
    }
    if (_or) {
      Type _type = definition.getType();
      boolean _notEquals = (!Objects.equal(_type, null));
      if (_notEquals) {
        Type _type_1 = definition.getType();
        return CollectionLiterals.<Type>newArrayList(_type_1);
      }
      return this.getVoidTypes();
    }
    return this.getBooleanTypes();
  }
  
  protected Collection<? extends Type> _inferType(final OperationDefinition definition, final ElementReferenceExpression expression) {
    Type _type = definition.getType();
    boolean _notEquals = (!Objects.equal(_type, null));
    if (_notEquals) {
      Type _type_1 = definition.getType();
      return CollectionLiterals.<Type>newArrayList(_type_1);
    }
    return this.getVoidTypes();
  }
  
  protected Collection<? extends Type> _inferType(final EventValueReferenceExpression expression) {
    Expression _value = expression.getValue();
    return this.getTypes(_value);
  }
  
  protected Collection<? extends Type> _inferType(final ParenthesizedExpression e) {
    Expression _expression = e.getExpression();
    return this.getTypes(_expression);
  }
  
  protected Collection<? extends Type> _getLiteralTypes(final HexLiteral literal) {
    return this.getIntegerTypes();
  }
  
  protected Collection<? extends Type> _getLiteralTypes(final IntLiteral literal) {
    return this.getIntegerTypes();
  }
  
  protected Collection<? extends Type> _getLiteralTypes(final BoolLiteral bool) {
    return this.getBooleanTypes();
  }
  
  protected Collection<? extends Type> _getLiteralTypes(final RealLiteral literal) {
    return this.getRealTypes();
  }
  
  protected Collection<? extends Type> _getLiteralTypes(final StringLiteral literal) {
    return this.getStringTypes();
  }
  
  protected Collection<? extends Type> _getLiteralTypes(final EnumLiteral literal) {
    EnumerationType _type = literal.getType();
    return CollectionLiterals.<Type>newArrayList(_type);
  }
  
  public Collection<? extends Type> assertIntegerTypes(final Collection<? extends Type> types, final String operator) {
    Collection<? extends Type> integerTypes = this.getIntegerTypes(types);
    boolean _isEmpty = integerTypes.isEmpty();
    if (_isEmpty) {
      String _plus = ("operator \'" + operator);
      String _plus_1 = (_plus + "\' can only be applied to integer values!");
      this.error(_plus_1);
    }
    return integerTypes;
  }
  
  public Collection<? extends Type> assertRealTypes(final Collection<? extends Type> types, final String operator) {
    Collection<? extends Type> realTypes = this.getRealTypes(types);
    boolean _isEmpty = realTypes.isEmpty();
    if (_isEmpty) {
      String _plus = ("operator \'" + operator);
      String _plus_1 = (_plus + "\' can only be applied to real values!");
      this.error(_plus_1);
    }
    return types;
  }
  
  public Collection<? extends Type> assertNumericalTypes(final Collection<? extends Type> types, final String operator) {
    ArrayList<Type> numberTypes = CollectionLiterals.<Type>newArrayList();
    Collection<? extends Type> _integerTypes = this.getIntegerTypes(types);
    Iterables.<Type>addAll(numberTypes, _integerTypes);
    Collection<? extends Type> _realTypes = this.getRealTypes(types);
    Iterables.<Type>addAll(numberTypes, _realTypes);
    boolean _isEmpty = numberTypes.isEmpty();
    if (_isEmpty) {
      String _plus = ("operator \'" + operator);
      String _plus_1 = (_plus + "\' can only be applied to numbers!");
      this.error(_plus_1);
    }
    return numberTypes;
  }
  
  public Collection<? extends Type> assertBooleanTypes(final Collection<? extends Type> types, final String operator) {
    Collection<? extends Type> booleanTypes = this.getBooleanTypes(types);
    boolean _isEmpty = booleanTypes.isEmpty();
    if (_isEmpty) {
      String _plus = ("operator \'" + operator);
      String _plus_1 = (_plus + "\' can only be applied to boolean values!");
      this.error(_plus_1);
    }
    return booleanTypes;
  }
  
  public Collection<? extends Type> getNumericalTypes(final Collection<? extends Type> types) {
    ArrayList<Type> integerTypes = CollectionLiterals.<Type>newArrayList();
    for (final Type t : types) {
      boolean _or = false;
      boolean _isInteger = this.ts.isInteger(t);
      if (_isInteger) {
        _or = true;
      } else {
        boolean _isReal = this.ts.isReal(t);
        _or = (_isInteger || _isReal);
      }
      if (_or) {
        integerTypes.add(t);
      }
    }
    return integerTypes;
  }
  
  public Collection<? extends Type> getRealTypes(final Collection<? extends Type> types) {
    ArrayList<Type> realTypes = CollectionLiterals.<Type>newArrayList();
    for (final Type t : types) {
      boolean _isReal = this.ts.isReal(t);
      if (_isReal) {
        realTypes.add(t);
      }
    }
    return realTypes;
  }
  
  public Collection<? extends Type> getIntegerTypes(final Collection<? extends Type> types) {
    ArrayList<Type> integerTypes = CollectionLiterals.<Type>newArrayList();
    for (final Type t : types) {
      boolean _isInteger = this.ts.isInteger(t);
      if (_isInteger) {
        integerTypes.add(t);
      }
    }
    return integerTypes;
  }
  
  public Collection<? extends Type> getBooleanTypes(final Collection<? extends Type> types) {
    ArrayList<Type> booleanTypes = CollectionLiterals.<Type>newArrayList();
    for (final Type t : types) {
      boolean _isBoolean = this.ts.isBoolean(t);
      if (_isBoolean) {
        booleanTypes.add(t);
      }
    }
    return booleanTypes;
  }
  
  public void error(final String msg) {
    TypeCheckException _typeCheckException = new TypeCheckException(msg);
    throw _typeCheckException;
  }
  
  public Collection<? extends Type> getVoidTypes() {
    List<PrimitiveType> _primitiveTypes = this.ts.getPrimitiveTypes();
    final Function1<PrimitiveType,Boolean> _function = new Function1<PrimitiveType,Boolean>() {
        public Boolean apply(final PrimitiveType t) {
          boolean _isVoid = TypeInferrer.this.ts.isVoid(t);
          return Boolean.valueOf(_isVoid);
        }
      };
    Iterable<PrimitiveType> _filter = IterableExtensions.<PrimitiveType>filter(_primitiveTypes, _function);
    List<PrimitiveType> _list = IterableExtensions.<PrimitiveType>toList(_filter);
    return _list;
  }
  
  public Collection<? extends Type> getBooleanTypes() {
    List<PrimitiveType> _primitiveTypes = this.ts.getPrimitiveTypes();
    final Function1<PrimitiveType,Boolean> _function = new Function1<PrimitiveType,Boolean>() {
        public Boolean apply(final PrimitiveType t) {
          boolean _isBoolean = TypeInferrer.this.ts.isBoolean(t);
          return Boolean.valueOf(_isBoolean);
        }
      };
    Iterable<PrimitiveType> _filter = IterableExtensions.<PrimitiveType>filter(_primitiveTypes, _function);
    List<PrimitiveType> _list = IterableExtensions.<PrimitiveType>toList(_filter);
    return _list;
  }
  
  public Collection<? extends Type> getIntegerTypes() {
    List<PrimitiveType> _primitiveTypes = this.ts.getPrimitiveTypes();
    final Function1<PrimitiveType,Boolean> _function = new Function1<PrimitiveType,Boolean>() {
        public Boolean apply(final PrimitiveType t) {
          boolean _isInteger = TypeInferrer.this.ts.isInteger(t);
          return Boolean.valueOf(_isInteger);
        }
      };
    Iterable<PrimitiveType> _filter = IterableExtensions.<PrimitiveType>filter(_primitiveTypes, _function);
    List<PrimitiveType> _list = IterableExtensions.<PrimitiveType>toList(_filter);
    return _list;
  }
  
  public Collection<? extends Type> getRealTypes() {
    List<PrimitiveType> _primitiveTypes = this.ts.getPrimitiveTypes();
    final Function1<PrimitiveType,Boolean> _function = new Function1<PrimitiveType,Boolean>() {
        public Boolean apply(final PrimitiveType t) {
          boolean _isReal = TypeInferrer.this.ts.isReal(t);
          return Boolean.valueOf(_isReal);
        }
      };
    Iterable<PrimitiveType> _filter = IterableExtensions.<PrimitiveType>filter(_primitiveTypes, _function);
    List<PrimitiveType> _list = IterableExtensions.<PrimitiveType>toList(_filter);
    return _list;
  }
  
  public Collection<? extends Type> getStringTypes() {
    List<PrimitiveType> _primitiveTypes = this.ts.getPrimitiveTypes();
    final Function1<PrimitiveType,Boolean> _function = new Function1<PrimitiveType,Boolean>() {
        public Boolean apply(final PrimitiveType t) {
          boolean _isString = TypeInferrer.this.ts.isString(t);
          return Boolean.valueOf(_isString);
        }
      };
    Iterable<PrimitiveType> _filter = IterableExtensions.<PrimitiveType>filter(_primitiveTypes, _function);
    List<PrimitiveType> _list = IterableExtensions.<PrimitiveType>toList(_filter);
    return _list;
  }
  
  public Collection<? extends Type> inferType(final Statement expression) {
    if (expression instanceof ActiveStateReferenceExpression) {
      return _inferType((ActiveStateReferenceExpression)expression);
    } else if (expression instanceof AssignmentExpression) {
      return _inferType((AssignmentExpression)expression);
    } else if (expression instanceof BitwiseAndExpression) {
      return _inferType((BitwiseAndExpression)expression);
    } else if (expression instanceof BitwiseOrExpression) {
      return _inferType((BitwiseOrExpression)expression);
    } else if (expression instanceof BitwiseXorExpression) {
      return _inferType((BitwiseXorExpression)expression);
    } else if (expression instanceof ConditionalExpression) {
      return _inferType((ConditionalExpression)expression);
    } else if (expression instanceof ElementReferenceExpression) {
      return _inferType((ElementReferenceExpression)expression);
    } else if (expression instanceof EventRaisingExpression) {
      return _inferType((EventRaisingExpression)expression);
    } else if (expression instanceof EventValueReferenceExpression) {
      return _inferType((EventValueReferenceExpression)expression);
    } else if (expression instanceof FeatureCall) {
      return _inferType((FeatureCall)expression);
    } else if (expression instanceof LogicalAndExpression) {
      return _inferType((LogicalAndExpression)expression);
    } else if (expression instanceof LogicalNotExpression) {
      return _inferType((LogicalNotExpression)expression);
    } else if (expression instanceof LogicalOrExpression) {
      return _inferType((LogicalOrExpression)expression);
    } else if (expression instanceof LogicalRelationExpression) {
      return _inferType((LogicalRelationExpression)expression);
    } else if (expression instanceof NumericalAddSubtractExpression) {
      return _inferType((NumericalAddSubtractExpression)expression);
    } else if (expression instanceof NumericalMultiplyDivideExpression) {
      return _inferType((NumericalMultiplyDivideExpression)expression);
    } else if (expression instanceof NumericalUnaryExpression) {
      return _inferType((NumericalUnaryExpression)expression);
    } else if (expression instanceof ParenthesizedExpression) {
      return _inferType((ParenthesizedExpression)expression);
    } else if (expression instanceof PrimitiveValueExpression) {
      return _inferType((PrimitiveValueExpression)expression);
    } else if (expression instanceof ShiftExpression) {
      return _inferType((ShiftExpression)expression);
    } else if (expression instanceof Expression) {
      return _inferType((Expression)expression);
    } else if (expression != null) {
      return _inferType(expression);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(expression).toString());
    }
  }
  
  public Collection<? extends Type> inferType(final EObject definition, final ElementReferenceExpression expression) {
    if (definition instanceof OperationDefinition) {
      return _inferType((OperationDefinition)definition, expression);
    } else if (definition instanceof Event) {
      return _inferType((Event)definition, expression);
    } else if (definition instanceof Property) {
      return _inferType((Property)definition, expression);
    } else if (definition != null) {
      return _inferType(definition, expression);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(definition, expression).toString());
    }
  }
  
  public Collection<? extends Type> getLiteralTypes(final Literal bool) {
    if (bool instanceof BoolLiteral) {
      return _getLiteralTypes((BoolLiteral)bool);
    } else if (bool instanceof EnumLiteral) {
      return _getLiteralTypes((EnumLiteral)bool);
    } else if (bool instanceof HexLiteral) {
      return _getLiteralTypes((HexLiteral)bool);
    } else if (bool instanceof IntLiteral) {
      return _getLiteralTypes((IntLiteral)bool);
    } else if (bool instanceof RealLiteral) {
      return _getLiteralTypes((RealLiteral)bool);
    } else if (bool instanceof StringLiteral) {
      return _getLiteralTypes((StringLiteral)bool);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(bool).toString());
    }
  }
}
