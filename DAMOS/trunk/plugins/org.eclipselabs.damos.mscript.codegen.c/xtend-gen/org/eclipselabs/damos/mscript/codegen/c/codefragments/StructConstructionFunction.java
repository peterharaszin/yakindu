package org.eclipselabs.damos.mscript.codegen.c.codefragments;

import com.google.common.base.Objects;
import java.util.HashSet;
import java.util.List;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipselabs.damos.mscript.codegen.c.AbstractCodeFragment;
import org.eclipselabs.damos.mscript.codegen.c.ICodeFragment;
import org.eclipselabs.damos.mscript.codegen.c.ICodeFragment.IDependencyRule;
import org.eclipselabs.damos.mscript.codegen.c.ICodeFragmentCollector;
import org.eclipselabs.damos.mscript.codegen.c.ICodeFragmentContext;
import org.eclipselabs.damos.mscript.codegen.c.IGlobalNameProvider;
import org.eclipselabs.damos.mscript.codegen.c.codefragments.StructTypeDeclaration;
import org.eclipselabs.damos.mscript.codegen.c.datatype.MachineDataType;
import org.eclipselabs.damos.mscript.codegen.c.datatype.MachineStructMember;
import org.eclipselabs.damos.mscript.codegen.c.datatype.MachineStructType;

/**
 * @author Andreas Unger
 */
@SuppressWarnings("all")
public class StructConstructionFunction extends AbstractCodeFragment {
  private final static String PREFERRED_VARIABLE_NAME = "s";
  
  private final MachineStructType structType;
  
  private String typeName;
  
  private String name;
  
  private CharSequence functionSignature;
  
  public StructConstructionFunction(final MachineStructType structType) {
    this.structType = structType;
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
          return (it instanceof StructTypeDeclaration);
        }
      };
    this.addDependency(ICodeFragment.FORWARD_DECLARATION_DEPENDS_ON, new IDependencyRule() {
        public boolean applies(ICodeFragment other) {
          return _function.apply(other);
        }
    });
    final ICodeFragmentCollector codeFragmentCollector = context.getCodeFragmentCollector();
    StructTypeDeclaration _structTypeDeclaration = new StructTypeDeclaration(this.structType);
    final StructTypeDeclaration structTypeDeclaration = codeFragmentCollector.<StructTypeDeclaration>addCodeFragment(_structTypeDeclaration, monitor);
    String _name = structTypeDeclaration.getName();
    this.typeName = _name;
    IGlobalNameProvider _globalNameProvider = context.getGlobalNameProvider();
    String _newGlobalName = _globalNameProvider.newGlobalName("newStruct");
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
    CharSequence _xblockexpression = null;
    {
      String v = this.getVariableName();
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
      _builder.append(v, "	");
      _builder.append(";");
      _builder.newLineIfNotEmpty();
      {
        List<MachineStructMember> _members = this.structType.getMembers();
        for(final MachineStructMember member : _members) {
          _builder.append("\t");
          _builder.append(v, "	");
          _builder.append(".");
          String _name = member.getName();
          _builder.append(_name, "	");
          _builder.append(" = ");
          String _name_1 = member.getName();
          _builder.append(_name_1, "	");
          _builder.append(";");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.append("\t");
      _builder.append("return ");
      _builder.append(v, "	");
      _builder.append(";");
      _builder.newLineIfNotEmpty();
      _builder.append("}");
      _builder.newLine();
      _xblockexpression = (_builder);
    }
    return _xblockexpression;
  }
  
  private CharSequence generateFunctionSignature(final ICodeFragmentCollector codeFragmentCollector) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append(this.typeName, "");
    _builder.append(" ");
    _builder.append(this.name, "");
    _builder.append("(");
    {
      List<MachineStructMember> _members = this.structType.getMembers();
      boolean _hasElements = false;
      for(final MachineStructMember member : _members) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate(", ", "");
        }
        MachineDataType _type = member.getType();
        CharSequence _generateDataType = _type.generateDataType(codeFragmentCollector, this);
        _builder.append(_generateDataType, "");
        _builder.append(" ");
        String _name = member.getName();
        _builder.append(_name, "");
      }
    }
    _builder.append(")");
    return _builder;
  }
  
  private String getVariableName() {
    List<MachineStructMember> _members = this.structType.getMembers();
    final Function1<MachineStructMember,String> _function = new Function1<MachineStructMember,String>() {
        public String apply(final MachineStructMember it) {
          String _name = it.getName();
          return _name;
        }
      };
    List<String> _map = ListExtensions.<MachineStructMember, String>map(_members, _function);
    HashSet<String> _hashSet = new HashSet<String>(_map);
    final HashSet<String> names = _hashSet;
    String name = StructConstructionFunction.PREFERRED_VARIABLE_NAME;
    int i = 2;
    boolean _contains = names.contains(name);
    boolean _while = _contains;
    while (_while) {
      {
        String _plus = (StructConstructionFunction.PREFERRED_VARIABLE_NAME + Integer.valueOf(i));
        name = _plus;
        int _plus_1 = (i + 1);
        i = _plus_1;
      }
      boolean _contains_1 = names.contains(name);
      _while = _contains_1;
    }
    return name;
  }
  
  public int hashCode() {
    Class<? extends Object> _class = this.getClass();
    int _hashCode = _class.hashCode();
    int _hashCode_1 = this.structType.hashCode();
    return (_hashCode ^ _hashCode_1);
  }
  
  public boolean equals(final Object obj) {
    if ((obj instanceof StructConstructionFunction)) {
      final StructConstructionFunction other = ((StructConstructionFunction) obj);
      return Objects.equal(other.structType, this.structType);
    }
    return false;
  }
}
