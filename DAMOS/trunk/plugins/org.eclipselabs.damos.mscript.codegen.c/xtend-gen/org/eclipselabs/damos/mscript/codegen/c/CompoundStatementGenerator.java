package org.eclipselabs.damos.mscript.codegen.c;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.util.Arrays;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipselabs.damos.mscript.ArrayType;
import org.eclipselabs.damos.mscript.Assignment;
import org.eclipselabs.damos.mscript.CompoundStatement;
import org.eclipselabs.damos.mscript.Evaluable;
import org.eclipselabs.damos.mscript.Expression;
import org.eclipselabs.damos.mscript.ForStatement;
import org.eclipselabs.damos.mscript.IfStatement;
import org.eclipselabs.damos.mscript.IterationVariableDeclaration;
import org.eclipselabs.damos.mscript.LocalVariableDeclaration;
import org.eclipselabs.damos.mscript.Statement;
import org.eclipselabs.damos.mscript.Type;
import org.eclipselabs.damos.mscript.codegen.c.DataTypeGenerator;
import org.eclipselabs.damos.mscript.codegen.c.ICodeFragmentCollector;
import org.eclipselabs.damos.mscript.codegen.c.ICompoundStatementGenerator;
import org.eclipselabs.damos.mscript.codegen.c.IExpressionGenerator;
import org.eclipselabs.damos.mscript.codegen.c.IMscriptGeneratorConfiguration;
import org.eclipselabs.damos.mscript.codegen.c.IMscriptGeneratorContext;
import org.eclipselabs.damos.mscript.codegen.c.IOperationGenerator;
import org.eclipselabs.damos.mscript.codegen.c.IOperationGeneratorProvider;
import org.eclipselabs.damos.mscript.codegen.c.VariableDeclarationGenerator;
import org.eclipselabs.damos.mscript.codegen.c.internal.VariableReferenceGenerator;
import org.eclipselabs.damos.mscript.codegen.c.util.MscriptGeneratorUtil;
import org.eclipselabs.damos.mscript.computationmodel.ComputationModel;
import org.eclipselabs.damos.mscript.interpreter.IStaticEvaluationResult;
import org.eclipselabs.damos.mscript.interpreter.value.IValue;
import org.eclipselabs.damos.mscript.util.TypeUtil;

/**
 * @author Andreas Unger
 */
@SuppressWarnings("all")
public class CompoundStatementGenerator implements ICompoundStatementGenerator {
  private final IExpressionGenerator expressionGenerator;
  
  private final DataTypeGenerator dataTypeGenerator;
  
  private final VariableDeclarationGenerator variableDeclarationGenerator;
  
  private final VariableReferenceGenerator variableReferenceGenerator;
  
  private final IOperationGeneratorProvider operationGeneratorProvider;
  
  @Inject
  public CompoundStatementGenerator(final IExpressionGenerator expressionGenerator, final DataTypeGenerator dataTypeGenerator, final VariableDeclarationGenerator variableDeclarationGenerator, final VariableReferenceGenerator variableAccessGenerator, final IOperationGeneratorProvider operationGeneratorProvider) {
    this.expressionGenerator = expressionGenerator;
    this.dataTypeGenerator = dataTypeGenerator;
    this.variableDeclarationGenerator = variableDeclarationGenerator;
    this.variableReferenceGenerator = variableAccessGenerator;
    this.operationGeneratorProvider = operationGeneratorProvider;
  }
  
  public CharSequence generate(final IMscriptGeneratorContext context, final CompoundStatement compound) {
    CharSequence _doGenerate = this.doGenerate(context, compound);
    return _doGenerate;
  }
  
  private CharSequence _doGenerate(final IMscriptGeneratorContext context, final CompoundStatement compound) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _generateCompound = this.generateCompound(context, compound);
    _builder.append(_generateCompound, "");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  private CharSequence _doGenerate(final IMscriptGeneratorContext context, final Assignment assignment) {
    Expression _target = assignment.getTarget();
    final CharSequence target = this.expressionGenerator.generate(context, _target);
    Expression _target_1 = assignment.getTarget();
    final Type dataType = this.getDataType(context, _target_1);
    boolean _notEquals = (!Objects.equal(dataType, null));
    if (_notEquals) {
      Expression _assignedExpression = assignment.getAssignedExpression();
      return this.generateAssignment(context, dataType, target, _assignedExpression);
    }
    return "";
  }
  
