package org.kieler.synccharts.editor.factory;

import org.kieler.synccharts.editor.helper.SyncTransitionEditHelper;
import org.kieler.syncharts.model.synccharts.SyncchartsPackage;
import org.yakindu.sct.ui.editor.editor.guice.StatechartMetaModelTypeFactory;
import org.yakindu.sct.ui.editor.providers.SemanticHints;

import com.google.inject.Inject;
import com.google.inject.Provider;

public class KielerMetaModelTypeFactory extends StatechartMetaModelTypeFactory {

	public static final String NORMAL_TRANSITION_ID = "org.kieler.synccharts.normaltransition";
	public static final String STRONG_TRANSITION_ID = "org.kieler.synccharts.strongtransition";
	public static final String WEAK_TRANSITION_ID = "org.kieler.synccharts.weaktransition";

	@Inject
	private Provider<SyncTransitionEditHelper> editHelper;

	@Override
	protected void registerCustomElementTypes(IMetaModelTypeAcceptor acceptor) {
		registerSyncTransition(acceptor);
	}

	protected void registerSyncTransition(IMetaModelTypeAcceptor acceptor) {
		acceptor.accept(new HintedMetamodelType(NORMAL_TRANSITION_ID,
				getUrlFromPlugin("icons/obj16/transition-16.png"),
				"SyncTransition", SyncchartsPackage.Literals.SYNC_TRANSITION,
				editHelper.get(), SemanticHints.TRANSITION));

		acceptor.accept(new HintedMetamodelType(STRONG_TRANSITION_ID,
				getUrlFromPlugin("icons/obj16/transition-16.png"),
				"SyncTransition", SyncchartsPackage.Literals.SYNC_TRANSITION,
				editHelper.get(), SemanticHints.TRANSITION));

		acceptor.accept(new HintedMetamodelType(WEAK_TRANSITION_ID,
				getUrlFromPlugin("icons/obj16/transition-16.png"),
				"SyncTransition", SyncchartsPackage.Literals.SYNC_TRANSITION,
				editHelper.get(), SemanticHints.TRANSITION));
	}

}
