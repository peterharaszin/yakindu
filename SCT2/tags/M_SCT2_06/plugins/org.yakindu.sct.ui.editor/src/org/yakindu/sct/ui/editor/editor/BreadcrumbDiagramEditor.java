package org.yakindu.sct.ui.editor.editor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.debug.internal.ui.viewers.breadcrumb.BreadcrumbViewer;
import org.eclipse.debug.internal.ui.viewers.breadcrumb.IBreadcrumbDropDownSite;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.parts.DiagramDocumentEditor;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.viewers.BaseLabelProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreePathContentProvider;
import org.eclipse.jface.viewers.ITreePathLabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerLabel;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.yakindu.sct.ui.editor.StatechartImages;

@SuppressWarnings("restriction")
public abstract class BreadcrumbDiagramEditor extends DiagramDocumentEditor {

	private List<IFile> history;

	public BreadcrumbDiagramEditor(boolean hasFlyoutPalette) {
		super(hasFlyoutPalette);
		history = new ArrayList<IFile>(0);
	}
	

	@Override
	public void createPartControl(Composite parent) {
		parent.setLayout(new org.eclipse.swt.layout.GridLayout(1, true));
		super.createPartControl(parent);
		createBreadcrumpViewer(parent);
	}

	private Object getInputHistory() {
		return history;
	}

	@Override
	public IFileEditorInput getEditorInput() {
		return (IFileEditorInput) super.getEditorInput();
	}

	@Override
	public void setInput(IEditorInput input) {
		super.setInput(input);
		if (input instanceof TrackingFileEditorInput) {
			history = ((TrackingFileEditorInput) input).getHistory();
		}
		if (history.isEmpty()) {
			history.add(getEditorInput().getFile());
		}
	}

	private void createBreadcrumpViewer(Composite parent) {
		MyBreadcrumpViewer viewer = new MyBreadcrumpViewer(parent, SWT.NONE);
		viewer.setContentProvider(new ITreePathContentProvider() {

			private List<IFile> input;

			@SuppressWarnings("unchecked")
			public void inputChanged(Viewer viewer, Object oldInput,
					Object newInput) {
				if (newInput != null && newInput instanceof List) {
					input = (List<IFile>) newInput;
				}
			}

			public void dispose() {
				// Nothing to do
			}

			public boolean hasChildren(TreePath path) {
				return false;
			}

			public TreePath[] getParents(Object element) {
				return null;
			}

			@SuppressWarnings("rawtypes")
			public Object[] getElements(Object inputElement) {
				if (inputElement != null && inputElement instanceof Collection) {
					return ((Collection) inputElement).toArray();
				}
				return null;
			}

			public Object[] getChildren(TreePath parentPath) {
				return input.subList(parentPath.getSegmentCount(), input.size()).toArray();
			}
		});
		viewer.setLabelProvider(new MyLabelProvider());
		viewer.setInput(getInputHistory());
		viewer.addSelectionChangedListener(new ISelectionChangedListener() {
			
			public void selectionChanged(SelectionChangedEvent event) {
				ISelection selection = event.getSelection();
				if(selection instanceof IStructuredSelection){
					IFile firstElement = (IFile) ((IStructuredSelection) selection).getFirstElement();
					System.out.println("Selection event ;" + firstElement);
					final IWorkbenchPage page = PlatformUI.getWorkbench()
							.getActiveWorkbenchWindow().getActivePage();

					try {
						TrackingFileEditorInput input = new TrackingFileEditorInput(firstElement);
						input.setHistory(history.subList(0, history.indexOf(firstElement)));
						page.openEditor(input, StatechartDiagramEditor.ID);
					} catch (PartInitException e) {
						e.printStackTrace();
					}
				}
			}
		});

	}


	@Override
	protected void createGraphicalViewer(Composite parent) {
		super.createGraphicalViewer(parent);
		GridDataFactory.fillDefaults().grab(true, true).applyTo(parent);
	}
	
	

	public List<IFile> getHistory() {
		return history;
	}

	public class MyLabelProvider extends BaseLabelProvider implements
			ITreePathLabelProvider {

		public void updateLabel(ViewerLabel label, TreePath elementPath) {
			IFile lastSegment = (IFile)elementPath.getLastSegment();
			label.setText(lastSegment.getName());
			label.setImage(StatechartImages.LOGO.image());
		}
	}

	@SuppressWarnings("restriction")
	public class MyBreadcrumpViewer extends BreadcrumbViewer {

		public MyBreadcrumpViewer(Composite parent, int style) {
			super(parent, style);
		}

		@Override
		protected Control createDropDown(Composite parent,
				IBreadcrumbDropDownSite site, TreePath path) {
			return null;
		}

	}
	
	

}
