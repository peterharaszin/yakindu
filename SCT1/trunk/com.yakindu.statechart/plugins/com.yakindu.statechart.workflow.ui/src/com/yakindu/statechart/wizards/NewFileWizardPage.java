package com.yakindu.statechart.wizards;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.dialogs.WizardNewFileCreationPage;

/**
 * This wizardpage will be use for setting the new filename and folder.
 * @author lass
 *
 */
public class NewFileWizardPage extends WizardNewFileCreationPage {

	public NewFileWizardPage(IStructuredSelection selection) {
		super("NewConfigFileWizardPage", selection);
		
		setTitle("WorkflowFile");
		setDescription("Creates a new Workflowfile.");
		setFileExtension("workflow");
		setFileName("my.workflow");
	}

}
