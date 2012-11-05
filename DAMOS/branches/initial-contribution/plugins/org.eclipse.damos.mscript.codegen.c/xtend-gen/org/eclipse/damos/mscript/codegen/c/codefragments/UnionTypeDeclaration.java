package org.eclipse.damos.mscript.codegen.c.codefragments;

import com.google.common.base.Objects;
import java.util.List;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.damos.mscript.codegen.c.AbstractCodeFragment;
import org.eclipse.damos.mscript.codegen.c.ICodeFragmentCollector;
import org.eclipse.damos.mscript.codegen.c.ICodeFragmentContext;
import org.eclipse.damos.mscript.codegen.c.IGlobalNameProvider;
import org.eclipse.damos.mscript.codegen.c.datatype.MachineCompositeTypeMember;
import org.eclipse.damos.mscript.codegen.c.datatype.MachineDataType;
import org.eclipse.damos.mscript.codegen.c.datatype.MachineUnionType;
import org.eclipse.xtend2.lib.StringConcatenation;

/**
 * @author Andreas Unger
 */
@SuppressWarnings("all")
public class UnionTypeDeclaration extends AbstractCodeFragment {
  private final MachineUnionType unionType;
  
  private String name;
  
  private CharSequence declaration;
  
  public UnionTypeDeclaration(final MachineUnionType unionType) {
    this.unionType = unionType;
  }
  
  /**
   * @return the name
   */
  public String getName() {
    return this.name;
  }
  
  public void initialize(final ICodeFragmentContext context, final IProgressMonitor monitor) {
    final ICodeFragmentCollector codeFragmentCollector = context.getCodeFragmentCollector();
    final IGlobalNameProvider globalNameProvider = context.getGlobalNameProvider();
    String _newGlobalName = globalNameProvider.newGlobalName("Union");
    this.name = _newGlobalName;
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("typedef struct {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("int tag;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("union {");
    _builder.newLine();
    {
      List<MachineCompositeTypeMember> _members = this.unionType.getMembers();
      for(final MachineCompositeTypeMember member : _members) {
        _builder.append("\t\t");
        MachineDataType _type = member.getType();
        String _name = member.getName();
        CharSequence _generateDataType = _type.generateDataType(_name, codeFragmentCollector, this);
        _builder.append(_generateDataType, "		");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t");
    _builder.append("} value;");
    _builder.newLine();
    _builder.append("} ");
    _builder.append(this.name, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    this.declaration = _builder;
  }
  
  public CharSequence generateForwardDeclaration(final boolean internal) {
    return this.declaration;
  }
  
  public int hashCode() {
    Class<? extends Object> _class = this.getClass();
    int _hashCode = _class.hashCode();
    Class<? extends Object> _class_1 = this.unionType.getClass();
    int _hashCode_1 = _class_1.hashCode();
    return (_hashCode ^ _hashCode_1);
  }
  
  public boolean equals(final Object obj) {
    if ((obj instanceof UnionTypeDeclaration)) {
      final UnionTypeDeclaration other = ((UnionTypeDeclaration) obj);
      return Objects.equal(other.unionType, this.unionType);
    }
    return false;
  }
}
