package org.eclipse.damos.mscript.codegen.c.operationgenerators;

import org.eclipse.damos.mscript.AlgorithmExpression;
import org.eclipse.damos.mscript.CompoundStatement;
import org.eclipse.damos.mscript.Expression;
import org.eclipse.damos.mscript.ReturnStatement;
import org.eclipse.damos.mscript.Statement;
import org.eclipse.damos.mscript.Type;
import org.eclipse.damos.mscript.codegen.c.CompoundStatementGenerator;
import org.eclipse.damos.mscript.codegen.c.DataTypeGenerator;
import org.eclipse.damos.mscript.codegen.c.ExpressionGenerator;
import org.eclipse.damos.mscript.codegen.c.ICompoundStatementGenerator;
import org.eclipse.damos.mscript.codegen.c.IExpressionGenerator;
import org.eclipse.damos.mscript.codegen.c.IMscriptGeneratorContext;
import org.eclipse.damos.mscript.codegen.c.IOperationGenerator;
import org.eclipse.damos.mscript.codegen.c.IOperationGeneratorProvider;
import org.eclipse.damos.mscript.codegen.c.IStatementGenerator;
import org.eclipse.damos.mscript.codegen.c.LiteralGenerator;
import org.eclipse.damos.mscript.codegen.c.OperationGeneratorProvider;
import org.eclipse.damos.mscript.codegen.c.StatementGenerator;
import org.eclipse.damos.mscript.codegen.c.VariableDeclarationGenerator;
import org.eclipse.damos.mscript.codegen.c.internal.VariableReferenceGenerator;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * @author Andreas Unger
 */
@SuppressWarnings("all")
public class AlgorithmExpressionGenerator implements IOperationGenerator {
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
  
  private final DataTypeGenerator dataTypeGenerator = new Function0<DataTypeGenerator>() {
    public DataTypeGenerator apply() {
      DataTypeGenerator _dataTypeGenerator = new DataTypeGenerator();
      return _dataTypeGenerator;
    }
  }.apply();
  
  private final VariableDeclarationGenerator variableDeclarationGenerator = new Function0<VariableDeclarationGenerator>() {
    public VariableDeclarationGenerator apply() {
      VariableDeclarationGenerator _variableDeclarationGenerator = new VariableDeclarationGenerator(AlgorithmExpressionGenerator.this.dataTypeGenerator);
      return _variableDeclarationGenerator;
    }
  }.apply();
  
  private final IStatementGenerator statementGenerator = new Function0<IStatementGenerator>() {
    public IStatementGenerator apply() {
      LiteralGenerator _literalGenerator = new LiteralGenerator(AlgorithmExpressionGenerator.this.dataTypeGenerator);
      VariableReferenceGenerator _variableReferenceGenerator = new VariableReferenceGenerator(AlgorithmExpressionGenerator.this.expressionGenerator, _literalGenerator);
      OperationGeneratorProvider _operationGeneratorProvider = new OperationGeneratorProvider();
      StatementGenerator _statementGenerator = new StatementGenerator(AlgorithmExpressionGenerator.this.expressionGenerator, AlgorithmExpressionGenerator.this.dataTypeGenerator, AlgorithmExpressionGenerator.this.variableDeclarationGenerator, _variableReferenceGenerator, _operationGeneratorProvider);
      return _statementGenerator;
    }
  }.apply();
  
  private final ICompoundStatementGenerator compoundStatementGenerator = new Function0<ICompoundStatementGenerator>() {
    public ICompoundStatementGenerator apply() {
      CompoundStatementGenerator _compoundStatementGenerator = new CompoundStatementGenerator(AlgorithmExpressionGenerator.this.statementGenerator, AlgorithmExpressionGenerator.this.variableDeclarationGenerator);
      return _compoundStatementGenerator;
    }
  }.apply();
  
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
