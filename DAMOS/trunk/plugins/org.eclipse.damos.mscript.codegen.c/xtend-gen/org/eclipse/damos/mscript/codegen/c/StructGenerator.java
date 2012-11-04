package org.eclipse.damos.mscript.codegen.c;

import org.eclipse.xtend2.lib.StringConcatenation;

/**
 * @author Andreas Unger
 */
@SuppressWarnings("all")
public class StructGenerator {
  public CharSequence generate(final String name, final CharSequence content, final boolean internal) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("typedef struct {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append(content, "	");
    _builder.newLineIfNotEmpty();
    _builder.append("} ");
    _builder.append(name, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  public CharSequence generateMemberAccess(final String name, final boolean pointerReference) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append(name, "");
    {
      if (pointerReference) {
        _builder.append("->");
      } else {
        _builder.append(".");
      }
    }
    return _builder;
  }
}
