package org.eclipselabs.damos.mscript.codegen.c.codefragments;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;
import java.util.ArrayList;
import java.util.Iterator;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IntegerRange;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
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
public class ArrayScalarMultiplyFunction extends AbstractCodeFragment {
  private final IMultiplicativeExpressionGenerator multiplicativeExpressionGenerator = new Function0<IMultiplicativeExpressionGenerator>() {
    public IMultiplicativeExpressionGenerator apply() {
      InlineMultiplicativeExpressionGenerator _inlineMultiplicativeExpressionGenerator = new InlineMultiplicativeExpressionGenerator();
      return _inlineMultiplicativeExpressionGenerator;
    }
  }.apply();
  
  private final ComputationModel computationModel;
  
  private final MachineNumericType scalarType;
  
  private final MachineArrayType arrayType;
  
  private final MachineArrayType resultType;
  
  private CharSequence scalarTypeText;
  
  private CharSequence elementTypeText;
  
  private CharSequence resultTypeText;
  
  private String name;
  
  private String functionBody;
  
  @Inject
  public ArrayScalarMultiplyFunction(@Assisted final ComputationModel computationModel, @Assisted final MachineNumericType scalarType, @Assisted final MachineArrayType arrayType, @Assisted final MachineArrayType resultType) {
    this.computationModel = computationModel;
    this.scalarType = scalarType;
    this.arrayType = arrayType;
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
    String _generateDataType = this.scalarType.generateDataType(this.computationModel, codeFragmentCollector, this);
    this.scalarTypeText = _generateDataType;
    MachineDataType _elementType = this.arrayType.getElementType();
    CharSequence _generateDataType_1 = _elementType.generateDataType(this.computationModel, codeFragmentCollector, this);
    this.elementTypeText = _generateDataType_1;
    String _generateDataType_2 = this.resultType.generateDataType(this.computationModel, codeFragmentCollector, this);
    this.resultTypeText = _generateDataType_2;
    IGlobalNameProvider _globalNameProvider = context.getGlobalNameProvider();
    String _newGlobalName = _globalNameProvider.newGlobalName("multiply");
    this.name = _newGlobalName;
    NumberFormat _numberFormat = this.scalarType.getNumberFormat();
    final NumericExpressionInfo leftOperand = NumericExpressionInfo.create(_numberFormat, "scalar");
    MachineNumericType _numericElementType = this.arrayType.getNumericElementType();
    NumberFormat _numberFormat_1 = _numericElementType.getNumberFormat();
    String _arrayVariableName = this.getArrayVariableName();
    Iterable<String> _indexVariables = this.getIndexVariables();
    final Function1<String,String> _function_1 = new Function1<String,String>() {
        public String apply(final String it) {
          String _plus = ("[" + it);
          String _plus_1 = (_plus + "]");
          return _plus_1;
        }
      };
    Iterable<String> _map = IterableExtensions.<String, String>map(_indexVariables, _function_1);
    String _join = IterableExtensions.join(_map);
    String _plus = (_arrayVariableName + _join);
    final NumericExpressionInfo rightOperand = NumericExpressionInfo.create(_numberFormat_1, _plus);
    MachineNumericType _numericElementType_1 = this.resultType.getNumericElementType();
    NumberFormat _numberFormat_2 = _numericElementType_1.getNumberFormat();
    final CharSequence multiplyExpression = this.multiplicativeExpressionGenerator.generate(codeFragmentCollector, OperatorKind.MULTIPLY, _numberFormat_2, leftOperand, rightOperand);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("{");
    _builder.newLine();
    _builder.append("\t");
    _builder.append(this.resultTypeText, "	");
    _builder.append(" result;");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("int ");
    {
      Iterable<String> _indexVariables_1 = this.getIndexVariables();
      boolean _hasElements = false;
      for(final String indexVariable : _indexVariables_1) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate(", ", "	");
        }
        _builder.append(indexVariable, "	");
      }
    }
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    Iterable<String> _indexVariables_2 = this.getIndexVariables();
    Iterator<String> _iterator = _indexVariables_2.iterator();
    CharSequence _generateLoop = this.generateLoop(0, _iterator, multiplyExpression);
    _builder.append(_generateLoop, "	");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("return result;");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.functionBody = _builder.toString();
  }
  
  private CharSequence generateLoop(final int dimension, final Iterator<String> indexVariableIt, final CharSequence multiplyExpression) {
    StringConcatenation _builder = new StringConcatenation();
    {
      int _dimensionality = this.arrayType.getDimensionality();
      boolean _lessThan = (dimension < _dimensionality);
      if (_lessThan) {
        String indexVariable = indexVariableIt.next();
        _builder.newLineIfNotEmpty();
        _builder.append("for (");
        _builder.append(indexVariable, "");
        _builder.append(" = 0; ");
        _builder.append(indexVariable, "");
        _builder.append(" < ");
        int _dimensionSize = this.arrayType.getDimensionSize(dimension);
        _builder.append(_dimensionSize, "");
        _builder.append("; ++");
        _builder.append(indexVariable, "");
        _builder.append(") {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        int _plus = (dimension + 1);
        CharSequence _generateLoop = this.generateLoop(_plus, indexVariableIt, multiplyExpression);
        _builder.append(_generateLoop, "	");
        _builder.newLineIfNotEmpty();
        _builder.append("}");
        _builder.newLine();
      } else {
        _builder.append("result.data");
        {
          Iterable<String> _indexVariables = this.getIndexVariables();
          for(final String indexVariable_1 : _indexVariables) {
            _builder.append("[");
            _builder.append(indexVariable_1, "");
            _builder.append("]");
          }
        }
        _builder.append(" = ");
        _builder.append(multiplyExpression, "");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }
  
  private Iterable<String> getIndexVariables() {
    int _dimensionality = this.arrayType.getDimensionality();
    boolean _lessEqualsThan = (_dimensionality <= 4);
    if (_lessEqualsThan) {
      ArrayList<String> _newArrayList = CollectionLiterals.<String>newArrayList("i", "j", "k", "l");
      int _dimensionality_1 = this.arrayType.getDimensionality();
      return IterableExtensions.<String>take(_newArrayList, _dimensionality_1);
    }
    int _dimensionality_2 = this.arrayType.getDimensionality();
    int _minus = (_dimensionality_2 - 1);
    IntegerRange _upTo = new IntegerRange(0, _minus);
    final Function1<Integer,String> _function = new Function1<Integer,String>() {
        public String apply(final Integer it) {
          String _plus = ("i" + it);
          return _plus;
        }
      };
    return IterableExtensions.<Integer, String>map(_upTo, _function);
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
    _builder.append(" scalar, ");
    _builder.append(this.elementTypeText, "");
    _builder.append(" ");
    String _arrayVariableName = this.getArrayVariableName();
    _builder.append(_arrayVariableName, "");
    {
      int[] _dimensionSizes = this.arrayType.getDimensionSizes();
      for(final int size : _dimensionSizes) {
        _builder.append("[");
        _builder.append(size, "");
        _builder.append("]");
      }
    }
    _builder.append(")");
    return _builder;
  }
  
  private String getArrayVariableName() {
    String _switchResult = null;
    int _dimensionality = this.arrayType.getDimensionality();
    final int _switchValue = _dimensionality;
    boolean _matched = false;
    if (!_matched) {
      if (Objects.equal(_switchValue,1)) {
        _matched=true;
        _switchResult = "vector";
      }
    }
    if (!_matched) {
      if (Objects.equal(_switchValue,2)) {
        _matched=true;
        _switchResult = "matrix";
      }
    }
    if (!_matched) {
      _switchResult = "array";
    }
    return _switchResult;
  }
  
  public int hashCode() {
    Class<? extends Object> _class = this.getClass();
    int _hashCode = _class.hashCode();
    int _hashCode_1 = this.scalarType.hashCode();
    int _bitwiseXor = (_hashCode ^ _hashCode_1);
    int _hashCode_2 = this.arrayType.hashCode();
    int _bitwiseXor_1 = (_bitwiseXor ^ _hashCode_2);
    int _hashCode_3 = this.resultType.hashCode();
    return (_bitwiseXor_1 ^ _hashCode_3);
  }
  
  public boolean equals(final Object obj) {
    if ((obj instanceof ArrayScalarMultiplyFunction)) {
      final ArrayScalarMultiplyFunction other = ((ArrayScalarMultiplyFunction) obj);
      boolean _and = false;
      boolean _and_1 = false;
      boolean _equals = Objects.equal(other.scalarType, this.scalarType);
      if (!_equals) {
        _and_1 = false;
      } else {
        boolean _equals_1 = Objects.equal(other.arrayType, this.arrayType);
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
