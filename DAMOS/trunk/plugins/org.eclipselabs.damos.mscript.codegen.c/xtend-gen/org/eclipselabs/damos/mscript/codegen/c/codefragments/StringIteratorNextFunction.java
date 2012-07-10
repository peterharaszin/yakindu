package org.eclipselabs.damos.mscript.codegen.c.codefragments;

import com.google.inject.Inject;
import java.util.Collection;
import java.util.Collections;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipselabs.damos.mscript.codegen.c.AbstractCodeFragment;
import org.eclipselabs.damos.mscript.codegen.c.ICodeFragment;
import org.eclipselabs.damos.mscript.codegen.c.ICodeFragment.IDependencyRule;
import org.eclipselabs.damos.mscript.codegen.c.ICodeFragmentCollector;
import org.eclipselabs.damos.mscript.codegen.c.ICodeFragmentContext;
import org.eclipselabs.damos.mscript.codegen.c.IGlobalNameProvider;
import org.eclipselabs.damos.mscript.codegen.c.Include;
import org.eclipselabs.damos.mscript.codegen.c.codefragments.StringIteratorDeclaration;
import org.eclipselabs.damos.mscript.codegen.c.codefragments.StringTable;

/**
 * @author Andreas Unger
 */
@SuppressWarnings("all")
public class StringIteratorNextFunction extends AbstractCodeFragment {
  private String name;
  
  private String statePrefix;
  
  private String stringTableName;
  
  private CharSequence functionSignature;
  
  @Inject
  public StringIteratorNextFunction() {
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
          return (it instanceof StringIteratorDeclaration);
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
    StringTable _stringTable = new StringTable();
    final StringTable stringTable = codeFragmentCollector.<StringTable>addCodeFragment(_stringTable, monitor);
    IGlobalNameProvider _globalNameProvider = context.getGlobalNameProvider();
    String _newGlobalName = _globalNameProvider.newGlobalName("StringIterator_next");
    this.name = _newGlobalName;
    IGlobalNameProvider _globalNameProvider_1 = context.getGlobalNameProvider();
    String _newGlobalName_1 = _globalNameProvider_1.newGlobalName("StringIteratorState");
    this.statePrefix = _newGlobalName_1;
    String _name = stringTable.getName();
    this.stringTableName = _name;
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
    Include _include = new Include("stdlib.h");
    return Collections.<Include>singletonList(_include);
  }
  
