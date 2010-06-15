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
package org.mda4e.statemachine.contribution.views;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.OperationHistoryFactory;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;
import org.mda4e.statemachine.contribution.commands.CmdCreateEvent;
import org.mda4e.statemachine.contribution.commands.CmdCreateVar;
import org.mda4e.statemachine.contribution.commands.CmdSetupEvent;
import org.mda4e.statemachine.contribution.commands.CmdSetupVar;

import statemachine.DataElement;
import statemachine.DataTypes;
import statemachine.Event;
import statemachine.IOTypes;
import statemachine.TriggerTypes;
import statemachine.Variable;
import statemachine.diagram.part.StatemachineDiagramEditor;

public class SetupDataElementDialog extends Dialog{

	public enum DialogType {
		EVENT,
		VARIABLE
	}
	
	private DataElement dataElement;
	private DialogType dialogType;
	
	public SetupDataElementDialog(Shell parentShell,DialogType dialogType, DataElement dataElement) {
		super(parentShell);
		this.dataElement = dataElement;
		this.dialogType = dialogType;	
	}

	protected Control createContents(Composite parent){
		parent.setSize(220,240);
		Rectangle parentBounds = getParentShell().getBounds();
		Rectangle bounds = getShell().getBounds();
		int x = parentBounds.x + (parentBounds.width - bounds.width) / 2;
		int y = parentBounds.y + (parentBounds.height - bounds.height) / 2;
		parent.setLocation(x, y);
		
		switch (dialogType){
		case EVENT: {
			if (dataElement!=null)
				getShell().setText("Setup Event");
			else
				getShell().setText("Create Event");
			break;
		}
		case VARIABLE: {
			if (dataElement!=null)
				getShell().setText("Setup Variable");
			else
				getShell().setText("Create Variable");
			break;
		}
		}//Switch
		
		DataElementComposite composite = new DataElementComposite(parent, dialogType);
		composite.pack();
		composite.drawWindow(dataElement);
		
		return parent;
	}
	
	private class DataElementComposite extends Composite {
		
		private Composite parentComposit;
		private DialogType dialogType;
		private Font bold = new Font(this.getDisplay(), "Arial", 11, SWT.BOLD);
		private Text txbDataElementName, txbPort;
		private Combo cmbAttribute, cmbIOType;
		
		
		public DataElementComposite(Composite parent, DialogType dialogType){
			super(parent, SWT.NULL);
			parentComposit = parent;
			this.dialogType = dialogType;
			setSize(parent.getSize().x,parent.getSize().y);
		}
				
		public void drawWindow(DataElement dataElement)
		{
			Label lblDataElementName = new Label(this, SWT.SHADOW_ETCHED_OUT);
			lblDataElementName.setBounds(10,10,30,15);
			lblDataElementName.setText("Name: ");
			lblDataElementName.pack();
			
			txbDataElementName= new Text(this,SWT.BOLD);
			//txbEventName.setText(dataElement.getName());
			txbDataElementName.setFont(bold);
			txbDataElementName.setBounds(100,10,90,25);
			txbDataElementName.setBackground(this.getDisplay().getSystemColor(SWT.COLOR_GRAY));
			
			Label lblPort = new Label(this, SWT.SHADOW_ETCHED_OUT);
			lblPort.setBounds(10,50,30,15);
			lblPort.setText("Port: ");
			lblPort.pack();
			
			txbPort= new Text(this,SWT.BOLD);
			//txbPort.setText(Integer.toString(dataElement.getPort()));
			txbPort.setFont(bold);
			txbPort.setBounds(100,50,90,25);
			txbPort.setBackground(this.getDisplay().getSystemColor(SWT.COLOR_GRAY));
			
			Label lblIOType = new Label(this, SWT.SHADOW_ETCHED_OUT);
			lblIOType.setBounds(10,90,30,15);
			lblIOType.setText("I/O Type: ");
			lblIOType.pack();
			
			cmbIOType = new Combo(this,SWT.READ_ONLY);
			for (int i=0;i<IOTypes.VALUES.size();i++) cmbIOType.add(IOTypes.get(i).getLiteral());
			//cmbIOType.select(dataElement.getIoType().getValue());
			cmbIOType.setBounds(100,90,90,25);
			cmbIOType.pack();
			
			Label lblAttribute = new Label(this, SWT.SHADOW_ETCHED_OUT);
			lblAttribute.setBounds(10,130,30,15);
			//lblAttribute.setText("Trigger Type: ");
			
			
			cmbAttribute = new Combo(this,SWT.READ_ONLY);
			cmbAttribute.setBounds(100,130,90,25);
			//for (int i=0;i<TriggerTypes.VALUES.size();i++) cmbAttribute.add(TriggerTypes.get(i).getLiteral());
			//cmbAttribute.select(dataElement.getTrigger().getValue());
			cmbAttribute.pack();

			Button btnSet = new Button(this, SWT.PUSH);
			//set.setText("Set Event");
			btnSet.setBounds(65,170,85,20);
			this.addKeyListener(new KeyListener(){

				public void keyPressed(KeyEvent e) {
					if (e.keyCode=='\r')// TODO Auto-generated method stub
						runEvent();
					
				}

				public void keyReleased(KeyEvent e) {
					// TODO Auto-generated method stub
					
				}
				
			});
			btnSet.addSelectionListener(new SelectionListener(){

				public void widgetDefaultSelected(SelectionEvent e) {
				}

				public void widgetSelected(SelectionEvent e) {
					runEvent();
				}
			});
			
			switch (dialogType){
			case EVENT: {
				lblAttribute.setText("Trigger Type: ");
				for (int i=0;i<(TriggerTypes.VALUES.size()-1);i++) cmbAttribute.add(TriggerTypes.get(i).getLiteral());
				if (dataElement!=null) {
					txbDataElementName.setText(dataElement.getName());
					txbPort.setText(Integer.toString(dataElement.getPort()));
					cmbIOType.select(dataElement.getIoType().getValue());
					cmbAttribute.select(((Event)dataElement).getTrigger().getValue());
					btnSet.setText("Set Event");
				}
				else {
					txbDataElementName.setText("");
					txbPort.setText("0");
					cmbIOType.select(0);
					cmbAttribute.select(0);
					btnSet.setText("Create Event");
				}
				break;
			}
			case VARIABLE: {
				lblAttribute.setText("Data Type: ");
				for (int i=0;i<DataTypes.VALUES.size();i++) cmbAttribute.add(DataTypes.get(i).getLiteral());
				if (dataElement!=null) {
					txbDataElementName.setText(dataElement.getName());
					txbPort.setText(Integer.toString(dataElement.getPort()));
					cmbIOType.select(dataElement.getIoType().getValue());
					cmbAttribute.select(((Variable)dataElement).getDataType().getValue());
					btnSet.setText("Set Variable");
				}
				else {
					txbDataElementName.setText("");
					txbPort.setText("0");
					cmbIOType.select(0);
					cmbAttribute.select(0);
					btnSet.setText("Create Variable");
				}
				break;
			}
			}//Switch
			cmbAttribute.pack();
			cmbIOType.pack();
			btnSet.pack();
			lblAttribute.pack();
		}
		
