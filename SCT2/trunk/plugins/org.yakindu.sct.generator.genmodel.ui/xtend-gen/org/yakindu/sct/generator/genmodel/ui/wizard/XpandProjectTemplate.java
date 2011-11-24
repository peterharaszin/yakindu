package org.yakindu.sct.generator.genmodel.ui.wizard;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import org.apache.commons.lang.StringEscapeUtils;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.xtext.xbase.lib.BooleanExtensions;
import org.eclipse.xtext.xbase.lib.IntegerExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.eclipse.xtext.xtend2.lib.StringConcatenation;
import org.yakindu.sct.generator.genmodel.ui.wizard.ProjectData;

@SuppressWarnings("all")
public class XpandProjectTemplate {
  
  private IProgressMonitor monitor;
  
  public IProgressMonitor setMonitor(final IProgressMonitor monitor) {
    IProgressMonitor _monitor = this.monitor = monitor;
    return _monitor;
  }
  
  public void generate(final ProjectData data) throws IOException, UnsupportedEncodingException, CoreException {
    {
      this.monitor.beginTask("Create YAKINDU Xpand Generator Project", 12);
      IWorkspace _workspace = ResourcesPlugin.getWorkspace();
      IWorkspaceRoot _root = _workspace.getRoot();
      String _projectName = data.getProjectName();
      IProject _project = _root.getProject(_projectName);
      final IProject project = _project;
      SubProgressMonitor _sub = this.sub(this.monitor);
      project.create(_sub);
      SubProgressMonitor _sub_1 = this.sub(this.monitor);
      project.open(_sub_1);
      this.monitor.worked(1);
      this.createFolder(project, "src");
      IFile _file = project.getFile(".settings/org.eclipse.core.resources.prefs");
      String _encoding = ResourcesPlugin.getEncoding();
      StringConcatenation _projectSettings = this.projectSettings(data, _encoding);
      this.write(_file, _projectSettings);
      IFile _file_1 = project.getFile(".settings/org.eclipse.xtend.shared.ui.prefs");
      StringConcatenation _xpandSettings = this.xpandSettings(data);
      this.write(_file_1, _xpandSettings);
      IFile _file_2 = project.getFile("build.properties");
      StringConcatenation _buildProperties = this.buildProperties(data);
      this.write(_file_2, _buildProperties);
      IFile _file_3 = project.getFile("META-INF/MANIFEST.MF");
      StringConcatenation _manifest = this.manifest(data);
      this.write(_file_3, _manifest);
      String _targetPackage = this.targetPackage(data);
      String _asFolder = this.asFolder(_targetPackage);
      String _operator_plus = StringExtensions.operator_plus("src/", _asFolder);
      String _operator_plus_1 = StringExtensions.operator_plus(_operator_plus, "/");
      String _templateName = this.templateName(data);
      String _operator_plus_2 = StringExtensions.operator_plus(_operator_plus_1, _templateName);
      String _operator_plus_3 = StringExtensions.operator_plus(_operator_plus_2, ".xpt");
      IFile _file_4 = project.getFile(_operator_plus_3);
      String _fromMyFolder = this.fromMyFolder("XpandDefaultTemplate.xpt");
      String _resource = this.resource(_fromMyFolder, "iso-8859-1");
      this.write(_file_4, _resource);
      boolean _isPluginExport = data.isPluginExport();
      if (_isPluginExport) {
        {
          IFile _file_5 = project.getFile("plugin.xml");
          StringConcatenation _plugin = this.plugin(data);
          this.write(_file_5, _plugin);
          String _generatorClass = data.getGeneratorClass();
          String _javaFilename = this.javaFilename(_generatorClass);
          String _operator_plus_4 = StringExtensions.operator_plus("src/", _javaFilename);
          IFile _file_6 = project.getFile(_operator_plus_4);
          StringConcatenation _generator = this.generator(data);
          this.write(_file_6, _generator);
          boolean _isTypeLibrary = data.isTypeLibrary();
          if (_isTypeLibrary) {
            this.createFolder(project, "library");
          }
        }
      }
      IFile _file_7 = project.getFile(".classpath");
      StringConcatenation _classpath = this.classpath(data);
      this.write(_file_7, _classpath);
      IFile _file_8 = project.getFile(".project");
      StringConcatenation _projectFile = this.projectFile(data);
      this.write(_file_8, _projectFile);
    }
  }
  
  public String fromMyFolder(final String s) {
    String _operator_plus = StringExtensions.operator_plus("org/yakindu/sct/generator/genmodel/ui/wizard/", s);
    return _operator_plus;
  }
  
