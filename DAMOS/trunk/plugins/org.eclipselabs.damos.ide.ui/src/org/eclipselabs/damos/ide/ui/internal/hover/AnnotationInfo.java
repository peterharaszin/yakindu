package org.eclipselabs.damos.ide.ui.internal.hover;

import java.util.List;

import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.jface.text.IInformationControl;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.source.Annotation;
import org.eclipselabs.damos.ide.core.validation.Problem;

public class AnnotationInfo {
		public final Annotation annotation;
		public final Position position;
		public final ITextViewer viewer;
		// DIFF: not part of AbstractAnnotationHover (1)
		public final ICompletionProposal[] proposals;
		public final List<Problem> resourceProblems;
		public final List<Problem> liveProblems;
		
		public AnnotationInfo(List<Problem> resourceProblems, List<Problem> liveProblems, Annotation annotation, Position position, ITextViewer textViewer, ICompletionProposal[] proposals) {
			this.resourceProblems = resourceProblems;
			this.liveProblems = liveProblems;
			this.annotation= annotation;
			this.position= position;
			this.viewer= textViewer;
			// DIFF: not part of AbstractAnnotationHover(1)
			this.proposals = proposals;
		}

		/**
		 * Create completion proposals which can resolve the given annotation at
		 * the given position. Returns an empty array if no such proposals exist.
		 *
		 * @return the proposals or an empty array
		 */
		public ICompletionProposal[] getCompletionProposals() {
			// DIFF: return proposals directly, no subclassing (1)
			return proposals;
		}

		/**
		 * Adds actions to the given toolbar.
		 *
		 * @param manager the toolbar manager to add actions to
		 * @param infoControl the information control
		 */
		public void fillToolBar(ToolBarManager manager, IInformationControl infoControl) {
			// DIFF: disabled as configuration is not supported yet (2)
//			ConfigureAnnotationsAction configureAnnotationsAction= new ConfigureAnnotationsAction(annotation, infoControl);
//			manager.add(configureAnnotationsAction);
		}
	}
