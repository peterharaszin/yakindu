package org.eclipselabs.damos.codegen.c;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipselabs.damos.codegen.c.IComponentGenerator;
import org.eclipselabs.damos.codegen.c.IComponentGeneratorContext;
import org.eclipselabs.damos.codegen.c.ICompoundGenerator;
import org.eclipselabs.damos.codegen.c.IGeneratorContext;
import org.eclipselabs.damos.codegen.c.IGraphGenerator;
import org.eclipselabs.damos.codegen.c.ITaskGenerator;
import org.eclipselabs.damos.codegen.c.internal.util.InternalGeneratorUtil;
import org.eclipselabs.damos.codegen.c.util.GeneratorConfigurationUtil;
import org.eclipselabs.damos.codegen.c.util.GeneratorUtil;
import org.eclipselabs.damos.dconfig.Configuration;
import org.eclipselabs.damos.dml.Component;
import org.eclipselabs.damos.dml.Inoutport;
import org.eclipselabs.damos.dml.Output;
import org.eclipselabs.damos.dml.OutputPort;
import org.eclipselabs.damos.execution.ComponentNode;
import org.eclipselabs.damos.execution.CompoundNode;
import org.eclipselabs.damos.execution.Graph;
import org.eclipselabs.damos.execution.Node;
import org.eclipselabs.damos.execution.datatype.IComponentSignature;
import org.eclipselabs.damos.mscript.DataType;
import org.eclipselabs.damos.mscript.codegen.c.Include;
import org.eclipselabs.damos.mscript.codegen.c.util.MscriptGeneratorUtil;
import org.eclipselabs.damos.mscript.computationmodel.ComputationModel;

/**
 * @author Andreas Unger
 */
@SuppressWarnings("all")
public class GraphGenerator implements IGraphGenerator {
  private final ICompoundGenerator compoundGenerator;
  
  private final ITaskGenerator taskGenerator;
  
  @Inject
  public GraphGenerator(final ICompoundGenerator compoundGenerator, final ITaskGenerator taskGenerator) {
    this.compoundGenerator = compoundGenerator;
    this.taskGenerator = taskGenerator;
  }
  
  public Collection<Include> getImplementationIncludes(final IGeneratorContext context, final Graph graph) {
    ArrayList<Include> _arrayList = new ArrayList<Include>();
    final ArrayList<Include> allIncludes = _arrayList;
    Iterable<Node> _allNodes = graph.getAllNodes();
    Iterable<ComponentNode> _filter = Iterables.<ComponentNode>filter(_allNodes, ComponentNode.class);
    final Function1<ComponentNode,Boolean> _function = new Function1<ComponentNode,Boolean>() {
        public Boolean apply(final ComponentNode n) {
          Component _component = n.getComponent();
          boolean _not = (!(_component instanceof Inoutport));
          return Boolean.valueOf(_not);
        }
      };
    final Iterable<ComponentNode> nodes = IterableExtensions.<ComponentNode>filter(_filter, _function);
    for (final ComponentNode node : nodes) {
      {
        final IComponentGenerator generator = InternalGeneratorUtil.getComponentGenerator(node);
        boolean _contributesComputeOutputsCode = generator.contributesComputeOutputsCode();
        if (_contributesComputeOutputsCode) {
          final Collection<Include> includes = generator.getComputeOutputsCodeIncludes();
          boolean _notEquals = (!Objects.equal(includes, null));
          if (_notEquals) {
            allIncludes.addAll(includes);
          }
        }
        boolean _contributesUpdateCode = generator.contributesUpdateCode();
        if (_contributesUpdateCode) {
          final Collection<Include> includes_1 = generator.getUpdateCodeIncludes();
          boolean _notEquals_1 = (!Objects.equal(includes_1, null));
          if (_notEquals_1) {
            allIncludes.addAll(includes_1);
          }
        }
      }
    }
    return allIncludes;
  }
  
