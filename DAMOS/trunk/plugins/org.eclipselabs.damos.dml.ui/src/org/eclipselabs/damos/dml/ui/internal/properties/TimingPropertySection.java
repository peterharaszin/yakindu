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

package org.eclipselabs.damos.dml.ui.internal.properties;

import org.eclipse.core.databinding.UpdateValueStrategy;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.property.value.IValueProperty;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.databinding.FeaturePath;
import org.eclipse.emf.databinding.edit.EMFEditProperties;
import org.eclipse.jface.databinding.swt.IWidgetValueProperty;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.jface.databinding.viewers.IViewerValueProperty;
import org.eclipse.jface.databinding.viewers.ViewerProperties;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eclipselabs.damos.dml.AsynchronousTimingConstraint;
import org.eclipselabs.damos.dml.Component;
import org.eclipselabs.damos.dml.ContinuousTimingConstraint;
import org.eclipselabs.damos.dml.DMLFactory;
import org.eclipselabs.damos.dml.DMLPackage;
import org.eclipselabs.damos.dml.OpaqueSampleTimeSpecification;
import org.eclipselabs.damos.dml.SynchronousTimingConstraint;
import org.eclipselabs.damos.dml.ui.internal.databinding.TextualElementUpdateValueStrategy;

/**
 * @author Andreas Unger
 *
 */
public class TimingPropertySection extends AbstractModelPropertySection {

	private ComboViewer timingConstraintViewer;
	private Text sampleTimeText;
	
	private EMFDataBindingContext context;
	
	private IObservableValue sampleTimeTextObservable;
	private IObservableValue sampleTimeObservable;
	private IObservableValue timingConstraintViewerObservable;
	private IObservableValue timingConstraintObservable;
	private IObservableValue sampleTimeTextEnabledObservable;
	private IObservableValue sampleTimeLabelEnabledObservable;
	private Label sampleTimeLabel;
	
	private enum TimingConstraintKind {
		
		INHERITED("Inherited"),
		CONTINUOUS("Continuous"),
		SYNCHRONOUS("Synchronous"),
		ASYNCHRONOUS("Asynchronous");
		
		private String name;
		
		TimingConstraintKind(String name) {
			this.name = name;
		}
		
		/**
		 * @return the name
		 */
		public String getName() {
			return name;
		}
		
	};
	
	public void createControls(Composite parent, TabbedPropertySheetPage aTabbedPropertySheetPage) {
		super.createControls(parent, aTabbedPropertySheetPage);
		
		Composite client = (Composite) PropertySectionUtil.createTopLevelSection(parent, "Timing Information", 2,
				getWidgetFactory()).getClient();
		
		Label timingConstraintLabel = getWidgetFactory().createLabel(client, "Timing Constraint:");
		GridData gridData = new GridData();
		timingConstraintLabel.setLayoutData(gridData);

		CCombo combo = getWidgetFactory().createCCombo(client, SWT.BORDER | SWT.READ_ONLY);
		gridData = new GridData();
		combo.setLayoutData(gridData);
		timingConstraintViewer = new ComboViewer(combo);

		sampleTimeLabel = getWidgetFactory().createLabel(client, "Sample Time (seconds):");
		gridData = new GridData();
		sampleTimeLabel.setLayoutData(gridData);
		
		sampleTimeText = getWidgetFactory().createText(client, "");
		gridData = new GridData(SWT.FILL, SWT.CENTER, true, false);
		sampleTimeText.setLayoutData(gridData);

		timingConstraintViewer.setLabelProvider(new LabelProvider() {
			
			@Override
			public String getText(Object element) {
				if (element instanceof TimingConstraintKind) {
					return ((TimingConstraintKind) element).getName();
				}
				return super.getText(element);
			}
			
		});
		
		timingConstraintViewer.setContentProvider(new ArrayContentProvider());
		timingConstraintViewer.setInput(TimingConstraintKind.values());
		timingConstraintViewer.addFilter(new ViewerFilter() {
			
			@Override
			public boolean select(Viewer viewer, Object parentElement, Object element) {
				Component component = getComponent();
				if (component != null) {
					switch ((TimingConstraintKind) element) {
					case INHERITED:
						return true;
					case CONTINUOUS:
						return component.isTimingConstraintApplicable(DMLPackage.eINSTANCE.getContinuousTimingConstraint());
					case SYNCHRONOUS:
						return component.isTimingConstraintApplicable(DMLPackage.eINSTANCE.getSynchronousTimingConstraint());
					case ASYNCHRONOUS:
						return component.isTimingConstraintApplicable(DMLPackage.eINSTANCE.getAsynchronousTimingConstraint());
					}
				}
				return false;
			}
			
		});
		
		initializeDataBinding();
	}

