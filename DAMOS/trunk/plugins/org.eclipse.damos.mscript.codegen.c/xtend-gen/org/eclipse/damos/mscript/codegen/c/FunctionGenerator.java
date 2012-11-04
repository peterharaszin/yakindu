package org.eclipse.damos.mscript.codegen.c;

import com.google.common.base.Objects;
import org.eclipse.xtend2.lib.StringConcatenation;

/**
 * @author Andreas Unger
 */
@SuppressWarnings("all")
public class FunctionGenerator {
  public CharSequence generateFunctionSignature(final CharSequence returnType, final CharSequence name, final CharSequence parameters, final boolean internal) {
    StringConcatenation _builder = new StringConcatenation();
    {
      if (internal) {
        _builder.append("static ");
      }
    }
    _builder.append(returnType, "");
    _builder.append(" ");
    _builder.append(name, "");
    _builder.append("(");
    {
      boolean _equals = Objects.equal(parameters, null);
      if (_equals) {
        _builder.append("void");
      } else {
        _builder.append(parameters, "");
      }
    }
    _builder.append(")");
    return _builder;
  }
}
