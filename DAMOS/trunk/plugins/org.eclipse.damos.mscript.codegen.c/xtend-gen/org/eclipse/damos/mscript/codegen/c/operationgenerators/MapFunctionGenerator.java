package org.eclipse.damos.mscript.codegen.c.operationgenerators;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.util.List;
import org.eclipse.damos.mscript.ArrayDimension;
import org.eclipse.damos.mscript.ArrayType;
import org.eclipse.damos.mscript.BuiltinFunctionDeclaration;
import org.eclipse.damos.mscript.CallableElement;
import org.eclipse.damos.mscript.Expression;
import org.eclipse.damos.mscript.FunctionCall;
import org.eclipse.damos.mscript.LambdaExpression;
import org.eclipse.damos.mscript.LambdaExpressionParameter;
import org.eclipse.damos.mscript.Type;
import org.eclipse.damos.mscript.builtin.BuiltinFunctionKind;
import org.eclipse.damos.mscript.codegen.c.ICodeFragmentCollector;
import org.eclipse.damos.mscript.codegen.c.IExpressionGenerator;
import org.eclipse.damos.mscript.codegen.c.IMscriptGeneratorConfiguration;
import org.eclipse.damos.mscript.codegen.c.IMscriptGeneratorContext;
import org.eclipse.damos.mscript.codegen.c.IOperationGenerator;
import org.eclipse.damos.mscript.codegen.c.IOperationGeneratorProvider;
import org.eclipse.damos.mscript.codegen.c.datatype.MachineArrayType;
import org.eclipse.damos.mscript.codegen.c.datatype.MachineDataType;
import org.eclipse.damos.mscript.codegen.c.datatype.MachineDataTypeFactory;
import org.eclipse.damos.mscript.interpreter.StaticFunctionInfo;
import org.eclipse.damos.mscript.interpreter.value.IValue;
import org.eclipse.damos.mscript.util.MscriptUtil;
import org.eclipse.damos.mscript.util.TypeUtil;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ListExtensions;

/**
 * @author Andreas Unger
 */
@SuppressWarnings("all")
public class MapFunctionGenerator implements IOperationGenerator {
  @Inject
  private IExpressionGenerator expressionGenerator;
  
  @Inject
  private IOperationGeneratorProvider operationGeneratorProvider;
  
  @Inject
  private MachineDataTypeFactory machineDataTypeFactory;
  
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
        String _name_1 = BuiltinFunctionKind.MAP.getName();
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
      Expression _get = _arguments.get(1);
      final LambdaExpression lambdaExpression = ((LambdaExpression) _get);
      final ICodeFragmentCollector codeFragmentCollector = context.getCodeFragmentCollector();
      IMscriptGeneratorConfiguration _configuration = context.getConfiguration();
      StaticFunctionInfo _functionInfo = context.getFunctionInfo();
      EList<Expression> _arguments_1 = functionCall.getArguments();
      Expression _get_1 = _arguments_1.get(0);
      IValue _value = _functionInfo.getValue(_get_1);
      Type _dataType = _value.getDataType();
      final MachineArrayType vectorType = this.machineDataTypeFactory.create(_configuration, ((ArrayType) _dataType));
      IMscriptGeneratorConfiguration _configuration_1 = context.getConfiguration();
      Type _elementType = ((ArrayType) resultDataType).getElementType();
      final MachineDataType elementType = this.machineDataTypeFactory.create(_configuration_1, _elementType);
      Type _xifexpression = null;
      int _dimensionality = ((ArrayType) resultDataType).getDimensionality();
      boolean _greaterThan = (_dimensionality > 1);
      if (_greaterThan) {
        Type _elementType_1 = ((ArrayType) resultDataType).getElementType();
        EList<ArrayDimension> _dimensions = ((ArrayType) resultDataType).getDimensions();
        final Function1<ArrayDimension,Integer> _function = new Function1<ArrayDimension,Integer>() {
            public Integer apply(final ArrayDimension it) {
              int _arrayDimensionSize = TypeUtil.getArrayDimensionSize(it);
              return Integer.valueOf(_arrayDimensionSize);
            }
          };
        List<Integer> _map = ListExtensions.<ArrayDimension, Integer>map(_dimensions, _function);
        ArrayType _createArrayType = TypeUtil.createArrayType(_elementType_1, _map);
        _xifexpression = _createArrayType;
      } else {
        Type _elementType_2 = ((ArrayType) resultDataType).getElementType();
        _xifexpression = _elementType_2;
      }
      final Type subType = _xifexpression;
      Expression _expression = lambdaExpression.getExpression();
      final String indexName = MscriptUtil.findAvailableLocalVariableName(_expression, "i");
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{");
      _builder.newLine();
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
      EList<LambdaExpressionParameter> _parameters = lambdaExpression.getParameters();
      LambdaExpressionParameter _get_2 = _parameters.get(0);
      String _name = _get_2.getName();
      CharSequence _generateDataType = elementType.generateDataType(_name, codeFragmentCollector, null);
      _builder.append(_generateDataType, "		");
      _builder.append(" = ");
      EList<Expression> _arguments_2 = functionCall.getArguments();
      Expression _get_3 = _arguments_2.get(0);
      CharSequence _generate = this.expressionGenerator.generate(context, _get_3);
      _builder.append(_generate, "		");
      _builder.append("[");
      _builder.append(indexName, "		");
      _builder.append("];");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      Expression _expression_1 = lambdaExpression.getExpression();
      IOperationGenerator _generator = this.operationGeneratorProvider.getGenerator(context, subType, _expression_1);
      String _plus = (target + "[");
      String _plus_1 = (_plus + indexName);
      String _plus_2 = (_plus_1 + "]");
      Expression _expression_2 = lambdaExpression.getExpression();
      CharSequence _generate_1 = _generator.generate(context, subType, _plus_2, _expression_2);
      _builder.append(_generate_1, "		");
      _builder.newLineIfNotEmpty();
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
