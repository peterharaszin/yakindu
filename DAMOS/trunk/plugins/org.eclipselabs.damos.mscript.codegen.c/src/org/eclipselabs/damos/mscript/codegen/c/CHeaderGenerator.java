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

import java.util.Collection;
import java.util.Set;
import java.util.TreeSet;

import org.eclipselabs.damos.common.util.PrintAppendable;

/**
 * @author Andreas Unger
 *
 */
public class CHeaderGenerator implements ICModuleGenerator {

	public CharSequence generate(CModule module) {
		StringBuilder sb = new StringBuilder();
		PrintAppendable out = new PrintAppendable(sb);

		if (module.getHeaderComment() != null) {
			out.println(module.getHeaderComment());
		}

		String headerMacro = module.getName().replaceAll("\\W", "_").toUpperCase() + "_H_";
		out.printf("#ifndef %s\n", headerMacro);
		out.printf("#define %s\n", headerMacro);
		out.println();
		
		Collection<Include> includes = getIncludes(module);
		
		for (Include include : includes) {
			out.println(include.toString());
		}
		
		if (!includes.isEmpty()) {
			out.println();
		}
		
		out.println("#ifdef __cplusplus");
		out.println("extern \"C\" {");
		out.println("#endif /* __cplusplus */");
		out.println();
		
		// Write external forward declarations
		for (CModuleEntry entry : module.getEntries()) {
			if (!entry.isInternal()) {
				out.print(entry.getCodeFragment().generateForwardDeclaration(false));
				out.println();
			}
		}
		
		out.println("#ifdef __cplusplus");
		out.println("}");
		out.println("#endif /* __cplusplus */");
		out.println();
		out.printf("#endif /* %s */\n", headerMacro);
		
		return sb;
	}

	/**
	 * @param module
	 * @return
	 */
	private Collection<Include> getIncludes(CModule module) {
		// Add external forward declaration includes
		Set<Include> includes = new TreeSet<Include>();
		for (CModuleEntry entry : module.getEntries()) {
			if (!entry.isInternal()) {
				for (Include include : entry.getCodeFragment().getForwardDeclarationIncludes()) {
					includes.add(include);
				}
			}
		}
		return includes;
	}

}
