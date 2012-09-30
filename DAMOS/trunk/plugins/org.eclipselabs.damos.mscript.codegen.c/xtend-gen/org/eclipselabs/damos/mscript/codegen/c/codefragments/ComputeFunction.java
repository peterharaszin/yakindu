package org.eclipselabs.damos.mscript.codegen.c.codefragments;

import com.google.common.base.Objects;
import java.util.List;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipselabs.damos.mscript.FeatureReference;
import org.eclipselabs.damos.mscript.FunctionDeclaration;
import org.eclipselabs.damos.mscript.InputParameterDeclaration;
import org.eclipselabs.damos.mscript.OutputParameterDeclaration;
import org.eclipselabs.damos.mscript.ParameterDeclaration;
import org.eclipselabs.damos.mscript.Statement;
import org.eclipselabs.damos.mscript.Type;
import org.eclipselabs.damos.mscript.VariableDeclaration;
import org.eclipselabs.damos.mscript.codegen.c.AbstractCodeFragment;
import org.eclipselabs.damos.mscript.codegen.c.CompoundStatementGenerator;
import org.eclipselabs.damos.mscript.codegen.c.DataTypeGenerator;
import org.eclipselabs.damos.mscript.codegen.c.ExpressionGenerator;
import org.eclipselabs.damos.mscript.codegen.c.ICodeFragment;
import org.eclipselabs.damos.mscript.codegen.c.ICodeFragment.IDependencyRule;
import org.eclipselabs.damos.mscript.codegen.c.ICodeFragmentCollector;
import org.eclipselabs.damos.mscript.codegen.c.ICodeFragmentContext;
import org.eclipselabs.damos.mscript.codegen.c.ICompoundStatementGenerator;
import org.eclipselabs.damos.mscript.codegen.c.IExpressionGenerator;
import org.eclipselabs.damos.mscript.codegen.c.IGlobalNameProvider;
import org.eclipselabs.damos.mscript.codegen.c.IMscriptGeneratorConfiguration;
import org.eclipselabs.damos.mscript.codegen.c.IMscriptGeneratorContext;
import org.eclipselabs.damos.mscript.codegen.c.IOperationGeneratorProvider;
import org.eclipselabs.damos.mscript.codegen.c.IVariableAccessStrategy;
import org.eclipselabs.damos.mscript.codegen.c.LiteralGenerator;
import org.eclipselabs.damos.mscript.codegen.c.OperationGeneratorProvider;
import org.eclipselabs.damos.mscript.codegen.c.StatementGenerator;
import org.eclipselabs.damos.mscript.codegen.c.VariableDeclarationGenerator;
import org.eclipselabs.damos.mscript.codegen.c.codefragments.ContextStruct;
import org.eclipselabs.damos.mscript.codegen.c.codefragments.FunctionContext;
import org.eclipselabs.damos.mscript.codegen.c.codefragments.InitializeFunction;
import org.eclipselabs.damos.mscript.codegen.c.codefragments.UpdateFunction;
import org.eclipselabs.damos.mscript.codegen.c.datatype.MachineDataType;
import org.eclipselabs.damos.mscript.codegen.c.datatype.MachineDataTypes;
import org.eclipselabs.damos.mscript.codegen.c.internal.VariableReferenceGenerator;
import org.eclipselabs.damos.mscript.computation.ComputationModel;
import org.eclipselabs.damos.mscript.function.ComputationCompound;
import org.eclipselabs.damos.mscript.function.FunctionDescription;
import org.eclipselabs.damos.mscript.function.FunctionInstance;
import org.eclipselabs.damos.mscript.function.util.FunctionModelUtil;
import org.eclipselabs.damos.mscript.interpreter.StaticFunctionInfo;
import org.eclipselabs.damos.mscript.interpreter.value.IValue;
import org.eclipselabs.damos.mscript.util.MscriptUtil;

/**
 * @author Andreas Unger
 */
@SuppressWarnings("all")
public class ComputeFunction extends AbstractCodeFragment {
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
  
  private final VariableReferenceGenerator variableAccessGenerator = new Function0<VariableReferenceGenerator>() {
    public VariableReferenceGenerator apply() {
      LiteralGenerator _literalGenerator = new LiteralGenerator(ComputeFunction.this.dataTypeGenerator);
      VariableReferenceGenerator _variableReferenceGenerator = new VariableReferenceGenerator(ComputeFunction.this.expressionGenerator, _literalGenerator);
      return _variableReferenceGenerator;
    }
  }.apply();
  
