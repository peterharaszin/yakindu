package org.eclipselabs.damos.codegen.c.codefragments;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import java.util.ArrayList;
import java.util.Collection;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipselabs.damos.codegen.c.IComponentGenerator;
import org.eclipselabs.damos.codegen.c.IGeneratorContext;
import org.eclipselabs.damos.codegen.c.ITaskGenerator;
import org.eclipselabs.damos.codegen.c.codefragments.PrimaryCodeFragment;
import org.eclipselabs.damos.codegen.c.codefragments.TaskMessageStruct;
import org.eclipselabs.damos.codegen.c.codefragments.factories.ITaskMessageStructFactory;
import org.eclipselabs.damos.codegen.c.util.GeneratorConfigurationExtensions;
import org.eclipselabs.damos.codegen.c.util.GeneratorNodeExtensions;
import org.eclipselabs.damos.dconfig.Configuration;
import org.eclipselabs.damos.dml.Component;
import org.eclipselabs.damos.execution.ComponentNode;
import org.eclipselabs.damos.execution.ExecutionFlow;
import org.eclipselabs.damos.execution.Node;
import org.eclipselabs.damos.execution.TaskGraph;
import org.eclipselabs.damos.mscript.codegen.c.ICodeFragment;
import org.eclipselabs.damos.mscript.codegen.c.ICodeFragment.IDependencyRule;
import org.eclipselabs.damos.mscript.codegen.c.Include;

/**
 * @author Andreas Unger
 */
@SuppressWarnings("all")
public class ContextStruct extends PrimaryCodeFragment {
  private final ITaskGenerator taskGenerator;
  
  private final ITaskMessageStructFactory taskMessageStructFactory;
  
  private final Collection<Include> forwardDeclarationIncludes = new Function0<Collection<Include>>() {
    public Collection<Include> apply() {
      ArrayList<Include> _arrayList = new ArrayList<Include>();
      return _arrayList;
    }
  }.apply();
  
  private CharSequence content;
  
  @Inject
  public ContextStruct(final ITaskGenerator taskGenerator, final ITaskMessageStructFactory taskMessageStructFactory) {
    this.taskGenerator = taskGenerator;
    this.taskMessageStructFactory = taskMessageStructFactory;
  }
  
  public void doInitialize(final IGeneratorContext context, final IProgressMonitor monitor) {
    final Function1<ICodeFragment,Boolean> _function = new Function1<ICodeFragment,Boolean>() {
        public Boolean apply(final ICodeFragment other) {
          return (other instanceof TaskMessageStruct);
        }
      };
    this.addDependency(ICodeFragment.FORWARD_DECLARATION_DEPENDS_ON, new IDependencyRule() {
        public boolean applies(ICodeFragment other) {
          return _function.apply(other);
        }
    });
    ExecutionFlow _executionFlow = context.getExecutionFlow();
    EList<TaskGraph> _taskGraphs = _executionFlow.getTaskGraphs();
    boolean _isEmpty = _taskGraphs.isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      ICodeFragment _create = this.taskMessageStructFactory.create();
      context.<ICodeFragment>addCodeFragment(_create, monitor);
    }
    Configuration _configuration = context.getConfiguration();
    final String prefix = GeneratorConfigurationExtensions.getPrefix(_configuration);
    ExecutionFlow _executionFlow_1 = context.getExecutionFlow();
    Iterable<Node> _allNodes = _executionFlow_1.getAllNodes();
    Iterable<ComponentNode> _filter = Iterables.<ComponentNode>filter(_allNodes, ComponentNode.class);
    final Function1<ComponentNode,Boolean> _function_1 = new Function1<ComponentNode,Boolean>() {
        public Boolean apply(final ComponentNode n) {
          IComponentGenerator _componentGenerator = GeneratorNodeExtensions.getComponentGenerator(n);
          boolean _contributesContextCode = _componentGenerator.contributesContextCode();
          return Boolean.valueOf(_contributesContextCode);
        }
      };
    final Iterable<ComponentNode> nodes = IterableExtensions.<ComponentNode>filter(_filter, _function_1);
    for (final ComponentNode node : nodes) {
      {
        IComponentGenerator _componentGenerator = GeneratorNodeExtensions.getComponentGenerator(node);
        final Collection<Include> includes = _componentGenerator.getContextCodeIncludes();
        boolean _notEquals = (!Objects.equal(includes, null));
        if (_notEquals) {
          this.forwardDeclarationIncludes.addAll(includes);
        }
      }
    }
    StringConcatenation _builder = new StringConcatenation();
    {
      final Function1<ComponentNode,Boolean> _function_2 = new Function1<ComponentNode,Boolean>() {
          public Boolean apply(final ComponentNode n) {
            IComponentGenerator _componentGenerator = GeneratorNodeExtensions.getComponentGenerator(n);
            CharSequence _contextTypeName = _componentGenerator.getContextTypeName();
            boolean _equals = Objects.equal(_contextTypeName, null);
            return Boolean.valueOf(_equals);
          }
        };
      Iterable<ComponentNode> _filter_1 = IterableExtensions.<ComponentNode>filter(nodes, _function_2);
      boolean _hasElements = false;
      for(final ComponentNode node_1 : _filter_1) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate("\n", "");
        }
        IComponentGenerator _componentGenerator = GeneratorNodeExtensions.getComponentGenerator(node_1);
        CharSequence _contextTypeName = this.getContextTypeName(context, node_1);
        CharSequence _generateContextCode = _componentGenerator.generateContextCode(_contextTypeName, monitor);
        _builder.append(_generateContextCode, "");
        _builder.newLineIfNotEmpty();
      }
      if (_hasElements) {
        _builder.append("\n", "");
      }
    }
    _builder.append("typedef struct {");
    _builder.newLine();
    _builder.append("\t");
    CharSequence _generateTaskContexts = this.taskGenerator.generateTaskContexts(context, monitor);
    _builder.append(_generateTaskContexts, "	");
    _builder.newLineIfNotEmpty();
    {
      for(final ComponentNode node_2 : nodes) {
        _builder.append("\t");
        CharSequence _contextTypeName_1 = this.getContextTypeName(context, node_2);
        _builder.append(_contextTypeName_1, "	");
        _builder.append(" ");
        Configuration _configuration_1 = context.getConfiguration();
        String _prefix = GeneratorConfigurationExtensions.getPrefix(_configuration_1, node_2);
        _builder.append(_prefix, "	");
        Component _component = node_2.getComponent();
        String _name = _component.getName();
        _builder.append(_name, "	");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("} ");
    _builder.append(prefix, "");
    _builder.append("Context;");
    _builder.newLineIfNotEmpty();
    this.content = _builder;
  }
  
  public Collection<Include> getForwardDeclarationIncludes() {
    return this.forwardDeclarationIncludes;
  }
  
  public CharSequence generateForwardDeclaration(final boolean internal) {
    return this.content;
  }
  
  private CharSequence getContextTypeName(final IGeneratorContext context, final ComponentNode node) {
    IComponentGenerator _componentGenerator = GeneratorNodeExtensions.getComponentGenerator(node);
    CharSequence typeName = _componentGenerator.getContextTypeName();
    boolean _equals = Objects.equal(typeName, null);
    if (_equals) {
      Configuration _configuration = context.getConfiguration();
      String _prefix = GeneratorConfigurationExtensions.getPrefix(_configuration, node);
      Component _component = node.getComponent();
      String _name = _component.getName();
      String _plus = (_prefix + _name);
      String _plus_1 = (_plus + "_Context");
      typeName = _plus_1;
    }
    return typeName;
  }
}
