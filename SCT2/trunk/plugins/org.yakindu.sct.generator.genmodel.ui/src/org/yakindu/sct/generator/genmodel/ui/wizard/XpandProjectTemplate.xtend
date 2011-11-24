/**
 * Copyright (c) 2011 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.generator.genmodel.ui.wizard

import org.eclipse.xtext.generator.IGenerator
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.IFileSystemAccess
import org.eclipse.core.runtime.IProgressMonitor
import org.eclipse.core.resources.IContainer
import org.eclipse.core.runtime.Path
import org.eclipse.core.resources.IFolder
import org.eclipse.core.resources.IResource
import org.eclipse.xtend.shared.ui.wizards.EclipseHelper
import org.eclipse.core.resources.ResourcesPlugin
import org.apache.commons.lang.StringEscapeUtils
import org.eclipse.jdt.core.JavaCore
import org.eclipse.jdt.core.IJavaProject
import org.eclipse.xtend.shared.ui.core.builder.XtendXpandNature
import org.eclipse.core.resources.IProjectDescription
import org.eclipse.xtend.shared.ui.core.builder.XtendXpandBuilder
import org.eclipse.core.resources.IFile
import org.eclipse.xtext.xtend2.lib.StringConcatenation
import java.io.ByteArrayInputStream
import org.eclipse.core.resources.IProject
import org.eclipse.core.runtime.SubProgressMonitor
import java.io.ByteArrayOutputStream
import java.io.BufferedInputStream


/**
 * 
 * @author holger willebrandt - Initial contribution and API
 */
class XpandProjectTemplate {
	
	IProgressMonitor monitor
	
	def setMonitor(IProgressMonitor monitor) {
		this.monitor = monitor
	}

	def generate(ProjectData data) {
		monitor.beginTask("Create YAKINDU Xpand Generator Project", 12);
		val project = ResourcesPlugin::workspace.root.getProject(data.projectName);
		project.create(monitor.sub)
		project.open(monitor.sub)
		monitor.worked(1)
		project.createFolder('src')
		project.getFile('.settings/org.eclipse.core.resources.prefs')
			.write(data.projectSettings(ResourcesPlugin::encoding))
		project.getFile('.settings/org.eclipse.xtend.shared.ui.prefs').write(data.xpandSettings)
		project.getFile('build.properties').write(data.buildProperties)
		project.getFile('META-INF/MANIFEST.MF').write(data.manifest)
		project.getFile('src/'+data.targetPackage.asFolder+'/'+data.templateName+'.xpt').
			write(resource('XpandDefaultTemplate.xpt'.fromMyFolder,'iso-8859-1'))
		if (data.pluginExport) {
			project.getFile('plugin.xml').write(data.plugin)
			project.getFile('src/'+data.generatorClass.javaFilename).write(data.generator)
			if (data.typeLibrary) {
				project.createFolder('library')
				//TODO create FeatureTypeLibrary.xmi
			}	
		}
		project.getFile('.classpath').write(data.classpath);
		project.getFile('.project').write(data.projectFile);
	}
	
	def fromMyFolder(String s) {
		'org/yakindu/sct/generator/genmodel/ui/wizard/'+s
	}
	
	def sub(IProgressMonitor mon) {
		new SubProgressMonitor(mon,1)
	}
	
	def templateName(ProjectData data) {
		if (data.pluginExport)
			data.generatorClass.simpleName
		else
			'Main'
	}
	
	def targetPackage(ProjectData data) {
		if (data.pluginExport)
			data.generatorClass.packageName
		else
			'org.yakindu.sct.generator.xpand'
	}
	
	def asFolder(String s) {
		s.replaceAll('\\.','/')
	}
	
	def javaPathToXpand(String s) {
		s.replaceAll('\\.','::')
	}
	
	def simpleName(String s) {
		s.substring(s.lastIndexOf('.')+1)
	}
	
	def packageName(String s) {
		s.substring(0, s.lastIndexOf('.'))	
	}
	
	def providerClass(ProjectData data){
		data.generatorClass+'DefaultValueProvider'
	}
	
