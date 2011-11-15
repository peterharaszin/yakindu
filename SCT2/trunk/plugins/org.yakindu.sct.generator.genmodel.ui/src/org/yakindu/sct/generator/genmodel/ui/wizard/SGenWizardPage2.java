/**
 * Copyright (c) 2011 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.generator.genmodel.ui.wizard;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.viewers.AbstractTreeViewer;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.CheckboxTreeViewer;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;
import org.yakindu.sct.generator.core.extensions.GeneratorExtensions;
import org.yakindu.sct.generator.core.extensions.GeneratorExtensions.GeneratorDescriptor;
import org.yakindu.sct.model.sgraph.SGraphPackage;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.ui.editor.StatechartImages;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

/**
 * 
 * @author holger willebrandt - Initial contribution and API
 */
public class SGenWizardPage2 extends WizardPage {

	protected static final String STATECHART_FILE_EXTENSION = "sct";
	private ComboViewer generatorCombo;
	protected CheckboxTreeViewer stateChartTree;
	private final SGenWizardPage1 fileSelectionPage;

	private static final ITreeContentProvider treeContentProvider = new ITreeContentProvider() {

		public Object[] getElements(Object inputElement) {
			if (inputElement instanceof TreeNode) {
				return ((TreeNode) inputElement).children.toArray();
			}
			return new Object[] {};
		}

		public boolean hasChildren(Object element) {
			if (element instanceof TreeNode) {
				return !((TreeNode) element).children.isEmpty();
			}
			return false;
		}

		public Object[] getChildren(Object parentElement) {
			if (parentElement instanceof TreeNode) {
				return ((TreeNode) parentElement).children.toArray();
			}
			return new Object[] {};
		}

		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
			// not handled
		}

		public void dispose() {
			// not handled
		}

