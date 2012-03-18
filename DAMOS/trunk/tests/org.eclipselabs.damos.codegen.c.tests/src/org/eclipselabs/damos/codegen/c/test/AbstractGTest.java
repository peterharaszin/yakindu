/****************************************************************************
 * Copyright (c) 2008, 2012 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipselabs.damos.codegen.c.test;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.junit.runner.RunWith;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

/**
 * @author Andreas Unger
 *
 */
@RunWith(GTestRunner.class)
public abstract class AbstractGTest {

	public void compile() {
		try {
			copyFilesFromBundleToFolder();
			IResource resource = ResourcesPlugin.getWorkspace().getRoot().findMember(getTargetPath());
			File directory = resource.getLocation().toFile();
			List<String> command = createCommand();
			
			ProcessBuilder processBuilder = new ProcessBuilder(command).directory(directory);
			Process process = processBuilder.redirectErrorStream(true).start();
			String message = readProcessInputStream(process);
			process.waitFor();
			
			if (process.exitValue() != 0) {
				throw new RuntimeException("Compilation failed (exit status " + process.exitValue() + "):\n" + message);
			}
		} catch (Error e) {
			throw e;
		} catch (RuntimeException e) {
			throw e;
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			try {
				ResourcesPlugin.getWorkspace().getRoot().refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
			} catch (CoreException e) {
				throw new RuntimeException(e);
			}
		}
	}

	/**
	 * @return
	 */
	private void copyFilesFromBundleToFolder() {
		IPath targetPath = getTargetPath();
		List<String> testDataFiles = new ArrayList<String>();
		getTestDataFiles(testDataFiles);
		for (String file : testDataFiles) {
			copyFileFromBundleToFolder(file, targetPath);
		}
	}

	private String readProcessInputStream(Process process) throws IOException {
		Reader reader = new InputStreamReader(process.getInputStream());
		char[] buffer = new char[4096];
		int count;
		StringBuilder message = new StringBuilder();
		while ((count = reader.read(buffer)) != -1) {
			message.append(buffer, 0, count);
		}
		return message.toString();
	}

	protected List<String> createCommand() {
		String gTestDirectory = getGTestDirectory();
		
		List<String> includes = new ArrayList<String>();
		getIncludes(includes);
		
		List<String> sourceFiles = new ArrayList<String>();
		getSourceFiles(sourceFiles);
		
		List<String> command = new ArrayList<String>();
		command.add(getCompilerCommand());
		command.add("-o");
		command.add(getFileName(getTestProgram()));
		command.add("-I" + gTestDirectory + "/include");
		for (String include : includes) {
			command.add("-I" + include);
		}
		command.add("-L" + gTestDirectory);
		for (String sourceFile : sourceFiles) {
			command.add(sourceFile);
		}
		command.add("-lgtest");
		command.add("-lgtest_main");
		command.add("-pthread");
		return command;
	}

	/**
	 * @return
	 */
	protected String getCompilerCommand() {
		return "g++";
	}

	/**
	 * @return
	 */
	private String getGTestDirectory() {
		String gTestDirectory = System.getenv("GTEST_DIR");
		if (gTestDirectory == null) {
			throw new RuntimeException("GTEST_DIR environment variable not set");
		}
		return gTestDirectory;
	}

	protected String getFileName(String path) {
		return new Path(path).lastSegment();
	}
	
	protected IPath getTargetPath() {
		return new Path(getTestProgram()).removeLastSegments(1);
	}
	
	protected void getIncludes(Collection<String> includes) {
	}
	
	protected void getSourceFiles(Collection<String> files) {
		files.add(getFileName(getTestSourceFile()));
	}
	
	protected String getTestSourceFile() {
		return getClass().getAnnotation(GTest.class).sourceFile();
	}
	
	protected void getTestDataFiles(Collection<String> files) {
		files.add(getTestSourceFile());
	}

	protected String getTestProgram() {
		return getClass().getAnnotation(GTest.class).program();
	}

	protected void copyFileFromBundleToFolder(String sourcePath, String targetPath) {
		copyFileFromBundleToFolder(new Path(sourcePath), new Path(targetPath));
	}

	protected void copyFileFromBundleToFolder(String sourcePath, IPath targetPath) {
		copyFileFromBundleToFolder(new Path(sourcePath), targetPath);
	}

	protected void copyFileFromBundleToFolder(IPath sourcePath, IPath targetPath) {
		String fileName = sourcePath.lastSegment();
		copyFileFromBundle(sourcePath, targetPath.append(fileName));
	}

	protected void copyFileFromBundle(String sourcePath, String targetPath) {
		copyFileFromBundle(sourcePath, new Path(targetPath));
	}

	protected void copyFileFromBundle(String sourcePath, IPath targetPath) {
		copyFileFromBundle(new Path(sourcePath), targetPath);
	}

	protected void copyFileFromBundle(IPath sourcePath, IPath targetPath) {
		try {
			InputStream is = FileLocator.openStream(getTestBundle(), sourcePath, false);
			createFile(targetPath, is);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	protected Bundle getTestBundle() {
		return FrameworkUtil.getBundle(getClass());
	}

	protected void copyFileFromBundle(String sourcePath, IFile targetFile) {
		copyFileFromBundle(new Path(sourcePath), targetFile);
	}

	protected void copyFileFromBundle(IPath sourcePath, IFile targetFile) {
		try {
			InputStream is = FileLocator.openStream(getTestBundle(), sourcePath, false);
			createFile(targetFile, is);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	protected void createFile(String path, InputStream source) {
		createFile(new Path(path), source);
	}
	
	protected void createFile(IPath path, InputStream source) {
		IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(path);
		createFile(file, source);
	}
	
	protected void createFile(IFile file, InputStream source) {
		ensureContainerExists(file.getParent());
		try {
			if (file.exists()) {
				file.setContents(source, true, false, new NullProgressMonitor());
			} else {
				file.create(source, true, new NullProgressMonitor());
			}
		} catch (CoreException e) {
			throw new RuntimeException(e);
		}
	}
	
	protected IFolder getFolder(String path) {
		return ensureContainerExists(ResourcesPlugin.getWorkspace().getRoot().getFolder(new Path(path)));
	}

	protected IFolder getFolder(IPath path) {
		return ensureContainerExists(ResourcesPlugin.getWorkspace().getRoot().getFolder(path));
	}

	protected <T extends IContainer> T ensureContainerExists(T container) {
		IProgressMonitor monitor = new NullProgressMonitor();
		IProject project = container.getProject();
		if (project.exists()) {
			if (!project.isOpen()) {
				throw new RuntimeException("Project " + project.getName() + " closed");
			}
		} else {
			try {
				project.create(monitor);
				project.open(monitor);
			} catch (CoreException e) {
				throw new RuntimeException(e);
			}
		}
		if (container instanceof IFolder) {
			doEnsureFolderExists((IFolder) container, monitor);
		}
		return container;
	}
	
	private void doEnsureFolderExists(IFolder folder, IProgressMonitor monitor) {
		if (!folder.exists()) {
			if (!folder.getParent().exists() && folder.getParent() instanceof IFolder) {
				doEnsureFolderExists((IFolder) folder.getParent(), monitor);
			}
			try {
				folder.create(true, true, monitor);
			} catch (CoreException e) {
				throw new RuntimeException(e);
			}
		}
	}

}
