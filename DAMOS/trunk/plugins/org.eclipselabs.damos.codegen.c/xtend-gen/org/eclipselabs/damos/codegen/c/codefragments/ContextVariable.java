package org.eclipselabs.damos.codegen.c.codefragments;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipselabs.damos.codegen.c.IGeneratorContext;
import org.eclipselabs.damos.codegen.c.codefragments.PrimaryCodeFragment;
import org.eclipselabs.damos.codegen.c.util.GeneratorConfigurationExtensions;
import org.eclipselabs.damos.dconfig.Configuration;
import org.eclipselabs.damos.mscript.codegen.c.ICodeFragment;
import org.eclipselabs.damos.mscript.codegen.c.ICodeFragment.IDependencyRule;
import org.eclipselabs.damos.mscript.codegen.c.codefragments.ContextStruct;
import org.eclipselabs.damos.mscript.codegen.c.codefragments.factories.IContextStructFactory;

/**
 * @author Andreas Unger
 */
@SuppressWarnings("all")
public class ContextVariable extends PrimaryCodeFragment {
  private final IContextStructFactory contextStructFactory;
  
  private ContextStruct contextStruct;
  
  private String prefix;
  
  public ContextVariable(final IContextStructFactory contextStructFactory) {
    this.contextStructFactory = contextStructFactory;
  }
  
  public void doInitialize(final IGeneratorContext context, final IProgressMonitor monitor) {
    final Function1<ICodeFragment,Boolean> _function = new Function1<ICodeFragment,Boolean>() {
        public Boolean apply(final ICodeFragment it) {
          return (it instanceof ContextStruct);
        }
      };
    this.addDependency(ICodeFragment.FORWARD_DECLARATION_DEPENDS_ON, new IDependencyRule() {
        public boolean applies(ICodeFragment other) {
          return _function.apply(other);
        }
    });
    Configuration _configuration = context.getConfiguration();
    boolean _isSingleton = GeneratorConfigurationExtensions.isSingleton(_configuration);
    ICodeFragment _create = this.contextStructFactory.create(_isSingleton);
    ICodeFragment _addCodeFragment = context.<ICodeFragment>addCodeFragment(_create, monitor);
    this.contextStruct = ((ContextStruct) _addCodeFragment);
    Configuration _configuration_1 = context.getConfiguration();
    String _prefix = GeneratorConfigurationExtensions.getPrefix(_configuration_1);
    this.prefix = _prefix;
  }
  
  public boolean contributesInternalForwardDeclaration() {
    return false;
  }
  
  public CharSequence generateForwardDeclaration(final boolean internal) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("extern ");
    CharSequence _generateImplementation = this.generateImplementation(false);
    _builder.append(_generateImplementation, "");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  public boolean contributesImplementation() {
    return this.contextStruct.contributesInternalForwardDeclaration();
  }
  
  public CharSequence generateImplementation(final boolean internal) {
    StringConcatenation _builder = new StringConcatenation();
    {
      if (internal) {
        _builder.append("static ");
      }
    }
    _builder.append(this.prefix, "");
    _builder.append("Context ");
    _builder.append(this.prefix, "");
    _builder.append("context;");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
}
