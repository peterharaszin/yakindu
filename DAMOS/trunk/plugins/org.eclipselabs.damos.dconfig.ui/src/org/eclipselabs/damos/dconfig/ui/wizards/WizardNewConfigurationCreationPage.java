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

package org.eclipselabs.damos.dconfig.ui.wizards;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
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
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.ContainerSelectionDialog;
import org.eclipse.ui.dialogs.FilteredResourcesSelectionDialog;
import org.eclipselabs.damos.common.ui.viewers.FragmentLabelProvider;
import org.eclipselabs.damos.common.ui.viewers.FragmentListContentProvider;
import org.eclipselabs.damos.dml.DMLPackage;
import org.eclipselabs.damos.dml.Fragment;

/**
 * @author Andreas Unger
 *
 */
public class WizardNewConfigurationCreationPage extends WizardPage {
	
	private static final String DCONFIG_FILE_EXTENSION = "dconfig";
	private static final String BLOCK_DIAGRAM_FILE_EXTENSION = "blockdiagram";
	
	private static final Pattern PACKAGE_NAME_PATTERN = Pattern.compile("\\A([a-zA-Z]\\w*)(\\.[a-zA-Z]\\w*)*\\z");
	private static final Pattern CONFIGURATION_NAME_PATTERN = Pattern.compile("\\A[a-zA-Z]\\w*\\z");
	private static final Pattern INVALID_PACKAGE_NAME_PATTERN = Pattern.compile("\\A[0-9]+|\\W|_");

	private IStructuredSelection selection;
	
	private String configurationNamePrefix = "";
	
	private Text parentFolderText;
	private Text packageNameText;
	private Text configurationNameText;
	private Text blockDiagramPathText;
	private ComboViewer fragmentViewer;

	public WizardNewConfigurationCreationPage(String pageName, String title, ImageDescriptor titleImage, IStructuredSelection selection) {
		super(pageName, title, titleImage);
		this.selection = selection;
		setPageComplete(false);
	}
	
	/**
	 * @param configurationNamePrefix the configurationNamePrefix to set
	 */
	public void setConfigurationNamePrefix(String configurationNamePrefix) {
		this.configurationNamePrefix = configurationNamePrefix;
	}
	
	/**
	 * @return the parentFolderText
	 */
	public IContainer getParentFolder() {
		IResource resource = ResourcesPlugin.getWorkspace().getRoot().findMember(parentFolderText.getText());
		if (resource instanceof IContainer) {
			return (IContainer) resource;
		}
		return null;
	}
	
	public IFile getConfigurationFile() {
		return getParentFolder().getFile(new Path(getConfigurationName() + "." + DCONFIG_FILE_EXTENSION));
	}
	
	/**
	 * @return the packageNameText
	 */
	public String getPackageName() {
		return packageNameText.getText();
	}
	
	public String getConfigurationName() {
		return configurationNameText.getText();
	}
	
