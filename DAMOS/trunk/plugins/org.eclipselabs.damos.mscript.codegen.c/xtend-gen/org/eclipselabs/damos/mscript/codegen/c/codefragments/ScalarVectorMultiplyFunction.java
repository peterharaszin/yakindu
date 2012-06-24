package org.eclipselabs.damos.mscript.codegen.c.codefragments;

import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipselabs.damos.mscript.ArrayType;
import org.eclipselabs.damos.mscript.DataType;
import org.eclipselabs.damos.mscript.OperatorKind;
import org.eclipselabs.damos.mscript.codegen.c.AbstractCodeFragment;
import org.eclipselabs.damos.mscript.codegen.c.DataTypeGenerator;
import org.eclipselabs.damos.mscript.codegen.c.ICodeFragment;
import org.eclipselabs.damos.mscript.codegen.c.ICodeFragment.IDependencyRule;
import org.eclipselabs.damos.mscript.codegen.c.ICodeFragmentCollector;
import org.eclipselabs.damos.mscript.codegen.c.ICodeFragmentContext;
import org.eclipselabs.damos.mscript.codegen.c.IGlobalNameProvider;
import org.eclipselabs.damos.mscript.codegen.c.IMultiplicativeExpressionGenerator;
import org.eclipselabs.damos.mscript.codegen.c.InlineMultiplicativeExpressionGenerator;
import org.eclipselabs.damos.mscript.codegen.c.NumericExpressionInfo;
import org.eclipselabs.damos.mscript.codegen.c.codefragments.ArrayTypeDeclaration;
import org.eclipselabs.damos.mscript.computationmodel.ComputationModel;
import org.eclipselabs.damos.mscript.computationmodel.NumberFormat;

/**
 * @author Andreas Unger
 */
@SuppressWarnings("all")
public class ScalarVectorMultiplyFunction extends AbstractCodeFragment {
  private final DataTypeGenerator dataTypeGenerator = new Function0<DataTypeGenerator>() {
    public DataTypeGenerator apply() {
      DataTypeGenerator _dataTypeGenerator = new DataTypeGenerator();
      return _dataTypeGenerator;
    }
  }.apply();
  
  private final IMultiplicativeExpressionGenerator multiplicativeExpressionGenerator = new Function0<IMultiplicativeExpressionGenerator>() {
    public IMultiplicativeExpressionGenerator apply() {
      InlineMultiplicativeExpressionGenerator _inlineMultiplicativeExpressionGenerator = new InlineMultiplicativeExpressionGenerator();
      return _inlineMultiplicativeExpressionGenerator;
    }
  }.apply();
  
  private final ComputationModel computationModel;
  
  private final DataType scalarType;
  
  private final DataType elementType;
  
  private final ArrayType resultType;
  
  private CharSequence scalarTypeText;
  
  private CharSequence elementTypeText;
  
  private CharSequence resultTypeText;
  
  private NumberFormat scalarNumberFormat;
  
  private NumberFormat elementNumberFormat;
  
  private NumberFormat resultElementNumberFormat;
  
  private String name;
  
  private String functionBody;
  
  @Inject
  public ScalarVectorMultiplyFunction(@Assisted final ComputationModel computationModel, @Assisted(value = "scalarType") final DataType scalarType, @Assisted(value = "elementType") final DataType elementType, @Assisted final ArrayType resultType) {
    this.computationModel = computationModel;
    this.scalarType = scalarType;
    this.elementType = elementType;
    this.resultType = resultType;
    NumberFormat _numberFormat = computationModel.getNumberFormat(scalarType);
    this.scalarNumberFormat = _numberFormat;
    NumberFormat _numberFormat_1 = computationModel.getNumberFormat(elementType);
    this.elementNumberFormat = _numberFormat_1;
    DataType _elementType = resultType.getElementType();
    NumberFormat _numberFormat_2 = computationModel.getNumberFormat(_elementType);
    this.resultElementNumberFormat = _numberFormat_2;
  }
  
  public String getName() {
    return this.name;
  }
  
