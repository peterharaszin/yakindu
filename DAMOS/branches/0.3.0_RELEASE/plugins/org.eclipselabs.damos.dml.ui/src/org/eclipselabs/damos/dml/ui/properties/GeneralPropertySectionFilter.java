package org.eclipselabs.damos.dml.ui.properties;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.jface.viewers.IFilter;
import org.eclipselabs.damos.dml.Component;


public class GeneralPropertySectionFilter implements IFilter {

	public boolean select(Object toTest) {
		if (toTest instanceof Component) {
			return true;
		}
		if (toTest instanceof IAdaptable) {
			return ((IAdaptable) toTest).getAdapter(Component.class) != null;
		}
		return false;
	}

}