  private final VariableDeclarationGenerator variableDeclarationGenerator = new Function0<VariableDeclarationGenerator>() {
    public VariableDeclarationGenerator apply() {
      DataTypeGenerator _dataTypeGenerator = new DataTypeGenerator();
      VariableDeclarationGenerator _variableDeclarationGenerator = new VariableDeclarationGenerator(_dataTypeGenerator);
      return _variableDeclarationGenerator;
    }
  }.apply();
  
  private final IOperationGeneratorProvider operationGeneratorProvider = new Function0<IOperationGeneratorProvider>() {
    public IOperationGeneratorProvider apply() {
      OperationGeneratorProvider _operationGeneratorProvider = new OperationGeneratorProvider();
      return _operationGeneratorProvider;
    }
  }.apply();
  
  private final ICompoundStatementGenerator compoundStatementGenerator = new Function0<ICompoundStatementGenerator>() {
    public ICompoundStatementGenerator apply() {
      StatementGenerator _statementGenerator = new StatementGenerator(ComputeFunction.this.expressionGenerator, ComputeFunction.this.dataTypeGenerator, ComputeFunction.this.variableDeclarationGenerator, ComputeFunction.this.variableAccessGenerator, ComputeFunction.this.operationGeneratorProvider);
      CompoundStatementGenerator _compoundStatementGenerator = new CompoundStatementGenerator(_statementGenerator, ComputeFunction.this.variableDeclarationGenerator);
      return _compoundStatementGenerator;
    }
  }.apply();
  
  private final IMscriptGeneratorContext generatorContext;
  
  private String name;
  
  private FunctionInstance functionInstance;
  
  private CharSequence functionSignature;
  
  private CharSequence functionBody;
  
  private InitializeFunction initializeFunction;
  
  private UpdateFunction updateFunction;
  
  private ContextStruct contextStruct;
  
  public ComputeFunction(final IMscriptGeneratorContext generatorContext) {
    this.generatorContext = generatorContext;
  }
  
  /**
   * @return the name
   */
  public String getName() {
    return this.name;
  }
  
  public ContextStruct getContextStruct() {
    return this.contextStruct;
  }
  
  public InitializeFunction getInitializeFunction() {
    return this.initializeFunction;
  }
  
  public UpdateFunction getUpdateFunction() {
    return this.updateFunction;
  }
  
