package org.eclipselabs.damos.mscript.codegen.c.codefragments;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IntegerRange;
import org.eclipselabs.damos.mscript.codegen.c.AbstractCodeFragment;
import org.eclipselabs.damos.mscript.codegen.c.ICodeFragment;
import org.eclipselabs.damos.mscript.codegen.c.ICodeFragment.IDependencyRule;
import org.eclipselabs.damos.mscript.codegen.c.ICodeFragmentCollector;
import org.eclipselabs.damos.mscript.codegen.c.ICodeFragmentContext;
import org.eclipselabs.damos.mscript.codegen.c.IGlobalNameProvider;
import org.eclipselabs.damos.mscript.codegen.c.codefragments.ArrayTypeDeclaration;
import org.eclipselabs.damos.mscript.codegen.c.datatype.MachineArrayType;
import org.eclipselabs.damos.mscript.codegen.c.datatype.MachineDataType;
import org.eclipselabs.damos.mscript.computationmodel.ComputationModel;

/**
 * @author Andreas Unger
 */
@SuppressWarnings("all")
public class ArrayConstructionFunction extends AbstractCodeFragment {
  private final MachineArrayType arrayType;
  
  private final ComputationModel computationModel;
  
  private String typeName;
  
  private String name;
  
  private String functionSignature;
  
  @Inject
  public ArrayConstructionFunction(@Assisted final ComputationModel computationModel, @Assisted final MachineArrayType arrayType) {
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
    ArrayTypeDeclaration _arrayTypeDeclaration = new ArrayTypeDeclaration(this.computationModel, this.arrayType);
    final ArrayTypeDeclaration arrayTypeDeclaration = codeFragmentCollector.<ArrayTypeDeclaration>addCodeFragment(_arrayTypeDeclaration, monitor);
    String _name = arrayTypeDeclaration.getName();
    this.typeName = _name;
    IGlobalNameProvider _globalNameProvider = context.getGlobalNameProvider();
    String _newGlobalName = _globalNameProvider.newGlobalName("newArray");
    this.name = _newGlobalName;
    String _generateFunctionSignature = this.generateFunctionSignature(codeFragmentCollector);
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
    _builder.append(" a;");
    _builder.newLineIfNotEmpty();
    {
      int _dimension = this.arrayType.getDimension(0);
      int _minus = (_dimension - 1);
      IntegerRange _upTo = new IntegerRange(0, _minus);
      for(final Integer i : _upTo) {
        _builder.append("\t");
        _builder.append("a.data[");
        _builder.append(i, "	");
        _builder.append("] = e");
        _builder.append(i, "	");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t");
    _builder.append("return a;");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  private String generateFunctionSignature(final ICodeFragmentCollector codeFragmentCollector) {
    String _xblockexpression = null;
    {
      int _dimension = this.arrayType.getDimension(0);
      int _minus = (_dimension - 1);
      final IntegerRange indices = new IntegerRange(0, _minus);
      MachineDataType _elementType = this.arrayType.getElementType();
      final CharSequence dataType = _elementType.generateDataType(this.computationModel, codeFragmentCollector, this);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append(this.typeName, "");
      _builder.append(" ");
      _builder.append(this.name, "");
      _builder.append("(");
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
          _builder.append(i, "");
        }
      }
      _builder.append(")");
      _xblockexpression = (_builder.toString());
    }
    return _xblockexpression;
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
      return Objects.equal(other, this.arrayType);
    }
    return false;
  }
}
