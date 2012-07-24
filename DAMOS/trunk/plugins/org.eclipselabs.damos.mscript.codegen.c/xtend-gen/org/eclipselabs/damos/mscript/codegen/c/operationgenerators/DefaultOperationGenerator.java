package org.eclipselabs.damos.mscript.codegen.c.operationgenerators;

import java.util.Arrays;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipselabs.damos.mscript.ArrayType;
import org.eclipselabs.damos.mscript.Expression;
import org.eclipselabs.damos.mscript.Type;
import org.eclipselabs.damos.mscript.codegen.c.DataTypeGenerator;
import org.eclipselabs.damos.mscript.codegen.c.ICodeFragmentCollector;
import org.eclipselabs.damos.mscript.codegen.c.IMscriptGeneratorConfiguration;
import org.eclipselabs.damos.mscript.codegen.c.IMscriptGeneratorContext;
import org.eclipselabs.damos.mscript.codegen.c.IOperationGenerator;
import org.eclipselabs.damos.mscript.codegen.c.util.MscriptGeneratorUtil;

/**
 * @author Andreas Unger
 */
@SuppressWarnings("all")
public class DefaultOperationGenerator implements IOperationGenerator {
  private final DataTypeGenerator dataTypeGenerator = new Function0<DataTypeGenerator>() {
    public DataTypeGenerator apply() {
      DataTypeGenerator _dataTypeGenerator = new DataTypeGenerator();
      return _dataTypeGenerator;
    }
  }.apply();
  
  public boolean canHandle(final IMscriptGeneratorContext context, final Type resultDataType, final Expression expression) {
    return true;
  }
  
  public CharSequence generate(final IMscriptGeneratorContext context, final Type resultDataType, final CharSequence target, final Expression expression) {
    return this.generateAssignment(context, resultDataType, target, expression);
  }
  
  private CharSequence _generateAssignment(final IMscriptGeneratorContext context, final Type targetDataType, final CharSequence target, final Expression assignedExpression) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append(target, "");
    _builder.append(" = ");
    CharSequence _generateAssignedExpression = this.generateAssignedExpression(context, targetDataType, assignedExpression);
    _builder.append(_generateAssignedExpression, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  private CharSequence _generateAssignment(final IMscriptGeneratorContext context, final ArrayType targetDataType, final CharSequence target, final Expression assignedExpression) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("memcpy(");
    _builder.append(target, "");
    _builder.append(", ");
    CharSequence _generateAssignedExpression = this.generateAssignedExpression(context, targetDataType, assignedExpression);
    _builder.append(_generateAssignedExpression, "");
    _builder.append(", sizeof (");
    IMscriptGeneratorConfiguration _configuration = context.getConfiguration();
    ICodeFragmentCollector _codeFragmentCollector = context.getCodeFragmentCollector();
    CharSequence _generateDataType = this.dataTypeGenerator.generateDataType(_configuration, null, _codeFragmentCollector, targetDataType, null);
    _builder.append(_generateDataType, "");
    _builder.append("));");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  public CharSequence generateAssignedExpression(final IMscriptGeneratorContext context, final Type targetDataType, final Expression expression) {
    return MscriptGeneratorUtil.cast(context, expression, targetDataType);
  }
  
  private CharSequence generateAssignment(final IMscriptGeneratorContext context, final Type targetDataType, final CharSequence target, final Expression assignedExpression) {
    if (targetDataType instanceof ArrayType) {
      return _generateAssignment(context, (ArrayType)targetDataType, target, assignedExpression);
    } else if (targetDataType != null) {
      return _generateAssignment(context, targetDataType, target, assignedExpression);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(context, targetDataType, target, assignedExpression).toString());
    }
  }
}
