package org.eclipselabs.damos.codegen.targets.arduino;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipselabs.damos.codegen.c.IGeneratorContext;
import org.eclipselabs.damos.codegen.c.util.GeneratorConfigurationExtensions;
import org.eclipselabs.damos.dconfig.Configuration;
import org.eclipselabs.damos.execution.ExecutionFlow;

@SuppressWarnings("all")
public class InoFileGenerator {
  public CharSequence generate(final IGeneratorContext context, final IProgressMonitor monitor) {
    CharSequence _xblockexpression = null;
    {
      Configuration _configuration = context.getConfiguration();
      final String prefix = GeneratorConfigurationExtensions.getPrefix(_configuration);
      Configuration _configuration_1 = context.getConfiguration();
      final String systemHeaderFile = GeneratorConfigurationExtensions.getSystemHeaderFile(_configuration_1);
      ExecutionFlow _executionFlow = context.getExecutionFlow();
      final double fundamentalSampleTime = _executionFlow.getFundamentalSampleTime();
      final boolean micro = (fundamentalSampleTime <= 0.01);
      int _xifexpression = (int) 0;
      if (micro) {
        _xifexpression = 1000000;
      } else {
        _xifexpression = 1000;
      }
      double _multiply = (fundamentalSampleTime * _xifexpression);
      final long stepSize = Math.round(_multiply);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("#include \"");
      _builder.append(systemHeaderFile, "");
      _builder.append("\"");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("unsigned long Damos_time;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("void setup() {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append(prefix, "	");
      _builder.append("initialize();");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("Damos_time = ");
      {
        if (micro) {
          _builder.append("micros");
        } else {
          _builder.append("millis");
        }
      }
      _builder.append("();");
      _builder.newLineIfNotEmpty();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("void loop() {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append(prefix, "	");
      _builder.append("execute();");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("Damos_time += ");
      _builder.append(stepSize, "	");
      _builder.append("UL;");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("// Delay system, if necessary");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("unsigned long delayTime = Damos_time - ");
      {
        if (micro) {
          _builder.append("micros");
        } else {
          _builder.append("millis");
        }
      }
      _builder.append("();");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("if (delayTime > ");
      _builder.append(stepSize, "	");
      _builder.append("UL) {");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("delayTime += ~(0UL);");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("if (delayTime <= ");
      _builder.append(stepSize, "	");
      _builder.append("UL) {");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      {
        if (micro) {
          _builder.append("delayMicroseconds");
        } else {
          _builder.append("delay");
        }
      }
      _builder.append("(delayTime);");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _xblockexpression = (_builder);
    }
    return _xblockexpression;
  }
}
