package org.eclipselabs.damos.mscript.codegen.c.codefragments;

import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;
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
import org.eclipselabs.damos.mscript.codegen.c.codefragments.StringIteratorNextFunction;
import org.eclipselabs.damos.mscript.codegen.c.codefragments.StringTypeDeclaration;

/**
 * @author Andreas Unger
 */
@SuppressWarnings("all")
public class StringIteratorInitializeFunction extends AbstractCodeFragment {
  private final int stringBufferSize;
  
  private String typeName;
  
  private String name;
  
  private String stringIteratorNextFunctionName;
  
  private CharSequence functionSignature;
  
  @Inject
  public StringIteratorInitializeFunction(@Assisted final int stringBufferSize) {
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
          if ((it instanceof StringTypeDeclaration)) {
            _or = true;
          } else {
            _or = ((it instanceof StringTypeDeclaration) || (it instanceof StringIteratorDeclaration));
          }
          return _or;
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
    StringTypeDeclaration _stringTypeDeclaration = new StringTypeDeclaration(this.stringBufferSize);
    final StringTypeDeclaration stringTypeDeclaration = codeFragmentCollector.<StringTypeDeclaration>addCodeFragment(_stringTypeDeclaration, monitor);
    StringIteratorNextFunction _stringIteratorNextFunction = new StringIteratorNextFunction();
    final StringIteratorNextFunction stringIteratorNextFunction = codeFragmentCollector.<StringIteratorNextFunction>addCodeFragment(_stringIteratorNextFunction, monitor);
    String _name = stringTypeDeclaration.getName();
    this.typeName = _name;
    IGlobalNameProvider _globalNameProvider = context.getGlobalNameProvider();
    String _newGlobalName = _globalNameProvider.newGlobalName("StringIterator_initialize");
    this.name = _newGlobalName;
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
    _builder.append("it->pos = string->data;");
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
    _builder.append("(Damos_StringIterator *it, const ");
    _builder.append(this.typeName, "");
    _builder.append(" *string, int *indentationBuffer, size_t indentationBufferSize)");
    return _builder;
  }
  
  public int hashCode() {
    Class<? extends Object> _class = this.getClass();
    return _class.hashCode();
  }
  
  public boolean equals(final Object obj) {
    if ((obj instanceof StringIteratorInitializeFunction)) {
      return true;
    }
    return false;
  }
}
