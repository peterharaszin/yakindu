package org.eclipse.damos.mscript.codegen.c.operationgenerators;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import org.eclipse.damos.mscript.ArrayType;
import org.eclipse.damos.mscript.BinaryExpression;
import org.eclipse.damos.mscript.Expression;
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

/**
 * @author Andreas Unger
 */
@SuppressWarnings("all")
public class MatrixMultiplyGenerator implements IOperationGenerator {
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
    boolean _and_1 = false;
    boolean _isNumericArray = TypeUtil.isNumericArray(resultDataType);
    if (!_isNumericArray) {
      _and_1 = false;
    } else {
      StaticFunctionInfo _functionInfo = context.getFunctionInfo();
      Expression _leftOperand = binaryExpression.getLeftOperand();
      IValue _value = _functionInfo.getValue(_leftOperand);
      Type _dataType = _value.getDataType();
      boolean _isNumericMatrix = TypeUtil.isNumericMatrix(_dataType);
      _and_1 = (_isNumericArray && _isNumericMatrix);
    }
    if (!_and_1) {
      _and = false;
    } else {
      StaticFunctionInfo _functionInfo_1 = context.getFunctionInfo();
      Expression _rightOperand = binaryExpression.getRightOperand();
      IValue _value_1 = _functionInfo_1.getValue(_rightOperand);
      Type _dataType_1 = _value_1.getDataType();
      boolean _isNumericMatrix_1 = TypeUtil.isNumericMatrix(_dataType_1);
      _and = (_and_1 && _isNumericMatrix_1);
    }
    return _and;
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
      final MachineArrayType leftMatrixType = MachineDataTypes.create(_configuration, ((ArrayType) _dataType));
      IMscriptGeneratorConfiguration _configuration_1 = context.getConfiguration();
      StaticFunctionInfo _functionInfo_1 = context.getFunctionInfo();
      Expression _rightOperand = binaryExpression.getRightOperand();
      IValue _value_1 = _functionInfo_1.getValue(_rightOperand);
      Type _dataType_1 = _value_1.getDataType();
      final MachineArrayType rightMatrixType = MachineDataTypes.create(_configuration_1, ((ArrayType) _dataType_1));
      IMscriptGeneratorConfiguration _configuration_2 = context.getConfiguration();
      final MachineArrayType resultType = MachineDataTypes.create(_configuration_2, ((ArrayType) resultDataType));
      Expression _leftOperand_1 = binaryExpression.getLeftOperand();
      CharSequence _generate = this.expressionGenerator.generate(context, _leftOperand_1);
      String _plus = (_generate + "[i][j]");
      MachineNumericType _numericElementType = leftMatrixType.getNumericElementType();
      NumberFormat _numberFormat = _numericElementType.getNumberFormat();
      TextualNumericExpressionOperand _textualNumericExpressionOperand = new TextualNumericExpressionOperand(_plus, _numberFormat);
      final TextualNumericExpressionOperand leftOperand = _textualNumericExpressionOperand;
      Expression _rightOperand_1 = binaryExpression.getRightOperand();
      CharSequence _generate_1 = this.expressionGenerator.generate(context, _rightOperand_1);
      String _plus_1 = (_generate_1 + "[j][k]");
      MachineNumericType _numericElementType_1 = rightMatrixType.getNumericElementType();
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
      _builder.append("int k, i, j;");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("for (k = 0; k < ");
      int _columnSize = rightMatrixType.getColumnSize();
      _builder.append(_columnSize, "	");
      _builder.append("; ++k) {");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("for (i = 0; i < ");
      int _rowSize = leftMatrixType.getRowSize();
      _builder.append(_rowSize, "		");
      _builder.append("; ++i) {");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t\t");
      _builder.append("for (j = 0; j < ");
      int _columnSize_1 = leftMatrixType.getColumnSize();
      _builder.append(_columnSize_1, "			");
      _builder.append("; ++j) {");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t\t\t");
      _builder.append(target, "				");
      _builder.append("[i][k] += ");
      _builder.append(multiplyExpression, "				");
      _builder.append(";");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t\t");
      _builder.append("}");
      _builder.newLine();
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
