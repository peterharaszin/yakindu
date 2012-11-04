package org.eclipse.damos.mscript.codegen.c.codefragments;

import com.google.inject.Inject;
import org.eclipse.damos.mscript.FunctionDeclaration;
import org.eclipse.damos.mscript.InputParameterDeclaration;
import org.eclipse.damos.mscript.OutputParameterDeclaration;
import org.eclipse.damos.mscript.StateVariableDeclaration;
import org.eclipse.damos.mscript.Type;
import org.eclipse.damos.mscript.VariableDeclaration;
import org.eclipse.damos.mscript.codegen.c.ICodeFragmentCollector;
import org.eclipse.damos.mscript.codegen.c.IMscriptGeneratorConfiguration;
import org.eclipse.damos.mscript.codegen.c.IMscriptGeneratorContext;
import org.eclipse.damos.mscript.codegen.c.PrimitiveTypeGenerator;
import org.eclipse.damos.mscript.codegen.c.codefragments.AbstractContextStructMember;
import org.eclipse.damos.mscript.codegen.c.datatype.MachineDataType;
import org.eclipse.damos.mscript.codegen.c.datatype.MachineDataTypeFactory;
import org.eclipse.damos.mscript.function.FunctionInstance;
import org.eclipse.damos.mscript.interpreter.StaticFunctionInfo;
import org.eclipse.damos.mscript.interpreter.value.IValue;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;

/**
 * @author Andreas Unger
 */
@SuppressWarnings("all")
public class FunctionContext extends AbstractContextStructMember {
  @Inject
  private PrimitiveTypeGenerator primitiveTypeGenerator;
  
  @Inject
  private MachineDataTypeFactory machineDataTypeFactory;
  
  private final IMscriptGeneratorContext generatorContext;
  
  public FunctionContext(final IMscriptGeneratorContext generatorContext) {
    this.generatorContext = generatorContext;
  }
  
  public CharSequence generate() {
    StringConcatenation _builder = new StringConcatenation();
    {
      StaticFunctionInfo _functionInfo = this.generatorContext.getFunctionInfo();
      FunctionInstance _functionInstance = _functionInfo.getFunctionInstance();
      FunctionDeclaration _declaration = _functionInstance.getDeclaration();
      EList<InputParameterDeclaration> _nonConstantInputParameterDeclarations = _declaration.getNonConstantInputParameterDeclarations();
      for(final InputParameterDeclaration d : _nonConstantInputParameterDeclarations) {
        {
          boolean _hasContext = this.hasContext(d);
          if (_hasContext) {
            CharSequence _generateContextStructureMember = this.generateContextStructureMember(d);
            _builder.append(_generateContextStructureMember, "");
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    {
      StaticFunctionInfo _functionInfo_1 = this.generatorContext.getFunctionInfo();
      FunctionInstance _functionInstance_1 = _functionInfo_1.getFunctionInstance();
      FunctionDeclaration _declaration_1 = _functionInstance_1.getDeclaration();
      EList<OutputParameterDeclaration> _outputParameterDeclarations = _declaration_1.getOutputParameterDeclarations();
      for(final OutputParameterDeclaration d_1 : _outputParameterDeclarations) {
        {
          boolean _hasContext_1 = this.hasContext(d_1);
          if (_hasContext_1) {
            CharSequence _generateContextStructureMember_1 = this.generateContextStructureMember(d_1);
            _builder.append(_generateContextStructureMember_1, "");
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    {
      StaticFunctionInfo _functionInfo_2 = this.generatorContext.getFunctionInfo();
      FunctionInstance _functionInstance_2 = _functionInfo_2.getFunctionInstance();
      FunctionDeclaration _declaration_2 = _functionInstance_2.getDeclaration();
      EList<StateVariableDeclaration> _stateVariableDeclarations = _declaration_2.getStateVariableDeclarations();
      for(final StateVariableDeclaration d_2 : _stateVariableDeclarations) {
        CharSequence _generateContextStructureMember_2 = this.generateContextStructureMember(d_2);
        _builder.append(_generateContextStructureMember_2, "");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }
  
  private CharSequence generateContextStructureMember(final VariableDeclaration variableDeclaration) {
    final String variableName = variableDeclaration.getName();
    StaticFunctionInfo _functionInfo = this.generatorContext.getFunctionInfo();
    IValue _value = _functionInfo.getValue(variableDeclaration);
    final Type dataType = _value.getDataType();
    IMscriptGeneratorConfiguration _configuration = this.generatorContext.getConfiguration();
    MachineDataType _create = this.machineDataTypeFactory.create(_configuration, dataType);
    ICodeFragmentCollector _codeFragmentCollector = this.generatorContext.getCodeFragmentCollector();
    final CharSequence typeName = _create.generateDataType(null, _codeFragmentCollector, null);
    boolean _hasContext = this.hasContext(variableDeclaration);
    if (_hasContext) {
      StaticFunctionInfo _functionInfo_1 = this.generatorContext.getFunctionInfo();
      final int bufferSize = _functionInfo_1.getCircularBufferSize(variableDeclaration);
      int _multiply = (2 * bufferSize);
      final CharSequence indexCDataType = this.primitiveTypeGenerator.generateIndexType(_multiply);
      StringConcatenation _builder = new StringConcatenation();
      CharSequence _generateBufferVariableDeclaration = this.generateBufferVariableDeclaration(typeName, variableName, bufferSize);
      _builder.append(_generateBufferVariableDeclaration, "");
      _builder.newLineIfNotEmpty();
      _builder.append(indexCDataType, "");
      _builder.append(" ");
      _builder.append(variableName, "");
      _builder.append("_index;");
      _builder.newLineIfNotEmpty();
      return _builder;
    }
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append(typeName, "");
    _builder_1.append(" ");
    _builder_1.append(variableName, "");
    _builder_1.append(";");
    return _builder_1;
  }
  
  protected CharSequence generateBufferVariableDeclaration(final CharSequence typeName, final CharSequence variableName, final int bufferSize) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append(typeName, "");
    _builder.append(" ");
    _builder.append(variableName, "");
    _builder.append("[");
    _builder.append(bufferSize, "");
    _builder.append("];");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  private boolean hasContext(final VariableDeclaration variableDeclaration) {
    StaticFunctionInfo _functionInfo = this.generatorContext.getFunctionInfo();
    int _circularBufferSize = _functionInfo.getCircularBufferSize(variableDeclaration);
    return (_circularBufferSize > 1);
  }
}