	private void initializeDataBinding() {
		context = new EMFDataBindingContext();

		IWidgetValueProperty sampleTimeUIProperty = WidgetProperties.text(new int[] { SWT.DefaultSelection, SWT.FocusOut });
		sampleTimeTextObservable = sampleTimeUIProperty.observe(sampleTimeText);

		IViewerValueProperty timingConstraintUIProperty = ViewerProperties.singleSelection();
		timingConstraintViewerObservable = timingConstraintUIProperty.observe(timingConstraintViewer);
		
		sampleTimeTextEnabledObservable = WidgetProperties.enabled().observe(sampleTimeText);
		sampleTimeLabelEnabledObservable = WidgetProperties.enabled().observe(sampleTimeLabel);
	}
	
	private Component getComponent() {
		return (Component) getModel();
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.ui.views.properties.tabbed.AbstractPropertySection#refresh()
	 */
	@Override
	public void refresh() {
		super.refresh();
		disposeModelObservables();
		
		// Refresh viewer to refilter the input
		timingConstraintViewer.refresh();

		IValueProperty sampleTimeProperty = EMFEditProperties.value(
				getEditingDomain(),
				FeaturePath.fromList(DMLPackage.eINSTANCE.getComponent_TimingConstraint(),
						DMLPackage.eINSTANCE.getSynchronousTimingConstraint_SampleTime()));
		sampleTimeObservable = sampleTimeProperty.observe(getComponent());
		context.bindValue(sampleTimeTextObservable, sampleTimeObservable, new TextualElementUpdateValueStrategy(
				DMLPackage.eINSTANCE.getOpaqueSampleTimeSpecification()), new SampleTimeUpdateValueStrategy());

		IValueProperty timingConstraintProperty = EMFEditProperties.value(getEditingDomain(),
				DMLPackage.eINSTANCE.getComponent_TimingConstraint());
		timingConstraintObservable = timingConstraintProperty.observe(getComponent());
		UpdateValueStrategy timingConstraintUpdateStrategy = new TimingConstraintUpdateStrategy();
		context.bindValue(timingConstraintViewerObservable, timingConstraintObservable, timingConstraintUpdateStrategy,
				timingConstraintUpdateStrategy);
		
		context.bindValue(sampleTimeTextEnabledObservable, timingConstraintObservable, new UpdateValueStrategy(
				UpdateValueStrategy.POLICY_NEVER), new SynchronousTimingConstraintUpdateValueStrategy());
		context.bindValue(sampleTimeLabelEnabledObservable, timingConstraintObservable, new UpdateValueStrategy(
				UpdateValueStrategy.POLICY_NEVER), new SynchronousTimingConstraintUpdateValueStrategy());
	}

	/**
	 * 
	 */
	private void disposeModelObservables() {
		if (timingConstraintObservable != null) {
			timingConstraintObservable.dispose();
			timingConstraintObservable = null;
		}
		if (sampleTimeObservable != null) {
			sampleTimeObservable.dispose();
			sampleTimeObservable = null;
		}
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.views.properties.tabbed.AbstractPropertySection#dispose()
	 */
	@Override
	public void dispose() {
		disposeModelObservables();
		super.dispose();
	}
	
	private class TimingConstraintUpdateStrategy extends UpdateValueStrategy {
		
		private ContinuousTimingConstraint continuousTimingConstraint;
		private SynchronousTimingConstraint synchronousTimingConstraint;
		private AsynchronousTimingConstraint asynchronousTimingConstraint;
		
		/* (non-Javadoc)
		 * @see org.eclipse.core.databinding.UpdateValueStrategy#convert(java.lang.Object)
		 */
		@Override
		public Object convert(Object value) {
			if (value instanceof TimingConstraintKind) {
				switch ((TimingConstraintKind) value) {
				case INHERITED:
					return null;
				case CONTINUOUS:
					return getContinuousTimingConstraint();
				case SYNCHRONOUS:
					return getSynchronousTimingConstraint();
				case ASYNCHRONOUS:
					return getAsynchronousTimingConstraint();
				}
			} else {
				if (value == null) {
					return TimingConstraintKind.INHERITED;
				}
				if (value instanceof ContinuousTimingConstraint) {
					return TimingConstraintKind.CONTINUOUS;
				}
				if (value instanceof SynchronousTimingConstraint) {
					return TimingConstraintKind.SYNCHRONOUS;
				}
				if (value instanceof AsynchronousTimingConstraint) {
					return TimingConstraintKind.ASYNCHRONOUS;
				}
			}
			throw new IllegalArgumentException();
		}
		
		/**
		 * @return the continuousTimingConstraint
		 */
		private ContinuousTimingConstraint getContinuousTimingConstraint() {
			if (continuousTimingConstraint == null) {
				if (getComponent().getTimingConstraint() instanceof ContinuousTimingConstraint) {
					continuousTimingConstraint = (ContinuousTimingConstraint) getComponent().getTimingConstraint();
				} else {
					continuousTimingConstraint = DMLFactory.eINSTANCE.createContinuousTimingConstraint();;
				}
			}
			return continuousTimingConstraint;
		}
		
		/**
		 * @return the synchronousTimingConstraint
		 */
		private SynchronousTimingConstraint getSynchronousTimingConstraint() {
			if (synchronousTimingConstraint == null) {
				if (getComponent().getTimingConstraint() instanceof SynchronousTimingConstraint) {
					synchronousTimingConstraint = (SynchronousTimingConstraint) getComponent().getTimingConstraint();
				} else {
					synchronousTimingConstraint = DMLFactory.eINSTANCE.createSynchronousTimingConstraint();
					OpaqueSampleTimeSpecification sampleTimeSpecification = DMLFactory.eINSTANCE.createOpaqueSampleTimeSpecification();
					sampleTimeSpecification.setSampleTime("1");
					synchronousTimingConstraint.setSampleTime(sampleTimeSpecification);
				}
			}
			return synchronousTimingConstraint;
		}
		
		/**
		 * @return the asynchronousTimingConstraint
		 */
		private AsynchronousTimingConstraint getAsynchronousTimingConstraint() {
			if (asynchronousTimingConstraint == null) {
				if (getComponent().getTimingConstraint() instanceof AsynchronousTimingConstraint) {
					asynchronousTimingConstraint = (AsynchronousTimingConstraint) getComponent().getTimingConstraint();
				} else {
					asynchronousTimingConstraint = DMLFactory.eINSTANCE.createAsynchronousTimingConstraint();
				}
			}
			return asynchronousTimingConstraint;
		}
		
	}
	
	private static final class SynchronousTimingConstraintUpdateValueStrategy extends UpdateValueStrategy {

		/* (non-Javadoc)
		 * @see org.eclipse.core.databinding.UpdateValueStrategy#convert(java.lang.Object)
		 */
		@Override
		public Object convert(Object value) {
			return value instanceof SynchronousTimingConstraint;
		}
		
	}

	private static class SampleTimeUpdateValueStrategy extends TextualElementUpdateValueStrategy {
		
		@Override
		protected IStatus doSet(IObservableValue observableValue, Object value) {
			if (value != null) {
				return super.doSet(observableValue, value);
			}
			return Status.OK_STATUS;
		}

	}

}