  public void initialize(final ICodeFragmentContext context, final IProgressMonitor monitor) {
    final Function1<ICodeFragment,Boolean> _function = new Function1<ICodeFragment,Boolean>() {
        public Boolean apply(final ICodeFragment it) {
          return (it instanceof ArrayTypeDeclaration);
        }
      };
    this.addDependency(ICodeFragment.FORWARD_DECLARATION_DEPENDS_ON, new IDependencyRule() {
        public boolean applies(ICodeFragment other) {
          return _function.apply(other);
        }
    });
    final ICodeFragmentCollector codeFragmentCollector = context.getCodeFragmentCollector();
    CharSequence _generateDataType = this.dataTypeGenerator.generateDataType(this.computationModel, codeFragmentCollector, this.scalarType, this);
    this.scalarTypeText = _generateDataType;
    CharSequence _generateDataType_1 = this.dataTypeGenerator.generateDataType(this.computationModel, codeFragmentCollector, this.elementType, this);
    this.elementTypeText = _generateDataType_1;
    CharSequence _generateDataType_2 = this.dataTypeGenerator.generateDataType(this.computationModel, codeFragmentCollector, this.resultType, this);
    this.resultTypeText = _generateDataType_2;
    IGlobalNameProvider _globalNameProvider = context.getGlobalNameProvider();
    String _newGlobalName = _globalNameProvider.newGlobalName("multiply");
    this.name = _newGlobalName;
    final NumericExpressionInfo leftOperand = NumericExpressionInfo.create(this.scalarNumberFormat, "scalar");
    final NumericExpressionInfo rightOperand = NumericExpressionInfo.create(this.elementNumberFormat, "vector[i]");
    final CharSequence multiplyExpression = this.multiplicativeExpressionGenerator.generate(codeFragmentCollector, OperatorKind.MULTIPLY, this.resultElementNumberFormat, leftOperand, rightOperand);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("{");
    _builder.newLine();
    _builder.append("\t");
    _builder.append(this.resultTypeText, "	");
    _builder.append(" result;");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("int i;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("for (i = 0; i < size; ++i) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("result.data[i] = ");
    _builder.append(multiplyExpression, "		");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("return result;");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.functionBody = _builder.toString();
  }
  
  public CharSequence generateForwardDeclaration(final boolean internal) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _generateFunctionSignature = this.generateFunctionSignature(internal);
    _builder.append(_generateFunctionSignature, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  public boolean contributesImplementation() {
    return true;
  }
  
  public CharSequence generateImplementation(final boolean internal) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _generateFunctionSignature = this.generateFunctionSignature(internal);
    _builder.append(_generateFunctionSignature, "");
    _builder.append(" ");
    _builder.append(this.functionBody, "");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  private CharSequence generateFunctionSignature(final boolean internal) {
    StringConcatenation _builder = new StringConcatenation();
    {
      if (internal) {
        _builder.append("static ");
      }
    }
    _builder.append(this.resultTypeText, "");
    _builder.append(" ");
    _builder.append(this.name, "");
    _builder.append("(");
    _builder.append(this.scalarTypeText, "");
    _builder.append(" scalar, const ");
    _builder.append(this.elementTypeText, "");
    _builder.append(" vector[], int size)");
    return _builder;
  }
  
  public int hashCode() {
    Class<? extends Object> _class = this.getClass();
    int _hashCode = _class.hashCode();
    Class<? extends Object> _class_1 = this.scalarNumberFormat.getClass();
    int _hashCode_1 = _class_1.hashCode();
    int _bitwiseXor = (_hashCode ^ _hashCode_1);
    Class<? extends Object> _class_2 = this.elementNumberFormat.getClass();
    int _hashCode_2 = _class_2.hashCode();
    int _bitwiseXor_1 = (_bitwiseXor ^ _hashCode_2);
    Class<? extends Object> _class_3 = this.resultElementNumberFormat.getClass();
    int _hashCode_3 = _class_3.hashCode();
    return (_bitwiseXor_1 ^ _hashCode_3);
  }
  
  public boolean equals(final Object obj) {
    if ((obj instanceof ScalarVectorMultiplyFunction)) {
      final ScalarVectorMultiplyFunction other = ((ScalarVectorMultiplyFunction) obj);
      boolean _and = false;
      boolean _and_1 = false;
      boolean _isEquivalentTo = other.scalarNumberFormat.isEquivalentTo(this.scalarNumberFormat);
      if (!_isEquivalentTo) {
        _and_1 = false;
      } else {
        boolean _isEquivalentTo_1 = other.elementNumberFormat.isEquivalentTo(this.elementNumberFormat);
        _and_1 = (_isEquivalentTo && _isEquivalentTo_1);
      }
      if (!_and_1) {
        _and = false;
      } else {
        boolean _isEquivalentTo_2 = other.resultElementNumberFormat.isEquivalentTo(this.resultElementNumberFormat);
        _and = (_and_1 && _isEquivalentTo_2);
      }
      return _and;
    }
    return false;
  }
}