	public Fragment getFragment() {
		return (Fragment) ((IStructuredSelection) fragmentViewer.getSelection()).getFirstElement();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.dialogs.IDialogPage#createControl(org.eclipse.swt.widgets.Composite)
	 */
	public void createControl(Composite parent) {
		initializeDialogUnits(parent);
		
		// top level group
		final Composite topLevel = new Composite(parent, SWT.NONE);
		topLevel.setLayout(new GridLayout(3, false));
		topLevel.setLayoutData(new GridData(GridData.VERTICAL_ALIGN_FILL
				| GridData.HORIZONTAL_ALIGN_FILL));
		topLevel.setFont(parent.getFont());

		Label label = new Label(topLevel, SWT.NONE);
		label.setText("Parent folder:");
		
		parentFolderText = new Text(topLevel, SWT.SINGLE | SWT.BORDER);
		parentFolderText.setLayoutData(new GridData(GridData.FILL, GridData.BEGINNING, true, false));
		
		IContainer selectedContainer = getSelectedContainer();
		if (selectedContainer != null) {
			parentFolderText.setText(selectedContainer.getFullPath().makeRelative().toString());
		}
		
		parentFolderText.addModifyListener(new ModifyListener() {
			
			public void modifyText(ModifyEvent event) {
				validatePage();
			}
			
		});

		Button browseFolderButton = new Button(topLevel, SWT.PUSH);
		browseFolderButton.setText("Browse...");
		browseFolderButton.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				browseParentFolder();
			}
			
		});
		
		Fragment fragment = getSelectedFragment();
		
		label = new Label(topLevel, SWT.NONE);
		label.setText("Package:");

		packageNameText = new Text(topLevel, SWT.SINGLE | SWT.BORDER);
		String packageName = "";
		if (fragment != null && fragment.getPackageName() != null && fragment.getPackageName().trim().length() > 0) {
			packageName = fragment.getPackageName();
		} else if (selectedContainer != null && selectedContainer.getProject() != null) {
			Matcher matcher = INVALID_PACKAGE_NAME_PATTERN.matcher(selectedContainer.getProject().getName());
			packageName = matcher.replaceAll("").toLowerCase();
		}
		packageNameText.setText(packageName);
		packageNameText.setLayoutData(new GridData(GridData.FILL, GridData.BEGINNING, true, false));

		packageNameText.addModifyListener(new ModifyListener() {
			
			public void modifyText(ModifyEvent event) {
				validatePage();
			}
			
		});

		new Label(topLevel, SWT.NONE);
		
		label = new Label(topLevel, SWT.SEPARATOR | SWT.SHADOW_OUT | SWT.HORIZONTAL);
		label.setLayoutData(new GridData(GridData.FILL, GridData.BEGINNING, true, false, 3, 1));

		label = new Label(topLevel, SWT.NONE);
		label.setText("Name:");

		configurationNameText = new Text(topLevel, SWT.SINGLE | SWT.BORDER);
		configurationNameText.setLayoutData(new GridData(GridData.FILL, GridData.BEGINNING, true, false));
		
		if (fragment != null && fragment.getName() != null) {
			String configurationName = createDefaultConfigurationName(fragment.getName().trim());
			IContainer parentFolder = getParentFolder();
			if (parentFolder != null) {
				configurationName = findAvailableConfigurationName(parentFolder, configurationName);
			}
			configurationNameText.setText(configurationName);
		}
		
		configurationNameText.addModifyListener(new ModifyListener() {
			
			public void modifyText(ModifyEvent event) {
				validatePage();
			}
			
		});

		new Label(topLevel, SWT.NONE);

		label = new Label(topLevel, SWT.NONE);
		label.setText("Block diagram:");

		blockDiagramPathText = new Text(topLevel, SWT.SINGLE | SWT.BORDER);
		blockDiagramPathText.setLayoutData(new GridData(GridData.FILL, GridData.BEGINNING, true, false));
		
		IFile blockDiagramFile = getSelectedBlockDiagramFile();
		if (blockDiagramFile != null) {
			blockDiagramPathText.setText(blockDiagramFile.getFullPath().makeRelative().toString());
		}

		blockDiagramPathText.addModifyListener(new ModifyListener() {
			
			public void modifyText(ModifyEvent event) {
				updateBlockDiagramPath();
			}
			
		});
		
		Button browseBlockDiagramButton = new Button(topLevel, SWT.PUSH);
		browseBlockDiagramButton.setText("Browse...");
		browseBlockDiagramButton.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				browseBlockDiagram();
			}
			
		});

		label = new Label(topLevel, SWT.NONE);
		label.setText("Fragment:");

		fragmentViewer = new ComboViewer(topLevel, SWT.SINGLE | SWT.BORDER | SWT.READ_ONLY);
		fragmentViewer.getCombo().setLayoutData(new GridData(GridData.FILL, GridData.BEGINNING, true, false));
		fragmentViewer.setLabelProvider(new FragmentLabelProvider());
		fragmentViewer.setContentProvider(new FragmentListContentProvider());
		if (fragment != null) {
			fragmentViewer.setInput(fragment.eResource().getResourceSet());
			fragmentViewer.getCombo().select(0);
		}
		fragmentViewer.addSelectionChangedListener(new ISelectionChangedListener() {
			
			public void selectionChanged(SelectionChangedEvent event) {
				validatePage();
			}
			
		});

		new Label(topLevel, SWT.NONE);

		validatePage();
		// Show description on opening
		setErrorMessage(null);
		setMessage(null);
		setControl(topLevel);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.dialogs.DialogPage#setVisible(boolean)
	 */
	@Override
	public void setVisible(boolean visible) {
		super.setVisible(visible);
		if (visible) {
			configurationNameText.setFocus();
			if (configurationNameText.getText().length() > 0) {
				configurationNameText.selectAll();
			}
		}
	}

	/**
	 * @param parentFolder
	 * @param configurationName
	 * @return
	 */
	private String findAvailableConfigurationName(IContainer parentFolder, String configurationName) {
		String name = configurationName;
		int i = 2;
		while (configurationExists(parentFolder, name)) {
			name = configurationName + i++;
		}
		return name;
	}

	private String createDefaultConfigurationName(String name) {
		return configurationNamePrefix + name;
	}

	private boolean validatePage() {
		String errorMessage = null;
		
		IContainer parentFolder = getParentFolder();
		if (parentFolderText.getText().trim().length() == 0) {
			errorMessage = "No parent folder specified";
		} else if (packageNameText.getText().trim().length() == 0) {
			errorMessage = "No package specified";
		} else if (configurationNameText.getText().trim().length() == 0) {
			errorMessage = "No name specified";
		} else if (blockDiagramPathText.getText().trim().length() == 0) {
			errorMessage = "No block diagram specified";
		} else if (parentFolder == null) {
			errorMessage = "Invalid parent folder";
		} else if (!PACKAGE_NAME_PATTERN.matcher(packageNameText.getText()).matches()) {
			errorMessage = "Invalid package name";
		} else if (!CONFIGURATION_NAME_PATTERN.matcher(configurationNameText.getText()).matches()) {
			errorMessage = "Invalid name";
		} else if (configurationExists(parentFolder, configurationNameText.getText())) {
			errorMessage = "Configuration already exists";
		} else if (fragmentViewer.getCombo().getItemCount() == 0) {
			errorMessage = "Invalid block diagram";
		} else if (fragmentViewer.getSelection().isEmpty()) {
			errorMessage = "No fragment selected";
		}

		setErrorMessage(errorMessage);
		
		boolean valid = errorMessage == null;
		if (valid != isPageComplete()) {
			setPageComplete(valid);
		}
		
		return valid;
	}
	
	private boolean configurationExists(IContainer parentFolder, String configurationName) {
		return parentFolder.findMember(configurationName + "." + DCONFIG_FILE_EXTENSION) != null;
	}
	
	private IContainer getSelectedContainer() {
		Object selectedElement = selection.getFirstElement();
		if (selectedElement instanceof IAdaptable) {
			IResource resource = (IResource) ((IAdaptable) selectedElement).getAdapter(IResource.class);
			if (resource != null) {
				selectedElement = resource;
			}
		}
		if (selectedElement instanceof IContainer) {
			return (IContainer) selectedElement;
		}
		if (selectedElement instanceof IResource) {
			return ((IResource) selectedElement).getParent();
		}
		return null;
	}
	
	private IFile getSelectedBlockDiagramFile() {
		if (selection.getFirstElement() instanceof IFile) {
			IFile file = (IFile) selection.getFirstElement();
			if (BLOCK_DIAGRAM_FILE_EXTENSION.equals(file.getFullPath().getFileExtension())) {
				return file;
			}
		}
		return null;
	}

	private Fragment getSelectedFragment() {
		IFile file = getSelectedBlockDiagramFile();
		if (file != null) {
			URI uri = URI.createPlatformResourceURI(file.getFullPath().toString(), true);
			ResourceSet resourceSet = new ResourceSetImpl();
			try {
				Resource resource = resourceSet.getResource(uri, true);
				return (Fragment) EcoreUtil.getObjectByType(resource.getContents(), DMLPackage.eINSTANCE.getFragment());
			} catch (RuntimeException e) {
				// Return null
			}
		}
		return null;
	}

	/**
	 * 
	 */
	private void browseParentFolder() {
		IContainer initialSelection = null;
		
		IContainer root = ResourcesPlugin.getWorkspace().getRoot();
		if (root.getFullPath().isValidPath(parentFolderText.getText())) {
			Path path = new Path(parentFolderText.getText());
			IResource resource = root.findMember(path);
			if (resource instanceof IContainer && resource.exists()) {
				initialSelection = (IContainer) resource;
			}
		}

		if (initialSelection == null) {
			initialSelection = root;
		}
		
		ContainerSelectionDialog d = new ContainerSelectionDialog(getShell(), initialSelection, true, "Select target folder");
		d.open();
		Object[] result = d.getResult();
		if (result != null && result.length > 0) {
			Object firstResult = result[0];
			if (firstResult instanceof IPath) {
				IPath path = (IPath) firstResult;
				parentFolderText.setText(path.makeRelative().toString());
			}
		}
	}

	private void updateBlockDiagramPath() {
		try {
			ResourceSet rs = new ResourceSetImpl();
			URI uri = URI.createPlatformResourceURI(blockDiagramPathText.getText(), false);
			rs.getResource(uri, true);
			fragmentViewer.setInput(rs);
			fragmentViewer.getCombo().select(0);
		} catch (Exception e) {
			fragmentViewer.setInput(null);
		}
		validatePage();
	}

	private void browseBlockDiagram() {
		FilteredResourcesSelectionDialog d = new FilteredResourcesSelectionDialog(
				getShell(),
				false,
				ResourcesPlugin.getWorkspace().getRoot(),
				IResource.FILE);
		d.setInitialPattern("*." + BLOCK_DIAGRAM_FILE_EXTENSION);
		d.open();
		Object firstResult = d.getFirstResult();
		if (firstResult instanceof IFile) {
			blockDiagramPathText.setText(((IFile) firstResult).getFullPath().makeRelative().toString());
		}
	}
	
}
