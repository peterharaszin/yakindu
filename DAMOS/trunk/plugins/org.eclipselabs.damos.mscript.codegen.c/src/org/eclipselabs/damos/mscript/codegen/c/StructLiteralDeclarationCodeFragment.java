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

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipselabs.damos.common.util.PrintAppendable;
import org.eclipselabs.damos.mscript.codegen.c.datatype.MachineDataTypes;
import org.eclipselabs.damos.mscript.codegen.c.util.MscriptGeneratorUtil;
import org.eclipselabs.damos.mscript.computationmodel.ComputationModel;
import org.eclipselabs.damos.mscript.interpreter.value.StructValue;

/**
 * @author Andreas Unger
 *
 */
public class StructLiteralDeclarationCodeFragment extends AbstractCodeFragment {

	private StructValue structValue;
	private ComputationModel computationModel;
	
	private String typeName;
	private String name;
	
	private CharSequence body;
	
	/**
	 * 
	 */
	public StructLiteralDeclarationCodeFragment(ComputationModel computationModel, StructValue value) {
		this.computationModel = computationModel;
		this.structValue = value;
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	@Override
	public void initialize(IAdaptable context, IProgressMonitor monitor) {
		addDependency(FORWARD_DECLARATION_DEPENDS_ON, new IDependencyRule() {
			
			public boolean applies(ICodeFragment other) {
				return other instanceof StructTypeDeclarationCodeFragment;
			}
			
		});

		StructTypeDeclarationCodeFragment structTypeDeclarationCodeFragment = new StructTypeDeclarationCodeFragment(computationModel, MachineDataTypes.create(computationModel, structValue.getDataType()));
		ICodeFragmentCollector codeFragmentCollector = (ICodeFragmentCollector) context.getAdapter(ICodeFragmentCollector.class);
		StructTypeDeclarationCodeFragment codeFragment = (StructTypeDeclarationCodeFragment) codeFragmentCollector.addCodeFragment(structTypeDeclarationCodeFragment, new NullProgressMonitor());
		typeName = codeFragment.getName();
		
		IGlobalNameProvider globalNameProvider = (IGlobalNameProvider) context.getAdapter(IGlobalNameProvider.class);
		name = globalNameProvider.getName("structure");

		body = MscriptGeneratorUtil.createInitializer(computationModel, codeFragmentCollector, structValue);
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.mscript.codegen.c.AbstractCodeFragment#contributesInternalForwardDeclaration()
	 */
	@Override
	public boolean contributesInternalForwardDeclaration() {
		return false;
	}
	
	public CharSequence generateForwardDeclaration(boolean internal) {
		StringBuilder sb = new StringBuilder();
		PrintAppendable out = new PrintAppendable(sb);
		out.printf("extern const %s %s;\n", typeName, name);
		return sb;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.mscript.codegen.c.AbstractCodeFragment#contributesImplementation()
	 */
	@Override
	public boolean contributesImplementation() {
		return true;
	}
	
	@Override
	public CharSequence generateImplementation(boolean internal) {
		StringBuilder sb = new StringBuilder();
		if (internal) {
			sb.append("static ");
		}
		PrintAppendable out = new PrintAppendable(sb);
		out.printf("const %s %s = ", typeName, name);
		out.print(body);
		out.print(";\n");
		return sb;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return getClass().hashCode(); // TODO: get hash from value
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof StructLiteralDeclarationCodeFragment) {
//			StructLiteralDeclarationCodeFragment other = (StructLiteralDeclarationCodeFragment) obj;
			// TODO: check equals using value
		}
		return false;
	}

}
