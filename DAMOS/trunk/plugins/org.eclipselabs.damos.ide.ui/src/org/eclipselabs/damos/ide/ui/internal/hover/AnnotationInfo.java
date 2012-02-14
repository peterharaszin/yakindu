package org.eclipselabs.damos.ide.ui.internal.hover;

import java.util.List;

import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.jface.text.IInformationControl;
import org.eclipselabs.damos.ide.core.validation.Problem;

public class AnnotationInfo {

	public final List<Problem> resourceProblems;
	public final List<Problem> liveProblems;
	
	public AnnotationInfo(List<Problem> resourceProblems, List<Problem> liveProblems) {
		this.resourceProblems = resourceProblems;
		this.liveProblems = liveProblems;
	}

	/**
	 * Adds actions to the given toolbar.
	 *
	 * @param manager the toolbar manager to add actions to
	 * @param infoControl the information control
	 */
	public void fillToolBar(ToolBarManager manager, IInformationControl infoControl) {
	}

}
