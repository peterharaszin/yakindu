package org.eclipselabs.damos.codegen.c;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipselabs.damos.codegen.c.IComponentGenerator;
import org.eclipselabs.damos.codegen.c.IComponentGeneratorContext;
import org.eclipselabs.damos.codegen.c.ICompoundGenerator;
import org.eclipselabs.damos.codegen.c.IGeneratorContext;
import org.eclipselabs.damos.codegen.c.IGraphGenerator;
import org.eclipselabs.damos.codegen.c.MscriptGeneratorConfiguration;
import org.eclipselabs.damos.codegen.c.internal.util.CompoundGeneratorUtil;
import org.eclipselabs.damos.codegen.c.util.GeneratorConfigurationExtensions;
import org.eclipselabs.damos.codegen.c.util.GeneratorNodeExtensions;
import org.eclipselabs.damos.codegen.c.util.GeneratorUtil;
import org.eclipselabs.damos.dconfig.Configuration;
import org.eclipselabs.damos.dml.Action;
import org.eclipselabs.damos.dml.ActionLink;
import org.eclipselabs.damos.dml.Choice;
import org.eclipselabs.damos.dml.Component;
import org.eclipselabs.damos.dml.Compound;
import org.eclipselabs.damos.dml.InputPort;
import org.eclipselabs.damos.dml.Memory;
import org.eclipselabs.damos.dml.OutputPort;
import org.eclipselabs.damos.dml.WhileLoop;
import org.eclipselabs.damos.dml.WhileLoopCondition;
import org.eclipselabs.damos.execution.ActionNode;
import org.eclipselabs.damos.execution.ComponentNode;
import org.eclipselabs.damos.execution.CompoundNode;
import org.eclipselabs.damos.execution.Graph;
import org.eclipselabs.damos.execution.Node;
import org.eclipselabs.damos.execution.datatype.IComponentSignature;
import org.eclipselabs.damos.mscript.Type;
import org.eclipselabs.damos.mscript.codegen.c.DataTypeGenerator;
import org.eclipselabs.damos.mscript.codegen.c.ICodeFragmentCollector;
import org.eclipselabs.damos.mscript.computation.ComputationModel;

/**
 * @author Andreas Unger
 */
@SuppressWarnings("all")
public class CompoundGenerator implements ICompoundGenerator {
  private final DataTypeGenerator dataTypeGenerator = new Function0<DataTypeGenerator>() {
    public DataTypeGenerator apply() {
      DataTypeGenerator _dataTypeGenerator = new DataTypeGenerator();
      return _dataTypeGenerator;
    }
  }.apply();
  
  private final IGraphGenerator graphGenerator;
  
  @Inject
  public CompoundGenerator(final IGraphGenerator graphGenerator) {
    this.graphGenerator = graphGenerator;
  }
  
  public boolean contributesChoiceVariableDeclarations(final IGeneratorContext context, final Graph graph) {
    Iterable<Node> _allNodes = graph.getAllNodes();
    Iterable<ComponentNode> _filter = Iterables.<ComponentNode>filter(_allNodes, ComponentNode.class);
    final Function1<ComponentNode,Boolean> _function = new Function1<ComponentNode,Boolean>() {
        public Boolean apply(final ComponentNode n) {
          Component _component = n.getComponent();
          return Boolean.valueOf((_component instanceof Choice));
        }
      };
    boolean _exists = IterableExtensions.<ComponentNode>exists(_filter, _function);
    return _exists;
  }
  
