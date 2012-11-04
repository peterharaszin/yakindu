package org.eclipse.damos.codegen.c.codefragments;

import com.google.inject.Inject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.damos.codegen.c.IGeneratorContext;
import org.eclipse.damos.codegen.c.IGraphGenerator;
import org.eclipse.damos.codegen.c.codefragments.ContextVariable;
import org.eclipse.damos.codegen.c.codefragments.InputStruct;
import org.eclipse.damos.codegen.c.codefragments.OutputStruct;
import org.eclipse.damos.codegen.c.codefragments.PrimaryCodeFragment;
import org.eclipse.damos.codegen.c.internal.util.InternalGeneratorUtil;
import org.eclipse.damos.codegen.c.util.GeneratorConfigurationExtensions;
import org.eclipse.damos.dconfig.Configuration;
import org.eclipse.damos.execution.ComponentNode;
import org.eclipse.damos.execution.ExecutionFlow;
import org.eclipse.damos.execution.Graph;
import org.eclipse.damos.mscript.codegen.c.FunctionGenerator;
import org.eclipse.damos.mscript.codegen.c.ICodeFragment;
import org.eclipse.damos.mscript.codegen.c.ICodeFragment.IDependencyRule;
import org.eclipse.damos.mscript.codegen.c.Include;
import org.eclipse.damos.mscript.codegen.c.VariableDeclarationGenerator;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Functions.Function1;

/**
 * @author Andreas Unger
 */
@SuppressWarnings("all")
public class ExecuteFunction extends PrimaryCodeFragment {
  @Inject
  private VariableDeclarationGenerator variableDeclarationGenerator;
  
  @Inject
  private FunctionGenerator functionGenerator;
  
  @Inject
  private IGraphGenerator graphGenerator;
  
  private final Collection<Include> implementationIncludes = new Function0<Collection<Include>>() {
    public Collection<Include> apply() {
      ArrayList<Include> _arrayList = new ArrayList<Include>();
      return _arrayList;
    }
  }.apply();
  
  private CharSequence prefix;
  
  private CharSequence parameters;
  
  private CharSequence functionBody;
  
  public ExecuteFunction() {
    Include _include = new Include("math.h");
    this.implementationIncludes.add(_include);
    Include _include_1 = new Include("string.h");
    this.implementationIncludes.add(_include_1);
  }
  
  public void doInitialize(final IGeneratorContext context, final IProgressMonitor monitor) {
    final Function1<ICodeFragment,Boolean> _function = new Function1<ICodeFragment,Boolean>() {
        public Boolean apply(final ICodeFragment it) {
          boolean _or = false;
          if ((it instanceof InputStruct)) {
            _or = true;
          } else {
            _or = ((it instanceof InputStruct) || (it instanceof OutputStruct));
          }
          return _or;
        }
      };
    this.addDependency(ICodeFragment.FORWARD_DECLARATION_DEPENDS_ON, new IDependencyRule() {
        public boolean applies(ICodeFragment other) {
          return _function.apply(other);
        }
    });
    final Function1<ICodeFragment,Boolean> _function_1 = new Function1<ICodeFragment,Boolean>() {
        public Boolean apply(final ICodeFragment it) {
          return (it instanceof ContextVariable);
        }
      };
    this.addDependency(ICodeFragment.IMPLEMENTATION_DEPENDS_ON, new IDependencyRule() {
        public boolean applies(ICodeFragment other) {
          return _function_1.apply(other);
        }
    });
    ExecutionFlow _executionFlow = context.getExecutionFlow();
    final Graph graph = _executionFlow.getGraph();
    Collection<Include> _implementationIncludes = this.graphGenerator.getImplementationIncludes(context, graph);
    this.implementationIncludes.addAll(_implementationIncludes);
    Configuration _configuration = context.getConfiguration();
    String _prefix = GeneratorConfigurationExtensions.getPrefix(_configuration);
    this.prefix = _prefix;
    CharSequence _generateParameters = this.generateParameters(context);
    this.parameters = _generateParameters;
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("{");
    _builder.newLine();
    {
      boolean _contributesOutputVariableDeclarations = this.graphGenerator.contributesOutputVariableDeclarations(context, graph);
      if (_contributesOutputVariableDeclarations) {
        _builder.append("\t");
        CharSequence _generateOutputVariableDeclarations = this.graphGenerator.generateOutputVariableDeclarations(context, graph, monitor);
        _builder.append(_generateOutputVariableDeclarations, "	");
        _builder.newLineIfNotEmpty();
        _builder.newLine();
      }
    }
    _builder.append("\t");
    CharSequence _generateGraph = this.graphGenerator.generateGraph(context, graph, monitor);
    _builder.append(_generateGraph, "	");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    this.functionBody = _builder;
  }
  
