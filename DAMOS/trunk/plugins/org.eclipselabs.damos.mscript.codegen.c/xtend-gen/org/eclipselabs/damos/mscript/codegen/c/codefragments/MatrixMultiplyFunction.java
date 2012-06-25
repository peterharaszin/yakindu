package org.eclipselabs.damos.mscript.codegen.c.codefragments;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;
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
import org.eclipselabs.damos.mscript.codegen.c.NumericExpressionInfo;
import org.eclipselabs.damos.mscript.codegen.c.codefragments.ArrayTypeDeclaration;
import org.eclipselabs.damos.mscript.codegen.c.datatype.MachineArrayType;
import org.eclipselabs.damos.mscript.codegen.c.datatype.MachineDataType;
import org.eclipselabs.damos.mscript.codegen.c.datatype.MachineNumericType;
import org.eclipselabs.damos.mscript.computationmodel.ComputationModel;
import org.eclipselabs.damos.mscript.computationmodel.NumberFormat;

/**
 * @author Andreas Unger
 */
@SuppressWarnings("all")
public class MatrixMultiplyFunction extends AbstractCodeFragment {
  private final IMultiplicativeExpressionGenerator multiplicativeExpressionGenerator = new Function0<IMultiplicativeExpressionGenerator>() {
    public IMultiplicativeExpressionGenerator apply() {
      InlineMultiplicativeExpressionGenerator _inlineMultiplicativeExpressionGenerator = new InlineMultiplicativeExpressionGenerator();
      return _inlineMultiplicativeExpressionGenerator;
    }
  }.apply();
  
  private final ComputationModel computationModel;
  
  private final MachineArrayType leftMatrixType;
  
  private final MachineArrayType rightMatrixType;
  
  private final MachineArrayType resultType;
  
  private CharSequence leftMatrixElementTypeText;
  
  private CharSequence rightMatrixElementTypeText;
  
  private CharSequence resultTypeText;
  
  private String name;
  
  private String functionBody;
  
  @Inject
  public MatrixMultiplyFunction(@Assisted final ComputationModel computationModel, @Assisted final MachineArrayType leftMatrixType, @Assisted final MachineArrayType rightMatrixType, @Assisted final MachineArrayType resultType) {
    this.computationModel = computationModel;
    this.leftMatrixType = leftMatrixType;
    this.rightMatrixType = rightMatrixType;
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
    MachineDataType _elementType = this.leftMatrixType.getElementType();
    CharSequence _generateDataType = _elementType.generateDataType(this.computationModel, codeFragmentCollector, this);
    this.leftMatrixElementTypeText = _generateDataType;
    MachineDataType _elementType_1 = this.rightMatrixType.getElementType();
    CharSequence _generateDataType_1 = _elementType_1.generateDataType(this.computationModel, codeFragmentCollector, this);
    this.rightMatrixElementTypeText = _generateDataType_1;
    String _generateDataType_2 = this.resultType.generateDataType(this.computationModel, codeFragmentCollector, this);
    this.resultTypeText = _generateDataType_2;
    IGlobalNameProvider _globalNameProvider = context.getGlobalNameProvider();
    String _newGlobalName = _globalNameProvider.newGlobalName("multiply");
    this.name = _newGlobalName;
    MachineNumericType _numericElementType = this.leftMatrixType.getNumericElementType();
    NumberFormat _numberFormat = _numericElementType.getNumberFormat();
    final NumericExpressionInfo leftOperand = NumericExpressionInfo.create(_numberFormat, "leftMatrix[i][j]");
    MachineNumericType _numericElementType_1 = this.rightMatrixType.getNumericElementType();
    NumberFormat _numberFormat_1 = _numericElementType_1.getNumberFormat();
    final NumericExpressionInfo rightOperand = NumericExpressionInfo.create(_numberFormat_1, "rightMatrix[j][k]");
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
    _builder.append("int k, i, j;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("for (k = 0; k < ");
    int _dimensionSize = this.rightMatrixType.getDimensionSize(1);
    _builder.append(_dimensionSize, "	");
    _builder.append("; ++k) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("for (i = 0; i < ");
    int _dimensionSize_1 = this.leftMatrixType.getDimensionSize(0);
    _builder.append(_dimensionSize_1, "		");
    _builder.append("; ++i) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t");
    _builder.append("for (j = 0; j < ");
    int _dimensionSize_2 = this.leftMatrixType.getDimensionSize(1);
    _builder.append(_dimensionSize_2, "			");
    _builder.append("; ++j) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t\t");
    _builder.append("result.data[i][k] += ");
    _builder.append(multiplyExpression, "				");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
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
    _builder.append(this.leftMatrixElementTypeText, "");
    _builder.append(" leftMatrix[");
    int _dimensionSize = this.leftMatrixType.getDimensionSize(0);
    _builder.append(_dimensionSize, "");
    _builder.append("][");
    int _dimensionSize_1 = this.leftMatrixType.getDimensionSize(1);
    _builder.append(_dimensionSize_1, "");
    _builder.append("], ");
    _builder.append(this.rightMatrixElementTypeText, "");
    _builder.append(" rightMatrix[");
    int _dimensionSize_2 = this.rightMatrixType.getDimensionSize(0);
    _builder.append(_dimensionSize_2, "");
    _builder.append("][");
    int _dimensionSize_3 = this.rightMatrixType.getDimensionSize(1);
    _builder.append(_dimensionSize_3, "");
    _builder.append("])");
    return _builder;
  }
  
  public int hashCode() {
    Class<? extends Object> _class = this.getClass();
    int _hashCode = _class.hashCode();
    int _hashCode_1 = this.leftMatrixType.hashCode();
    int _bitwiseXor = (_hashCode ^ _hashCode_1);
    int _hashCode_2 = this.rightMatrixType.hashCode();
    int _bitwiseXor_1 = (_bitwiseXor ^ _hashCode_2);
    int _hashCode_3 = this.resultType.hashCode();
    return (_bitwiseXor_1 ^ _hashCode_3);
  }
  
  public boolean equals(final Object obj) {
    if ((obj instanceof MatrixMultiplyFunction)) {
      final MatrixMultiplyFunction other = ((MatrixMultiplyFunction) obj);
      boolean _and = false;
      boolean _and_1 = false;
      boolean _equals = Objects.equal(other.leftMatrixType, this.leftMatrixType);
      if (!_equals) {
        _and_1 = false;
      } else {
        boolean _equals_1 = Objects.equal(other.rightMatrixType, this.rightMatrixType);
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
