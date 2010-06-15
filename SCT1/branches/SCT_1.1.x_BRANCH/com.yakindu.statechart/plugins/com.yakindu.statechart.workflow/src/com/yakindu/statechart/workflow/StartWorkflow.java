package com.yakindu.statechart.workflow;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.mwe.core.WorkflowRunner;
import org.eclipse.emf.mwe.core.monitor.NullProgressMonitor;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.MessageConsole;
import org.eclipse.ui.console.MessageConsoleStream;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;

import com.google.inject.Injector;
import com.yakindu.statechart.WorkflowStandaloneSetup;

public class StartWorkflow {

	final static String C_CODEGENERATOR = "../com.yakindu.statechart.codegenerator.c/src/com/yakindu/statechart/codegenerator/c/workflow/";
	final static String JAVA_CODEGENERATOR = "../com.yakindu.statechart.codegenerator.java/src/com/yakindu/statechart/codegenerator/java/workflow/";

	private IContainer projectPath;
	private IFile workflowFile;
	private Shell shell;

	private List<Model> models;
	private Target target;
	private TargetPlatform targetPlatform;

	// Hack 1
	// This hack is needed cause the oaw-project stores the outstreams in
	// background and will not find the new PrintStream.
	// The PrintStreams have not to close after Task ends. (look @ Part2)
	static private PrintStream outStream;
	static private PrintStream errStream;

	public StartWorkflow(Shell shell, IFile file) {
		projectPath = file.getProject();
		workflowFile = file;
		this.shell = shell;
	}

	public void start() {
		parseFile();
		String consoleTitel = "Code Generation";

		// Redirect output of WorkflowRunner to local console.
		IConsole[] consoles = ConsolePlugin.getDefault().getConsoleManager()
				.getConsoles();
		MessageConsole console = null;

		for (int i = 0; i < consoles.length; i++) {
			if (consoles[i].getName().equals(consoleTitel)) {
				console = (MessageConsole) consoles[i];
			}
		}

		// Create new instance of MessageConsole if there is no active console.
		if (console == null) {
			console = new MessageConsole(consoleTitel, null);
			ConsolePlugin.getDefault().getConsoleManager().addConsoles(
					new IConsole[] { console });
		}

		ConsolePlugin.getDefault().getConsoleManager().showConsoleView(console);

		// Store old and set new PrintStreams.
		final PrintStream oldOut = System.out;
		final PrintStream oldErr = System.err;

		if (outStream == null) {
			final MessageConsoleStream stream = console.newMessageStream();
			outStream = new PrintStream(stream);
			errStream = new PrintStream(stream);
		}
		System.setOut(outStream);
		System.setErr(errStream);

		// Run the WorkflowRunner for each model
		if (models.size() >= 1 && target.getTarget() != null
				&& targetPlatform != null) {

			ProgressMonitorDialog dialog = new ProgressMonitorDialog(shell);
			try {
				dialog.run(true, false, new IRunnableWithProgress() {

					@Override
					public void run(IProgressMonitor monitor)
							throws InvocationTargetException,
							InterruptedException {
						monitor.beginTask("Generade code for "
								+ models.size()
								+ ((models.size() == 1) ? " model."
										: " models."), models.size());

						// Generate code for each model
						for (Model model : models) {
							generateModel(monitor, model);
						}

						try {
							projectPath.refreshLocal(IResource.DEPTH_INFINITE,
									null);
						} catch (CoreException e) {
							throw new RuntimeException(e);
						}

						// Set the console to the stored one.
						System.setOut(oldOut);
						System.setErr(oldErr);
						
						// Hack 1 - Part2
						// outStream.close();
						// errStream.close();
						monitor.done();
					}

					/**
					 * Defines the correct generator for the platform, set
					 * properties and run the WorkflowRunner.
					 * 
					 * @param monitor
					 * @param model
					 */
					private void generateModel(IProgressMonitor monitor,
							Model model) {
						monitor
								.subTask("Generate code for "
										+ model.getModel());

						String generator = "generate_";
						String workflowFile = null;

						if (targetPlatform.getTargetplatform().contains("java")) {
							generator += getJavaWorkflowName(targetPlatform
									.getTargetplatform())
									+ ((targetPlatform.isDefensive()) ? "_defensive"
											: "") + ".oaw";
							workflowFile = JAVA_CODEGENERATOR + generator;
						} else if (targetPlatform.getTargetplatform().equals(
								"c")) {
							generator += targetPlatform.getTargetplatform()
									+ ".oaw";
							workflowFile = C_CODEGENERATOR + generator;
						}

						// Set properties and run the WorkflowRunner
						Map<String, String> properties = new HashMap<String, String>();
						properties.put("model", projectPath.getLocationURI()
								+ "/" + model.getModel());
						properties.put("src-gen", projectPath.getLocation()
								+ "/" + target.getTarget());

						new WorkflowRunner().run(workflowFile,
								new NullProgressMonitor(), properties,
								new HashMap<String, Object>());

						monitor.worked(1);
					}
				});
			} catch (InvocationTargetException e) {
				throw new RuntimeException(e);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		}
	}

	/**
	 * Creates a Workflow-Object from a workflow-file and save its values to
	 * models, target and targetPlatform.
	 */
	private void parseFile() {
		Injector injector = new WorkflowStandaloneSetup()
				.createInjectorAndDoEMFRegistration();
		XtextResourceSet resourceSet = injector
				.getInstance(XtextResourceSet.class);
		resourceSet.addLoadOption(XtextResource.OPTION_RESOLVE_ALL,
				Boolean.TRUE);

		Resource resource = resourceSet.createResource(URI
				.createURI("dummy:/example.workflow"));
		InputStream in = null;

		try {
			in = new FileInputStream(workflowFile.getLocation().toFile());
			resource.load(in, resourceSet.getLoadOptions());
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		Workflow workflow = (Workflow) resource.getContents().get(0);
		models = workflow.getModels();
		target = workflow.getTarget();
		targetPlatform = workflow.getPlatform();
	}

	/**
	 * Mapping the java-versions to the workflows' filenames.
	 * 
	 * @param targetPlatform
	 * @return
	 */
	private String getJavaWorkflowName(String targetPlatform) {
		String newTargetPlatform = null;
		if (targetPlatform.equals("java")) {
			newTargetPlatform = "java";
		} else if (targetPlatform.equals("javame")) {
			newTargetPlatform = "java_me";
		} else if (targetPlatform.equals("lejos")) {
			newTargetPlatform = "java_lejos";
		}
		return newTargetPlatform;
	}

	public List<Model> getModels() {
		return models;
	}

	public Target getTarget() {
		return target;
	}

	public TargetPlatform getTargetPlatform() {
		return targetPlatform;
	}
}
