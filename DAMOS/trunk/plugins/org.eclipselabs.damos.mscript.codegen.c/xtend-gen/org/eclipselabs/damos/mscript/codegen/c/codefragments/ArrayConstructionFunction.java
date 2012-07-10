package org.eclipselabs.damos.mscript.codegen.c.codefragments;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IntegerRange;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipselabs.damos.mscript.codegen.c.AbstractCodeFragment;
import org.eclipselabs.damos.mscript.codegen.c.ICodeFragment;
import org.eclipselabs.damos.mscript.codegen.c.ICodeFragment.IDependencyRule;
import org.eclipselabs.damos.mscript.codegen.c.ICodeFragmentCollector;
import org.eclipselabs.damos.mscript.codegen.c.ICodeFragmentContext;
import org.eclipselabs.damos.mscript.codegen.c.IGlobalNameProvider;
import org.eclipselabs.damos.mscript.codegen.c.codefragments.ArrayTypeDeclaration;
import org.eclipselabs.damos.mscript.codegen.c.datatype.MachineArrayType;
import org.eclipselabs.damos.mscript.codegen.c.datatype.MachineDataType;

/**
 * @author Andreas Unger
 */
@SuppressWarnings("all")
public class ArrayConstructionFunction extends AbstractCodeFragment {
  private final MachineArrayType arrayType;
  
  private String typeName;
  
  private String name;
  
  private CharSequence functionSignature;
  
  @Inject
  public ArrayConstructionFunction(@Assisted final MachineArrayType arrayType) {
    this.arrayType = arrayType;
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
    ArrayTypeDeclaration _arrayTypeDeclaration = new ArrayTypeDeclaration(this.arrayType);
    final ArrayTypeDeclaration arrayTypeDeclaration = codeFragmentCollector.<ArrayTypeDeclaration>addCodeFragment(_arrayTypeDeclaration, monitor);
    String _switchResult = null;
    int _dimensionality = this.arrayType.getDimensionality();
    final int _switchValue = _dimensionality;
    boolean _matched = false;
    if (!_matched) {
      if (Objects.equal(_switchValue,1)) {
        _matched=true;
        _switchResult = "newVector";
      }
    }
    if (!_matched) {
      if (Objects.equal(_switchValue,2)) {
        _matched=true;
        _switchResult = "newMatrix";
      }
    }
    if (!_matched) {
      _switchResult = "newArray";
    }
    final String preferredName = _switchResult;
    String _name = arrayTypeDeclaration.getName();
    this.typeName = _name;
    IGlobalNameProvider _globalNameProvider = context.getGlobalNameProvider();
    String _newGlobalName = _globalNameProvider.newGlobalName(preferredName);
    this.name = _newGlobalName;
    CharSequence _generateFunctionSignature = this.generateFunctionSignature(codeFragmentCollector);
    this.functionSignature = _generateFunctionSignature;
  }
  
  public boolean contributesInternalForwardDeclaration() {
    return false;
  }
  
