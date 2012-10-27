/*******************************************************************************
 * Copyright (c) 2008, 2012 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Andreas Unger - initial API and implementation
 *******************************************************************************/
package org.eclipse.damos.mscript.codegen.c.codefragments;

import com.google.common.base.Objects;
import java.util.HashSet;
import java.util.List;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.damos.mscript.codegen.c.AbstractCodeFragment;
import org.eclipse.damos.mscript.codegen.c.ICodeFragment;
import org.eclipse.damos.mscript.codegen.c.ICodeFragment.IDependencyRule;
import org.eclipse.damos.mscript.codegen.c.ICodeFragmentCollector;
import org.eclipse.damos.mscript.codegen.c.ICodeFragmentContext;
import org.eclipse.damos.mscript.codegen.c.IGlobalNameProvider;
import org.eclipse.damos.mscript.codegen.c.codefragments.RecordTypeDeclaration;
import org.eclipse.damos.mscript.codegen.c.datatype.MachineCompositeTypeMember;
import org.eclipse.damos.mscript.codegen.c.datatype.MachineDataType;
import org.eclipse.damos.mscript.codegen.c.datatype.MachineRecordType;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ListExtensions;

/**
 * @author Andreas Unger
 */
@SuppressWarnings("all")
public class RecordConstructionFunction extends AbstractCodeFragment {
  private final static String PREFERRED_VARIABLE_NAME = "s";
  
  private final MachineRecordType recordType;
  
  private String typeName;
  
  private String name;
  
  private CharSequence functionSignature;
  
  public RecordConstructionFunction(final MachineRecordType recordType) {
    this.recordType = recordType;
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
    RecordTypeDeclaration _recordTypeDeclaration = new RecordTypeDeclaration(this.recordType);
    final RecordTypeDeclaration recordTypeDeclaration = codeFragmentCollector.<RecordTypeDeclaration>addCodeFragment(_recordTypeDeclaration, monitor);
    String _name = recordTypeDeclaration.getName();
    this.typeName = _name;
    IGlobalNameProvider _globalNameProvider = context.getGlobalNameProvider();
    String _newGlobalName = _globalNameProvider.newGlobalName("newRecord");
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
        List<MachineCompositeTypeMember> _members = this.recordType.getMembers();
        for(final MachineCompositeTypeMember member : _members) {
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
      List<MachineCompositeTypeMember> _members = this.recordType.getMembers();
      boolean _hasElements = false;
      for(final MachineCompositeTypeMember member : _members) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate(", ", "");
        }
        MachineDataType _type = member.getType();
        String _name = member.getName();
        CharSequence _generateDataType = _type.generateDataType(_name, codeFragmentCollector, this);
        _builder.append(_generateDataType, "");
      }
    }
    _builder.append(")");
    return _builder;
  }
  
  private String getVariableName() {
    List<MachineCompositeTypeMember> _members = this.recordType.getMembers();
    final Function1<MachineCompositeTypeMember,String> _function = new Function1<MachineCompositeTypeMember,String>() {
        public String apply(final MachineCompositeTypeMember it) {
          String _name = it.getName();
          return _name;
        }
      };
    List<String> _map = ListExtensions.<MachineCompositeTypeMember, String>map(_members, _function);
    HashSet<String> _hashSet = new HashSet<String>(_map);
    final HashSet<String> names = _hashSet;
    String name = RecordConstructionFunction.PREFERRED_VARIABLE_NAME;
    int i = 2;
    boolean _contains = names.contains(name);
    boolean _while = _contains;
    while (_while) {
      {
        String _plus = (RecordConstructionFunction.PREFERRED_VARIABLE_NAME + Integer.valueOf(i));
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
    int _hashCode_1 = this.recordType.hashCode();
    return (_hashCode ^ _hashCode_1);
  }
  
  public boolean equals(final Object obj) {
    if ((obj instanceof RecordConstructionFunction)) {
      final RecordConstructionFunction other = ((RecordConstructionFunction) obj);
      return Objects.equal(other.recordType, this.recordType);
    }
    return false;
  }
}
