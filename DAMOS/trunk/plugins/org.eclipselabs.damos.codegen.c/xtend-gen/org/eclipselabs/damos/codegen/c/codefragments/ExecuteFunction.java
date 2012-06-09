package org.eclipselabs.damos.codegen.c.codefragments;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipselabs.damos.codegen.c.IGeneratorContext;
import org.eclipselabs.damos.codegen.c.IGraphGenerator;
import org.eclipselabs.damos.codegen.c.codefragments.ContextVariable;
import org.eclipselabs.damos.codegen.c.codefragments.InputStruct;
import org.eclipselabs.damos.codegen.c.codefragments.OutputStruct;
import org.eclipselabs.damos.codegen.c.codefragments.PrimaryCodeFragment;
import org.eclipselabs.damos.codegen.c.internal.util.InternalGeneratorUtil;
import org.eclipselabs.damos.codegen.c.util.GeneratorConfigurationUtil;
import org.eclipselabs.damos.dconfig.Configuration;
import org.eclipselabs.damos.execution.ComponentNode;
import org.eclipselabs.damos.execution.ExecutionFlow;
import org.eclipselabs.damos.execution.Graph;
import org.eclipselabs.damos.mscript.codegen.c.ICodeFragment;
import org.eclipselabs.damos.mscript.codegen.c.ICodeFragment.IDependencyRule;
import org.eclipselabs.damos.mscript.codegen.c.Include;

/**
 * @author Andreas Unger
 */
@SuppressWarnings("all")
public class ExecuteFunction extends PrimaryCodeFragment {
  private final IGraphGenerator graphGenerator;
  
  private final Collection<Include> implementationIncludes = new Function0<Collection<Include>>() {
    public Collection<Include> apply() {
      ArrayList<Include> _arrayList = new ArrayList<Include>();
      return _arrayList;
    }
  }.apply();
  
  private CharSequence functionSignature;
  
  private CharSequence functionBody;
  
  public ExecuteFunction(final IGraphGenerator graphGenerator) {
    this.graphGenerator = graphGenerator;
    Include _include = new Include("math.h");
    this.implementationIncludes.add(_include);
  }
  
  public void doInitialize(final IGeneratorContext context, final IProgressMonitor monitor) {
    final Function1<ICodeFragment,Boolean> _function = new Function1<ICodeFragment,Boolean>() {
        public Boolean apply(final ICodeFragment other) {
          boolean _or = false;
          if ((other instanceof InputStruct)) {
            _or = true;
          } else {
            _or = ((other instanceof InputStruct) || (other instanceof OutputStruct));
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
        public Boolean apply(final ICodeFragment other) {
          return (other instanceof ContextVariable);
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
    CharSequence _generateFunctionSignature = this.generateFunctionSignature(context);
    this.functionSignature = _generateFunctionSignature;
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("{");
    _builder.newLine();
    _builder.append("\t");
    CharSequence _generateOutputVariableDeclarations = this.graphGenerator.generateOutputVariableDeclarations(context, graph, monitor);
    _builder.append(_generateOutputVariableDeclarations, "	");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
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
  
  public Collection<Include> getImplementationIncludes() {
    return this.implementationIncludes;
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
  
  private CharSequence generateFunctionSignature(final IGeneratorContext context) {
    Configuration _configuration = context.getConfiguration();
    final String prefix = GeneratorConfigurationUtil.getPrefix(_configuration);
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
      CharSequence _xblockexpression = null;
      {
        CharSequence _xifexpression_1 = null;
        if (hasInput) {
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("const ");
          _builder.append(prefix, "");
          _builder.append("Input *input");
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
          StringConcatenation _builder_1 = new StringConcatenation();
          _builder_1.append(prefix, "");
          _builder_1.append("Output *output");
          _xifexpression_2 = _builder_1;
        }
        final CharSequence outputParameter = _xifexpression_2;
        StringConcatenation _builder_2 = new StringConcatenation();
        _builder_2.append(inputParameter, "");
        _builder_2.append(outputParameter, "");
        _xblockexpression = (_builder_2);
      }
      _xifexpression = _xblockexpression;
    } else {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("void");
      _xifexpression = _builder;
    }
    final CharSequence parameters = _xifexpression;
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("void ");
    _builder_1.append(prefix, "");
    _builder_1.append("execute(");
    _builder_1.append(parameters, "");
    _builder_1.append(")");
    return _builder_1;
  }
}
