package org.eclipse.damos.mscript.codegen.c.codefragments;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import java.util.Collection;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.damos.mscript.CompoundStatement;
import org.eclipse.damos.mscript.FunctionDeclaration;
import org.eclipse.damos.mscript.InputParameterDeclaration;
import org.eclipse.damos.mscript.MscriptPackage;
import org.eclipse.damos.mscript.OutputParameterDeclaration;
import org.eclipse.damos.mscript.ParameterDeclaration;
import org.eclipse.damos.mscript.StateVariableDeclaration;
import org.eclipse.damos.mscript.Statement;
import org.eclipse.damos.mscript.VariableDeclaration;
import org.eclipse.damos.mscript.codegen.c.AbstractCodeFragment;
import org.eclipse.damos.mscript.codegen.c.ICodeFragment;
import org.eclipse.damos.mscript.codegen.c.ICodeFragment.IDependencyRule;
import org.eclipse.damos.mscript.codegen.c.ICodeFragmentCollector;
import org.eclipse.damos.mscript.codegen.c.ICodeFragmentContext;
import org.eclipse.damos.mscript.codegen.c.ICompoundStatementGenerator;
import org.eclipse.damos.mscript.codegen.c.IGlobalNameProvider;
import org.eclipse.damos.mscript.codegen.c.IMscriptGeneratorConfiguration;
import org.eclipse.damos.mscript.codegen.c.IMscriptGeneratorContext;
import org.eclipse.damos.mscript.codegen.c.IVariableAccessStrategy;
import org.eclipse.damos.mscript.codegen.c.codefragments.ContextStruct;
import org.eclipse.damos.mscript.codegen.c.codefragments.IComputeFunction;
import org.eclipse.damos.mscript.computation.ComputationModel;
import org.eclipse.damos.mscript.function.FunctionDescription;
import org.eclipse.damos.mscript.function.FunctionInstance;
import org.eclipse.damos.mscript.interpreter.StaticFunctionInfo;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * @author Andreas Unger
 */
@SuppressWarnings("all")
public class InitializeFunction extends AbstractCodeFragment {
  @Inject
  private ICompoundStatementGenerator compoundStatementGenerator;
  
  private final IMscriptGeneratorContext generatorContext;
  
  private final IComputeFunction computeFunction;
  
  private String name;
  
  private StaticFunctionInfo functionInfo;
  
  private FunctionInstance functionInstance;
  
  private CharSequence functionSignature;
  
  private ContextStruct contextStruct;
  
  public InitializeFunction(final IMscriptGeneratorContext generatorContext, final IComputeFunction computeFunction) {
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
          boolean _equals = Objects.equal(it, InitializeFunction.this.computeFunction);
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
    String _plus = (_name + "_initialize");
    String _newGlobalName = _globalNameProvider.newGlobalName(_plus);
    this.name = _newGlobalName;
    ContextStruct _xifexpression = null;
    FunctionDescription _functionDescription_1 = this.functionInfo.getFunctionDescription();
    FunctionDeclaration _declaration_1 = _functionDescription_1.getDeclaration();
    EClass _eClass = _declaration_1.eClass();
    EClass _standardFunctionDeclaration = MscriptPackage.eINSTANCE.getStandardFunctionDeclaration();
    boolean _notEquals = (!Objects.equal(_eClass, _standardFunctionDeclaration));
    if (_notEquals) {
      ContextStruct _contextStruct = new ContextStruct(false);
      NullProgressMonitor _nullProgressMonitor = new NullProgressMonitor();
      ContextStruct _addCodeFragment = codeFragmentCollector.<ContextStruct>addCodeFragment(_contextStruct, _nullProgressMonitor);
      _xifexpression = _addCodeFragment;
    } else {
      ContextStruct _contextStruct_1 = new ContextStruct(this.functionInfo, false);
      NullProgressMonitor _nullProgressMonitor_1 = new NullProgressMonitor();
      ContextStruct _addCodeFragment_1 = codeFragmentCollector.<ContextStruct>addCodeFragment(_contextStruct_1, _nullProgressMonitor_1);
      _xifexpression = _addCodeFragment_1;
    }
    this.contextStruct = _xifexpression;
    CharSequence _generateFunctionSignature = this.generateFunctionSignature(codeFragmentCollector);
    this.functionSignature = _generateFunctionSignature;
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
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    {
      Iterable<VariableDeclaration> _statefulVariables = this.getStatefulVariables();
      for(final VariableDeclaration variableDeclaration : _statefulVariables) {
        _builder.append("\t");
        CharSequence _generateIndexVariable = this.generateIndexVariable(variableDeclaration);
        _builder.append(_generateIndexVariable, "	");
        _builder.append(" = 0;");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t");
    CompoundStatement _initializationCompound = this.functionInstance.getInitializationCompound();
    EList<Statement> _statements = _initializationCompound.getStatements();
    CharSequence _generate = this.compoundStatementGenerator.generate(this.generatorContext, _statements);
    _builder.append(_generate, "	");
    _builder.newLineIfNotEmpty();
    {
      Collection<CharSequence> _initializeCalls = this.contextStruct.getInitializeCalls();
      for(final CharSequence initializeCall : _initializeCalls) {
        _builder.append("\t");
        _builder.append(initializeCall, "	");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  private CharSequence generateIndexVariable(final VariableDeclaration variableDeclaration) {
    IVariableAccessStrategy _variableAccessStrategy = this.generatorContext.getVariableAccessStrategy();
    String _name = variableDeclaration.getName();
    String _plus = (_name + "_index");
    CharSequence _generateContextMemberAccess = _variableAccessStrategy.generateContextMemberAccess(false, _plus);
    return _generateContextMemberAccess;
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
            int _circularBufferSize = InitializeFunction.this.functionInfo.getCircularBufferSize(it);
            boolean _greaterThan = (_circularBufferSize > 1);
            return Boolean.valueOf(_greaterThan);
          }
        };
      Iterable<VariableDeclaration> _filter = IterableExtensions.<VariableDeclaration>filter(_plus_1, _function);
      _xblockexpression = (_filter);
    }
    return _xblockexpression;
  }
  
  private CharSequence generateFunctionSignature(final ICodeFragmentCollector codeFragmentCollector) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("void ");
    _builder.append(this.name, "");
    _builder.append("(");
    {
      StaticFunctionInfo _functionInfo = this.generatorContext.getFunctionInfo();
      FunctionDescription _functionDescription = _functionInfo.getFunctionDescription();
      boolean _isStateful = _functionDescription.isStateful();
      if (_isStateful) {
        ContextStruct _contextStruct = this.computeFunction.getContextStruct();
        String _name = _contextStruct.getName();
        _builder.append(_name, "");
        _builder.append(" *context");
      }
    }
    _builder.append(")");
    return _builder;
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
    if ((obj instanceof InitializeFunction)) {
      final InitializeFunction other = ((InitializeFunction) obj);
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
