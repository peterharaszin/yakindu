package org.eclipselabs.damos.mscript.codegen.c.operationgenerators;

import com.google.common.base.Objects;
import java.util.ArrayList;
import java.util.Iterator;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IntegerRange;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipselabs.damos.mscript.ArrayType;
import org.eclipselabs.damos.mscript.BinaryExpression;
import org.eclipselabs.damos.mscript.Expression;
import org.eclipselabs.damos.mscript.OperatorKind;
import org.eclipselabs.damos.mscript.Type;
import org.eclipselabs.damos.mscript.codegen.c.ExpressionGenerator;
import org.eclipselabs.damos.mscript.codegen.c.ICodeFragmentCollector;
import org.eclipselabs.damos.mscript.codegen.c.IExpressionGenerator;
import org.eclipselabs.damos.mscript.codegen.c.IMscriptGeneratorConfiguration;
import org.eclipselabs.damos.mscript.codegen.c.IMscriptGeneratorContext;
import org.eclipselabs.damos.mscript.codegen.c.IMultiplicativeExpressionGenerator;
import org.eclipselabs.damos.mscript.codegen.c.IOperationGenerator;
import org.eclipselabs.damos.mscript.codegen.c.InlineMultiplicativeExpressionGenerator;
import org.eclipselabs.damos.mscript.codegen.c.NumericExpressionCaster;
import org.eclipselabs.damos.mscript.codegen.c.TextualNumericExpressionOperand;
import org.eclipselabs.damos.mscript.codegen.c.datatype.MachineArrayType;
import org.eclipselabs.damos.mscript.codegen.c.datatype.MachineDataTypes;
import org.eclipselabs.damos.mscript.codegen.c.datatype.MachineNumericType;
import org.eclipselabs.damos.mscript.computation.NumberFormat;
import org.eclipselabs.damos.mscript.interpreter.StaticFunctionInfo;
import org.eclipselabs.damos.mscript.interpreter.value.IValue;
import org.eclipselabs.damos.mscript.util.TypeUtil;

/**
 * @author Andreas Unger
 */
@SuppressWarnings("all")
public class ArrayElementWiseOperationGenerator implements IOperationGenerator {
  private final IExpressionGenerator expressionGenerator = new Function0<IExpressionGenerator>() {
    public IExpressionGenerator apply() {
      ExpressionGenerator _expressionGenerator = new ExpressionGenerator();
      return _expressionGenerator;
    }
  }.apply();
  
  private final IMultiplicativeExpressionGenerator multiplicativeExpressionGenerator = new Function0<IMultiplicativeExpressionGenerator>() {
    public IMultiplicativeExpressionGenerator apply() {
      InlineMultiplicativeExpressionGenerator _inlineMultiplicativeExpressionGenerator = new InlineMultiplicativeExpressionGenerator();
      return _inlineMultiplicativeExpressionGenerator;
    }
  }.apply();
  
  public boolean canHandle(final IMscriptGeneratorContext context, final Type resultDataType, final Expression expression) {
    boolean _not = (!(expression instanceof BinaryExpression));
    if (_not) {
      return false;
    }
    final BinaryExpression binaryExpression = ((BinaryExpression) expression);
    boolean _and = false;
    OperatorKind _operator = binaryExpression.getOperator();
    boolean _notEquals = (!Objects.equal(_operator, OperatorKind.ADD));
    if (!_notEquals) {
      _and = false;
    } else {
      OperatorKind _operator_1 = binaryExpression.getOperator();
      boolean _notEquals_1 = (!Objects.equal(_operator_1, OperatorKind.SUBTRACT));
      _and = (_notEquals && _notEquals_1);
    }
    if (_and) {
      return false;
    }
    boolean _and_1 = false;
    boolean _and_2 = false;
    boolean _isNumericArray = TypeUtil.isNumericArray(resultDataType);
    if (!_isNumericArray) {
      _and_2 = false;
    } else {
      StaticFunctionInfo _functionInfo = context.getFunctionInfo();
      Expression _leftOperand = binaryExpression.getLeftOperand();
      IValue _value = _functionInfo.getValue(_leftOperand);
      Type _dataType = _value.getDataType();
      boolean _isNumericArray_1 = TypeUtil.isNumericArray(_dataType);
      _and_2 = (_isNumericArray && _isNumericArray_1);
    }
    if (!_and_2) {
      _and_1 = false;
    } else {
      StaticFunctionInfo _functionInfo_1 = context.getFunctionInfo();
      Expression _rightOperand = binaryExpression.getRightOperand();
      IValue _value_1 = _functionInfo_1.getValue(_rightOperand);
      Type _dataType_1 = _value_1.getDataType();
      boolean _isNumericArray_2 = TypeUtil.isNumericArray(_dataType_1);
      _and_1 = (_and_2 && _isNumericArray_2);
    }
    return _and_1;
  }
  