  public Collection<Include> getForwardDeclarationIncludes() {
    Include _include = new Include("stdint.h");
    return Collections.<Include>singleton(_include);
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
  
  public Collection<Include> getImplementationIncludes() {
    return this.implementationIncludes;
  }
  
  public CharSequence generateImplementation(final boolean internal) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _generateFunctionSignature = this.generateFunctionSignature(internal);
    _builder.append(_generateFunctionSignature, "");
    _builder.append(" ");
    _builder.append(this.functionBody, "");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  protected CharSequence generateFunctionSignature(final boolean internal) {
    String _plus = (this.prefix + "execute");
    CharSequence _generateFunctionSignature = this.functionGenerator.generateFunctionSignature("void", _plus, this.parameters, internal);
    return _generateFunctionSignature;
  }
  
  protected CharSequence generateParameters(final IGeneratorContext context) {
    CharSequence _xblockexpression = null;
    {
      Configuration _configuration = context.getConfiguration();
      boolean _isSingleton = GeneratorConfigurationExtensions.isSingleton(_configuration);
      final boolean hasContext = (!_isSingleton);
      List<ComponentNode> _inportNodes = InternalGeneratorUtil.getInportNodes(context);
      boolean _isEmpty = _inportNodes.isEmpty();
      final boolean hasInput = (!_isEmpty);
      List<ComponentNode> _outportNodes = InternalGeneratorUtil.getOutportNodes(context);
      boolean _isEmpty_1 = _outportNodes.isEmpty();
      final boolean hasOutput = (!_isEmpty_1);
      CharSequence _xifexpression = null;
      boolean _or = false;
      if (hasInput) {
        _or = true;
      } else {
        _or = (hasInput || hasOutput);
      }
      if (_or) {
        CharSequence _xblockexpression_1 = null;
        {
          CharSequence _xifexpression_1 = null;
          if (hasInput) {
            StringConcatenation _builder = new StringConcatenation();
            String _plus = (this.prefix + "Input");
            CharSequence _generateVariableDeclaration = this.variableDeclarationGenerator.generateVariableDeclaration(_plus, "input", true, true);
            _builder.append(_generateVariableDeclaration, "");
            {
              if (hasOutput) {
                _builder.append(", ");
              }
            }
            _xifexpression_1 = _builder;
          }
          final CharSequence inputParameter = _xifexpression_1;
          CharSequence _xifexpression_2 = null;
          if (hasOutput) {
            String _plus_1 = (this.prefix + "Output");
            CharSequence _generateVariableDeclaration_1 = this.variableDeclarationGenerator.generateVariableDeclaration(_plus_1, "output", false, true);
            _xifexpression_2 = _generateVariableDeclaration_1;
          }
          final CharSequence outputParameter = _xifexpression_2;
          StringConcatenation _builder_1 = new StringConcatenation();
          {
            if (hasContext) {
              CharSequence _generateContextParameter = this.generateContextParameter();
              _builder_1.append(_generateContextParameter, "");
              _builder_1.append(", ");
            }
          }
          _builder_1.append(inputParameter, "");
          _builder_1.append(outputParameter, "");
          _xblockexpression_1 = (_builder_1);
        }
        _xifexpression = _xblockexpression_1;
      } else {
        CharSequence _xifexpression_1 = null;
        if (hasContext) {
          CharSequence _generateContextParameter = this.generateContextParameter();
          _xifexpression_1 = _generateContextParameter;
        }
        _xifexpression = _xifexpression_1;
      }
      _xblockexpression = (_xifexpression);
    }
    return _xblockexpression;
  }
  
  protected CharSequence generateContextParameter() {
    String _plus = (this.prefix + "Context");
    CharSequence _generateVariableDeclaration = this.variableDeclarationGenerator.generateVariableDeclaration(_plus, "context", false, true);
    return _generateVariableDeclaration;
  }
}