  public CharSequence generateGraph(final IGeneratorContext context, final Graph graph, final IProgressMonitor monitor) {
    CharSequence _xblockexpression = null;
    {
      EList<Node> _nodes = graph.getNodes();
      final Function1<Node,Boolean> _function = new Function1<Node,Boolean>() {
          public Boolean apply(final Node n) {
            boolean _contributesComputeOutputsCode = GraphGenerator.this.contributesComputeOutputsCode(context, n);
            return Boolean.valueOf(_contributesComputeOutputsCode);
          }
        };
      final Iterable<Node> computeOutputsNodes = IterableExtensions.<Node>filter(_nodes, _function);
      EList<Node> _nodes_1 = graph.getNodes();
      Iterable<ComponentNode> _filter = Iterables.<ComponentNode>filter(_nodes_1, ComponentNode.class);
      final Function1<ComponentNode,Boolean> _function_1 = new Function1<ComponentNode,Boolean>() {
          public Boolean apply(final ComponentNode n) {
            IComponentGenerator _componentGenerator = InternalGeneratorUtil.getComponentGenerator(n);
            boolean _contributesUpdateCode = _componentGenerator.contributesUpdateCode();
            return Boolean.valueOf(_contributesUpdateCode);
          }
        };
      final Iterable<ComponentNode> updateNodes = IterableExtensions.<ComponentNode>filter(_filter, _function_1);
      StringConcatenation _builder = new StringConcatenation();
      {
        boolean _contributesChoiceVariableDeclarations = this.compoundGenerator.contributesChoiceVariableDeclarations(context, graph);
        if (_contributesChoiceVariableDeclarations) {
          CharSequence _generateChoiceVariableDeclarations = this.compoundGenerator.generateChoiceVariableDeclarations(context, graph, monitor);
          _builder.append(_generateChoiceVariableDeclarations, "");
          _builder.newLineIfNotEmpty();
          _builder.newLine();
        }
      }
      {
        boolean _isEmpty = IterableExtensions.isEmpty(computeOutputsNodes);
        boolean _not = (!_isEmpty);
        if (_not) {
          _builder.append("/*");
          _builder.newLine();
          _builder.append(" ");
          _builder.append("* Compute outputs");
          _builder.newLine();
          _builder.append(" ");
          _builder.append("*/");
          _builder.newLine();
          _builder.newLine();
        }
      }
      {
        boolean _hasElements = false;
        for(final Node node : computeOutputsNodes) {
          if (!_hasElements) {
            _hasElements = true;
          } else {
            _builder.appendImmediate("\n", "");
          }
          CharSequence _generateComputeOutputsCode = this.generateComputeOutputsCode(context, node, monitor);
          _builder.append(_generateComputeOutputsCode, "");
          _builder.newLineIfNotEmpty();
        }
      }
      {
        boolean _and = false;
        boolean _isEmpty_1 = IterableExtensions.isEmpty(computeOutputsNodes);
        boolean _not_1 = (!_isEmpty_1);
        if (!_not_1) {
          _and = false;
        } else {
          boolean _isEmpty_2 = IterableExtensions.isEmpty(updateNodes);
          boolean _not_2 = (!_isEmpty_2);
          _and = (_not_1 && _not_2);
        }
        if (_and) {
          _builder.newLine();
        }
      }
      {
        boolean _isEmpty_3 = IterableExtensions.isEmpty(updateNodes);
        boolean _not_3 = (!_isEmpty_3);
        if (_not_3) {
          _builder.append("/*");
          _builder.newLine();
          _builder.append(" ");
          _builder.append("* Update states");
          _builder.newLine();
          _builder.append(" ");
          _builder.append("*/");
          _builder.newLine();
          _builder.newLine();
        }
      }
      {
        boolean _hasElements_1 = false;
        for(final ComponentNode node_1 : updateNodes) {
          if (!_hasElements_1) {
            _hasElements_1 = true;
          } else {
            _builder.appendImmediate("\n", "");
          }
          _builder.append("/* ");
          Component _component = node_1.getComponent();
          String _name = _component.getName();
          _builder.append(_name, "");
          _builder.append(" */");
          _builder.newLineIfNotEmpty();
          _builder.append("{");
          _builder.newLine();
          _builder.append("\t");
          IComponentGenerator _componentGenerator = InternalGeneratorUtil.getComponentGenerator(node_1);
          CharSequence _generateUpdateCode = _componentGenerator.generateUpdateCode(monitor);
          _builder.append(_generateUpdateCode, "	");
          _builder.newLineIfNotEmpty();
          _builder.append("}");
          _builder.newLine();
        }
      }
      _xblockexpression = (_builder);
    }
    return _xblockexpression;
  }
  
  private boolean contributesComputeOutputsCode(final IGeneratorContext context, final Node node) {
    if ((node instanceof CompoundNode)) {
      return true;
    }
    if ((node instanceof ComponentNode)) {
      final ComponentNode componentNode = ((ComponentNode) node);
      boolean _or = false;
      boolean _or_1 = false;
      IComponentGenerator _componentGenerator = InternalGeneratorUtil.getComponentGenerator(componentNode);
      boolean _contributesComputeOutputsCode = _componentGenerator.contributesComputeOutputsCode();
      if (_contributesComputeOutputsCode) {
        _or_1 = true;
      } else {
        boolean _contributesLatchUpdate = this.taskGenerator.contributesLatchUpdate(context, componentNode);
        _or_1 = (_contributesComputeOutputsCode || _contributesLatchUpdate);
      }
      if (_or_1) {
        _or = true;
      } else {
        boolean _contributesMessageQueueSend = this.taskGenerator.contributesMessageQueueSend(context, componentNode);
        _or = (_or_1 || _contributesMessageQueueSend);
      }
      return _or;
    }
    return false;
  }
  
  private CharSequence _generateComputeOutputsCode(final IGeneratorContext context, final CompoundNode node, final IProgressMonitor monitor) {
    CharSequence _generateCompoundCode = this.compoundGenerator.generateCompoundCode(context, node, monitor);
    return _generateCompoundCode;
  }
  
