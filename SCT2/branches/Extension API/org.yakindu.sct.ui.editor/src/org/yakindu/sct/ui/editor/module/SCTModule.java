package org.yakindu.sct.ui.editor.module;

import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.xtext.ui.editor.validation.MarkerCreator;
import org.eclipse.xtext.ui.validation.MarkerTypeProvider;
import org.eclipse.xtext.validation.IDiagnosticConverter;
import org.yakindu.sct.model.sgraph.ui.validation.SCTMarkerCreator;
import org.yakindu.sct.model.sgraph.ui.validation.SCTMarkerTypeProvider;
import org.yakindu.sct.ui.editor.editor.StatechartDiagramEditor;
import org.yakindu.sct.ui.editor.editor.guice.IMetaModelTypeFactory;
import org.yakindu.sct.ui.editor.editor.guice.StatechartMetaModelTypeFactory;
import org.yakindu.sct.ui.editor.editparts.BorderItemEditPart;
import org.yakindu.sct.ui.editor.editparts.ChoiceEditPart;
import org.yakindu.sct.ui.editor.editparts.EntryEditPart;
import org.yakindu.sct.ui.editor.editparts.ExitEditPart;
import org.yakindu.sct.ui.editor.editparts.FinalStateEditPart;
import org.yakindu.sct.ui.editor.editparts.NamedElementLabelEditPart;
import org.yakindu.sct.ui.editor.editparts.RegionCompartmentEditPart;
import org.yakindu.sct.ui.editor.editparts.RegionEditPart;
import org.yakindu.sct.ui.editor.editparts.RegionNameEditPart;
import org.yakindu.sct.ui.editor.editparts.StateEditPart;
import org.yakindu.sct.ui.editor.editparts.StateFigureCompartmentEditPart;
import org.yakindu.sct.ui.editor.editparts.StateNameEditPart;
import org.yakindu.sct.ui.editor.editparts.StateTextCompartmentEditPart;
import org.yakindu.sct.ui.editor.editparts.StateTextCompartmentExpressionEditPart;
import org.yakindu.sct.ui.editor.editparts.StatechartDiagramEditPart;
import org.yakindu.sct.ui.editor.editparts.StatechartNameEditPart;
import org.yakindu.sct.ui.editor.editparts.StatechartTextEditPart;
import org.yakindu.sct.ui.editor.editparts.StatechartTextExpressionEditPart;
import org.yakindu.sct.ui.editor.editparts.TransitionEditPart;
import org.yakindu.sct.ui.editor.editparts.TransitionExpressionEditPart;
import org.yakindu.sct.ui.editor.providers.DefaultSCTPaletteFactory;
import org.yakindu.sct.ui.editor.providers.ISCTPaletteFactory;
import org.yakindu.sct.ui.editor.providers.SemanticHints;
import org.yakindu.sct.ui.editor.validation.SCTDiagnosticConverterImpl;
import org.yakindu.sct.ui.editor.wizards.DefaultDiagramInitializer;
import org.yakindu.sct.ui.editor.wizards.IDiagramInitializer;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class SCTModule extends AbstractModule implements SemanticHints {

	public static final String FILE_EXTENSION = "fileExtension";
	public static final String CONTRIBUTOR_ID = "propertySheetId";

	/**
	 * returns an implementation if {@link IMetaModelTypeFactory} that registers
	 * the default statechart {@link IElementType}s. Override if you want to
	 * contribute custom element types
	 * 
	 */
	protected Class<? extends IMetaModelTypeFactory> getMetaModelTypeFactory() {
		return StatechartMetaModelTypeFactory.class;
	}

	/**
	 * returns an implementation of {@link ISCTPaletteFactory} that registeres
	 * the default palette entries. Override if you want to add or remove
	 * palette entries.
	 */
	protected Class<? extends ISCTPaletteFactory> getPaletteFactory() {
		return DefaultSCTPaletteFactory.class;
	}

	/**
	 * returns an implementation of {@link IDiagramInitializer} that initializes
	 * new created diagrams.
	 * 
	 * @return
	 */
	protected Class<? extends IDiagramInitializer> getDiagramInitializer() {
		return DefaultDiagramInitializer.class;
	}

	/**
	 * Returns the default file extension for diagrams.
	 */
	protected String getFileExtension() {
		return "sct";
	}

	/**
	 * Override the property sheet id if you want to contribute your own
	 * property sheets via
	 * org.eclipse.ui.views.properties.tabbed.propertyContributor extension
	 * point
	 * 
	 */
	protected String getContributorId() {
		return "de.cau.cs.kieler.yakindu.sccharts.ui.editor.SCChartsDiagramEditor";
	}

	protected Class<? extends IGraphicalEditPart> getTransitionEditPart() {
		return TransitionEditPart.class;
	}

	protected Class<? extends IGraphicalEditPart> getStateEditPart() {
		return StateEditPart.class;
	}
	
	protected Class<? extends IGraphicalEditPart> getStateNameEditPart() {
		return StateNameEditPart.class;
	}
	
	protected Class<? extends IGraphicalEditPart> getStateTextCompartmentEditPart() {
		return StateTextCompartmentEditPart.class;
	}
	
	protected Class<? extends IGraphicalEditPart> getStateFigureCompartmentEditPart() {
		return StateFigureCompartmentEditPart.class;
	}
	
	protected Class<? extends IGraphicalEditPart> getRegionEditPart() {
		return RegionEditPart.class;
	}
	
	protected Class<? extends IGraphicalEditPart> getRegionNameEditPart() {
		return RegionNameEditPart.class;
	}
	protected Class<? extends IGraphicalEditPart> getChoiceEditPart() {
		return ChoiceEditPart.class;
	}
	
	protected Class<? extends IGraphicalEditPart> getEntryEditPart() {
		return EntryEditPart.class;
	}
	
	protected Class<? extends IGraphicalEditPart> getBorderItemEditPart() {
		return BorderItemEditPart.class;
	}

	protected Class<? extends IGraphicalEditPart> getFinalStateEditPart() {
		return FinalStateEditPart.class;
	}

	protected Class<? extends IGraphicalEditPart> getNamedElementLabelEditPart() {
		return NamedElementLabelEditPart.class;
	}

	protected Class<? extends IGraphicalEditPart> getExitEditPart() {
		return ExitEditPart.class;
	}
	
	protected Class<? extends IGraphicalEditPart> getStateTextCompartmentExpressionEditPart() {
		return StateTextCompartmentExpressionEditPart.class;
	}

	protected Class<? extends IGraphicalEditPart> getTransitionExpressionEditPart() {
		return TransitionExpressionEditPart.class;
	}

	protected Class<? extends IGraphicalEditPart> getRegionCompartmentEditPart() {
		return RegionCompartmentEditPart.class;
	}

	protected Class<? extends IGraphicalEditPart> getStatechartTextExpressionEditPart() {
		return StatechartTextExpressionEditPart.class;
	}

	protected Class<? extends IGraphicalEditPart> getStatechartTextEditPart() {
		return StatechartTextEditPart.class;
	}

	protected Class<? extends IGraphicalEditPart> getStatechartNameEditPart() {
		return StatechartNameEditPart.class;
	}
	
	@Override
	protected void configure() {
		bind(String.class).annotatedWith(Names.named(FILE_EXTENSION)).toInstance(getFileExtension());
		bind(IMetaModelTypeFactory.class).to(getMetaModelTypeFactory());
		bind(ISCTPaletteFactory.class).to(getPaletteFactory());
		bind(String.class).annotatedWith(Names.named(CONTRIBUTOR_ID)).toInstance(getContributorId());
		configureEditParts();
	}

	protected void configureEditParts() {
		bind(IGraphicalEditPart.class).annotatedWith(Names.named(StatechartDiagramEditor.ID)).to(
				StatechartDiagramEditPart.class);
		bind(IGraphicalEditPart.class).annotatedWith(Names.named(STATECHART_TEXT)).to(getStatechartTextEditPart());
		bind(IGraphicalEditPart.class).annotatedWith(Names.named(STATECHART_NAME)).to(getStatechartNameEditPart());

		bind(IGraphicalEditPart.class).annotatedWith(Names.named(STATECHART_TEXT_EXPRESSION)).to(
				getStatechartTextExpressionEditPart());

		bind(IGraphicalEditPart.class).annotatedWith(Names.named(REGION)).to(getRegionEditPart());
		bind(IGraphicalEditPart.class).annotatedWith(Names.named(REGION_NAME)).to(getRegionNameEditPart());
		bind(IGraphicalEditPart.class).annotatedWith(Names.named(REGION_COMPARTMENT)).to(
				getRegionCompartmentEditPart());
		bind(IGraphicalEditPart.class).annotatedWith(Names.named(TRANSITION)).to(getTransitionEditPart());
		bind(IGraphicalEditPart.class).annotatedWith(Names.named(TRANSITION_EXPRESSION)).to(
				getTransitionExpressionEditPart());
		bind(IGraphicalEditPart.class).annotatedWith(Names.named(STATE_NAME)).to(getStateNameEditPart());
		bind(IGraphicalEditPart.class).annotatedWith(Names.named(STATE_TEXT_COMPARTMENT)).to(
				getStateTextCompartmentEditPart());
		bind(IGraphicalEditPart.class).annotatedWith(Names.named(STATE_TEXT_COMPARTMENT_EXPRESSION)).to(
				getStateTextCompartmentExpressionEditPart());
		bind(IGraphicalEditPart.class).annotatedWith(Names.named(STATE_FIGURE_COMPARTMENT)).to(
				getStateFigureCompartmentEditPart());
		bind(IGraphicalEditPart.class).annotatedWith(Names.named(STATE)).to(getStateEditPart());
		bind(IGraphicalEditPart.class).annotatedWith(Names.named(CHOICE)).to(getChoiceEditPart());
		bind(IGraphicalEditPart.class).annotatedWith(Names.named(DEEPHISTORY)).to(getEntryEditPart());
		bind(IGraphicalEditPart.class).annotatedWith(Names.named(SHALLOWHISTORY)).to(getEntryEditPart());
		bind(IGraphicalEditPart.class).annotatedWith(Names.named(ENTRY)).to(getEntryEditPart());
		bind(IGraphicalEditPart.class).annotatedWith(Names.named(FINALSTATE)).to(getFinalStateEditPart());
		bind(IGraphicalEditPart.class).annotatedWith(Names.named(EXIT)).to(getExitEditPart());
		bind(IGraphicalEditPart.class).annotatedWith(Names.named(BORDER_ITEM_LABEL_CONTAINER)).to(
				getNamedElementLabelEditPart());
		bind(IGraphicalEditPart.class).annotatedWith(Names.named(BORDER_ITEM_LABEL)).to(getBorderItemEditPart());
		bind(IGraphicalEditPart.class).annotatedWith(Names.named(SYNCHRONIZATION)).to(getStateEditPart());
		bind(IDiagramInitializer.class).to(getDiagramInitializer());
		bind(MarkerCreator.class).to(SCTMarkerCreator.class);
		bind(MarkerTypeProvider.class).to(SCTMarkerTypeProvider.class);
		bind(IDiagnosticConverter.class).to(SCTDiagnosticConverterImpl.class);

	}
}
