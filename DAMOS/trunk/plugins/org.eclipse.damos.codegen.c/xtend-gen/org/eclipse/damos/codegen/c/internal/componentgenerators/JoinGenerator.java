package org.eclipse.damos.codegen.c.internal.componentgenerators;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.damos.codegen.c.AbstractComponentGenerator;
import org.eclipse.damos.codegen.c.IVariableAccessor;
import org.eclipse.damos.codegen.c.IVariableAccessorFactory;
import org.eclipse.damos.codegen.c.internal.util.CompoundGeneratorUtil;
import org.eclipse.damos.codegen.c.util.GeneratorHelper;
import org.eclipse.damos.dconfig.Configuration;
import org.eclipse.damos.dml.Action;
import org.eclipse.damos.dml.ActionLink;
import org.eclipse.damos.dml.Component;
import org.eclipse.damos.dml.Compound;
import org.eclipse.damos.dml.InputPort;
import org.eclipse.damos.dml.OutputPort;
import org.eclipse.damos.dml.util.DMLUtil;
import org.eclipse.damos.execution.ActionNode;
import org.eclipse.damos.execution.ComponentNode;
import org.eclipse.damos.execution.CompoundNode;
import org.eclipse.damos.execution.DataFlowSourceEnd;
import org.eclipse.damos.execution.DataFlowTargetEnd;
import org.eclipse.damos.execution.Graph;
import org.eclipse.damos.execution.Node;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;

/**
 * @author Andreas Unger
 */
@SuppressWarnings("all")
public class JoinGenerator extends AbstractComponentGenerator {
  @Inject
  private IVariableAccessorFactory variableAccessorFactory;
  
  @Inject
  private GeneratorHelper generatorHelper;
  
  public boolean contributesComputeOutputsCode() {
    return true;
  }
  
  public CharSequence generateComputeOutputsCode(final IProgressMonitor monitor) {
    CharSequence _xblockexpression = null;
    {
      TreeMap<Integer,CharSequence> _treeMap = new TreeMap<Integer,CharSequence>();
      final TreeMap<Integer,CharSequence> variableNameMap = _treeMap;
      ComponentNode choiceNode = ((ComponentNode) null);
      Component _component = this.getComponent();
      EList<InputPort> _inputPorts = _component.getInputPorts();
      for (final InputPort inputPort : _inputPorts) {
        {
          ComponentNode _node = this.getNode();
          final DataFlowTargetEnd targetEnd = _node.getIncomingDataFlow(inputPort);
          final DataFlowSourceEnd sourceEnd = targetEnd.getSourceEnd();
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
              final CharSequence incomingVariableName = this.generatorHelper.generateIncomingVariableReference(_configuration, _node_2, inputPort);
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
      IVariableAccessor _create = this.variableAccessorFactory.create(_configuration_1, _node);
      Component _component_1 = this.getComponent();
      OutputPort _firstOutputPort = _component_1.getFirstOutputPort();
      final CharSequence outputVariableName = _create.generateOutputVariableReference(_firstOutputPort, false);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("switch (");
      _builder.append(choiceVariableName, "");
      _builder.append(") {");
      _builder.newLineIfNotEmpty();
      {
        Set<Entry<Integer,CharSequence>> _entrySet = variableNameMap.entrySet();
        for(final Entry<Integer,CharSequence> entry : _entrySet) {
          _builder.append("case ");
          Integer _key = entry.getKey();
          _builder.append(_key, "");
          _builder.append(":");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append(outputVariableName, "	");
          _builder.append(" = ");
          CharSequence _value = entry.getValue();
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
