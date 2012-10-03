package org.eclipse.damos.dml.ui.properties;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.damos.dml.Component;
import org.eclipse.damos.dml.DMLPackage;
import org.eclipse.jface.viewers.IFilter;


public class TimingPropertySectionFilter implements IFilter {

	public boolean select(Object toTest) {
		if (toTest instanceof IAdaptable) {
			Component component = (Component) ((IAdaptable) toTest).getAdapter(Component.class);
			if (component != null) {
				if (component.isTimingConstraintApplicable(DMLPackage.eINSTANCE.getSynchronousTimingConstraint())) {
					return true;
				}
				
				int n = 0;
				if (component.isTimingConstraintApplicable(DMLPackage.eINSTANCE.getContinuousTimingConstraint())) {
					++n;
				}
				if (component.isTimingConstraintApplicable(DMLPackage.eINSTANCE.getAsynchronousTimingConstraint())) {
					++n;
				}
				return n > 1;
			}
		}
		return false;
	}

}
