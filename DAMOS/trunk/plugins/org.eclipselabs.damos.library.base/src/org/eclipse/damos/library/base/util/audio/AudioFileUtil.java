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

package org.eclipse.damos.library.base.util.audio;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.damos.dml.Block;
import org.eclipse.damos.library.base.LibraryBasePlugin;
import org.eclipse.emf.common.util.URI;

/**
 * @author Andreas Unger
 *
 */
public class AudioFileUtil {

	public static IStatus checkFileURI(Block block) {
		String fileURIString = block.getArgumentStringValue(AudioFileConstants.PARAMETER__FILE_URI);
		if (fileURIString != null && fileURIString.trim().length() > 0) {
			try {
				URI uri = URI.createURI(fileURIString);
				if (!(uri.isFile() || uri.isPlatformResource())) {
					return new Status(IStatus.ERROR, LibraryBasePlugin.PLUGIN_ID, "Invalid file URI scheme");
				}
			} catch (IllegalArgumentException e) {
				return new Status(IStatus.ERROR, LibraryBasePlugin.PLUGIN_ID, "Invalid file URI");
			}
		} else {
			return new Status(IStatus.ERROR, LibraryBasePlugin.PLUGIN_ID, "No file URI specified");
		}
		return Status.OK_STATUS;
	}

}
