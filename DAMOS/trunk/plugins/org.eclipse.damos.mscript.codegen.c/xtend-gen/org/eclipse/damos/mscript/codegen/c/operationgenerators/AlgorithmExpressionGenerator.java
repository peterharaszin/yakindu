package org.eclipse.damos.mscript.codegen.c.operationgenerators;

import com.google.inject.Inject;
import org.eclipse.damos.mscript.AlgorithmExpression;
import org.eclipse.damos.mscript.CompoundStatement;
import org.eclipse.damos.mscript.Expression;
import org.eclipse.damos.mscript.ReturnStatement;
import org.eclipse.damos.mscript.Statement;
import org.eclipse.damos.mscript.Type;
import org.eclipse.damos.mscript.codegen.c.ICompoundStatementGenerator;
import org.eclipse.damos.mscript.codegen.c.IMscriptGeneratorContext;
import org.eclipse.damos.mscript.codegen.c.IOperationGenerator;
import org.eclipse.damos.mscript.codegen.c.IOperationGeneratorProvider;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * @author Andreas Unger
 */
@SuppressWarnings("all")
public class AlgorithmExpressionGenerator implements IOperationGenerator {
  @Inject
  private IOperationGeneratorProvider operationGeneratorProvider;
  
  @Inject
  private ICompoundStatementGenerator compoundStatementGenerator;
  
  public boolean canHandle(final IMscriptGeneratorContext context, final Type resultDataType, final Expression expression) {
    return (expression instanceof AlgorithmExpression);
  }
  
  public CharSequence generate(final IMscriptGeneratorContext context, final Type resultDataType, final CharSequence target, final Expression expression) {
    CharSequence _xblockexpression = null;
    {
      final AlgorithmExpression algorithmExpression = ((AlgorithmExpression) expression);
      CompoundStatement _body = algorithmExpression.getBody();
      EList<Statement> _statements = _body.getStatements();
      Statement _last = IterableExtensions.<Statement>last(_statements);
      final ReturnStatement returnStatement = ((ReturnStatement) _last);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      CompoundStatement _body_1 = algorithmExpression.getBody();
      EList<Statement> _statements_1 = _body_1.getStatements();
      final Function1<Statement,Boolean> _function = new Function1<Statement,Boolean>() {
          public Boolean apply(final Statement it) {
            boolean _not = (!(it instanceof ReturnStatement));
            return Boolean.valueOf(_not);
          }
        };
      Iterable<Statement> _filter = IterableExtensions.<Statement>filter(_statements_1, _function);
      CharSequence _generate = this.compoundStatementGenerator.generate(context, _filter);
      _builder.append(_generate, "	");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      Expression _expression = returnStatement.getExpression();
      IOperationGenerator _generator = this.operationGeneratorProvider.getGenerator(context, resultDataType, _expression);
      Expression _expression_1 = returnStatement.getExpression();
      CharSequence _generate_1 = _generator.generate(context, resultDataType, target, _expression_1);
      _builder.append(_generate_1, "	");
      _builder.newLineIfNotEmpty();
      _builder.append("}");
      _builder.newLine();
      _xblockexpression = (_builder);
    }
    return _xblockexpression;
  }
}
