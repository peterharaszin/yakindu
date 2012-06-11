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

package org.eclipselabs.damos.mscript.codegen.c.codefragments;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipselabs.damos.common.util.PrintAppendable;
import org.eclipselabs.damos.mscript.codegen.c.AbstractCodeFragment;
import org.eclipselabs.damos.mscript.codegen.c.DataTypeGenerator;
import org.eclipselabs.damos.mscript.codegen.c.ICodeFragment;
import org.eclipselabs.damos.mscript.codegen.c.ICodeFragmentCollector;
import org.eclipselabs.damos.mscript.codegen.c.ICodeFragmentContext;
import org.eclipselabs.damos.mscript.codegen.c.IGlobalNameProvider;
import org.eclipselabs.damos.mscript.codegen.c.LiteralGenerator;
import org.eclipselabs.damos.mscript.codegen.c.datatype.MachineArrayType;
import org.eclipselabs.damos.mscript.codegen.c.datatype.MachineDataTypes;
import org.eclipselabs.damos.mscript.computationmodel.ComputationModel;
import org.eclipselabs.damos.mscript.interpreter.value.IArrayValue;

/**
 * @author Andreas Unger
 *
 */
public class ArrayLiteralDeclaration extends AbstractCodeFragment {

	private final LiteralGenerator literalGenerator = new LiteralGenerator(new DataTypeGenerator());
	
	private final ComputationModel computationModel;
	private final IArrayValue arrayValue;
	
	private String name;
	private String typeName;
	private CharSequence body;

	/**
	 * 
	 */
	public ArrayLiteralDeclaration(ComputationModel computationModel, IArrayValue value) {
		this.computationModel = computationModel;
		this.arrayValue = value;
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	@Override
	public void initialize(ICodeFragmentContext context, IProgressMonitor monitor) {
		addDependency(FORWARD_DECLARATION_DEPENDS_ON, new IDependencyRule() {
			
			public boolean applies(ICodeFragment other) {
				return other instanceof ArrayTypeDeclaration;
			}
			
		});
		
		MachineArrayType arrayType = MachineDataTypes.create(computationModel, arrayValue.getDataType());
		ArrayTypeDeclaration arrayTypeDeclaration = new ArrayTypeDeclaration(computationModel, arrayType);
		ICodeFragmentCollector codeFragmentCollector = context.getCodeFragmentCollector();
		ArrayTypeDeclaration codeFragment = (ArrayTypeDeclaration) codeFragmentCollector.addCodeFragment(arrayTypeDeclaration, new NullProgressMonitor());
		typeName = codeFragment.getName();
		
		IGlobalNameProvider globalNameProvider = context.getGlobalNameProvider();
		name = globalNameProvider.newGlobalName("array");

		body = literalGenerator.generateInitializer(computationModel, codeFragmentCollector, arrayValue);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.mscript.codegen.c.AbstractCodeFragment#contributesInternalForwardDeclaration()
	 */
	@Override
	public boolean contributesInternalForwardDeclaration() {
		return false;
	}
	
	public CharSequence generateForwardDeclaration(boolean internal) {
		return String.format("extern const %s %s;\n", typeName, name);
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
		if (obj instanceof ArrayLiteralDeclaration) {
//			ArrayLiteralDeclarationCodeFragment other = (ArrayLiteralDeclarationCodeFragment) obj;
			// TODO: check equals using value
		}
		return false;
	}

}