  public CharSequence generate(final IMscriptGeneratorContext context, final Type resultDataType, final CharSequence target, final Expression expression) {
    CharSequence _xblockexpression = null;
    {
      final BinaryExpression binaryExpression = ((BinaryExpression) expression);
      final ICodeFragmentCollector codeFragmentCollector = context.getCodeFragmentCollector();
      IMscriptGeneratorConfiguration _configuration = context.getConfiguration();
      StaticFunctionInfo _functionInfo = context.getFunctionInfo();
      Expression _leftOperand = binaryExpression.getLeftOperand();
      IValue _value = _functionInfo.getValue(_leftOperand);
      Type _dataType = _value.getDataType();
      final MachineArrayType leftArrayType = MachineDataTypes.create(_configuration, ((ArrayType) _dataType));
      IMscriptGeneratorConfiguration _configuration_1 = context.getConfiguration();
      StaticFunctionInfo _functionInfo_1 = context.getFunctionInfo();
      Expression _rightOperand = binaryExpression.getRightOperand();
      IValue _value_1 = _functionInfo_1.getValue(_rightOperand);
      Type _dataType_1 = _value_1.getDataType();
      final MachineArrayType rightArrayType = MachineDataTypes.create(_configuration_1, ((ArrayType) _dataType_1));
      IMscriptGeneratorConfiguration _configuration_2 = context.getConfiguration();
      final MachineArrayType resultType = MachineDataTypes.create(_configuration_2, ((ArrayType) resultDataType));
      CharSequence multiplyExpression = this.getMultiplicativeExpression(context, codeFragmentCollector, binaryExpression, leftArrayType, rightArrayType, resultType);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("int ");
      {
        Iterable<String> _indexVariables = this.getIndexVariables(resultType);
        boolean _hasElements = false;
        for(final String indexVariable : _indexVariables) {
          if (!_hasElements) {
            _hasElements = true;
          } else {
            _builder.appendImmediate(", ", "	");
          }
          _builder.append(indexVariable, "	");
        }
      }
      _builder.append(";");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      Iterable<String> _indexVariables_1 = this.getIndexVariables(resultType);
      Iterator<String> _iterator = _indexVariables_1.iterator();
      CharSequence _generateLoop = this.generateLoop(0, _iterator, multiplyExpression, target, resultType);
      _builder.append(_generateLoop, "	");
      _builder.newLineIfNotEmpty();
      _builder.append("}");
      _builder.newLine();
      _xblockexpression = (_builder);
    }
    return _xblockexpression;
  }
  
  private CharSequence getMultiplicativeExpression(final IMscriptGeneratorContext context, final ICodeFragmentCollector codeFragmentCollector, final BinaryExpression binaryExpression, final MachineArrayType leftArrayType, final MachineArrayType rightArrayType, final MachineArrayType resultType) {
    Expression _leftOperand = binaryExpression.getLeftOperand();
    CharSequence _generate = this.expressionGenerator.generate(context, _leftOperand);
    Iterable<String> _indexVariables = this.getIndexVariables(resultType);
    final Function1<String,String> _function = new Function1<String,String>() {
        public String apply(final String it) {
          String _plus = ("[" + it);
          String _plus_1 = (_plus + "]");
          return _plus_1;
        }
      };
    Iterable<String> _map = IterableExtensions.<String, String>map(_indexVariables, _function);
    String _join = IterableExtensions.join(_map);
    final String leftOperandText = (_generate + _join);
    Expression _rightOperand = binaryExpression.getRightOperand();
    CharSequence _generate_1 = this.expressionGenerator.generate(context, _rightOperand);
    Iterable<String> _indexVariables_1 = this.getIndexVariables(resultType);
    final Function1<String,String> _function_1 = new Function1<String,String>() {
        public String apply(final String it) {
          String _plus = ("[" + it);
          String _plus_1 = (_plus + "]");
          return _plus_1;
        }
      };
    Iterable<String> _map_1 = IterableExtensions.<String, String>map(_indexVariables_1, _function_1);
    String _join_1 = IterableExtensions.join(_map_1);
    final String rightOperandText = (_generate_1 + _join_1);
    boolean _or = false;
    OperatorKind _operator = binaryExpression.getOperator();
    boolean _equals = Objects.equal(_operator, OperatorKind.ADD);
    if (_equals) {
      _or = true;
    } else {
      OperatorKind _operator_1 = binaryExpression.getOperator();
      boolean _equals_1 = Objects.equal(_operator_1, OperatorKind.SUBTRACT);
      _or = (_equals || _equals_1);
    }
    if (_or) {
      String _switchResult = null;
      OperatorKind _operator_2 = binaryExpression.getOperator();
      final OperatorKind _switchValue = _operator_2;
      boolean _matched = false;
      if (!_matched) {
        if (Objects.equal(_switchValue,OperatorKind.ADD)) {
          _matched=true;
          _switchResult = "+";
        }
      }
      if (!_matched) {
        if (Objects.equal(_switchValue,OperatorKind.SUBTRACT)) {
          _matched=true;
          _switchResult = "-";
        }
      }
      final String operatorSymbol = _switchResult;
      MachineNumericType _numericElementType = leftArrayType.getNumericElementType();
      NumberFormat _numberFormat = _numericElementType.getNumberFormat();
      MachineNumericType _numericElementType_1 = resultType.getNumericElementType();
      NumberFormat _numberFormat_1 = _numericElementType_1.getNumberFormat();
      final CharSequence leftOperand = NumericExpressionCaster.INSTANCE.cast(leftOperandText, _numberFormat, _numberFormat_1);
      MachineNumericType _numericElementType_2 = rightArrayType.getNumericElementType();
      NumberFormat _numberFormat_2 = _numericElementType_2.getNumberFormat();
      MachineNumericType _numericElementType_3 = resultType.getNumericElementType();
      NumberFormat _numberFormat_3 = _numericElementType_3.getNumberFormat();
      final CharSequence rightOperand = NumericExpressionCaster.INSTANCE.cast(rightOperandText, _numberFormat_2, _numberFormat_3);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append(leftOperand, "");
      _builder.append(" ");
      _builder.append(operatorSymbol, "");
      _builder.append(" ");
      _builder.append(rightOperand, "");
      return _builder;
    }
    MachineNumericType _numericElementType_4 = leftArrayType.getNumericElementType();
    NumberFormat _numberFormat_4 = _numericElementType_4.getNumberFormat();
    TextualNumericExpressionOperand _textualNumericExpressionOperand = new TextualNumericExpressionOperand(leftOperandText, _numberFormat_4);
    final TextualNumericExpressionOperand leftOperand_1 = _textualNumericExpressionOperand;
    MachineNumericType _numericElementType_5 = rightArrayType.getNumericElementType();
    NumberFormat _numberFormat_5 = _numericElementType_5.getNumberFormat();
    TextualNumericExpressionOperand _textualNumericExpressionOperand_1 = new TextualNumericExpressionOperand(rightOperandText, _numberFormat_5);
    final TextualNumericExpressionOperand rightOperand_1 = _textualNumericExpressionOperand_1;
    OperatorKind _operator_3 = binaryExpression.getOperator();
    MachineNumericType _numericElementType_6 = resultType.getNumericElementType();
    NumberFormat _numberFormat_6 = _numericElementType_6.getNumberFormat();
    return this.multiplicativeExpressionGenerator.generate(codeFragmentCollector, _operator_3, _numberFormat_6, leftOperand_1, rightOperand_1);
  }
  
