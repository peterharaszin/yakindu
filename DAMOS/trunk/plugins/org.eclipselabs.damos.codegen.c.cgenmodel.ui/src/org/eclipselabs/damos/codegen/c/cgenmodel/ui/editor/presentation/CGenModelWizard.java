/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.codegen.c.cgenmodel.ui.editor.presentation;


import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.edit.ui.provider.ExtendedImageRegistry;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.ui.dialogs.ContainerSelectionDialog;
import org.eclipse.ui.dialogs.FilteredResourcesSelectionDialog;
import org.eclipse.ui.dialogs.WizardNewFileCreationPage;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.part.ISetSelectionTarget;
import org.eclipselabs.damos.codegen.c.cgenmodel.CGenModelFactory;
import org.eclipselabs.damos.codegen.c.cgenmodel.CGenModelPackage;
import org.eclipselabs.damos.codegen.c.cgenmodel.GenModel;
import org.eclipselabs.damos.codegen.c.cgenmodel.GenSubsystem;
import org.eclipselabs.damos.codegen.c.cgenmodel.GenSystem;
import org.eclipselabs.damos.codegen.c.cgenmodel.GenTopLevelSystem;
import org.eclipselabs.damos.codegen.c.cgenmodel.ui.CGenModelUIPlugin;
import org.eclipselabs.damos.common.ui.viewers.FragmentLabelProvider;
import org.eclipselabs.damos.common.ui.viewers.FragmentListContentProvider;
import org.eclipselabs.damos.dml.DMLPackage;
import org.eclipselabs.damos.dml.Fragment;
import org.eclipselabs.damos.dml.FragmentElement;
import org.eclipselabs.damos.dml.Subsystem;
import org.eclipselabs.damos.dml.SubsystemRealization;
import org.eclipselabs.damos.dml.System;
import org.eclipselabs.damos.dml.util.DMLUtil;
import org.eclipselabs.damos.execution.executionmodel.ExecutionModel;


/**
 * This is a simple wizard for creating a new model file.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated NOT
 */
