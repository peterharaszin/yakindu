package org.eclipselabs.damos.codegen.c.internal.componentgenerators;

import com.google.common.base.Objects;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipselabs.damos.codegen.c.AbstractComponentGenerator;
import org.eclipselabs.damos.codegen.c.internal.util.CompoundGeneratorUtil;
import org.eclipselabs.damos.codegen.c.util.GeneratorUtil;
import org.eclipselabs.damos.dconfig.Configuration;
import org.eclipselabs.damos.dml.Action;
import org.eclipselabs.damos.dml.ActionLink;
import org.eclipselabs.damos.dml.Component;
import org.eclipselabs.damos.dml.Compound;
import org.eclipselabs.damos.dml.InputPort;
import org.eclipselabs.damos.dml.OutputPort;
import org.eclipselabs.damos.dml.util.DMLUtil;
import org.eclipselabs.damos.execution.ActionNode;
import org.eclipselabs.damos.execution.ComponentNode;
import org.eclipselabs.damos.execution.CompoundNode;
import org.eclipselabs.damos.execution.DataFlow;
import org.eclipselabs.damos.execution.DataFlowSourceEnd;
import org.eclipselabs.damos.execution.DataFlowTargetEnd;
import org.eclipselabs.damos.execution.Graph;
import org.eclipselabs.damos.execution.Node;

/**
 * @author Andreas Unger
 */
@SuppressWarnings("all")
public class JoinGenerator extends AbstractComponentGenerator {
  public boolean contributesComputeOutputsCode() {
    return true;
  }
  
  public CharSequence generateComputeOutputsCode(final IProgressMonitor monitor) {
    CharSequence _xblockexpression = null;
    {
      TreeMap<Integer,String> _treeMap = new TreeMap<Integer,String>();
      final TreeMap<Integer,String> variableNameMap = _treeMap;
      ComponentNode choiceNode = ((ComponentNode) null);
      Component _component = this.getComponent();
      EList<InputPort> _inputPorts = _component.getInputPorts();
      for (final InputPort inputPort : _inputPorts) {
        {
          ComponentNode _node = this.getNode();
          final DataFlowTargetEnd targetEnd = _node.getIncomingDataFlow(inputPort);
          DataFlow _dataFlow = targetEnd.getDataFlow();
          final DataFlowSourceEnd sourceEnd = _dataFlow.getSourceEnd();
          Node _node_1 = sourceEnd.getNode();
          final CompoundNode enclosingCompoundNode = this.findEnclosingActionNodeWithActionLink(_node_1);
          if ((enclosingCompoundNode instanceof ActionNode)) {
            final ActionNode actionNode = ((ActionNode) enclosingCompoundNode);
            Compound _compound = actionNode.getCompound();
            final Action action = ((Action) _compound);
            ComponentNode _choiceNode = actionNode.getChoiceNode();
            boolean _notEquals = (!Objects.equal(_choiceNode, null));
            if (_notEquals) {
              Configuration _configuration = this.getConfiguration();
              ComponentNode _node_2 = this.getNode();
              final String incomingVariableName = GeneratorUtil.getIncomingVariableName(_configuration, _node_2, inputPort);
              ActionLink _link = action.getLink();
              int _indexOf = DMLUtil.indexOf(_link);
              variableNameMap.put(Integer.valueOf(_indexOf), incomingVariableName);
              ComponentNode _choiceNode_1 = actionNode.getChoiceNode();
              choiceNode = _choiceNode_1;
            }
          }
        }
      }
      Configuration _configuration = this.getConfiguration();
      final String choiceVariableName = CompoundGeneratorUtil.getChoiceVariableName(_configuration, choiceNode);
      Configuration _configuration_1 = this.getConfiguration();
      ComponentNode _node = this.getNode();
      Component _component_1 = this.getComponent();
      OutputPort _firstOutputPort = _component_1.getFirstOutputPort();
      final String outputVariableName = GeneratorUtil.getOutputVariableName(_configuration_1, _node, _firstOutputPort);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("switch (");
      _builder.append(choiceVariableName, "");
      _builder.append(") {");
      _builder.newLineIfNotEmpty();
      {
        Set<Entry<Integer,String>> _entrySet = variableNameMap.entrySet();
        for(final Entry<Integer,String> entry : _entrySet) {
          _builder.append("case ");
          Integer _key = entry.getKey();
          _builder.append(_key, "");
          _builder.append(":");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append(outputVariableName, "	");
          _builder.append(" = ");
          String _value = entry.getValue();
          _builder.append(_value, "	");
          _builder.append(";");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("break;");
          _builder.newLine();
        }
      }
      _builder.append("}");
      _builder.newLine();
      _xblockexpression = (_builder);
    }
    return _xblockexpression;
  }
  
  private CompoundNode findEnclosingActionNodeWithActionLink(final Node startNode) {
    Node node = startNode;
    Graph graph = null;
    boolean _while = true;
    while (_while) {
      {
        Graph _graph = node.getGraph();
        graph = _graph;
        if ((graph instanceof CompoundNode)) {
          final CompoundNode compoundNode = ((CompoundNode) graph);
          Compound _compound = compoundNode.getCompound();
          if ((_compound instanceof Action)) {
            Compound _compound_1 = compoundNode.getCompound();
            final Action action = ((Action) _compound_1);
            ActionLink _link = action.getLink();
            boolean _notEquals = (!Objects.equal(_link, null));
            if (_notEquals) {
              return compoundNode;
            }
          }
        }
        if ((graph instanceof Node)) {
          node = ((Node) graph);
        } else {
          return null;
        }
      }
      _while = true;
    }
    return null;
  }
}
