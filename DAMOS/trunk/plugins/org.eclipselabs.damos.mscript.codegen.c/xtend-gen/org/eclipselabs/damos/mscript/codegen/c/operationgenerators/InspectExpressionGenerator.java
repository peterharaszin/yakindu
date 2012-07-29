package org.eclipselabs.damos.mscript.codegen.c.operationgenerators;

import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IntegerRange;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipselabs.damos.mscript.Expression;
import org.eclipselabs.damos.mscript.InspectExpression;
import org.eclipselabs.damos.mscript.InspectWhenClause;
import org.eclipselabs.damos.mscript.Type;
import org.eclipselabs.damos.mscript.UnionType;
import org.eclipselabs.damos.mscript.codegen.c.ExpressionGenerator;
import org.eclipselabs.damos.mscript.codegen.c.IExpressionGenerator;
import org.eclipselabs.damos.mscript.codegen.c.IMscriptGeneratorContext;
import org.eclipselabs.damos.mscript.codegen.c.IOperationGenerator;
import org.eclipselabs.damos.mscript.codegen.c.IOperationGeneratorProvider;
import org.eclipselabs.damos.mscript.codegen.c.OperationGeneratorProvider;
import org.eclipselabs.damos.mscript.interpreter.IStaticEvaluationResult;
import org.eclipselabs.damos.mscript.interpreter.value.IValue;

/**
 * @author Andreas Unger
 */
@SuppressWarnings("all")
public class InspectExpressionGenerator implements IOperationGenerator {
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
    return (expression instanceof InspectExpression);
  }
  
  public CharSequence generate(final IMscriptGeneratorContext context, final Type resultDataType, final CharSequence target, final Expression expression) {
    CharSequence _xblockexpression = null;
    {
      final InspectExpression inspectExpression = ((InspectExpression) expression);
      IStaticEvaluationResult _staticEvaluationResult = context.getStaticEvaluationResult();
      Expression _unionExpression = inspectExpression.getUnionExpression();
      IValue _value = _staticEvaluationResult.getValue(_unionExpression);
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
