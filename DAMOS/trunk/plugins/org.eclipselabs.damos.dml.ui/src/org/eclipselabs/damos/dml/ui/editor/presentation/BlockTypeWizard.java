/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.dml.ui.editor.presentation;


import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.edit.ui.provider.ExtendedImageRegistry;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.ui.dialogs.WizardNewFileCreationPage;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.part.ISetSelectionTarget;
import org.eclipselabs.damos.dml.BlockType;
import org.eclipselabs.damos.dml.DMLFactory;
import org.eclipselabs.damos.dml.registry.BlockFamilyRegistry;
import org.eclipselabs.damos.dml.registry.IBlockFamilyDescriptor;
import org.eclipselabs.damos.dml.ui.DMLUIPlugin;


/**
 * This is a simple wizard for creating a new model file.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated NOT
 */
public class BlockTypeWizard extends Wizard implements INewWizard {
	/**
	 * The supported extensions for created files.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<String> FILE_EXTENSIONS =
		Collections.unmodifiableList(Arrays.asList(DMLUIPlugin.INSTANCE.getString("_UI_BlockTypeEditorFilenameExtensions").split("\\s*,\\s*")));

	/**
	 * A formatted list of supported file extensions, suitable for display.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String FORMATTED_FILE_EXTENSIONS =
		DMLUIPlugin.INSTANCE.getString("_UI_BlockTypeEditorFilenameExtensions").replaceAll("\\s*,\\s*", ", ");

	/**
	 * This is the file creation page.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BlockTypeModelWizardNewFileCreationPage newFileCreationPage;
	
	private BlockTypeWizardBlockFamilySelectionPage blockFamilySelectionPage;

	/**
	 * Remember the selection during initialization for populating the default container.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IStructuredSelection selection;

	/**
	 * Remember the workbench during initialization.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IWorkbench workbench;

	/**
	 * This just records the information.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.workbench = workbench;
		this.selection = selection;
		setWindowTitle(DMLUIPlugin.INSTANCE.getString("_UI_Wizard_label"));
		setDefaultPageImageDescriptor(ExtendedImageRegistry.INSTANCE.getImageDescriptor(DMLUIPlugin.INSTANCE.getImage("full/wizban/NewBlockType")));
	}

	/**
	 * Create a new model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EObject createInitialModel() {
		IBlockFamilyDescriptor blockFamily = blockFamilySelectionPage.getBlockFamily();
		BlockType blockType;
		if (blockFamily.getBlockTypeFactory() != null) {
			blockType = blockFamily.getBlockTypeFactory().createBlockType();
		} else {
			blockType = DMLFactory.eINSTANCE.createBlockType();
		}
		blockType.setFamilyId(blockFamily.getId());
		return blockType;
	}

	/**
	 * Do the work after everything is specified.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean performFinish() {
		try {
			// Remember the file.
			//
			final IFile modelFile = getModelFile();

			// Do the work within an operation.
			//
			WorkspaceModifyOperation operation =
				new WorkspaceModifyOperation() {
					@Override
					protected void execute(IProgressMonitor progressMonitor) {
						try {
							// Create a resource set
							//
							ResourceSet resourceSet = new ResourceSetImpl();

							// Get the URI of the model file.
							//
							URI fileURI = URI.createPlatformResourceURI(modelFile.getFullPath().toString(), true);

							// Create a resource for this file.
							//
							Resource resource = resourceSet.createResource(fileURI);

							// Add the initial model object to the contents.
							//
							EObject rootObject = createInitialModel();
							if (rootObject != null) {
								resource.getContents().add(rootObject);
							}

							// Save the contents of the resource to the file system.
							//
							Map<Object, Object> options = new HashMap<Object, Object>();
							options.put(XMLResource.OPTION_ENCODING, "UTF-8");
							resource.save(options);
						}
						catch (Exception exception) {
							DMLUIPlugin.INSTANCE.log(exception);
						}
						finally {
							progressMonitor.done();
						}
					}
				};

			getContainer().run(false, false, operation);

			// Select the new file resource in the current view.
			//
			IWorkbenchWindow workbenchWindow = workbench.getActiveWorkbenchWindow();
			IWorkbenchPage page = workbenchWindow.getActivePage();
			final IWorkbenchPart activePart = page.getActivePart();
			if (activePart instanceof ISetSelectionTarget) {
				final ISelection targetSelection = new StructuredSelection(modelFile);
				getShell().getDisplay().asyncExec
					(new Runnable() {
						 public void run() {
							 ((ISetSelectionTarget)activePart).selectReveal(targetSelection);
						 }
					 });
			}

			// Open an editor on the new file.
			//
			try {
				page.openEditor
					(new FileEditorInput(modelFile),
					 workbench.getEditorRegistry().getDefaultEditor(modelFile.getFullPath().toString()).getId());
			}
			catch (PartInitException exception) {
				MessageDialog.openError(workbenchWindow.getShell(), DMLUIPlugin.INSTANCE.getString("_UI_OpenEditorError_label"), exception.getMessage());
				return false;
			}

			return true;
		}
		catch (Exception exception) {
			DMLUIPlugin.INSTANCE.log(exception);
			return false;
		}
	}

	/**
	 * This is the one page of the wizard.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public class BlockTypeModelWizardNewFileCreationPage extends WizardNewFileCreationPage {
		/**
		 * Pass in the selection.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public BlockTypeModelWizardNewFileCreationPage(String pageId, IStructuredSelection selection) {
			super(pageId, selection);
		}

		/**
		 * The framework calls this to see if the file is correct.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated NOT
		 */
		@Override
		protected boolean validatePage() {
			if (super.validatePage()) {
				String extension = FILE_EXTENSIONS.get(0) + "." + DMLUIPlugin.INSTANCE.getString("_UI_DMLEditorFilenameExtension");
				if (!getFileName().endsWith(extension)) {
					String key = FILE_EXTENSIONS.size() > 1 ? "_WARN_FilenameExtensions" : "_WARN_FilenameExtension";
					setErrorMessage(DMLUIPlugin.INSTANCE.getString(key, new Object [] { extension }));
					return false;
				}
				return true;
			}
			return false;
		}

