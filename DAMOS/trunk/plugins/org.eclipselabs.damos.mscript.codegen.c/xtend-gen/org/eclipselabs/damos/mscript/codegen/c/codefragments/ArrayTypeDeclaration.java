package org.eclipselabs.damos.mscript.codegen.c.codefragments;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipselabs.damos.mscript.codegen.c.AbstractCodeFragment;
import org.eclipselabs.damos.mscript.codegen.c.ICodeFragmentCollector;
import org.eclipselabs.damos.mscript.codegen.c.ICodeFragmentContext;
import org.eclipselabs.damos.mscript.codegen.c.IGlobalNameProvider;
import org.eclipselabs.damos.mscript.codegen.c.datatype.MachineArrayType;
import org.eclipselabs.damos.mscript.codegen.c.datatype.MachineDataType;
import org.eclipselabs.damos.mscript.computationmodel.ComputationModel;

/**
 * @author Andreas Unger
 */
@SuppressWarnings("all")
public class ArrayTypeDeclaration extends AbstractCodeFragment {
  private final ComputationModel computationModel;
  
  private final MachineArrayType arrayType;
  
  private CharSequence elementType;
  
  private String name;
  
  @Inject
  public ArrayTypeDeclaration(@Assisted final ComputationModel computationModel, @Assisted final MachineArrayType arrayType) {
    this.computationModel = computationModel;
    this.arrayType = arrayType;
  }
  
  /**
   * @return the name
   */
  public String getName() {
    return this.name;
  }
  
  public void initialize(final ICodeFragmentContext context, final IProgressMonitor monitor) {
    MachineDataType _elementType = this.arrayType.getElementType();
    ICodeFragmentCollector _codeFragmentCollector = context.getCodeFragmentCollector();
    CharSequence _generateDataType = _elementType.generateDataType(this.computationModel, _codeFragmentCollector, this);
    this.elementType = _generateDataType;
    IGlobalNameProvider _globalNameProvider = context.getGlobalNameProvider();
    String _newGlobalName = _globalNameProvider.newGlobalName("Array");
    this.name = _newGlobalName;
  }
  
  public CharSequence generateForwardDeclaration(final boolean internal) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("typedef struct { ");
    _builder.append(this.elementType, "");
    _builder.append(" data[");
    int _dimension = this.arrayType.getDimension(0);
    _builder.append(_dimension, "");
    _builder.append("]; } ");
    _builder.append(this.name, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    {
      boolean _not = (!internal);
      if (_not) {
        _builder.append("#define ");
        String _upperCase = this.name.toUpperCase();
        _builder.append(_upperCase, "");
        _builder.append("_SIZE ");
        int _dimension_1 = this.arrayType.getDimension(0);
        _builder.append(_dimension_1, "");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }
  
  public int hashCode() {
    Class<? extends Object> _class = this.getClass();
    int _hashCode = _class.hashCode();
    int _hashCode_1 = this.arrayType.hashCode();
    return (_hashCode ^ _hashCode_1);
  }
  
  public boolean equals(final Object obj) {
    if ((obj instanceof ArrayTypeDeclaration)) {
      final ArrayTypeDeclaration other = ((ArrayTypeDeclaration) obj);
      return Objects.equal(other.arrayType, this.arrayType);
    }
    return false;
  }
}
