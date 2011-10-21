package org.yakindu.sct.statechart.diagram.providers;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.requests.DirectEditRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IPrimaryEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditor;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramWorkbenchPart;
import org.eclipse.gmf.runtime.emf.ui.providers.marker.AbstractModelMarkerNavigationProvider;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.xtext.EcoreUtil2;
import org.yakindu.model.sct.statechart.StatechartPackage;
import org.yakindu.sct.statechart.diagram.validation.IMarkerType;

import de.itemis.xtext.utils.gmf.directedit.IXtextAwareEditPart;

/**
 * 
 * @author muelder
 * 
 */
public class StatechartMarkerNavigationProvider extends
		AbstractModelMarkerNavigationProvider implements IMarkerType {

	@SuppressWarnings("rawtypes")
	protected void doGotoMarker(IMarker marker) {

		String elementId = marker
				.getAttribute(
						org.eclipse.gmf.runtime.common.core.resources.IMarker.ELEMENT_ID,
						null);
		if (elementId == null || !(getEditor() instanceof DiagramEditor)) {
			return;
		}
		DiagramEditor editor = (DiagramEditor) getEditor();
		Map editPartRegistry = editor.getDiagramGraphicalViewer()
				.getEditPartRegistry();
		EObject targetView = editor.getDiagram().eResource()
				.getEObject(elementId);
		if (targetView == null) {
			return;
		}
		EditPart targetEditPart = (EditPart) editPartRegistry.get(targetView);
		if (targetEditPart != null) {
			selectElementsInDiagram(editor,
					Arrays.asList(new EditPart[] { targetEditPart }));
		}

		try {
			String type = marker.getType();
			if (type.equals(XTEXT_MARKER_TYPE)) {
				DirectEditRequest request = new DirectEditRequest();
				request.setDirectEditFeature(StatechartPackage.eINSTANCE
						.getExpressionElement_Expression());
				List<EObject> allNotationElements = EcoreUtil2
						.eAllContentsAsList(targetView);
				for (EObject eObject : allNotationElements) {
					if(eObject instanceof View){
						IGraphicalEditPart editPart = (IGraphicalEditPart)editPartRegistry.get((View)eObject);
						if(editPart instanceof IXtextAwareEditPart){
							editPart.performRequest(request);
							//TODO: Select range
						}
					}
				}
			}
		} catch (CoreException e) {
			e.printStackTrace();
		}

	}

	// public void gotoMarker(IMarker marker) {
	// if (fIsUpdatingMarkerViews)
	// return;
	//
	// if (getSourceViewer() == null)
	// return;
	//
	// int start= MarkerUtilities.getCharStart(marker);
	// int end= MarkerUtilities.getCharEnd(marker);
	//
	// boolean selectLine= start < 0 || end < 0;
	//
	// // look up the current range of the marker when the document has been
	// edited
	// IAnnotationModel model=
	// getDocumentProvider().getAnnotationModel(getEditorInput());
	// if (model instanceof AbstractMarkerAnnotationModel) {
	//
	// AbstractMarkerAnnotationModel markerModel=
	// (AbstractMarkerAnnotationModel) model;
	// Position pos= markerModel.getMarkerPosition(marker);
	// if (pos != null && !pos.isDeleted()) {
	// // use position instead of marker values
	// start= pos.getOffset();
	// end= pos.getOffset() + pos.getLength();
	// }
	//
	// if (pos != null && pos.isDeleted()) {
	// // do nothing if position has been deleted
	// return;
	// }
	// }

	// IDocument document= getDocumentProvider().getDocument(getEditorInput());
	//
	// if (selectLine) {
	// int line;
	// try {
	// if (start >= 0)
	// line= document.getLineOfOffset(start);
	// else {
	// line= MarkerUtilities.getLineNumber(marker);
	// // Marker line numbers are 1-based
	// -- line;
	// start= document.getLineOffset(line);
	// }
	// end= start + document.getLineLength(line) - 1;
	// } catch (BadLocationException e) {
	// return;
	// }
	// }
	//
	// int length= document.getLength();
	// if (end <= length && start <= length) {
	// fIsComingFromGotoMarker= true;
	// selectAndReveal(start, end - start);
	// }
	// }

	public static void selectElementsInDiagram(
			IDiagramWorkbenchPart diagramPart, List<EditPart> editParts) {
		diagramPart.getDiagramGraphicalViewer().deselectAll();

		EditPart firstPrimary = null;
		for (Iterator<EditPart> it = editParts.iterator(); it.hasNext();) {
			EditPart nextPart = (EditPart) it.next();
			diagramPart.getDiagramGraphicalViewer().appendSelection(nextPart);
			if (firstPrimary == null && nextPart instanceof IPrimaryEditPart) {
				firstPrimary = nextPart;
			}
		}
		if (!editParts.isEmpty()) {
			//TODO animation
			diagramPart.getDiagramGraphicalViewer().reveal(
					firstPrimary != null ? firstPrimary : (EditPart) editParts
							.get(0));
		}
	}

}
