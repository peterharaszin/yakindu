package org.eclipselabs.damos.ide.ui.internal.hover;

import java.util.List;

import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.jface.text.IInformationControl;
import org.eclipselabs.damos.ide.core.validation.Problem;

/*
 * Classes of this package have been copied from other Eclipse projects like Jface and Xtext,
 * since only parts of the required classes are public API.
 * 
 * TODO: Clean-up this code
 */

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
