package org.eclipselabs.damos.mscript.codegen.c;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.util.Arrays;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipselabs.damos.mscript.ArrayType;
import org.eclipselabs.damos.mscript.Assignment;
import org.eclipselabs.damos.mscript.CallableElement;
import org.eclipselabs.damos.mscript.Compound;
import org.eclipselabs.damos.mscript.DataType;
import org.eclipselabs.damos.mscript.Evaluable;
import org.eclipselabs.damos.mscript.Expression;
import org.eclipselabs.damos.mscript.ForStatement;
import org.eclipselabs.damos.mscript.IfStatement;
import org.eclipselabs.damos.mscript.IterationVariableDeclaration;
import org.eclipselabs.damos.mscript.LocalVariableDeclaration;
import org.eclipselabs.damos.mscript.NumericType;
import org.eclipselabs.damos.mscript.Statement;
import org.eclipselabs.damos.mscript.VariableDeclaration;
import org.eclipselabs.damos.mscript.VariableReference;
import org.eclipselabs.damos.mscript.codegen.c.DataTypeGenerator;
import org.eclipselabs.damos.mscript.codegen.c.ICodeFragmentCollector;
import org.eclipselabs.damos.mscript.codegen.c.ICompoundStatementGenerator;
import org.eclipselabs.damos.mscript.codegen.c.IExpressionGenerator;
import org.eclipselabs.damos.mscript.codegen.c.IMscriptGeneratorContext;
import org.eclipselabs.damos.mscript.codegen.c.VariableDeclarationGenerator;
import org.eclipselabs.damos.mscript.codegen.c.internal.VariableReferenceGenerator;
import org.eclipselabs.damos.mscript.codegen.c.util.MscriptGeneratorUtil;
import org.eclipselabs.damos.mscript.computationmodel.ComputationModel;
import org.eclipselabs.damos.mscript.computationmodel.NumberFormat;
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
  
  @Inject
  public CompoundStatementGenerator(final IExpressionGenerator expressionGenerator, final DataTypeGenerator dataTypeGenerator, final VariableDeclarationGenerator variableDeclarationGenerator, final VariableReferenceGenerator variableAccessGenerator) {
    this.expressionGenerator = expressionGenerator;
    this.dataTypeGenerator = dataTypeGenerator;
    this.variableDeclarationGenerator = variableDeclarationGenerator;
    this.variableReferenceGenerator = variableAccessGenerator;
  }
  
  public CharSequence generate(final IMscriptGeneratorContext context, final Compound compound) {
    CharSequence _doGenerate = this.doGenerate(context, compound);
    return _doGenerate;
  }
  
  private CharSequence _doGenerate(final IMscriptGeneratorContext context, final Compound compound) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _generateCompound = this.generateCompound(context, compound);
    _builder.append(_generateCompound, "");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  private CharSequence _doGenerate(final IMscriptGeneratorContext context, final Assignment assignment) {
    CharSequence _xblockexpression = null;
    {
      Expression _target = assignment.getTarget();
      boolean _not = (!(_target instanceof VariableReference));
      if (_not) {
        IllegalArgumentException _illegalArgumentException = new IllegalArgumentException();
        throw _illegalArgumentException;
      }
      Expression _target_1 = assignment.getTarget();
      final VariableReference variableReference = ((VariableReference) _target_1);
      CallableElement _feature = variableReference.getFeature();
      boolean _not_1 = (!(_feature instanceof VariableDeclaration));
      if (_not_1) {
        IllegalArgumentException _illegalArgumentException_1 = new IllegalArgumentException();
        throw _illegalArgumentException_1;
      }
      CallableElement _feature_1 = variableReference.getFeature();
      final VariableDeclaration target = ((VariableDeclaration) _feature_1);
      DataType _dataType = this.getDataType(context, target);
      CharSequence _generate = this.variableReferenceGenerator.generate(context, variableReference);
      Expression _assignedExpression = assignment.getAssignedExpression();
      CharSequence _generateAssignment = this.generateAssignment(context, _dataType, _generate, _assignedExpression);
      _xblockexpression = (_generateAssignment);
    }
    return _xblockexpression;
  }
  
  private CharSequence _doGenerate(final IMscriptGeneratorContext context, final LocalVariableDeclaration localVariableDeclaration) {
    Expression _initializer = localVariableDeclaration.getInitializer();
    boolean _notEquals = (!Objects.equal(_initializer, null));
    if (_notEquals) {
      DataType _dataType = this.getDataType(context, localVariableDeclaration);
      String _name = localVariableDeclaration.getName();
      Expression _initializer_1 = localVariableDeclaration.getInitializer();
      return this.generateAssignment(context, _dataType, _name, _initializer_1);
    }
    return "";
  }
  
  private CharSequence _doGenerate(final IMscriptGeneratorContext context, final ForStatement forStatement) {
    CharSequence _xblockexpression = null;
    {
      final IterationVariableDeclaration iterationVariableDeclaration = forStatement.getIterationVariable();
      Expression _collectionExpression = forStatement.getCollectionExpression();
      final DataType collectionDataType = this.getDataType(context, _collectionExpression);
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
      ComputationModel _computationModel = context.getComputationModel();
      ICodeFragmentCollector _codeFragmentCollector = context.getCodeFragmentCollector();
      DataType _dataType = this.getDataType(context, iterationVariableDeclaration);
      final CharSequence itVarDecl = this.variableDeclarationGenerator.generateVariableDeclaration(_computationModel, _codeFragmentCollector, _dataType, itVarName, false, null);
      final int size = TypeUtil.getArraySize(collectionArrayType);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      ComputationModel _computationModel_1 = context.getComputationModel();
      CharSequence _generateIndexDataType = this.dataTypeGenerator.generateIndexDataType(_computationModel_1, size);
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
      _builder.append(").data[");
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
  
  private CharSequence _generateThenStatement(final IMscriptGeneratorContext context, final Compound compound) {
    CharSequence _generateCompound = this.generateCompound(context, compound);
    return _generateCompound;
  }
  
  private CharSequence generateCompound(final IMscriptGeneratorContext context, final Compound compound) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("{");
    _builder.newLine();
    {
      EList<LocalVariableDeclaration> _localVariableDeclarations = compound.getLocalVariableDeclarations();
      for(final LocalVariableDeclaration localVariableDeclaration : _localVariableDeclarations) {
        _builder.append("\t");
        ComputationModel _computationModel = context.getComputationModel();
        ICodeFragmentCollector _codeFragmentCollector = context.getCodeFragmentCollector();
        DataType _dataType = this.getDataType(context, localVariableDeclaration);
        String _name = localVariableDeclaration.getName();
        CharSequence _generateVariableDeclaration = this.variableDeclarationGenerator.generateVariableDeclaration(_computationModel, _codeFragmentCollector, _dataType, _name, false, null);
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
  
  private CharSequence generateAssignment(final IMscriptGeneratorContext context, final DataType targetDataType, final CharSequence target, final Expression assignedExpression) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append(target, "");
    _builder.append(" = ");
    CharSequence _generateAssignedExpression = this.generateAssignedExpression(context, targetDataType, assignedExpression);
    _builder.append(_generateAssignedExpression, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  public CharSequence generateAssignedExpression(final IMscriptGeneratorContext context, final DataType targetDataType, final Expression expression) {
    if ((targetDataType instanceof NumericType)) {
      ComputationModel _computationModel = context.getComputationModel();
      final NumberFormat numberFormat = _computationModel.getNumberFormat(targetDataType);
      return MscriptGeneratorUtil.castNumericType(context, numberFormat, expression);
    }
    return this.expressionGenerator.generate(context, expression);
  }
  
  public DataType getDataType(final IMscriptGeneratorContext context, final Evaluable evaluable) {
    IStaticEvaluationResult _staticEvaluationResult = context.getStaticEvaluationResult();
    IValue _value = _staticEvaluationResult.getValue(evaluable);
    return _value==null?(DataType)null:_value.getDataType();
  }
  
  private CharSequence doGenerate(final IMscriptGeneratorContext context, final Statement localVariableDeclaration) {
    if (localVariableDeclaration instanceof LocalVariableDeclaration) {
      return _doGenerate(context, (LocalVariableDeclaration)localVariableDeclaration);
    } else if (localVariableDeclaration instanceof Assignment) {
      return _doGenerate(context, (Assignment)localVariableDeclaration);
    } else if (localVariableDeclaration instanceof Compound) {
      return _doGenerate(context, (Compound)localVariableDeclaration);
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
    if (compound instanceof Compound) {
      return _generateThenStatement(context, (Compound)compound);
    } else if (compound != null) {
      return _generateThenStatement(context, compound);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(context, compound).toString());
    }
  }
}
