package org.eclipselabs.damos.diagram.ui.internal.editpolicies;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipselabs.damos.diagram.ui.view.ISemanticHints;
import org.eclipselabs.damos.dml.ConditionalCompound;
import org.eclipselabs.damos.dml.DMLPackage;

/**
 * @author Andreas Unger
 *
 */
public class CompoundCanonicalEditPolicy extends CanonicalEditPolicy {
	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy#getSemanticChildrenList()
	 */
	@Override
	protected List<EObject> getSemanticChildrenList() {
		ConditionalCompound compound = (ConditionalCompound) resolveSemanticElement();
		if (compound != null) {
			return Collections.<EObject>singletonList(compound.getCondition());
		}
		return Collections.<EObject>emptyList();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy#getFeatureToSynchronize()
	 */
	@Override
	protected EStructuralFeature getFeatureToSynchronize() {
		return DMLPackage.eINSTANCE.getConditionalCompound_Condition();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy#shouldDeleteView(org.eclipse.gmf.runtime.notation.View)
	 */
	@Override
	protected boolean shouldDeleteView(View view) {
		return !ISemanticHints.COMPOUND_COMPARTMENT.equals(view.getType());
	}
	
}