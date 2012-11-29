package org.kieler.synccharts.editor.factory;

import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteStack;
import org.eclipse.jface.resource.ImageDescriptor;
import org.kieler.synccharts.editor.Activator;
import org.yakindu.sct.ui.editor.providers.DefaultSCTPaletteFactory;

public class KielerPaletteFactory extends DefaultSCTPaletteFactory {

	@Override
	protected void createTransitionEntry(PaletteContainer container) {
		PaletteStack stack = new PaletteStack("Stack", "", null);
		container.add(stack);

		stack.add(new ConnectionCreationToolEntry("Normal Transition",
				"Creates a normal transition",
				getType(KielerMetaModelTypeFactory.NORMAL_TRANSITION_ID),
				findIcon("icons/obj16/transition-normal-16.png"),
				findIcon("icons/obj32/transition-normal-32.png")));

		stack.add(new ConnectionCreationToolEntry("Weak Transition",
				"Creates a weak transition",
				getType(KielerMetaModelTypeFactory.WEAK_TRANSITION_ID),
				findIcon("icons/obj16/transition-weak-16.png"),
				findIcon("icons/obj32/transition-weak-32.png")));

		stack.add(new ConnectionCreationToolEntry("Strong Transition",
				"Creates a strong transition",
				getType(KielerMetaModelTypeFactory.STRONG_TRANSITION_ID),
				findIcon("icons/obj16/transition-strong-16.png"),
				findIcon("icons/obj32/transition-strong-32.png")));

	}

	private ImageDescriptor findIcon(String iconPath) {
		return super.getImageDescriptor(iconPath, Activator.getDefault()
				.getBundle());
	}

}