	def javaFilename(String s) {
		s.replaceAll('\\.','/')+'.java'
	}
	
	def write(IFile file, StringConcatenation content) {
		file.write(content.toString)
	}

	def write(IFile file, String content) {
		if (!file.parent.exists) {
			createFolderHierarchy(file.parent as IFolder,monitor.sub)
		}
		val stream = new ByteArrayInputStream(content.getBytes(file.charset))
		try {
			if (file.exists) {
				file.setContents(stream, true, true, monitor.sub)
			} else {
				val submonitor = monitor.sub
				file.create(stream, true, submonitor)
				file.setCharset(ResourcesPlugin::encoding, submonitor)
			}
		} catch (Exception e) {
			e.printStackTrace
		} finally{
			stream.close();
		}
		monitor.worked(1)
	}
	
	def createFolder(IContainer container, String folderPath) {
		createFolderHierarchy(container.getFolder(new Path(folderPath)),monitor.sub);
		monitor.worked(1)
	}

	 def createFolderHierarchy(IFolder folder, IProgressMonitor submonitor) {
		if (!folder.exists) {
			if (!folder.parent.exists
					&& folder.parent.type == IResource::FOLDER) {
				createFolderHierarchy(folder.parent as IFolder,submonitor);
			}
			folder.create(true, true, monitor);
		}
	}
	
	def escapeForXml(String s) {
		StringEscapeUtils::escapeXml(s)
	}
	
	def resource(String path, String encoding) {
		val inStream = Thread::currentThread.contextClassLoader.getResourceAsStream(path)
		val outStream = new ByteArrayOutputStream()
		try {
			val buffer = new BufferedInputStream(inStream)
			var result=0;
			while ((result=buffer.read) != -1 ) {
				outStream.write(result as byte)
			}
			outStream.toString(encoding)
		} finally {
			inStream.close
		}
	}
	
	def projectFile(ProjectData data) '''
		<?xml version="1.0" encoding="UTF-8"?>
		<projectDescription>
			<name>«data.projectName»</name>
			<comment></comment>
			<projects>
			</projects>
			<buildSpec>
				<buildCommand>
					<name>org.eclipse.xtend.shared.ui.xtendBuilder</name>
					<arguments>
					</arguments>
				</buildCommand>
				<buildCommand>
					<name>org.eclipse.pde.ManifestBuilder</name>
					<arguments>
					</arguments>
				</buildCommand>
				<buildCommand>
					<name>org.eclipse.pde.SchemaBuilder</name>
					<arguments>
					</arguments>
				</buildCommand>
				<buildCommand>
					<name>org.eclipse.jdt.core.javabuilder</name>
					<arguments>
					</arguments>
				</buildCommand>
			</buildSpec>
			<natures>
				<nature>org.eclipse.jdt.core.javanature</nature>
				<nature>org.eclipse.pde.PluginNature</nature>
				<nature>org.eclipse.xtend.shared.ui.xtendXPandNature</nature>
			</natures>
		</projectDescription>
	'''
	
	def classpath(ProjectData data) '''
		<?xml version="1.0" encoding="UTF-8"?>
		<classpath>
			<classpathentry kind="src" path="src"/>
			<classpathentry kind="con" path="org.eclipse.jdt.launching.JRE_CONTAINER"/>
			<classpathentry kind="con" path="org.eclipse.pde.core.requiredPlugins"/>
			<classpathentry kind="output" path="bin"/>
		</classpath>
	'''
	
