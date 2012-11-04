package org.eclipse.damos.codegen.c.codefragments;

import com.google.inject.Inject;
import java.util.List;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.damos.codegen.c.IComponentGenerator;
import org.eclipse.damos.codegen.c.IComponentGeneratorContext;
import org.eclipse.damos.codegen.c.IGeneratorContext;
import org.eclipse.damos.codegen.c.MscriptGeneratorConfiguration;
import org.eclipse.damos.codegen.c.codefragments.PrimaryCodeFragment;
import org.eclipse.damos.codegen.c.internal.util.InternalGeneratorUtil;
import org.eclipse.damos.codegen.c.util.GeneratorConfigurationExtensions;
import org.eclipse.damos.codegen.c.util.GeneratorNodeExtensions;
import org.eclipse.damos.dconfig.Configuration;
import org.eclipse.damos.dml.Component;
import org.eclipse.damos.dml.InputPort;
import org.eclipse.damos.execution.ComponentNode;
import org.eclipse.damos.execution.datatype.IComponentSignature;
import org.eclipse.damos.mscript.Type;
import org.eclipse.damos.mscript.codegen.c.StructGenerator;
import org.eclipse.damos.mscript.codegen.c.VariableDeclarationGenerator;
import org.eclipse.damos.mscript.computation.ComputationModel;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.StringExtensions;

/**
 * @author Andreas Unger
 */
@SuppressWarnings("all")
public class OutputStruct extends PrimaryCodeFragment {
  @Inject
  private VariableDeclarationGenerator variableDeclarationGenerator;
  
  @Inject
  private StructGenerator structGenerator;
  
  private CharSequence declaration;
  
  public void doInitialize(final IGeneratorContext context, final IProgressMonitor monitor) {
    Configuration _configuration = context.getConfiguration();
    final String prefix = GeneratorConfigurationExtensions.getPrefix(_configuration);
    StringConcatenation _builder = new StringConcatenation();
    {
      List<ComponentNode> _outportNodes = InternalGeneratorUtil.getOutportNodes(context);
      for(final ComponentNode node : _outportNodes) {
        CharSequence _variableDeclaration = this.getVariableDeclaration(context, node);
        _builder.append(_variableDeclaration, "");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
      }
    }
    final CharSequence content = _builder;
    String _plus = (prefix + "Output");
    CharSequence _generate = this.structGenerator.generate(_plus, content, false);
    this.declaration = _generate;
  }
  
  /**
   * @param context
   * @param node
   * @return
   */
  private CharSequence getVariableDeclaration(final IGeneratorContext context, final ComponentNode node) {
    final IComponentGenerator generator = GeneratorNodeExtensions.getComponentGenerator(node);
    IComponentGeneratorContext _context = generator.getContext();
    final IComponentSignature signature = _context.getComponentSignature();
    Component _component = node.getComponent();
    final InputPort inputPort = _component.getFirstInputPort();
    final Type dataType = signature.getInputDataType(inputPort);
    Configuration _configuration = context.getConfiguration();
    ComputationModel _computationModel = GeneratorConfigurationExtensions.getComputationModel(_configuration, node);
    Configuration _configuration_1 = context.getConfiguration();
    MscriptGeneratorConfiguration _mscriptGeneratorConfiguration = new MscriptGeneratorConfiguration(_computationModel, _configuration_1);
    Component _component_1 = node.getComponent();
    String _name = _component_1.getName();
    String _firstLower = StringExtensions.toFirstLower(_name);
    return this.variableDeclarationGenerator.generateVariableDeclaration(_mscriptGeneratorConfiguration, context, dataType, _firstLower, false, this);
  }
  
  public CharSequence generateForwardDeclaration(final boolean internal) {
    return this.declaration;
  }
}
