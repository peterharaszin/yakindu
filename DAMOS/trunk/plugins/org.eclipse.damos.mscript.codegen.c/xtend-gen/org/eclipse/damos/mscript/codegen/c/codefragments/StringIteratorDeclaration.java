package org.eclipse.damos.mscript.codegen.c.codefragments;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.damos.mscript.codegen.c.AbstractCodeFragment;
import org.eclipse.damos.mscript.codegen.c.ICodeFragmentContext;
import org.eclipse.xtend2.lib.StringConcatenation;

/**
 * @author Andreas Unger
 */
@SuppressWarnings("all")
public class StringIteratorDeclaration extends AbstractCodeFragment {
  /**
   * @return the name
   */
  public String getName() {
    return this.getName();
  }
  
  public void initialize(final ICodeFragmentContext context, final IProgressMonitor monitor) {
  }
  
  public CharSequence generateForwardDeclaration(final boolean internal) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("#ifndef DAMOS_STRING_ITERATOR");
    _builder.newLine();
    _builder.append("#define DAMOS_STRING_ITERATOR");
    _builder.newLine();
    _builder.newLine();
    _builder.append("typedef struct Damos_StringIterator_ {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("int state;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("const char *pos;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("const char *stringTablePos;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("const char *indentationStringTablePos;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("int *indentationPos;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("int *indentationEnd;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("int *indentationBuffer;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("int *indentationBufferEnd;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("char previous;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("char (*next)(struct Damos_StringIterator_ *self);");
    _builder.newLine();
    _builder.append("} Damos_StringIterator;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("#endif /* DAMOS_STRING_ITERATOR */");
    _builder.newLine();
    return _builder;
  }
  
  public int hashCode() {
    Class<? extends Object> _class = this.getClass();
    return _class.hashCode();
  }
  
  public boolean equals(final Object obj) {
    if ((obj instanceof StringIteratorDeclaration)) {
      return true;
    }
    return false;
  }
}
