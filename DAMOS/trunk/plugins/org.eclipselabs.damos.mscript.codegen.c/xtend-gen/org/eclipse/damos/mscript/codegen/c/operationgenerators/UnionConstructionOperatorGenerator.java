package org.eclipse.damos.mscript.codegen.c.operationgenerators;

import org.eclipse.damos.mscript.CompositeTypeMember;
import org.eclipse.damos.mscript.Expression;
import org.eclipse.damos.mscript.Type;
import org.eclipse.damos.mscript.TypeSpecifier;
import org.eclipse.damos.mscript.UnionConstructionOperator;
import org.eclipse.damos.mscript.UnionType;
import org.eclipse.damos.mscript.codegen.c.IMscriptGeneratorContext;
import org.eclipse.damos.mscript.codegen.c.IOperationGenerator;
import org.eclipse.damos.mscript.codegen.c.IOperationGeneratorProvider;
import org.eclipse.damos.mscript.codegen.c.OperationGeneratorProvider;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Functions.Function0;

/**
 * @author Andreas Unger
 */
@SuppressWarnings("all")
public class UnionConstructionOperatorGenerator implements IOperationGenerator {
  private final IOperationGeneratorProvider operationGeneratorProvider = new Function0<IOperationGeneratorProvider>() {
    public IOperationGeneratorProvider apply() {
      OperationGeneratorProvider _operationGeneratorProvider = new OperationGeneratorProvider();
      return _operationGeneratorProvider;
    }
  }.apply();
  
  public boolean canHandle(final IMscriptGeneratorContext context, final Type resultDataType, final Expression expression) {
    return (expression instanceof UnionConstructionOperator);
  }
  
  public CharSequence generate(final IMscriptGeneratorContext context, final Type resultDataType, final CharSequence target, final Expression expression) {
    CharSequence _xblockexpression = null;
    {
      final UnionConstructionOperator unionConstructionOperator = ((UnionConstructionOperator) expression);
      final CompositeTypeMember member = unionConstructionOperator.getMember();
      TypeSpecifier _typeSpecifier = unionConstructionOperator.getTypeSpecifier();
      Type _type = _typeSpecifier.getType();
      final UnionType type = ((UnionType) _type);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append(target, "");
      _builder.append(".tag = ");
      EList<CompositeTypeMember> _members = type.getMembers();
      int _indexOf = _members.indexOf(member);
      _builder.append(_indexOf, "");
      _builder.append(";");
      _builder.newLineIfNotEmpty();
      Type _type_1 = member.getType();
      Expression _value = unionConstructionOperator.getValue();
      IOperationGenerator _generator = this.operationGeneratorProvider.getGenerator(context, _type_1, _value);
      Type _type_2 = member.getType();
      String _plus = (target + ".value.");
      String _name = member.getName();
      String _plus_1 = (_plus + _name);
      Expression _value_1 = unionConstructionOperator.getValue();
      CharSequence _generate = _generator.generate(context, _type_2, _plus_1, _value_1);
      _builder.append(_generate, "");
      _builder.newLineIfNotEmpty();
      _xblockexpression = (_builder);
    }
    return _xblockexpression;
  }
}
