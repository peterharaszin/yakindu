/****************************************************************************
 * Copyright (c) 2008, 2012 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipselabs.damos.ide.ui.internal.providers;

import java.util.Collection;

import org.eclipse.core.resources.IMarker;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IMarkerResolution;
import org.eclipse.ui.IMarkerResolution2;
import org.eclipse.ui.IMarkerResolutionGenerator;
import org.eclipselabs.damos.ide.core.validation.Problem;
import org.eclipselabs.damos.ide.ui.internal.registry.QuickFixProviderRegistry;
import org.eclipselabs.damos.ide.ui.quickfix.IQuickFix;

/**
 * @author Andreas Unger
 *
 */
public class QuickFixMarkerResolutionGenerator implements IMarkerResolutionGenerator {
	
	private static final IMarkerResolution[] EMPTY_RESOLUTIONS = new IMarkerResolution[0];

	/* (non-Javadoc)
	 * @see org.eclipse.ui.IMarkerResolutionGenerator#getResolutions(org.eclipse.core.resources.IMarker)
	 */
	public IMarkerResolution[] getResolutions(IMarker marker) {
		Collection<IQuickFix> quickFixes = QuickFixProviderRegistry.getInstance().getQuickFixes(Problem.create(marker));
		if (quickFixes.isEmpty()) {
			return EMPTY_RESOLUTIONS;
		}
		IMarkerResolution[] resolutions = new IMarkerResolution[quickFixes.size()];
		int i = 0;
		for (IQuickFix quickFix : quickFixes) {
			resolutions[i++] = new QuickFixMarkerResolution(quickFix);
		}
		return resolutions;
	}
	
	private static class QuickFixMarkerResolution implements IMarkerResolution2 {

		private final IQuickFix quickFix;
		
		/**
		 * 
		 */
		public QuickFixMarkerResolution(IQuickFix quickFix) {
			this.quickFix = quickFix;
		}
		
		/* (non-Javadoc)
		 * @see org.eclipse.ui.IMarkerResolution#getLabel()
		 */
		public String getLabel() {
			return quickFix.getLabel();
		}

		/* (non-Javadoc)
		 * @see org.eclipse.ui.IMarkerResolution2#getDescription()
		 */
		public String getDescription() {
			return quickFix.getDescription();
		}

		/* (non-Javadoc)
		 * @see org.eclipse.ui.IMarkerResolution2#getImage()
		 */
		public Image getImage() {
			return quickFix.getImage();
		}

		/* (non-Javadoc)
		 * @see org.eclipse.ui.IMarkerResolution#run(org.eclipse.core.resources.IMarker)
		 */
		public void run(IMarker marker) {
			quickFix.run(Problem.create(marker));
		}
		
	}

}
