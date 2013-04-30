package org.yakindu.sct.simulation.ui.model.presenter;

import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.swt.widgets.Display;
import org.yakindu.sct.model.sexec.Trace;
import org.yakindu.sct.simulation.ui.SimulationActivator;
import org.yakindu.sct.simulation.ui.preferences.SimulationPreferenceConstants;

import de.itemis.gmf.runtime.commons.highlighting.IHighlightingSupport;

/**
 * @author andreas muelder - Initial contribution and API
 * 
 */
public abstract class AbstractDynamicNotationHandler implements
		IDynamicNotationHandler, IPropertyChangeListener {

	protected abstract void visualizeStep(Trace trace);

	protected abstract void updatePreferences();

	public AbstractDynamicNotationHandler() {
		SimulationActivator.getDefault().getPreferenceStore()
				.addPropertyChangeListener(this);
	}

	private IHighlightingSupport support;

	public IHighlightingSupport getHighlightingSupport() {
		return support;
	}

	public void setHighlightingSupport(IHighlightingSupport support) {
		this.support = support;
	}

	public final void traceStepExecuted(final Trace trace) {
		Display.getDefault().asyncExec(new Runnable() {
			public void run() {
				visualizeStep(trace);
			}
		});
	}

	public void propertyChange(PropertyChangeEvent event) {
		if (SimulationPreferenceConstants.STATE_BACKGROUND_HIGHLIGHTING_COLOR
				.equals(event.getProperty())
				|| SimulationPreferenceConstants.TRANSITION_HIGHLIGHTING_COLOR
						.equals(event.getProperty())
				|| SimulationPreferenceConstants.STATE_FOREGROUND_HIGHLIGHTING_COLOR
						.equals(event.getProperty())) {
			updatePreferences();
		}
	}
}