  public CharSequence generateImplementation(final boolean internal) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("enum {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append(this.statePrefix, "	");
    _builder.append("_InString,");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append(this.statePrefix, "	");
    _builder.append("_InString_InIndentation,");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append(this.statePrefix, "	");
    _builder.append("_InString_InIndentationStringTable,");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append(this.statePrefix, "	");
    _builder.append("_InStringTable,");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append(this.statePrefix, "	");
    _builder.append("_InStringTable_InIndentation,");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append(this.statePrefix, "	");
    _builder.append("_InStringTable_InIndentationStringTable");
    _builder.newLineIfNotEmpty();
    _builder.append("};");
    _builder.newLine();
    _builder.newLine();
    {
      if (internal) {
        _builder.append("static ");
      }
    }
    _builder.append(this.functionSignature, "");
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("char c;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("for (;;) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("switch (self->state) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("case ");
    _builder.append(this.statePrefix, "		");
    _builder.append("_InString:");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t");
    _builder.append("c = *self->pos++;");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("if (c == 0x03) {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("if (self->previous == \'\\n\') {");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("c = *self->pos;");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("if (c & 0x80) {");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t");
    _builder.append("int index = c & 0x7f;");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t");
    _builder.append("const char *pos = ");
    _builder.append(this.stringTableName, "						");
    _builder.append("[index];");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t\t\t\t");
    _builder.append("if (*pos == \'\\f\') {");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t");
    _builder.append("++self->pos;");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t");
    _builder.append("self->stringTablePos = pos + 1;");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t\t");
    _builder.append("self->state = ");
    _builder.append(this.statePrefix, "							");
    _builder.append("_InStringTable;");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("continue;");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("if (c & 0x80) {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("int index = c & 0x7f;");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("const char *pos = ");
    _builder.append(this.stringTableName, "				");
    _builder.append("[index];");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t\t");
    _builder.append("if (*pos == 0x02) {");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("if (self->indentationEnd != self->indentationBufferEnd) {");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t");
    _builder.append("*self->indentationEnd++ = index;");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("} else {");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("self->stringTablePos = pos;");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("self->state = ");
    _builder.append(this.statePrefix, "					");
    _builder.append("_InStringTable;");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("continue;");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("if (*self->pos == 0x03) {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("if (self->indentationEnd != self->indentationBuffer) {");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("--self->indentationEnd;");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("if (c == \'\\n\' && self->indentationBuffer != self->indentationEnd) {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("self->indentationPos = self->indentationBuffer;");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("self->state = ");
    _builder.append(this.statePrefix, "				");
    _builder.append("_InString_InIndentation;");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("self->previous = c;");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("break;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("case ");
    _builder.append(this.statePrefix, "		");
    _builder.append("_InString_InIndentation:");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t");
    _builder.append("if (self->indentationPos == self->indentationEnd) {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("self->state = ");
    _builder.append(this.statePrefix, "				");
    _builder.append("_InString;");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t\t");
    _builder.append("continue;");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("self->indentationStringTablePos = ");
    _builder.append(this.stringTableName, "			");
    _builder.append("[*self->indentationPos++] + 1;");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t");
    _builder.append("self->state = ");
    _builder.append(this.statePrefix, "			");
    _builder.append("_InString_InIndentationStringTable;");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t");
    _builder.append("/* Fall through */");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("case ");
    _builder.append(this.statePrefix, "		");
    _builder.append("_InString_InIndentationStringTable:");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t");
    _builder.append("c = *self->indentationStringTablePos;");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("if (c == \'\\0\') {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("self->state = ");
    _builder.append(this.statePrefix, "				");
    _builder.append("_InString_InIndentation;");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t\t");
    _builder.append("continue;");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("++self->indentationStringTablePos;");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("break;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("case ");
    _builder.append(this.statePrefix, "		");
    _builder.append("_InStringTable:");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t");
    _builder.append("c = *self->stringTablePos;");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("if (c == \'\\0\') {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("self->state = ");
    _builder.append(this.statePrefix, "				");
    _builder.append("_InString;");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t\t");
    _builder.append("continue;");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("++self->stringTablePos;");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("if (c == \'\\f\') {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("c = \'\\n\';");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("if (*self->stringTablePos == \'\\0\' && *self->pos == 0x03) {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("if (self->indentationEnd != self->indentationBuffer) {");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("--self->indentationEnd;");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("if (c == \'\\n\' && self->indentationBuffer != self->indentationEnd) {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("self->indentationPos = self->indentationBuffer;");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("self->state = ");
    _builder.append(this.statePrefix, "				");
    _builder.append("_InStringTable_InIndentation;");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("self->previous = c;");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("break;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("case ");
    _builder.append(this.statePrefix, "		");
    _builder.append("_InStringTable_InIndentation:");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t");
    _builder.append("if (self->indentationPos == self->indentationEnd) {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("self->state = ");
    _builder.append(this.statePrefix, "				");
    _builder.append("_InStringTable;");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t\t");
    _builder.append("continue;");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("self->indentationStringTablePos = ");
    _builder.append(this.stringTableName, "			");
    _builder.append("[*self->indentationPos++] + 1;");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t");
    _builder.append("self->state = ");
    _builder.append(this.statePrefix, "			");
    _builder.append("_InStringTable_InIndentationStringTable;");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t");
    _builder.append("/* Fall through */");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("case ");
    _builder.append(this.statePrefix, "		");
    _builder.append("_InStringTable_InIndentationStringTable:");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t");
    _builder.append("c = *self->indentationStringTablePos;");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("if (c == \'\\0\') {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("self->state = ");
    _builder.append(this.statePrefix, "				");
    _builder.append("_InStringTable_InIndentation;");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t\t");
    _builder.append("continue;");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("++self->indentationStringTablePos;");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("break;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("default:");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("c = \'\\0\';");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("break;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return c;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  private CharSequence generateFunctionSignature(final ICodeFragmentCollector codeFragmentCollector) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("char ");
    _builder.append(this.name, "");
    _builder.append("(Damos_StringIterator *self)");
    return _builder;
  }
  
  public int hashCode() {
    Class<? extends Object> _class = this.getClass();
    return _class.hashCode();
  }
  
  public boolean equals(final Object obj) {
    if ((obj instanceof StringIteratorNextFunction)) {
      return true;
    }
    return false;
  }
}
