package org.eclipse.damos.mscript.codegen.c.operationgenerators;

import com.google.inject.Inject;
import java.util.List;
import org.eclipse.damos.mscript.Expression;
import org.eclipse.damos.mscript.InspectExpression;
import org.eclipse.damos.mscript.InspectWhenClause;
import org.eclipse.damos.mscript.Type;
import org.eclipse.damos.mscript.UnionType;
import org.eclipse.damos.mscript.codegen.c.IExpressionGenerator;
import org.eclipse.damos.mscript.codegen.c.IMscriptGeneratorContext;
import org.eclipse.damos.mscript.codegen.c.IOperationGenerator;
import org.eclipse.damos.mscript.codegen.c.IOperationGeneratorProvider;
import org.eclipse.damos.mscript.interpreter.StaticFunctionInfo;
import org.eclipse.damos.mscript.interpreter.value.IValue;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IntegerRange;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * @author Andreas Unger
 */
@SuppressWarnings("all")
public class InspectExpressionGenerator implements IOperationGenerator {
  @Inject
  private IExpressionGenerator expressionGenerator;
  
  @Inject
  private IOperationGeneratorProvider operationGeneratorProvider;
  
  public boolean canHandle(final IMscriptGeneratorContext context, final Type resultDataType, final Expression expression) {
    return (expression instanceof InspectExpression);
  }
  
  public CharSequence generate(final IMscriptGeneratorContext context, final Type resultDataType, final CharSequence target, final Expression expression) {
    CharSequence _xblockexpression = null;
    {
      final InspectExpression inspectExpression = ((InspectExpression) expression);
      StaticFunctionInfo _functionInfo = context.getFunctionInfo();
      Expression _unionExpression = inspectExpression.getUnionExpression();
      IValue _value = _functionInfo.getValue(_unionExpression);
      Type _dataType = _value.getDataType();
      final UnionType unionType = ((UnionType) _dataType);
      EList<InspectWhenClause> _whenClauses = inspectExpression.getWhenClauses();
      final Function1<InspectWhenClause,Integer> _function = new Function1<InspectWhenClause,Integer>() {
          public Integer apply(final InspectWhenClause it) {
            String _name = it.getName();
            int _memberIndex = unionType.getMemberIndex(_name);
            return Integer.valueOf(_memberIndex);
          }
        };
      final List<InspectWhenClause> whenClauses = IterableExtensions.<InspectWhenClause, Integer>sortBy(_whenClauses, _function);
      boolean _isEmpty = whenClauses.isEmpty();
      if (_isEmpty) {
        return "";
      }
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("switch (");
      Expression _unionExpression_1 = inspectExpression.getUnionExpression();
      CharSequence _generate = this.expressionGenerator.generate(context, _unionExpression_1);
      _builder.append(_generate, "");
      _builder.append(".tag) {");
      _builder.newLineIfNotEmpty();
      {
        int _size = whenClauses.size();
        int _minus = (_size - 1);
        IntegerRange _upTo = new IntegerRange(0, _minus);
        for(final Integer i : _upTo) {
          _builder.append("case ");
          _builder.append(i, "");
          _builder.append(":");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          InspectWhenClause _get = whenClauses.get((i).intValue());
          Expression _expression = _get.getExpression();
          IOperationGenerator _generator = this.operationGeneratorProvider.getGenerator(context, resultDataType, _expression);
          InspectWhenClause _get_1 = whenClauses.get((i).intValue());
          Expression _expression_1 = _get_1.getExpression();
          CharSequence _generate_1 = _generator.generate(context, resultDataType, target, _expression_1);
          _builder.append(_generate_1, "	");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("break;");
          _builder.newLine();
        }
      }
      _builder.append("}");
      _builder.newLine();
      _xblockexpression = (_builder);
    }
    return _xblockexpression;
  }
}
