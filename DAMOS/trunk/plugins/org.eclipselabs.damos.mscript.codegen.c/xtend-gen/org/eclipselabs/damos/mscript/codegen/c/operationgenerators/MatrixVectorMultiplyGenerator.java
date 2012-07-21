package org.eclipselabs.damos.mscript.codegen.c.operationgenerators;

import com.google.common.base.Objects;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipselabs.damos.mscript.ArrayType;
import org.eclipselabs.damos.mscript.BinaryExpression;
import org.eclipselabs.damos.mscript.DataType;
import org.eclipselabs.damos.mscript.Expression;
import org.eclipselabs.damos.mscript.OperatorKind;
import org.eclipselabs.damos.mscript.codegen.c.ExpressionGenerator;
import org.eclipselabs.damos.mscript.codegen.c.ICodeFragmentCollector;
import org.eclipselabs.damos.mscript.codegen.c.IExpressionGenerator;
import org.eclipselabs.damos.mscript.codegen.c.IMscriptGeneratorConfiguration;
import org.eclipselabs.damos.mscript.codegen.c.IMscriptGeneratorContext;
import org.eclipselabs.damos.mscript.codegen.c.IMultiplicativeExpressionGenerator;
import org.eclipselabs.damos.mscript.codegen.c.IOperationGenerator;
import org.eclipselabs.damos.mscript.codegen.c.InlineMultiplicativeExpressionGenerator;
import org.eclipselabs.damos.mscript.codegen.c.TextualNumericExpressionOperand;
import org.eclipselabs.damos.mscript.codegen.c.datatype.MachineArrayType;
import org.eclipselabs.damos.mscript.codegen.c.datatype.MachineDataTypes;
import org.eclipselabs.damos.mscript.codegen.c.datatype.MachineNumericType;
import org.eclipselabs.damos.mscript.computationmodel.NumberFormat;
import org.eclipselabs.damos.mscript.interpreter.IStaticEvaluationResult;
import org.eclipselabs.damos.mscript.interpreter.value.IValue;
import org.eclipselabs.damos.mscript.util.TypeUtil;

/**
 * @author Andreas Unger
 */
@SuppressWarnings("all")
public class MatrixVectorMultiplyGenerator implements IOperationGenerator {
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
  
  public boolean canHandle(final IMscriptGeneratorContext context, final DataType resultDataType, final Expression expression) {
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
    boolean _and_1 = false;
    boolean _isNumericArray = TypeUtil.isNumericArray(resultDataType);
    if (!_isNumericArray) {
      _and_1 = false;
    } else {
      IStaticEvaluationResult _staticEvaluationResult = context.getStaticEvaluationResult();
      Expression _leftOperand = binaryExpression.getLeftOperand();
      IValue _value = _staticEvaluationResult.getValue(_leftOperand);
      DataType _dataType = _value.getDataType();
      boolean _isNumericMatrix = TypeUtil.isNumericMatrix(_dataType);
      _and_1 = (_isNumericArray && _isNumericMatrix);
    }
    if (!_and_1) {
      _and = false;
    } else {
      IStaticEvaluationResult _staticEvaluationResult_1 = context.getStaticEvaluationResult();
      Expression _rightOperand = binaryExpression.getRightOperand();
      IValue _value_1 = _staticEvaluationResult_1.getValue(_rightOperand);
      DataType _dataType_1 = _value_1.getDataType();
      boolean _isNumericVector = TypeUtil.isNumericVector(_dataType_1);
      _and = (_and_1 && _isNumericVector);
    }
    return _and;
  }
  
  public CharSequence generate(final IMscriptGeneratorContext context, final DataType resultDataType, final CharSequence target, final Expression expression) {
    CharSequence _xblockexpression = null;
    {
      final BinaryExpression binaryExpression = ((BinaryExpression) expression);
      final ICodeFragmentCollector codeFragmentCollector = context.getCodeFragmentCollector();
      IMscriptGeneratorConfiguration _configuration = context.getConfiguration();
      IStaticEvaluationResult _staticEvaluationResult = context.getStaticEvaluationResult();
      Expression _leftOperand = binaryExpression.getLeftOperand();
      IValue _value = _staticEvaluationResult.getValue(_leftOperand);
      DataType _dataType = _value.getDataType();
      final MachineArrayType matrixType = MachineDataTypes.create(_configuration, ((ArrayType) _dataType));
      IMscriptGeneratorConfiguration _configuration_1 = context.getConfiguration();
      IStaticEvaluationResult _staticEvaluationResult_1 = context.getStaticEvaluationResult();
      Expression _rightOperand = binaryExpression.getRightOperand();
      IValue _value_1 = _staticEvaluationResult_1.getValue(_rightOperand);
      DataType _dataType_1 = _value_1.getDataType();
      final MachineArrayType vectorType = MachineDataTypes.create(_configuration_1, ((ArrayType) _dataType_1));
      IMscriptGeneratorConfiguration _configuration_2 = context.getConfiguration();
      final MachineArrayType resultType = MachineDataTypes.create(_configuration_2, ((ArrayType) resultDataType));
      Expression _leftOperand_1 = binaryExpression.getLeftOperand();
      CharSequence _generate = this.expressionGenerator.generate(context, _leftOperand_1);
      String _plus = (_generate + "[i][j]");
      MachineNumericType _numericElementType = matrixType.getNumericElementType();
      NumberFormat _numberFormat = _numericElementType.getNumberFormat();
      TextualNumericExpressionOperand _textualNumericExpressionOperand = new TextualNumericExpressionOperand(_plus, _numberFormat);
      final TextualNumericExpressionOperand leftOperand = _textualNumericExpressionOperand;
      Expression _rightOperand_1 = binaryExpression.getRightOperand();
      CharSequence _generate_1 = this.expressionGenerator.generate(context, _rightOperand_1);
      String _plus_1 = (_generate_1 + "[j]");
      MachineNumericType _numericElementType_1 = vectorType.getNumericElementType();
      NumberFormat _numberFormat_1 = _numericElementType_1.getNumberFormat();
      TextualNumericExpressionOperand _textualNumericExpressionOperand_1 = new TextualNumericExpressionOperand(_plus_1, _numberFormat_1);
      final TextualNumericExpressionOperand rightOperand = _textualNumericExpressionOperand_1;
      MachineNumericType _numericElementType_2 = resultType.getNumericElementType();
      NumberFormat _numberFormat_2 = _numericElementType_2.getNumberFormat();
      final CharSequence multiplyExpression = this.multiplicativeExpressionGenerator.generate(codeFragmentCollector, OperatorKind.MULTIPLY, _numberFormat_2, leftOperand, rightOperand);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("int i, j;");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("for (i = 0; i < ");
      int _rowSize = matrixType.getRowSize();
      _builder.append(_rowSize, "	");
      _builder.append("; ++i) {");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("for (j = 0; j < ");
      int _columnSize = matrixType.getColumnSize();
      _builder.append(_columnSize, "		");
      _builder.append("; ++j) {");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t\t");
      _builder.append(target, "			");
      _builder.append("[i] += ");
      _builder.append(multiplyExpression, "			");
      _builder.append(";");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _xblockexpression = (_builder);
    }
    return _xblockexpression;
  }
}
