package org.eclipselabs.damos.codegen.c.codefragments;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipselabs.damos.codegen.c.IGeneratorContext;
import org.eclipselabs.damos.codegen.c.codefragments.PrimaryCodeFragment;

@SuppressWarnings("all")
public class ComponentContextDeclarations extends PrimaryCodeFragment {
  private final CharSequence content;
  
  public ComponentContextDeclarations(final CharSequence content) {
    this.content = content;
  }
  
  protected void doInitialize(final IGeneratorContext context, final IProgressMonitor monitor) {
  }
  
  public CharSequence generateForwardDeclaration(final boolean internal) {
    return this.content;
  }
}
