/**
 * Copyright (c) 2006-2009 committers of mda4e and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of mda4e (http://www.mda4e.org/) - initial API and implementation
 *
 */
package org.mda4e.statemachine.contribution.part;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.mwe.core.ConfigurationException;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.issues.IssuesImpl;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gmf.runtime.common.ui.action.IDisposableAction;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramWorkbenchPart;
import org.eclipse.gmf.runtime.emf.core.util.EMFCoreUtil;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.actions.WorkspaceModifyDelegatingOperation;
import org.eclipse.xtend.check.CheckFacade;
import org.eclipse.xtend.expression.EvaluationException;
import org.eclipse.xtend.expression.ExecutionContextImpl;
import org.eclipse.xtend.typesystem.emf.EmfMetaModel;

import statemachine.StatemachinePackage;
import statemachine.diagram.part.StatemachineDiagramEditorPlugin;
import statemachine.diagram.part.StatemachineDiagramEditorUtil;
import statemachine.diagram.part.ValidateAction;
import statemachine.diagram.providers.StatemachineMarkerNavigationProvider;
import statemachine.diagram.providers.StatemachineValidationProvider;

import com.yakindu.statechart.model.expressions.statechartexpressions.StatechartexpressionsPackage;

public class ContributionValidateAction extends ValidateAction implements
		IDisposableAction {

	final private static Logger log = Logger
			.getLogger(ContributionValidateAction.class);

	private IWorkbenchPage workbenchPage;

	public ContributionValidateAction(final IWorkbenchPage workbenchPage) {
		super(workbenchPage);
		this.workbenchPage = workbenchPage;
	}

	private volatile boolean isDisposed = false;

	private Job j;

	public void init() {
		// System.out.println("ContributionAction");
		j = new ValidateJob("executing Yakindu Statechart checks", this);
		j.schedule();
	}

	public void dispose() {

		j.cancel();
		isDisposed = true;
	}

	public boolean isDisposed() {
		return isDisposed;
	}

	public static void runValidation(final DiagramEditPart diagramEditPart,
			final View view) {
		final DiagramEditPart fpart = diagramEditPart;
		final View fview = view;
		ValidateAction.runValidation(fpart, fview);
		final TransactionalEditingDomain txDomain = TransactionUtil
				.getEditingDomain(fview);
		StatemachineValidationProvider.runWithConstraints(txDomain,
				new Runnable() {

					public void run() {
						IFile target = fview.eResource() != null ? WorkspaceSynchronizer
								.getFile(fview.eResource())
								: null;
						Issues issues = runProjectEMFValidator(fview, target);
						if (view.isSetElement() && view.getElement() != null) {
//							ExecutionContextImpl executionContext = new ExecutionContextImpl();
//							EmfMetaModel statechartMetaModel = new EmfMetaModel(
//									StatemachinePackage.eINSTANCE);
//							executionContext.registerMetaModel(statechartMetaModel);
//							executionContext
//									.registerMetaModel(new EmfMetaModel(MetaModelRegistration
//											.getEPackage()));
//							executionContext.registerMetaModel(new EmfMetaModel(EcorePackage.eINSTANCE));
							Diagnostic diagnostic = org.eclipse.emf.ecore.util.Diagnostician.INSTANCE.validate(view.getElement());
							createMarkers(target, diagnostic, fpart);
						}

						BasicDiagnostic diagnosticProject = new DiagnosticIssuesWrapper(
								issues);
						createMarkers(target, diagnosticProject, fpart);
					}
				});
	}

	private static Issues runProjectEMFValidator(View target, IFile file) {
		final String chkFolderName = "checks";
		final String chkExtension = "chk";
		// if (target.isSetElement() && target.getElement() != null) {
		// IFile file = target.eResource() != null ? WorkspaceSynchronizer
		// .getFile(target.eResource()) : null;
		if (file != null) {
			IProject project = file.getProject();
			IFolder folder = project.getFolder(chkFolderName);
			if (folder.exists()) {
				Collection<IFile> fileList = getChkFiles(folder, chkExtension);
				Issues issues = new IssuesImpl();
				for (IFile checkFile : fileList) {
					LinkedList<EObject> list = new LinkedList<EObject>();
					list.add(target.getElement());
					for (Iterator<EObject> iter = target.getElement()
							.eAllContents(); iter.hasNext();) {
						list.add(iter.next());
					}
					try {
						URI checkFileURI = URI.createFileURI(ResourcesPlugin
								.getWorkspace().getRoot().getLocation().append(
										checkFile.getFullPath()).toString());

						// .getRawLocation().toOSString();
						// String fileNameWithoutExtension =
						// fileName.substring(0, fileName.lastIndexOf(".chk"));
						ExecutionContextImpl executionContext = new ExecutionContextImpl();
						EmfMetaModel statechartMetaModel = new EmfMetaModel(
								StatemachinePackage.eINSTANCE);
						executionContext.registerMetaModel(statechartMetaModel);
						executionContext
								.registerMetaModel(new EmfMetaModel(StatechartexpressionsPackage.eINSTANCE));
						executionContext.registerMetaModel(new EmfMetaModel(EcorePackage.eINSTANCE));
						CheckFacade.checkAll(checkFileURI.trimFileExtension()
								.toString(), list, executionContext, issues);
					} catch (ConfigurationException e) {
						try {
							IMarker failure = file
									.createMarker(StatemachineMarkerNavigationProvider.MARKER_TYPE);
							failure.setAttribute(IMarker.MESSAGE, "Error in "
									+ checkFile.getFullPath() + ":"
									+ e.getMessage());
							failure.setAttribute(IMarker.SEVERITY,
									IMarker.SEVERITY_ERROR);
							failure.setAttribute(IMarker.LOCATION, checkFile
									.getLocation().toOSString());
							failure.setAttribute(IMarker.LINE_NUMBER, 1);
						} catch (CoreException e1) {
							log.error(e1);
						}
					}
				}
				if (issues != null) {
					return issues;
				}
			}
		}
		// }
		return new IssuesImpl();
	}

	/**
	 * search for files with the given extension recursive in the given
	 * directory
	 * 
	 * @param folder
	 *            The folder to search for files inside
	 * @param extension
	 *            The extension we are looking at
	 * @return List of matching files
	 */
	private static Collection<IFile> getChkFiles(IFolder folder,
			String extension) {
		Collection<IFile> files = new LinkedList<IFile>();
		try {
			for (IResource resource : folder.members()) {
				if (resource instanceof IFile
						&& extension.equals(
								((IFile) resource).getFileExtension())) {
					files.add((IFile) resource);
				} else if (resource instanceof IFolder) {
					files.addAll(getChkFiles((IFolder) resource, extension));
				}
			}
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return files;
	}

	/**
	 * Copied from generated ValidateAction (It uses private methods)
	 * 
	 * @author Benjamin Schwertfeger
	 */
	public void run() {
		IWorkbenchPart workbenchPart = workbenchPage.getActivePart();
		if (workbenchPart instanceof IDiagramWorkbenchPart) {
			final IDiagramWorkbenchPart part = (IDiagramWorkbenchPart) workbenchPart;
			try {
				new WorkspaceModifyDelegatingOperation(
						new IRunnableWithProgress() {

							public void run(IProgressMonitor monitor)
									throws InterruptedException,
									InvocationTargetException {
								runValidation(part.getDiagramEditPart(), part
										.getDiagram());
							}
						}).run(new NullProgressMonitor());
			} catch (Exception e) {
				StatemachineDiagramEditorPlugin.getInstance().logError(
						"Validation action failed", e); //$NON-NLS-1$
			}
		}
	}

	/**
	 * Copied from generated ValidateAction (It is private)
	 * 
	 * @author Benjamin Schwertfeger
	 * @param diagnostic
	 * @param targetElementCollector
	 * @param allDiagnostics
	 * @return
	 */
	private static Set<EObject> collectTargetElements(Diagnostic diagnostic,
			Set<EObject> targetElementCollector, List<Diagnostic> allDiagnostics) {
		List<?> data = diagnostic.getData();
		EObject target = null;
		if (data != null && !data.isEmpty() && data.get(0) instanceof EObject) {
			target = (EObject) data.get(0);
			targetElementCollector.add(target);
			allDiagnostics.add(diagnostic);
		}
		if (diagnostic.getChildren() != null
				&& !diagnostic.getChildren().isEmpty()) {
			for (Diagnostic d : diagnostic.getChildren()) {
				collectTargetElements(d, targetElementCollector, allDiagnostics);
			}
		}
		return targetElementCollector;
	}

	/**
	 * Copied from generated ValidateAction (It is private)
	 * 
	 * @author Benjamin Schwertfeger
	 * @param target
	 * @param emfValidationStatus
	 * @param diagramEditPart
	 */
	private static void createMarkers(IFile target,
			Diagnostic emfValidationStatus, DiagramEditPart diagramEditPart) {
		if (emfValidationStatus.getSeverity() == Diagnostic.OK) {
			return;
		}
		final Diagnostic rootStatus = emfValidationStatus;
		List<Diagnostic> allDiagnostics = new ArrayList<Diagnostic>();
		StatemachineDiagramEditorUtil.LazyElement2ViewMap element2ViewMap = new StatemachineDiagramEditorUtil.LazyElement2ViewMap(
				diagramEditPart.getDiagramView(), collectTargetElements(
						rootStatus, new HashSet<EObject>(), allDiagnostics));
		for (Diagnostic d : emfValidationStatus.getChildren()) {
			Diagnostic nextDiagnostic = d;
			List<?> data = nextDiagnostic.getData();
			if (data != null && !data.isEmpty()
					&& data.get(0) instanceof EObject) {
				EObject element = (EObject) data.get(0);
				View view = StatemachineDiagramEditorUtil.findView(
						diagramEditPart, element, element2ViewMap);
				addMarker(
						diagramEditPart.getViewer(),
						target,
						view.eResource().getURIFragment(view),
						EMFCoreUtil.getQualifiedName(element, true),
						nextDiagnostic.getMessage(),
						diagnosticToStatusSeverity(nextDiagnostic.getSeverity()));
			} else if (data.get(0) instanceof EvaluationException) {
				addMarker(
						diagramEditPart.getViewer(),
						target,
						null,
						null,
						nextDiagnostic.getMessage(),
						diagnosticToStatusSeverity(nextDiagnostic.getSeverity()));
			}
		}
	}

	/**
	 * Copied from generated ValidateAction (It is private)
	 * 
	 * @author Benjamin Schwertfeger
	 * @param diagnosticSeverity
	 * @return
	 */
	private static int diagnosticToStatusSeverity(int diagnosticSeverity) {
		if (diagnosticSeverity == Diagnostic.OK) {
			return IStatus.OK;
		} else if (diagnosticSeverity == Diagnostic.INFO) {
			return IStatus.INFO;
		} else if (diagnosticSeverity == Diagnostic.WARNING) {
			return IStatus.WARNING;
		} else if (diagnosticSeverity == Diagnostic.ERROR
				|| diagnosticSeverity == Diagnostic.CANCEL) {
			return IStatus.ERROR;
		}
		return IStatus.INFO;
	}

	/**
	 * Copied from generated ValidateAction (It is private)
	 * 
	 * @author Benjamin Schwertfeger
	 * @param viewer
	 * @param target
	 * @param elementId
	 * @param location
	 * @param message
	 * @param statusSeverity
	 */
	private static void addMarker(EditPartViewer viewer, IFile target,
			String elementId, String location, String message,
			int statusSeverity) {
		if (target == null) {
			return;
		}
		StatemachineMarkerNavigationProvider.addMarker(target, elementId,
				location, message, statusSeverity);
	}

	private final class ValidateJob extends Job {

		private final ValidateAction validateAction;

		private ValidateJob(String name, ValidateAction validateAction) {
			super(name);
			this.validateAction = validateAction;
		}

		protected IStatus run(IProgressMonitor monitor) {
			if (!monitor.isCanceled()) {
				validateAction.run();
				schedule(5000);
			}
			return Status.OK_STATUS;
		}
	}
}
