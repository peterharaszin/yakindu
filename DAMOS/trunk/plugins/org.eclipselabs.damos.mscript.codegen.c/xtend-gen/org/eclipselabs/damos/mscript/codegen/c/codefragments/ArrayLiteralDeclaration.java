package org.eclipselabs.damos.mscript.codegen.c.codefragments;

import com.google.common.base.Objects;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipselabs.damos.mscript.ArrayType;
import org.eclipselabs.damos.mscript.codegen.c.AbstractCodeFragment;
import org.eclipselabs.damos.mscript.codegen.c.DataTypeGenerator;
import org.eclipselabs.damos.mscript.codegen.c.ICodeFragment;
import org.eclipselabs.damos.mscript.codegen.c.ICodeFragment.IDependencyRule;
import org.eclipselabs.damos.mscript.codegen.c.ICodeFragmentCollector;
import org.eclipselabs.damos.mscript.codegen.c.ICodeFragmentContext;
import org.eclipselabs.damos.mscript.codegen.c.IGlobalNameProvider;
import org.eclipselabs.damos.mscript.codegen.c.IMscriptGeneratorConfiguration;
import org.eclipselabs.damos.mscript.codegen.c.LiteralGenerator;
import org.eclipselabs.damos.mscript.codegen.c.codefragments.ArrayTypeDeclaration;
import org.eclipselabs.damos.mscript.codegen.c.datatype.MachineArrayType;
import org.eclipselabs.damos.mscript.codegen.c.datatype.MachineDataTypes;
import org.eclipselabs.damos.mscript.computationmodel.ComputationModel;
import org.eclipselabs.damos.mscript.interpreter.value.IArrayValue;

/**
 * @author Andreas Unger
 */
@SuppressWarnings("all")
public class ArrayLiteralDeclaration extends AbstractCodeFragment {
  private final LiteralGenerator literalGenerator = new Function0<LiteralGenerator>() {
    public LiteralGenerator apply() {
      DataTypeGenerator _dataTypeGenerator = new DataTypeGenerator();
      LiteralGenerator _literalGenerator = new LiteralGenerator(_dataTypeGenerator);
      return _literalGenerator;
    }
  }.apply();
  
  private final IMscriptGeneratorConfiguration configuration;
  
  private final IArrayValue arrayValue;
  
  private String name;
  
  private String typeName;
  
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
    final Function1<ICodeFragment,Boolean> _function = new Function1<ICodeFragment,Boolean>() {
        public Boolean apply(final ICodeFragment it) {
          return (it instanceof ArrayTypeDeclaration);
        }
      };
    this.addDependency(ICodeFragment.FORWARD_DECLARATION_DEPENDS_ON, new IDependencyRule() {
        public boolean applies(ICodeFragment other) {
          return _function.apply(other);
        }
    });
    final ICodeFragmentCollector codeFragmentCollector = context.getCodeFragmentCollector();
    ArrayType _dataType = this.arrayValue.getDataType();
    final MachineArrayType arrayType = MachineDataTypes.create(this.configuration, _dataType);
    ArrayTypeDeclaration _arrayTypeDeclaration = new ArrayTypeDeclaration(arrayType);
    final ArrayTypeDeclaration arrayTypeDeclaration = codeFragmentCollector.<ArrayTypeDeclaration>addCodeFragment(_arrayTypeDeclaration, monitor);
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
    String _name = arrayTypeDeclaration.getName();
    this.typeName = _name;
    IGlobalNameProvider _globalNameProvider = context.getGlobalNameProvider();
    String _newGlobalName = _globalNameProvider.newGlobalName(preferredName);
    this.name = _newGlobalName;
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
    _builder.append(this.typeName, "");
    _builder.append(" ");
    _builder.append(this.name, "");
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
    _builder.append(this.typeName, "");
    _builder.append(" ");
    _builder.append(this.name, "");
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
