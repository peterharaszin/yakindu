package org.eclipselabs.damos.codegen.c.codefragments;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipselabs.damos.codegen.c.IComponentGenerator;
import org.eclipselabs.damos.codegen.c.IGeneratorContext;
import org.eclipselabs.damos.codegen.c.codefragments.ComponentContextDeclarations;
import org.eclipselabs.damos.codegen.c.util.GeneratorConfigurationExtensions;
import org.eclipselabs.damos.codegen.c.util.GeneratorNodeExtensions;
import org.eclipselabs.damos.dconfig.Configuration;
import org.eclipselabs.damos.dml.Component;
import org.eclipselabs.damos.execution.ComponentNode;
import org.eclipselabs.damos.execution.ExecutionFlow;
import org.eclipselabs.damos.execution.Node;
import org.eclipselabs.damos.mscript.codegen.c.ICodeFragment;
import org.eclipselabs.damos.mscript.codegen.c.Include;
import org.eclipselabs.damos.mscript.codegen.c.codefragments.AbstractContextStructPart;
import org.eclipselabs.damos.mscript.codegen.c.codefragments.ContextStruct;

/**
 * @author Andreas Unger
 */
@SuppressWarnings("all")
public class ComponentContexts extends AbstractContextStructPart {
  private final Collection<Include> forwardDeclarationIncludes;
  
  private final Collection<ICodeFragment> declarationCodeFragments;
  
  private final CharSequence content;
  
  private ComponentContexts(final Collection<Include> forwardDeclarationIncludes, final Collection<ICodeFragment> declarationCodeFragments, final CharSequence content) {
    this.forwardDeclarationIncludes = forwardDeclarationIncludes;
    this.declarationCodeFragments = declarationCodeFragments;
    this.content = content;
  }
  
  public static void initialize(final IGeneratorContext context, final IProgressMonitor monitor) {
    ExecutionFlow _executionFlow = context.getExecutionFlow();
    Iterable<Node> _allNodes = _executionFlow.getAllNodes();
    Iterable<ComponentNode> _filter = Iterables.<ComponentNode>filter(_allNodes, ComponentNode.class);
    final Function1<ComponentNode,Boolean> _function = new Function1<ComponentNode,Boolean>() {
        public Boolean apply(final ComponentNode n) {
          IComponentGenerator _componentGenerator = GeneratorNodeExtensions.getComponentGenerator(n);
          boolean _contributesContextCode = _componentGenerator.contributesContextCode();
          return Boolean.valueOf(_contributesContextCode);
        }
      };
    final Iterable<ComponentNode> nodes = IterableExtensions.<ComponentNode>filter(_filter, _function);
    boolean _isEmpty = IterableExtensions.isEmpty(nodes);
    if (_isEmpty) {
      return;
    }
    ArrayList<Include> _arrayList = new ArrayList<Include>();
    final ArrayList<Include> forwardDeclarationIncludes = _arrayList;
    for (final ComponentNode node : nodes) {
      {
        IComponentGenerator _componentGenerator = GeneratorNodeExtensions.getComponentGenerator(node);
        final Collection<Include> includes = _componentGenerator.getContextCodeIncludes();
        boolean _notEquals = (!Objects.equal(includes, null));
        if (_notEquals) {
          forwardDeclarationIncludes.addAll(includes);
        }
      }
    }
    StringConcatenation _builder = new StringConcatenation();
    {
      for(final ComponentNode node_1 : nodes) {
        CharSequence _contextTypeName = ComponentContexts.getContextTypeName(context, node_1);
        _builder.append(_contextTypeName, "");
        _builder.append(" ");
        Configuration _configuration = context.getConfiguration();
        String _prefix = GeneratorConfigurationExtensions.getPrefix(_configuration, node_1);
        _builder.append(_prefix, "");
        Component _component = node_1.getComponent();
        String _name = _component.getName();
        _builder.append(_name, "");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
      }
    }
    final CharSequence content = _builder;
    Collection<ICodeFragment> declarationCodeFragments = Collections.<ICodeFragment>emptyList();
    final Function1<ComponentNode,Boolean> _function_1 = new Function1<ComponentNode,Boolean>() {
        public Boolean apply(final ComponentNode n) {
          IComponentGenerator _componentGenerator = GeneratorNodeExtensions.getComponentGenerator(n);
          CharSequence _contextTypeName = _componentGenerator.getContextTypeName();
          boolean _equals = Objects.equal(_contextTypeName, null);
          return Boolean.valueOf(_equals);
        }
      };
    final Iterable<ComponentNode> declarationNodes = IterableExtensions.<ComponentNode>filter(nodes, _function_1);
    boolean _isEmpty_1 = IterableExtensions.isEmpty(declarationNodes);
    boolean _not = (!_isEmpty_1);
    if (_not) {
      StringConcatenation _builder_1 = new StringConcatenation();
      {
        boolean _hasElements = false;
        for(final ComponentNode node_2 : declarationNodes) {
          if (!_hasElements) {
            _hasElements = true;
          } else {
            _builder_1.appendImmediate("\n", "");
          }
          IComponentGenerator _componentGenerator = GeneratorNodeExtensions.getComponentGenerator(node_2);
          CharSequence _contextTypeName_1 = ComponentContexts.getContextTypeName(context, node_2);
          CharSequence _generateContextCode = _componentGenerator.generateContextCode(_contextTypeName_1, monitor);
          _builder_1.append(_generateContextCode, "");
          _builder_1.newLineIfNotEmpty();
        }
      }
      final CharSequence declarationContent = _builder_1;
      ComponentContextDeclarations _componentContextDeclarations = new ComponentContextDeclarations(declarationContent);
      final ComponentContextDeclarations declarationCodeFragment = _componentContextDeclarations;
      NullProgressMonitor _nullProgressMonitor = new NullProgressMonitor();
      context.<ComponentContextDeclarations>addCodeFragment(declarationCodeFragment, _nullProgressMonitor);
      Set<ICodeFragment> _singleton = Collections.<ICodeFragment>singleton(declarationCodeFragment);
      declarationCodeFragments = _singleton;
    }
    Configuration _configuration_1 = context.getConfiguration();
    boolean _isSingleton = GeneratorConfigurationExtensions.isSingleton(_configuration_1);
    ContextStruct _contextStruct = new ContextStruct(_isSingleton);
    NullProgressMonitor _nullProgressMonitor_1 = new NullProgressMonitor();
    final ContextStruct contextStruct = context.<ContextStruct>addCodeFragment(_contextStruct, _nullProgressMonitor_1);
    ComponentContexts _componentContexts = new ComponentContexts(forwardDeclarationIncludes, declarationCodeFragments, content);
    contextStruct.addPart(_componentContexts);
  }
  
  public Collection<Include> getForwardDeclarationIncludes() {
    return this.forwardDeclarationIncludes;
  }
  
  public Collection<ICodeFragment> getDeclarationCodeFragments() {
    return this.declarationCodeFragments;
  }
  
  public CharSequence generate() {
    return this.content;
  }
  
  private static CharSequence getContextTypeName(final IGeneratorContext context, final ComponentNode node) {
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
