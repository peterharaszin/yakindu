package org.eclipselabs.damos.diagram.ui.internal.properties;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.jface.viewers.IFilter;
import org.eclipselabs.damos.dml.Inoutport;


public class InoutportDataTypePropertySectionFilter implements IFilter {

	public boolean select(Object toTest) {
		if (toTest instanceof IAdaptable) {
			return ((IAdaptable) toTest).getAdapter(Inoutport.class) != null;
		}
		return false;
	}

}
