package org.eclipse.damos.mscript.codegen.c.operationgenerators;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.util.ArrayList;
import java.util.Iterator;
import org.eclipse.damos.mscript.ArrayType;
import org.eclipse.damos.mscript.BinaryExpression;
import org.eclipse.damos.mscript.Expression;
import org.eclipse.damos.mscript.NumericType;
import org.eclipse.damos.mscript.OperatorKind;
import org.eclipse.damos.mscript.Type;
import org.eclipse.damos.mscript.codegen.c.ICodeFragmentCollector;
import org.eclipse.damos.mscript.codegen.c.IExpressionGenerator;
import org.eclipse.damos.mscript.codegen.c.IMscriptGeneratorConfiguration;
import org.eclipse.damos.mscript.codegen.c.IMscriptGeneratorContext;
import org.eclipse.damos.mscript.codegen.c.IMultiplicativeExpressionGenerator;
import org.eclipse.damos.mscript.codegen.c.IOperationGenerator;
import org.eclipse.damos.mscript.codegen.c.TextualNumericExpressionOperand;
import org.eclipse.damos.mscript.codegen.c.datatype.MachineArrayType;
import org.eclipse.damos.mscript.codegen.c.datatype.MachineDataTypes;
import org.eclipse.damos.mscript.codegen.c.datatype.MachineNumericType;
import org.eclipse.damos.mscript.computation.NumberFormat;
import org.eclipse.damos.mscript.interpreter.StaticFunctionInfo;
import org.eclipse.damos.mscript.interpreter.value.IValue;
import org.eclipse.damos.mscript.util.TypeUtil;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IntegerRange;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * @author Andreas Unger
 */
@SuppressWarnings("all")
public class ArrayScalarMultiplyGenerator implements IOperationGenerator {
  @Inject
  private IExpressionGenerator expressionGenerator;
  
  @Inject
  private IMultiplicativeExpressionGenerator multiplicativeExpressionGenerator;
  
  public boolean canHandle(final IMscriptGeneratorContext context, final Type resultDataType, final Expression expression) {
    boolean _not = (!(expression instanceof BinaryExpression));
    if (_not) {
      return false;
    }
    final BinaryExpression binaryExpression = ((BinaryExpression) expression);
    OperatorKind _operator = binaryExpression.getOperator();
    boolean _notEquals = (!Objects.equal(_operator, OperatorKind.MULTIPLY));
    if (_notEquals) {
      return false;
    }
    boolean _and = false;
    boolean _isNumericArray = TypeUtil.isNumericArray(resultDataType);
    if (!_isNumericArray) {
      _and = false;
    } else {
      boolean _or = false;
      boolean _and_1 = false;
      StaticFunctionInfo _functionInfo = context.getFunctionInfo();
      Expression _leftOperand = binaryExpression.getLeftOperand();
      IValue _value = _functionInfo.getValue(_leftOperand);
      Type _dataType = _value.getDataType();
      if (!(_dataType instanceof NumericType)) {
        _and_1 = false;
      } else {
        StaticFunctionInfo _functionInfo_1 = context.getFunctionInfo();
        Expression _rightOperand = binaryExpression.getRightOperand();
        IValue _value_1 = _functionInfo_1.getValue(_rightOperand);
        Type _dataType_1 = _value_1.getDataType();
        boolean _isNumericArray_1 = TypeUtil.isNumericArray(_dataType_1);
        _and_1 = ((_dataType instanceof NumericType) && _isNumericArray_1);
      }
      if (_and_1) {
        _or = true;
      } else {
        boolean _and_2 = false;
        StaticFunctionInfo _functionInfo_2 = context.getFunctionInfo();
        Expression _leftOperand_1 = binaryExpression.getLeftOperand();
        IValue _value_2 = _functionInfo_2.getValue(_leftOperand_1);
        Type _dataType_2 = _value_2.getDataType();
        boolean _isNumericArray_2 = TypeUtil.isNumericArray(_dataType_2);
        if (!_isNumericArray_2) {
          _and_2 = false;
        } else {
          StaticFunctionInfo _functionInfo_3 = context.getFunctionInfo();
          Expression _rightOperand_1 = binaryExpression.getRightOperand();
          IValue _value_3 = _functionInfo_3.getValue(_rightOperand_1);
          Type _dataType_3 = _value_3.getDataType();
          _and_2 = (_isNumericArray_2 && (_dataType_3 instanceof NumericType));
        }
        _or = (_and_1 || _and_2);
      }
      _and = (_isNumericArray && _or);
    }
    return _and;
  }
  
