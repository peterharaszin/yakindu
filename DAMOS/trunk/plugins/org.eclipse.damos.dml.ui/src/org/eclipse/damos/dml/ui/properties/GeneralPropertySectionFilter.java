package org.eclipse.damos.dml.ui.properties;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.damos.dml.Component;
import org.eclipse.jface.viewers.IFilter;


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
