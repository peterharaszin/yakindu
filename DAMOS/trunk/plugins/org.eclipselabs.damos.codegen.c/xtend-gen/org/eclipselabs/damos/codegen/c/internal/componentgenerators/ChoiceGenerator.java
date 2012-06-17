package org.eclipselabs.damos.codegen.c.internal.componentgenerators;

import com.google.common.base.Objects;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipselabs.damos.codegen.c.AbstractComponentGenerator;
import org.eclipselabs.damos.codegen.c.IComponentGeneratorContext;
import org.eclipselabs.damos.codegen.c.internal.util.CompoundGeneratorUtil;
import org.eclipselabs.damos.codegen.c.util.GeneratorUtil;
import org.eclipselabs.damos.dconfig.Configuration;
import org.eclipselabs.damos.dml.ActionLink;
import org.eclipselabs.damos.dml.Choice;
import org.eclipselabs.damos.dml.Component;
import org.eclipselabs.damos.dml.InputPort;
import org.eclipselabs.damos.dml.ValueSpecification;
import org.eclipselabs.damos.dml.util.DMLUtil;
import org.eclipselabs.damos.dmltext.MscriptValueSpecification;
import org.eclipselabs.damos.execution.ComponentNode;
import org.eclipselabs.damos.mscript.Expression;
import org.eclipselabs.damos.mscript.VariableReference;
import org.eclipselabs.damos.mscript.codegen.c.ExpressionGenerator;
import org.eclipselabs.damos.mscript.codegen.c.ICodeFragmentCollector;
import org.eclipselabs.damos.mscript.codegen.c.IExpressionGenerator;
import org.eclipselabs.damos.mscript.codegen.c.IVariableAccessStrategy;
import org.eclipselabs.damos.mscript.codegen.c.MscriptGeneratorContext;
import org.eclipselabs.damos.mscript.computationmodel.ComputationModel;
import org.eclipselabs.damos.mscript.interpreter.StaticEvaluationContext;

/**
 * @author Andreas Unger
 */
@SuppressWarnings("all")
public class ChoiceGenerator extends AbstractComponentGenerator {
  private final IExpressionGenerator expressionGenerator = new Function0<IExpressionGenerator>() {
    public IExpressionGenerator apply() {
      ExpressionGenerator _expressionGenerator = new ExpressionGenerator();
      return _expressionGenerator;
    }
  }.apply();
  
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
      final String incomingVariableName = GeneratorUtil.getIncomingVariableName(_configuration, _node, _firstInputPort);
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
    if ((valueSpecification instanceof MscriptValueSpecification)) {
      final MscriptValueSpecification condition = ((MscriptValueSpecification) valueSpecification);
      ComputationModel _computationModel = this.getComputationModel();
      StaticEvaluationContext _staticEvaluationContext = new StaticEvaluationContext();
      final Function1<VariableReference,String> _function = new Function1<VariableReference,String>() {
          public String apply(final VariableReference v) {
            return "";
          }
        };
      IComponentGeneratorContext _context = this.getContext();
      ICodeFragmentCollector _codeFragmentCollector = _context.getCodeFragmentCollector();
      MscriptGeneratorContext _mscriptGeneratorContext = new MscriptGeneratorContext(_computationModel, _staticEvaluationContext, new IVariableAccessStrategy() {
          public CharSequence generateVariableReference(VariableReference variableReference) {
            return _function.apply(variableReference);
          }
      }, _codeFragmentCollector);
      final MscriptGeneratorContext mscriptGeneratorContext = _mscriptGeneratorContext;
      Expression _expression = condition.getExpression();
      return this.expressionGenerator.generate(mscriptGeneratorContext, _expression);
    }
    return "INVALID_EXPRESSION";
  }
}
