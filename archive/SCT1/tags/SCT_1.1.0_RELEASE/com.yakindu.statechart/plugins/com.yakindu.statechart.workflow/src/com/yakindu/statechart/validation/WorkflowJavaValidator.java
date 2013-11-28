package com.yakindu.statechart.validation;

import org.eclipse.xtext.validation.Check;

import com.yakindu.statechart.workflow.Model;
import com.yakindu.statechart.workflow.TargetPlatform;
import com.yakindu.statechart.workflow.WorkflowPackage;

public class WorkflowJavaValidator extends AbstractWorkflowJavaValidator {

	/**
	 * Check for a valid extension in modelFile.
	 * 
	 * @param model
	 */
	@Check
	public void checkSourceName(Model model) {
		if (!model.getModel().endsWith(".statemachine")) {
			error("Model have to be a statemachine.",
					WorkflowPackage.MODEL__MODEL);
		}
	}

	/**
	 * Checks the targetPlatform for correct use of the parameter defensive.
	 * 
	 * @param targetPlatform
	 */
	@Check
	public void checkDefensiveForC(TargetPlatform targetPlatform) {
		if (targetPlatform.getTargetplatform().equals("c")
				&& targetPlatform.isDefensive()) {
			warning("Defensive code is not available for c.",
					WorkflowPackage.TARGET_PLATFORM__DEFENSIVE);
		}
	}
}