  public SubProgressMonitor sub(final IProgressMonitor mon) {
    SubProgressMonitor _subProgressMonitor = new SubProgressMonitor(mon, 1);
    return _subProgressMonitor;
  }
  
  public String templateName(final ProjectData data) {
    String _xifexpression = null;
    boolean _isPluginExport = data.isPluginExport();
    if (_isPluginExport) {
      String _generatorClass = data.getGeneratorClass();
      String _simpleName = this.simpleName(_generatorClass);
      _xifexpression = _simpleName;
    } else {
      _xifexpression = "Main";
    }
    return _xifexpression;
  }
  
  public String targetPackage(final ProjectData data) {
    String _xifexpression = null;
    boolean _isPluginExport = data.isPluginExport();
    if (_isPluginExport) {
      String _generatorClass = data.getGeneratorClass();
      String _packageName = this.packageName(_generatorClass);
      _xifexpression = _packageName;
    } else {
      _xifexpression = "org.yakindu.sct.generator.xpand";
    }
    return _xifexpression;
  }
  
  public String asFolder(final String s) {
    String _replaceAll = s.replaceAll("\\.", "/");
    return _replaceAll;
  }
  
  public String javaPathToXpand(final String s) {
    String _replaceAll = s.replaceAll("\\.", "::");
    return _replaceAll;
  }
  
  public String simpleName(final String s) {
    int _lastIndexOf = s.lastIndexOf(".");
    int _operator_plus = IntegerExtensions.operator_plus(((Integer)_lastIndexOf), ((Integer)1));
    String _substring = s.substring(_operator_plus);
    return _substring;
  }
  
  public String packageName(final String s) {
    int _lastIndexOf = s.lastIndexOf(".");
    String _substring = s.substring(0, _lastIndexOf);
    return _substring;
  }
  
  public String providerClass(final ProjectData data) {
    String _generatorClass = data.getGeneratorClass();
    String _operator_plus = StringExtensions.operator_plus(_generatorClass, "DefaultValueProvider");
    return _operator_plus;
  }
  
  public String javaFilename(final String s) {
    String _replaceAll = s.replaceAll("\\.", "/");
    String _operator_plus = StringExtensions.operator_plus(_replaceAll, ".java");
    return _operator_plus;
  }
  
  public void write(final IFile file, final StringConcatenation content) throws IOException, UnsupportedEncodingException, CoreException {
    String _string = content.toString();
    this.write(file, _string);
  }
  
  public void write(final IFile file, final String content) throws IOException, UnsupportedEncodingException, CoreException {
    {
      IContainer _parent = file.getParent();
      boolean _exists = _parent.exists();
      boolean _operator_not = BooleanExtensions.operator_not(_exists);
      if (_operator_not) {
        IContainer _parent_1 = file.getParent();
        SubProgressMonitor _sub = this.sub(this.monitor);
        this.createFolderHierarchy(((IFolder) _parent_1), _sub);
      }
      String _charset = file.getCharset();
      byte[] _bytes = content.getBytes(_charset);
      ByteArrayInputStream _byteArrayInputStream = new ByteArrayInputStream(_bytes);
      final ByteArrayInputStream stream = _byteArrayInputStream;
      try {
        boolean _exists_1 = file.exists();
        if (_exists_1) {
          SubProgressMonitor _sub_1 = this.sub(this.monitor);
          file.setContents(stream, true, true, _sub_1);
        } else {
          {
            SubProgressMonitor _sub_2 = this.sub(this.monitor);
            final SubProgressMonitor submonitor = _sub_2;
            file.create(stream, true, submonitor);
            String _encoding = ResourcesPlugin.getEncoding();
            file.setCharset(_encoding, submonitor);
          }
        }
      } catch (final Exception e) { 
        e.printStackTrace();
      } finally {
        stream.close();
      }
      this.monitor.worked(1);
    }
  }
  
  public void createFolder(final IContainer container, final String folderPath) throws CoreException {
    {
      Path _path = new Path(folderPath);
      IFolder _folder = container.getFolder(_path);
      SubProgressMonitor _sub = this.sub(this.monitor);
      this.createFolderHierarchy(_folder, _sub);
      this.monitor.worked(1);
    }
  }
  
