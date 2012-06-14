package org.eclipselabs.damos.mscript.codegen.c;

import com.google.common.base.Objects;
import java.util.Collection;
import java.util.TreeSet;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipselabs.damos.mscript.codegen.c.CModule;
import org.eclipselabs.damos.mscript.codegen.c.CModuleEntry;
import org.eclipselabs.damos.mscript.codegen.c.ICModuleGenerator;
import org.eclipselabs.damos.mscript.codegen.c.ICodeFragment;
import org.eclipselabs.damos.mscript.codegen.c.Include;

/**
 * @author Andreas Unger
 */
@SuppressWarnings("all")
public class CHeaderGenerator implements ICModuleGenerator {
  public CharSequence generate(final CModule it) {
    String _name = it.getName();
    String _replaceAll = _name.replaceAll("\\W", "_");
    String _upperCase = _replaceAll.toUpperCase();
    final String headerMacro = (_upperCase + "_H_");
    Collection<Include> _includes = this.getIncludes(it);
    return this.doGenerate(it, headerMacro, _includes);
  }
  
  private CharSequence doGenerate(final CModule it, final String headerMacro, final Collection<Include> includes) {
    StringConcatenation _builder = new StringConcatenation();
    {
      String _headerComment = it.getHeaderComment();
      boolean _notEquals = (!Objects.equal(_headerComment, null));
      if (_notEquals) {
        String _headerComment_1 = it.getHeaderComment();
        _builder.append(_headerComment_1, "");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("#ifndef ");
    _builder.append(headerMacro, "");
    _builder.newLineIfNotEmpty();
    _builder.append("#define ");
    _builder.append(headerMacro, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
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
    _builder.append("#ifdef __cplusplus");
    _builder.newLine();
    _builder.append("extern \"C\" {");
    _builder.newLine();
    _builder.append("#endif /* __cplusplus */");
    _builder.newLine();
    _builder.newLine();
    {
      Collection<CModuleEntry> _entries = it.getEntries();
      final Function1<CModuleEntry,Boolean> _function = new Function1<CModuleEntry,Boolean>() {
          public Boolean apply(final CModuleEntry e) {
            boolean _isInternal = e.isInternal();
            boolean _not = (!_isInternal);
            return Boolean.valueOf(_not);
          }
        };
      Iterable<CModuleEntry> _filter = IterableExtensions.<CModuleEntry>filter(_entries, _function);
      boolean _hasElements_1 = false;
      for(final CModuleEntry entry : _filter) {
        if (!_hasElements_1) {
          _hasElements_1 = true;
        } else {
          _builder.appendImmediate("\n", "");
        }
        ICodeFragment _codeFragment = entry.getCodeFragment();
        CharSequence _generateForwardDeclaration = _codeFragment.generateForwardDeclaration(false);
        _builder.append(_generateForwardDeclaration, "");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.newLine();
    _builder.append("#ifdef __cplusplus");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("#endif /* __cplusplus */");
    _builder.newLine();
    _builder.newLine();
    _builder.append("#endif /* ");
    _builder.append(headerMacro, "");
    _builder.append(" */");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  /**
   * @param module
   * @return
   */
  private Collection<Include> getIncludes(final CModule it) {
    TreeSet<Include> _treeSet = new TreeSet<Include>();
    final Collection<Include> includes = _treeSet;
    Collection<CModuleEntry> _entries = it.getEntries();
    for (final CModuleEntry entry : _entries) {
      boolean _isInternal = entry.isInternal();
      boolean _not = (!_isInternal);
      if (_not) {
        ICodeFragment _codeFragment = entry.getCodeFragment();
        Collection<Include> _forwardDeclarationIncludes = _codeFragment.getForwardDeclarationIncludes();
        for (final Include include : _forwardDeclarationIncludes) {
          includes.add(include);
        }
      }
    }
    return includes;
  }
}
