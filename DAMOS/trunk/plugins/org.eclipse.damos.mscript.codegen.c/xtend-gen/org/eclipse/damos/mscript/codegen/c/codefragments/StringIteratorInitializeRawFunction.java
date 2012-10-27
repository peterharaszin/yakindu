package org.eclipse.damos.mscript.codegen.c.codefragments;

import java.util.Collection;
import java.util.Collections;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.damos.mscript.codegen.c.AbstractCodeFragment;
import org.eclipse.damos.mscript.codegen.c.ICodeFragment;
import org.eclipse.damos.mscript.codegen.c.ICodeFragment.IDependencyRule;
import org.eclipse.damos.mscript.codegen.c.ICodeFragmentCollector;
import org.eclipse.damos.mscript.codegen.c.ICodeFragmentContext;
import org.eclipse.damos.mscript.codegen.c.IGlobalNameProvider;
import org.eclipse.damos.mscript.codegen.c.Include;
import org.eclipse.damos.mscript.codegen.c.codefragments.StringIteratorDeclaration;
import org.eclipse.damos.mscript.codegen.c.codefragments.StringIteratorNextFunction;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Functions.Function1;

/**
 * @author Andreas Unger
 */
@SuppressWarnings("all")
public class StringIteratorInitializeRawFunction extends AbstractCodeFragment {
  private final int stringBufferSize;
  
  private String name;
  
  private String stringIteratorNextFunctionName;
  
  private CharSequence functionSignature;
  
  public StringIteratorInitializeRawFunction(final int stringBufferSize) {
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
          return (it instanceof StringIteratorNextFunction);
        }
      };
    this.addDependency(ICodeFragment.IMPLEMENTATION_DEPENDS_ON, new IDependencyRule() {
        public boolean applies(ICodeFragment other) {
          return _function_1.apply(other);
        }
    });
    final ICodeFragmentCollector codeFragmentCollector = context.getCodeFragmentCollector();
    StringIteratorNextFunction _stringIteratorNextFunction = new StringIteratorNextFunction();
    final StringIteratorNextFunction stringIteratorNextFunction = codeFragmentCollector.<StringIteratorNextFunction>addCodeFragment(_stringIteratorNextFunction, monitor);
    IGlobalNameProvider _globalNameProvider = context.getGlobalNameProvider();
    String _newGlobalName = _globalNameProvider.newGlobalName("StringIterator_initializeRaw");
    this.name = _newGlobalName;
    String _name = stringIteratorNextFunction.getName();
    this.stringIteratorNextFunctionName = _name;
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
    {
      if (internal) {
        _builder.append("static ");
      }
    }
    _builder.append(this.functionSignature, "");
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("it->state = 0;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("it->pos = string;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("it->stringTablePos = NULL;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("it->indentationStringTablePos = NULL;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("it->indentationPos = indentationBuffer;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("it->indentationEnd = indentationBuffer;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("it->indentationBuffer = indentationBuffer;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("it->indentationBufferEnd = indentationBuffer != NULL ? indentationBuffer + indentationBufferSize : NULL;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("it->previous = \'\\0\';");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("it->next = ");
    _builder.append(this.stringIteratorNextFunctionName, "	");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  private CharSequence generateFunctionSignature(final ICodeFragmentCollector codeFragmentCollector) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("void ");
    _builder.append(this.name, "");
    _builder.append("(Damos_StringIterator *it, const char *string, int *indentationBuffer, size_t indentationBufferSize)");
    return _builder;
  }
  
  public int hashCode() {
    Class<? extends Object> _class = this.getClass();
    return _class.hashCode();
  }
  
  public boolean equals(final Object obj) {
    if ((obj instanceof StringIteratorInitializeRawFunction)) {
      return true;
    }
    return false;
  }
}
