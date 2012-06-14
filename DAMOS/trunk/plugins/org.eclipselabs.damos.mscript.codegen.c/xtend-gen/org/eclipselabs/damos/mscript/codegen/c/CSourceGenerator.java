package org.eclipselabs.damos.mscript.codegen.c;

import com.google.common.base.Objects;
import java.util.Collection;
import java.util.Set;
import java.util.TreeSet;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipselabs.damos.mscript.codegen.c.CModule;
import org.eclipselabs.damos.mscript.codegen.c.CModuleEntry;
import org.eclipselabs.damos.mscript.codegen.c.CModuleSet;
import org.eclipselabs.damos.mscript.codegen.c.ICModuleGenerator;
import org.eclipselabs.damos.mscript.codegen.c.ICodeFragment;
import org.eclipselabs.damos.mscript.codegen.c.Include;

/**
 * @author Andreas Unger
 */
@SuppressWarnings("all")
public class CSourceGenerator implements ICModuleGenerator {
  public CharSequence generate(final CModule it) {
    Collection<Include> _includes = this.getIncludes(it);
    return this.doGenerate(it, _includes);
  }
  
  private CharSequence doGenerate(final CModule it, final Collection<Include> includes) {
    StringConcatenation _builder = new StringConcatenation();
    {
      String _sourceComment = it.getSourceComment();
      boolean _notEquals = (!Objects.equal(_sourceComment, null));
      if (_notEquals) {
        String _sourceComment_1 = it.getSourceComment();
        _builder.append(_sourceComment_1, "");
        _builder.newLineIfNotEmpty();
      }
    }
    {
      boolean _hasElements = false;
      for(final Include include : includes) {
        if (!_hasElements) {
          _hasElements = true;
        }
        _builder.append(include, "");
        _builder.newLineIfNotEmpty();
      }
      if (_hasElements) {
        _builder.append("\n", "");
      }
    }
    _builder.append("#include \"");
    String _name = it.getName();
    _builder.append(_name, "");
    _builder.append(".h\"");
    _builder.newLineIfNotEmpty();
    {
      CModuleSet _moduleSet = it.getModuleSet();
      Collection<CModule> _modules = _moduleSet.getModules();
      final Function1<CModule,Boolean> _function = new Function1<CModule,Boolean>() {
          public Boolean apply(final CModule e) {
            boolean _and = false;
            boolean _notEquals = (!Objects.equal(e, it));
            if (!_notEquals) {
              _and = false;
            } else {
              boolean _dependsOn = it.dependsOn(e);
              _and = (_notEquals && _dependsOn);
            }
            return Boolean.valueOf(_and);
          }
        };
      Iterable<CModule> _filter = IterableExtensions.<CModule>filter(_modules, _function);
      boolean _hasElements_1 = false;
      for(final CModule otherModule : _filter) {
        if (!_hasElements_1) {
          _hasElements_1 = true;
        }
        _builder.append("#include \"");
        String _name_1 = otherModule.getName();
        _builder.append(_name_1, "");
        _builder.append(".h\"");
        _builder.newLineIfNotEmpty();
      }
      if (_hasElements_1) {
        _builder.append("\n", "");
      }
    }
    _builder.newLine();
    CharSequence _generateInternalForwardDeclarations = this.generateInternalForwardDeclarations(it);
    _builder.append(_generateInternalForwardDeclarations, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    CharSequence _generateImplementations = this.generateImplementations(it, false);
    _builder.append(_generateImplementations, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    CharSequence _generateImplementations_1 = this.generateImplementations(it, true);
    _builder.append(_generateImplementations_1, "");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  private CharSequence generateInternalForwardDeclarations(final CModule it) {
    StringConcatenation _builder = new StringConcatenation();
    {
      Collection<CModuleEntry> _entries = it.getEntries();
      final Function1<CModuleEntry,Boolean> _function = new Function1<CModuleEntry,Boolean>() {
          public Boolean apply(final CModuleEntry e) {
            boolean _and = false;
            boolean _isInternal = e.isInternal();
            if (!_isInternal) {
              _and = false;
            } else {
              ICodeFragment _codeFragment = e.getCodeFragment();
              boolean _contributesInternalForwardDeclaration = _codeFragment.contributesInternalForwardDeclaration();
              _and = (_isInternal && _contributesInternalForwardDeclaration);
            }
            return Boolean.valueOf(_and);
          }
        };
      Iterable<CModuleEntry> _filter = IterableExtensions.<CModuleEntry>filter(_entries, _function);
      boolean _hasElements = false;
      for(final CModuleEntry entry : _filter) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate("\n", "");
        }
        ICodeFragment _codeFragment = entry.getCodeFragment();
        CharSequence _generateForwardDeclaration = _codeFragment.generateForwardDeclaration(true);
        _builder.append(_generateForwardDeclaration, "");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }
  
  private CharSequence generateImplementations(final CModule it, final boolean contributesInternalForwardDeclaration) {
    StringConcatenation _builder = new StringConcatenation();
    {
      Collection<CModuleEntry> _entries = it.getEntries();
      final Function1<CModuleEntry,Boolean> _function = new Function1<CModuleEntry,Boolean>() {
          public Boolean apply(final CModuleEntry e) {
            boolean _and = false;
            ICodeFragment _codeFragment = e.getCodeFragment();
            boolean _contributesImplementation = _codeFragment.contributesImplementation();
            if (!_contributesImplementation) {
              _and = false;
            } else {
              ICodeFragment _codeFragment_1 = e.getCodeFragment();
              boolean _contributesInternalForwardDeclaration = _codeFragment_1.contributesInternalForwardDeclaration();
              boolean _equals = (_contributesInternalForwardDeclaration == contributesInternalForwardDeclaration);
              _and = (_contributesImplementation && _equals);
            }
            return Boolean.valueOf(_and);
          }
        };
      Iterable<CModuleEntry> _filter = IterableExtensions.<CModuleEntry>filter(_entries, _function);
      boolean _hasElements = false;
      for(final CModuleEntry entry : _filter) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate("\n", "");
        }
        ICodeFragment _codeFragment = entry.getCodeFragment();
        boolean _isInternal = entry.isInternal();
        CharSequence _generateImplementation = _codeFragment.generateImplementation(_isInternal);
        _builder.append(_generateImplementation, "");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }
  
  /**
   * @param module
   * @return
   */
  private Collection<Include> getIncludes(final CModule it) {
    TreeSet<Include> _treeSet = new TreeSet<Include>();
    final Set<Include> includes = _treeSet;
    Collection<CModuleEntry> _entries = it.getEntries();
    for (final CModuleEntry entry : _entries) {
      {
        final ICodeFragment codeFragment = entry.getCodeFragment();
        boolean _and = false;
        boolean _isInternal = entry.isInternal();
        if (!_isInternal) {
          _and = false;
        } else {
          boolean _contributesInternalForwardDeclaration = codeFragment.contributesInternalForwardDeclaration();
          _and = (_isInternal && _contributesInternalForwardDeclaration);
        }
        if (_and) {
          Collection<Include> _forwardDeclarationIncludes = codeFragment.getForwardDeclarationIncludes();
          for (final Include include : _forwardDeclarationIncludes) {
            includes.add(include);
          }
        }
      }
    }
    Collection<CModuleEntry> _entries_1 = it.getEntries();
    for (final CModuleEntry entry_1 : _entries_1) {
      ICodeFragment _codeFragment = entry_1.getCodeFragment();
      Collection<Include> _implementationIncludes = _codeFragment.getImplementationIncludes();
      for (final Include include : _implementationIncludes) {
        includes.add(include);
      }
    }
    return includes;
  }
}