  private CharSequence _generateComputeOutputsCode(final IGeneratorContext context, final ComponentNode node, final IProgressMonitor monitor) {
    CharSequence _xblockexpression = null;
    {
      final IComponentGenerator generator = InternalGeneratorUtil.getComponentGenerator(node);
      StringConcatenation _builder = new StringConcatenation();
      {
        boolean _contributesComputeOutputsCode = generator.contributesComputeOutputsCode();
        if (_contributesComputeOutputsCode) {
          _builder.append("/* ");
          Component _component = node.getComponent();
          String _name = _component.getName();
          _builder.append(_name, "");
          _builder.append(" */");
          _builder.newLineIfNotEmpty();
          _builder.append("{");
          _builder.newLine();
          _builder.append("\t");
          CharSequence _generateComputeOutputsCode = generator.generateComputeOutputsCode(monitor);
          _builder.append(_generateComputeOutputsCode, "	");
          _builder.newLineIfNotEmpty();
          _builder.append("}");
          _builder.newLine();
        }
      }
      CharSequence _generateLatchUpdate = this.taskGenerator.generateLatchUpdate(context, node, monitor);
      _builder.append(_generateLatchUpdate, "");
      _builder.newLineIfNotEmpty();
      CharSequence _generateMessageQueueSend = this.taskGenerator.generateMessageQueueSend(context, node, monitor);
      _builder.append(_generateMessageQueueSend, "");
      _builder.newLineIfNotEmpty();
      _xblockexpression = (_builder);
    }
    return _xblockexpression;
  }
  
  public CharSequence generateOutputVariableDeclarations(final IGeneratorContext context, final Graph graph, final IProgressMonitor monitor) {
    CharSequence _xblockexpression = null;
    {
      Iterable<Node> _allNodes = graph.getAllNodes();
      Iterable<ComponentNode> _filter = Iterables.<ComponentNode>filter(_allNodes, ComponentNode.class);
      final Function1<ComponentNode,Boolean> _function = new Function1<ComponentNode,Boolean>() {
          public Boolean apply(final ComponentNode n) {
            Component _component = n.getComponent();
            boolean _not = (!(_component instanceof Inoutport));
            return Boolean.valueOf(_not);
          }
        };
      final Iterable<ComponentNode> nodes = IterableExtensions.<ComponentNode>filter(_filter, _function);
      StringConcatenation _builder = new StringConcatenation();
      {
        for(final ComponentNode node : nodes) {
          final IComponentGenerator generator = InternalGeneratorUtil.getComponentGenerator(node);
          _builder.newLineIfNotEmpty();
          {
            Component _component = node.getComponent();
            EList<Output> _outputs = _component.getOutputs();
            final Function1<Output,Boolean> _function_1 = new Function1<Output,Boolean>() {
                public Boolean apply(final Output o) {
                  boolean _isTestPoint = o.isTestPoint();
                  boolean _not = (!_isTestPoint);
                  return Boolean.valueOf(_not);
                }
              };
            Iterable<Output> _filter_1 = IterableExtensions.<Output>filter(_outputs, _function_1);
            final Function1<Output,EList<OutputPort>> _function_2 = new Function1<Output,EList<OutputPort>>() {
                public EList<OutputPort> apply(final Output o) {
                  EList<OutputPort> _ports = o.getPorts();
                  return _ports;
                }
              };
            Iterable<EList<OutputPort>> _map = IterableExtensions.<Output, EList<OutputPort>>map(_filter_1, _function_2);
            Iterable<OutputPort> _flatten = Iterables.<OutputPort>concat(_map);
            for(final OutputPort outputPort : _flatten) {
              Configuration _configuration = context.getConfiguration();
              final ComputationModel computationModel = GeneratorConfigurationUtil.getComputationModel(_configuration, node);
              _builder.newLineIfNotEmpty();
              IComponentGeneratorContext _context = generator.getContext();
              IComponentSignature _componentSignature = _context.getComponentSignature();
              final DataType outputDataType = _componentSignature.getOutputDataType(outputPort);
              _builder.newLineIfNotEmpty();
              final String cDataType = MscriptGeneratorUtil.getCDataType(computationModel, context, outputDataType, null);
              _builder.newLineIfNotEmpty();
              _builder.append(cDataType, "");
              _builder.append(" ");
              Configuration _configuration_1 = context.getConfiguration();
              String _outputVariableName = GeneratorUtil.getOutputVariableName(_configuration_1, node, outputPort);
              _builder.append(_outputVariableName, "");
              _builder.append(";");
              _builder.newLineIfNotEmpty();
            }
          }
        }
      }
      _xblockexpression = (_builder);
    }
    return _xblockexpression;
  }
  
  private CharSequence generateComputeOutputsCode(final IGeneratorContext context, final Node node, final IProgressMonitor monitor) {
    if (node instanceof CompoundNode) {
      return _generateComputeOutputsCode(context, (CompoundNode)node, monitor);
    } else if (node instanceof ComponentNode) {
      return _generateComputeOutputsCode(context, (ComponentNode)node, monitor);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(context, node, monitor).toString());
    }
  }
}
