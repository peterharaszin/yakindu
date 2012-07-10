package org.eclipselabs.damos.mscript.codegen.c.codefragments;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipselabs.damos.mscript.codegen.c.AbstractCodeFragment;
import org.eclipselabs.damos.mscript.codegen.c.ICodeFragment;
import org.eclipselabs.damos.mscript.codegen.c.ICodeFragment.IDependencyRule;
import org.eclipselabs.damos.mscript.codegen.c.ICodeFragmentCollector;
import org.eclipselabs.damos.mscript.codegen.c.ICodeFragmentContext;
import org.eclipselabs.damos.mscript.codegen.c.IGlobalNameProvider;
import org.eclipselabs.damos.mscript.codegen.c.IMscriptGeneratorConfiguration;
import org.eclipselabs.damos.mscript.codegen.c.Include;
import org.eclipselabs.damos.mscript.codegen.c.codefragments.ConstantStringSegment;
import org.eclipselabs.damos.mscript.codegen.c.codefragments.ExpressionStringSegment;
import org.eclipselabs.damos.mscript.codegen.c.codefragments.IStringSegment;
import org.eclipselabs.damos.mscript.codegen.c.codefragments.StringTable;
import org.eclipselabs.damos.mscript.codegen.c.codefragments.StringTypeDeclaration;
import org.eclipselabs.damos.mscript.codegen.c.datatype.MachineDataType;
import org.eclipselabs.damos.mscript.codegen.c.datatype.MachineNumericType;
import org.eclipselabs.damos.mscript.codegen.c.datatype.MachineStringType;
import org.eclipselabs.damos.mscript.computationmodel.FixedPointFormat;
import org.eclipselabs.damos.mscript.computationmodel.NumberFormat;

/**
 * @author Andreas Unger
 */
@SuppressWarnings("all")
public class StringConstructionFunction extends AbstractCodeFragment {
  private final IMscriptGeneratorConfiguration configuration;
  
  private final List<IStringSegment> stringSegments;
  
  private final boolean plain;
  
  private String typeName;
  
  private String name;
  
  private String stringTableName;
  
  private CharSequence functionSignature;
  
