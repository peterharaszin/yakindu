package org.eclipse.damos.mscript.codegen.c.codefragments;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import java.util.Collection;
import java.util.List;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.damos.mscript.FeatureReference;
import org.eclipse.damos.mscript.FunctionDeclaration;
import org.eclipse.damos.mscript.InputParameterDeclaration;
import org.eclipse.damos.mscript.MscriptPackage;
import org.eclipse.damos.mscript.OutputParameterDeclaration;
import org.eclipse.damos.mscript.ParameterDeclaration;
import org.eclipse.damos.mscript.StateVariableDeclaration;
import org.eclipse.damos.mscript.Statement;
import org.eclipse.damos.mscript.Type;
import org.eclipse.damos.mscript.VariableDeclaration;
import org.eclipse.damos.mscript.codegen.c.AbstractCodeFragment;
import org.eclipse.damos.mscript.codegen.c.FunctionGenerator;
import org.eclipse.damos.mscript.codegen.c.ICodeFragment;
import org.eclipse.damos.mscript.codegen.c.ICodeFragment.IDependencyRule;
import org.eclipse.damos.mscript.codegen.c.ICodeFragmentCollector;
import org.eclipse.damos.mscript.codegen.c.ICodeFragmentContext;
import org.eclipse.damos.mscript.codegen.c.ICompoundStatementGenerator;
import org.eclipse.damos.mscript.codegen.c.IGlobalNameProvider;
import org.eclipse.damos.mscript.codegen.c.IMscriptGeneratorConfiguration;
import org.eclipse.damos.mscript.codegen.c.IMscriptGeneratorContext;
import org.eclipse.damos.mscript.codegen.c.IVariableAccessStrategy;
import org.eclipse.damos.mscript.codegen.c.VariableDeclarationGenerator;
import org.eclipse.damos.mscript.codegen.c.codefragments.ContextStruct;
import org.eclipse.damos.mscript.codegen.c.codefragments.IComputeFunction;
import org.eclipse.damos.mscript.codegen.c.codefragments.factories.IContextStructFactory;
import org.eclipse.damos.mscript.codegen.c.datatype.MachineDataType;
import org.eclipse.damos.mscript.codegen.c.datatype.MachineDataTypeFactory;
import org.eclipse.damos.mscript.computation.ComputationModel;
import org.eclipse.damos.mscript.function.ComputationCompound;
import org.eclipse.damos.mscript.function.FunctionDescription;
import org.eclipse.damos.mscript.function.FunctionInstance;
import org.eclipse.damos.mscript.function.util.FunctionModelUtil;
import org.eclipse.damos.mscript.interpreter.StaticFunctionInfo;
import org.eclipse.damos.mscript.interpreter.value.IValue;
import org.eclipse.damos.mscript.util.MscriptUtil;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * @author Andreas Unger
 */
@SuppressWarnings("all")
public class UpdateFunction extends AbstractCodeFragment {
  @Inject
  private ICompoundStatementGenerator compoundStatementGenerator;
  
  @Inject
  private MachineDataTypeFactory machineDataTypeFactory;
  
  @Inject
  private IContextStructFactory contextStructFactory;
  
  @Inject
  private VariableDeclarationGenerator variableDeclarationGenerator;
  
  @Inject
  private FunctionGenerator functionGenerator;
  
  private final IMscriptGeneratorContext generatorContext;
  
  private final IComputeFunction computeFunction;
  
  private String name;
  
  private StaticFunctionInfo functionInfo;
  
  private FunctionInstance functionInstance;
  
  private CharSequence parameters;
  
  private ContextStruct contextStruct;
  
  public UpdateFunction(final IMscriptGeneratorContext generatorContext, final IComputeFunction computeFunction) {
    this.generatorContext = generatorContext;
    this.computeFunction = computeFunction;
  }
  
  /**
   * @return the name
   */
  public String getName() {
    return this.name;
  }
  
