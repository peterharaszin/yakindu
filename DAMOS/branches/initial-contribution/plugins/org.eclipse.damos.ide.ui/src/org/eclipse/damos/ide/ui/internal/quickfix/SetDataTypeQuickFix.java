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
package org.eclipse.damos.ide.ui.internal.quickfix;

import org.eclipse.damos.dml.Inoutport;
import org.eclipse.damos.dscript.DscriptDataTypeSpecification;
import org.eclipse.damos.dscript.DscriptFactory;
import org.eclipse.damos.dscript.util.DscriptUtil;
import org.eclipse.damos.ide.core.validation.Problem;
import org.eclipse.damos.ide.ui.IDEUIPlugin;
import org.eclipse.damos.ide.ui.quickfix.AbstractQuickFix;
import org.eclipse.damos.mscript.AnonymousTypeSpecifier;
import org.eclipse.damos.mscript.MscriptFactory;
import org.eclipse.damos.mscript.Type;
import org.eclipse.damos.mscript.util.TypeUtil;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.swt.graphics.Image;

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
		return IDEUIPlugin.getDefault().getImageRegistry().get(IDEUIPlugin.IMAGE_CORRECTION_CHANGE);
	}

	public String getLabel() {
		return label;
	}
	
	protected final void run(final Problem problem, final TransactionalEditingDomain editingDomain) {
		editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain, "Set Data Type") {
			
			@Override
			protected void doExecute() {
				DscriptDataTypeSpecification dataTypeSpecification = DscriptFactory.eINSTANCE.createDscriptDataTypeSpecification();
				AnonymousTypeSpecifier dataTypeSpecifier = MscriptFactory.eINSTANCE.createAnonymousTypeSpecifier();
				dataTypeSpecifier.setType(createDataType());
				dataTypeSpecification.setTypeSpecifier(dataTypeSpecifier);
				DscriptUtil.setText(dataTypeSpecification, getDataTypeName());

				Inoutport inoutport = (Inoutport) editingDomain.getResourceSet().getEObject(problem.getElementURI(), true);
				inoutport.setDataType(dataTypeSpecification);
			}
			
		});
	}
	
	protected abstract String getDataTypeName();

	protected abstract Type createDataType();
	
	public static class Real extends SetDataTypeQuickFix {

		@Override
		protected String getDataTypeName() {
			return "real";
		}
		
		@Override
		protected Type createDataType() {
			return TypeUtil.createRealType();
		}
		
	}

	public static class Integer extends SetDataTypeQuickFix {

		@Override
		protected String getDataTypeName() {
			return "int";
		}

		@Override
		protected Type createDataType() {
			return TypeUtil.createIntegerType();
		}
		
	}

	public static class Boolean extends SetDataTypeQuickFix {

		@Override
		protected String getDataTypeName() {
			return "boolean";
		}

		@Override
		protected Type createDataType() {
			return MscriptFactory.eINSTANCE.createBooleanType();
		}
		
	}

}