  private CharSequence generateLoop(final int dimension, final Iterator<String> indexVariableIt, final CharSequence multiplyExpression, final CharSequence target, final MachineArrayType resultType) {
    StringConcatenation _builder = new StringConcatenation();
    {
      int _dimensionality = resultType.getDimensionality();
      boolean _lessThan = (dimension < _dimensionality);
      if (_lessThan) {
        String indexVariable = indexVariableIt.next();
        _builder.newLineIfNotEmpty();
        _builder.append("for (");
        _builder.append(indexVariable, "");
        _builder.append(" = 0; ");
        _builder.append(indexVariable, "");
        _builder.append(" < ");
        int _dimensionSize = resultType.getDimensionSize(dimension);
        _builder.append(_dimensionSize, "");
        _builder.append("; ++");
        _builder.append(indexVariable, "");
        _builder.append(") {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        int _plus = (dimension + 1);
        CharSequence _generateLoop = this.generateLoop(_plus, indexVariableIt, multiplyExpression, target, resultType);
        _builder.append(_generateLoop, "	");
        _builder.newLineIfNotEmpty();
        _builder.append("}");
        _builder.newLine();
      } else {
        _builder.append(target, "");
        {
          Iterable<String> _indexVariables = this.getIndexVariables(resultType);
          for(final String indexVariable_1 : _indexVariables) {
            _builder.append("[");
            _builder.append(indexVariable_1, "");
            _builder.append("]");
          }
        }
        _builder.append(" = ");
        _builder.append(multiplyExpression, "");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }
  
  private Iterable<String> getIndexVariables(final MachineArrayType resultType) {
    int _dimensionality = resultType.getDimensionality();
    boolean _lessEqualsThan = (_dimensionality <= 4);
    if (_lessEqualsThan) {
      ArrayList<String> _newArrayList = CollectionLiterals.<String>newArrayList("i", "j", "k", "l");
      int _dimensionality_1 = resultType.getDimensionality();
      return IterableExtensions.<String>take(_newArrayList, _dimensionality_1);
    }
    int _dimensionality_2 = resultType.getDimensionality();
    int _minus = (_dimensionality_2 - 1);
    IntegerRange _upTo = new IntegerRange(0, _minus);
    final Function1<Integer,String> _function = new Function1<Integer,String>() {
        public String apply(final Integer it) {
          String _plus = ("i" + it);
          return _plus;
        }
      };
    return IterableExtensions.<Integer, String>map(_upTo, _function);
  }
}
