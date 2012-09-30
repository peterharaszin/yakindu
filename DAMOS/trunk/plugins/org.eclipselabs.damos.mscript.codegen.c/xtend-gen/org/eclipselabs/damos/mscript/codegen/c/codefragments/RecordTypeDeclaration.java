package org.eclipselabs.damos.mscript.codegen.c.codefragments;

import com.google.common.base.Objects;
import java.util.List;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipselabs.damos.mscript.codegen.c.AbstractCodeFragment;
import org.eclipselabs.damos.mscript.codegen.c.ICodeFragmentCollector;
import org.eclipselabs.damos.mscript.codegen.c.ICodeFragmentContext;
import org.eclipselabs.damos.mscript.codegen.c.IGlobalNameProvider;
import org.eclipselabs.damos.mscript.codegen.c.datatype.MachineCompositeTypeMember;
import org.eclipselabs.damos.mscript.codegen.c.datatype.MachineDataType;
import org.eclipselabs.damos.mscript.codegen.c.datatype.MachineRecordType;

/**
 * @author Andreas Unger
 */
@SuppressWarnings("all")
public class RecordTypeDeclaration extends AbstractCodeFragment {
  private final MachineRecordType recordType;
  
  private String name;
  
  private CharSequence declaration;
  
  public RecordTypeDeclaration(final MachineRecordType recordType) {
    this.recordType = recordType;
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
    String _newGlobalName = globalNameProvider.newGlobalName("Record");
    this.name = _newGlobalName;
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("typedef struct {");
    _builder.newLine();
    {
      List<MachineCompositeTypeMember> _members = this.recordType.getMembers();
      for(final MachineCompositeTypeMember member : _members) {
        _builder.append("\t");
        MachineDataType _type = member.getType();
        String _name = member.getName();
        CharSequence _generateDataType = _type.generateDataType(_name, codeFragmentCollector, this);
        _builder.append(_generateDataType, "	");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
      }
    }
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
    Class<? extends Object> _class_1 = this.recordType.getClass();
    int _hashCode_1 = _class_1.hashCode();
    return (_hashCode ^ _hashCode_1);
  }
  
  public boolean equals(final Object obj) {
    if ((obj instanceof RecordTypeDeclaration)) {
      final RecordTypeDeclaration other = ((RecordTypeDeclaration) obj);
      return Objects.equal(other.recordType, this.recordType);
    }
    return false;
  }
}
