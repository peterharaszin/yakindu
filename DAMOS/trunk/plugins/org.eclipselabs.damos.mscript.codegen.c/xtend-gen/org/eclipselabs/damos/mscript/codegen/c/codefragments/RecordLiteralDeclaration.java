package org.eclipselabs.damos.mscript.codegen.c.codefragments;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipselabs.damos.mscript.RecordType;
import org.eclipselabs.damos.mscript.codegen.c.AbstractCodeFragment;
import org.eclipselabs.damos.mscript.codegen.c.DataTypeGenerator;
import org.eclipselabs.damos.mscript.codegen.c.ICodeFragment;
import org.eclipselabs.damos.mscript.codegen.c.ICodeFragment.IDependencyRule;
import org.eclipselabs.damos.mscript.codegen.c.ICodeFragmentCollector;
import org.eclipselabs.damos.mscript.codegen.c.ICodeFragmentContext;
import org.eclipselabs.damos.mscript.codegen.c.IGlobalNameProvider;
import org.eclipselabs.damos.mscript.codegen.c.IMscriptGeneratorConfiguration;
import org.eclipselabs.damos.mscript.codegen.c.LiteralGenerator;
import org.eclipselabs.damos.mscript.codegen.c.codefragments.RecordTypeDeclaration;
import org.eclipselabs.damos.mscript.codegen.c.datatype.MachineDataTypes;
import org.eclipselabs.damos.mscript.codegen.c.datatype.MachineRecordType;
import org.eclipselabs.damos.mscript.computation.ComputationModel;
import org.eclipselabs.damos.mscript.interpreter.value.RecordValue;

/**
 * @author Andreas Unger
 */
@SuppressWarnings("all")
public class RecordLiteralDeclaration extends AbstractCodeFragment {
  private final LiteralGenerator literalGenerator = new Function0<LiteralGenerator>() {
    public LiteralGenerator apply() {
      DataTypeGenerator _dataTypeGenerator = new DataTypeGenerator();
      LiteralGenerator _literalGenerator = new LiteralGenerator(_dataTypeGenerator);
      return _literalGenerator;
    }
  }.apply();
  
  private final IMscriptGeneratorConfiguration configuration;
  
  private final RecordValue recordValue;
  
  private String typeName;
  
  private String name;
  
  private CharSequence body;
  
  public RecordLiteralDeclaration(final IMscriptGeneratorConfiguration configuration, final RecordValue value) {
    this.configuration = configuration;
    this.recordValue = value;
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
          return (it instanceof RecordTypeDeclaration);
        }
      };
    this.addDependency(ICodeFragment.FORWARD_DECLARATION_DEPENDS_ON, new IDependencyRule() {
        public boolean applies(ICodeFragment other) {
          return _function.apply(other);
        }
    });
    final ICodeFragmentCollector codeFragmentCollector = context.getCodeFragmentCollector();
    RecordType _dataType = this.recordValue.getDataType();
    MachineRecordType _create = MachineDataTypes.create(this.configuration, _dataType);
    RecordTypeDeclaration _recordTypeDeclaration = new RecordTypeDeclaration(_create);
    RecordTypeDeclaration recordTypeDeclaration = _recordTypeDeclaration;
    RecordTypeDeclaration _addCodeFragment = codeFragmentCollector.<RecordTypeDeclaration>addCodeFragment(recordTypeDeclaration, monitor);
    recordTypeDeclaration = _addCodeFragment;
    String _name = recordTypeDeclaration.getName();
    this.typeName = _name;
    IGlobalNameProvider _globalNameProvider = context.getGlobalNameProvider();
    String _newGlobalName = _globalNameProvider.newGlobalName("record");
    this.name = _newGlobalName;
    ComputationModel _computationModel = this.configuration.getComputationModel();
    CharSequence _generateInitializer = this.literalGenerator.generateInitializer(_computationModel, codeFragmentCollector, this.recordValue);
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