public class CGenModelWizard extends Wizard implements INewWizard {
	/**
	 * The supported extensions for created files.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<String> FILE_EXTENSIONS =
		Collections.unmodifiableList(Arrays.asList(CGenModelUIPlugin.INSTANCE.getString("_UI_CGenModelEditorFilenameExtensions").split("\\s*,\\s*")));

	/**
	 * A formatted list of supported file extensions, suitable for display.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String FORMATTED_FILE_EXTENSIONS =
		CGenModelUIPlugin.INSTANCE.getString("_UI_CGenModelEditorFilenameExtensions").replaceAll("\\s*,\\s*", ", ");

	/**
	 * This caches an instance of the model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CGenModelPackage cGenModelPackage = CGenModelPackage.eINSTANCE;

	/**
	 * This caches an instance of the model factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CGenModelFactory cGenModelFactory = cGenModelPackage.getCGenModelFactory();

	/**
	 * This is the file creation page.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CGenModelWizardNewFileCreationPage newFileCreationPage;
	
	private CGenModelWizardExecutionModelSelectionPage executionModelSelectionPage;

	private CGenModelWizardFragmentSelectionPage fragmentSelectionPage;
	
	private CGenModelWizardDirectorySelectionPage directorySelectionPage;

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
		setWindowTitle(CGenModelUIPlugin.INSTANCE.getString("_UI_Wizard_label"));
		setDefaultPageImageDescriptor(ExtendedImageRegistry.INSTANCE.getImageDescriptor(CGenModelUIPlugin.INSTANCE.getImage("full/wizban/NewCGenModel")));
	}

	/**
	 * Create a new model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected EObject createInitialModel() {
		Set<String> usedPrefixes = new HashSet<String>();
		GenModel genModel = cGenModelFactory.createGenModel();
		
		Fragment topLevelFragment = fragmentSelectionPage.getTopLevelFragment();

		genModel.setExecutionModel(executionModelSelectionPage.getExecutionModel());
		genModel.setSourceDirectory(directorySelectionPage.getSourceDirectory());
		genModel.setHeaderDirectory(directorySelectionPage.getSourceDirectory());
		genModel.setMainSourceFile(topLevelFragment.getName() + ".c");
		genModel.setMainHeaderFile(topLevelFragment.getName() + ".h");
		
		GenTopLevelSystem genTopLevelSystem = cGenModelFactory.createGenTopLevelSystem();
		genTopLevelSystem.setFragment(topLevelFragment);
		genTopLevelSystem.setPrefix(createGenSystemPrefix(topLevelFragment.getName(), usedPrefixes));
		genModel.setGenTopLevelSystem(genTopLevelSystem);
		if (DMLUtil.isCyclic(topLevelFragment)) {
			MessageDialog.openError(getShell(), "Execution Model", "Specified fragment is cyclic. Execution model creation could not be finished.");
		} else {
			initializeGenSubsystems(genTopLevelSystem, topLevelFragment, usedPrefixes);
		}
		return genModel;
	}
	
	private void initializeGenSubsystems(GenSystem genSystem, Fragment fragment, Set<String> usedPrefixes) {
		for (FragmentElement fragmentElement : fragment.getAllFragmentElements()) {
			if (fragmentElement instanceof Subsystem) {
				Subsystem subsystem = (Subsystem) fragmentElement;
				SubsystemRealization realization = subsystem.getRealization(fragment);
				if (realization != null) {
					Fragment realizingFragment = realization.getRealizingFragment();
					GenSubsystem genSubsystem = cGenModelFactory.createGenSubsystem();
					genSubsystem.setPrefix(createGenSystemPrefix(subsystem.getName(), usedPrefixes));
					genSubsystem.setSubsystem(subsystem);
					genSystem.getGenSubsystems().add(genSubsystem);
					initializeGenSubsystems(genSubsystem, realizingFragment, usedPrefixes);
				}
			}
		}
	}
	
	private String createGenSystemPrefix(String preferredName, Set<String> usedPrefixes) {
		String prefix = preferredName;
		int i = 1;
		while (usedPrefixes.contains(prefix)) {
			prefix = preferredName + ++i;
		}
		usedPrefixes.add(prefix);
		return prefix + "_";
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
							CGenModelUIPlugin.INSTANCE.log(exception);
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
				MessageDialog.openError(workbenchWindow.getShell(), CGenModelUIPlugin.INSTANCE.getString("_UI_OpenEditorError_label"), exception.getMessage());
				return false;
			}

			return true;
		}
		catch (Exception exception) {
			CGenModelUIPlugin.INSTANCE.log(exception);
			return false;
		}
	}

	/**
	 * This is the one page of the wizard.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public class CGenModelWizardNewFileCreationPage extends WizardNewFileCreationPage {
		/**
		 * Pass in the selection.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public CGenModelWizardNewFileCreationPage(String pageId, IStructuredSelection selection) {
			super(pageId, selection);
		}

		/**
		 * The framework calls this to see if the file is correct.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		@Override
		protected boolean validatePage() {
			if (super.validatePage()) {
				String extension = new Path(getFileName()).getFileExtension();
				if (extension == null || !FILE_EXTENSIONS.contains(extension)) {
					String key = FILE_EXTENSIONS.size() > 1 ? "_WARN_FilenameExtensions" : "_WARN_FilenameExtension";
					setErrorMessage(CGenModelUIPlugin.INSTANCE.getString(key, new Object [] { FORMATTED_FILE_EXTENSIONS }));
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
	
	private static class CGenModelWizardExecutionModelSelectionPage extends WizardPage {

		private static final String EXECUTION_MODEL_FILE_EXTENSION = "executionmodel";
		
		private ExecutionModel executionModel;
		
		private LoadModelComposite loadModelComposite = new LoadModelComposite() {

			protected void resetResource() {
				executionModel = null;
			}
			
			protected void loadResource(Resource resource) {
				EList<EObject> contents = resource.getContents();
				if (contents.isEmpty()) {
					MessageDialog.openError(getShell(), getMessageDialogTitle(), "Specified resource is empty");
					return;
				}
				EObject element = contents.get(0);
				if (!(element instanceof ExecutionModel)) {
					MessageDialog.openError(getShell(), getMessageDialogTitle(), "Specified resource does not contain an execution model");
					return;
				}
				executionModel = (ExecutionModel) element;
			}

			@Override
			protected String getLabelText() {
				return "Execution model URI:";
			}

			@Override
			protected String getModelFileExtension() {
				return EXECUTION_MODEL_FILE_EXTENSION;
			}

			@Override
			protected Shell getShell() {
				return CGenModelWizardExecutionModelSelectionPage.this.getShell();
			}

			@Override
			protected String getMessageDialogTitle() {
				return "Execution Model";
			}

			@Override
			protected void updatePageComplete() {
				CGenModelWizardExecutionModelSelectionPage.this.updatePageComplete();
			}
			
		};
		
		/**
		 * 
		 */
		public CGenModelWizardExecutionModelSelectionPage() {
			super("Specify Execution Model");
		}
		
