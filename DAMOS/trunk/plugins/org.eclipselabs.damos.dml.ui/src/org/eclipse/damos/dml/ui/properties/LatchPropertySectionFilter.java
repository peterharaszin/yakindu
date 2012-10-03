package org.eclipse.damos.dml.ui.properties;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.damos.dml.Latch;
import org.eclipse.jface.viewers.IFilter;


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
