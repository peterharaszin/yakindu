package org.eclipselabs.damos.mscript.codegen.c.codefragments;

import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipselabs.damos.mscript.codegen.c.AbstractCodeFragment;
import org.eclipselabs.damos.mscript.codegen.c.ICodeFragmentCollector;
import org.eclipselabs.damos.mscript.codegen.c.ICodeFragmentContext;
import org.eclipselabs.damos.mscript.codegen.c.IGlobalNameProvider;
import org.eclipselabs.damos.mscript.codegen.c.codefragments.StringIteratorDeclaration;
import org.eclipselabs.damos.mscript.codegen.c.codefragments.StringIteratorInitializeFunction;
import org.eclipselabs.damos.mscript.codegen.c.codefragments.StringIteratorNextFunction;

/**
 * @author Andreas Unger
 */
@SuppressWarnings("all")
public class StringTypeDeclaration extends AbstractCodeFragment {
  private final int stringBufferSize;
  
  private String name;
  
  @Inject
  public StringTypeDeclaration(@Assisted final int stringBufferSize) {
    this.stringBufferSize = stringBufferSize;
  }
  
  /**
   * @return the name
   */
  public String getName() {
    return this.name;
  }
  
  public void initialize(final ICodeFragmentContext context, final IProgressMonitor monitor) {
    IGlobalNameProvider _globalNameProvider = context.getGlobalNameProvider();
    String _newGlobalName = _globalNameProvider.newGlobalName("String");
    this.name = _newGlobalName;
  }
  
  public void postProcess(final ICodeFragmentContext context, final IProgressMonitor monitor) {
    final ICodeFragmentCollector codeFragmentCollector = context.getCodeFragmentCollector();
    StringIteratorDeclaration _stringIteratorDeclaration = new StringIteratorDeclaration();
    codeFragmentCollector.<StringIteratorDeclaration>addCodeFragment(_stringIteratorDeclaration, monitor);
    StringIteratorNextFunction _stringIteratorNextFunction = new StringIteratorNextFunction();
    codeFragmentCollector.<StringIteratorNextFunction>addCodeFragment(_stringIteratorNextFunction, monitor);
    StringIteratorInitializeFunction _stringIteratorInitializeFunction = new StringIteratorInitializeFunction(this.stringBufferSize);
    codeFragmentCollector.<StringIteratorInitializeFunction>addCodeFragment(_stringIteratorInitializeFunction, monitor);
  }
  
  public CharSequence generateForwardDeclaration(final boolean internal) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("typedef struct { char data[");
    _builder.append(this.stringBufferSize, "");
    _builder.append("]; } ");
    _builder.append(this.name, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  public int hashCode() {
    Class<? extends Object> _class = this.getClass();
    return _class.hashCode();
  }
  
  public boolean equals(final Object obj) {
    if ((obj instanceof StringTypeDeclaration)) {
      return true;
    }
    return false;
  }
}
