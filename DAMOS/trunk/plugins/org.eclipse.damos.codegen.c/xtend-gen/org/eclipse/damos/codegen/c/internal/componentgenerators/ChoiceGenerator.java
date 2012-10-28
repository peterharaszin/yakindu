package org.eclipse.damos.codegen.c.internal.componentgenerators;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.damos.codegen.c.AbstractComponentGenerator;
import org.eclipse.damos.codegen.c.IComponentGeneratorContext;
import org.eclipse.damos.codegen.c.MscriptGeneratorConfiguration;
import org.eclipse.damos.codegen.c.internal.componentgenerators.ChoiceVariableAccessStrategy;
import org.eclipse.damos.codegen.c.internal.util.CompoundGeneratorUtil;
import org.eclipse.damos.codegen.c.util.GeneratorHelper;
import org.eclipse.damos.dconfig.Configuration;
import org.eclipse.damos.dml.ActionLink;
import org.eclipse.damos.dml.Choice;
import org.eclipse.damos.dml.Component;
import org.eclipse.damos.dml.InputPort;
import org.eclipse.damos.dml.ValueSpecification;
import org.eclipse.damos.dml.util.DMLUtil;
import org.eclipse.damos.dscript.DscriptValueSpecification;
import org.eclipse.damos.execution.ComponentNode;
import org.eclipse.damos.mscript.Expression;
import org.eclipse.damos.mscript.codegen.c.ICodeFragmentCollector;
import org.eclipse.damos.mscript.codegen.c.IExpressionGenerator;
import org.eclipse.damos.mscript.codegen.c.MscriptGeneratorContext;
import org.eclipse.damos.mscript.computation.ComputationModel;
import org.eclipse.damos.mscript.interpreter.StaticFunctionInfo;
import org.eclipse.damos.mscript.util.ISampleInterval;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * @author Andreas Unger
 */
@SuppressWarnings("all")
public class ChoiceGenerator extends AbstractComponentGenerator {
  @Inject
  private IExpressionGenerator expressionGenerator;
  
  @Inject
  private GeneratorHelper generatorHelper;
  
  public boolean contributesComputeOutputsCode() {
    return true;
  }
  
  public CharSequence generateComputeOutputsCode(final IProgressMonitor monitor) {
    CharSequence _xblockexpression = null;
    {
      Component _component = this.getComponent();
      final Choice choice = ((Choice) _component);
      Configuration _configuration = this.getConfiguration();
      ComponentNode _node = this.getNode();
      InputPort _firstInputPort = choice.getFirstInputPort();
      final String incomingVariableName = this.generatorHelper.getIncomingVariableName(_configuration, _node, _firstInputPort);
      Configuration _configuration_1 = this.getConfiguration();
      ComponentNode _node_1 = this.getNode();
      final String choiceResult = CompoundGeneratorUtil.getChoiceVariableName(_configuration_1, _node_1);
      EList<ActionLink> _actionLinks = choice.getActionLinks();
      final Function1<ActionLink,Boolean> _function = new Function1<ActionLink,Boolean>() {
          public Boolean apply(final ActionLink l) {
            ValueSpecification _condition = l.getCondition();
            boolean _notEquals = (!Objects.equal(_condition, null));
            return Boolean.valueOf(_notEquals);
          }
        };
      Iterable<ActionLink> actionLinks = IterableExtensions.<ActionLink>filter(_actionLinks, _function);
      EList<ActionLink> _actionLinks_1 = choice.getActionLinks();
      final Function1<ActionLink,Boolean> _function_1 = new Function1<ActionLink,Boolean>() {
          public Boolean apply(final ActionLink l) {
            ValueSpecification _condition = l.getCondition();
            boolean _equals = Objects.equal(_condition, null);
            return Boolean.valueOf(_equals);
          }
        };
      Iterable<ActionLink> _filter = IterableExtensions.<ActionLink>filter(_actionLinks_1, _function_1);
      ActionLink defaultActionLink = IterableExtensions.<ActionLink>head(_filter);
      StringConcatenation _builder = new StringConcatenation();
      {
        for(final ActionLink actionLink : actionLinks) {
          {
            ActionLink _head = IterableExtensions.<ActionLink>head(actionLinks);
            boolean _notEquals = (!Objects.equal(actionLink, _head));
            if (_notEquals) {
              _builder.append("} else ");
            }
          }
          _builder.append("if (");
          _builder.append(incomingVariableName, "");
          _builder.append(" == (");
          ValueSpecification _condition = actionLink.getCondition();
          CharSequence _generateValueSpecification = this.generateValueSpecification(_condition);
          _builder.append(_generateValueSpecification, "");
          _builder.append(")) {");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append(choiceResult, "	");
          _builder.append(" = ");
          int _indexOf = DMLUtil.indexOf(actionLink);
          _builder.append(_indexOf, "	");
          _builder.append(";");
          _builder.newLineIfNotEmpty();
        }
      }
      {
        boolean _notEquals_1 = (!Objects.equal(defaultActionLink, null));
        if (_notEquals_1) {
          _builder.append("} else {");
          _builder.newLine();
          _builder.append("\t");
          _builder.append(choiceResult, "	");
          _builder.append(" = ");
          int _indexOf_1 = DMLUtil.indexOf(defaultActionLink);
          _builder.append(_indexOf_1, "	");
          _builder.append(";");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.append("}");
      _builder.newLine();
      _xblockexpression = (_builder);
    }
    return _xblockexpression;
  }
  
  private CharSequence generateValueSpecification(final ValueSpecification valueSpecification) {
    if ((valueSpecification instanceof DscriptValueSpecification)) {
      final DscriptValueSpecification condition = ((DscriptValueSpecification) valueSpecification);
      StaticFunctionInfo _staticFunctionInfo = new StaticFunctionInfo(null);
      final StaticFunctionInfo staticFunctionInfo = _staticFunctionInfo;
      ComputationModel _computationModel = this.getComputationModel();
      Configuration _configuration = this.getConfiguration();
      MscriptGeneratorConfiguration _mscriptGeneratorConfiguration = new MscriptGeneratorConfiguration(_computationModel, _configuration);
      IComponentGeneratorContext _context = this.getContext();
      ComponentNode _node = _context.getNode();
      ISampleInterval _sampleInterval = _node.getSampleInterval();
      ChoiceVariableAccessStrategy _choiceVariableAccessStrategy = new ChoiceVariableAccessStrategy();
      IComponentGeneratorContext _context_1 = this.getContext();
      ICodeFragmentCollector _codeFragmentCollector = _context_1.getCodeFragmentCollector();
      MscriptGeneratorContext _mscriptGeneratorContext = new MscriptGeneratorContext(_mscriptGeneratorConfiguration, staticFunctionInfo, _sampleInterval, _choiceVariableAccessStrategy, _codeFragmentCollector);
      final MscriptGeneratorContext mscriptGeneratorContext = _mscriptGeneratorContext;
      Expression _expression = condition.getExpression();
      return this.expressionGenerator.generate(mscriptGeneratorContext, _expression);
    }
    return "INVALID_EXPRESSION";
  }
}
