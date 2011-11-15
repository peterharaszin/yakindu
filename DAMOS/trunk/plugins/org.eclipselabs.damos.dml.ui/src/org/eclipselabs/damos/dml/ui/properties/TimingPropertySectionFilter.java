package org.eclipselabs.damos.dml.ui.properties;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.jface.viewers.IFilter;
import org.eclipselabs.damos.dml.Component;
import org.eclipselabs.damos.dml.DMLPackage;


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
