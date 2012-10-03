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

package org.eclipse.damos.dml.ui.wizards;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.damos.dml.DMLPackage;
import org.eclipse.damos.dml.Fragment;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.IStructuredSelection;
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

/**
 * @author Andreas Unger
 *
 */
public class WizardNewQualifiedElementCreationPage extends WizardPage {
	
	private static final Pattern PACKAGE_NAME_PATTERN = Pattern.compile("\\A([a-zA-Z]\\w*)(\\.[a-zA-Z]\\w*)*\\z");
	private static final Pattern MODEL_NAME_PATTERN = Pattern.compile("\\A[a-zA-Z]\\w*\\z");
	private static final Pattern INVALID_PACKAGE_NAME_PATTERN = Pattern.compile("\\A[0-9]+|\\W|_");

	private IStructuredSelection selection;
	
	private String fileExtension;
	private String blockDiagramFileExtension;
	private String modelKind;
	private String initialModelName;
	
	private Text parentFolderText;
	private Text packageNameText;
	private Text modelNameText;

	public WizardNewQualifiedElementCreationPage(String pageName, String title, ImageDescriptor titleImage, String modelKind, String blockDiagramFileExtension, String fileExtension, IStructuredSelection selection) {
		super(pageName, title, titleImage);
		this.modelKind = modelKind;
		this.blockDiagramFileExtension = blockDiagramFileExtension;
		this.fileExtension = fileExtension;
		this.selection = selection;
		setPageComplete(false);
	}
	
	/**
	 * @param initialModelName the initialModelName to set
	 */
	public void setInitialModelName(String initialModelName) {
		this.initialModelName = initialModelName;
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
	
	public IFile getModelFile() {
		return getParentFolder().getFile(new Path(getModelName() + "." + fileExtension));
	}
	
	/**
	 * @return the packageNameText
	 */
	public String getPackageName() {
		return packageNameText.getText();
	}
	
	public String getModelName() {
		return modelNameText.getText();
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

		modelNameText = new Text(topLevel, SWT.SINGLE | SWT.BORDER);
		modelNameText.setLayoutData(new GridData(GridData.FILL, GridData.BEGINNING, true, false));
		
		if (initialModelName != null) {
			modelNameText.setText(initialModelName);
		} else if (fragment != null && fragment.getName() != null) {
			String modelName = fragment.getName().trim();
			IContainer parentFolder = getParentFolder();
			if (parentFolder != null) {
				modelName = findAvailableModelName(parentFolder, modelName);
			}
			modelNameText.setText(modelName);
		}
		
		modelNameText.addModifyListener(new ModifyListener() {
			
			public void modifyText(ModifyEvent event) {
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
			modelNameText.setFocus();
			if (modelNameText.getText().length() > 0) {
				modelNameText.selectAll();
			}
		}
	}

	private String findAvailableModelName(IContainer parentFolder, String modelName) {
		String name = modelName;
		int i = 2;
		while (modelExists(parentFolder, name)) {
			name = modelName + i++;
		}
		return name;
	}

	private boolean validatePage() {
		String errorMessage = null;
		
		IContainer parentFolder = getParentFolder();
		if (parentFolderText.getText().trim().length() == 0) {
			errorMessage = "No parent folder specified";
		} else if (packageNameText.getText().trim().length() == 0) {
			errorMessage = "No package specified";
		} else if (modelNameText.getText().trim().length() == 0) {
			errorMessage = "No name specified";
		} else if (parentFolder == null) {
			errorMessage = "Invalid parent folder";
		} else if (!PACKAGE_NAME_PATTERN.matcher(packageNameText.getText()).matches()) {
			errorMessage = "Invalid package name";
		} else if (!MODEL_NAME_PATTERN.matcher(modelNameText.getText()).matches()) {
			errorMessage = "Invalid name";
		} else if (modelExists(parentFolder, modelNameText.getText())) {
			errorMessage = toFirstUpper(modelKind) + " already exists";
		}

		setErrorMessage(errorMessage);
		
		boolean valid = errorMessage == null;
		if (valid != isPageComplete()) {
			setPageComplete(valid);
		}
		
		return valid;
	}
	
	private String toFirstUpper(String s) {
		if (s == null || s.length() == 0) {
			return s;
		}
		return s.substring(0, 1).toUpperCase() + s.substring(1);
	}

	private boolean modelExists(IContainer parentFolder, String modelName) {
		return parentFolder.findMember(modelName + "." + fileExtension) != null;
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
			if (blockDiagramFileExtension.equals(file.getFullPath().getFileExtension())) {
				return file;
			}
		}
		return null;
	}

	public Fragment getSelectedFragment() {
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

}
