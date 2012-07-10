package org.eclipselabs.damos.mscript.codegen.c.codefragments;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.IntegerRange;
import org.eclipselabs.damos.mscript.codegen.c.AbstractCodeFragment;
import org.eclipselabs.damos.mscript.codegen.c.ICodeFragmentCollector;
import org.eclipselabs.damos.mscript.codegen.c.ICodeFragmentContext;
import org.eclipselabs.damos.mscript.codegen.c.IGlobalNameProvider;
import org.eclipselabs.damos.mscript.codegen.c.datatype.MachineArrayType;
import org.eclipselabs.damos.mscript.codegen.c.datatype.MachineDataType;

/**
 * @author Andreas Unger
 */
@SuppressWarnings("all")
public class ArrayTypeDeclaration extends AbstractCodeFragment {
  private final MachineArrayType arrayType;
  
  private CharSequence elementType;
  
  private String name;
  
  @Inject
  public ArrayTypeDeclaration(@Assisted final MachineArrayType arrayType) {
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
    CharSequence _generateDataType = _elementType.generateDataType(_codeFragmentCollector, this);
    this.elementType = _generateDataType;
    String _switchResult = null;
    int _dimensionality = this.arrayType.getDimensionality();
    final int _switchValue = _dimensionality;
    boolean _matched = false;
    if (!_matched) {
      if (Objects.equal(_switchValue,1)) {
        _matched=true;
        _switchResult = "Vector";
      }
    }
    if (!_matched) {
      if (Objects.equal(_switchValue,2)) {
        _matched=true;
        _switchResult = "Matrix";
      }
    }
    if (!_matched) {
      _switchResult = "Array";
    }
    final String preferredName = _switchResult;
    IGlobalNameProvider _globalNameProvider = context.getGlobalNameProvider();
    String _newGlobalName = _globalNameProvider.newGlobalName(preferredName);
    this.name = _newGlobalName;
  }
  
  public CharSequence generateForwardDeclaration(final boolean internal) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("typedef struct { ");
    _builder.append(this.elementType, "");
    _builder.append(" data");
    {
      int[] _dimensionSizes = this.arrayType.getDimensionSizes();
      for(final int size : _dimensionSizes) {
        _builder.append("[");
        _builder.append(size, "");
        _builder.append("]");
      }
    }
    _builder.append("; } ");
    _builder.append(this.name, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    {
      boolean _not = (!internal);
      if (_not) {
        {
          int _dimensionality = this.arrayType.getDimensionality();
          boolean _equals = (_dimensionality == 1);
          if (_equals) {
            _builder.append("#define ");
            String _upperCase = this.name.toUpperCase();
            _builder.append(_upperCase, "");
            _builder.append("_SIZE ");
            int _dimensionSize = this.arrayType.getDimensionSize(0);
            _builder.append(_dimensionSize, "");
            _builder.newLineIfNotEmpty();
          } else {
            int _dimensionality_1 = this.arrayType.getDimensionality();
            boolean _equals_1 = (_dimensionality_1 == 2);
            if (_equals_1) {
              _builder.append("#define ");
              String _upperCase_1 = this.name.toUpperCase();
              _builder.append(_upperCase_1, "");
              _builder.append("_ROW_SIZE ");
              int _dimensionSize_1 = this.arrayType.getDimensionSize(0);
              _builder.append(_dimensionSize_1, "");
              _builder.newLineIfNotEmpty();
              _builder.append("#define ");
              String _upperCase_2 = this.name.toUpperCase();
              _builder.append(_upperCase_2, "");
              _builder.append("_COLUMN_SIZE ");
              int _dimensionSize_2 = this.arrayType.getDimensionSize(1);
              _builder.append(_dimensionSize_2, "");
              _builder.newLineIfNotEmpty();
            } else {
              {
                int _dimensionality_2 = this.arrayType.getDimensionality();
                int _minus = (_dimensionality_2 - 1);
                IntegerRange _upTo = new IntegerRange(0, _minus);
                for(final Integer i : _upTo) {
                  _builder.append("#define ");
                  String _upperCase_3 = this.name.toUpperCase();
                  _builder.append(_upperCase_3, "");
                  _builder.append("_SIZE");
                  _builder.append(i, "");
                  _builder.append(" ");
                  int _dimensionSize_3 = this.arrayType.getDimensionSize((i).intValue());
                  _builder.append(_dimensionSize_3, "");
                  _builder.newLineIfNotEmpty();
                }
              }
            }
          }
        }
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