		public Object getParent(Object element) {
			return null;
		}

	};
	private static final LabelProvider treeLabelProvider = new LabelProvider() {

		@Override
		public Image getImage(Object element) {
			if (element instanceof TreeNode) {
				TreeNode treeNode = (TreeNode) element;
				if (isStatechartResource(treeNode.resource)) {
					return StatechartImages.LOGO.image();
				} else if (treeNode.resource.getType() == IResource.FOLDER) {
					return PlatformUI.getWorkbench().getSharedImages()
							.getImage(ISharedImages.IMG_OBJ_FOLDER);
				} else if (treeNode.resource.getType() == IResource.PROJECT) {
					return PlatformUI.getWorkbench().getSharedImages()
							.getImage(IDE.SharedImages.IMG_OBJ_PROJECT);
				}
			}
			return super.getImage(element);
		}

		@Override
		public String getText(Object element) {
			if (element instanceof TreeNode) {
				return ((TreeNode) element).resource.getName();
			}
			return super.getText(element);
		}
	};

	/**
	 * @param pageName
	 * @param resourceDescriptions
	 * @param selection
	 */
	protected SGenWizardPage2(String pageName, SGenWizardPage1 fileSelectionPage) {
		super(pageName);
		this.fileSelectionPage = fileSelectionPage;
	}

	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NULL);
		setControl(container);
		container.setLayout(new GridLayout(1, false));

		Label lblNewLabel = new Label(container, SWT.NONE);
		lblNewLabel.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true,
				false, 1, 1));
		lblNewLabel.setText("Statecharts");

		stateChartTree = new CheckboxTreeViewer(container, SWT.BORDER);
		stateChartTree.getTree().setLayoutData(
				new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));

		stateChartTree.setContentProvider(treeContentProvider);
		stateChartTree.setLabelProvider(treeLabelProvider);
		stateChartTree
				.addCheckStateListener(new TreePropagatingCheckStateListener(
						stateChartTree) {
					@Override
					public void checkStateChanged(CheckStateChangedEvent event) {
						super.checkStateChanged(event);
						checkComplete();
					}
				});
		stateChartTree
				.addDoubleClickListener(new TreeExpandingDoubleClickListener(
						stateChartTree));
		stateChartTree.setAutoExpandLevel(AbstractTreeViewer.ALL_LEVELS);

		Label lblGenerator = new Label(container, SWT.NONE);
		lblGenerator.setText("Generator");

		generatorCombo = new ComboViewer(container, SWT.READ_ONLY);
		generatorCombo.getCombo().setLayoutData(
				new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		generatorCombo.setLabelProvider(new GeneratorDescriptorLabelProvider());
		generatorCombo.setContentProvider(new ArrayContentProvider());
		GeneratorDescriptor[] generatorArray = Iterables.toArray(
				GeneratorExtensions.getGeneratorDescriptors(),
				GeneratorDescriptor.class);
		generatorCombo.setInput(generatorArray);
		generatorCombo.getCombo().select(0);

		checkComplete();

	}

	public List<Statechart> getStatecharts() {
		List<Statechart> statecharts = Lists.newArrayList();
		Object[] checkedElements = stateChartTree.getCheckedElements();
		for (Object object : checkedElements) {
			if (object instanceof TreeNode) {
				IResource resource = ((TreeNode) object).resource;
				if (isStatechartResource(resource)) {
					statecharts.add(loadStatechart(resource));
				}
			}
		}
		return statecharts;
	}

	private static Statechart loadStatechart(IResource resource) {
		Resource emfResource = toEmfResource(resource);
		Statechart statechart = (Statechart) EcoreUtil.getObjectByType(
				emfResource.getContents(), SGraphPackage.Literals.STATECHART);
		return statechart;
	}

	private static Resource toEmfResource(IResource iResource) {
		URI uri = URI.createPlatformResourceURI(iResource.getFullPath()
				.toString(), true);
		ResourceSet resourceSet = new ResourceSetImpl();
		Resource resource = Resource.Factory.Registry.INSTANCE.getFactory(uri)
				.createResource(uri);
		resourceSet.getResources().add(resource);
		try {
			resource.load(Collections.emptyMap());
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		return resource;
	}

	public String getGeneratorId() {
		return ((GeneratorDescriptor) ((StructuredSelection) generatorCombo
				.getSelection()).getFirstElement()).getId();
	}

	@Override
	public void setVisible(boolean visible) {
		super.setVisible(visible);
		if (visible) {
			IPath containerPath = fileSelectionPage.getFilePath();
			IFolder folder = ResourcesPlugin.getWorkspace().getRoot()
					.getFolder(containerPath);
			try {
				TreeNode projectTree = new TreeNode(folder.getProject());
				projectTree.children.add(buildTree(folder.getProject()));
				stateChartTree.setInput(projectTree);
			} catch (CoreException e) {
				// input will be empty
			}
			checkComplete();
		}
	}

	protected void checkComplete() {
		setPageComplete(validatePage());
	}

	protected boolean validatePage() {
		return stateChartTree.getCheckedElements().length > 0
				&& !generatorCombo.getSelection().isEmpty();
	}

	private TreeNode buildTree(IResource resource) throws CoreException {
		final TreeNode root = new TreeNode(resource);
		List<IResource> statecharts = Lists.newArrayList();
		resource.accept(new StatechartVisitor(resource, statecharts));
		if (!statecharts.isEmpty()) {
			Iterables.addAll(root.children,
					Iterables.transform(statecharts, toTreeNode));
		}
		List<IResource> folders = Lists.newArrayList();
		resource.accept(new FolderVisitor(resource, folders));
		for (IResource folder : folders) {
			TreeNode subtree = buildTree(folder);
			if (!subtree.isEmpty()) {
				root.children.add(subtree);
			}
		}
		return root;
	}

	protected static boolean isStatechartResource(IResource resource) {
		return resource.getType() == IResource.FILE
				&& STATECHART_FILE_EXTENSION
						.equals(resource.getFileExtension());
	}

	private static final Function<IResource, TreeNode> toTreeNode = new Function<IResource, TreeNode>() {

		public TreeNode apply(IResource from) {
			return new TreeNode(from);
		}
	};

	private static class TreeNode {
		final IResource resource;
		final List<TreeNode> children = Lists.newArrayList();

		public TreeNode(IResource project) {
			this.resource = project;
		}

		public boolean isEmpty() {
			return resource.getType() == IResource.FOLDER
					&& (children.isEmpty() || Iterables.all(children, isEmpty));
		}

		static final Predicate<TreeNode> isEmpty = new Predicate<TreeNode>() {
			public boolean apply(TreeNode input) {
				return input.isEmpty();
			}
		};
	}

	private class FolderVisitor implements IResourceVisitor {
		final List<IResource> matches;
		private final IResource rootFolder;

		public FolderVisitor(IResource rootFolder, List<IResource> matches) {
			super();
			this.rootFolder = rootFolder;
			this.matches = matches;
		}

		public boolean visit(IResource resource) throws CoreException {
			if (rootFolder.equals(resource)) {
				return true;
			}
			if (resource.getType() == IResource.FOLDER && !resource.isDerived()) {
				matches.add(resource);
			}
			return resource.getType() == IResource.PROJECT;
		}

	}

	private class StatechartVisitor implements IResourceVisitor {

		final List<IResource> matches;
		private final IResource rootResource;

		public StatechartVisitor(IResource rootResource, List<IResource> matches) {
			super();
			this.rootResource = rootResource;
			this.matches = matches;
		}

		public boolean visit(IResource resource) throws CoreException {
			if (rootResource.equals(resource)
					&& resource.getType() == IResource.FOLDER) {
				return true;
			}
			if (isStatechartResource(resource)) {
				matches.add(resource);
			}
			return resource.getType() == IResource.PROJECT;
		}
	}

	private static class GeneratorDescriptorLabelProvider extends LabelProvider {

		GeneratorDescriptorLabelProvider() {
			super();
		}

		@Override
		public String getText(Object element) {
			if (element instanceof GeneratorDescriptor) {
				return ((GeneratorDescriptor) element).getName();
			}
			return super.getText(element);
		}

		@Override
		public Image getImage(Object element) {
			if (element instanceof GeneratorDescriptor) {
				return ((GeneratorDescriptor) element).getImage();
			}
			return super.getImage(element);
		}

	}
}
