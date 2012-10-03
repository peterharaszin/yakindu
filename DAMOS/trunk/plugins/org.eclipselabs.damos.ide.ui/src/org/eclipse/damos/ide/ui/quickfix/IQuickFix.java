/****************************************************************************
 * Copyright (c) 2008, 2010 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipse.damos.ide.ui.quickfix;

import org.eclipse.damos.ide.core.validation.Problem;
import org.eclipse.swt.graphics.Image;

/**
 * @author Andreas Unger
 */
public interface IQuickFix {

    /**
     * Returns optional additional information about the quick fix.
     * The additional information will be presented to assist the user
     * in deciding if the selected proposal is the desired choice.
     *
     * @return the additional information or <code>null</code>
     */
    String getDescription();

    /**
     * Returns the image to be displayed in the list of quick fixes.
     * The image would typically be shown to the left of the display string.
     *
     * @return the image to be shown or <code>null</code> if no image is desired
     */
    Image getImage();

    /** 
     * Returns a short label indicating what the quick fix will do. 
     * 
     * @return a short label for this quick fix
     */
    String getLabel();

    /**
     * Runs this quick fix.
     * 
     * @param problem the problem to resolve
     */
    void run(Problem problem);

}
