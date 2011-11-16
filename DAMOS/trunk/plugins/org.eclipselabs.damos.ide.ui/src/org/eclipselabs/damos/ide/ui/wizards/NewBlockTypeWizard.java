package org.eclipselabs.damos.ide.ui.wizards;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.dialogs.WizardNewFileCreationPage;

public class NewBlockTypeWizard extends AbstractNewFileWizard {
	
	private WizardNewFileCreationPage newFileCreationPage;
	
	private static final String CONTENTS = 
			"blockType org::example::MyBlockType\n\n" +
			"input x\n" +
			"output y\n\n" +
			"parameter gain = 1\n\n" +
			"behavior {\n\n" +
			"\tfunc main<gain>(x) -> y {\n" +
			"\t\tcheck<1>(real) -> real\n\n" +		
			"\t\tstatic assert gain is real() :\n" +
			"\t\t\terror \"Gain must be real value\"\n\n" +
			"\t\tstatic assert x is real() :\n" +
			"\t\t\terror \"X must be real value\"\n\n" +
			"\t\teq y = gain * x\n" +
			"\t}\n\n" +
			"}\n";
	
	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		super.init(workbench, selection);
		setWindowTitle("New Block Type");
	}
	
	/**
	 * @return the newFileCreationPage
	 */
	public WizardNewFileCreationPage getNewFileCreationPage() {
		return newFileCreationPage;
	}
	
	/**
	 * @return the contents
	 */
	public String getContents() {
		return CONTENTS;
	}

	public void addPages() {
		super.addPages();
		newFileCreationPage = new WizardNewFileCreationPage("New Block Type", getSelection());
		newFileCreationPage.setTitle("Create a Block Type");
		newFileCreationPage.setDescription("Enter block type file name.");
		newFileCreationPage.setFileName("Unnamed");
		newFileCreationPage.setFileExtension("blocktype");
		ensureUniqueFileName();
		addPage(newFileCreationPage);
	}
	
}
