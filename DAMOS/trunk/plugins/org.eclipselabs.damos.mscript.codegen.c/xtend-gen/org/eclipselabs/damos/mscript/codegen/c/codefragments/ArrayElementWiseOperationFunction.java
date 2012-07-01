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
import org.eclipselabs.damos.mscript.codegen.c.NumericExpressionCaster;
import org.eclipselabs.damos.mscript.codegen.c.TextualNumericExpressionOperand;
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
public class ArrayElementWiseOperationFunction extends AbstractCodeFragment {
  private final IMultiplicativeExpressionGenerator multiplicativeExpressionGenerator = new Function0<IMultiplicativeExpressionGenerator>() {
    public IMultiplicativeExpressionGenerator apply() {
      InlineMultiplicativeExpressionGenerator _inlineMultiplicativeExpressionGenerator = new InlineMultiplicativeExpressionGenerator();
      return _inlineMultiplicativeExpressionGenerator;
    }
  }.apply();
  
  private final ComputationModel computationModel;
  
  private final OperatorKind operator;
  
  private final MachineArrayType leftArrayType;
  
  private final MachineArrayType rightArrayType;
  
  private final MachineArrayType resultType;
  
  private CharSequence leftArrayElementTypeText;
  
  private CharSequence rightArrayElementTypeText;
  
  private CharSequence resultTypeText;
  
  private String name;
  
  private String functionBody;
  
