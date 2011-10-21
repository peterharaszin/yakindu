package org.yakindu.sct.ui.editor.propertysheets;

import java.util.List;

import org.yakindu.sct.model.sgraph.NamedElement;
import org.yakindu.sct.model.sgraph.SGraphPackage;

import de.itemis.gmf.runtime.commons.properties.descriptors.IFormPropertyDescriptor;
import de.itemis.gmf.runtime.commons.properties.descriptors.TextPropertyDescriptor;

/**
 * Base property section for all model elements that inherit from
 * {@link NamedElement}
 * 
 * @author andreas muelder
 * 
 */
public abstract class NamePropertySection extends AbstractEditorPropertySection {

	@Override
	protected void createPropertyDescriptors(
			List<IFormPropertyDescriptor> descriptors) {
		TextPropertyDescriptor nameDescriptor = new TextPropertyDescriptor(
				SGraphPackage.Literals.NAMED_ELEMENT__NAME, "Name: ");
		descriptors.add(nameDescriptor);
	}
}
