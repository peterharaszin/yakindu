package org.kieler.synccharts.editor.module;

import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.kieler.synccharts.editor.factory.KielerMetaModelTypeFactory;
import org.kieler.synccharts.editor.factory.KielerPaletteFactory;
import org.kieler.synccharts.editor.parts.SyncTransitionEditPart;
import org.yakindu.sct.ui.editor.editor.guice.IMetaModelTypeFactory;
import org.yakindu.sct.ui.editor.module.SCTModule;
import org.yakindu.sct.ui.editor.providers.ISCTPaletteFactory;

public class KielerModule extends SCTModule {

	@Override
	protected Class<? extends IGraphicalEditPart> getTransitionEditPart() {
		return SyncTransitionEditPart.class;
	}

	@Override
	protected Class<? extends IMetaModelTypeFactory> getMetaModelTypeFactory() {
		return KielerMetaModelTypeFactory.class;
	}

	@Override
	protected Class<? extends ISCTPaletteFactory> getPaletteFactory() {
		return KielerPaletteFactory.class;
	}

	@Override
	protected String getFileExtension() {
		return "sync";
	}

}
