/****************************************************************************
 * Copyright (c) 2008, 2009 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipselabs.damos.library.base.ui.properties.math;

import java.util.Collections;
import java.util.List;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.NotificationFilter;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.properties.sections.AbstractModelerPropertySection;
import org.eclipse.gmf.runtime.diagram.ui.properties.views.TextChangeHelper;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.PropertiesSetStyle;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eclipselabs.damos.diagram.core.type.ElementTypes;
import org.eclipselabs.damos.diagram.ui.view.util.PropertiesSetStyleUtil;
import org.eclipselabs.damos.dml.Argument;
import org.eclipselabs.damos.dml.Block;
import org.eclipselabs.damos.dml.BlockInput;
import org.eclipselabs.damos.dml.BlockInputPort;
import org.eclipselabs.damos.dml.DMLPackage;
import org.eclipselabs.damos.dml.Input;
import org.eclipselabs.damos.dml.InputPort;
import org.eclipselabs.damos.dml.util.DMLUtil;
import org.eclipselabs.damos.dscript.util.DscriptUtil;
import org.eclipselabs.damos.library.base.ui.figures.shapes.math.SumShapeType;
import org.eclipselabs.damos.library.base.ui.view.styles.math.SumStyles;
import org.eclipselabs.damos.library.base.util.math.SumConstants;
import org.eclipselabs.damos.library.common.ui.view.styles.MultiShapeBlockStyles;
import org.eclipselabs.damos.library.common.util.BlockConstants;

/**
 * @author Andreas Unger
 *
 */
public class SumInputPortsPropertySection extends AbstractModelerPropertySection {
	
	private static final String SPACER_PORT_PORT = "|oo";
	private static final String PORT_SPACER_PORT = "o|o";
	private static final String PORT_PORT_PORT = "ooo";

	private Group inputPortsArrangementGroup;

	private org.eclipse.swt.widgets.List list;
	private Button removeButton;
	private Button toggleButton;

	private Button spacerPortPortButton;
	private Button portSpacerPortButton;
	private Button portPortPortButton;
	private Button customButton;
	private Text customText;
	
	private TextChangeHelper customTextListener = new TextChangeHelper() {
		
		boolean textModified = false;

		public void handleEvent(Event event) {
			if (event.type == SWT.KeyDown) {
				textModified = true;
			}
			super.handleEvent(event);
		}

		public void textChanged(Control control) {
			if (textModified) {
				updateInputPortsArrangement(((Text) control).getText());
				textModified = false;
			}
		}
		
	};

	public void createControls(Composite parent, TabbedPropertySheetPage aTabbedPropertySheetPage) {
		super.createControls(parent, aTabbedPropertySheetPage);
		Composite composite = getWidgetFactory().createFlatFormComposite(parent);
		FormLayout layout = (FormLayout) composite.getLayout();
		layout.spacing = 3;
		
		Composite groups = getWidgetFactory().createComposite(composite);
		groups.setLayout(new GridLayout(2, false));

		createPortsGroup(groups);
		createArrangementGroup(groups);
	}
	