  public CharSequence generateForwardDeclaration(final boolean internal) {
    StringConcatenation _builder = new StringConcatenation();
    {
      if (internal) {
        _builder.append("static ");
      }
    }
    _builder.append(this.functionSignature, "");
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
    _builder.append(this.functionSignature, "");
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append(this.typeName, "	");
    _builder.append(" ");
    CharSequence _variableName = this.getVariableName();
    _builder.append(_variableName, "	");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    List<Integer> _emptyList = Collections.<Integer>emptyList();
    CharSequence _generateArrayElementAssignments = this.generateArrayElementAssignments(0, _emptyList);
    _builder.append(_generateArrayElementAssignments, "	");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("return ");
    CharSequence _variableName_1 = this.getVariableName();
    _builder.append(_variableName_1, "	");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  private CharSequence generateFunctionSignature(final ICodeFragmentCollector codeFragmentCollector) {
    CharSequence _xblockexpression = null;
    {
      MachineDataType _elementType = this.arrayType.getElementType();
      final CharSequence dataType = _elementType.generateDataType(codeFragmentCollector, this);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append(this.typeName, "");
      _builder.append(" ");
      _builder.append(this.name, "");
      _builder.append("(");
      List<Integer> _emptyList = Collections.<Integer>emptyList();
      CharSequence _generateFunctionParameters = this.generateFunctionParameters(dataType, 0, _emptyList);
      _builder.append(_generateFunctionParameters, "");
      _builder.append(")");
      _xblockexpression = (_builder);
    }
    return _xblockexpression;
  }
  
  private CharSequence generateFunctionParameters(final CharSequence dataType, final int dimension, final List<Integer> previousIndices) {
    CharSequence _xblockexpression = null;
    {
      int _dimensionSize = this.arrayType.getDimensionSize(dimension);
      int _minus = (_dimensionSize - 1);
      final IntegerRange indices = new IntegerRange(0, _minus);
      CharSequence _xifexpression = null;
      int _dimensionality = this.arrayType.getDimensionality();
      int _minus_1 = (_dimensionality - 1);
      boolean _equals = (dimension == _minus_1);
      if (_equals) {
        StringConcatenation _builder = new StringConcatenation();
        {
          boolean _hasElements = false;
          for(final Integer i : indices) {
            if (!_hasElements) {
              _hasElements = true;
            } else {
              _builder.appendImmediate(", ", "");
            }
            _builder.append(dataType, "");
            _builder.append(" e");
            List<Integer> _concat = ArrayConstructionFunction.<Integer>concat(previousIndices, i);
            String _join = IterableExtensions.join(_concat, "_");
            _builder.append(_join, "");
          }
        }
        _xifexpression = _builder;
      } else {
        StringConcatenation _builder_1 = new StringConcatenation();
        {
          boolean _hasElements_1 = false;
          for(final Integer i_1 : indices) {
            if (!_hasElements_1) {
              _hasElements_1 = true;
            } else {
              _builder_1.appendImmediate(", ", "");
            }
            int _plus = (dimension + 1);
            List<Integer> _concat_1 = ArrayConstructionFunction.<Integer>concat(previousIndices, i_1);
            CharSequence _generateFunctionParameters = this.generateFunctionParameters(dataType, _plus, _concat_1);
            _builder_1.append(_generateFunctionParameters, "");
          }
        }
        _xifexpression = _builder_1;
      }
      _xblockexpression = (_xifexpression);
    }
    return _xblockexpression;
  }
  
  private CharSequence generateArrayElementAssignments(final int dimension, final List<Integer> previousIndices) {
    CharSequence _xblockexpression = null;
    {
      int _dimensionSize = this.arrayType.getDimensionSize(dimension);
      int _minus = (_dimensionSize - 1);
      final IntegerRange indices = new IntegerRange(0, _minus);
      StringConcatenation _builder = new StringConcatenation();
      {
        int _dimensionality = this.arrayType.getDimensionality();
        int _minus_1 = (_dimensionality - 1);
        boolean _equals = (dimension == _minus_1);
        if (_equals) {
          {
            for(final Integer i : indices) {
              CharSequence _variableName = this.getVariableName();
              _builder.append(_variableName, "");
              _builder.append(".data");
              {
                List<Integer> _concat = ArrayConstructionFunction.<Integer>concat(previousIndices, i);
                for(final Integer j : _concat) {
                  _builder.append("[");
                  _builder.append(j, "");
                  _builder.append("]");
                }
              }
              _builder.append(" = e");
              List<Integer> _concat_1 = ArrayConstructionFunction.<Integer>concat(previousIndices, i);
              String _join = IterableExtensions.join(_concat_1, "_");
              _builder.append(_join, "");
              _builder.append(";");
              _builder.newLineIfNotEmpty();
            }
          }
        } else {
          {
            for(final Integer i_1 : indices) {
              int _plus = (dimension + 1);
              List<Integer> _concat_2 = ArrayConstructionFunction.<Integer>concat(previousIndices, i_1);
              CharSequence _generateArrayElementAssignments = this.generateArrayElementAssignments(_plus, _concat_2);
              _builder.append(_generateArrayElementAssignments, "");
              _builder.newLineIfNotEmpty();
            }
          }
        }
      }
      _xblockexpression = (_builder);
    }
    return _xblockexpression;
  }
  
  private CharSequence getVariableName() {
    String _switchResult = null;
    int _dimensionality = this.arrayType.getDimensionality();
    final int _switchValue = _dimensionality;
    boolean _matched = false;
    if (!_matched) {
      if (Objects.equal(_switchValue,1)) {
        _matched=true;
        _switchResult = "v";
      }
    }
    if (!_matched) {
      if (Objects.equal(_switchValue,2)) {
        _matched=true;
        _switchResult = "m";
      }
    }
    if (!_matched) {
      _switchResult = "a";
    }
    return _switchResult;
  }
  
  private static <T extends Object> List<T> concat(final List<? extends T> collection, final T element) {
    int _size = collection.size();
    int _plus = (_size + 1);
    ArrayList<T> _arrayList = new ArrayList<T>(_plus);
    final ArrayList<T> result = _arrayList;
    Iterables.<T>addAll(result, collection);
    result.add(element);
    return result;
  }
  
  public int hashCode() {
    Class<? extends Object> _class = this.getClass();
    int _hashCode = _class.hashCode();
    int _hashCode_1 = this.arrayType.hashCode();
    return (_hashCode ^ _hashCode_1);
  }
  
  public boolean equals(final Object obj) {
    if ((obj instanceof ArrayConstructionFunction)) {
      final ArrayConstructionFunction other = ((ArrayConstructionFunction) obj);
      return Objects.equal(other.arrayType, this.arrayType);
    }
    return false;
  }
}