  @Inject
  public StringConstructionFunction(@Assisted final IMscriptGeneratorConfiguration configuration, @Assisted final List<? extends IStringSegment> stringSegments, final boolean plain) {
    this.configuration = configuration;
    ArrayList<IStringSegment> _arrayList = new ArrayList<IStringSegment>(stringSegments);
    this.stringSegments = _arrayList;
    this.plain = plain;
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
          return (it instanceof StringTypeDeclaration);
        }
      };
    this.addDependency(ICodeFragment.FORWARD_DECLARATION_DEPENDS_ON, new IDependencyRule() {
        public boolean applies(ICodeFragment other) {
          return _function.apply(other);
        }
    });
    final Function1<ICodeFragment,Boolean> _function_1 = new Function1<ICodeFragment,Boolean>() {
        public Boolean apply(final ICodeFragment it) {
          return (it instanceof StringTable);
        }
      };
    this.addDependency(ICodeFragment.IMPLEMENTATION_DEPENDS_ON, new IDependencyRule() {
        public boolean applies(ICodeFragment other) {
          return _function_1.apply(other);
        }
    });
    final ICodeFragmentCollector codeFragmentCollector = context.getCodeFragmentCollector();
    int _stringBufferSize = this.configuration.getStringBufferSize();
    StringTypeDeclaration _stringTypeDeclaration = new StringTypeDeclaration(_stringBufferSize);
    final StringTypeDeclaration stringTypeDeclaration = codeFragmentCollector.<StringTypeDeclaration>addCodeFragment(_stringTypeDeclaration, monitor);
    StringTable _stringTable = new StringTable();
    final StringTable stringTable = codeFragmentCollector.<StringTable>addCodeFragment(_stringTable, monitor);
    String _name = stringTypeDeclaration.getName();
    this.typeName = _name;
    IGlobalNameProvider _globalNameProvider = context.getGlobalNameProvider();
    String _newGlobalName = _globalNameProvider.newGlobalName("newString");
    this.name = _newGlobalName;
    String _name_1 = stringTable.getName();
    this.stringTableName = _name_1;
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
  
  public Collection<Include> getImplementationIncludes() {
    ArrayList<Include> _arrayList = new ArrayList<Include>();
    final Procedure1<ArrayList<Include>> _function = new Procedure1<ArrayList<Include>>() {
        public void apply(final ArrayList<Include> it) {
          Include _include = new Include("inttypes.h");
          it.add(_include);
          Include _include_1 = new Include("stdio.h");
          it.add(_include_1);
        }
      };
    return ObjectExtensions.<ArrayList<Include>>operator_doubleArrow(_arrayList, _function);
  }
  
  public CharSequence generateImplementation(final boolean internal) {
    CharSequence _xblockexpression = null;
    {
      int index = 0;
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
      _builder.append(" result;");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("int i = 0;");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      {
        for(final IStringSegment s : this.stringSegments) {
          _builder.append("\t");
          int _plus = (index + 1);
          int _index = index = _plus;
          CharSequence _generateStringSegment = this.generateStringSegment(s, _index);
          _builder.append(_generateStringSegment, "	");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("result.data[i] = \'\\0\';");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("return result;");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _xblockexpression = (_builder);
    }
    return _xblockexpression;
  }
  
  private CharSequence _generateStringSegment(final ConstantStringSegment s, final int index) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("if (i < ");
    int _stringBufferSize = this.configuration.getStringBufferSize();
    int _minus = (_stringBufferSize - 1);
    _builder.append(_minus, "");
    _builder.append(") {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("result.data[i++] = 0x80 | s");
    _builder.append(index, "	");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  private CharSequence _generateStringSegment(final ExpressionStringSegment s, final int index) {
    StringConcatenation _builder = new StringConcatenation();
    {
      boolean _not = (!this.plain);
      if (_not) {
        _builder.append("if (i < ");
        int _stringBufferSize = this.configuration.getStringBufferSize();
        int _minus = (_stringBufferSize - 1);
        _builder.append(_minus, "");
        _builder.append(") {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("result.data[i++] = 0x80 | indent");
        _builder.append(index, "	");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
        _builder.append("}");
        _builder.newLine();
      }
    }
    {
      boolean _isStatic_ = s.isStatic_();
      if (_isStatic_) {
        _builder.append("result.data[i++] = 0x80 | s");
        _builder.append(index, "");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
      } else {
        MachineDataType _dataType = s.getDataType();
        CharSequence _generateExpressionStringSegment = this.generateExpressionStringSegment(_dataType, index);
        _builder.append(_generateExpressionStringSegment, "");
        _builder.newLineIfNotEmpty();
      }
    }
    {
      boolean _not_1 = (!this.plain);
      if (_not_1) {
        _builder.append("if (i < ");
        int _stringBufferSize_1 = this.configuration.getStringBufferSize();
        int _minus_1 = (_stringBufferSize_1 - 1);
        _builder.append(_minus_1, "");
        _builder.append(") {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("result.data[i++] = 0x03;");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
      }
    }
    return _builder;
  }
  
  private CharSequence _generateExpressionStringSegment(final MachineStringType type, final int index) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("{");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("int j;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("for (j = 0; i < ");
    int _stringBufferSize = this.configuration.getStringBufferSize();
    int _minus = (_stringBufferSize - 1);
    _builder.append(_minus, "	");
    _builder.append(" && s");
    _builder.append(index, "	");
    _builder.append("[j] != \'\\0\'; ++j) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("result.data[i++] = s");
    _builder.append(index, "		");
    _builder.append("[j];");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  private CharSequence _generateExpressionStringSegment(final MachineNumericType type, final int index) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("i += snprintf(result.data + i, ");
    int _stringBufferSize = this.configuration.getStringBufferSize();
    _builder.append(_stringBufferSize, "");
    _builder.append(" - i, \"%\" PRId");
    int _wordSize = this.getWordSize(type);
    _builder.append(_wordSize, "");
    _builder.append(", s");
    _builder.append(index, "");
    _builder.append(");");
    _builder.newLineIfNotEmpty();
    _builder.append("if (i > ");
    int _stringBufferSize_1 = this.configuration.getStringBufferSize();
    int _minus = (_stringBufferSize_1 - 1);
    _builder.append(_minus, "");
    _builder.append(") {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("i = ");
    int _stringBufferSize_2 = this.configuration.getStringBufferSize();
    int _minus_1 = (_stringBufferSize_2 - 1);
    _builder.append(_minus_1, "	");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  private int getWordSize(final MachineNumericType type) {
    NumberFormat _numberFormat = type.getNumberFormat();
    if ((_numberFormat instanceof FixedPointFormat)) {
      NumberFormat _numberFormat_1 = type.getNumberFormat();
      return ((FixedPointFormat) _numberFormat_1).getWordSize();
    }
    return 0;
  }
  
  private CharSequence generateFunctionSignature(final ICodeFragmentCollector codeFragmentCollector) {
    CharSequence _xblockexpression = null;
    {
      int index = 0;
      StringConcatenation _builder = new StringConcatenation();
      _builder.append(this.typeName, "");
      _builder.append(" ");
      _builder.append(this.name, "");
      _builder.append("(");
      {
        boolean _hasElements = false;
        for(final IStringSegment s : this.stringSegments) {
          if (!_hasElements) {
            _hasElements = true;
          } else {
            _builder.appendImmediate(", ", "");
          }
          int _plus = (index + 1);
          int _index = index = _plus;
          CharSequence _generateFunctionParameter = this.generateFunctionParameter(codeFragmentCollector, s, _index);
          _builder.append(_generateFunctionParameter, "");
        }
      }
      _builder.append(")");
      _xblockexpression = (_builder);
    }
    return _xblockexpression;
  }
  
  private CharSequence _generateFunctionParameter(final ICodeFragmentCollector codeFragmentCollector, final ConstantStringSegment s, final int index) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _generateDataType = s.generateDataType(codeFragmentCollector, this);
    _builder.append(_generateDataType, "");
    _builder.append("s");
    _builder.append(index, "");
    return _builder;
  }
  
  private CharSequence _generateFunctionParameter(final ICodeFragmentCollector codeFragmentCollector, final ExpressionStringSegment s, final int index) {
    StringConcatenation _builder = new StringConcatenation();
    {
      boolean _not = (!this.plain);
      if (_not) {
        _builder.append("int indent");
        _builder.append(index, "");
        _builder.append(", ");
      }
    }
    CharSequence _generateDataType = s.generateDataType(codeFragmentCollector, this);
    _builder.append(_generateDataType, "");
    _builder.append("s");
    _builder.append(index, "");
    return _builder;
  }
  
  public int hashCode() {
    Class<? extends Object> _class = this.getClass();
    int _hashCode = _class.hashCode();
    int _hashCode_1 = this.stringSegments.hashCode();
    int _bitwiseXor = (_hashCode ^ _hashCode_1);
    int _xifexpression = (int) 0;
    if (this.plain) {
      _xifexpression = 1;
    } else {
      _xifexpression = 0;
    }
    return (_bitwiseXor ^ _xifexpression);
  }
  
  public boolean equals(final Object obj) {
    if ((obj instanceof StringConstructionFunction)) {
      final StringConstructionFunction other = ((StringConstructionFunction) obj);
      boolean _and = false;
      boolean _equals = (other.plain == this.plain);
      if (!_equals) {
        _and = false;
      } else {
        boolean _equals_1 = Objects.equal(other.stringSegments, this.stringSegments);
        _and = (_equals && _equals_1);
      }
      return _and;
    }
    return false;
  }
  
  private CharSequence generateStringSegment(final IStringSegment s, final int index) {
    if (s instanceof ConstantStringSegment) {
      return _generateStringSegment((ConstantStringSegment)s, index);
    } else if (s instanceof ExpressionStringSegment) {
      return _generateStringSegment((ExpressionStringSegment)s, index);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(s, index).toString());
    }
  }
  
  private CharSequence generateExpressionStringSegment(final MachineDataType type, final int index) {
    if (type instanceof MachineNumericType) {
      return _generateExpressionStringSegment((MachineNumericType)type, index);
    } else if (type instanceof MachineStringType) {
      return _generateExpressionStringSegment((MachineStringType)type, index);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(type, index).toString());
    }
  }
  
  private CharSequence generateFunctionParameter(final ICodeFragmentCollector codeFragmentCollector, final IStringSegment s, final int index) {
    if (s instanceof ConstantStringSegment) {
      return _generateFunctionParameter(codeFragmentCollector, (ConstantStringSegment)s, index);
    } else if (s instanceof ExpressionStringSegment) {
      return _generateFunctionParameter(codeFragmentCollector, (ExpressionStringSegment)s, index);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(codeFragmentCollector, s, index).toString());
    }
  }
}
