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

package org.eclipselabs.damos.mscript.codegen.c;

/**
 * @author Andreas Unger
 *
 */
public interface ICodeFragmentDependency {

	boolean forwardDeclarationDependsOn(ICodeFragment other);

	boolean implementationDependsOn(ICodeFragment other);
	
	boolean forwardDeclarationRequiredBy(ICodeFragment other);
	
	boolean implementationRequiredBy(ICodeFragment other);

	public static class Stub implements ICodeFragmentDependency {

		/* (non-Javadoc)
		 * @see org.eclipselabs.damos.mscript.codegen.c.ICodeFragmentDependency#dependsOn(org.eclipselabs.damos.mscript.codegen.c.ICodeFragment)
		 */
		public boolean forwardDeclarationDependsOn(ICodeFragment other) {
			return false;
		}
		
		/* (non-Javadoc)
		 * @see org.eclipselabs.damos.mscript.codegen.c.ICodeFragmentDependency#implementationDependsOn(org.eclipselabs.damos.mscript.codegen.c.ICodeFragment)
		 */
		public boolean implementationDependsOn(ICodeFragment other) {
			return false;
		}

		/* (non-Javadoc)
		 * @see org.eclipselabs.damos.mscript.codegen.c.ICodeFragmentDependency#requiredBy(org.eclipselabs.damos.mscript.codegen.c.ICodeFragment)
		 */
		public boolean forwardDeclarationRequiredBy(ICodeFragment other) {
			return false;
		}
		
		/* (non-Javadoc)
		 * @see org.eclipselabs.damos.mscript.codegen.c.ICodeFragmentDependency#implementationRequiredBy(org.eclipselabs.damos.mscript.codegen.c.ICodeFragment)
		 */
		public boolean implementationRequiredBy(ICodeFragment other) {
			return false;
		}
		
	}
	
}