  public Object createFolderHierarchy(final IFolder folder, final IProgressMonitor submonitor) throws CoreException {
    Object _xifexpression = null;
    boolean _exists = folder.exists();
    boolean _operator_not = BooleanExtensions.operator_not(_exists);
    if (_operator_not) {
      {
        boolean _operator_and = false;
        IContainer _parent = folder.getParent();
        boolean _exists_1 = _parent.exists();
        boolean _operator_not_1 = BooleanExtensions.operator_not(_exists_1);
        if (!_operator_not_1) {
          _operator_and = false;
        } else {
          IContainer _parent_1 = folder.getParent();
          int _type = _parent_1.getType();
          boolean _operator_equals = ObjectExtensions.operator_equals(((Integer)_type), ((Integer)IResource.FOLDER));
          _operator_and = BooleanExtensions.operator_and(_operator_not_1, _operator_equals);
        }
        if (_operator_and) {
          IContainer _parent_2 = folder.getParent();
          this.createFolderHierarchy(((IFolder) _parent_2), submonitor);
        }
        folder.create(true, true, this.monitor);
      }
    }
    return _xifexpression;
  }
  
  public String escapeForXml(final String s) {
    String _escapeXml = StringEscapeUtils.escapeXml(s);
    return _escapeXml;
  }
  
  public String resource(final String path, final String encoding) throws IOException, UnsupportedEncodingException {
    String _xblockexpression = null;
    {
      Thread _currentThread = Thread.currentThread();
      ClassLoader _contextClassLoader = _currentThread.getContextClassLoader();
      InputStream _resourceAsStream = _contextClassLoader.getResourceAsStream(path);
      final InputStream inStream = _resourceAsStream;
      ByteArrayOutputStream _byteArrayOutputStream = new ByteArrayOutputStream();
      final ByteArrayOutputStream outStream = _byteArrayOutputStream;
      String _xtrycatchfinallyexpression = null;
      try {
        String _xblockexpression_1 = null;
        {
          BufferedInputStream _bufferedInputStream = new BufferedInputStream(inStream);
          final BufferedInputStream buffer = _bufferedInputStream;
          int result = 0;
          int _read = buffer.read();
          int _result = result = _read;
          int _operator_minus = IntegerExtensions.operator_minus(1);
          boolean _operator_notEquals = ObjectExtensions.operator_notEquals(((Integer)_result), ((Integer)_operator_minus));
          Boolean _xwhileexpression = _operator_notEquals;
          while (_xwhileexpression) {
            outStream.write(((byte) result));
            int _read_1 = buffer.read();
            int _result_1 = result = _read_1;
            int _operator_minus_1 = IntegerExtensions.operator_minus(1);
            boolean _operator_notEquals_1 = ObjectExtensions.operator_notEquals(((Integer)_result_1), ((Integer)_operator_minus_1));
            _xwhileexpression = _operator_notEquals_1;
          }
          String _string = outStream.toString(encoding);
          _xblockexpression_1 = (_string);
        }
        _xtrycatchfinallyexpression = _xblockexpression_1;
      } finally {
        inStream.close();
      }
      _xblockexpression = (_xtrycatchfinallyexpression);
    }
    return _xblockexpression;
  }
  