  public CharSequence generate(final IMscriptGeneratorContext context, final Type resultDataType, final CharSequence target, final Expression expression) {
    CharSequence _xblockexpression = null;
    {
      final BinaryExpression binaryExpression = ((BinaryExpression) expression);
      final ICodeFragmentCollector codeFragmentCollector = context.getCodeFragmentCollector();
      Expression _xifexpression = null;
      StaticFunctionInfo _functionInfo = context.getFunctionInfo();
      Expression _leftOperand = binaryExpression.getLeftOperand();
      IValue _value = _functionInfo.getValue(_leftOperand);
      Type _dataType = _value.getDataType();
      if ((_dataType instanceof NumericType)) {
        Expression _leftOperand_1 = binaryExpression.getLeftOperand();
        _xifexpression = _leftOperand_1;
      } else {
        Expression _rightOperand = binaryExpression.getRightOperand();
        _xifexpression = _rightOperand;
      }
      final Expression scalarOperand = _xifexpression;
      Expression _xifexpression_1 = null;
      StaticFunctionInfo _functionInfo_1 = context.getFunctionInfo();
      Expression _leftOperand_2 = binaryExpression.getLeftOperand();
      IValue _value_1 = _functionInfo_1.getValue(_leftOperand_2);
      Type _dataType_1 = _value_1.getDataType();
      if ((_dataType_1 instanceof NumericType)) {
        Expression _rightOperand_1 = binaryExpression.getRightOperand();
        _xifexpression_1 = _rightOperand_1;
      } else {
        Expression _leftOperand_3 = binaryExpression.getLeftOperand();
        _xifexpression_1 = _leftOperand_3;
      }
      final Expression arrayOperand = _xifexpression_1;
      IMscriptGeneratorConfiguration _configuration = context.getConfiguration();
      StaticFunctionInfo _functionInfo_2 = context.getFunctionInfo();
      IValue _value_2 = _functionInfo_2.getValue(scalarOperand);
      Type _dataType_2 = _value_2.getDataType();
      final MachineNumericType scalarType = MachineDataTypes.create(_configuration, ((NumericType) _dataType_2));
      IMscriptGeneratorConfiguration _configuration_1 = context.getConfiguration();
      StaticFunctionInfo _functionInfo_3 = context.getFunctionInfo();
      IValue _value_3 = _functionInfo_3.getValue(arrayOperand);
      Type _dataType_3 = _value_3.getDataType();
      final MachineArrayType arrayType = MachineDataTypes.create(_configuration_1, ((ArrayType) _dataType_3));
      IMscriptGeneratorConfiguration _configuration_2 = context.getConfiguration();
      final MachineArrayType resultType = MachineDataTypes.create(_configuration_2, ((ArrayType) resultDataType));
      CharSequence _generate = this.expressionGenerator.generate(context, scalarOperand);
      NumberFormat _numberFormat = scalarType.getNumberFormat();
      TextualNumericExpressionOperand _textualNumericExpressionOperand = new TextualNumericExpressionOperand(_generate, _numberFormat);
      final TextualNumericExpressionOperand leftOperand = _textualNumericExpressionOperand;
      CharSequence _generate_1 = this.expressionGenerator.generate(context, arrayOperand);
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
      String _plus = (_generate_1 + _join);
      MachineNumericType _numericElementType = arrayType.getNumericElementType();
      NumberFormat _numberFormat_1 = _numericElementType.getNumberFormat();
      TextualNumericExpressionOperand _textualNumericExpressionOperand_1 = new TextualNumericExpressionOperand(_plus, _numberFormat_1);
      final TextualNumericExpressionOperand rightOperand = _textualNumericExpressionOperand_1;
      MachineNumericType _numericElementType_1 = resultType.getNumericElementType();
      NumberFormat _numberFormat_2 = _numericElementType_1.getNumberFormat();
      final CharSequence multiplyExpression = this.multiplicativeExpressionGenerator.generate(codeFragmentCollector, OperatorKind.MULTIPLY, _numberFormat_2, leftOperand, rightOperand);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("int ");
      {
        Iterable<String> _indexVariables_1 = this.getIndexVariables(resultType);
        boolean _hasElements = false;
        for(final String indexVariable : _indexVariables_1) {
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
      Iterable<String> _indexVariables_2 = this.getIndexVariables(resultType);
      Iterator<String> _iterator = _indexVariables_2.iterator();
      CharSequence _generateLoop = this.generateLoop(0, _iterator, multiplyExpression, target, resultType);
      _builder.append(_generateLoop, "	");
      _builder.newLineIfNotEmpty();
      _builder.append("}");
      _builder.newLine();
      _xblockexpression = (_builder);
    }
    return _xblockexpression;
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
