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

import java.io.IOException;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipselabs.damos.common.util.PrintAppendable;
import org.eclipselabs.damos.mscript.ArrayType;
import org.eclipselabs.damos.mscript.DataType;
import org.eclipselabs.damos.mscript.IntegerType;
import org.eclipselabs.damos.mscript.RealType;
import org.eclipselabs.damos.mscript.computationmodel.ComputationModel;
import org.eclipselabs.damos.mscript.computationmodel.NumberFormat;
import org.eclipselabs.damos.mscript.interpreter.value.IArrayValue;
import org.eclipselabs.damos.mscript.interpreter.value.ISimpleNumericValue;
import org.eclipselabs.damos.mscript.util.TypeUtil;

/**
 * @author Andreas Unger
 *
 */
public class ArrayDeclarationCodeFragment extends AbstractCodeFragment {

	private IArrayValue arrayValue;
	private ComputationModel computationModel;
	
	private String name;
	private String typeName;
	private NumberFormat elementNumberFormat;
	
	/**
	 * 
	 */
	public ArrayDeclarationCodeFragment(ComputationModel computationModel, IArrayValue value) {
		this.computationModel = computationModel;
		this.arrayValue = value;
		this.elementNumberFormat = computationModel.getNumberFormat(arrayValue.getDataType().getElementType());
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.mscript.codegen.c.AbstractCodeFragment#initialize(org.eclipse.core.runtime.IAdaptable, org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	public void initialize(IAdaptable context, IProgressMonitor monitor) throws IOException {
		addDependency(new ICodeFragmentDependency.Stub() {
			
			public boolean forwardDeclarationDependsOn(ICodeFragment other) {
				return other instanceof ArrayTypeDeclarationCodeFragment;
			}
			
		});
		
		ArrayType arrayType = arrayValue.getDataType();
		ArrayTypeDeclarationCodeFragment arrayTypeDeclarationCodeFragment = new ArrayTypeDeclarationCodeFragment(computationModel, EcoreUtil.copy(arrayType.getElementType()), TypeUtil.getArraySize(arrayType));
		ICodeFragmentCollector codeFragmentCollector = (ICodeFragmentCollector) context.getAdapter(ICodeFragmentCollector.class);
		ArrayTypeDeclarationCodeFragment codeFragment = (ArrayTypeDeclarationCodeFragment) codeFragmentCollector.addCodeFragment(arrayTypeDeclarationCodeFragment, new NullProgressMonitor());
		typeName = codeFragment.getName();
		
		IGlobalNameProvider globalNameProvider = (IGlobalNameProvider) context.getAdapter(IGlobalNameProvider.class);
		name = globalNameProvider.getName("array");
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.mscript.codegen.c.AbstractCodeFragment#contributesInternalForwardDeclaration()
	 */
	@Override
	public boolean contributesInternalForwardDeclaration() {
		return false;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.mscript.codegen.c.ICodeFragment#writeForwardDeclaration(java.lang.Appendable, boolean)
	 */
	public void writeForwardDeclaration(Appendable appendable, boolean internal) throws IOException {
		PrintAppendable out = new PrintAppendable(appendable);
		out.printf("extern const %s %s;\n", typeName, name);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.mscript.codegen.c.AbstractCodeFragment#contributesImplementation()
	 */
	@Override
	public boolean contributesImplementation() {
		return true;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.mscript.codegen.c.AbstractCodeFragment#writeImplementation(java.lang.Appendable, boolean)
	 */
	@Override
	public void writeImplementation(Appendable appendable, boolean internal) throws IOException {
		if (internal) {
			appendable.append("static ");
		}
		PrintAppendable out = new PrintAppendable(appendable);
		out.printf("const %s %s = { { ", typeName, name);
		int arraySize = TypeUtil.getArraySize(arrayValue.getDataType());
		DataType elementType = arrayValue.getDataType().getElementType();
		for (int i = 0; i < arraySize; ++i) {
			if (i > 0) {
				out.append(", ");
			}
			if (elementType instanceof RealType) {
				out.printf("%f", ((ISimpleNumericValue) arrayValue.get(i)).doubleValue());
			} else if (elementType instanceof IntegerType) {
				out.printf("%d", ((ISimpleNumericValue) arrayValue.get(i)).longValue());
			}
		}
		out.print(" } };\n");
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return getClass().hashCode() ^ elementNumberFormat.getClass().hashCode();
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof ArrayDeclarationCodeFragment) {
			ArrayDeclarationCodeFragment other = (ArrayDeclarationCodeFragment) obj;
			
			// TODO: complete this
			return other.elementNumberFormat.isEquivalentTo(elementNumberFormat);
		}
		return false;
	}

}
