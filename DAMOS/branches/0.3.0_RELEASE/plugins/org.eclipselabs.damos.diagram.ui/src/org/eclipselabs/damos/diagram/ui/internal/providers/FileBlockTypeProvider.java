package org.eclipselabs.damos.diagram.ui.internal.providers;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.edit.domain.EditingDomain;

/**
 * @author Andreas Unger
 *
 */
public class FileBlockTypeProvider extends AbstractFileBlockTypeProvider {
	/**
	 * 
	 */
	private final IFile file;

	/**
	 * @param editingDomain
	 * @param file
	 */
	public FileBlockTypeProvider(EditingDomain editingDomain, IFile file) {
		super(editingDomain);
		this.file = file;
	}

	protected IFile getFile() {
		return file;
	}
}