	protected void createPortsGroup(Composite parent) {
		Group portsGroup = getWidgetFactory().createGroup(parent, "Input Ports:");
		portsGroup.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false));
		GridLayout layout = new GridLayout(2, false);
		portsGroup.setLayout(layout);

		list = getWidgetFactory().createList(portsGroup, SWT.BORDER | SWT.V_SCROLL | SWT.SINGLE);
		list.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				if (toggleButton != null) {
					toggleButton.setEnabled(list.getSelectionCount() > 0);
				}
			}
		});
		GridData gridData = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 3);
		gridData.minimumWidth = 50;
		list.setLayoutData(gridData);
		
		Button addButton = getWidgetFactory().createButton(portsGroup, "Add", SWT.NONE);
		addButton.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, false, false));
		addButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				addPort();
			}
		});
		
		removeButton = getWidgetFactory().createButton(portsGroup, "Remove", SWT.NONE);
		removeButton.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, false, false));
		removeButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				if (list.getItemCount() > 2) {
					int i = list.getSelectionIndex();
					if (i < 0) {
						i = list.getItemCount() - 1;
					}
					removePort(i);
				}
			}
		});
		
		toggleButton = getWidgetFactory().createButton(portsGroup, "Toggle Sign", SWT.NONE);
		toggleButton.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, false, false));
		toggleButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				int i = list.getSelectionIndex();
				if (i >= 0) {
					togglePort(i);
				}
			}
		});
	}
	
	protected void createArrangementGroup(Composite parent) {
		inputPortsArrangementGroup = getWidgetFactory().createGroup(parent, "Input Ports Arrangement:");
		inputPortsArrangementGroup.setLayoutData(new GridData(SWT.FILL, SWT.TOP, false, false));
		GridLayout layout = new GridLayout(2, false);
		inputPortsArrangementGroup.setLayout(layout);
		
		Canvas canvas;
		GridData gridData;
		
		spacerPortPortButton = getWidgetFactory().createButton(inputPortsArrangementGroup, "Spacer-port-port:", SWT.RADIO);
		spacerPortPortButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				if (spacerPortPortButton.getSelection()) {
					updateInputPortsArrangement(SPACER_PORT_PORT);
				}
			}
		});
		canvas = new OvalSumCanvas(inputPortsArrangementGroup, false, true, true);
		gridData = new GridData(SWT.BEGINNING, SWT.CENTER, false, false);
		gridData.widthHint = 40;
		gridData.heightHint = 40;
		canvas.setLayoutData(gridData);
		canvas.setBackground(getWidgetFactory().getColors().getBackground());
		
		portSpacerPortButton = getWidgetFactory().createButton(inputPortsArrangementGroup, "Port-spacer-port:", SWT.RADIO);
		portSpacerPortButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				if (portSpacerPortButton.getSelection()) {
					updateInputPortsArrangement(PORT_SPACER_PORT);
				}
			}
		});
		canvas = new OvalSumCanvas(inputPortsArrangementGroup, true, false, true);
		gridData = new GridData(SWT.BEGINNING, SWT.CENTER, false, false);
		gridData.widthHint = 40;
		gridData.heightHint = 40;
		canvas.setLayoutData(gridData);
		canvas.setBackground(getWidgetFactory().getColors().getBackground());

		portPortPortButton = getWidgetFactory().createButton(inputPortsArrangementGroup, "Port-port-port:", SWT.RADIO);
		portPortPortButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				if (portPortPortButton.getSelection()) {
					updateInputPortsArrangement(PORT_PORT_PORT);
				}
			}
		});
		canvas = new OvalSumCanvas(inputPortsArrangementGroup, true, true ,true);
		gridData = new GridData(SWT.BEGINNING, SWT.CENTER, false, false);
		gridData.widthHint = 40;
		gridData.heightHint = 40;
		canvas.setLayoutData(gridData);
		canvas.setBackground(getWidgetFactory().getColors().getBackground());
		
		customButton = getWidgetFactory().createButton(inputPortsArrangementGroup, "Custom (o = port, | = spacer):", SWT.RADIO);
		customButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				customText.setEnabled(customButton.getSelection());
				if (customButton.getSelection()) {
					updateInputPortsArrangement(customText.getText());
				}
			}
		});
		customText = getWidgetFactory().createText(inputPortsArrangementGroup, "", SWT.BORDER);
		gridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
		gridData.widthHint = 100;
		customText.setLayoutData(gridData);
		customTextListener.startListeningTo(customText);
		customTextListener.startListeningForEnter(customText);
	}

	protected void addPort() {
		final IGraphicalEditPart editPart = (IGraphicalEditPart) getPrimarySelection();
		Block block = (Block) editPart.resolveSemanticElement();
		if (block != null) {
			Input input = block.getInput(BlockConstants.INPUT);
			if (input != null) {
		        CreateElementRequest createRequest = new CreateElementRequest(
		        		editPart.getEditingDomain(),
		                input,
		                ElementTypes.BLOCK_INPUT_PORT,
		                DMLPackage.Literals.INPUT__PORTS);
		        ICommand command = ElementTypes.BLOCK_INPUT.getEditCommand(createRequest);
		        executeAsCompositeCommand("Add Input Port", Collections.singletonList(command));
			}
		}
	}
	
	protected void removePort(int index) {
		final IGraphicalEditPart editPart = (IGraphicalEditPart) getPrimarySelection();
		Block block = (Block) editPart.resolveSemanticElement();
		if (block != null) {
			Input input = block.getInput(BlockConstants.INPUT);
			if (input != null) {
				List<InputPort> inputPorts = input.getPorts();
				DestroyElementRequest destroyRequest = new DestroyElementRequest(
		        		editPart.getEditingDomain(),
		                inputPorts.get(index),
		                false);
		        ICommand command = ElementTypes.BLOCK_INPUT.getEditCommand(destroyRequest);
		        executeAsCompositeCommand("Remove Input Port", Collections.singletonList(command));
			}
		}
	}
	
	protected void togglePort(int index) {
		final IGraphicalEditPart editPart = (IGraphicalEditPart) getPrimarySelection();
		Block block = (Block) editPart.resolveSemanticElement();
		if (block != null) {
			BlockInput input = block.getInput(BlockConstants.INPUT);
			if (input != null) {
				List<InputPort> inputPorts = input.getPorts();
				if (index < inputPorts.size()) {
					InputPort inputPort = inputPorts.get(index);
					if (inputPort instanceof BlockInputPort) {
						BlockInputPort blockInputPort = (BlockInputPort) inputPort;
						Argument signArgument = blockInputPort.getArgument(SumConstants.PORT_PARAMETER__SIGN);
						if (signArgument != null) {
							double sign = DMLUtil.getArgumentValueAsDouble(blockInputPort, SumConstants.PORT_PARAMETER__SIGN, 1);
							SetRequest setRequest = new SetRequest(
									editPart.getEditingDomain(),
									signArgument,
									DMLPackage.Literals.ARGUMENT__VALUE,
									DscriptUtil.createValueSpecification(sign >= 0 ? -1 : 1));
					        ICommand command = ElementTypes.ARGUMENT.getEditCommand(setRequest);
					        executeAsCompositeCommand("Change Input Port Sign", Collections.singletonList(command));
						}
					}
				}
			}
		}
	}
	
	public void refresh() {
		super.refresh();
		if (!isDisposed()) {
			IGraphicalEditPart editPart = (IGraphicalEditPart) getPrimarySelection();
			if (editPart != null) {
				Block block = (Block) editPart.resolveSemanticElement();
				if (block != null) {
					refreshInputPorts(block);
					View view = editPart.getNotationView();
					if (view != null) {
						String shape = PropertiesSetStyleUtil.getStringValue(view, MultiShapeBlockStyles.SHAPE_STYLE, MultiShapeBlockStyles.SHAPE_STYLE__SHAPE);
						if (shape != null) {
							boolean isRound = SumShapeType.ROUND.name().equals(shape);
							if (isRound) {
								refreshInputPortsArrangement(block);
							}
							inputPortsArrangementGroup.setVisible(isRound);
						}
					}
				}
			}
			removeButton.setEnabled(list.getItemCount() > 2);
			toggleButton.setEnabled(list.getSelectionCount() > 0);
		}
	}
	
	protected void refreshInputPorts(Block block) {
		BlockInput input = block.getInput(BlockConstants.INPUT);
		if (input != null) {
			int i = 0;
			for (InputPort inputPort : input.getPorts()) {
				if (inputPort instanceof BlockInputPort) {
					double sign = DMLUtil.getArgumentValueAsDouble((BlockInputPort) inputPort, SumConstants.PORT_PARAMETER__SIGN, 1);
					String literal = sign >= 0 ? "+" : "-";
					if (i < list.getItemCount()) {
						if (!list.getItem(i).equals(literal)) {
							list.setItem(i, literal);
						}
					} else {
						list.add(literal);
					}
					++i;
				}
			}
			if (i < list.getItemCount()) {
				list.remove(i, list.getItemCount() - 1);						
			}
		}
	}
	
	protected void refreshInputPortsArrangement(Block block) {
		BlockInput input = block.getInput(BlockConstants.INPUT);
		if (input != null) {
			List<InputPort> inputPorts = input.getPorts();
			int n = inputPorts.size();
			
			String inputPortsArrangement = getInputPortsArrangement();
			
			spacerPortPortButton.setEnabled(n == 2);
			portSpacerPortButton.setEnabled(n == 2);
			portPortPortButton.setEnabled(n == 3);
			
			boolean spacerPortPort = SPACER_PORT_PORT.equals(inputPortsArrangement);
			boolean portSpacerPort = PORT_SPACER_PORT.equals(inputPortsArrangement);
			boolean portPortPort = PORT_PORT_PORT.equals(inputPortsArrangement);
			boolean custom = !(spacerPortPort || portSpacerPort || portPortPort);
			
			spacerPortPortButton.setSelection(spacerPortPort);
			portSpacerPortButton.setSelection(portSpacerPort);
			portPortPortButton.setSelection(portPortPort);
			
			customButton.setSelection(custom);
			customText.setEnabled(custom);
			customText.setText(inputPortsArrangement);
		}
	}
		
	protected void updateInputPortsArrangement(final String arrangement) {
		if (!arrangement.equals(getInputPortsArrangement())) {
			final IGraphicalEditPart editPart = (IGraphicalEditPart) getPrimarySelection();
			final Node node = (Node) editPart.getNotationView();
			ICommand command = createCommand("Change Input Ports Arrangement", node.eResource(), new Runnable() {
				public void run() {
					PropertiesSetStyle inputPortsStyle = (PropertiesSetStyle) node.getNamedStyle(NotationPackage.eINSTANCE.getPropertiesSetStyle(), SumStyles.INPUT_PORTS_STYLE);
					if (inputPortsStyle != null) {
						inputPortsStyle.setProperty(SumStyles.INPUT_PORTS_STYLE__ARRANGEMENT, arrangement);
					}
				}
			});
			executeAsCompositeCommand("Change Input Ports Arrangement", Collections.singletonList(command));
		}
	}

	protected String getInputPortsArrangement() {
		IGraphicalEditPart editPart = (IGraphicalEditPart) getPrimarySelection();
		if (editPart != null) {
			Node node = (Node) editPart.getNotationView();
			if (node != null) {
				PropertiesSetStyle inputPortsStyle = (PropertiesSetStyle) node.getNamedStyle(NotationPackage.eINSTANCE.getPropertiesSetStyle(), SumStyles.INPUT_PORTS_STYLE);
				if (inputPortsStyle != null) {
					Object prop = inputPortsStyle.getProperty(SumStyles.INPUT_PORTS_STYLE__ARRANGEMENT);
					if (prop instanceof String) {
						return (String) prop;
					}
				}
			}
		}
		return "";
	}

	/**
     * Update if necessary, upon receiving the model event.
     * 
     * @see #aboutToBeShown()
     * @see #aboutToBeHidden()
     * @param notification -
     *            even notification
     * @param element -
     *            element that has changed
     */
    public void update(final Notification notification, EObject element) {
    	if (!isDisposed()) {
			postUpdateRequest(new Runnable() {
				public void run() {
					if (!isDisposed() && !isNotifierDeleted(notification)) {
						refresh();
					}
				}
			});
		}
	}

    /* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.properties.sections.AbstractModelerPropertySection#getFilter()
	 */
	public NotificationFilter getFilter() {
        return NotificationFilter.createEventTypeFilter(Notification.SET).or(
				NotificationFilter.createEventTypeFilter(Notification.UNSET)).or(
				NotificationFilter.createEventTypeFilter(Notification.ADD)).or(
				NotificationFilter.createEventTypeFilter(Notification.ADD_MANY)).or(
				NotificationFilter.createEventTypeFilter(Notification.REMOVE)).or(
				NotificationFilter.createEventTypeFilter(Notification.REMOVE_MANY)).and(
				NotificationFilter.createNotifierTypeFilter(EObject.class));
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.properties.sections.AbstractModelerPropertySection#dispose()
	 */
	public void dispose() {
		customTextListener.stopListeningTo(customText);
		super.dispose();
	}
		
	private static class OvalSumCanvas extends Canvas implements PaintListener {

		private boolean north;
		private boolean west;
		private boolean south;
		
		private int[] points = new int[6];
		
		/**
		 * @param parent
		 * @param style
		 */
		public OvalSumCanvas(Composite parent, boolean north, boolean west, boolean south) {
			super(parent, SWT.NONE);
			this.north = north;
			this.west = west;
			this.south = south;
			addPaintListener(this);
		}
		
		/* (non-Javadoc)
		 * @see org.eclipse.swt.events.PaintListener#paintControl(org.eclipse.swt.events.PaintEvent)
		 */
		public void paintControl(PaintEvent e) {
			e.gc.setForeground(ColorConstants.black);
			e.gc.setLineWidth(1);
			e.gc.setLineStyle(SWT.LINE_SOLID);
			e.gc.setAntialias(SWT.ON);
			
			Rectangle bounds = getBounds();
			int portSize = bounds.height / 8;
			int d = (bounds.height - 2 * portSize) - 2;
			int r = d / 2;
			int cx = bounds.width / 2;
			int cy = bounds.height / 2;
			
			e.gc.drawOval(cx - r, cy - r, d, d);
			
			if (north) {
				points[0] = cx - portSize;
				points[1] = cy - r - portSize;
				points[2] = cx;
				points[3] = cy - r;
				points[4] = cx + portSize;
				points[5] = cy - r - portSize;
				e.gc.drawPolyline(points);
			}
			
			if (west) {
				points[0] = cx - r - portSize;
				points[1] = cy - portSize;
				points[2] = cx - r;
				points[3] = cy;
				points[4] = cx - r - portSize;
				points[5] = cy + portSize;
				e.gc.drawPolyline(points);
			}
			
			if (south) {
				points[0] = cx - portSize;
				points[1] = cy + r + portSize;
				points[2] = cx;
				points[3] = cy + r;
				points[4] = cx + portSize;
				points[5] = cy + r + portSize;
				e.gc.drawPolyline(points);
			}
			
			points[0] = cx + r;
			points[1] = cy - portSize;
			points[2] = cx + r + portSize;
			points[3] = cy;
			points[4] = cx + r;
			points[5] = cy + portSize;
			e.gc.drawPolyline(points);
		}
		
	}

}