  public StringConcatenation projectFile(final ProjectData data) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
    _builder.newLine();
    _builder.append("<projectDescription>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<name>");
    String _projectName = data.getProjectName();
    _builder.append(_projectName, "	");
    _builder.append("</name>");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("<comment></comment>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<projects>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("</projects>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<buildSpec>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<buildCommand>");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("<name>org.eclipse.xtend.shared.ui.xtendBuilder</name>");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("<arguments>");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("</arguments>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("</buildCommand>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<buildCommand>");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("<name>org.eclipse.pde.ManifestBuilder</name>");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("<arguments>");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("</arguments>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("</buildCommand>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<buildCommand>");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("<name>org.eclipse.pde.SchemaBuilder</name>");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("<arguments>");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("</arguments>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("</buildCommand>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<buildCommand>");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("<name>org.eclipse.jdt.core.javabuilder</name>");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("<arguments>");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("</arguments>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("</buildCommand>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("</buildSpec>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<natures>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<nature>org.eclipse.jdt.core.javanature</nature>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<nature>org.eclipse.pde.PluginNature</nature>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<nature>org.eclipse.xtend.shared.ui.xtendXPandNature</nature>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("</natures>");
    _builder.newLine();
    _builder.append("</projectDescription>");
    _builder.newLine();
    return _builder;
  }
  
  public StringConcatenation classpath(final ProjectData data) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
    _builder.newLine();
    _builder.append("<classpath>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<classpathentry kind=\"src\" path=\"src\"/>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<classpathentry kind=\"con\" path=\"org.eclipse.jdt.launching.JRE_CONTAINER\"/>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<classpathentry kind=\"con\" path=\"org.eclipse.pde.core.requiredPlugins\"/>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<classpathentry kind=\"output\" path=\"bin\"/>");
    _builder.newLine();
    _builder.append("</classpath>");
    _builder.newLine();
    return _builder;
  }
  
  public StringConcatenation manifest(final ProjectData data) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Manifest-Version: 1.0");
    _builder.newLine();
    _builder.append("Bundle-ManifestVersion: 2");
    _builder.newLine();
    _builder.append("Bundle-Name: ");
    String _projectName = data.getProjectName();
    _builder.append(_projectName, "");
    _builder.newLineIfNotEmpty();
    _builder.append("Bundle-SymbolicName: ");
    String _projectName_1 = data.getProjectName();
    _builder.append(_projectName_1, "");
    _builder.append("; singleton:=true");
    _builder.newLineIfNotEmpty();
    _builder.append("Bundle-Version: 1.0.0");
    _builder.newLine();
    _builder.append("Require-Bundle: org.eclipse.jdt.core;bundle-version=\"3.5.0\",");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("org.eclipse.xtend.profiler;resolution:=optional,");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("org.apache.commons.logging,");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("org.apache.log4j;resolution:=optional,");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("com.ibm.icu;bundle-version=\"4.0.1\",");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("org.antlr.runtime;bundle-version=\"3.0.0\",");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("org.eclipse.core.runtime;bundle-version=\"3.5.0\",");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("org.eclipse.emf.mwe.utils;bundle-version=\"0.7.0\",");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("org.eclipse.emf.ecore.xmi;bundle-version=\"2.5.0\",");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("org.eclipse.jface.text;bundle-version=\"3.5.0\",");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("org.eclipse.xpand;bundle-version=\"0.7.0\",");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("org.eclipse.xtend;bundle-version=\"0.7.0\",");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("org.eclipse.xtend.typesystem.emf;bundle-version=\"0.7.0\",");
    _builder.newLine();
    {
      boolean _isPluginExport = data.isPluginExport();
      if (_isPluginExport) {
        _builder.append(" ", "");
        _builder.append("org.yakindu.sct.generator.core;bundle-version=\"1.0.0\",");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append(" ");
    _builder.append("org.yakindu.sct.model.sgen;bundle-version=\"1.0.0\",");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("org.yakindu.sct.model.sexec;bundle-version=\"1.0.0\",");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("org.yakindu.sct.model.stext;bundle-version=\"1.0.0\",");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("org.yakindu.sct.model.sgraph;bundle-version=\"1.0.0\"");
    _builder.newLine();
    _builder.append("Bundle-RequiredExecutionEnvironment: J2SE-1.5");
    _builder.newLine();
    return _builder;
  }
  
  public StringConcatenation plugin(final ProjectData data) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
    _builder.newLine();
    _builder.append("<?eclipse version=\"3.4\"?>");
    _builder.newLine();
    _builder.append("<plugin>");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("<extension");
    _builder.newLine();
    _builder.append("         ");
    _builder.append("point=\"org.yakindu.sct.generator.core.generator\">");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("<SCTGenerator class=\"");
    String _generatorClass = data.getGeneratorClass();
    _builder.append(_generatorClass, "      ");
    _builder.append("\"");
    _builder.newLineIfNotEmpty();
    _builder.append("            ");
    _builder.append("description=\"");
    String _generatorDescription = data.getGeneratorDescription();
    String _escapeForXml = this.escapeForXml(_generatorDescription);
    _builder.append(_escapeForXml, "            ");
    _builder.append("\"");
    _builder.newLineIfNotEmpty();
    _builder.append("            ");
    _builder.append("id=\"");
    String _generatorId = data.getGeneratorId();
    _builder.append(_generatorId, "            ");
    _builder.append("\"");
    _builder.newLineIfNotEmpty();
    _builder.append("            ");
    _builder.append("name=\"");
    String _generatorName = data.getGeneratorName();
    String _escapeForXml_1 = this.escapeForXml(_generatorName);
    _builder.append(_escapeForXml_1, "            ");
    _builder.append("\">");
    _builder.newLineIfNotEmpty();
    _builder.append("      ");
    _builder.append("</SCTGenerator>");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("</extension>");
    _builder.newLine();
    {
      boolean _isTypeLibrary = data.isTypeLibrary();
      if (_isTypeLibrary) {
        _builder.append("<extension");
        _builder.newLine();
        _builder.append("      ");
        _builder.append("point=\"org.yakindu.sct.generator.core.featuretypes\">");
        _builder.newLine();
        _builder.append("   ");
        _builder.append("<FeatureLibrary generatorId=\"");
        String _generatorId_1 = data.getGeneratorId();
        _builder.append(_generatorId_1, "   ");
        _builder.append("\" ");
        _builder.newLineIfNotEmpty();
        _builder.append("   ");
        _builder.append("defaultProvider=\"");
        String _providerClass = this.providerClass(data);
        _builder.append(_providerClass, "   ");
        _builder.append("\"");
        _builder.newLineIfNotEmpty();
        _builder.append("         ");
        _builder.append("uri=\"platform:/plugin/");
        String _projectName = data.getProjectName();
        _builder.append(_projectName, "         ");
        _builder.append("/library/FeatureTypeLibrary.xmi\">");
        _builder.newLineIfNotEmpty();
        _builder.append("   ");
        _builder.append("</FeatureLibrary>");
        _builder.newLine();
        _builder.append("</extension>");
        _builder.newLine();
      }
    }
    _builder.append("</plugin>");
    _builder.newLine();
    return _builder;
  }
  
  public StringConcatenation generator(final ProjectData data) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package ");
    String _generatorClass = data.getGeneratorClass();
    String _packageName = this.packageName(_generatorClass);
    _builder.append(_packageName, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import org.yakindu.sct.generator.core.impl.AbstractXpandBasedCodeGenerator;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("/**");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* Generator using Xpand template \"");
    String _generatorClass_1 = data.getGeneratorClass();
    String _javaPathToXpand = this.javaPathToXpand(_generatorClass_1);
    _builder.append(_javaPathToXpand, " ");
    _builder.append("::main\"");
    _builder.newLineIfNotEmpty();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("public class ");
    String _generatorClass_2 = data.getGeneratorClass();
    String _simpleName = this.simpleName(_generatorClass_2);
    _builder.append(_simpleName, "");
    _builder.append(" extends AbstractXpandBasedCodeGenerator {");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Override");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public String getTemplatePath() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return \"");
    String _generatorClass_3 = data.getGeneratorClass();
    String _javaPathToXpand_1 = this.javaPathToXpand(_generatorClass_3);
    _builder.append(_javaPathToXpand_1, "		");
    _builder.append("::main\";");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public StringConcatenation defaultProvider(final ProjectData data) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package ");
    String _providerClass = this.providerClass(data);
    String _packageName = this.packageName(_providerClass);
    _builder.append(_packageName, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import org.yakindu.sct.generator.core.features.AbstractDefaultFeatureValueProvider;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("/**");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* Default value proivder for ");
    String _generatorName = data.getGeneratorName();
    _builder.append(_generatorName, " ");
    _builder.append(" feature library");
    _builder.newLineIfNotEmpty();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("public class ");
    String _providerClass_1 = this.providerClass(data);
    String _simpleName = this.simpleName(_providerClass_1);
    _builder.append(_simpleName, "");
    _builder.append(" extends AbstractDefaultFeatureValueProvider {");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private static final String LIBRARY_NAME = \"");
    String _generatorName_1 = data.getGeneratorName();
    _builder.append(_generatorName_1, "	");
    _builder.append("\";");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Override");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected void setDefaultValue(FeatureParameterValue parameterValue,");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("Statechart statechart) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("String parameterName = parameterValue.getParameter().getName();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("//TODO: set the default values");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public boolean isProviderFor(FeatureTypeLibrary library) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return library.getName().equals(LIBRARY_NAME);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public IStatus validateParameterValue(FeatureParameterValue value) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("String name = value.getParameter().getName();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("//TODO implement validation");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return Status.OK_STATUS;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public StringConcatenation projectSettings(final ProjectData data, final String encoding) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("eclipse.preferences.version=1");
    _builder.newLine();
    _builder.append("encoding/<project>=");
    _builder.append(encoding, "");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  public StringConcatenation xpandSettings(final ProjectData data) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("eclipse.preferences.version=1");
    _builder.newLine();
    _builder.append("project.specific.metamodel=true");
    _builder.newLine();
    _builder.append("metamodelContributor=org.eclipse.xtend.typesystem.emf.ui.EmfMetamodelContributor");
    _builder.newLine();
    return _builder;
  }
  
  public StringConcatenation buildProperties(final ProjectData data) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("source.. = src");
    _builder.newLine();
    {
      boolean _isPluginExport = data.isPluginExport();
      if (_isPluginExport) {
        _builder.append("bin.includes = META-INF/,.,plugin.xml");
        _builder.newLine();} else {
        _builder.append("bin.includes = META-INF/,.");
        _builder.newLine();
      }
    }
    return _builder;
  }
}