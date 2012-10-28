package org.eclipse.damos.mscript.codegen.c.codefragments;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.damos.mscript.ArrayType;
import org.eclipse.damos.mscript.codegen.c.AbstractCodeFragment;
import org.eclipse.damos.mscript.codegen.c.ICodeFragmentCollector;
import org.eclipse.damos.mscript.codegen.c.ICodeFragmentContext;
import org.eclipse.damos.mscript.codegen.c.IGlobalNameProvider;
import org.eclipse.damos.mscript.codegen.c.IMscriptGeneratorConfiguration;
import org.eclipse.damos.mscript.codegen.c.LiteralGenerator;
import org.eclipse.damos.mscript.codegen.c.datatype.MachineArrayType;
import org.eclipse.damos.mscript.codegen.c.datatype.MachineDataTypes;
import org.eclipse.damos.mscript.computation.ComputationModel;
import org.eclipse.damos.mscript.interpreter.value.IArrayValue;
import org.eclipse.xtend2.lib.StringConcatenation;

/**
 * @author Andreas Unger
 */
@SuppressWarnings("all")
public class ArrayLiteralDeclaration extends AbstractCodeFragment {
  @Inject
  private LiteralGenerator literalGenerator;
  
  private final IMscriptGeneratorConfiguration configuration;
  
  private final IArrayValue arrayValue;
  
  private String name;
  
  private CharSequence type;
  
  private CharSequence body;
  
  public ArrayLiteralDeclaration(final IMscriptGeneratorConfiguration configuration, final IArrayValue value) {
    this.configuration = configuration;
    this.arrayValue = value;
  }
  
  /**
   * @return the name
   */
  public String getName() {
    return this.name;
  }
  
  public void initialize(final ICodeFragmentContext context, final IProgressMonitor monitor) {
    final ICodeFragmentCollector codeFragmentCollector = context.getCodeFragmentCollector();
    ArrayType _dataType = this.arrayValue.getDataType();
    final MachineArrayType arrayType = MachineDataTypes.create(this.configuration, _dataType);
    String _switchResult = null;
    int _dimensionality = arrayType.getDimensionality();
    final int _switchValue = _dimensionality;
    boolean _matched = false;
    if (!_matched) {
      if (Objects.equal(_switchValue,1)) {
        _matched=true;
        _switchResult = "vector";
      }
    }
    if (!_matched) {
      if (Objects.equal(_switchValue,2)) {
        _matched=true;
        _switchResult = "matrix";
      }
    }
    if (!_matched) {
      _switchResult = "array";
    }
    final String preferredName = _switchResult;
    IGlobalNameProvider _globalNameProvider = context.getGlobalNameProvider();
    String _newGlobalName = _globalNameProvider.newGlobalName(preferredName);
    this.name = _newGlobalName;
    CharSequence _generateDataType = arrayType.generateDataType(this.name, codeFragmentCollector, this);
    this.type = _generateDataType;
    ComputationModel _computationModel = this.configuration.getComputationModel();
    CharSequence _generateInitializer = this.literalGenerator.generateInitializer(_computationModel, codeFragmentCollector, this.arrayValue);
    this.body = _generateInitializer;
  }
  
  public boolean contributesInternalForwardDeclaration() {
    return false;
  }
  
  public CharSequence generateForwardDeclaration(final boolean internal) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("extern const ");
    _builder.append(this.type, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  public boolean contributesImplementation() {
    return true;
  }
  
  public CharSequence generateImplementation(final boolean internal) {
    StringConcatenation _builder = new StringConcatenation();
    {
      if (internal) {
        _builder.append("static ");
      }
    }
    _builder.append("const ");
    _builder.append(this.type, "");
    _builder.append(" = ");
    _builder.append(this.body, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  public int hashCode() {
    Class<? extends Object> _class = this.getClass();
    return _class.hashCode();
  }
  
  public boolean equals(final Object obj) {
    return false;
  }
}