  public void initialize(final ICodeFragmentContext context, final IProgressMonitor monitor) {
    final Function1<ICodeFragment,Boolean> _function = new Function1<ICodeFragment,Boolean>() {
        public Boolean apply(final ICodeFragment it) {
          boolean _equals = Objects.equal(it, UpdateFunction.this.computeFunction);
          return _equals;
        }
      };
    this.addDependency(ICodeFragment.FORWARD_DECLARATION_DEPENDS_ON, new IDependencyRule() {
        public boolean applies(ICodeFragment other) {
          return _function.apply(other);
        }
    });
    StaticFunctionInfo _functionInfo = this.generatorContext.getFunctionInfo();
    this.functionInfo = _functionInfo;
    FunctionInstance _functionInstance = this.functionInfo.getFunctionInstance();
    this.functionInstance = _functionInstance;
    final ICodeFragmentCollector codeFragmentCollector = context.getCodeFragmentCollector();
    IGlobalNameProvider _globalNameProvider = context.getGlobalNameProvider();
    StaticFunctionInfo _functionInfo_1 = this.generatorContext.getFunctionInfo();
    FunctionDescription _functionDescription = _functionInfo_1.getFunctionDescription();
    FunctionDeclaration _declaration = _functionDescription.getDeclaration();
    String _name = _declaration.getName();
    String _plus = (_name + "_update");
    String _newGlobalName = _globalNameProvider.newGlobalName(_plus);
    this.name = _newGlobalName;
    ContextStruct _xifexpression = null;
    FunctionDescription _functionDescription_1 = this.functionInfo.getFunctionDescription();
    FunctionDeclaration _declaration_1 = _functionDescription_1.getDeclaration();
    EClass _eClass = _declaration_1.eClass();
    EClass _standardFunctionDeclaration = MscriptPackage.eINSTANCE.getStandardFunctionDeclaration();
    boolean _notEquals = (!Objects.equal(_eClass, _standardFunctionDeclaration));
    if (_notEquals) {
      ICodeFragment _create = this.contextStructFactory.create(null, null, false);
      NullProgressMonitor _nullProgressMonitor = new NullProgressMonitor();
      ContextStruct _addCodeFragment = codeFragmentCollector.<ContextStruct>addCodeFragment(((ContextStruct) _create), _nullProgressMonitor);
      _xifexpression = _addCodeFragment;
    } else {
      ICodeFragment _create_1 = this.contextStructFactory.create(this.functionInfo, null, false);
      NullProgressMonitor _nullProgressMonitor_1 = new NullProgressMonitor();
      ContextStruct _addCodeFragment_1 = codeFragmentCollector.<ContextStruct>addCodeFragment(((ContextStruct) _create_1), _nullProgressMonitor_1);
      _xifexpression = _addCodeFragment_1;
    }
    this.contextStruct = _xifexpression;
    CharSequence _generateParameters = this.generateParameters(codeFragmentCollector);
    this.parameters = _generateParameters;
  }
  
