package org.yakindu.sct.model.stext.validation;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
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
import org.yakindu.sct.model.sgraph.Declaration;
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
import org.yakindu.sct.model.stext.stext.VariableDefinition;
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
  
  public Collection<? extends Type> getTypes(final Declaration decl) {
    Collection<? extends Type> _xblockexpression = null;
    {
      boolean _equals = Objects.equal(decl, null);
      if (_equals) {
        return CollectionLiterals.<Type>newArrayList();
      }
      Collection<? extends Type> _get = this.cache.get(decl, this);
      _xblockexpression = (_get);
    }
    return _xblockexpression;
  }
  
  protected Collection<? extends Type> _inferType(final VariableDefinition definition) {
    Expression _initialValue = definition.getInitialValue();
    boolean _equals = Objects.equal(_initialValue, null);
    if (_equals) {
      Type _type = definition.getType();
      return CollectionLiterals.<Type>newArrayList(_type);
    } else {
      Expression _initialValue_1 = definition.getInitialValue();
      final Collection<? extends Type> valTypes = this.getTypes(_initialValue_1);
      Type _type_1 = definition.getType();
      ArrayList<Type> _newArrayList = CollectionLiterals.<Type>newArrayList(_type_1);
      final Collection<Type> types = this.assign(_newArrayList, valTypes);
      boolean _isEmpty = types.isEmpty();
      if (_isEmpty) {
        final Function1<Type,String> _function = new Function1<Type,String>() {
            public String apply(final Type t) {
              String _name = t.getName();
              return _name;
            }
          };
        Iterable<String> _map = IterableExtensions.map(valTypes, _function);
        String _join = IterableExtensions.join(_map, ",");
        String _plus = ("Can not assign a value of type " + _join);
        String _plus_1 = (_plus + " to a variable of type ");
        Type _type_2 = definition.getType();
        String _name = _type_2.getName();
        String _plus_2 = (_plus_1 + _name);
        this.error(_plus_2);
      }
      return types;
    }
  }
  
  protected Collection<? extends Type> _inferType(final AssignmentExpression assignment) {
    Expression _expression = assignment.getExpression();
    Collection<? extends Type> valueTypes = this.getTypes(_expression);
    Expression _varRef = assignment.getVarRef();
    Collection<? extends Type> varTypes = this.getTypes(_varRef);
    Collection<Type> types = this.assign(varTypes, valueTypes);
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
      final Function1<Type,Boolean> _function = new Function1<Type,Boolean>() {
          public Boolean apply(final Type t) {
            boolean _isVoid = TypeInferrer.this.ts.isVoid(t);
            return Boolean.valueOf(_isVoid);
          }
        };
      Iterable<? extends Type> _filter = IterableExtensions.filter(eventTypes, _function);
      boolean _isEmpty = IterableExtensions.isEmpty(_filter);
      if (_isEmpty) {
        final Function1<Type,String> _function_1 = new Function1<Type,String>() {
            public String apply(final Type t) {
              String _name = t.getName();
              return _name;
            }
          };
        Iterable<String> _map = IterableExtensions.map(eventTypes, _function_1);
        String _join = IterableExtensions.join(_map, ",");
        String _plus = ("Need to assign a value to an event of type " + _join);
        this.error(_plus);
        return CollectionLiterals.<Type>newArrayList();
      }
      return this.getVoidTypes();
    }
    Expression _value_1 = eventRaising.getValue();
    Collection<? extends Type> valueTypes = this.getTypes(_value_1);
    Collection<Type> types = this.assign(eventTypes, valueTypes);
    boolean _isEmpty_1 = types.isEmpty();
    if (_isEmpty_1) {
      final Function1<Type,String> _function_2 = new Function1<Type,String>() {
          public String apply(final Type t) {
            String _name = t.getName();
            return _name;
          }
        };
      Iterable<String> _map_1 = IterableExtensions.map(valueTypes, _function_2);
      String _join_1 = IterableExtensions.join(_map_1, ",");
      String _plus_1 = ("Can not assign a value of type " + _join_1);
      String _plus_2 = (_plus_1 + " to an event of type ");
      final Function1<Type,String> _function_3 = new Function1<Type,String>() {
          public String apply(final Type t) {
            String _name = t.getName();
            return _name;
          }
        };
      Iterable<String> _map_2 = IterableExtensions.map(eventTypes, _function_3);
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
    return this.combine(_assertBooleanTypes, _assertBooleanTypes_1);
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
    return this.combine(_assertIntegerTypes, _assertIntegerTypes_1);
  }
  
  protected Collection<? extends Type> _inferType(final BitwiseOrExpression expression) {
    Expression _leftOperand = expression.getLeftOperand();
    Collection<? extends Type> _types = this.getTypes(_leftOperand);
    Collection<? extends Type> _assertIntegerTypes = this.assertIntegerTypes(_types, "|");
    Expression _rightOperand = expression.getRightOperand();
    Collection<? extends Type> _types_1 = this.getTypes(_rightOperand);
    Collection<? extends Type> _assertIntegerTypes_1 = this.assertIntegerTypes(_types_1, "|");
    return this.combine(_assertIntegerTypes, _assertIntegerTypes_1);
  }
  
  protected Collection<? extends Type> _inferType(final BitwiseXorExpression expression) {
    Expression _leftOperand = expression.getLeftOperand();
    Collection<? extends Type> _types = this.getTypes(_leftOperand);
    Collection<? extends Type> _assertIntegerTypes = this.assertIntegerTypes(_types, "^");
    Expression _rightOperand = expression.getRightOperand();
    Collection<? extends Type> _types_1 = this.getTypes(_rightOperand);
    Collection<? extends Type> _assertIntegerTypes_1 = this.assertIntegerTypes(_types_1, "^");
    return this.combine(_assertIntegerTypes, _assertIntegerTypes_1);
  }
  
  protected Collection<? extends Type> _inferType(final LogicalRelationExpression expression) {
    Expression _leftOperand = expression.getLeftOperand();
    final Collection<? extends Type> leftTypes = this.getTypes(_leftOperand);
    Expression _rightOperand = expression.getRightOperand();
    final Collection<? extends Type> rightTypes = this.getTypes(_rightOperand);
    final Collection<Type> combined = this.combine(leftTypes, rightTypes);
    final Function1<Type,Boolean> _function = new Function1<Type,Boolean>() {
        public Boolean apply(final Type t) {
          boolean _isBoolean = TypeInferrer.this.ts.isBoolean(t);
          return Boolean.valueOf(_isBoolean);
        }
      };
    Iterable<Type> _filter = IterableExtensions.<Type>filter(combined, _function);
    boolean _isEmpty = IterableExtensions.isEmpty(_filter);
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
        final Function1<Type,String> _function_1 = new Function1<Type,String>() {
            public String apply(final Type t) {
              String _name = t.getName();
              return _name;
            }
          };
        Iterable<String> _map = IterableExtensions.map(leftTypes, _function_1);
        String _join = IterableExtensions.join(_map, ",");
        String _plus_2 = ("Incompatible operands " + _join);
        String _plus_3 = (_plus_2 + " and ");
        final Function1<Type,String> _function_2 = new Function1<Type,String>() {
            public String apply(final Type t) {
              String _name = t.getName();
              return _name;
            }
          };
        Iterable<String> _map_1 = IterableExtensions.map(rightTypes, _function_2);
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
    return this.combine(_assertNumericalTypes, _assertNumericalTypes_1);
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
    return this.combine(leftTypes, rightTypes);
  }
  
  protected Collection<? extends Type> _inferType(final ConditionalExpression expression) {
    Expression _condition = expression.getCondition();
    Collection<? extends Type> _types = this.getTypes(_condition);
    this.assertBooleanTypes(_types, "?");
    Expression _trueCase = expression.getTrueCase();
    final Collection<? extends Type> trueTypes = this.getTypes(_trueCase);
    Expression _falseCase = expression.getFalseCase();
    final Collection<? extends Type> falseTypes = this.getTypes(_falseCase);
    final Collection<Type> types = this.combine(trueTypes, falseTypes);
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
    final Function1<Type,Boolean> _function = new Function1<Type,Boolean>() {
        public Boolean apply(final Type t) {
          boolean _isInteger = TypeInferrer.this.ts.isInteger(t);
          return Boolean.valueOf(_isInteger);
        }
      };
    Iterable<? extends Type> integerTypes = IterableExtensions.filter(types, _function);
    boolean _isEmpty = IterableExtensions.isEmpty(integerTypes);
    if (_isEmpty) {
      String _plus = ("operator \'" + operator);
      String _plus_1 = (_plus + "\' can only be applied to integer values!");
      this.error(_plus_1);
    }
    return IterableExtensions.toList(integerTypes);
  }
  
  public Collection<? extends Type> assertRealTypes(final Collection<? extends Type> types, final String operator) {
    final Function1<Type,Boolean> _function = new Function1<Type,Boolean>() {
        public Boolean apply(final Type t) {
          boolean _isReal = TypeInferrer.this.ts.isReal(t);
          return Boolean.valueOf(_isReal);
        }
      };
    Iterable<? extends Type> realTypes = IterableExtensions.filter(types, _function);
    boolean _isEmpty = IterableExtensions.isEmpty(realTypes);
    if (_isEmpty) {
      String _plus = ("operator \'" + operator);
      String _plus_1 = (_plus + "\' can only be applied to real values!");
      this.error(_plus_1);
    }
    return IterableExtensions.toList(types);
  }
  
  public Collection<? extends Type> assertNumericalTypes(final Collection<? extends Type> types, final String operator) {
    ArrayList<Type> numberTypes = CollectionLiterals.<Type>newArrayList();
    final Function1<Type,Boolean> _function = new Function1<Type,Boolean>() {
        public Boolean apply(final Type t) {
          boolean _isInteger = TypeInferrer.this.ts.isInteger(t);
          return Boolean.valueOf(_isInteger);
        }
      };
    Iterable<? extends Type> _filter = IterableExtensions.filter(types, _function);
    Iterables.<Type>addAll(numberTypes, _filter);
    final Function1<Type,Boolean> _function_1 = new Function1<Type,Boolean>() {
        public Boolean apply(final Type t) {
          boolean _isReal = TypeInferrer.this.ts.isReal(t);
          return Boolean.valueOf(_isReal);
        }
      };
    Iterable<? extends Type> _filter_1 = IterableExtensions.filter(types, _function_1);
    Iterables.<Type>addAll(numberTypes, _filter_1);
    boolean _isEmpty = numberTypes.isEmpty();
    if (_isEmpty) {
      String _plus = ("operator \'" + operator);
      String _plus_1 = (_plus + "\' can only be applied to numbers!");
      this.error(_plus_1);
    }
    return IterableExtensions.<Type>toList(numberTypes);
  }
  
  public Collection<? extends Type> assertBooleanTypes(final Collection<? extends Type> types, final String operator) {
    final Function1<Type,Boolean> _function = new Function1<Type,Boolean>() {
        public Boolean apply(final Type t) {
          boolean _isBoolean = TypeInferrer.this.ts.isBoolean(t);
          return Boolean.valueOf(_isBoolean);
        }
      };
    Iterable<? extends Type> booleanTypes = IterableExtensions.filter(types, _function);
    boolean _isEmpty = IterableExtensions.isEmpty(booleanTypes);
    if (_isEmpty) {
      String _plus = ("operator \'" + operator);
      String _plus_1 = (_plus + "\' can only be applied to boolean values!");
      this.error(_plus_1);
    }
    return IterableExtensions.toList(booleanTypes);
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
  
  public Collection<Type> assign(final Collection<? extends Type> leftTypes, final Collection<? extends Type> rightTypes) {
    final Collection<Type> combined = this.combine(leftTypes, rightTypes);
    ArrayList<Type> _arrayList = new ArrayList<Type>();
    final List<Type> matched = _arrayList;
    for (final Type t1 : leftTypes) {
      for (final Type t2 : combined) {
        boolean _equals = EcoreUtil.equals(t1, t2);
        if (_equals) {
          matched.add(t1);
        }
      }
    }
    return matched;
  }
  
  public Collection<Type> combine(final Collection<? extends Type> leftTypes, final Collection<? extends Type> rightTypes) {
    HashSet<Type> _hashSet = new HashSet<Type>();
    final Set<Type> resultTypes = _hashSet;
    for (final Type t1 : leftTypes) {
      for (final Type t2 : rightTypes) {
        boolean _equals = EcoreUtil.equals(t1, t2);
        if (_equals) {
          resultTypes.add(t1);
        }
      }
    }
    HashSet<Type> _hashSet_1 = new HashSet<Type>();
    final Set<Type> leftBacklog = _hashSet_1;
    leftBacklog.addAll(leftTypes);
    leftBacklog.removeAll(resultTypes);
    HashSet<Type> _hashSet_2 = new HashSet<Type>();
    final Set<Type> rightBacklog = _hashSet_2;
    rightBacklog.addAll(rightTypes);
    rightBacklog.removeAll(resultTypes);
    final Function1<Type,Boolean> _function = new Function1<Type,Boolean>() {
        public Boolean apply(final Type t) {
          boolean _isVoid = TypeInferrer.this.ts.isVoid(t);
          return Boolean.valueOf(_isVoid);
        }
      };
    Iterable<Type> _filter = IterableExtensions.<Type>filter(leftBacklog, _function);
    final List<Type> leftVoids = IterableExtensions.<Type>toList(_filter);
    final Function1<Type,Boolean> _function_1 = new Function1<Type,Boolean>() {
        public Boolean apply(final Type t) {
          boolean _isVoid = TypeInferrer.this.ts.isVoid(t);
          return Boolean.valueOf(_isVoid);
        }
      };
    Iterable<Type> _filter_1 = IterableExtensions.<Type>filter(rightBacklog, _function_1);
    final List<Type> rightVoids = IterableExtensions.<Type>toList(_filter_1);
    boolean _and = false;
    boolean _isEmpty = leftVoids.isEmpty();
    boolean _not = (!_isEmpty);
    if (!_not) {
      _and = false;
    } else {
      boolean _isEmpty_1 = rightVoids.isEmpty();
      boolean _not_1 = (!_isEmpty_1);
      _and = (_not && _not_1);
    }
    if (_and) {
      resultTypes.addAll(leftVoids);
      resultTypes.addAll(rightVoids);
      leftBacklog.removeAll(leftVoids);
      rightBacklog.removeAll(rightVoids);
    }
    final Function1<Type,Boolean> _function_2 = new Function1<Type,Boolean>() {
        public Boolean apply(final Type t) {
          boolean _isBoolean = TypeInferrer.this.ts.isBoolean(t);
          return Boolean.valueOf(_isBoolean);
        }
      };
    Iterable<Type> _filter_2 = IterableExtensions.<Type>filter(leftBacklog, _function_2);
    final List<Type> leftBooleans = IterableExtensions.<Type>toList(_filter_2);
    final Function1<Type,Boolean> _function_3 = new Function1<Type,Boolean>() {
        public Boolean apply(final Type t) {
          boolean _isBoolean = TypeInferrer.this.ts.isBoolean(t);
          return Boolean.valueOf(_isBoolean);
        }
      };
    Iterable<Type> _filter_3 = IterableExtensions.<Type>filter(rightBacklog, _function_3);
    final List<Type> rightBooleans = IterableExtensions.<Type>toList(_filter_3);
    boolean _and_1 = false;
    boolean _isEmpty_2 = leftBooleans.isEmpty();
    boolean _not_2 = (!_isEmpty_2);
    if (!_not_2) {
      _and_1 = false;
    } else {
      boolean _isEmpty_3 = rightBooleans.isEmpty();
      boolean _not_3 = (!_isEmpty_3);
      _and_1 = (_not_2 && _not_3);
    }
    if (_and_1) {
      resultTypes.addAll(leftBooleans);
      resultTypes.addAll(rightBooleans);
      leftBacklog.removeAll(leftBooleans);
      rightBacklog.removeAll(rightBooleans);
    }
    final Function1<Type,Boolean> _function_4 = new Function1<Type,Boolean>() {
        public Boolean apply(final Type t) {
          boolean _isString = TypeInferrer.this.ts.isString(t);
          return Boolean.valueOf(_isString);
        }
      };
    Iterable<Type> _filter_4 = IterableExtensions.<Type>filter(leftBacklog, _function_4);
    final List<Type> leftStrings = IterableExtensions.<Type>toList(_filter_4);
    final Function1<Type,Boolean> _function_5 = new Function1<Type,Boolean>() {
        public Boolean apply(final Type t) {
          boolean _isString = TypeInferrer.this.ts.isString(t);
          return Boolean.valueOf(_isString);
        }
      };
    Iterable<Type> _filter_5 = IterableExtensions.<Type>filter(rightBacklog, _function_5);
    final List<Type> rightStrings = IterableExtensions.<Type>toList(_filter_5);
    boolean _and_2 = false;
    boolean _isEmpty_4 = leftStrings.isEmpty();
    boolean _not_4 = (!_isEmpty_4);
    if (!_not_4) {
      _and_2 = false;
    } else {
      boolean _isEmpty_5 = rightStrings.isEmpty();
      boolean _not_5 = (!_isEmpty_5);
      _and_2 = (_not_4 && _not_5);
    }
    if (_and_2) {
      resultTypes.addAll(leftStrings);
      resultTypes.addAll(rightStrings);
      leftBacklog.removeAll(leftStrings);
      rightBacklog.removeAll(rightStrings);
    }
    final List<Type> leftNumericals = this.getNumericalTypes(leftBacklog);
    final List<Type> rightNumericals = this.getNumericalTypes(rightBacklog);
    boolean _and_3 = false;
    boolean _isEmpty_6 = leftNumericals.isEmpty();
    boolean _not_6 = (!_isEmpty_6);
    if (!_not_6) {
      _and_3 = false;
    } else {
      boolean _isEmpty_7 = rightNumericals.isEmpty();
      boolean _not_7 = (!_isEmpty_7);
      _and_3 = (_not_6 && _not_7);
    }
    if (_and_3) {
      final Function1<Type,Boolean> _function_6 = new Function1<Type,Boolean>() {
          public Boolean apply(final Type t) {
            boolean _isReal = TypeInferrer.this.ts.isReal(t);
            return Boolean.valueOf(_isReal);
          }
        };
      Iterable<Type> _filter_6 = IterableExtensions.<Type>filter(leftNumericals, _function_6);
      final List<Type> leftReals = IterableExtensions.<Type>toList(_filter_6);
      final Function1<Type,Boolean> _function_7 = new Function1<Type,Boolean>() {
          public Boolean apply(final Type t) {
            boolean _isReal = TypeInferrer.this.ts.isReal(t);
            return Boolean.valueOf(_isReal);
          }
        };
      Iterable<Type> _filter_7 = IterableExtensions.<Type>filter(rightNumericals, _function_7);
      final List<Type> rightReals = IterableExtensions.<Type>toList(_filter_7);
      boolean _or = false;
      boolean _isEmpty_8 = leftReals.isEmpty();
      boolean _not_8 = (!_isEmpty_8);
      if (_not_8) {
        _or = true;
      } else {
        boolean _isEmpty_9 = rightReals.isEmpty();
        boolean _not_9 = (!_isEmpty_9);
        _or = (_not_8 || _not_9);
      }
      if (_or) {
        resultTypes.addAll(leftReals);
        resultTypes.addAll(rightReals);
      } else {
        final Function1<Type,Boolean> _function_8 = new Function1<Type,Boolean>() {
            public Boolean apply(final Type t) {
              boolean _isInteger = TypeInferrer.this.ts.isInteger(t);
              return Boolean.valueOf(_isInteger);
            }
          };
        Iterable<Type> _filter_8 = IterableExtensions.<Type>filter(leftNumericals, _function_8);
        final List<Type> leftIntegers = IterableExtensions.<Type>toList(_filter_8);
        final Function1<Type,Boolean> _function_9 = new Function1<Type,Boolean>() {
            public Boolean apply(final Type t) {
              boolean _isInteger = TypeInferrer.this.ts.isInteger(t);
              return Boolean.valueOf(_isInteger);
            }
          };
        Iterable<Type> _filter_9 = IterableExtensions.<Type>filter(leftNumericals, _function_9);
        final List<Type> rightIntegers = IterableExtensions.<Type>toList(_filter_9);
        boolean _and_4 = false;
        boolean _isEmpty_10 = leftIntegers.isEmpty();
        boolean _not_10 = (!_isEmpty_10);
        if (!_not_10) {
          _and_4 = false;
        } else {
          boolean _isEmpty_11 = rightIntegers.isEmpty();
          boolean _not_11 = (!_isEmpty_11);
          _and_4 = (_not_10 && _not_11);
        }
        if (_and_4) {
          resultTypes.addAll(leftIntegers);
          resultTypes.addAll(rightIntegers);
        }
      }
    }
    return resultTypes;
  }
  
  public List<Type> getNumericalTypes(final Collection<? extends Type> types) {
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
  
  public Collection<? extends Type> analyze(final Statement stmt) {
    return this.inferType(stmt);
  }
  
  public Collection<? extends Type> analyze(final Declaration decl) {
    return this.inferType(decl);
  }
  
  public Collection<? extends Type> inferType(final EObject definition) {
    if (definition instanceof VariableDefinition) {
      return _inferType((VariableDefinition)definition);
    } else if (definition instanceof ActiveStateReferenceExpression) {
      return _inferType((ActiveStateReferenceExpression)definition);
    } else if (definition instanceof AssignmentExpression) {
      return _inferType((AssignmentExpression)definition);
    } else if (definition instanceof BitwiseAndExpression) {
      return _inferType((BitwiseAndExpression)definition);
    } else if (definition instanceof BitwiseOrExpression) {
      return _inferType((BitwiseOrExpression)definition);
    } else if (definition instanceof BitwiseXorExpression) {
      return _inferType((BitwiseXorExpression)definition);
    } else if (definition instanceof ConditionalExpression) {
      return _inferType((ConditionalExpression)definition);
    } else if (definition instanceof ElementReferenceExpression) {
      return _inferType((ElementReferenceExpression)definition);
    } else if (definition instanceof EventRaisingExpression) {
      return _inferType((EventRaisingExpression)definition);
    } else if (definition instanceof EventValueReferenceExpression) {
      return _inferType((EventValueReferenceExpression)definition);
    } else if (definition instanceof FeatureCall) {
      return _inferType((FeatureCall)definition);
    } else if (definition instanceof LogicalAndExpression) {
      return _inferType((LogicalAndExpression)definition);
    } else if (definition instanceof LogicalNotExpression) {
      return _inferType((LogicalNotExpression)definition);
    } else if (definition instanceof LogicalOrExpression) {
      return _inferType((LogicalOrExpression)definition);
    } else if (definition instanceof LogicalRelationExpression) {
      return _inferType((LogicalRelationExpression)definition);
    } else if (definition instanceof NumericalAddSubtractExpression) {
      return _inferType((NumericalAddSubtractExpression)definition);
    } else if (definition instanceof NumericalMultiplyDivideExpression) {
      return _inferType((NumericalMultiplyDivideExpression)definition);
    } else if (definition instanceof NumericalUnaryExpression) {
      return _inferType((NumericalUnaryExpression)definition);
    } else if (definition instanceof ParenthesizedExpression) {
      return _inferType((ParenthesizedExpression)definition);
    } else if (definition instanceof PrimitiveValueExpression) {
      return _inferType((PrimitiveValueExpression)definition);
    } else if (definition instanceof ShiftExpression) {
      return _inferType((ShiftExpression)definition);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(definition).toString());
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
