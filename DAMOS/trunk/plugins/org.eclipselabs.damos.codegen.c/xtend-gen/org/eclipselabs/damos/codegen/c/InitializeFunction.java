package org.eclipselabs.damos.codegen.c;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import java.util.ArrayList;
import java.util.Collection;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipselabs.damos.codegen.c.ContextVariable;
import org.eclipselabs.damos.codegen.c.IComponentGenerator;
import org.eclipselabs.damos.codegen.c.IGeneratorContext;
import org.eclipselabs.damos.codegen.c.ITaskGenerator;
import org.eclipselabs.damos.codegen.c.PrimaryCodeFragment;
import org.eclipselabs.damos.codegen.c.internal.util.InternalGeneratorUtil;
import org.eclipselabs.damos.dconfig.Configuration;
import org.eclipselabs.damos.dml.Component;
import org.eclipselabs.damos.execution.ComponentNode;
import org.eclipselabs.damos.execution.ExecutionFlow;
import org.eclipselabs.damos.execution.Node;
import org.eclipselabs.damos.mscript.codegen.c.ICodeFragment;
import org.eclipselabs.damos.mscript.codegen.c.ICodeFragment.IDependencyRule;
import org.eclipselabs.damos.mscript.codegen.c.Include;

/**
 * @author Andreas Unger
 */
@SuppressWarnings("all")
public class InitializeFunction extends PrimaryCodeFragment {
  private final ITaskGenerator taskGenerator;
  
  private final Collection<Include> implementationIncludes = new Function0<Collection<Include>>() {
    public Collection<Include> apply() {
      ArrayList<Include> _arrayList = new ArrayList<Include>();
      return _arrayList;
    }
  }.apply();
  
  private CharSequence functionSignature;
  
  private CharSequence functionBody;
  
  @Inject
  public InitializeFunction(final ITaskGenerator taskGenerator) {
    this.taskGenerator = taskGenerator;
    Include _include = new Include("math.h");
    this.implementationIncludes.add(_include);
  }
  
  public void doInitialize(final IGeneratorContext context, final IProgressMonitor monitor) {
    final Function1<ICodeFragment,Boolean> _function = new Function1<ICodeFragment,Boolean>() {
        public Boolean apply(final ICodeFragment other) {
          return (other instanceof ContextVariable);
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
          IComponentGenerator _componentGenerator = InternalGeneratorUtil.getComponentGenerator(n);
          boolean _contributesInitializationCode = _componentGenerator.contributesInitializationCode();
          return Boolean.valueOf(_contributesInitializationCode);
        }
      };
    final Iterable<ComponentNode> nodes = IterableExtensions.<ComponentNode>filter(_filter, _function_1);
    for (final ComponentNode node : nodes) {
      {
        IComponentGenerator _componentGenerator = InternalGeneratorUtil.getComponentGenerator(node);
        final Collection<Include> includes = _componentGenerator.getInitializationCodeIncludes();
        boolean _notEquals = (!Objects.equal(includes, null));
        if (_notEquals) {
          this.implementationIncludes.addAll(includes);
        }
      }
    }
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("void ");
    Configuration _configuration = context.getConfiguration();
    String _prefix = InternalGeneratorUtil.getPrefix(_configuration);
    _builder.append(_prefix, "");
    _builder.append("initialize(void)");
    this.functionSignature = _builder;
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("{");
    _builder_1.newLine();
    _builder_1.append("\t");
    CharSequence _generateInitializeTasks = this.taskGenerator.generateInitializeTasks(context, monitor);
    _builder_1.append(_generateInitializeTasks, "	");
    _builder_1.newLineIfNotEmpty();
    {
      boolean _hasElements = false;
      for(final ComponentNode node_1 : nodes) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder_1.appendImmediate("\n", "	");
        }
        _builder_1.append("\t");
        _builder_1.append("/* ");
        Component _component = node_1.getComponent();
        String _name = _component.getName();
        _builder_1.append(_name, "	");
        _builder_1.append(" */");
        _builder_1.newLineIfNotEmpty();
        _builder_1.append("\t");
        _builder_1.append("{");
        _builder_1.newLine();
        _builder_1.append("\t");
        _builder_1.append("\t");
        IComponentGenerator _componentGenerator = InternalGeneratorUtil.getComponentGenerator(node_1);
        CharSequence _generateInitializationCode = _componentGenerator.generateInitializationCode(monitor);
        _builder_1.append(_generateInitializationCode, "		");
        _builder_1.newLineIfNotEmpty();
        _builder_1.append("\t");
        _builder_1.append("}");
        _builder_1.newLine();
      }
    }
    _builder_1.append("}");
    _builder_1.newLine();
    this.functionBody = _builder_1;
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
}
