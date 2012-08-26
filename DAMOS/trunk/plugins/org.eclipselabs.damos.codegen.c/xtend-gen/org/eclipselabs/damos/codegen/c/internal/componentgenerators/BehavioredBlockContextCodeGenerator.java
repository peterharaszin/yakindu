package org.eclipselabs.damos.codegen.c.internal.componentgenerators;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipselabs.damos.codegen.c.IComponentGeneratorContext;
import org.eclipselabs.damos.codegen.c.internal.componentgenerators.IBehavioredBlockGeneratorContext;
import org.eclipselabs.damos.mscript.FunctionDeclaration;
import org.eclipselabs.damos.mscript.InputParameterDeclaration;
import org.eclipselabs.damos.mscript.OutputParameterDeclaration;
import org.eclipselabs.damos.mscript.StateVariableDeclaration;
import org.eclipselabs.damos.mscript.Type;
import org.eclipselabs.damos.mscript.VariableDeclaration;
import org.eclipselabs.damos.mscript.codegen.c.DataTypeGenerator;
import org.eclipselabs.damos.mscript.codegen.c.ICodeFragmentCollector;
import org.eclipselabs.damos.mscript.codegen.c.IMscriptGeneratorConfiguration;
import org.eclipselabs.damos.mscript.codegen.c.VariableDeclarationGenerator;
import org.eclipselabs.damos.mscript.computation.ComputationModel;
import org.eclipselabs.damos.mscript.function.FunctionInstance;
import org.eclipselabs.damos.mscript.interpreter.IStaticEvaluationResult;
import org.eclipselabs.damos.mscript.interpreter.value.IValue;

/**
 * @author Andreas Unger
 */
@SuppressWarnings("all")
public class BehavioredBlockContextCodeGenerator {
  private final DataTypeGenerator dataTypeGenerator = new Function0<DataTypeGenerator>() {
    public DataTypeGenerator apply() {
      DataTypeGenerator _dataTypeGenerator = new DataTypeGenerator();
      return _dataTypeGenerator;
    }
  }.apply();
  
  private final VariableDeclarationGenerator variableDeclarationGenerator = new Function0<VariableDeclarationGenerator>() {
    public VariableDeclarationGenerator apply() {
      DataTypeGenerator _dataTypeGenerator = new DataTypeGenerator();
      VariableDeclarationGenerator _variableDeclarationGenerator = new VariableDeclarationGenerator(_dataTypeGenerator);
      return _variableDeclarationGenerator;
    }
  }.apply();
  
  public CharSequence generateContextCode(final IBehavioredBlockGeneratorContext context, final CharSequence typeName, final IProgressMonitor monitor) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("typedef struct {");
    _builder.newLine();
    {
      FunctionInstance _functionInstance = context.getFunctionInstance();
      FunctionDeclaration _declaration = _functionInstance.getDeclaration();
      EList<InputParameterDeclaration> _inputParameterDeclarations = _declaration.getInputParameterDeclarations();
      for(final InputParameterDeclaration d : _inputParameterDeclarations) {
        {
          boolean _hasContext = this.hasContext(context, d);
          if (_hasContext) {
            _builder.append("\t");
            CharSequence _generateContextStructureMember = this.generateContextStructureMember(context, monitor, d);
            _builder.append(_generateContextStructureMember, "	");
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    {
      FunctionInstance _functionInstance_1 = context.getFunctionInstance();
      FunctionDeclaration _declaration_1 = _functionInstance_1.getDeclaration();
      EList<OutputParameterDeclaration> _outputParameterDeclarations = _declaration_1.getOutputParameterDeclarations();
      for(final OutputParameterDeclaration d_1 : _outputParameterDeclarations) {
        {
          boolean _hasContext_1 = this.hasContext(context, d_1);
          if (_hasContext_1) {
            _builder.append("\t");
            CharSequence _generateContextStructureMember_1 = this.generateContextStructureMember(context, monitor, d_1);
            _builder.append(_generateContextStructureMember_1, "	");
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    {
      FunctionInstance _functionInstance_2 = context.getFunctionInstance();
      FunctionDeclaration _declaration_2 = _functionInstance_2.getDeclaration();
      EList<StateVariableDeclaration> _stateVariableDeclarations = _declaration_2.getStateVariableDeclarations();
      for(final StateVariableDeclaration d_2 : _stateVariableDeclarations) {
        _builder.append("\t");
        CharSequence _generateContextStructureMember_2 = this.generateContextStructureMember(context, monitor, d_2);
        _builder.append(_generateContextStructureMember_2, "	");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("} ");
    _builder.append(typeName, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  private CharSequence generateContextStructureMember(final IBehavioredBlockGeneratorContext context, final IProgressMonitor monitor, final VariableDeclaration variableDeclaration) {
    final String name = variableDeclaration.getName();
    IStaticEvaluationResult _staticEvaluationResult = context.getStaticEvaluationResult();
    IValue _value = _staticEvaluationResult.getValue(variableDeclaration);
    final Type dataType = _value.getDataType();
    IMscriptGeneratorConfiguration _mscriptGeneratorConfiguration = context.getMscriptGeneratorConfiguration();
    IComponentGeneratorContext _context = context.getContext();
    ICodeFragmentCollector _codeFragmentCollector = _context.getCodeFragmentCollector();
    final CharSequence cVariableDeclaration = this.variableDeclarationGenerator.generateVariableDeclaration(_mscriptGeneratorConfiguration, _codeFragmentCollector, dataType, name, false, null);
    boolean _hasContext = this.hasContext(context, variableDeclaration);
    if (_hasContext) {
      IStaticEvaluationResult _staticEvaluationResult_1 = context.getStaticEvaluationResult();
      final int bufferSize = _staticEvaluationResult_1.getCircularBufferSize(variableDeclaration);
      IMscriptGeneratorConfiguration _mscriptGeneratorConfiguration_1 = context.getMscriptGeneratorConfiguration();
      ComputationModel _computationModel = _mscriptGeneratorConfiguration_1.getComputationModel();
      int _multiply = (2 * bufferSize);
      final CharSequence indexCDataType = this.dataTypeGenerator.generateIndexDataType(_computationModel, _multiply);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append(cVariableDeclaration, "");
      _builder.append("[");
      _builder.append(bufferSize, "");
      _builder.append("];");
      _builder.newLineIfNotEmpty();
      _builder.append(indexCDataType, "");
      _builder.append(" ");
      _builder.append(name, "");
      _builder.append("_index;");
      _builder.newLineIfNotEmpty();
      return _builder;
    }
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append(cVariableDeclaration, "");
    _builder_1.append(";");
    return _builder_1;
  }
  
  private boolean hasContext(final IBehavioredBlockGeneratorContext context, final VariableDeclaration variableDeclaration) {
    IStaticEvaluationResult _staticEvaluationResult = context.getStaticEvaluationResult();
    int _circularBufferSize = _staticEvaluationResult.getCircularBufferSize(variableDeclaration);
    return (_circularBufferSize > 1);
  }
}
