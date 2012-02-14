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
package org.eclipselabs.damos.ide.ui.internal.quickfix;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.swt.graphics.Image;
import org.eclipselabs.damos.dml.Inoutport;
import org.eclipselabs.damos.dmltext.DMLTextFactory;
import org.eclipselabs.damos.dmltext.MscriptDataTypeSpecification;
import org.eclipselabs.damos.dmltext.util.DMLTextUtil;
import org.eclipselabs.damos.ide.core.validation.Problem;
import org.eclipselabs.damos.ide.ui.IDEUIPlugin;
import org.eclipselabs.damos.ide.ui.quickfix.AbstractQuickFix;
import org.eclipselabs.damos.mscript.DataType;
import org.eclipselabs.damos.mscript.DataTypeSpecifier;
import org.eclipselabs.damos.mscript.MscriptFactory;
import org.eclipselabs.damos.mscript.util.TypeUtil;

/**
 * @author Andreas Unger
 *
 */
public abstract class SetDataTypeQuickFix extends AbstractQuickFix {

	private String label;
	
	/**
	 * 
	 */
	public SetDataTypeQuickFix() {
		this.label = "Set data type to " + getDataTypeName();
	}
	
	public String getDescription() {
		return null;
	}

	public Image getImage() {
		return IDEUIPlugin.getDefault().getImageRegistry().get(IDEUIPlugin.IMAGE_CORRECTION_ADD);
	}

	public String getLabel() {
		return label;
	}
	
	protected final void run(final Problem problem, final TransactionalEditingDomain editingDomain) {
		editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain, "Set Data Type") {
			
			@Override
			protected void doExecute() {
				MscriptDataTypeSpecification dataTypeSpecification = DMLTextFactory.eINSTANCE.createMscriptDataTypeSpecification();
				DataTypeSpecifier dataTypeSpecifier = MscriptFactory.eINSTANCE.createDataTypeSpecifier();
				dataTypeSpecifier.setDefinedType(createDataType());
				dataTypeSpecification.setSpecifier(dataTypeSpecifier);
				DMLTextUtil.setText(dataTypeSpecification, getDataTypeName());

				Inoutport inoutport = (Inoutport) editingDomain.getResourceSet().getEObject(problem.getElementURI(), true);
				inoutport.setDataType(dataTypeSpecification);
			}
			
		});
	}
	
	protected abstract String getDataTypeName();

	protected abstract DataType createDataType();
	
	public static class Real extends SetDataTypeQuickFix {

		@Override
		protected String getDataTypeName() {
			return "real";
		}
		
		@Override
		protected DataType createDataType() {
			return TypeUtil.createRealType();
		}
		
	}

	public static class Integer extends SetDataTypeQuickFix {

		@Override
		protected String getDataTypeName() {
			return "int";
		}

		@Override
		protected DataType createDataType() {
			return TypeUtil.createIntegerType();
		}
		
	}

	public static class Boolean extends SetDataTypeQuickFix {

		@Override
		protected String getDataTypeName() {
			return "boolean";
		}

		@Override
		protected DataType createDataType() {
			return MscriptFactory.eINSTANCE.createBooleanType();
		}
		
	}

}
