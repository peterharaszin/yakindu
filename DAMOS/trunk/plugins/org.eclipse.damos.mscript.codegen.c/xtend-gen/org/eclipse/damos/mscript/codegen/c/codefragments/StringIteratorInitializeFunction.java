/*******************************************************************************
 * Copyright (c) 2008, 2012 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Andreas Unger - initial API and implementation
 *******************************************************************************/
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
import org.eclipse.damos.mscript.codegen.c.codefragments.StringIteratorInitializeRawFunction;
import org.eclipse.damos.mscript.codegen.c.codefragments.StringTypeDeclaration;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Functions.Function1;

/**
 * @author Andreas Unger
 */
@SuppressWarnings("all")
public class StringIteratorInitializeFunction extends AbstractCodeFragment {
  private final int stringBufferSize;
  
  private String typeName;
  
  private String name;
  
  private String stringIteratorInitializeRawFunctionName;
  
  private CharSequence functionSignature;
  
  public StringIteratorInitializeFunction(final int stringBufferSize) {
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
          return (it instanceof StringIteratorInitializeRawFunction);
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
    StringIteratorInitializeRawFunction _stringIteratorInitializeRawFunction = new StringIteratorInitializeRawFunction(this.stringBufferSize);
    final StringIteratorInitializeRawFunction stringIteratorInitializeRawFunction = codeFragmentCollector.<StringIteratorInitializeRawFunction>addCodeFragment(_stringIteratorInitializeRawFunction, monitor);
    String _name = stringTypeDeclaration.getName();
    this.typeName = _name;
    IGlobalNameProvider _globalNameProvider = context.getGlobalNameProvider();
    String _newGlobalName = _globalNameProvider.newGlobalName("StringIterator_initialize");
    this.name = _newGlobalName;
    String _name_1 = stringIteratorInitializeRawFunction.getName();
    this.stringIteratorInitializeRawFunctionName = _name_1;
    CharSequence _generateFunctionSignature = this.generateFunctionSignature(codeFragmentCollector);
    this.functionSignature = _generateFunctionSignature;
  }
  
  public boolean contributesInternalForwardDeclaration() {
    return false;
  }
  
  public Collection<Include> getForwardDeclarationIncludes() {
    Include _include = new Include("stddef.h");
    return Collections.<Include>singletonList(_include);
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
    _builder.append(this.stringIteratorInitializeRawFunctionName, "	");
    _builder.append("(it, string->data, indentationBuffer, indentationBufferSize);");
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
