package org.eclipse.damos.mscript.codegen.c.codefragments;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.damos.mscript.codegen.c.AbstractCodeFragment;
import org.eclipse.damos.mscript.codegen.c.ICodeFragment;
import org.eclipse.damos.mscript.codegen.c.ICodeFragment.IDependencyRule;
import org.eclipse.damos.mscript.codegen.c.ICodeFragmentCollector;
import org.eclipse.damos.mscript.codegen.c.ICodeFragmentContext;
import org.eclipse.damos.mscript.codegen.c.IGlobalNameProvider;
import org.eclipse.damos.mscript.codegen.c.codefragments.StringIteratorInitializeRawFunction;
import org.eclipse.damos.mscript.codegen.c.codefragments.StringIteratorNextFunction;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Functions.Function1;

/**
 * @author Andreas Unger
 */
@SuppressWarnings("all")
public class StringEqualToFunction extends AbstractCodeFragment {
  private final int stringBufferSize;
  
  private String name;
  
  private String stringIteratorInitializeRawFunctionName;
  
  private String stringIteratorNextFunctionName;
  
  private CharSequence functionSignature;
  
  public StringEqualToFunction(final int stringBufferSize) {
    this.stringBufferSize = stringBufferSize;
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
          boolean _or = false;
          if ((it instanceof StringIteratorInitializeRawFunction)) {
            _or = true;
          } else {
            _or = ((it instanceof StringIteratorInitializeRawFunction) || (it instanceof StringIteratorNextFunction));
          }
          return _or;
        }
      };
    this.addDependency(ICodeFragment.IMPLEMENTATION_DEPENDS_ON, new IDependencyRule() {
        public boolean applies(ICodeFragment other) {
          return _function.apply(other);
        }
    });
    final ICodeFragmentCollector codeFragmentCollector = context.getCodeFragmentCollector();
    StringIteratorInitializeRawFunction _stringIteratorInitializeRawFunction = new StringIteratorInitializeRawFunction(this.stringBufferSize);
    final StringIteratorInitializeRawFunction stringIteratorInitializeRawFunction = codeFragmentCollector.<StringIteratorInitializeRawFunction>addCodeFragment(_stringIteratorInitializeRawFunction, monitor);
    StringIteratorNextFunction _stringIteratorNextFunction = new StringIteratorNextFunction();
    final StringIteratorNextFunction stringIteratorNextFunction = codeFragmentCollector.<StringIteratorNextFunction>addCodeFragment(_stringIteratorNextFunction, monitor);
    IGlobalNameProvider _globalNameProvider = context.getGlobalNameProvider();
    String _newGlobalName = _globalNameProvider.newGlobalName("StringEqualTo");
    this.name = _newGlobalName;
    String _name = stringIteratorInitializeRawFunction.getName();
    this.stringIteratorInitializeRawFunctionName = _name;
    String _name_1 = stringIteratorNextFunction.getName();
    this.stringIteratorNextFunctionName = _name_1;
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
    _builder.append("Damos_StringIterator it1;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("Damos_StringIterator it2;");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("int indentationBuffer1[");
    _builder.append(this.stringBufferSize, "	");
    _builder.append("];");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("int indentationBuffer2[");
    _builder.append(this.stringBufferSize, "	");
    _builder.append("];");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append(this.stringIteratorInitializeRawFunctionName, "	");
    _builder.append("(&it1, string1, indentationBuffer1, ");
    _builder.append(this.stringBufferSize, "	");
    _builder.append(");");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append(this.stringIteratorInitializeRawFunctionName, "	");
    _builder.append("(&it2, string2, indentationBuffer2, ");
    _builder.append(this.stringBufferSize, "	");
    _builder.append(");");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("char c1;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("char c2;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("do {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("c1 = ");
    _builder.append(this.stringIteratorNextFunctionName, "		");
    _builder.append("(&it1);");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("c2 = ");
    _builder.append(this.stringIteratorNextFunctionName, "		");
    _builder.append("(&it2);");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("if (c1 != c2) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("return 0;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("} while (c1 != \'\\0\');");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("return 1;");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  private CharSequence generateFunctionSignature(final ICodeFragmentCollector codeFragmentCollector) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("uint_fast8_t ");
    _builder.append(this.name, "");
    _builder.append("(const char *string1, const char *string2)");
    return _builder;
  }
  
  public int hashCode() {
    Class<? extends Object> _class = this.getClass();
    return _class.hashCode();
  }
  
  public boolean equals(final Object obj) {
    if ((obj instanceof StringEqualToFunction)) {
      return true;
    }
    return false;
  }
}
