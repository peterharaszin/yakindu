package org.eclipselabs.damos.codegen.c.codefragments;

import java.util.List;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipselabs.damos.codegen.c.IComponentGenerator;
import org.eclipselabs.damos.codegen.c.IComponentGeneratorContext;
import org.eclipselabs.damos.codegen.c.IGeneratorContext;
import org.eclipselabs.damos.codegen.c.codefragments.PrimaryCodeFragment;
import org.eclipselabs.damos.codegen.c.internal.util.InternalGeneratorUtil;
import org.eclipselabs.damos.codegen.c.util.GeneratorConfigurationUtil;
import org.eclipselabs.damos.dconfig.Configuration;
import org.eclipselabs.damos.dml.Component;
import org.eclipselabs.damos.dml.OutputPort;
import org.eclipselabs.damos.execution.ComponentNode;
import org.eclipselabs.damos.execution.datatype.IComponentSignature;
import org.eclipselabs.damos.mscript.DataType;
import org.eclipselabs.damos.mscript.codegen.c.util.MscriptGeneratorUtil;
import org.eclipselabs.damos.mscript.computationmodel.ComputationModel;

/**
 * @author Andreas Unger
 */
@SuppressWarnings("all")
public class InputStruct extends PrimaryCodeFragment {
  private CharSequence content;
  
  public void doInitialize(final IGeneratorContext context, final IProgressMonitor monitor) {
    Configuration _configuration = context.getConfiguration();
    final String prefix = GeneratorConfigurationUtil.getPrefix(_configuration);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("typedef struct {");
    _builder.newLine();
    {
      List<ComponentNode> _inportNodes = InternalGeneratorUtil.getInportNodes(context);
      for(final ComponentNode node : _inportNodes) {
        _builder.append("\t");
        String _cVariableDeclaration = this.getCVariableDeclaration(context, node);
        _builder.append(_cVariableDeclaration, "	");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("} ");
    _builder.append(prefix, "");
    _builder.append("Input;");
    _builder.newLineIfNotEmpty();
    this.content = _builder;
  }
  
  /**
   * @param context
   * @param node
   * @return
   */
  private String getCVariableDeclaration(final IGeneratorContext context, final ComponentNode node) {
    final IComponentGenerator generator = InternalGeneratorUtil.getComponentGenerator(node);
    IComponentGeneratorContext _context = generator.getContext();
    final IComponentSignature signature = _context.getComponentSignature();
    Component _component = node.getComponent();
    final OutputPort outputPort = _component.getFirstOutputPort();
    final DataType dataType = signature.getOutputDataType(outputPort);
    Configuration _configuration = context.getConfiguration();
    ComputationModel _computationModel = GeneratorConfigurationUtil.getComputationModel(_configuration, node);
    Component _component_1 = node.getComponent();
    String _name = _component_1.getName();
    String _uncapitalize = InternalGeneratorUtil.uncapitalize(_name);
    return MscriptGeneratorUtil.getCVariableDeclaration(_computationModel, context, dataType, _uncapitalize, false, this);
  }
  
  public CharSequence generateForwardDeclaration(final boolean internal) {
    return this.content;
  }
}
