package org.eclipse.damos.codegen.c;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.damos.codegen.c.IComponentGenerator;
import org.eclipse.damos.codegen.c.IComponentGeneratorContext;
import org.eclipse.damos.codegen.c.ICompoundGenerator;
import org.eclipse.damos.codegen.c.IGeneratorContext;
import org.eclipse.damos.codegen.c.IGraphGenerator;
import org.eclipse.damos.codegen.c.MscriptGeneratorConfiguration;
import org.eclipse.damos.codegen.c.internal.util.CompoundGeneratorUtil;
import org.eclipse.damos.codegen.c.util.GeneratorConfigurationExtensions;
import org.eclipse.damos.codegen.c.util.GeneratorHelper;
import org.eclipse.damos.codegen.c.util.GeneratorNodeExtensions;
import org.eclipse.damos.dconfig.Configuration;
import org.eclipse.damos.dml.Action;
import org.eclipse.damos.dml.ActionLink;
import org.eclipse.damos.dml.Choice;
import org.eclipse.damos.dml.Component;
import org.eclipse.damos.dml.Compound;
import org.eclipse.damos.dml.InputPort;
import org.eclipse.damos.dml.Memory;
import org.eclipse.damos.dml.OutputPort;
import org.eclipse.damos.dml.WhileLoop;
import org.eclipse.damos.dml.WhileLoopCondition;
import org.eclipse.damos.execution.ActionNode;
import org.eclipse.damos.execution.ComponentNode;
import org.eclipse.damos.execution.CompoundNode;
import org.eclipse.damos.execution.Graph;
import org.eclipse.damos.execution.Node;
import org.eclipse.damos.execution.datatype.IComponentSignature;
import org.eclipse.damos.mscript.Type;
import org.eclipse.damos.mscript.codegen.c.DataTypeGenerator;
import org.eclipse.damos.mscript.codegen.c.ICodeFragmentCollector;
import org.eclipse.damos.mscript.codegen.c.PrimitiveTypeGenerator;
import org.eclipse.damos.mscript.computation.ComputationModel;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;

/**
 * @author Andreas Unger
 */
@SuppressWarnings("all")
public class CompoundGenerator implements ICompoundGenerator {
  @Inject
  private IGraphGenerator graphGenerator;
  
  @Inject
  private DataTypeGenerator dataTypeGenerator;
  
  @Inject
  private GeneratorHelper generatorHelper;
  
  @Inject
  private PrimitiveTypeGenerator primitiveTypeGenerator;
  
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
    CharSequence _xblockexpression = null;
    {
      Iterable<Node> _allNodes = graph.getAllNodes();
      Iterable<ComponentNode> _filter = Iterables.<ComponentNode>filter(_allNodes, ComponentNode.class);
      final Function1<ComponentNode,Boolean> _function = new Function1<ComponentNode,Boolean>() {
          public Boolean apply(final ComponentNode n) {
            Component _component = n.getComponent();
            return Boolean.valueOf((_component instanceof Choice));
          }
        };
      final Iterable<ComponentNode> nodes = IterableExtensions.<ComponentNode>filter(_filter, _function);
      StringConcatenation _builder = new StringConcatenation();
      {
        for(final ComponentNode node : nodes) {
          int _size = IterableExtensions.size(nodes);
          int _minus = (_size - 1);
          CharSequence _generateIndexType = this.primitiveTypeGenerator.generateIndexType(_minus);
          _builder.append(_generateIndexType, "");
          _builder.append(" ");
          Configuration _configuration = context.getConfiguration();
          String _choiceVariableName = CompoundGeneratorUtil.getChoiceVariableName(_configuration, node);
          _builder.append(_choiceVariableName, "");
          _builder.append(";");
          _builder.newLineIfNotEmpty();
        }
      }
      _xblockexpression = (_builder);
    }
    return _xblockexpression;
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
          CharSequence _generateIncomingVariableReference = this.generatorHelper.generateIncomingVariableReference(_configuration_1, actionNode, _condition);
          CharSequence _elvis = ObjectExtensions.<CharSequence>operator_elvis(_generateIncomingVariableReference, "0");
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
      final CharSequence initializer = this.generatorHelper.generateIncomingVariableReference(_configuration_3, node, _firstInputPort);
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
