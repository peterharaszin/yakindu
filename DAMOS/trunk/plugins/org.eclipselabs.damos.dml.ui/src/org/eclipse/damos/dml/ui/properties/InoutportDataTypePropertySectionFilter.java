package org.eclipse.damos.dml.ui.properties;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.damos.dml.Inoutport;
import org.eclipse.jface.viewers.IFilter;


public class InoutportDataTypePropertySectionFilter implements IFilter {

	public boolean select(Object toTest) {
		if (toTest instanceof Inoutport) {
			return true;
		}
		if (toTest instanceof IAdaptable) {
			return ((IAdaptable) toTest).getAdapter(Inoutport.class) != null;
		}
		return false;
	}

}
