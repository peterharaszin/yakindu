package org.eclipse.damos.codegen.c.codefragments;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import java.util.ArrayList;
import java.util.Collection;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.damos.codegen.c.IComponentGenerator;
import org.eclipse.damos.codegen.c.IGeneratorContext;
import org.eclipse.damos.codegen.c.ITaskGenerator;
import org.eclipse.damos.codegen.c.codefragments.ContextVariable;
import org.eclipse.damos.codegen.c.codefragments.PrimaryCodeFragment;
import org.eclipse.damos.codegen.c.util.GeneratorConfigurationExtensions;
import org.eclipse.damos.codegen.c.util.GeneratorNodeExtensions;
import org.eclipse.damos.dconfig.Configuration;
import org.eclipse.damos.dml.Component;
import org.eclipse.damos.execution.ComponentNode;
import org.eclipse.damos.execution.ExecutionFlow;
import org.eclipse.damos.execution.Node;
import org.eclipse.damos.mscript.codegen.c.FunctionGenerator;
import org.eclipse.damos.mscript.codegen.c.ICodeFragment;
import org.eclipse.damos.mscript.codegen.c.ICodeFragment.IDependencyRule;
import org.eclipse.damos.mscript.codegen.c.Include;
import org.eclipse.damos.mscript.codegen.c.VariableDeclarationGenerator;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * @author Andreas Unger
 */
@SuppressWarnings("all")
public class InitializeFunction extends PrimaryCodeFragment {
  @Inject
  private VariableDeclarationGenerator variableDeclarationGenerator;
  
  @Inject
  private FunctionGenerator functionGenerator;
  
  @Inject
  private ITaskGenerator taskGenerator;
  
  private final Collection<Include> implementationIncludes = new Function0<Collection<Include>>() {
    public Collection<Include> apply() {
      ArrayList<Include> _arrayList = new ArrayList<Include>();
      return _arrayList;
    }
  }.apply();
  
  private CharSequence prefix;
  
  private CharSequence parameters;
  
  private CharSequence functionBody;
  
  public InitializeFunction() {
    Include _include = new Include("math.h");
    this.implementationIncludes.add(_include);
  }
  
  public void doInitialize(final IGeneratorContext context, final IProgressMonitor monitor) {
    final Function1<ICodeFragment,Boolean> _function = new Function1<ICodeFragment,Boolean>() {
        public Boolean apply(final ICodeFragment it) {
          return (it instanceof ContextVariable);
        }
      };
    this.addDependency(ICodeFragment.IMPLEMENTATION_DEPENDS_ON, new IDependencyRule() {
        public boolean applies(ICodeFragment other) {
          return _function.apply(other);
        }
    });
    ExecutionFlow _executionFlow = context.getExecutionFlow();
    Iterable<Node> _allNodes = _executionFlow.getAllNodes();
    Iterable<ComponentNode> _filter = Iterables.<ComponentNode>filter(_allNodes, ComponentNode.class);
    final Function1<ComponentNode,Boolean> _function_1 = new Function1<ComponentNode,Boolean>() {
        public Boolean apply(final ComponentNode n) {
          IComponentGenerator _componentGenerator = GeneratorNodeExtensions.getComponentGenerator(n);
          boolean _contributesInitializationCode = _componentGenerator.contributesInitializationCode();
          return Boolean.valueOf(_contributesInitializationCode);
        }
      };
    final Iterable<ComponentNode> nodes = IterableExtensions.<ComponentNode>filter(_filter, _function_1);
    for (final ComponentNode node : nodes) {
      {
        IComponentGenerator _componentGenerator = GeneratorNodeExtensions.getComponentGenerator(node);
        final Collection<Include> includes = _componentGenerator.getInitializationCodeIncludes();
        boolean _notEquals = (!Objects.equal(includes, null));
        if (_notEquals) {
          this.implementationIncludes.addAll(includes);
        }
      }
    }
    Configuration _configuration = context.getConfiguration();
    String _prefix = GeneratorConfigurationExtensions.getPrefix(_configuration);
    this.prefix = _prefix;
    CharSequence _generateParameters = this.generateParameters(context);
    this.parameters = _generateParameters;
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("{");
    _builder.newLine();
    _builder.append("\t");
    CharSequence _generateInitializeTasks = this.taskGenerator.generateInitializeTasks(context, monitor);
    _builder.append(_generateInitializeTasks, "	");
    _builder.newLineIfNotEmpty();
    {
      boolean _hasElements = false;
      for(final ComponentNode node_1 : nodes) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate("\n", "	");
        }
        _builder.append("\t");
        _builder.append("/* ");
        Component _component = node_1.getComponent();
        String _name = _component.getName();
        _builder.append(_name, "	");
        _builder.append(" */");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("{");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t");
        IComponentGenerator _componentGenerator = GeneratorNodeExtensions.getComponentGenerator(node_1);
        CharSequence _generateInitializationCode = _componentGenerator.generateInitializationCode(monitor);
        _builder.append(_generateInitializationCode, "		");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
      }
    }
    _builder.append("}");
    _builder.newLine();
    this.functionBody = _builder;
  }
  
  protected CharSequence generateParameters(final IGeneratorContext context) {
    CharSequence _xifexpression = null;
    Configuration _configuration = context.getConfiguration();
    boolean _isSingleton = GeneratorConfigurationExtensions.isSingleton(_configuration);
    boolean _not = (!_isSingleton);
    if (_not) {
      String _plus = (this.prefix + "Context");
      CharSequence _generateVariableDeclaration = this.variableDeclarationGenerator.generateVariableDeclaration(_plus, "context", false, true);
      _xifexpression = _generateVariableDeclaration;
    }
    return _xifexpression;
  }
  
  protected CharSequence generateFunctionSignature(final boolean internal) {
    String _plus = (this.prefix + "initialize");
    CharSequence _generateFunctionSignature = this.functionGenerator.generateFunctionSignature("void", _plus, this.parameters, internal);
    return _generateFunctionSignature;
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
}