  @Inject
  public ArrayElementWiseOperationFunction(@Assisted final ComputationModel computationModel, final OperatorKind operator, @Assisted final MachineArrayType leftArrayType, @Assisted final MachineArrayType rightArrayType, @Assisted final MachineArrayType resultType) {
    this.computationModel = computationModel;
    this.operator = operator;
    this.leftArrayType = leftArrayType;
    this.rightArrayType = rightArrayType;
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
    MachineDataType _elementType = this.leftArrayType.getElementType();
    CharSequence _generateDataType = _elementType.generateDataType(this.computationModel, codeFragmentCollector, this);
    this.leftArrayElementTypeText = _generateDataType;
    MachineDataType _elementType_1 = this.rightArrayType.getElementType();
    CharSequence _generateDataType_1 = _elementType_1.generateDataType(this.computationModel, codeFragmentCollector, this);
    this.rightArrayElementTypeText = _generateDataType_1;
    String _generateDataType_2 = this.resultType.generateDataType(this.computationModel, codeFragmentCollector, this);
    this.resultTypeText = _generateDataType_2;
    IGlobalNameProvider _globalNameProvider = context.getGlobalNameProvider();
    String _preferredName = this.getPreferredName();
    String _newGlobalName = _globalNameProvider.newGlobalName(_preferredName);
    this.name = _newGlobalName;
    CharSequence multiplyExpression = this.getMultiplicativeExpression(codeFragmentCollector);
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
      Iterable<String> _indexVariables = this.getIndexVariables();
      boolean _hasElements = false;
      for(final String indexVariable : _indexVariables) {
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
    Iterable<String> _indexVariables_1 = this.getIndexVariables();
    Iterator<String> _iterator = _indexVariables_1.iterator();
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
  
  private String getPreferredName() {
    String _switchResult = null;
    final OperatorKind operator = this.operator;
    boolean _matched = false;
    if (!_matched) {
      if (Objects.equal(operator,OperatorKind.ADD)) {
        _matched=true;
        _switchResult = "add";
      }
    }
    if (!_matched) {
      if (Objects.equal(operator,OperatorKind.SUBTRACT)) {
        _matched=true;
        _switchResult = "subtract";
      }
    }
    if (!_matched) {
      if (Objects.equal(operator,OperatorKind.MULTIPLY)) {
        _matched=true;
        _switchResult = "multiply";
      }
    }
    if (!_matched) {
      if (Objects.equal(operator,OperatorKind.DIVIDE)) {
        _matched=true;
        _switchResult = "divide";
      }
    }
    if (!_matched) {
      if (Objects.equal(operator,OperatorKind.MODULO)) {
        _matched=true;
        _switchResult = "modulo";
      }
    }
    return _switchResult;
  }
  
  private CharSequence getMultiplicativeExpression(final ICodeFragmentCollector codeFragmentCollector) {
    String _arrayVariableName = this.getArrayVariableName();
    String _plus = ("left" + _arrayVariableName);
    Iterable<String> _indexVariables = this.getIndexVariables();
    final Function1<String,String> _function = new Function1<String,String>() {
        public String apply(final String it) {
          String _plus = ("[" + it);
          String _plus_1 = (_plus + "]");
          return _plus_1;
        }
      };
    Iterable<String> _map = IterableExtensions.<String, String>map(_indexVariables, _function);
    String _join = IterableExtensions.join(_map);
    final String leftOperandText = (_plus + _join);
    String _arrayVariableName_1 = this.getArrayVariableName();
    String _plus_1 = ("right" + _arrayVariableName_1);
    Iterable<String> _indexVariables_1 = this.getIndexVariables();
    final Function1<String,String> _function_1 = new Function1<String,String>() {
        public String apply(final String it) {
          String _plus = ("[" + it);
          String _plus_1 = (_plus + "]");
          return _plus_1;
        }
      };
    Iterable<String> _map_1 = IterableExtensions.<String, String>map(_indexVariables_1, _function_1);
    String _join_1 = IterableExtensions.join(_map_1);
    final String rightOperandText = (_plus_1 + _join_1);
    boolean _or = false;
    boolean _equals = Objects.equal(this.operator, OperatorKind.ADD);
    if (_equals) {
      _or = true;
    } else {
      boolean _equals_1 = Objects.equal(this.operator, OperatorKind.SUBTRACT);
      _or = (_equals || _equals_1);
    }
    if (_or) {
      String _switchResult = null;
      final OperatorKind operator = this.operator;
      boolean _matched = false;
      if (!_matched) {
        if (Objects.equal(operator,OperatorKind.ADD)) {
          _matched=true;
          _switchResult = "+";
        }
      }
      if (!_matched) {
        if (Objects.equal(operator,OperatorKind.SUBTRACT)) {
          _matched=true;
          _switchResult = "-";
        }
      }
      final String operatorSymbol = _switchResult;
      MachineNumericType _numericElementType = this.leftArrayType.getNumericElementType();
      NumberFormat _numberFormat = _numericElementType.getNumberFormat();
      MachineNumericType _numericElementType_1 = this.resultType.getNumericElementType();
      NumberFormat _numberFormat_1 = _numericElementType_1.getNumberFormat();
      final CharSequence leftOperand = NumericExpressionCaster.INSTANCE.cast(leftOperandText, _numberFormat, _numberFormat_1);
      MachineNumericType _numericElementType_2 = this.rightArrayType.getNumericElementType();
      NumberFormat _numberFormat_2 = _numericElementType_2.getNumberFormat();
      MachineNumericType _numericElementType_3 = this.resultType.getNumericElementType();
      NumberFormat _numberFormat_3 = _numericElementType_3.getNumberFormat();
      final CharSequence rightOperand = NumericExpressionCaster.INSTANCE.cast(rightOperandText, _numberFormat_2, _numberFormat_3);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append(leftOperand, "");
      _builder.append(" ");
      _builder.append(operatorSymbol, "");
      _builder.append(" ");
      _builder.append(rightOperand, "");
      return _builder;
    }
    MachineNumericType _numericElementType_4 = this.leftArrayType.getNumericElementType();
    NumberFormat _numberFormat_4 = _numericElementType_4.getNumberFormat();
    TextualNumericExpressionOperand _textualNumericExpressionOperand = new TextualNumericExpressionOperand(leftOperandText, _numberFormat_4);
    final TextualNumericExpressionOperand leftOperand_1 = _textualNumericExpressionOperand;
    MachineNumericType _numericElementType_5 = this.rightArrayType.getNumericElementType();
    NumberFormat _numberFormat_5 = _numericElementType_5.getNumberFormat();
    TextualNumericExpressionOperand _textualNumericExpressionOperand_1 = new TextualNumericExpressionOperand(rightOperandText, _numberFormat_5);
    final TextualNumericExpressionOperand rightOperand_1 = _textualNumericExpressionOperand_1;
    MachineNumericType _numericElementType_6 = this.resultType.getNumericElementType();
    NumberFormat _numberFormat_6 = _numericElementType_6.getNumberFormat();
    return this.multiplicativeExpressionGenerator.generate(codeFragmentCollector, this.operator, _numberFormat_6, leftOperand_1, rightOperand_1);
  }
  
  private CharSequence generateLoop(final int dimension, final Iterator<String> indexVariableIt, final CharSequence multiplyExpression) {
    StringConcatenation _builder = new StringConcatenation();
    {
      int _dimensionality = this.rightArrayType.getDimensionality();
      boolean _lessThan = (dimension < _dimensionality);
      if (_lessThan) {
        String indexVariable = indexVariableIt.next();
        _builder.newLineIfNotEmpty();
        _builder.append("for (");
        _builder.append(indexVariable, "");
        _builder.append(" = 0; ");
        _builder.append(indexVariable, "");
        _builder.append(" < ");
        int _dimensionSize = this.leftArrayType.getDimensionSize(dimension);
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
    int _dimensionality = this.rightArrayType.getDimensionality();
    boolean _lessEqualsThan = (_dimensionality <= 4);
    if (_lessEqualsThan) {
      ArrayList<String> _newArrayList = CollectionLiterals.<String>newArrayList("i", "j", "k", "l");
      int _dimensionality_1 = this.rightArrayType.getDimensionality();
      return IterableExtensions.<String>take(_newArrayList, _dimensionality_1);
    }
    int _dimensionality_2 = this.rightArrayType.getDimensionality();
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
    _builder.append(this.leftArrayElementTypeText, "");
    _builder.append(" left");
    String _arrayVariableName = this.getArrayVariableName();
    _builder.append(_arrayVariableName, "");
    {
      int[] _dimensionSizes = this.leftArrayType.getDimensionSizes();
      for(final int size : _dimensionSizes) {
        _builder.append("[");
        _builder.append(size, "");
        _builder.append("]");
      }
    }
    _builder.append(", ");
    _builder.append(this.rightArrayElementTypeText, "");
    _builder.append(" right");
    String _arrayVariableName_1 = this.getArrayVariableName();
    _builder.append(_arrayVariableName_1, "");
    {
      int[] _dimensionSizes_1 = this.rightArrayType.getDimensionSizes();
      for(final int size_1 : _dimensionSizes_1) {
        _builder.append("[");
        _builder.append(size_1, "");
        _builder.append("]");
      }
    }
    _builder.append(")");
    return _builder;
  }
  
  private String getArrayVariableName() {
    String _switchResult = null;
    int _dimensionality = this.leftArrayType.getDimensionality();
    final int _switchValue = _dimensionality;
    boolean _matched = false;
    if (!_matched) {
      if (Objects.equal(_switchValue,1)) {
        _matched=true;
        _switchResult = "Vector";
      }
    }
    if (!_matched) {
      if (Objects.equal(_switchValue,2)) {
        _matched=true;
        _switchResult = "Matrix";
      }
    }
    if (!_matched) {
      _switchResult = "Array";
    }
    return _switchResult;
  }
  
  public int hashCode() {
    Class<? extends Object> _class = this.getClass();
    int _hashCode = _class.hashCode();
    int _hashCode_1 = this.operator.hashCode();
    int _bitwiseXor = (_hashCode ^ _hashCode_1);
    int _hashCode_2 = this.leftArrayType.hashCode();
    int _bitwiseXor_1 = (_bitwiseXor ^ _hashCode_2);
    int _hashCode_3 = this.rightArrayType.hashCode();
    int _bitwiseXor_2 = (_bitwiseXor_1 ^ _hashCode_3);
    int _hashCode_4 = this.resultType.hashCode();
    return (_bitwiseXor_2 ^ _hashCode_4);
  }
  
  public boolean equals(final Object obj) {
    if ((obj instanceof ArrayElementWiseOperationFunction)) {
      final ArrayElementWiseOperationFunction other = ((ArrayElementWiseOperationFunction) obj);
      boolean _and = false;
      boolean _and_1 = false;
      boolean _and_2 = false;
      boolean _equals = Objects.equal(other.operator, this.operator);
      if (!_equals) {
        _and_2 = false;
      } else {
        boolean _equals_1 = Objects.equal(other.leftArrayType, this.leftArrayType);
        _and_2 = (_equals && _equals_1);
      }
      if (!_and_2) {
        _and_1 = false;
      } else {
        boolean _equals_2 = Objects.equal(other.rightArrayType, this.rightArrayType);
        _and_1 = (_and_2 && _equals_2);
      }
      if (!_and_1) {
        _and = false;
      } else {
        boolean _equals_3 = Objects.equal(other.resultType, this.resultType);
        _and = (_and_1 && _equals_3);
      }
      return _and;
    }
    return false;
  }
}
