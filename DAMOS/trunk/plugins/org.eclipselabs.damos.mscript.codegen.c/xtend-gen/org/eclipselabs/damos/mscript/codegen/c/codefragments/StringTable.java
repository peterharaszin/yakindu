package org.eclipselabs.damos.mscript.codegen.c.codefragments;

import com.google.common.base.Objects;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipselabs.damos.mscript.codegen.c.AbstractCodeFragment;
import org.eclipselabs.damos.mscript.codegen.c.ICodeFragmentContext;
import org.eclipselabs.damos.mscript.codegen.c.IGlobalNameProvider;
import org.eclipselabs.damos.mscript.codegen.c.internal.util.StringUtil;

/**
 * @author Andreas Unger
 */
@SuppressWarnings("all")
public class StringTable extends AbstractCodeFragment {
  private final List<String> strings = new Function0<List<String>>() {
    public List<String> apply() {
      ArrayList<String> _arrayList = new ArrayList<String>();
      return _arrayList;
    }
  }.apply();
  
  private String name;
  
  /**
   * @return the name
   */
  public String getName() {
    return this.name;
  }
  
  public int addString(final String newString) {
    final String s = StringUtil.escape(newString);
    int i = 0;
    for (final String string : this.strings) {
      {
        boolean _equals = Objects.equal(string, s);
        if (_equals) {
          return i;
        }
        int _plus = (i + 1);
        i = _plus;
      }
    }
    this.strings.add(s);
    return i;
  }
  
  public void initialize(final ICodeFragmentContext context, final IProgressMonitor monitor) {
    IGlobalNameProvider _globalNameProvider = context.getGlobalNameProvider();
    String _newGlobalName = _globalNameProvider.newGlobalName("StringTable");
    this.name = _newGlobalName;
  }
  
  public boolean contributesInternalForwardDeclaration() {
    return false;
  }
  
  public CharSequence generateForwardDeclaration(final boolean internal) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("extern const char *");
    _builder.append(this.name, "");
    _builder.append("[");
    int _size = this.strings.size();
    _builder.append(_size, "");
    _builder.append("];");
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
    _builder.append("const char *");
    _builder.append(this.name, "");
    _builder.append("[");
    int _size = this.strings.size();
    _builder.append(_size, "");
    _builder.append("] = {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    {
      boolean _hasElements = false;
      for(final String string : this.strings) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate(",\n", "	");
        }
        _builder.append("\"");
        _builder.append(string, "	");
        _builder.append("\"");
      }
    }
    _builder.newLineIfNotEmpty();
    _builder.append("};");
    _builder.newLine();
    return _builder;
  }
  
  public int hashCode() {
    Class<? extends Object> _class = this.getClass();
    return _class.hashCode();
  }
  
  public boolean equals(final Object obj) {
    if ((obj instanceof StringTable)) {
      return true;
    }
    return false;
  }
}
