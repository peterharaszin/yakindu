package de.itemis.gmf.runtime.commons.highlighting;

import org.eclipse.emf.ecore.EObject;

/**
 * @author Alexander Nyssen
 * @author Andreas Muelder
 * 
 */
public interface IHighlightingSupport {

	/**
	 * Prevent user from editing
	 */
	void lockEditor();

	boolean isLocked();
	/**
	 * Allow user to edit model again
	 */
	void releaseEditor();

	void highlight(EObject semanticElement, HighlightingParameters parameters);

	/**
	 * Highlight a model element. Fading time may be zero to indicate that
	 * hightlighting should take place immediately.
	 * 
	 * @param modelElement
	 * @param parameterObject
	 */
	void fadeIn(EObject semanticElement, HighlightingParameters parameters);

	/**
	 * Unhighlight a model element. Fading time may be zero to indicate that
	 * hightlighting should be directly removed.
	 * 
	 * @param modelElement
	 * @param fadeOutTime
	 */
	void fadeOut(EObject semanticElement, HighlightingParameters parameters);

	/**
	 * Shortly highlight the given model element. The given fading time will be
	 * used for entering and leaving the highlighted state.
	 * 
	 * @param modelElement
	 * @param parameters
	 */
	void flash(EObject semanticElemesnt, HighlightingParameters parameters);

	public static class HighlightingSupportNullImpl implements
			IHighlightingSupport {

		public void lockEditor() {
		}

		public void releaseEditor() {
		}

		public void fadeIn(EObject semanticElement,
				HighlightingParameters parameters) {
		}

		public void fadeOut(EObject semanticElement,
				HighlightingParameters parameters) {
		}

		public void flash(EObject semanticElement,
				HighlightingParameters parameters) {
		}

		public void highlight(EObject semanticElement,
				HighlightingParameters parameters) {
			
		}

		public boolean isLocked() {
			// TODO Auto-generated method stub
			return false;
		}
	}
}
