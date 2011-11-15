package org.eclipselabs.damos.dml.ui.properties;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.jface.viewers.IFilter;
import org.eclipselabs.damos.dml.Latch;


public class LatchPropertySectionFilter implements IFilter {

	public boolean select(Object toTest) {
		if (toTest instanceof Latch) {
			return true;
		}
		if (toTest instanceof IAdaptable) {
			return ((IAdaptable) toTest).getAdapter(Latch.class) != null;
		}
		return false;
	}

}