  private CharSequence _doGenerate(final IMscriptGeneratorContext context, final LocalVariableDeclaration localVariableDeclaration) {
    Expression _initializer = localVariableDeclaration.getInitializer();
    boolean _notEquals = (!Objects.equal(_initializer, null));
    if (_notEquals) {
      final Type dataType = this.getDataType(context, localVariableDeclaration);
      boolean _notEquals_1 = (!Objects.equal(dataType, null));
      if (_notEquals_1) {
        String _name = localVariableDeclaration.getName();
        Expression _initializer_1 = localVariableDeclaration.getInitializer();
        return this.generateAssignment(context, dataType, _name, _initializer_1);
      }
    }
    return "";
  }
  
  private CharSequence _doGenerate(final IMscriptGeneratorContext context, final ForStatement forStatement) {
    CharSequence _xblockexpression = null;
    {
      final IterationVariableDeclaration iterationVariableDeclaration = forStatement.getIterationVariable();
      Expression _collectionExpression = forStatement.getCollectionExpression();
      final Type collectionDataType = this.getDataType(context, _collectionExpression);
      boolean _not = (!(collectionDataType instanceof ArrayType));
      if (_not) {
        RuntimeException _runtimeException = new RuntimeException("Collection type must be array type");
        throw _runtimeException;
      }
      final ArrayType collectionArrayType = ((ArrayType) collectionDataType);
      int _dimensionality = collectionArrayType.getDimensionality();
      boolean _notEquals = (_dimensionality != 1);
      if (_notEquals) {
        RuntimeException _runtimeException_1 = new RuntimeException("Array dimensionality must be 1");
        throw _runtimeException_1;
      }
      final String itVarName = iterationVariableDeclaration.getName();
      IMscriptGeneratorConfiguration _configuration = context.getConfiguration();
      ICodeFragmentCollector _codeFragmentCollector = context.getCodeFragmentCollector();
      Type _dataType = this.getDataType(context, iterationVariableDeclaration);
      final CharSequence itVarDecl = this.variableDeclarationGenerator.generateVariableDeclaration(_configuration, _codeFragmentCollector, _dataType, itVarName, false, null);
      final int size = TypeUtil.getArraySize(collectionArrayType);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      IMscriptGeneratorConfiguration _configuration_1 = context.getConfiguration();
      ComputationModel _computationModel = _configuration_1.getComputationModel();
      CharSequence _generateIndexDataType = this.dataTypeGenerator.generateIndexDataType(_computationModel, size);
      _builder.append(_generateIndexDataType, "	");
      _builder.append(" ");
      _builder.append(itVarName, "	");
      _builder.append("_i;");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("for (");
      _builder.append(itVarName, "	");
      _builder.append("_i = 0; ");
      _builder.append(itVarName, "	");
      _builder.append("_i < ");
      _builder.append(size, "	");
      _builder.append("; ++");
      _builder.append(itVarName, "	");
      _builder.append("_i) {");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append(itVarDecl, "		");
      _builder.append(" = (");
      Expression _collectionExpression_1 = forStatement.getCollectionExpression();
      CharSequence _generate = this.expressionGenerator.generate(context, _collectionExpression_1);
      _builder.append(_generate, "		");
      _builder.append(")[");
      _builder.append(itVarName, "		");
      _builder.append("_i];");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      Statement _body = forStatement.getBody();
      CharSequence _doGenerate = this.doGenerate(context, _body);
      _builder.append(_doGenerate, "		");
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
  
  private CharSequence _doGenerate(final IMscriptGeneratorContext context, final IfStatement ifStatement) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("if (");
    Expression _condition = ifStatement.getCondition();
    CharSequence _generate = this.expressionGenerator.generate(context, _condition);
    _builder.append(_generate, "");
    _builder.append(") ");
    Statement _thenStatement = ifStatement.getThenStatement();
    CharSequence _generateThenStatement = this.generateThenStatement(context, _thenStatement);
    _builder.append(_generateThenStatement, "");
    _builder.append(" else ");
    Statement _elseStatement = ifStatement.getElseStatement();
    CharSequence _doGenerate = this.doGenerate(context, _elseStatement);
    _builder.append(_doGenerate, "");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  private CharSequence _generateThenStatement(final IMscriptGeneratorContext context, final Statement statement) {
    CharSequence _doGenerate = this.doGenerate(context, statement);
    return _doGenerate;
  }
  
  private CharSequence _generateThenStatement(final IMscriptGeneratorContext context, final CompoundStatement compound) {
    CharSequence _generateCompound = this.generateCompound(context, compound);
    return _generateCompound;
  }
  
  private CharSequence generateCompound(final IMscriptGeneratorContext context, final CompoundStatement compound) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("{");
    _builder.newLine();
    {
      EList<LocalVariableDeclaration> _localVariableDeclarations = compound.getLocalVariableDeclarations();
      for(final LocalVariableDeclaration localVariableDeclaration : _localVariableDeclarations) {
        _builder.append("\t");
        IMscriptGeneratorConfiguration _configuration = context.getConfiguration();
        ICodeFragmentCollector _codeFragmentCollector = context.getCodeFragmentCollector();
        Type _dataType = this.getDataType(context, localVariableDeclaration);
        String _name = localVariableDeclaration.getName();
        CharSequence _generateVariableDeclaration = this.variableDeclarationGenerator.generateVariableDeclaration(_configuration, _codeFragmentCollector, _dataType, _name, false, null);
        _builder.append(_generateVariableDeclaration, "	");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
      }
    }
    {
      EList<Statement> _statements = compound.getStatements();
      for(final Statement statement : _statements) {
        _builder.append("\t");
        CharSequence _doGenerate = this.doGenerate(context, statement);
        _builder.append(_doGenerate, "	");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("}");
    return _builder;
  }
  
  private CharSequence generateAssignment(final IMscriptGeneratorContext context, final Type targetDataType, final CharSequence target, final Expression assignedExpression) {
    final IOperationGenerator operationGenerator = this.operationGeneratorProvider.getGenerator(context, targetDataType, assignedExpression);
    boolean _notEquals = (!Objects.equal(operationGenerator, null));
    if (_notEquals) {
      return operationGenerator.generate(context, targetDataType, target, assignedExpression);
    }
    return this.doGenerateAssignment(context, targetDataType, target, assignedExpression);
  }
  
  private CharSequence _doGenerateAssignment(final IMscriptGeneratorContext context, final Type targetDataType, final CharSequence target, final Expression assignedExpression) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append(target, "");
    _builder.append(" = ");
    CharSequence _generateAssignedExpression = this.generateAssignedExpression(context, targetDataType, assignedExpression);
    _builder.append(_generateAssignedExpression, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  private CharSequence _doGenerateAssignment(final IMscriptGeneratorContext context, final ArrayType targetDataType, final CharSequence target, final Expression assignedExpression) {
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
  
  public Type getDataType(final IMscriptGeneratorContext context, final Evaluable evaluable) {
    IStaticEvaluationResult _staticEvaluationResult = context.getStaticEvaluationResult();
    IValue _value = _staticEvaluationResult.getValue(evaluable);
    return _value==null?(Type)null:_value.getDataType();
  }
  
  private CharSequence doGenerate(final IMscriptGeneratorContext context, final Statement localVariableDeclaration) {
    if (localVariableDeclaration instanceof LocalVariableDeclaration) {
      return _doGenerate(context, (LocalVariableDeclaration)localVariableDeclaration);
    } else if (localVariableDeclaration instanceof Assignment) {
      return _doGenerate(context, (Assignment)localVariableDeclaration);
    } else if (localVariableDeclaration instanceof CompoundStatement) {
      return _doGenerate(context, (CompoundStatement)localVariableDeclaration);
    } else if (localVariableDeclaration instanceof ForStatement) {
      return _doGenerate(context, (ForStatement)localVariableDeclaration);
    } else if (localVariableDeclaration instanceof IfStatement) {
      return _doGenerate(context, (IfStatement)localVariableDeclaration);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(context, localVariableDeclaration).toString());
    }
  }
  
  private CharSequence generateThenStatement(final IMscriptGeneratorContext context, final Statement compound) {
    if (compound instanceof CompoundStatement) {
      return _generateThenStatement(context, (CompoundStatement)compound);
    } else if (compound != null) {
      return _generateThenStatement(context, compound);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(context, compound).toString());
    }
  }
  
  private CharSequence doGenerateAssignment(final IMscriptGeneratorContext context, final Type targetDataType, final CharSequence target, final Expression assignedExpression) {
    if (targetDataType instanceof ArrayType) {
      return _doGenerateAssignment(context, (ArrayType)targetDataType, target, assignedExpression);
    } else if (targetDataType != null) {
      return _doGenerateAssignment(context, targetDataType, target, assignedExpression);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(context, targetDataType, target, assignedExpression).toString());
    }
  }
}
