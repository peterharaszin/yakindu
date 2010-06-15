/**
 * Copyright (c) 2006-2009 committers of mda4e and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of mda4e (http://www.mda4e.org/) - initial API and implementation
 *
 */
package org.mda4e.statemachine.contribution.model;

import java.security.InvalidParameterException;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.OperationHistoryFactory;
import org.eclipse.jface.viewers.ICellEditorValidator;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.views.properties.ComboBoxPropertyDescriptor;
import org.eclipse.ui.views.properties.IPropertyDescriptor;
import org.eclipse.ui.views.properties.IPropertySource;
import org.eclipse.ui.views.properties.TextPropertyDescriptor;
import org.mda4e.statemachine.contribution.commands.CmdSetupVar;

import statemachine.DataTypes;
import statemachine.Event;
import statemachine.IOTypes;
import statemachine.TriggerTypes;
import statemachine.Variable;
import statemachine.diagram.part.StatemachineDiagramEditor;

public class VariablePropertySource implements IPropertySource {

	private enum IDs {
		DATATYPE, IOTYPE, NAME, PORT
	}

	private Variable variable;
	private IPropertyDescriptor[] propertyDescriptors;

	public VariablePropertySource(Variable var) {
		variable = var;
	}

	public Object getEditableValue() {
		return variable.getName();
	}

	public IPropertyDescriptor[] getPropertyDescriptors() {
		if (propertyDescriptors == null) {
			TextPropertyDescriptor name = new TextPropertyDescriptor(IDs.NAME,
					"Name");
			name.setDescription("Event Name");
			TextPropertyDescriptor port = new TextPropertyDescriptor(IDs.PORT,
					"Port");
			port.setValidator(new ICellEditorValidator() {
				public String isValid(Object value) {
					try {
						Integer.parseInt(value.toString());
						return null;
					} catch (NumberFormatException e) {
						return "No valid integer entered";
					}
				}

			});
			port.setDescription("The portnumber for this event");
			IOTypes[] iotypes = IOTypes.values();
			String[] types = new String[iotypes.length];
			for (int i = 0; i < iotypes.length; i++) {
				types[i] = iotypes[i].name();
			}
			ComboBoxPropertyDescriptor ioTypes = new ComboBoxPropertyDescriptor(
					IDs.IOTYPE, "IO-Type", types);

			TriggerTypes[] triggerTypes = TriggerTypes.values();
			String[] tTypes = new String[triggerTypes.length];
			for (int i = 0; i < tTypes.length; i++) {
				tTypes[i] = triggerTypes[i].name();
			}
			ComboBoxPropertyDescriptor trigger = new ComboBoxPropertyDescriptor(
					IDs.DATATYPE, "Data type", tTypes);

			propertyDescriptors = new IPropertyDescriptor[] { name, port,
					ioTypes, trigger };
		}
		return propertyDescriptors;
	}

	public Object getPropertyValue(Object id) {
		if (id instanceof IDs) {
			switch ((IDs) id) {
			case NAME:
				return variable.getName();
			case PORT:
				return Integer.toString(variable.getPort());
			case IOTYPE:
				return variable.getIoType().getValue();
			case DATATYPE:
				return variable.getDataType().getValue();
			}
		}
		throw new InvalidParameterException(id + "is not supported by "
				+ getClass().getName());
	}

	/** returns false always because events doesn't have a default value */
	public boolean isPropertySet(Object id) {
		return false;
	}

	/** doesn't do anything because events doesn't have any default value */
	public void resetPropertyValue(Object id) {
	}

	public void setPropertyValue(Object id, Object value) {
		if (id instanceof IDs) {
			IWorkbenchPage page = PlatformUI.getWorkbench()
					.getActiveWorkbenchWindow().getActivePage();
			if (page.getActiveEditor() instanceof StatemachineDiagramEditor) {
				StatemachineDiagramEditor editor = (StatemachineDiagramEditor) page
						.getActiveEditor();
				try {
					switch ((IDs) id) {
					case NAME:
						OperationHistoryFactory.getOperationHistory().execute(
								new CmdSetupVar(editor.getEditingDomain(),
										"variable changed", null, variable,
										variable.getDataType(), variable
												.getIoType(), value.toString(),
										variable.getPort()), null, null);
						break;
					case PORT:
						OperationHistoryFactory.getOperationHistory().execute(
								new CmdSetupVar(editor.getEditingDomain(),
										"variable changed", null, variable,
										variable.getDataType(), variable
												.getIoType(), variable
												.getName(), Integer
												.parseInt(value.toString())),
								null, null);
						break;
					case IOTYPE:
						OperationHistoryFactory
								.getOperationHistory()
								.execute(
										new CmdSetupVar(editor
												.getEditingDomain(),
												"variable changed", null,
												variable, variable
														.getDataType(), IOTypes
														.get((Integer) value),
												variable.getName(), variable
														.getPort()), null, null);
						break;
					case DATATYPE:
						OperationHistoryFactory
								.getOperationHistory()
								.execute(
										new CmdSetupVar(editor
												.getEditingDomain(),
												"variable changed", null,
												variable, DataTypes
														.get((Integer) value),
												variable.getIoType(), variable
														.getName(), variable
														.getPort()), null, null);
						break;
					}
				} catch (ExecutionException e) {
					e.printStackTrace();
				}
			}
			return;
		}
		throw new InvalidParameterException(id + "is not supported by "
				+ getClass().getName());
	}

}