  public CharSequence generateForwardDeclaration(final boolean internal) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _generateFunctionSignature = this.generateFunctionSignature(internal);
    _builder.append(_generateFunctionSignature, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  public boolean contributesImplementation() {
    return true;
  }
  
  public CharSequence generateImplementation(final boolean internal) {
    CharSequence _xblockexpression = null;
    {
      final List<InputParameterDeclaration> computeOutputsCodeInputs = FunctionModelUtil.getDirectFeedthroughInputs(this.functionInstance);
      StringConcatenation _builder = new StringConcatenation();
      CharSequence _generateFunctionSignature = this.generateFunctionSignature(internal);
      _builder.append(_generateFunctionSignature, "");
      _builder.append(" {");
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
              _and = (_isEmpty && _isEmpty_1);
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
        FunctionDeclaration _declaration = this.functionInstance.getDeclaration();
        EList<InputParameterDeclaration> _nonConstantInputParameterDeclarations = _declaration.getNonConstantInputParameterDeclarations();
        for(final InputParameterDeclaration inputParameterDeclaration : _nonConstantInputParameterDeclarations) {
          {
            boolean _and_1 = false;
            StaticFunctionInfo _functionInfo = this.generatorContext.getFunctionInfo();
            int _circularBufferSize = _functionInfo.getCircularBufferSize(inputParameterDeclaration);
            boolean _greaterThan = (_circularBufferSize > 1);
            if (!_greaterThan) {
              _and_1 = false;
            } else {
              boolean _contains = computeOutputsCodeInputs.contains(inputParameterDeclaration);
              boolean _not = (!_contains);
              _and_1 = (_greaterThan && _not);
            }
            if (_and_1) {
              _builder.append("\t");
              CharSequence _generateUpdateInputContextStatement = this.generateUpdateInputContextStatement(inputParameterDeclaration);
              _builder.append(_generateUpdateInputContextStatement, "	");
              _builder.newLineIfNotEmpty();
            }
          }
        }
      }
      {
        Iterable<VariableDeclaration> _statefulVariables = this.getStatefulVariables();
        for(final VariableDeclaration variableDeclaration : _statefulVariables) {
          _builder.append("\t");
          CharSequence _generateIndexVariable = this.generateIndexVariable(variableDeclaration);
          _builder.append(_generateIndexVariable, "	");
          _builder.append(" = (");
          CharSequence _generateIndexVariable_1 = this.generateIndexVariable(variableDeclaration);
          _builder.append(_generateIndexVariable_1, "	");
          _builder.append(" + 1) % ");
          int _circularBufferSize_1 = this.functionInfo.getCircularBufferSize(variableDeclaration);
          _builder.append(_circularBufferSize_1, "	");
          _builder.append(";");
          _builder.newLineIfNotEmpty();
        }
      }
      {
        Collection<CharSequence> _updateCalls = this.contextStruct.getUpdateCalls();
        for(final CharSequence updateCall : _updateCalls) {
          _builder.append("\t");
          _builder.append(updateCall, "	");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.append("}");
      _builder.newLine();
      _xblockexpression = (_builder);
    }
    return _xblockexpression;
  }
  
  private Iterable<VariableDeclaration> getStatefulVariables() {
    Iterable<VariableDeclaration> _xblockexpression = null;
    {
      FunctionInstance _functionInstance = this.functionInfo.getFunctionInstance();
      final FunctionDeclaration functionDeclaration = _functionInstance.getDeclaration();
      EList<InputParameterDeclaration> _nonConstantInputParameterDeclarations = functionDeclaration.getNonConstantInputParameterDeclarations();
      EList<OutputParameterDeclaration> _outputParameterDeclarations = functionDeclaration.getOutputParameterDeclarations();
      Iterable<ParameterDeclaration> _plus = Iterables.<ParameterDeclaration>concat(_nonConstantInputParameterDeclarations, _outputParameterDeclarations);
      EList<StateVariableDeclaration> _stateVariableDeclarations = functionDeclaration.getStateVariableDeclarations();
      Iterable<VariableDeclaration> _plus_1 = Iterables.<VariableDeclaration>concat(_plus, _stateVariableDeclarations);
      final Function1<VariableDeclaration,Boolean> _function = new Function1<VariableDeclaration,Boolean>() {
          public Boolean apply(final VariableDeclaration it) {
            int _circularBufferSize = UpdateFunction.this.functionInfo.getCircularBufferSize(it);
            boolean _greaterThan = (_circularBufferSize > 1);
            return Boolean.valueOf(_greaterThan);
          }
        };
      Iterable<VariableDeclaration> _filter = IterableExtensions.<VariableDeclaration>filter(_plus_1, _function);
      _xblockexpression = (_filter);
    }
    return _xblockexpression;
  }
  
  private CharSequence generateUpdateInputContextStatement(final InputParameterDeclaration inputParameterDeclaration) {
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
  
  private CharSequence generateParameters(final ICodeFragmentCollector codeFragmentCollector) {
    CharSequence _xblockexpression = null;
    {
      final EList<InputParameterDeclaration> inputParameterDeclarations = this.getInputParameterDeclarations();
      StringConcatenation _builder = new StringConcatenation();
      {
        StaticFunctionInfo _functionInfo = this.generatorContext.getFunctionInfo();
        FunctionDescription _functionDescription = _functionInfo.getFunctionDescription();
        boolean _isStateful = _functionDescription.isStateful();
        if (_isStateful) {
          ContextStruct _contextStruct = this.computeFunction.getContextStruct();
          String _name = _contextStruct.getName();
          CharSequence _generateVariableDeclaration = this.variableDeclarationGenerator.generateVariableDeclaration(_name, "context", false, true);
          _builder.append(_generateVariableDeclaration, "");
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
          CharSequence _generateParameterDeclaration = this.generateParameterDeclaration(codeFragmentCollector, inputParameter);
          _builder.append(_generateParameterDeclaration, "");
        }
      }
      _xblockexpression = (_builder);
    }
    return _xblockexpression;
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
  
  private CharSequence generateDataType(final ICodeFragmentCollector codeFragmentCollector, final ParameterDeclaration parameterDeclaration, final String variableName) {
    CharSequence _xblockexpression = null;
    {
      StaticFunctionInfo _functionInfo = this.generatorContext.getFunctionInfo();
      IValue _value = _functionInfo.getValue(parameterDeclaration);
      final Type dataType = _value.getDataType();
      IMscriptGeneratorConfiguration _configuration = this.generatorContext.getConfiguration();
      MachineDataType _create = this.machineDataTypeFactory.create(_configuration, dataType);
      CharSequence _generateDataType = _create.generateDataType(variableName, codeFragmentCollector, this);
      _xblockexpression = (_generateDataType);
    }
    return _xblockexpression;
  }
  
  private EList<InputParameterDeclaration> getInputParameterDeclarations() {
    StaticFunctionInfo _functionInfo = this.generatorContext.getFunctionInfo();
    FunctionDescription _functionDescription = _functionInfo.getFunctionDescription();
    FunctionDeclaration _declaration = _functionDescription.getDeclaration();
    EList<InputParameterDeclaration> _nonConstantInputParameterDeclarations = _declaration.getNonConstantInputParameterDeclarations();
    return _nonConstantInputParameterDeclarations;
  }
  
  protected CharSequence generateFunctionSignature(final boolean internal) {
    CharSequence _generateFunctionSignature = this.functionGenerator.generateFunctionSignature("void", this.name, this.parameters, internal);
    return _generateFunctionSignature;
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
    if ((obj instanceof UpdateFunction)) {
      final UpdateFunction other = ((UpdateFunction) obj);
      boolean _and = false;
      boolean _equals = Objects.equal(other.functionInfo, this.functionInfo);
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
