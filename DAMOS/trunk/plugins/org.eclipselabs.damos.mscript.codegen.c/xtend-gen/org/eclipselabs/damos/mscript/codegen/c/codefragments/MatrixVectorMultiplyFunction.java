package org.eclipselabs.damos.mscript.codegen.c.codefragments;

import com.google.common.base.Objects;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipselabs.damos.mscript.OperatorKind;
import org.eclipselabs.damos.mscript.codegen.c.AbstractCodeFragment;
import org.eclipselabs.damos.mscript.codegen.c.ICodeFragment;
import org.eclipselabs.damos.mscript.codegen.c.ICodeFragment.IDependencyRule;
import org.eclipselabs.damos.mscript.codegen.c.ICodeFragmentCollector;
import org.eclipselabs.damos.mscript.codegen.c.ICodeFragmentContext;
import org.eclipselabs.damos.mscript.codegen.c.IGlobalNameProvider;
import org.eclipselabs.damos.mscript.codegen.c.IMultiplicativeExpressionGenerator;
import org.eclipselabs.damos.mscript.codegen.c.InlineMultiplicativeExpressionGenerator;
import org.eclipselabs.damos.mscript.codegen.c.TextualNumericExpressionOperand;
import org.eclipselabs.damos.mscript.codegen.c.codefragments.ArrayTypeDeclaration;
import org.eclipselabs.damos.mscript.codegen.c.datatype.MachineArrayType;
import org.eclipselabs.damos.mscript.codegen.c.datatype.MachineDataType;
import org.eclipselabs.damos.mscript.codegen.c.datatype.MachineNumericType;
import org.eclipselabs.damos.mscript.computationmodel.NumberFormat;

/**
 * @author Andreas Unger
 */
@SuppressWarnings("all")
public class MatrixVectorMultiplyFunction extends AbstractCodeFragment {
  private final IMultiplicativeExpressionGenerator multiplicativeExpressionGenerator = new Function0<IMultiplicativeExpressionGenerator>() {
    public IMultiplicativeExpressionGenerator apply() {
      InlineMultiplicativeExpressionGenerator _inlineMultiplicativeExpressionGenerator = new InlineMultiplicativeExpressionGenerator();
      return _inlineMultiplicativeExpressionGenerator;
    }
  }.apply();
  
  private final MachineArrayType matrixType;
  
  private final MachineArrayType vectorType;
  
  private final MachineArrayType resultType;
  
  private CharSequence matrixElementTypeText;
  
  private CharSequence vectorElementTypeText;
  
  private CharSequence resultTypeText;
  
  private String name;
  
  private String functionBody;
  
  public MatrixVectorMultiplyFunction(final MachineArrayType matrixType, final MachineArrayType vectorType, final MachineArrayType resultType) {
    this.matrixType = matrixType;
    this.vectorType = vectorType;
    this.resultType = resultType;
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
    MachineDataType _elementType = this.matrixType.getElementType();
    CharSequence _generateDataType = _elementType.generateDataType(codeFragmentCollector, this);
    this.matrixElementTypeText = _generateDataType;
    MachineDataType _elementType_1 = this.vectorType.getElementType();
    CharSequence _generateDataType_1 = _elementType_1.generateDataType(codeFragmentCollector, this);
    this.vectorElementTypeText = _generateDataType_1;
    String _generateDataType_2 = this.resultType.generateDataType(codeFragmentCollector, this);
    this.resultTypeText = _generateDataType_2;
    IGlobalNameProvider _globalNameProvider = context.getGlobalNameProvider();
    String _newGlobalName = _globalNameProvider.newGlobalName("multiply");
    this.name = _newGlobalName;
    MachineNumericType _numericElementType = this.matrixType.getNumericElementType();
    NumberFormat _numberFormat = _numericElementType.getNumberFormat();
    TextualNumericExpressionOperand _textualNumericExpressionOperand = new TextualNumericExpressionOperand("matrix[i][j]", _numberFormat);
    final TextualNumericExpressionOperand leftOperand = _textualNumericExpressionOperand;
    MachineNumericType _numericElementType_1 = this.vectorType.getNumericElementType();
    NumberFormat _numberFormat_1 = _numericElementType_1.getNumberFormat();
    TextualNumericExpressionOperand _textualNumericExpressionOperand_1 = new TextualNumericExpressionOperand("vector[j]", _numberFormat_1);
    final TextualNumericExpressionOperand rightOperand = _textualNumericExpressionOperand_1;
    MachineNumericType _numericElementType_2 = this.resultType.getNumericElementType();
    NumberFormat _numberFormat_2 = _numericElementType_2.getNumberFormat();
    final CharSequence multiplyExpression = this.multiplicativeExpressionGenerator.generate(codeFragmentCollector, OperatorKind.MULTIPLY, _numberFormat_2, leftOperand, rightOperand);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("{");
    _builder.newLine();
    _builder.append("\t");
    _builder.append(this.resultTypeText, "	");
    _builder.append(" result = { 0 };");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("int i, j;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("for (i = 0; i < ");
    int _rowSize = this.matrixType.getRowSize();
    _builder.append(_rowSize, "	");
    _builder.append("; ++i) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("for (j = 0; j < ");
    int _columnSize = this.matrixType.getColumnSize();
    _builder.append(_columnSize, "		");
    _builder.append("; ++j) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t");
    _builder.append("result.data[i] += ");
    _builder.append(multiplyExpression, "			");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
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
    _builder.append(this.matrixElementTypeText, "");
    _builder.append(" matrix[");
    int _rowSize = this.matrixType.getRowSize();
    _builder.append(_rowSize, "");
    _builder.append("][");
    int _columnSize = this.matrixType.getColumnSize();
    _builder.append(_columnSize, "");
    _builder.append("], ");
    _builder.append(this.vectorElementTypeText, "");
    _builder.append(" vector[");
    int _size = this.vectorType.getSize();
    _builder.append(_size, "");
    _builder.append("])");
    return _builder;
  }
  
  public int hashCode() {
    Class<? extends Object> _class = this.getClass();
    int _hashCode = _class.hashCode();
    int _hashCode_1 = this.matrixType.hashCode();
    int _bitwiseXor = (_hashCode ^ _hashCode_1);
    int _hashCode_2 = this.vectorType.hashCode();
    int _bitwiseXor_1 = (_bitwiseXor ^ _hashCode_2);
    int _hashCode_3 = this.resultType.hashCode();
    return (_bitwiseXor_1 ^ _hashCode_3);
  }
  
  public boolean equals(final Object obj) {
    if ((obj instanceof MatrixVectorMultiplyFunction)) {
      final MatrixVectorMultiplyFunction other = ((MatrixVectorMultiplyFunction) obj);
      boolean _and = false;
      boolean _and_1 = false;
      boolean _equals = Objects.equal(other.matrixType, this.matrixType);
      if (!_equals) {
        _and_1 = false;
      } else {
        boolean _equals_1 = Objects.equal(other.vectorType, this.vectorType);
        _and_1 = (_equals && _equals_1);
      }
      if (!_and_1) {
        _and = false;
      } else {
        boolean _equals_2 = Objects.equal(other.resultType, this.resultType);
        _and = (_and_1 && _equals_2);
      }
      return _and;
    }
    return false;
  }
}
