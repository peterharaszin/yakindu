package com.yakindu.statechart.workflow.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.List;

import junit.framework.TestCase;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.NullProgressMonitor;

import com.yakindu.statechart.workflow.Model;
import com.yakindu.statechart.workflow.StartWorkflow;
import com.yakindu.statechart.workflow.Target;
import com.yakindu.statechart.workflow.TargetPlatform;

public class TestStartWorkflow extends TestCase {

	final static String RESOURCEFOLDER = "resources";

	private IProject project;

	@Override
	protected void setUp() throws Exception {
		super.setUp();

		/**
		 * Create files for testworkspace
		 */

		// Project and folder
		ResourcesPlugin.getWorkspace().getRoot().getProject("test").create(
				new NullProgressMonitor());
		project = ResourcesPlugin.getWorkspace().getRoot().getProject("test");
		project.open(new NullProgressMonitor());
		project.getFolder("src").create(true, true, new NullProgressMonitor());
		project.getFolder("model")
				.create(true, true, new NullProgressMonitor());
		project.getFolder("src-gen").create(true, true,
				new NullProgressMonitor());
		project.getFolder("src-gen2").create(true, true,
				new NullProgressMonitor());
		project.getFolder("src-gen3").create(true, true,
				new NullProgressMonitor());

		// Workflows
		File workflowFile = new File(RESOURCEFOLDER + "/testJava.workflow");
		InputStream workflowInputStream = new FileInputStream(workflowFile);
		project.getFolder("src").getFile("testJava.workflow").create(
				workflowInputStream, true, new NullProgressMonitor());

		workflowFile = new File(RESOURCEFOLDER + "/testJavaMeDef.workflow");
		workflowInputStream = new FileInputStream(workflowFile);
		project.getFolder("src").getFile("testJavaMeDef.workflow").create(
				workflowInputStream, true, new NullProgressMonitor());

		workflowFile = new File(RESOURCEFOLDER + "/testC.workflow");
		workflowInputStream = new FileInputStream(workflowFile);
		project.getFolder("src").getFile("testC.workflow").create(
				workflowInputStream, true, new NullProgressMonitor());

		// Models
		File modelFile = new File(RESOURCEFOLDER + "/Tresor.statemachine");
		InputStream modelInputStream = new FileInputStream(modelFile);
		project.getFolder("model").getFile("Tresor.statemachine").create(
				modelInputStream, true, new NullProgressMonitor());

		modelFile = new File(RESOURCEFOLDER + "/test.statemachine");
		modelInputStream = new FileInputStream(modelFile);
		project.getFolder("model").getFile("test.statemachine").create(
				modelInputStream, true, new NullProgressMonitor());
	}

	/**
	 * Testing the private method getJavaWorkflowName in StartWorkflow.java.
	 * 
	 * @throws Exception
	 */
	public void testGetJavaWorkflowName() throws Exception {
		IFile file = project.getFile("src/testJava.workflow");
		StartWorkflow workflow = new StartWorkflow(null, file);

		Method m = StartWorkflow.class.getDeclaredMethod("getJavaWorkflowName",
				String.class);
		m.setAccessible(true);
		String actualJava = (String) m.invoke(workflow, "java");
		String actualJavaMe = (String) m.invoke(workflow, "javame");
		String actualJavaLejos = (String) m.invoke(workflow, "lejos");
		String actualFail = (String) m.invoke(workflow, "notSupportedString");

		assertEquals("java", actualJava);
		assertEquals("java_me", actualJavaMe);
		assertEquals("java_lejos", actualJavaLejos);
		assertEquals(null, actualFail);
	}

	/**
	 * Testing the Java-Workflow.
	 */
	public void testJavaWorkflow() {
		IFile file = project.getFile("src/testJava.workflow");

		StartWorkflow workflow = new StartWorkflow(null, file);
		workflow.start();

		List<Model> models = workflow.getModels();
		assertEquals(2, models.size());
		assertEquals("model/Tresor.statemachine", models.get(0).getModel());

		Target target = workflow.getTarget();
		assertEquals("src-gen", target.getTarget());

		TargetPlatform targetPlatform = workflow.getTargetPlatform();
		assertEquals("java", targetPlatform.getTargetplatform());
		assertEquals(false, targetPlatform.isDefensive());

		assertEquals(true, project.getFolder("src-gen/tresor").exists());
		assertEquals(true, project.getFolder("src-gen/tresor").getFile(
				"TresorStatechart.java").exists());

	}

	/**
	 * Testing the Javame-defensive-Workflow.
	 */
	public void testJavaMeDefWorkflow() {
		IFile file = project.getFile("src/testJavaMeDef.workflow");

		StartWorkflow workflow = new StartWorkflow(null, file);
		workflow.start();

		TargetPlatform targetPlatform = workflow.getTargetPlatform();
		assertEquals("javame", targetPlatform.getTargetplatform());
		assertEquals(true, targetPlatform.isDefensive());
	}

	/**
	 * Testing the C-Workflow
	 */
	public void testCWorkflow() {
		IFile file = project.getFile("src/testC.workflow");

		StartWorkflow workflow = new StartWorkflow(null, file);
		workflow.start();

		TargetPlatform targetPlatform = workflow.getTargetPlatform();
		assertEquals("c", targetPlatform.getTargetplatform());
		assertEquals(false, targetPlatform.isDefensive());
	}

	/**
	 * Testing the case if the workflow-file is not found.
	 */
	public void testNoneWorkflow() {
		IFile file = project.getFile("src/none.workflow");

		try {
			StartWorkflow workflow = new StartWorkflow(null, file);
			workflow.start();

			fail("Expected RuntimeException.");
		} catch (RuntimeException e) {
		}
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
		project.delete(true, new NullProgressMonitor());
	}
}
