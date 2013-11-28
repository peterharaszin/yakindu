package com.yakindu.statechart.wizards;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.ContainerSelectionDialog;
import org.eclipse.ui.dialogs.ElementTreeSelectionDialog;
import org.eclipse.ui.model.WorkbenchContentProvider;
import org.eclipse.ui.model.WorkbenchLabelProvider;

/**
 * This wizardpage collects the parameter to create the workflow-file with
 * values.
 * 
 * @author lass
 * 
 */
public class FillNewFileWizardPage extends WizardPage {

	private Text modelName;
	private Text targetFolder;
	private List targetPlatform;
	private Button defensive;

	private NewFileWizardPage newFileWizardPage;

	public FillNewFileWizardPage(NewFileWizardPage newFileWizardPage) {
		super("wizardPage");
		this.newFileWizardPage = newFileWizardPage;

		setTitle("Fill Workflowfile");
		setDescription("Please choose a model which you want to transform, "
				+ "a targetfolder where you will find the generated files and "
				+ "the platformspezifications.");
	}

	/**
	 * This method creates the form for the required elements of the
	 * .workflow-file.
	 */
	@Override
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NULL);
		GridLayout layout = new GridLayout();
		container.setLayout(layout);
		layout.numColumns = 3;
		layout.verticalSpacing = 9;

		/**
		 * Model-region
		 */
		Label label = new Label(container, SWT.NULL);
		label.setText("&Model:");
		modelName = new Text(container, SWT.BORDER | SWT.SINGLE);
		modelName.setEditable(false);
		GridData gd = new GridData(GridData.FILL_HORIZONTAL);
		modelName.setLayoutData(gd);

		Button button = new Button(container, SWT.PUSH);
		button.setText("Browse...");
		button.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				handleBrowseModelFile();
			}
		});

		/**
		 * TargetFolder-region
		 */
		Label label2 = new Label(container, SWT.NULL);
		label2.setText("&TargetFolder:");
		targetFolder = new Text(container, SWT.BORDER | SWT.SINGLE);
		targetFolder.setEditable(false);
		GridData gd2 = new GridData(GridData.FILL_HORIZONTAL);
		targetFolder.setLayoutData(gd2);

		Button button2 = new Button(container, SWT.PUSH);
		button2.setText("Browse...");
		button2.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				handleBrowseTargetFolder();
			}
		});

		/**
		 * Platform-region
		 */
		Label label3 = new Label(container, SWT.NULL);
		label3.setText("&Platform:");
		targetPlatform = new List(container, SWT.PUSH);
		targetPlatform.add("C");
		targetPlatform.add("Java");
		targetPlatform.add("Javame");
		targetPlatform.add("lejos");
		targetPlatform.setSelection(1);
		GridData gd3 = new GridData(GridData.FILL_HORIZONTAL);
		targetPlatform.setLayoutData(gd3);

		defensive = new Button(container, SWT.CHECK);
		defensive.setText("Defensive");
		GridData gd4 = new GridData(GridData.FILL_HORIZONTAL);
		defensive.setLayoutData(gd4);

		setControl(container);
	}

	/**
	 * Handler to select a statemachine-Model.
	 */
	private void handleBrowseModelFile() {
		ElementTreeSelectionDialog dialog = new ElementTreeSelectionDialog(
				getShell(), new WorkbenchLabelProvider(),
				new WorkbenchContentProvider());

		IProject project = ResourcesPlugin.getWorkspace().getRoot().getFolder(
				newFileWizardPage.getContainerFullPath()).getProject();
		dialog.setInput(project);
		dialog.addFilter(new ViewerFilter() {

			@Override
			public boolean select(Viewer viewer, Object parentElement,
					Object element) {
				if (element instanceof IFolder) {
					return true;
				} else if (element instanceof IFile) {
					IFile file = (IFile) element;
					if (file.getFileExtension().equals("statemachine")) {
						return true;
					}
				}
				return false;
			}
		});

		if (dialog.open() == ContainerSelectionDialog.OK) {
			Object[] result = dialog.getResult();
			if (result.length == 1) {
				modelName.setText(((IFile) result[0]).getProjectRelativePath()
						.toString());
			}
		}
	}

	/**
	 * Handler to select the TargetFolder.
	 */
	private void handleBrowseTargetFolder() {

		ContainerSelectionDialog dialog = new ContainerSelectionDialog(
				getShell(), ResourcesPlugin.getWorkspace().getRoot().getFolder(
						newFileWizardPage.getContainerFullPath()), false,
				"Select new file container");
		if (dialog.open() == ContainerSelectionDialog.OK) {
			Object[] result = dialog.getResult();
			if (result.length == 1) {
				targetFolder.setText(ResourcesPlugin.getWorkspace().getRoot()
						.getFolder((Path) result[0]).getProjectRelativePath()
						.toString());
			}
		}
	}

	public String getModelNameText() {
		return modelName.getText();
	}

	public String getTargetFolderText() {
		return targetFolder.getText();
	}

	public String getTargetPlatformText() {
		return targetPlatform.getSelection()[0];
	}

	public boolean isDefensive() {
		return defensive.getSelection();
	}
}
