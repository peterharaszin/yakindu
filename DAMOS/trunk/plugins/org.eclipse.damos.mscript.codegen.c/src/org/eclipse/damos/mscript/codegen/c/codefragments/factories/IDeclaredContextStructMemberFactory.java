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
package org.eclipse.damos.mscript.codegen.c.codefragments.factories;

import org.eclipse.damos.mscript.codegen.c.ICodeFragment;
import org.eclipse.damos.mscript.codegen.c.codefragments.DeclaredContextStructMember;
import org.eclipse.damos.mscript.codegen.c.codefragments.IContextStructMember;
import org.eclipse.damos.mscript.codegen.c.codefragments.factories.IDeclaredContextStructMemberFactory.Default;

import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import com.google.inject.Injector;

/**
 * @author Andreas Unger
 *
 */
@ImplementedBy(Default.class)
public interface IDeclaredContextStructMemberFactory {

	IContextStructMember create(String name, String typeName, ICodeFragment declarationCodeFragment);
	
	class Default implements IDeclaredContextStructMemberFactory {

		@Inject
		private Injector injector;
		
		@Override
		public IContextStructMember create(String name, String typeName, ICodeFragment declarationCodeFragment) {
			IContextStructMember contextStructMember = new DeclaredContextStructMember(name, typeName, declarationCodeFragment);
			injector.injectMembers(contextStructMember);
			return contextStructMember;
		}
		
	}
	
}
