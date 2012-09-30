package org.eclipselabs.damos.mscript.codegen.c.codefragments;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipselabs.damos.mscript.FunctionDeclaration;
import org.eclipselabs.damos.mscript.codegen.c.AbstractCodeFragment;
import org.eclipselabs.damos.mscript.codegen.c.ICodeFragment;
import org.eclipselabs.damos.mscript.codegen.c.ICodeFragment.IDependencyRule;
import org.eclipselabs.damos.mscript.codegen.c.ICodeFragmentContext;
import org.eclipselabs.damos.mscript.codegen.c.IGlobalNameProvider;
import org.eclipselabs.damos.mscript.codegen.c.Include;
import org.eclipselabs.damos.mscript.codegen.c.codefragments.IContextStructMember;
import org.eclipselabs.damos.mscript.codegen.c.codefragments.UnionTypeDeclaration;
import org.eclipselabs.damos.mscript.function.FunctionDescription;
import org.eclipselabs.damos.mscript.interpreter.StaticFunctionInfo;

/**
 * @author Andreas Unger
 */
@SuppressWarnings("all")
public class ContextStruct extends AbstractCodeFragment {
  private final Collection<IContextStructMember> members = new Function0<Collection<IContextStructMember>>() {
    public Collection<IContextStructMember> apply() {
      ArrayList<IContextStructMember> _arrayList = new ArrayList<IContextStructMember>();
      return _arrayList;
    }
  }.apply();
  
  private final Collection<Include> forwardDeclarationIncludes = new Function0<Collection<Include>>() {
    public Collection<Include> apply() {
      ArrayList<Include> _arrayList = new ArrayList<Include>();
      return _arrayList;
    }
  }.apply();
  
  private final StaticFunctionInfo functionInfo;
  
  private final boolean singleton;
  
  private final List<CharSequence> initializeCalls = new Function0<List<CharSequence>>() {
    public List<CharSequence> apply() {
      ArrayList<CharSequence> _arrayList = new ArrayList<CharSequence>();
      return _arrayList;
    }
  }.apply();
  
  private final List<CharSequence> updateCalls = new Function0<List<CharSequence>>() {
    public List<CharSequence> apply() {
      ArrayList<CharSequence> _arrayList = new ArrayList<CharSequence>();
      return _arrayList;
    }
  }.apply();
  
  private IGlobalNameProvider globalNameProvider;
  
  private String name;
  
  public ContextStruct(final boolean singleton) {
    this.functionInfo = null;
    this.singleton = singleton;
  }
  
  public ContextStruct(final StaticFunctionInfo functionInfo, final boolean singleton) {
    this.functionInfo = functionInfo;
    this.singleton = singleton;
  }
  
  public ContextStruct(final StaticFunctionInfo functionInfo, final String name, final boolean singleton) {
    this.functionInfo = functionInfo;
    this.singleton = singleton;
    this.name = name;
  }
  
  public void addInitializeCall(final CharSequence initializeCall) {
    this.initializeCalls.add(initializeCall);
  }
  
  public Collection<CharSequence> getInitializeCalls() {
    return this.initializeCalls;
  }
  
  public void addUpdateCall(final CharSequence updateCall) {
    this.updateCalls.add(updateCall);
  }
  
  public Collection<CharSequence> getUpdateCalls() {
    return this.updateCalls;
  }
  
  public String getName() {
    return this.name;
  }
  
