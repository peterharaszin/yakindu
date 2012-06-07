/****************************************************************************
 * Copyright (c) 2008, 2011 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipselabs.damos.ide.ui;

import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipselabs.damos.common.inject.Default;
import org.eclipselabs.damos.diagram.core.resource.BlockDiagramFileExtension;
import org.eclipselabs.damos.diagram.ui.parts.BlockDiagramEditorId;
import org.eclipselabs.damos.diagram.ui.preferences.IDefaultCommonBlockTypesProvider;
import org.eclipselabs.damos.diagram.ui.tools.IValueSpecificationDirectEditHelper;
import org.eclipselabs.damos.dml.ui.editpane.IDataTypeSpecificationEditPane;
import org.eclipselabs.damos.dml.ui.editpane.IParameterEditPaneProvider;
import org.eclipselabs.damos.dml.ui.editpane.IValueSpecificationEditPane;
import org.eclipselabs.damos.dml.ui.parts.BlockLibraryViewId;
import org.eclipselabs.damos.dml.ui.parts.FragmentExplorerViewId;
import org.eclipselabs.damos.dml.ui.properties.ContributorId;
import org.eclipselabs.damos.ide.ui.internal.directedit.ValueSpecificationDirectEditHelper;
import org.eclipselabs.damos.ide.ui.internal.editors.DataTypeSpecificationEditPane;
import org.eclipselabs.damos.ide.ui.internal.editors.ValueSpecificationEditPane;
import org.eclipselabs.damos.ide.ui.internal.providers.DefaultCommonBlockTypesProvider;
import org.eclipselabs.damos.ide.ui.internal.providers.ParameterEditPaneProvider;

import com.google.inject.AbstractModule;

/**
 * @author Andreas Unger
 *
 */
public class IDEUIModule extends AbstractModule {

	private static final String BLOCK_DIAGRAM_EDITOR_ID = "org.eclipselabs.damos.ide.ui.blockDiagramEditor";

	static final PreferencesHint PREFERENCES_HINT = new PreferencesHint(BLOCK_DIAGRAM_EDITOR_ID);

	/* (non-Javadoc)
	 * @see com.google.inject.AbstractModule#configure()
	 */
	@Override
	protected void configure() {
		configureContributorId();
		configureBlockLibraryViewId();
		configureFragmentExplorerViewId();
		configureBlockDiagramFileExtension();
		configureIValueSpecificationEditor();
		configureIDataTypeSpecificationEditor();
		configureIValueSpecificationDirectEditHelper();
		configureIArgumentEditorProvider();
		configureIDefaultCommonBlockTypesProvider();
		configureBlockDiagramEditorId();
		configurePreferencesHint();
	}
	
	protected void configureContributorId() {
		bind(String.class).annotatedWith(ContributorId.class).toInstance("org.eclipselabs.damos.ide.ui.properties");
	}

	protected void configureBlockLibraryViewId() {
		bind(String.class).annotatedWith(BlockLibraryViewId.class).toInstance("org.eclipselabs.damos.ide.ui.blockLibraryView");
	}

	protected void configureFragmentExplorerViewId() {
		bind(String.class).annotatedWith(FragmentExplorerViewId.class).toInstance("org.eclipselabs.damos.ide.ui.fragmentExplorerView");
	}
	
	protected void configureBlockDiagramFileExtension() {
		bind(String.class).annotatedWith(BlockDiagramFileExtension.class).toInstance("blockdiagram");
	}
	
	protected void configureIValueSpecificationEditor() {
		bind(IValueSpecificationEditPane.class).to(ValueSpecificationEditPane.class);
	}

	protected void configureIDataTypeSpecificationEditor() {
		bind(IDataTypeSpecificationEditPane.class).to(DataTypeSpecificationEditPane.class);
	}
	
	protected void configureIValueSpecificationDirectEditHelper() {
		bind(IValueSpecificationDirectEditHelper.class).to(ValueSpecificationDirectEditHelper.class);
	}

	protected void configureIArgumentEditorProvider() {
		bind(IParameterEditPaneProvider.class).annotatedWith(Default.class).to(ParameterEditPaneProvider.class);
	}

	protected void configureIDefaultCommonBlockTypesProvider() {
		bind(IDefaultCommonBlockTypesProvider.class).to(DefaultCommonBlockTypesProvider.class);
	}

	protected void configureBlockDiagramEditorId() {
		bind(String.class).annotatedWith(BlockDiagramEditorId.class).toInstance(BLOCK_DIAGRAM_EDITOR_ID);
	}

	protected void configurePreferencesHint() {
		bind(PreferencesHint.class).toInstance(PREFERENCES_HINT);
	}

}
