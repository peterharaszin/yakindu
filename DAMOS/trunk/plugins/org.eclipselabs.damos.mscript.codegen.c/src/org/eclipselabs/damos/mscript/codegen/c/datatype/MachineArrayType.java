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

package org.eclipselabs.damos.mscript.codegen.c.datatype;

import static org.eclipselabs.damos.mscript.codegen.c.ICodeFragment.FORWARD_DECLARATION_DEPENDS_ON;

import java.util.Arrays;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipselabs.damos.mscript.codegen.c.ICodeFragment;
import org.eclipselabs.damos.mscript.codegen.c.ICodeFragment.IDependencyRule;
import org.eclipselabs.damos.mscript.codegen.c.ICodeFragmentCollector;
import org.eclipselabs.damos.mscript.codegen.c.codefragments.ArrayTypeDeclaration;

/**
 * @author Andreas Unger
 *
 */
public class MachineArrayType extends MachineDataType {

	private final MachineDataType elementType;
	private final int[] dimensionSizes;
	
	/**
	 * 
	 */
	MachineArrayType(MachineDataType elementType, int[] dimensionSizes) {
		this.elementType = elementType;
		this.dimensionSizes = dimensionSizes;
	}
	
	/**
	 * @return the elementType
	 */
	public MachineDataType getElementType() {
		return elementType;
	}
	
	public boolean isNumeric() {
		return elementType instanceof MachineNumericType;
	}
	
	public MachineNumericType getNumericElementType() {
		return (MachineNumericType) getElementType();
	}
	
	public int getDimensionality() {
		return dimensionSizes.length;
	}
	
	public int[] getDimensionSizes() {
		return dimensionSizes;
	}

	public int getDimensionSize(int index) {
		return dimensionSizes[index];
	}
	
	public int getSize() {
		return dimensionSizes[0];
	}
	
	public int getRowSize() {
		return dimensionSizes[0];
	}
	
	public int getColumnSize() {
		return dimensionSizes[1];
	}

	@Override
	public String generateDataType(ICodeFragmentCollector codeFragmentCollector, ICodeFragment dependentCodeFragment) {
		final ArrayTypeDeclaration codeFragment = (ArrayTypeDeclaration) codeFragmentCollector
				.addCodeFragment(new ArrayTypeDeclaration(this),
						new NullProgressMonitor());
		if (dependentCodeFragment != null) {
			dependentCodeFragment.addDependency(FORWARD_DECLARATION_DEPENDS_ON, new IDependencyRule() {
				
				public boolean applies(ICodeFragment other) {
					return other == codeFragment;
				}
				
			});
		}
		return codeFragment.getName();
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.mscript.codegen.c.datatype.MachineDataType#hashCode()
	 */
	@Override
	public int hashCode() {
		return super.hashCode() ^ elementType.hashCode() ^ Arrays.hashCode(dimensionSizes);
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof MachineArrayType) {
			MachineArrayType other = (MachineArrayType) obj;
			return other.elementType.equals(elementType) && Arrays.equals(other.dimensionSizes, dimensionSizes);
		}
		return super.equals(obj);
	}
	
}