		/**
		 * @return the executionModel
		 */
		public ExecutionModel getExecutionModel() {
			return executionModel;
		}
		
		public void createControl(final Composite parent) {
			initializeDialogUnits(parent);
			
			// top level group
			Composite topLevel = new Composite(parent, SWT.NONE);
			GridLayout gridLayout = new GridLayout();
			topLevel.setLayout(gridLayout);
			topLevel.setLayoutData(new GridData(GridData.VERTICAL_ALIGN_FILL | GridData.HORIZONTAL_ALIGN_FILL));
			topLevel.setFont(parent.getFont());
			
			loadModelComposite.createControl(topLevel);

			setErrorMessage(null);
			setMessage(null);

			setControl(topLevel);
			
			updatePageComplete();
		}
		
		private void updatePageComplete() {
			setPageComplete(executionModel != null);
			setErrorMessage(null);
		}
		
	}
	
	private static class CGenModelWizardFragmentSelectionPage extends WizardPage {

		private static final String BLOCK_DIAGRAM_FILE_EXTENSION = "blockdiagram";
		
		private Fragment topLevelFragment;
		
		private ComboViewer fragmentViewer;
		
		private LoadModelComposite loadModelComposite = new LoadModelComposite() {

			protected void resetResource() {
				fragmentViewer.setInput(null);
				topLevelFragment = null;
			}
			
			protected void loadResource(Resource resource) {
				EList<EObject> contents = resource.getContents();
				if (contents.isEmpty()) {
					MessageDialog.openError(getShell(), getMessageDialogTitle(), "Specified resource is empty");
					return;
				}
				fragmentViewer.setInput(resource.getResourceSet());
				System system = (System) EcoreUtil.getObjectByType(contents, DMLPackage.eINSTANCE.getSystem());
				if (system != null) {
					fragmentViewer.setSelection(new StructuredSelection(system));
				} else {
					fragmentViewer.getCombo().select(0);
				}
				updateSelectedFragment(fragmentViewer.getSelection());
			}

			@Override
			protected String getLabelText() {
				return "Block diagram URI:";
			}

			@Override
			protected String getModelFileExtension() {
				return BLOCK_DIAGRAM_FILE_EXTENSION;
			}

			@Override
			protected Shell getShell() {
				return CGenModelWizardFragmentSelectionPage.this.getShell();
			}

			@Override
			protected String getMessageDialogTitle() {
				return "Block Diagram";
			}

			@Override
			protected void updatePageComplete() {
				CGenModelWizardFragmentSelectionPage.this.updatePageComplete();
			}
			
		};
		
		/**
		 * 
		 */
		public CGenModelWizardFragmentSelectionPage() {
			super("Specify Top-Level System Fragment");
		}
		
		/**
		 * @return the topLevelFragment
		 */
		public Fragment getTopLevelFragment() {
			return topLevelFragment;
		}
		
		public void createControl(final Composite parent) {
			initializeDialogUnits(parent);
			
			// top level group
			Composite topLevel = new Composite(parent, SWT.NONE);
			GridLayout gridLayout = new GridLayout();
			topLevel.setLayout(gridLayout);
			topLevel.setLayoutData(new GridData(GridData.VERTICAL_ALIGN_FILL | GridData.HORIZONTAL_ALIGN_FILL));
			topLevel.setFont(parent.getFont());
			
			loadModelComposite.createControl(topLevel);
			
			Label label = new Label(topLevel, SWT.NONE);
			label.setText("Select top-level fragment:");
			
			fragmentViewer = new ComboViewer(topLevel, SWT.SINGLE | SWT.BORDER | SWT.READ_ONLY);
			fragmentViewer.getCombo().setLayoutData(new GridData(GridData.FILL, GridData.BEGINNING, true, false, 2, 1));
			fragmentViewer.setLabelProvider(new FragmentLabelProvider());
			fragmentViewer.setContentProvider(new FragmentListContentProvider());
			fragmentViewer.addSelectionChangedListener(new ISelectionChangedListener() {
				
				public void selectionChanged(SelectionChangedEvent event) {
					updateSelectedFragment(event.getSelection());
				}
				
			});

			setErrorMessage(null);
			setMessage(null);

			setControl(topLevel);
			
			updatePageComplete();
		}
		
		private void updateSelectedFragment(ISelection selection) {
			if (selection instanceof IStructuredSelection) {
				IStructuredSelection structuredSelection = (IStructuredSelection) selection;
				topLevelFragment = (Fragment) structuredSelection.getFirstElement();
				updatePageComplete();
			}
		}
		
		private void updatePageComplete() {
			setPageComplete(topLevelFragment != null);
			setErrorMessage(null);
		}
		
	}
	
	private static class CGenModelWizardDirectorySelectionPage extends WizardPage {

		private Text sourceDirectoryText;
		
		/**
		 * 
		 */
		public CGenModelWizardDirectorySelectionPage() {
			super("Directory Selection");
		}
		
		public String getSourceDirectory() {
			return sourceDirectoryText.getText();
		}
		
		/* (non-Javadoc)
		 * @see org.eclipse.jface.dialogs.IDialogPage#createControl(org.eclipse.swt.widgets.Composite)
		 */
		public void createControl(Composite parent) {
			initializeDialogUnits(parent);
			
			// top level group
			Composite topLevel = new Composite(parent, SWT.NONE);
			GridLayout gridLayout = new GridLayout(3, false);
			topLevel.setLayout(gridLayout);
			topLevel.setLayoutData(new GridData(GridData.VERTICAL_ALIGN_FILL | GridData.HORIZONTAL_ALIGN_FILL));
			topLevel.setFont(parent.getFont());

			Label label = new Label(topLevel, SWT.NONE);
			label.setText("Source directory:");
			label.setLayoutData(new GridData());
			sourceDirectoryText = new Text(topLevel, SWT.SINGLE | SWT.BORDER);
			sourceDirectoryText.setLayoutData(new GridData(GridData.FILL, GridData.BEGINNING, true, false));
			sourceDirectoryText.addModifyListener(new ModifyListener() {
				
				public void modifyText(ModifyEvent e) {
					updatePageComplete();
				}
				
			});
			
			Button browseButton = new Button(topLevel, SWT.PUSH);
			browseButton.setText("Browse...");
			browseButton.addSelectionListener(new SelectionAdapter() {
				
				public void widgetSelected(SelectionEvent e) {
					ContainerSelectionDialog d = new ContainerSelectionDialog(
							getShell(),
							ResourcesPlugin.getWorkspace().getRoot(),
							false,
							null);
					d.open();
					Object[] results = d.getResult();
					if (results != null && results.length > 0 && results[0] instanceof IPath) {
						sourceDirectoryText.setText(((IPath) results[0]).toString());
					}
				}
				
			});

			setErrorMessage(null);
			setMessage(null);

			setControl(topLevel);
			
			updatePageComplete();
		}

		/**
		 * 
		 */
		private void updatePageComplete() {
			setErrorMessage(null);
			setPageComplete(true);

			String pathString = sourceDirectoryText.getText();
			if (pathString.trim().length() == 0) {
				setPageComplete(false);
				return;
			}
			
			IFolder sourceFolder = ResourcesPlugin.getWorkspace().getRoot().getFolder(new Path(pathString));
			if (!sourceFolder.isAccessible()) {
				setErrorMessage("Invalid source directory specified");
				setPageComplete(false);
			}
		}
		
	}

	private static abstract class LoadModelComposite {
		
		private Text modelURIText;
		
		private Composite modelURIComposite;
				
		public void createControl(final Composite parent) {
			GridLayout gridLayout;
			
			Composite labelComposite = new Composite(parent, SWT.NONE);
			gridLayout = new GridLayout(2, false);
			gridLayout.marginWidth = 0;
			gridLayout.marginHeight = 0;
			labelComposite.setLayout(gridLayout);
			labelComposite.setLayoutData(new GridData(GridData.FILL, GridData.BEGINNING, true, false));
			labelComposite.setFont(parent.getFont());
			
			modelURIComposite = new Composite(parent, SWT.NONE);
			gridLayout = new GridLayout(2, false);
			gridLayout.marginWidth = 0;
			gridLayout.marginHeight = 0;
			modelURIComposite.setLayout(gridLayout);
			modelURIComposite.setLayoutData(new GridData(GridData.FILL, GridData.BEGINNING, true, false));
			modelURIComposite.setFont(parent.getFont());
			
			Label label = new Label(labelComposite, SWT.NONE);
			label.setText(getLabelText());
			label.setLayoutData(new GridData(GridData.FILL, GridData.CENTER, true, false));
			
			Button browseWorkspaceButton = new Button(labelComposite, SWT.PUSH);
			browseWorkspaceButton.setText("Browse Workspace...");
			browseWorkspaceButton.addSelectionListener(new SelectionAdapter() {
				
				@Override
				public void widgetSelected(SelectionEvent e) {
					FilteredResourcesSelectionDialog d = new FilteredResourcesSelectionDialog(
							getShell(),
							false,
							ResourcesPlugin.getWorkspace().getRoot(),
							IResource.FILE);
					d.setInitialPattern("*." + getModelFileExtension());
					d.open();
					Object firstResult = d.getFirstResult();
					if (firstResult instanceof IFile) {
						URI uri = URI.createPlatformResourceURI(((IFile) firstResult).getFullPath().toString(), true);
						modelURIText.setText(uri.toString());
						updatePageComplete();
					}
				}
				
			});
			
			modelURIText = new Text(modelURIComposite, SWT.SINGLE | SWT.BORDER);
			modelURIText.setLayoutData(new GridData(GridData.FILL, GridData.BEGINNING, true, false));
			modelURIText.addModifyListener(new ModifyListener() {
				
				public void modifyText(ModifyEvent e) {
					resetResource();
					updatePageComplete();
				}
				
			});
			
			Button loadButton = new Button(modelURIComposite, SWT.PUSH);
			loadButton.setText("Load");
			loadButton.addSelectionListener(new SelectionAdapter() {
				
				@Override
				public void widgetSelected(SelectionEvent event) {
					String uriString = modelURIText.getText();
					if (uriString.trim().length() == 0) {
						MessageDialog.openError(getShell(), getMessageDialogTitle(), "No block diagram URI specified");
						return;
					}
					ResourceSet resourceSet = new ResourceSetImpl();
					URI uri = null;
					try {
						uri = URI.createURI(uriString);
					} catch (IllegalArgumentException e) {
						MessageDialog.openError(getShell(), getMessageDialogTitle(), "Invalid resource URI");
						return;
					}
					Resource resource = null;
					try {
						resource = resourceSet.getResource(uri, true);
					} catch (RuntimeException e) {
						MessageDialog.openError(getShell(), getMessageDialogTitle(), "Loading specified resource failed");
						return;
					}
					loadResource(resource);
					updatePageComplete();
				}
				
			});
		}
		
		protected abstract void resetResource();
		
		protected abstract void loadResource(Resource resource);
		
		protected abstract String getLabelText();
		
		protected abstract String getModelFileExtension();
		
		protected abstract Shell getShell();
		
		protected abstract String getMessageDialogTitle();

		protected abstract void updatePageComplete();

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
		newFileCreationPage = new CGenModelWizardNewFileCreationPage("Whatever", selection);
		newFileCreationPage.setTitle(CGenModelUIPlugin.INSTANCE.getString("_UI_CGenModelWizard_label"));
		newFileCreationPage.setDescription(CGenModelUIPlugin.INSTANCE.getString("_UI_CGenModelWizard_description"));
		newFileCreationPage.setFileName(CGenModelUIPlugin.INSTANCE.getString("_UI_CGenModelEditorFilenameDefaultBase") + "." + FILE_EXTENSIONS.get(0));
		addPage(newFileCreationPage);

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
					String defaultModelBaseFilename = CGenModelUIPlugin.INSTANCE.getString("_UI_CGenModelEditorFilenameDefaultBase");
					String defaultModelFilenameExtension = FILE_EXTENSIONS.get(0);
					String modelFilename = defaultModelBaseFilename + "." + defaultModelFilenameExtension;
					for (int i = 1; ((IContainer)selectedResource).findMember(modelFilename) != null; ++i) {
						modelFilename = defaultModelBaseFilename + i + "." + defaultModelFilenameExtension;
					}
					newFileCreationPage.setFileName(modelFilename);
				}
			}
		}
		
		executionModelSelectionPage = new CGenModelWizardExecutionModelSelectionPage();
		executionModelSelectionPage.setTitle("Execution Model");
		executionModelSelectionPage.setDescription("Specify an execution model URI and try to load it");
		addPage(executionModelSelectionPage);

		fragmentSelectionPage = new CGenModelWizardFragmentSelectionPage();
		fragmentSelectionPage.setTitle("Top-Level System Fragment");
		fragmentSelectionPage.setDescription("Specify a top-level system fragment and try to load it");
		addPage(fragmentSelectionPage);

		directorySelectionPage = new CGenModelWizardDirectorySelectionPage();
		directorySelectionPage.setTitle("Source Directory");
		directorySelectionPage.setDescription("Specify source directory for the generated source code");
		addPage(directorySelectionPage);
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
