package org.eclipselabs.damos.mscript.codegen.c.operationgenerators;

import com.google.common.base.Objects;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipselabs.damos.mscript.ArrayType;
import org.eclipselabs.damos.mscript.BuiltinFunctionDeclaration;
import org.eclipselabs.damos.mscript.CallableElement;
import org.eclipselabs.damos.mscript.Expression;
import org.eclipselabs.damos.mscript.FunctionCall;
import org.eclipselabs.damos.mscript.LambdaExpression;
import org.eclipselabs.damos.mscript.LambdaExpressionParameter;
import org.eclipselabs.damos.mscript.Type;
import org.eclipselabs.damos.mscript.builtin.BuiltinFunctionKind;
import org.eclipselabs.damos.mscript.codegen.c.ExpressionGenerator;
import org.eclipselabs.damos.mscript.codegen.c.ICodeFragmentCollector;
import org.eclipselabs.damos.mscript.codegen.c.IExpressionGenerator;
import org.eclipselabs.damos.mscript.codegen.c.IMscriptGeneratorConfiguration;
import org.eclipselabs.damos.mscript.codegen.c.IMscriptGeneratorContext;
import org.eclipselabs.damos.mscript.codegen.c.IOperationGenerator;
import org.eclipselabs.damos.mscript.codegen.c.IOperationGeneratorProvider;
import org.eclipselabs.damos.mscript.codegen.c.OperationGeneratorProvider;
import org.eclipselabs.damos.mscript.codegen.c.datatype.MachineArrayType;
import org.eclipselabs.damos.mscript.codegen.c.datatype.MachineDataType;
import org.eclipselabs.damos.mscript.codegen.c.datatype.MachineDataTypes;
import org.eclipselabs.damos.mscript.interpreter.IStaticEvaluationResult;
import org.eclipselabs.damos.mscript.interpreter.value.IValue;
import org.eclipselabs.damos.mscript.util.MscriptUtil;

/**
 * @author Andreas Unger
 */
@SuppressWarnings("all")
public class FoldFunctionGenerator implements IOperationGenerator {
  private final IOperationGeneratorProvider operationGeneratorProvider = new Function0<IOperationGeneratorProvider>() {
    public IOperationGeneratorProvider apply() {
      OperationGeneratorProvider _operationGeneratorProvider = new OperationGeneratorProvider();
      return _operationGeneratorProvider;
    }
  }.apply();
  
  private final IExpressionGenerator expressionGenerator = new Function0<IExpressionGenerator>() {
    public IExpressionGenerator apply() {
      ExpressionGenerator _expressionGenerator = new ExpressionGenerator();
      return _expressionGenerator;
    }
  }.apply();
  
  public boolean canHandle(final IMscriptGeneratorContext context, final Type resultDataType, final Expression expression) {
    if ((expression instanceof FunctionCall)) {
      final FunctionCall functionCall = ((FunctionCall) expression);
      boolean _and = false;
      CallableElement _feature = functionCall.getFeature();
      if (!(_feature instanceof BuiltinFunctionDeclaration)) {
        _and = false;
      } else {
        CallableElement _feature_1 = functionCall.getFeature();
        String _name = _feature_1.getName();
        String _name_1 = BuiltinFunctionKind.FOLD.getName();
        boolean _equals = Objects.equal(_name, _name_1);
        _and = ((_feature instanceof BuiltinFunctionDeclaration) && _equals);
      }
      return _and;
    }
    return false;
  }
  
  public CharSequence generate(final IMscriptGeneratorContext context, final Type resultDataType, final CharSequence target, final Expression expression) {
    CharSequence _xblockexpression = null;
    {
      final FunctionCall functionCall = ((FunctionCall) expression);
      EList<Expression> _arguments = functionCall.getArguments();
      Expression _get = _arguments.get(2);
      final LambdaExpression lambdaExpression = ((LambdaExpression) _get);
      final ICodeFragmentCollector codeFragmentCollector = context.getCodeFragmentCollector();
      IMscriptGeneratorConfiguration _configuration = context.getConfiguration();
      IStaticEvaluationResult _staticEvaluationResult = context.getStaticEvaluationResult();
      EList<Expression> _arguments_1 = functionCall.getArguments();
      Expression _get_1 = _arguments_1.get(0);
      IValue _value = _staticEvaluationResult.getValue(_get_1);
      Type _dataType = _value.getDataType();
      final MachineArrayType vectorType = MachineDataTypes.create(_configuration, ((ArrayType) _dataType));
      IMscriptGeneratorConfiguration _configuration_1 = context.getConfiguration();
      final MachineDataType resultType = MachineDataTypes.create(_configuration_1, resultDataType);
      Expression _expression = lambdaExpression.getExpression();
      final String indexName = MscriptUtil.findAvailableLocalVariableName(_expression, "i");
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      EList<LambdaExpressionParameter> _parameters = lambdaExpression.getParameters();
      LambdaExpressionParameter _get_2 = _parameters.get(0);
      String _name = _get_2.getName();
      CharSequence _generateDataType = resultType.generateDataType(_name, codeFragmentCollector, null);
      _builder.append(_generateDataType, "	");
      _builder.append(" = ");
      EList<Expression> _arguments_2 = functionCall.getArguments();
      Expression _get_3 = _arguments_2.get(1);
      CharSequence _generate = this.expressionGenerator.generate(context, _get_3);
      _builder.append(_generate, "	");
      _builder.append(";");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("int ");
      _builder.append(indexName, "	");
      _builder.append(";");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("for (");
      _builder.append(indexName, "	");
      _builder.append(" = 0; ");
      _builder.append(indexName, "	");
      _builder.append(" < ");
      int _size = vectorType.getSize();
      _builder.append(_size, "	");
      _builder.append("; ++");
      _builder.append(indexName, "	");
      _builder.append(") {");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      EList<LambdaExpressionParameter> _parameters_1 = lambdaExpression.getParameters();
      LambdaExpressionParameter _get_4 = _parameters_1.get(1);
      String _name_1 = _get_4.getName();
      CharSequence _generateDataType_1 = resultType.generateDataType(_name_1, codeFragmentCollector, null);
      _builder.append(_generateDataType_1, "		");
      _builder.append(" = ");
      EList<Expression> _arguments_3 = functionCall.getArguments();
      Expression _get_5 = _arguments_3.get(0);
      CharSequence _generate_1 = this.expressionGenerator.generate(context, _get_5);
      _builder.append(_generate_1, "		");
      _builder.append("[");
      _builder.append(indexName, "		");
      _builder.append("];");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      Expression _expression_1 = lambdaExpression.getExpression();
      IOperationGenerator _generator = this.operationGeneratorProvider.getGenerator(context, resultDataType, _expression_1);
      EList<LambdaExpressionParameter> _parameters_2 = lambdaExpression.getParameters();
      LambdaExpressionParameter _get_6 = _parameters_2.get(0);
      String _name_2 = _get_6.getName();
      Expression _expression_2 = lambdaExpression.getExpression();
      CharSequence _generate_2 = _generator.generate(context, resultDataType, _name_2, _expression_2);
      _builder.append(_generate_2, "		");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append(target, "	");
      _builder.append(" = ");
      EList<LambdaExpressionParameter> _parameters_3 = lambdaExpression.getParameters();
      LambdaExpressionParameter _get_7 = _parameters_3.get(0);
      String _name_3 = _get_7.getName();
      _builder.append(_name_3, "	");
      _builder.append(";");
      _builder.newLineIfNotEmpty();
      _builder.append("}");
      _builder.newLine();
      _xblockexpression = (_builder);
    }
    return _xblockexpression;
  }
}