		/**
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public IFile getModelFile() {
			return ResourcesPlugin.getWorkspace().getRoot().getFile(getContainerFullPath().append(getFileName()));
		}
	}

	private static class BlockTypeWizardBlockFamilySelectionPage extends WizardPage {

		private ComboViewer blockFamilyViewer;
		
		/**
		 * 
		 */
		public BlockTypeWizardBlockFamilySelectionPage() {
			super("Block Family Selection");
		}
		
		public void createControl(Composite parent) {
			initializeDialogUnits(parent);
			
			// top level group
			Composite topLevel = new Composite(parent, SWT.NONE);
			GridLayout gridLayout = new GridLayout(2, false);
			topLevel.setLayout(gridLayout);
			topLevel.setLayoutData(new GridData(GridData.VERTICAL_ALIGN_FILL | GridData.HORIZONTAL_ALIGN_FILL));
			topLevel.setFont(parent.getFont());

			Label label = new Label(topLevel, SWT.NONE);
			label.setText("Block Family:");
			label.setLayoutData(new GridData());
			
			blockFamilyViewer = new ComboViewer(topLevel, SWT.SINGLE | SWT.BORDER | SWT.READ_ONLY);
			blockFamilyViewer.getCombo().setLayoutData(new GridData(GridData.FILL, GridData.BEGINNING, true, false));
			blockFamilyViewer.setLabelProvider(new LabelProvider() {
				
				/* (non-Javadoc)
				 * @see org.eclipse.jface.viewers.LabelProvider#getText(java.lang.Object)
				 */
				@Override
				public String getText(Object element) {
					if (element instanceof IBlockFamilyDescriptor) {
						return ((IBlockFamilyDescriptor) element).getName();
					}
					return super.getText(element);
				}
				
			});
			blockFamilyViewer.setContentProvider(new ArrayContentProvider());
			blockFamilyViewer.setInput(BlockFamilyRegistry.getInstance().getBlockFamilies());
			blockFamilyViewer.addSelectionChangedListener(new ISelectionChangedListener() {
				
				public void selectionChanged(SelectionChangedEvent event) {
					updatePageComplete();
				}
				
			});
			
			setErrorMessage(null);
			setMessage(null);

			setControl(topLevel);
			
			updatePageComplete();
		}
		