	def manifest(ProjectData data)'''
		Manifest-Version: 1.0
		Bundle-ManifestVersion: 2
		Bundle-Name: «data.projectName»
		Bundle-SymbolicName: «data.projectName»; singleton:=true
		Bundle-Version: 1.0.0
		Require-Bundle: org.eclipse.jdt.core;bundle-version="3.5.0",
		 org.eclipse.xtend.profiler;resolution:=optional,
		 org.apache.commons.logging,
		 org.apache.log4j;resolution:=optional,
		 com.ibm.icu;bundle-version="4.0.1",
		 org.antlr.runtime;bundle-version="3.0.0",
		 org.eclipse.core.runtime;bundle-version="3.5.0",
		 org.eclipse.emf.mwe.utils;bundle-version="0.7.0",
		 org.eclipse.emf.ecore.xmi;bundle-version="2.5.0",
		 org.eclipse.jface.text;bundle-version="3.5.0",
		 org.eclipse.xpand;bundle-version="0.7.0",
		 org.eclipse.xtend;bundle-version="0.7.0",
		 org.eclipse.xtend.typesystem.emf;bundle-version="0.7.0",
		«IF data.pluginExport»
			«' '»org.yakindu.sct.generator.core;bundle-version="1.0.0",
		«ENDIF»
		 org.yakindu.sct.model.sgen;bundle-version="1.0.0",
		 org.yakindu.sct.model.sexec;bundle-version="1.0.0",
		 org.yakindu.sct.model.stext;bundle-version="1.0.0",
		 org.yakindu.sct.model.sgraph;bundle-version="1.0.0"
		Bundle-RequiredExecutionEnvironment: J2SE-1.5
	'''
	
	def plugin(ProjectData data) '''
		<?xml version="1.0" encoding="UTF-8"?>
		<?eclipse version="3.4"?>
		<plugin>
		   <extension
		         point="org.yakindu.sct.generator.core.generator">
		      <SCTGenerator class="«data.generatorClass»"
		            description="«data.generatorDescription.escapeForXml»"
		            id="«data.generatorId»"
		            name="«data.generatorName.escapeForXml»">
		      </SCTGenerator>
		   </extension>
		«IF data.typeLibrary»
		   <extension
		         point="org.yakindu.sct.generator.core.featuretypes">
		      <FeatureLibrary generatorId="«data.generatorId»" 
		      defaultProvider="«data.providerClass»"
		            uri="platform:/plugin/«data.projectName»/library/FeatureTypeLibrary.xmi">
		      </FeatureLibrary>
		   </extension>
		«ENDIF»   
		</plugin>
	'''
	
	def generator(ProjectData data) '''
		package «data.generatorClass.packageName»;
		
		import org.yakindu.sct.generator.core.impl.AbstractXpandBasedCodeGenerator;
		
		/**
		 * Generator using Xpand template "«data.generatorClass.javaPathToXpand»::main"
		 */
		public class «data.generatorClass.simpleName» extends AbstractXpandBasedCodeGenerator {
		
			@Override
			public String getTemplatePath() {
				return "«data.generatorClass.javaPathToXpand»::main";
			}
		}
	'''
	
	def defaultProvider(ProjectData data) '''
		package «data.providerClass.packageName»;
		
		import org.yakindu.sct.generator.core.features.AbstractDefaultFeatureValueProvider;
		
		/**
		 * Default value proivder for «data.generatorName» feature library
		 */
		public class «data.providerClass.simpleName» extends AbstractDefaultFeatureValueProvider {
		
			private static final String LIBRARY_NAME = "«data.generatorName»";
			
			@Override
			protected void setDefaultValue(FeatureParameterValue parameterValue,
					Statechart statechart) {
				String parameterName = parameterValue.getParameter().getName();
				//TODO: set the default values
			}
		
			public boolean isProviderFor(FeatureTypeLibrary library) {
				return library.getName().equals(LIBRARY_NAME);
			}
		
			public IStatus validateParameterValue(FeatureParameterValue value) {
				String name = value.getParameter().getName();
				//TODO implement validation
				return Status.OK_STATUS;
			}
		}
	'''
	
	def projectSettings(ProjectData data, String encoding) '''
		eclipse.preferences.version=1
		encoding/<project>=«encoding»
	'''

	def xpandSettings(ProjectData data) '''
		eclipse.preferences.version=1
		project.specific.metamodel=true
		metamodelContributor=org.eclipse.xtend.typesystem.emf.ui.EmfMetamodelContributor
	'''
	
	def buildProperties(ProjectData data) '''
		source.. = src
		«IF data.pluginExport»
			bin.includes = META-INF/,.,plugin.xml
		«ELSE»
			bin.includes = META-INF/,.
		«ENDIF»
	'''
	
 }