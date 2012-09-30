package org.eclipselabs.damos.mscript.codegen.c;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipselabs.damos.mscript.Evaluable;
import org.eclipselabs.damos.mscript.LocalVariableDeclaration;
import org.eclipselabs.damos.mscript.Statement;
import org.eclipselabs.damos.mscript.Type;
import org.eclipselabs.damos.mscript.codegen.c.ICodeFragmentCollector;
import org.eclipselabs.damos.mscript.codegen.c.ICompoundStatementGenerator;
import org.eclipselabs.damos.mscript.codegen.c.IMscriptGeneratorConfiguration;
import org.eclipselabs.damos.mscript.codegen.c.IMscriptGeneratorContext;
import org.eclipselabs.damos.mscript.codegen.c.IStatementGenerator;
import org.eclipselabs.damos.mscript.codegen.c.VariableDeclarationGenerator;
import org.eclipselabs.damos.mscript.interpreter.StaticFunctionInfo;
import org.eclipselabs.damos.mscript.interpreter.value.IValue;

@SuppressWarnings("all")
public class CompoundStatementGenerator implements ICompoundStatementGenerator {
  private final IStatementGenerator statementGenerator;
  
  private final VariableDeclarationGenerator variableDeclarationGenerator;
  
  @Inject
  public CompoundStatementGenerator(final IStatementGenerator statementGenerator, final VariableDeclarationGenerator variableDeclarationGenerator) {
    this.statementGenerator = statementGenerator;
    this.variableDeclarationGenerator = variableDeclarationGenerator;
  }
  
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