  public void initialize(final ICodeFragmentContext context, final IProgressMonitor monitor) {
    final Function1<ICodeFragment,Boolean> _function = new Function1<ICodeFragment,Boolean>() {
        public Boolean apply(final ICodeFragment it) {
          return (it instanceof UnionTypeDeclaration);
        }
      };
    this.addDependency(ICodeFragment.FORWARD_DECLARATION_DEPENDS_ON, new IDependencyRule() {
        public boolean applies(ICodeFragment other) {
          return _function.apply(other);
        }
    });
    IGlobalNameProvider _globalNameProvider = context.getGlobalNameProvider();
    this.globalNameProvider = _globalNameProvider;
    boolean _equals = Objects.equal(this.name, null);
    if (_equals) {
      String _xifexpression = null;
      boolean _notEquals = (!Objects.equal(this.functionInfo, null));
      if (_notEquals) {
        FunctionDescription _functionDescription = this.functionInfo.getFunctionDescription();
        FunctionDeclaration _declaration = _functionDescription.getDeclaration();
        String _name = _declaration.getName();
        String _plus = (_name + "_Context");
        _xifexpression = _plus;
      } else {
        _xifexpression = "Context";
      }
      final String preferredName = _xifexpression;
      String _newGlobalName = this.globalNameProvider.newGlobalName(preferredName);
      this.name = _newGlobalName;
    }
  }
  
  public boolean contributesInternalForwardDeclaration() {
    boolean _or = false;
    boolean _not = (!this.singleton);
    if (_not) {
      _or = true;
    } else {
      boolean _isEmpty = this.members.isEmpty();
      boolean _not_1 = (!_isEmpty);
      _or = (_not || _not_1);
    }
    return _or;
  }
  
  public Collection<Include> getForwardDeclarationIncludes() {
    return this.forwardDeclarationIncludes;
  }
  
  public CharSequence generateForwardDeclaration(final boolean internal) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("typedef struct {");
    _builder.newLine();
    {
      boolean _isEmpty = this.members.isEmpty();
      if (_isEmpty) {
        _builder.append("\t");
        _builder.append("char dummy;");
        _builder.newLine();
      } else {
        {
          for(final IContextStructMember part : this.members) {
            _builder.append("\t");
            CharSequence _generate = part.generate();
            _builder.append(_generate, "	");
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    _builder.append("} ");
    _builder.append(this.name, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  public String newUniqueName(final String preferredName) {
    String _newGlobalName = this.globalNameProvider.newGlobalName(preferredName);
    return _newGlobalName;
  }
  
  public boolean addMember(final IContextStructMember member) {
    boolean _xblockexpression = false;
    {
      Collection<ICodeFragment> _declarationCodeFragments = member.getDeclarationCodeFragments();
      for (final ICodeFragment declarationCodeFragment : _declarationCodeFragments) {
        final Function1<ICodeFragment,Boolean> _function = new Function1<ICodeFragment,Boolean>() {
            public Boolean apply(final ICodeFragment it) {
              boolean _equals = Objects.equal(it, declarationCodeFragment);
              return _equals;
            }
          };
        this.addDependency(ICodeFragment.FORWARD_DECLARATION_DEPENDS_ON, new IDependencyRule() {
            public boolean applies(ICodeFragment other) {
              return _function.apply(other);
            }
        });
      }
      Collection<Include> _forwardDeclarationIncludes = member.getForwardDeclarationIncludes();
      Iterables.<Include>addAll(this.forwardDeclarationIncludes, _forwardDeclarationIncludes);
      boolean _add = this.members.add(member);
      _xblockexpression = (_add);
    }
    return _xblockexpression;
  }
  
  public int hashCode() {
    int _xblockexpression = (int) 0;
    {
      Class<? extends Object> _class = this.getClass();
      int hashCode = _class.hashCode();
      boolean _notEquals = (!Objects.equal(this.functionInfo, null));
      if (_notEquals) {
        int _hashCode = this.functionInfo.hashCode();
        int _bitwiseXor = (hashCode ^ _hashCode);
        hashCode = _bitwiseXor;
      }
      _xblockexpression = (hashCode);
    }
    return _xblockexpression;
  }
  
  public boolean equals(final Object obj) {
    if ((obj instanceof ContextStruct)) {
      final ContextStruct other = ((ContextStruct) obj);
      return Objects.equal(other.functionInfo, this.functionInfo);
    }
    return false;
  }
}