		private void runEvent(){
			StatemachineDiagramEditor editor=null;
			String name = txbDataElementName.getText();
			int port = stringToInt(txbPort.getText());
			
			
			if (name == ""){
				MessageDialog.openInformation(
						getShell(),
						"Error", "You must enter a name!");
			}
			else if (port < 0) {
				MessageDialog.openInformation(
						getShell(),
						"Error", "You must enter Values between 0 and 32000");
			}
			else{
				
				IOTypes newIOType = IOTypes.get(cmbIOType.getSelectionIndex());
				IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
				if (page.getActiveEditor() instanceof StatemachineDiagramEditor) {
					editor = (StatemachineDiagramEditor)page.getActiveEditor();
					
					try {
						if (dataElement==null) {
							switch (dialogType){
							case EVENT:{
								TriggerTypes newTriggerType = TriggerTypes.get(cmbAttribute.getSelectionIndex());
								OperationHistoryFactory.getOperationHistory().execute(new CmdCreateEvent(editor.getEditingDomain(),"event creation",null,newTriggerType, newIOType, port, name),null,null);
								break;
							}
							case VARIABLE:{
								DataTypes newDataType=DataTypes.get(cmbAttribute.getSelectionIndex());
								OperationHistoryFactory.getOperationHistory().execute(new CmdCreateVar(editor.getEditingDomain(),"variablecreation",null, newDataType, newIOType, name, port),null,null);
								break;
							}
							}//switch
						} else {
							switch (dialogType){
							case EVENT:{
								TriggerTypes newTriggerType = TriggerTypes.get(cmbAttribute.getSelectionIndex());
								OperationHistoryFactory.getOperationHistory().execute(new CmdSetupEvent(editor.getEditingDomain(),"event creation",null,(Event)dataElement,newTriggerType, newIOType, port, name),null,null);
								break;
							}
							case VARIABLE:{
								DataTypes newDataType=DataTypes.get(cmbAttribute.getSelectionIndex());
								OperationHistoryFactory.getOperationHistory().execute(new CmdSetupVar(editor.getEditingDomain(),"variablecreation",null, (Variable)dataElement, newDataType, newIOType, name, port),null,null);
								break;
							}
							}//switch
						}//if
						
						
					} catch (ExecutionException e) {
						e.printStackTrace();
					}
				}
				parentComposit.getShell().close();
			}
		} //runEvent
		
		private int stringToInt(String input){
			try {
		    	return Integer.valueOf(input.trim()).intValue();
				} catch (Exception e) {
										return -1;
										}
	    } //stringToInt
	}// DataElementComposite
} //SetupDataElementDialog