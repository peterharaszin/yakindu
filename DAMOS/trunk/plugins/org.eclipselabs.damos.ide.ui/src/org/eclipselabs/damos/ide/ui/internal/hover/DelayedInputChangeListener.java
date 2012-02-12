package org.eclipselabs.damos.ide.ui.internal.hover;

import org.eclipse.jface.text.IDelayedInputChangeProvider;
import org.eclipse.jface.text.IInputChangedListener;


/**
 * A delayed input change listener that forwards delayed input changes to an information control replacer.
 *
 * @since 3.4
 */
public final class DelayedInputChangeListener implements IInputChangedListener {

	private final IDelayedInputChangeProvider fChangeProvider;
	private final InformationControlReplacer fInformationControlReplacer;

	/**
	 * Creates a new listener.
	 *
	 * @param changeProvider the information control with delayed input changes
	 * @param informationControlReplacer the information control replacer, whose information control should get the new input
	 */
	public DelayedInputChangeListener(IDelayedInputChangeProvider changeProvider, InformationControlReplacer informationControlReplacer) {
		fChangeProvider= changeProvider;
		fInformationControlReplacer= informationControlReplacer;
	}

	/*
	 * @see org.eclipse.jface.text.IDelayedInputChangeListener#inputChanged(java.lang.Object)
	 */
	public void inputChanged(Object newInput) {
		fChangeProvider.setDelayedInputChangeListener(null);
		fInformationControlReplacer.setDelayedInput(newInput);
	}
}