  public CharSequence generateChoiceVariableDeclarations(final IGeneratorContext context, final Graph graph, final IProgressMonitor monitor) {
    StringConcatenation _builder = new StringConcatenation();
    {
      Iterable<Node> _allNodes = graph.getAllNodes();
      Iterable<ComponentNode> _filter = Iterables.<ComponentNode>filter(_allNodes, ComponentNode.class);
      final Function1<ComponentNode,Boolean> _function = new Function1<ComponentNode,Boolean>() {
          public Boolean apply(final ComponentNode n) {
            Component _component = n.getComponent();
            return Boolean.valueOf((_component instanceof Choice));
          }
        };
      Iterable<ComponentNode> _filter_1 = IterableExtensions.<ComponentNode>filter(_filter, _function);
      for(final ComponentNode node : _filter_1) {
        _builder.append("uint_fast8_t ");
        Configuration _configuration = context.getConfiguration();
        String _choiceVariableName = CompoundGeneratorUtil.getChoiceVariableName(_configuration, node);
        _builder.append(_choiceVariableName, "");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }
  
  public CharSequence generateCompoundCode(final IGeneratorContext context, final CompoundNode compoundNode, final IProgressMonitor monitor) {
    CharSequence _xblockexpression = null;
    {
      boolean _not = (!(compoundNode instanceof ActionNode));
      if (_not) {
        return "";
      }
      final ActionNode actionNode = ((ActionNode) compoundNode);
      Compound _compound = actionNode.getCompound();
      final Action action = ((Action) _compound);
      WhileLoop _xifexpression = null;
      if ((action instanceof WhileLoop)) {
        _xifexpression = ((WhileLoop) action);
      }
      final WhileLoop whileLoop = _xifexpression;
      Choice _xifexpression_1 = null;
      ComponentNode _choiceNode = actionNode.getChoiceNode();
      boolean _notEquals = (!Objects.equal(_choiceNode, null));
      if (_notEquals) {
        ComponentNode _choiceNode_1 = actionNode.getChoiceNode();
        Component _component = _choiceNode_1.getComponent();
        _xifexpression_1 = ((Choice) _component);
      }
      final Choice choice = _xifexpression_1;
      Configuration _configuration = context.getConfiguration();
      final String prefix = GeneratorConfigurationExtensions.getPrefix(_configuration, compoundNode);
      StringConcatenation _builder = new StringConcatenation();
      {
        boolean _notEquals_1 = (!Objects.equal(choice, null));
        if (_notEquals_1) {
          _builder.append("if (");
          _builder.append(prefix, "");
          String _name = choice.getName();
          _builder.append(_name, "");
          _builder.append("_result == ");
          int _actionIndex = this.getActionIndex(choice, action);
          _builder.append(_actionIndex, "");
          _builder.append(") {");
          _builder.newLineIfNotEmpty();
        } else {
          _builder.append("{");
          _builder.newLine();
        }
      }
      {
        EList<Node> _nodes = compoundNode.getNodes();
        Iterable<ComponentNode> _filter = Iterables.<ComponentNode>filter(_nodes, ComponentNode.class);
        final Function1<ComponentNode,Boolean> _function = new Function1<ComponentNode,Boolean>() {
            public Boolean apply(final ComponentNode n) {
              Component _component = n.getComponent();
              return Boolean.valueOf((_component instanceof Memory));
            }
          };
        Iterable<ComponentNode> _filter_1 = IterableExtensions.<ComponentNode>filter(_filter, _function);
        for(final ComponentNode node : _filter_1) {
          _builder.append("\t");
          CharSequence _generateMemoryVariableDeclaration = this.generateMemoryVariableDeclaration(context, node);
          _builder.append(_generateMemoryVariableDeclaration, "	");
          _builder.newLineIfNotEmpty();
        }
      }
      {
        boolean _notEquals_2 = (!Objects.equal(whileLoop, null));
        if (_notEquals_2) {
          _builder.append("\t");
          _builder.append("do {");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("\t");
          CharSequence _generateGraph = this.graphGenerator.generateGraph(context, compoundNode, monitor);
          _builder.append(_generateGraph, "		");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("} while (");
          Configuration _configuration_1 = context.getConfiguration();
          WhileLoopCondition _condition = whileLoop.getCondition();
          String _incomingVariableName = GeneratorUtil.getIncomingVariableName(_configuration_1, actionNode, _condition);
          String _elvis = ObjectExtensions.<String>operator_elvis(_incomingVariableName, "0");
          _builder.append(_elvis, "	");
          _builder.append(");");
          _builder.newLineIfNotEmpty();
        } else {
          _builder.append("\t");
          CharSequence _generateGraph_1 = this.graphGenerator.generateGraph(context, compoundNode, monitor);
          _builder.append(_generateGraph_1, "	");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.append("}");
      _builder.newLine();
      _xblockexpression = (_builder);
    }
    return _xblockexpression;
  }
  
  private CharSequence generateMemoryVariableDeclaration(final IGeneratorContext context, final ComponentNode node) {
    CharSequence _xblockexpression = null;
    {
      final IComponentGenerator generator = GeneratorNodeExtensions.getComponentGenerator(node);
      Configuration _configuration = context.getConfiguration();
      final ComputationModel computationModel = GeneratorConfigurationExtensions.getComputationModel(_configuration, node);
      IComponentGeneratorContext _context = generator.getContext();
      IComponentSignature _componentSignature = _context.getComponentSignature();
      Component _component = node.getComponent();
      OutputPort _firstOutputPort = _component.getFirstOutputPort();
      final Type outputDataType = _componentSignature.getOutputDataType(_firstOutputPort);
      Configuration _configuration_1 = context.getConfiguration();
      final String variableName = CompoundGeneratorUtil.getMemoryPreviousValueVariableName(_configuration_1, node);
      Configuration _configuration_2 = context.getConfiguration();
      MscriptGeneratorConfiguration _mscriptGeneratorConfiguration = new MscriptGeneratorConfiguration(computationModel, _configuration_2);
      IComponentGeneratorContext _context_1 = generator.getContext();
      ICodeFragmentCollector _codeFragmentCollector = _context_1.getCodeFragmentCollector();
      final CharSequence dataType = this.dataTypeGenerator.generateDataType(_mscriptGeneratorConfiguration, variableName, _codeFragmentCollector, outputDataType, null);
      Configuration _configuration_3 = context.getConfiguration();
      Component _component_1 = node.getComponent();
      InputPort _firstInputPort = _component_1.getFirstInputPort();
      final String initializer = GeneratorUtil.getIncomingVariableName(_configuration_3, node, _firstInputPort);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append(dataType, "");
      _builder.append(" = ");
      _builder.append(initializer, "");
      _builder.append(";");
      _xblockexpression = (_builder);
    }
    return _xblockexpression;
  }
  
  private int getActionIndex(final Choice choice, final Action action) {
    int index = 0;
    EList<ActionLink> _actionLinks = choice.getActionLinks();
    for (final ActionLink actionLink : _actionLinks) {
      {
        Action _action = actionLink.getAction();
        boolean _equals = Objects.equal(_action, action);
        if (_equals) {
          return index;
        }
        int _plus = (index + 1);
        index = _plus;
      }
    }
    return index;
  }
}