  public void initialize(final ICodeFragmentContext context, final IProgressMonitor monitor) {
    StaticFunctionInfo _functionInfo = this.generatorContext.getFunctionInfo();
    FunctionInstance _functionInstance = _functionInfo.getFunctionInstance();
    this.functionInstance = _functionInstance;
    final ICodeFragmentCollector codeFragmentCollector = context.getCodeFragmentCollector();
    IGlobalNameProvider _globalNameProvider = context.getGlobalNameProvider();
    StaticFunctionInfo _functionInfo_1 = this.generatorContext.getFunctionInfo();
    FunctionDescription _functionDescription = _functionInfo_1.getFunctionDescription();
    FunctionDeclaration _declaration = _functionDescription.getDeclaration();
    String _name = _declaration.getName();
    String _newGlobalName = _globalNameProvider.newGlobalName(_name);
    this.name = _newGlobalName;
    StaticFunctionInfo _functionInfo_2 = this.generatorContext.getFunctionInfo();
    FunctionDescription _functionDescription_1 = _functionInfo_2.getFunctionDescription();
    boolean _isStateful = _functionDescription_1.isStateful();
    if (_isStateful) {
      StaticFunctionInfo _functionInfo_3 = this.generatorContext.getFunctionInfo();
      ContextStruct _contextStruct = new ContextStruct(_functionInfo_3, false);
      this.contextStruct = _contextStruct;
      NullProgressMonitor _nullProgressMonitor = new NullProgressMonitor();
      ContextStruct _addCodeFragment = codeFragmentCollector.<ContextStruct>addCodeFragment(this.contextStruct, _nullProgressMonitor);
      this.contextStruct = _addCodeFragment;
      FunctionContext _functionContext = new FunctionContext(this.generatorContext);
      final FunctionContext functionContextDeclaration = _functionContext;
      this.contextStruct.addMember(functionContextDeclaration);
      final Function1<ICodeFragment,Boolean> _function = new Function1<ICodeFragment,Boolean>() {
          public Boolean apply(final ICodeFragment it) {
            boolean _equals = Objects.equal(it, ComputeFunction.this.contextStruct);
            return _equals;
          }
        };
      this.addDependency(ICodeFragment.FORWARD_DECLARATION_DEPENDS_ON, new IDependencyRule() {
          public boolean applies(ICodeFragment other) {
            return _function.apply(other);
          }
      });
      UpdateFunction _updateFunction = new UpdateFunction(this.generatorContext, this);
      NullProgressMonitor _nullProgressMonitor_1 = new NullProgressMonitor();
      UpdateFunction _addCodeFragment_1 = codeFragmentCollector.<UpdateFunction>addCodeFragment(_updateFunction, _nullProgressMonitor_1);
      this.updateFunction = _addCodeFragment_1;
      InitializeFunction _initializeFunction = new InitializeFunction(this.generatorContext, this);
      NullProgressMonitor _nullProgressMonitor_2 = new NullProgressMonitor();
      InitializeFunction _addCodeFragment_2 = codeFragmentCollector.<InitializeFunction>addCodeFragment(_initializeFunction, _nullProgressMonitor_2);
      this.initializeFunction = _addCodeFragment_2;
    }
    CharSequence _generateFunctionSignature = this.generateFunctionSignature(codeFragmentCollector);
    this.functionSignature = _generateFunctionSignature;
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("{");
    _builder.newLine();
    _builder.append("\t");
    ICodeFragmentCollector _codeFragmentCollector = this.generatorContext.getCodeFragmentCollector();
    FunctionDeclaration _declaration_1 = this.functionInstance.getDeclaration();
    EList<OutputParameterDeclaration> _outputParameterDeclarations = _declaration_1.getOutputParameterDeclarations();
    OutputParameterDeclaration _head = IterableExtensions.<OutputParameterDeclaration>head(_outputParameterDeclarations);
    CharSequence _generateDataType = this.generateDataType(_codeFragmentCollector, _head);
    _builder.append(_generateDataType, "	");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    {
      EList<ComputationCompound> _computationCompounds = this.functionInstance.getComputationCompounds();
      for(final ComputationCompound compound : _computationCompounds) {
        {
          boolean _and = false;
          EList<VariableDeclaration> _derivatives = compound.getDerivatives();
          boolean _isEmpty = _derivatives.isEmpty();
          if (!_isEmpty) {
            _and = false;
          } else {
            EList<OutputParameterDeclaration> _outputs = compound.getOutputs();
            boolean _isEmpty_1 = _outputs.isEmpty();
            boolean _not = (!_isEmpty_1);
            _and = (_isEmpty && _not);
          }
          if (_and) {
            _builder.append("\t");
            EList<Statement> _statements = compound.getStatements();
            CharSequence _generate = this.compoundStatementGenerator.generate(this.generatorContext, _statements);
            _builder.append(_generate, "	");
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    {
      List<InputParameterDeclaration> _directFeedthroughInputs = FunctionModelUtil.getDirectFeedthroughInputs(this.functionInstance);
      for(final InputParameterDeclaration inputParameterDeclaration : _directFeedthroughInputs) {
        {
          StaticFunctionInfo _functionInfo_4 = this.generatorContext.getFunctionInfo();
          int _circularBufferSize = _functionInfo_4.getCircularBufferSize(inputParameterDeclaration);
          boolean _greaterThan = (_circularBufferSize > 1);
          if (_greaterThan) {
            _builder.append("\t");
            CharSequence _generateUpdateContextStatement = this.generateUpdateContextStatement(inputParameterDeclaration);
            _builder.append(_generateUpdateContextStatement, "	");
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    {
      FunctionDeclaration _declaration_2 = this.functionInstance.getDeclaration();
      EList<OutputParameterDeclaration> _outputParameterDeclarations_1 = _declaration_2.getOutputParameterDeclarations();
      for(final OutputParameterDeclaration outputParameterDeclaration : _outputParameterDeclarations_1) {
        {
          StaticFunctionInfo _functionInfo_5 = this.generatorContext.getFunctionInfo();
          int _circularBufferSize_1 = _functionInfo_5.getCircularBufferSize(outputParameterDeclaration);
          boolean _greaterThan_1 = (_circularBufferSize_1 > 1);
          if (_greaterThan_1) {
            _builder.append("\t");
            CharSequence _generateUpdateContextStatement_1 = this.generateUpdateContextStatement(outputParameterDeclaration);
            _builder.append(_generateUpdateContextStatement_1, "	");
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    _builder.append("\t");
    _builder.append("return ");
    FunctionDeclaration _declaration_3 = this.functionInstance.getDeclaration();
    EList<OutputParameterDeclaration> _outputParameterDeclarations_2 = _declaration_3.getOutputParameterDeclarations();
    OutputParameterDeclaration _head_1 = IterableExtensions.<OutputParameterDeclaration>head(_outputParameterDeclarations_2);
    String _name_1 = _head_1.getName();
    _builder.append(_name_1, "	");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    this.functionBody = _builder;
  }
  
  public CharSequence generateForwardDeclaration(final boolean internal) {
    StringConcatenation _builder = new StringConcatenation();
    {
      if (internal) {
        _builder.append("static ");
      }
    }
    _builder.append(this.functionSignature, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  public boolean contributesImplementation() {
    return true;
  }
  
  public CharSequence generateImplementation(final boolean internal) {
    StringConcatenation _builder = new StringConcatenation();
    {
      if (internal) {
        _builder.append("static ");
      }
    }
    _builder.append(this.functionSignature, "");
    _builder.append(" ");
    _builder.append(this.functionBody, "");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  private CharSequence generateFunctionSignature(final ICodeFragmentCollector codeFragmentCollector) {
    CharSequence _xblockexpression = null;
    {
      StaticFunctionInfo _functionInfo = this.generatorContext.getFunctionInfo();
      FunctionDescription _functionDescription = _functionInfo.getFunctionDescription();
      final FunctionDeclaration functionDeclaration = _functionDescription.getDeclaration();
      final List<InputParameterDeclaration> inputParameterDeclarations = this.getInputParameterDeclarations();
      StringConcatenation _builder = new StringConcatenation();
      EList<OutputParameterDeclaration> _outputParameterDeclarations = functionDeclaration.getOutputParameterDeclarations();
      OutputParameterDeclaration _head = IterableExtensions.<OutputParameterDeclaration>head(_outputParameterDeclarations);
      CharSequence _generateParameterDeclaration = this.generateParameterDeclaration(codeFragmentCollector, _head);
      _builder.append(_generateParameterDeclaration, "");
      _builder.append(" ");
      _builder.append(this.name, "");
      _builder.append("(");
      {
        StaticFunctionInfo _functionInfo_1 = this.generatorContext.getFunctionInfo();
        FunctionDescription _functionDescription_1 = _functionInfo_1.getFunctionDescription();
        boolean _isStateful = _functionDescription_1.isStateful();
        if (_isStateful) {
          String _name = this.contextStruct.getName();
          _builder.append(_name, "");
          _builder.append(" *context");
          {
            boolean _isEmpty = inputParameterDeclarations.isEmpty();
            boolean _not = (!_isEmpty);
            if (_not) {
              _builder.append(", ");
            }
          }
        }
      }
      {
        boolean _hasElements = false;
        for(final InputParameterDeclaration inputParameter : inputParameterDeclarations) {
          if (!_hasElements) {
            _hasElements = true;
          } else {
            _builder.appendImmediate(", ", "");
          }
          CharSequence _generateParameterDeclaration_1 = this.generateParameterDeclaration(codeFragmentCollector, inputParameter);
          _builder.append(_generateParameterDeclaration_1, "");
        }
      }
      _builder.append(")");
      _xblockexpression = (_builder);
    }
    return _xblockexpression;
  }
  
  private List<InputParameterDeclaration> getInputParameterDeclarations() {
    StaticFunctionInfo _functionInfo = this.generatorContext.getFunctionInfo();
    FunctionInstance _functionInstance = _functionInfo.getFunctionInstance();
    List<InputParameterDeclaration> _directFeedthroughInputs = FunctionModelUtil.getDirectFeedthroughInputs(_functionInstance);
    return _directFeedthroughInputs;
  }
  
  private CharSequence generateParameterDeclaration(final ICodeFragmentCollector codeFragmentCollector, final ParameterDeclaration parameterDeclaration) {
    CharSequence _xblockexpression = null;
    {
      String _xifexpression = null;
      if ((parameterDeclaration instanceof InputParameterDeclaration)) {
        String _name = parameterDeclaration.getName();
        _xifexpression = _name;
      }
      final String variableName = _xifexpression;
      CharSequence _generateDataType = this.generateDataType(codeFragmentCollector, parameterDeclaration, variableName);
      _xblockexpression = (_generateDataType);
    }
    return _xblockexpression;
  }
  
  private CharSequence generateDataType(final ICodeFragmentCollector codeFragmentCollector, final ParameterDeclaration parameterDeclaration) {
    CharSequence _xblockexpression = null;
    {
      StaticFunctionInfo _functionInfo = this.generatorContext.getFunctionInfo();
      IValue _value = _functionInfo.getValue(parameterDeclaration);
      final Type dataType = _value.getDataType();
      IMscriptGeneratorConfiguration _configuration = this.generatorContext.getConfiguration();
      MachineDataType _create = MachineDataTypes.create(_configuration, dataType);
      String _name = parameterDeclaration.getName();
      CharSequence _generateDataType = _create.generateDataType(_name, codeFragmentCollector, this);
      _xblockexpression = (_generateDataType);
    }
    return _xblockexpression;
  }
  
  private CharSequence generateDataType(final ICodeFragmentCollector codeFragmentCollector, final ParameterDeclaration parameterDeclaration, final String variableName) {
    CharSequence _xblockexpression = null;
    {
      StaticFunctionInfo _functionInfo = this.generatorContext.getFunctionInfo();
      IValue _value = _functionInfo.getValue(parameterDeclaration);
      final Type dataType = _value.getDataType();
      IMscriptGeneratorConfiguration _configuration = this.generatorContext.getConfiguration();
      MachineDataType _create = MachineDataTypes.create(_configuration, dataType);
      CharSequence _generateDataType = _create.generateDataType(variableName, codeFragmentCollector, this);
      _xblockexpression = (_generateDataType);
    }
    return _xblockexpression;
  }
  
  private CharSequence generateUpdateContextStatement(final ParameterDeclaration inputParameterDeclaration) {
    StringConcatenation _builder = new StringConcatenation();
    IVariableAccessStrategy _variableAccessStrategy = this.generatorContext.getVariableAccessStrategy();
    String _name = inputParameterDeclaration.getName();
    CharSequence _generateContextMemberAccess = _variableAccessStrategy.generateContextMemberAccess(false, _name);
    _builder.append(_generateContextMemberAccess, "");
    _builder.append("[");
    CharSequence _generateIndexVariable = this.generateIndexVariable(inputParameterDeclaration);
    _builder.append(_generateIndexVariable, "");
    _builder.append("] = ");
    IVariableAccessStrategy _variableAccessStrategy_1 = this.generatorContext.getVariableAccessStrategy();
    StaticFunctionInfo _functionInfo = this.generatorContext.getFunctionInfo();
    FeatureReference _createVariableReference = MscriptUtil.createVariableReference(_functionInfo, inputParameterDeclaration, 0, false);
    CharSequence _generateVariableReference = _variableAccessStrategy_1.generateVariableReference(_createVariableReference);
    _builder.append(_generateVariableReference, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  private CharSequence generateIndexVariable(final VariableDeclaration variableDeclaration) {
    IVariableAccessStrategy _variableAccessStrategy = this.generatorContext.getVariableAccessStrategy();
    String _name = variableDeclaration.getName();
    String _plus = (_name + "_index");
    CharSequence _generateContextMemberAccess = _variableAccessStrategy.generateContextMemberAccess(false, _plus);
    return _generateContextMemberAccess;
  }
  
  public int hashCode() {
    Class<? extends Object> _class = this.getClass();
    int _hashCode = _class.hashCode();
    StaticFunctionInfo _functionInfo = this.generatorContext.getFunctionInfo();
    int _hashCode_1 = _functionInfo.hashCode();
    int _bitwiseXor = (_hashCode ^ _hashCode_1);
    IMscriptGeneratorConfiguration _configuration = this.generatorContext.getConfiguration();
    ComputationModel _computationModel = _configuration.getComputationModel();
    int _hashCode_2 = _computationModel.hashCode();
    return (_bitwiseXor ^ _hashCode_2);
  }
  
  public boolean equals(final Object obj) {
    if ((obj instanceof ComputeFunction)) {
      final ComputeFunction other = ((ComputeFunction) obj);
      boolean _and = false;
      StaticFunctionInfo _functionInfo = other.generatorContext.getFunctionInfo();
      StaticFunctionInfo _functionInfo_1 = this.generatorContext.getFunctionInfo();
      boolean _equals = Objects.equal(_functionInfo, _functionInfo_1);
      if (!_equals) {
        _and = false;
      } else {
        IMscriptGeneratorConfiguration _configuration = other.generatorContext.getConfiguration();
        ComputationModel _computationModel = _configuration.getComputationModel();
        IMscriptGeneratorConfiguration _configuration_1 = this.generatorContext.getConfiguration();
        ComputationModel _computationModel_1 = _configuration_1.getComputationModel();
        boolean _equals_1 = Objects.equal(_computationModel, _computationModel_1);
        _and = (_equals && _equals_1);
      }
      return _and;
    }
    return false;
  }
}
