package org.eclipse.damos.mscript.codegen.c;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import org.eclipse.damos.mscript.Evaluable;
import org.eclipse.damos.mscript.LocalVariableDeclaration;
import org.eclipse.damos.mscript.Statement;
import org.eclipse.damos.mscript.Type;
import org.eclipse.damos.mscript.codegen.c.ICodeFragmentCollector;
import org.eclipse.damos.mscript.codegen.c.ICompoundStatementGenerator;
import org.eclipse.damos.mscript.codegen.c.IMscriptGeneratorConfiguration;
import org.eclipse.damos.mscript.codegen.c.IMscriptGeneratorContext;
import org.eclipse.damos.mscript.codegen.c.IStatementGenerator;
import org.eclipse.damos.mscript.codegen.c.VariableDeclarationGenerator;
import org.eclipse.damos.mscript.interpreter.StaticFunctionInfo;
import org.eclipse.damos.mscript.interpreter.value.IValue;
import org.eclipse.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class CompoundStatementGenerator implements ICompoundStatementGenerator {
  @Inject
  private IStatementGenerator statementGenerator;
  
  @Inject
  private VariableDeclarationGenerator variableDeclarationGenerator;
  
  public CharSequence generate(final IMscriptGeneratorContext context, final Iterable<Statement> statements) {
    StringConcatenation _builder = new StringConcatenation();
    {
      Iterable<LocalVariableDeclaration> _filter = Iterables.<LocalVariableDeclaration>filter(statements, LocalVariableDeclaration.class);
      for(final LocalVariableDeclaration localVariableDeclaration : _filter) {
        IMscriptGeneratorConfiguration _configuration = context.getConfiguration();
        ICodeFragmentCollector _codeFragmentCollector = context.getCodeFragmentCollector();
        Type _dataType = this.getDataType(context, localVariableDeclaration);
        String _name = localVariableDeclaration.getName();
        CharSequence _generateVariableDeclaration = this.variableDeclarationGenerator.generateVariableDeclaration(_configuration, _codeFragmentCollector, _dataType, _name, false, null);
        _builder.append(_generateVariableDeclaration, "");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
      }
    }
    {
      for(final Statement statement : statements) {
        CharSequence _generate = this.statementGenerator.generate(context, statement);
        _builder.append(_generate, "");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }
  
  private Type getDataType(final IMscriptGeneratorContext context, final Evaluable evaluable) {
    StaticFunctionInfo _functionInfo = context.getFunctionInfo();
    IValue _value = _functionInfo.getValue(evaluable);
    return _value==null?(Type)null:_value.getDataType();
  }
}
