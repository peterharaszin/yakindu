package org.eclipselabs.damos.codegen.c.codefragments;

import java.util.List;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.eclipselabs.damos.codegen.c.IComponentGenerator;
import org.eclipselabs.damos.codegen.c.IComponentGeneratorContext;
import org.eclipselabs.damos.codegen.c.IGeneratorContext;
import org.eclipselabs.damos.codegen.c.MscriptGeneratorConfiguration;
import org.eclipselabs.damos.codegen.c.codefragments.PrimaryCodeFragment;
import org.eclipselabs.damos.codegen.c.internal.util.InternalGeneratorUtil;
import org.eclipselabs.damos.codegen.c.util.GeneratorConfigurationExtensions;
import org.eclipselabs.damos.codegen.c.util.GeneratorNodeExtensions;
import org.eclipselabs.damos.dconfig.Configuration;
import org.eclipselabs.damos.dml.Component;
import org.eclipselabs.damos.dml.OutputPort;
import org.eclipselabs.damos.execution.ComponentNode;
import org.eclipselabs.damos.execution.datatype.IComponentSignature;
import org.eclipselabs.damos.mscript.DataType;
import org.eclipselabs.damos.mscript.codegen.c.DataTypeGenerator;
import org.eclipselabs.damos.mscript.codegen.c.VariableDeclarationGenerator;
import org.eclipselabs.damos.mscript.computationmodel.ComputationModel;

/**
 * @author Andreas Unger
 */
@SuppressWarnings("all")
public class InputStruct extends PrimaryCodeFragment {
  private final VariableDeclarationGenerator variableDeclarationGenerator = new Function0<VariableDeclarationGenerator>() {
    public VariableDeclarationGenerator apply() {
      DataTypeGenerator _dataTypeGenerator = new DataTypeGenerator();
      VariableDeclarationGenerator _variableDeclarationGenerator = new VariableDeclarationGenerator(_dataTypeGenerator);
      return _variableDeclarationGenerator;
    }
  }.apply();
  
  private CharSequence content;
  
  public void doInitialize(final IGeneratorContext context, final IProgressMonitor monitor) {
    Configuration _configuration = context.getConfiguration();
    final String prefix = GeneratorConfigurationExtensions.getPrefix(_configuration);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("typedef struct {");
    _builder.newLine();
    {
      List<ComponentNode> _inportNodes = InternalGeneratorUtil.getInportNodes(context);
      for(final ComponentNode node : _inportNodes) {
        _builder.append("\t");
        CharSequence _variableDeclaration = this.getVariableDeclaration(context, node);
        _builder.append(_variableDeclaration, "	");
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
  private CharSequence getVariableDeclaration(final IGeneratorContext context, final ComponentNode node) {
    final IComponentGenerator generator = GeneratorNodeExtensions.getComponentGenerator(node);
    IComponentGeneratorContext _context = generator.getContext();
    final IComponentSignature signature = _context.getComponentSignature();
    Component _component = node.getComponent();
    final OutputPort outputPort = _component.getFirstOutputPort();
    final DataType dataType = signature.getOutputDataType(outputPort);
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
    return this.content;
  }
}