		/* (non-Javadoc)
		 * @see org.eclipse.jface.dialogs.DialogPage#setVisible(boolean)
		 */
		@Override
		public void setVisible(boolean visible) {
			if (visible) {
				Combo combo = blockFamilyViewer.getCombo();
				if (combo.getSelectionIndex() == -1) {
					combo.select(0);
					updatePageComplete();
				}
			}
			super.setVisible(visible);
		}

		/**
		 * @return
		 */
		public IBlockFamilyDescriptor getBlockFamily() {
			return (IBlockFamilyDescriptor) ((IStructuredSelection) blockFamilyViewer.getSelection()).getFirstElement();
		}

		/**
		 * 
		 */
		private void updatePageComplete() {
			setErrorMessage(null);
			setPageComplete(true);

			if (!(getBlockFamily() instanceof IBlockFamilyDescriptor)) {
				setPageComplete(false);
				return;
			}
		}
		
	}
	
	/**
	 * The framework calls this to create the contents of the wizard.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
		@Override
	public void addPages() {
		// Create a page, set the title, and the initial model file name.
		//
		newFileCreationPage = new BlockTypeModelWizardNewFileCreationPage("Whatever", selection);
		newFileCreationPage.setTitle(DMLUIPlugin.INSTANCE.getString("_UI_BlockTypeModelWizard_label"));
		newFileCreationPage.setDescription(DMLUIPlugin.INSTANCE.getString("_UI_BlockTypeModelWizard_description"));
		newFileCreationPage.setFileName(DMLUIPlugin.INSTANCE.getString("_UI_BlockTypeEditorFilenameDefaultBase") + "." + FILE_EXTENSIONS.get(0));
		addPage(newFileCreationPage);
		
		blockFamilySelectionPage = new BlockTypeWizardBlockFamilySelectionPage();
		blockFamilySelectionPage.setTitle("Block Family");
		blockFamilySelectionPage.setDescription("Specify the block family of the new block type");
		addPage(blockFamilySelectionPage);

		// Try and get the resource selection to determine a current directory for the file dialog.
		//
		if (selection != null && !selection.isEmpty()) {
			// Get the resource...
			//
			Object selectedElement = selection.iterator().next();
			if (selectedElement instanceof IResource) {
				// Get the resource parent, if its a file.
				//
				IResource selectedResource = (IResource)selectedElement;
				if (selectedResource.getType() == IResource.FILE) {
					selectedResource = selectedResource.getParent();
				}

				// This gives us a directory...
				//
				if (selectedResource instanceof IFolder || selectedResource instanceof IProject) {
					// Set this for the container.
					//
					newFileCreationPage.setContainerFullPath(selectedResource.getFullPath());

					// Make up a unique new name here.
					//
					String defaultDMLFilenameExtension = DMLUIPlugin.INSTANCE.getString("_UI_DMLEditorFilenameExtension");
					String defaultModelBaseFilename = DMLUIPlugin.INSTANCE.getString("_UI_BlockTypeEditorFilenameDefaultBase");
					String defaultModelFilenameExtension = FILE_EXTENSIONS.get(0);
					String modelFilename = defaultModelBaseFilename + "." + defaultModelFilenameExtension + "." + defaultDMLFilenameExtension;
					for (int i = 1; ((IContainer)selectedResource).findMember(modelFilename) != null; ++i) {
						modelFilename = defaultModelBaseFilename + i + "." + defaultModelFilenameExtension + "." + defaultDMLFilenameExtension;;
					}
					newFileCreationPage.setFileName(modelFilename);
				}
			}
		}
	}

	/**
	 * Get the file from the page.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IFile getModelFile() {
		return newFileCreationPage.getModelFile();
	}

}
