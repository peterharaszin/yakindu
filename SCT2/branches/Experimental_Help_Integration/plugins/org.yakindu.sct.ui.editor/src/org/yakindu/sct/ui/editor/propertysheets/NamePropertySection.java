package org.yakindu.sct.ui.editor.propertysheets;

import java.util.List;

import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Layout;
import org.yakindu.sct.model.sgraph.NamedElement;
import org.yakindu.sct.model.sgraph.SGraphPackage;

import de.itemis.gmf.runtime.commons.properties.descriptors.IFormPropertyDescriptor;
import de.itemis.gmf.runtime.commons.properties.descriptors.TextPropertyDescriptorWithHelp;
/**
 * Base property section for all model elements that inherit from {@link NamedElement}
 * @author andreas muelder
 *
 */
public abstract class NamePropertySection extends AbstractEditorPropertySection{

	@Override
	protected void createPropertyDescriptors(
			List<IFormPropertyDescriptor> descriptors) {
		TextPropertyDescriptorWithHelp nameDescriptor = new TextPropertyDescriptorWithHelp(
				SGraphPackage.Literals.NAMED_ELEMENT__NAME, "Name: ");
		descriptors.add(nameDescriptor);
	}

	@Override
	protected Layout createBodyLayout() {
		return new GridLayout(3,false);
	}
	
}
