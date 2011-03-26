package org.eclipselabs.damos.diagram.ui.internal.editpolicies;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipselabs.damos.dml.DMLPackage;
import org.eclipselabs.damos.dml.WhileLoop;

/**
 * @author Andreas Unger
 *
 */
public class WhileLoopCanonicalEditPolicy extends CompoundCanonicalEditPolicy {
	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy#getSemanticChildrenList()
	 */
	@Override
	protected List<EObject> getSemanticChildrenList() {
		WhileLoop compound = (WhileLoop) resolveSemanticElement();
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
		return DMLPackage.eINSTANCE.getWhileLoop_Condition();
	}

}