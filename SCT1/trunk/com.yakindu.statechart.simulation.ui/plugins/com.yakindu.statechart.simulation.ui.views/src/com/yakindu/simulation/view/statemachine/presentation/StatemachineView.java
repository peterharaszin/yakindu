/**
 * Copyright (c) 2010 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package com.yakindu.simulation.view.statemachine.presentation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.Timer;
import java.util.TimerTask;
import java.util.TreeMap;
import java.util.Map.Entry;

import org.apache.log4j.Logger;
import org.eclipse.help.IContextProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.SWTException;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.FontMetrics;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.TableItem;
import org.mda4e.simulation.core.SimulationException;
import org.mda4e.simulation.core.SimulationState;
import org.mda4e.simulation.core.event.IEvent;
import org.mda4e.simulation.core.event.IEventListener;
import org.mda4e.simulation.core.event.SimulationEvent;
import org.mda4e.simulation.core.event.SimulationEvent.SimulationEventTypes;
import org.mda4e.simulation.statemachine.IStatemachineEngine;
import org.mda4e.simulation.statemachine.event.StatemachineEvent;
import org.mda4e.simulation.statemachine.event.StatemachineEvent.StatemachineEventTypes;

import statemachine.DataElement;
import statemachine.Event;
import statemachine.IOTypes;
import statemachine.Variable;

import com.yakindu.simulation.engine.statechart.events.DynamicItemEvent;
import com.yakindu.simulation.engine.statechart.events.DynamicItemEvent.DynamicItemEventTypes;
import com.yakindu.simulation.view.statemachine.logic.EngineManager;
import com.yakindu.simulation.view.statemachine.nls.Messages;
import com.yakindu.simulation.view.statemachine.presentation.utilities.StatemachineViewConfig;
import com.yakindu.simulation.view.statemachine.presentation.utilities.actions.ShowNewEngineAction;
import com.yakindu.simulation.view.statemachine.presentation.utilities.comparators.DataElementComparator;
import com.yakindu.simulation.view.statemachine.presentation.utilities.help.ContextProvider;

/**
 * The class <code>StatemachineView</code> displays all variables and events of
 * the current statemachine and their values.
 * 
 * @author Philipp Richter
 */
public class StatemachineView extends ATableView implements IEventListener {

	/** Defines the instance to log informations and errors. */
	private static final Logger log = Logger.getLogger(StatemachineView.class);

	/** Defines the configuration of this class. */
	private StatemachineViewConfig config = null;

	/**
	 * Defines the instance of the <code>EngineManager</code> which allows the
	 * access to all necessary informations about the currently available
	 * simulation engines.
	 */
	private EngineManager manager = null;

	/** Defines the names of the columns of the table. */
	private static final String[] COLUMNS =
			{ Messages.StatemachineView_category,
					Messages.StatemachineView_item,
					Messages.StatemachineView_value };

	/** Indicates the alignment of the table columns. */
	private static final int[] COLUMN_ALIGN = { SWT.LEFT, SWT.LEFT, SWT.RIGHT };

	/** Indicates which table columns are editable. */
	private static final boolean[] COLUMN_EDITABLE = { false, false, true };

	/** Contains all <code>TableItems</code> which was added to the table. */
	private Map<DataElement, TableItem> items = null;
	/** Contains all buttons which are used to enable or disable the events. */
	private Map<DataElement, Button> itemButtons = null;
	/** Indicates if a <code>TableItem</code> is editable. */
	private Map<TableItem, Boolean> itemIsEditable = null;

	/**
	 * Indicates if an <code>TableItem</code> is already updating. If an item
	 * text is already shown as updated (the color <code>TABLE_UPDATE</code> is
	 * displayed), the result is true, otherwise <code>false</code>.
	 */
	private Map<TableItem, Boolean> itemIsUpdating = null;

	/**
	 * The timer is used for the reset of the background color of an
	 * <code>TableItem</code> if it was displayed as updated (the color
	 * <code>TABLE_UPDATE</code> is displayed).
	 */
	Timer timer = null;

	/**
	 * Indicates if it is the first time that the view has got the focus.
	 */
	private boolean firstSetFocus = true;

	/**
	 * Creates an instance with default configuration.
	 */
	public StatemachineView() {

		super();

		config = new StatemachineViewConfig();

		manager = new EngineManager();
		manager.addEventListener(this);

		items = new HashMap<DataElement, TableItem>();
		itemButtons = new HashMap<DataElement, Button>();
		itemIsEditable = new HashMap<TableItem, Boolean>();
		itemIsUpdating = new HashMap<TableItem, Boolean>();

		timer = new Timer("StatemachineViewColorReset");
	}

	/**
	 * This is a callback that will allow us to create the viewer and initialize
	 * it.
	 */
	@Override
	public void createPartControl(final Composite parent) {

		super.createPartControl(parent);

		initializeToolBar();

		viewReset();
	}

	/**
	 * Initializes the tool bar of the table and adds all actions.
	 */
	private void initializeToolBar() {

		super.toolBarAddAction(new ShowNewEngineAction(config));
	}

	/**
	 * Used to provide the dynamic help of this view. The method
	 * {@link #getContextProvider()} is called to retrieve the
	 * {@link IContextProvider} instance which contains the help.
	 * 
	 * @see org.eclipse.ui.part.WorkbenchPart#getAdapter(java.lang.Class)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Object getAdapter(final Class adapter) {

		if (adapter.equals((IContextProvider.class))) {
			return getContextProvider();
		}
		return super.getAdapter(adapter);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see stateview.utilities.TableView#getToolTip()
	 */
	@Override
	protected String getToolTip() {

		return Messages.StatemachineView_tooltip;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see stateview.utilities.TableView#getColumnAlign()
	 */
	@Override
	protected int[] getColumnAlign() {

		return COLUMN_ALIGN;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see stateview.utilities.TableView#getColumns()
	 */
	@Override
	protected String[] getColumns() {

		return COLUMNS;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see stateview.utilities.TableView#sessionSelected(int)
	 */
	@Override
	protected void sessionSelected(final int selectionIndex) {

		synchronized (items) {
			manager.activateEngine(selectionIndex);
			viewReset();
		}
	}

	/**
	 * Allows to reset the view.
	 */
	private void viewReset() {

		synchronized (items) {

			// Refresh all currently required information
			comboResetEntries();

			if (manager.isEngineChanged()) {
				tableResetEntries();
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.itemis.yakindu.simulation.view.statemachine.presentation.utilities
	 * .ATableView #getRowEditable(org.eclipse.swt.widgets.TableItem)
	 */
	@Override
	protected boolean getRowEditable(final TableItem item) {

		synchronized (items) {
			return itemIsEditable.get(item);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.itemis.yakindu.simulation.view.statemachine.presentation.utilities
	 * .ATableView #getColumnEditable(java.lang.String)
	 */
	@Override
	protected boolean getColumnEditable(final String columnName) {

		synchronized (items) {

			boolean result = false;

			for (int index = 0; index < COLUMNS.length; index++) {
				if (COLUMNS[index].equals(columnName)) {
					result = COLUMN_EDITABLE[index];
				}
			}

			return result;
		}
	}

	/**
	 * Creates an instance of the {@link ContextProvider} which provides a
	 * dynamic help of this view.
	 * 
	 * @return The context provider with a dynamic help of this view.
	 */
	private IContextProvider getContextProvider() {

		return new ContextProvider();
	}

	/**
	 * @see org.mda4e.simulation.core.event.IEventListener#receiveEvent(org.mda4e.simulation.core.event.IEvent)
	 */
	public synchronized void receiveEvent(final IEvent event) {

		if (event instanceof StatemachineEvent) {

			final StatemachineEvent smEvent = (StatemachineEvent) event;

			if (manager
					.compareEngines(smEvent.getUUID(), smEvent.getInstance())) {

				if (smEvent.getEventType() == StatemachineEventTypes.VariableChanged
						|| smEvent.getEventType() == StatemachineEventTypes.EventChanged) {

					if (smEvent.getSource() instanceof Entry) {

						final Entry<?, ?> entry = (Entry<?, ?>) smEvent
								.getSource();

						entryChanged(entry);

					} else {
						log.warn("An unsupported \"VariableChanged\" type was found!"
								+ " The getSource() provides an unsupported class type: type = "
								+ smEvent.getSource().getClass()
										.getSimpleName()
								+ " (expected: Entry)!");
					}
				}
			}
		} else if (event instanceof DynamicItemEvent) {

			DynamicItemEvent itemEvent = (DynamicItemEvent) event;

			if (itemEvent.getEventType() == DynamicItemEventTypes.Add) {

				addDynamicEvent(itemEvent);

			} else if (itemEvent.getEventType() == DynamicItemEventTypes.Remove) {

				removeDynamicEvent(itemEvent);
			}

		} else if (event instanceof SimulationEvent
				&& event.getSource() instanceof IStatemachineEngine) {

			final SimulationEvent simEvent = (SimulationEvent) event;

			final IStatemachineEngine engine = (IStatemachineEngine) simEvent
					.getSource();

			if (simEvent.getEventType() == SimulationEventTypes.SimStart) {

				if (manager.compareEngines(engine.getUUID(),
						engine.getInstanceNumber())) {

					startTableActivation();

				} else if (config.isShowNewEngine()) {

					manager.activateEngine(engine);
					startViewReset();
				}
			} else if (simEvent.getEventType() == SimulationEventTypes.SimResume) {

				if (config.isShowNewEngine()) {

					manager.activateEngine(engine);
					startViewReset();
				}

			} else if (simEvent.getEventType() == SimulationEventTypes.SimStop
					&& manager.compareEngines(engine.getUUID(),
							engine.getInstanceNumber())) {

				startTableDeactivation();

			} else if (simEvent.getEventType() == SimulationEventTypes.EngineInitialized
					|| simEvent.getEventType() == SimulationEventTypes.SubEngineInitialized) {

				startViewReset();

			} else if (simEvent.getEventType() == SimulationEventTypes.EngineDisposed
					|| simEvent.getEventType() == SimulationEventTypes.SubEngineDisposed) {

				startViewReset();
			}
		}
	}

	/**
	 * Adds an element dynamically to the item list. It allows to add an element
	 * at any time and not only if the view is reset.
	 * 
	 * @param itemEvent defines the <code>DynamicItemEvent</code>
	 */
	private void addDynamicEvent(final DynamicItemEvent itemEvent) {

		if (itemEvent != null) {

			Display.getDefault().syncExec(new Runnable() {

				public void run() {

					if (itemEvent.getSource() instanceof Event) {

						itemAdd(
							new StringBuffer(Messages.StatemachineView_dynamic)
								.append(" ")
								.append(Messages.StatemachineView_event)
								.toString(),
							(DataElement) itemEvent.getSource(),
							0.0,
							true,
							ITEM_EVENT_COLOR);

					} else if (itemEvent.getSource() instanceof Variable) {

						DataElement dynamicElement =
								(DataElement) itemEvent.getSource();

						itemAdd(
							new StringBuffer(Messages.StatemachineView_dynamic)
								.append(" ")
								.append(getCategory(dynamicElement))
								.toString(),
							(DataElement) itemEvent.getSource(),
							0.0,
							true,
							getColor(dynamicElement));
					}
				}
			});
		}
	}

	/**
	 * Removes an element dynamically from the item list. It allows to remove an
	 * element at any time.
	 * 
	 * @param itemEvent defines the <code>DynamicItemEvent</code>
	 */
	private void removeDynamicEvent(final DynamicItemEvent itemEvent) {

		if (itemEvent != null) {

			Display.getDefault().syncExec(new Runnable() {

				public void run() {

					synchronized (items) {

						if (itemEvent.getSource() instanceof DataElement) {

							DataElement element =
									(DataElement) itemEvent.getSource();

							if (items.containsKey(element)) {
								tableRemove(items.get(element));
							}

							if (itemButtons.containsKey(element)) {
								Button button = itemButtons.remove(element);
								if (!button.isDisposed()) {
									button.dispose();
								}
							}
						} else {
							log.warn("Unsupported DynamicItemEvent received: "
										+ itemEvent
											.getSource()
											.getClass()
											.getSimpleName());
						}
					}
				}
			});
		}
	}

	/**
	 * Defines the category string of the given <code>DataElement</code>.
	 * 
	 * @param element defines the <code>DataElement</code> whose category shall
	 *            be defined
	 * 
	 * @return The category of the given element.
	 */
	private String getCategory(DataElement element) {

		String category = "";

		if (element.getIoType() == IOTypes.INPUT) {
			category = Messages.StatemachineView_input;
		} else if (element.getIoType() == IOTypes.LOCAL) {
			category = Messages.StatemachineView_local;
		} else if (element.getIoType() == IOTypes.OUTPUT) {
			category = Messages.StatemachineView_output;
		}

		return category;
	}

	/**
	 * Defines the color of the <code>element</code> with the help of the
	 * {@link IOTypes}.
	 * 
	 * @param element defines the element whose color shall be defined.
	 * 
	 * @return The respective color of the element.
	 */
	private Color getColor(DataElement element) {

		Color color = null;

		if (element.getIoType() == IOTypes.INPUT) {
			color = ITEM_INPUT_COLOR;
		} else if (element.getIoType() == IOTypes.LOCAL) {
			color = ITEM_LOCAL_COLOR;
		} else if (element.getIoType() == IOTypes.OUTPUT) {
			color = ITEM_OUTPUT_COLOR;
		}

		return color;
	}

	/**
	 * Calls the method {@link #tableActivate()} in an asynchronous thread.
	 */
	private void startTableActivation() {

		Display.getDefault().asyncExec(new Runnable() {

			public void run() {

				tableActivate();
			}
		});
	}

	/**
	 * Calls the method {@link #tableDeactivate()} in an asynchronous thread.
	 */
	private void startTableDeactivation() {

		Display.getDefault().asyncExec(new Runnable() {

			public void run() {

				tableDeactivate();
			}
		});
	}

	/**
	 * Calls the method {@link #viewReset()} in an asynchronous thread.
	 */
	private void startViewReset() {

		Display.getDefault().asyncExec(new Runnable() {

			public void run() {

				viewReset();
			}
		});
	}

	/**
	 * Checks if the given <code>Entry</code> is a valid item and adds it to the
	 * table.
	 * 
	 * @param entry defines the entry which shall be added to the table
	 */
	private void entryChanged(final Entry<?, ?> entry) {

		if (entry.getKey() != null && entry.getValue() != null) {

			if (entry.getKey() instanceof DataElement
				&& (entry.getValue() instanceof Double || entry.getValue() instanceof Boolean)) {

				final DataElement element = (DataElement) entry.getKey();

				final Double value;

				if (entry.getValue() instanceof Boolean) {
					value = (Boolean) entry.getValue() ? 1.0 : 0.0;
				} else {
					value = (Double) entry.getValue();
				}

				Display.getDefault().asyncExec(new Runnable() {

					public void run() {

						elementUpdate(element, value, SHOW_COLOR_TIME);
					}
				});

			} else {
				log.warn("An unsupported entry was found: key = "
							+ entry.getKey().getClass().getSimpleName()
							+ " (expected: DataElement), value = "
							+ entry.getValue().getClass().getSimpleName()
							+ " (expected: Double or Boolean)!");
			}
		} else {
			log.warn("An entry was found with a null parameter!");
		}
	}

	/**
	 * Passing the focus request to the viewer's control.
	 */
	@Override
	public void setFocus() {

		if (firstSetFocus) {
			viewReset();
		}
	}

	/**
	 * Set <code>firstSetFocus</code> to <code>false</code> to signal that the
	 * view has got the focus already once.
	 */
	private void deactivateFirstFocus() {

		firstSetFocus = false;
	}

	/**
	 * Refreshes the items in the table.
	 */
	private synchronized void tableResetEntries() {

		synchronized (items) {

			tableDeactivate();

			// Clear internal information
			itemClearAll();

			tableRemoveAll();

			if (manager.getActiveEngine() != -1) {

				// Read variables and events of the current statemachine
				final SortedMap<Variable, Double> variables = new TreeMap<Variable, Double>(
						new DataElementComparator());
				final Map<Event, Boolean> events = new TreeMap<Event, Boolean>(
						new DataElementComparator());

				variables.putAll(manager.getVariables());
				events.putAll(manager.getEvents());

				// Add all inputs of the statemachine
				for (final Entry<Variable, Double> variable : variables
						.entrySet()) {

					if (variable.getKey().getIoType().equals(IOTypes.INPUT)) {
						itemAdd(Messages.StatemachineView_input,
								variable.getKey(), variable.getValue(), true,
								ITEM_INPUT_COLOR);
					}
				}

				// Add all events of the statemachine
				for (final Entry<Event, Boolean> event : events.entrySet()) {
					itemAdd(Messages.StatemachineView_event, event.getKey(),
							event.getValue() ? 1.0 : 0.0, false,
							ITEM_EVENT_COLOR);
				}

				// Add all variables of the statemachine
				for (final Entry<Variable, Double> variable : variables
						.entrySet()) {

					if (variable.getKey().getIoType().equals(IOTypes.LOCAL)) {
						itemAdd(Messages.StatemachineView_local,
								variable.getKey(), variable.getValue(), true,
								ITEM_LOCAL_COLOR);
					}
				}

				// Add all outputs of the statemachine
				for (final Entry<Variable, Double> variable : variables
						.entrySet()) {

					if (variable.getKey().getIoType().equals(IOTypes.OUTPUT)) {
						itemAdd(Messages.StatemachineView_output,
								variable.getKey(), variable.getValue(), false,
								ITEM_OUTPUT_COLOR);
					}
				}

				if (manager.getActiveEngineState() != null
						&& manager.getActiveEngineState() != SimulationState.STOPPED) {
					tableActivate();
				}
			}

			manager.resetEngineChanged();
		}
	}

	/**
	 * Clear all objects which are required to organize the
	 * <code>TableItems</code>.
	 */
	private void itemClearAll() {

		itemIsEditable.clear();
		itemIsUpdating.clear();

		// All items are disposed by the super class
		items.clear();

		// Clear all buttons if required
		for (final Button button : itemButtons.values()) {
			if (!button.isDisposed()) {
				button.dispose();
			}
		}
		itemButtons.clear();
	}

	/**
	 * Calls the <code>updateTableItem</code> of the super class to set the new
	 * value of the given element. If the new value is 0.0, another background
	 * color is chosen as if the value is unequal to 0.0.
	 * 
	 * @param element defines the {@link DataElement} instance which shall be
	 *            updated
	 * @param value defines the value of the <code>element</code>
	 * @param showColor defines the duration, how long the color shall be
	 *            displayed
	 */
	private void elementUpdate(final DataElement element, final double value,
			final long showColor) {

		if (value == 0.0) {
			itemIncomingUpdate(element, value, TABLE_UPDATE_ZERO, showColor);
		} else {
			itemIncomingUpdate(element, value, TABLE_UPDATE_NOT_ZERO, showColor);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.itemis.yakindu.simulation.view.statemachine.presentation.utilities
	 * .ATableView #itemUpdated(org.eclipse.swt.widgets.TableItem, int,
	 * java.lang.String)
	 */
	@Override
	protected String itemUpdated(final TableItem item, final int curCol,
			final String text) {

		synchronized (items) {

			String result = null;
			DataElement element = null;

			for (final Entry<DataElement, TableItem> entry : items.entrySet()) {

				if (entry.getValue().equals(item)) {
					element = entry.getKey();
					break;
				}
			}

			if (element != null) {

				try {
					if (!manager.setItem(element, Double.valueOf(text))) {
						result = Messages.TableView_changeerror;
					}
				} catch (final NumberFormatException e) {
					result = Messages.TableView_valueiswrongdescription;
				} catch (final SimulationException e) {
					result = e.getMessage();
				}
			} else {
				result = Messages.StatemachineView_itemnotfound;
			}

			return result;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.itemis.yakindu.simulation.view.statemachine.presentation.utilities
	 * .ATableView #verifyInput(org.eclipse.swt.widgets.TableItem, int,
	 * java.lang.String)
	 */
	@Override
	protected String verifyInput(final TableItem item, final int curCol,
			final String text) {

		String result = null;

		try {
			Double.parseDouble(text);
		} catch (final NumberFormatException e) {
			result = Messages.TableView_valueiswrongdescription;
		}

		return result;
	}

	/**
	 * Removes all entries of the <code>Combo</code> and adds all current
	 * engines to this control. If the selection can be restored, this is also
	 * be done.
	 */
	private void comboResetEntries() {

		// Save the first call of this method.
		deactivateFirstFocus();

		// Clear combo
		comboRemoveAll();

		// Read all engines
		final List<String> engines = manager.getEngines();

		// Refresh the engine list
		if (engines != null) {

			final StringBuffer caption = new StringBuffer();

			for (int ind = 0; ind < engines.size(); ind++) {

				caption.setLength(0);
				caption.append(ind + 1);
				caption.append(": ");
				caption.append(engines.get(ind));

				comboAdd(caption.toString());
			}

			final int activeEngine = manager.getActiveEngine();

			if (activeEngine != -1) {
				comboSelectEntry(activeEngine);
			} else {
				comboShowNoEntry(Messages.StatemachineView_noentry);
			}
		}
	}

	/**
	 * Adds informations about the given element to the table.
	 * 
	 * @param category defines the category of the element
	 * @param element defines the element which shall be added
	 * @param editable indicates whether the new item is editable
	 * @param value defines the value of the element
	 * @param foreground defines the color which shall be used for the text
	 * 
	 * @return The result is <code>true</code> if the element was added
	 *         successful.
	 */
	private boolean itemAdd(final String category, final DataElement element,
			final double value, final boolean editable, final Color foreground) {

		synchronized (items) {

			boolean result = false;

			try {

				final TableItem item = tableGetNewItem(SWT.DEFAULT);

				// Set the category
				item.setText(0, category);

				// Set the name
				item.setText(1, element.getName());

				// Set value or the button
				if (element instanceof Variable) {
					item.setText(2, String.valueOf(value));
				} else if (element instanceof statemachine.Event) {
					setButton(item, element, 2, value);
				}

				// Set foreground color
				item.setForeground(foreground);

				// Store the dependency between table item and data element
				items.put(element, item);
				// Store the editable state
				itemIsEditable.put(item, editable);
				// Store the update state
				itemIsUpdating.put(item, false);

				result = true;

			} catch (final SWTException e) {
				System.err.println(e);
			}

			return result;
		}
	}

	/**
	 * Creates a <code>Button</code> instance and links the instance with the
	 * cell of the <code>TableItem</code>. The value is converted to a <code>
	 * boolean</code>
	 * value (0.0 = <code>true</code>, otherwise is <code>true</code>).
	 * 
	 * @param item defines the <code>TableItem</code> to which the button shall
	 *            be connected
	 * @param element defines the <code>DataElement</code> whose value shall be
	 *            set
	 * @param col defines the column which defines the position of the <code>
	 * 					Button</code>
	 * @param value defines the value which is needed to set the text of the
	 *            <code>Button</code>
	 */
	private void setButton(final TableItem item, final DataElement element,
			final int col, final double value) {

		final Button button = new Button(super.getTable(), SWT.TOGGLE);

		// Set text and selection state
		setEventButton(button, value);

		button.addSelectionListener(getButtonListener(item, button));

		// Define the optimal size
		final int buttonWidth =
				getButtonWidth(
					Messages.TableView_deactivateevent,
					Messages.TableView_fireevent);
		button.setSize(buttonWidth, tableRowHeight);

		// Resize the column which contains the button
		tableSetColWidth(getColumns()[2], button.getSize().x);

		final TableEditor editor = tableGetNewItemEditor();
		editor.horizontalAlignment = SWT.LEFT;
		editor.grabHorizontal = true;
		editor.grabVertical = true;
		editor.setEditor(button, item, col);

		// Store the button instance
		itemButtons.put(element, button);
	}

	/**
	 * Provides a <code>SelectionListener</code> for the given button which is a
	 * part of the given <code>TableItem</code>.
	 * 
	 * @param item defines the <code>TableItem</code> which contains the
	 *            <code>button</code>
	 * @param button defines the <code>Button</code> instance for which the
	 *            listener is
	 * 
	 * @return The listener which implements the methods
	 *         <code>widgetDefaultSelected()</code> and
	 *         <code>widgetSelected()</code>.
	 */
	private SelectionListener getButtonListener(final TableItem item,
			final Button button) {

		return new SelectionListener() {

			public void widgetDefaultSelected(final SelectionEvent e) {

				widgetSelected(e);
			}

			public void widgetSelected(final SelectionEvent e) {

				if (button.getSelection()) {

					button.setSelection(false);
					final String result = itemUpdated(item, 2, "1.0");

					if (result != null) {
						showErrorMessageBox(
							Messages.TableView_eventchangeerror,
							result);
					}
				} else {

					button.setSelection(true);
					final String result = itemUpdated(item, 2, "0.0");

					if (result != null) {
						showErrorMessageBox(
							Messages.TableView_eventchangeerror,
							result);
					}
				}
			}
		};
	}

	/**
	 * Indicates which <code>boolean</code> value the given <code>value</code>
	 * represents and set the respective text of the <code>Button</code>.
	 * 
	 * @param button defines the instance to set the text
	 * @param value defines the value which shall be converted into a
	 *            <code>boolean</code>
	 */
	private void setEventButton(final Button button, final double value) {

		if (value == 0.0) {
			button.setText(Messages.TableView_fireevent);
			button.setSelection(false);
		} else {
			button.setText(Messages.TableView_deactivateevent);
			button.setSelection(true);
		}
	}

	/**
	 * Identifies the maximum text length and calculates the associated text
	 * width.
	 * 
	 * @param text1 defines the first text
	 * @param text2 defines the second text
	 * 
	 * @return The maximum text width of the given texts.
	 */
	private int getButtonWidth(final String text1, final String text2) {

		int result = 0;
		int maxChar = 0;

		final FontMetrics metrics = new GC(super.getTable()).getFontMetrics();

		maxChar = Math.max(text1.length(), text2.length());

		result = (metrics.getAverageCharWidth() + 3) * maxChar;

		return result;
	}

	/**
	 * Updates an <code>TableItem</code> with the given value. To visualize the
	 * update the color will be changed, too.
	 * 
	 * @param element defines the element which shall be updated
	 * @param value defines the new value of the variable
	 * @param color specifies the color to make the change visible
	 * @param showColor defines the duration in which the color is displayed
	 */
	private void itemIncomingUpdate(final DataElement element,
			final Double value, final Color color, final long showColor) {

		synchronized (items) {

			if (element == null) {
				log.error("The variable (input) is \"null\" (value = " + value
							+ "!");
			}

			if (value == null) {

				if (element != null) {
					log.error("The value of the input \"" + element.getName()
								+ "\" is \"null\"!");
				} else {
					log
						.error("The value of the input \"(unknown)\" is \"null\"!");
				}
				return;
			}

			final TableItem item = items.get(element);

			if (item == null) {
				return;
			}

			// Update the item
			if (element instanceof Variable) {

				item.setText(2, value.toString());
				// Make the update visible.
				setItemUpdateColor(item, color, showColor);

			} else if (element instanceof statemachine.Event) {

				final Button button = itemButtons.get(element);

				setEventButton(button, value);

				// Make the update visible
				setButtonFontStyle(button, item, SWT.BOLD, showColor);
			}
		}
	}

	/**
	 * Sets the background color of the given item for the given time to the
	 * given <code>color</code>. After the time is left the default color will
	 * be reset.
	 * 
	 * @param item defines the item
	 * @param color defines the color, which shall be set
	 * @param showColor specifies the time in which the new color is visible
	 *            before the color will be reset
	 */
	private void setItemUpdateColor(final TableItem item, final Color color,
			final long showColor) {

		try {

			// Only if the item just is not already updated.
			if (item != null && !itemIsUpdating.get(item)) {

				// Save the current color.
				final Color defaultColor = item.getBackground();

				if (showColor > 0) {

					// Set the item state to "Updating"
					itemIsUpdating.put(item, true);

					// Set the new color.
					item.setBackground(2, color);

					// Add a task to reset the color after the specific time.
					try {
						timer.schedule(new TimerTask() {

							@Override
							public void run() {

								resetItemColor(item, defaultColor);
							}
						}, showColor);
					} catch (final IllegalStateException e) {
						log.debug("An timer error occurs: " + e.getMessage());
					}
				}
			}
		} catch (final SWTException e) {
		}
	}

	/**
	 * Sets the font style of the given <code>Button</code> for the given time
	 * to the given <code>color</code>. After the time is left the default style
	 * will be reset.
	 * 
	 * @param button defines the button whose style shall be changed
	 * @param item indicates the item which contains the button
	 * @param fontStyle defines the color, which shall be set (supported:
	 *            {@link SWT#NORMAL}, {@link SWT#BOLD}, {@link SWT#ITALIC})
	 * @param showStyle specifies the time in which the new style is visible
	 *            before the color will be reset
	 */
	private void setButtonFontStyle(final Button button, final TableItem item,
			final int fontStyle, final long showStyle) {

		int style = fontStyle;
		try {

			// Only if the item just is not already updated.
			if (item != null && !itemIsUpdating.get(item)) {

				final Font font = button.getFont();
				// Save the current style.
				final int defaultStyle = font.getFontData()[0].getStyle();

				if (showStyle > 0) {

					// Set the item state to "Updating"
					itemIsUpdating.put(item, true);

					if (style != SWT.BOLD && style != SWT.NORMAL
						&& style != SWT.ITALIC) {
						style = SWT.BOLD;
					}

					// Set the new color.
					final FontData data = font.getFontData()[0];
					data.setStyle(style);
					button.setFont(new Font(Display.getDefault(), data));
					button.redraw();

					// Add a task to reset the color after the specific time.
					try {

						timer.schedule(new TimerTask() {

							@Override
							public void run() {

								resetButtonFontStyle(button, item, defaultStyle);
							}
						},
							showStyle);
					} catch (final IllegalStateException e) {
						log.debug("An timer error occurs: " + e.getMessage());
					}
				}
			}
		} catch (final SWTException e) {
		}
	}

	/**
	 * Reset the color of the given item.
	 * 
	 * @param item defines the item to reset.
	 * @param defaultColor specifies the default background color
	 */
	private void resetItemColor(final TableItem item, final Color defaultColor) {

		Display.getDefault().asyncExec(new Runnable() {

			public void run() {

				try {

					synchronized (items) {

						// Reset the item color.
						for (int ind = 0; ind < item
							.getParent()
							.getColumnCount(); ind++) {
							item.setBackground(ind, defaultColor);
						}

						// Reset the item state to "Ready"
						itemIsUpdating.put(item, false);
					}
				} catch (final SWTException e) {
				}
			}
		});
	}

	/**
	 * Reset the color of the button which is assigned to the given
	 * <code>TableItem</code>.
	 * 
	 * @param button defines the button whose style shall be reset
	 * 
	 * @param item defines the item to reset.
	 * @param defaultStyle specifies the default font style (supported:
	 *            {@link SWT#NORMAL}, {@link SWT#BOLD}, {@link SWT#ITALIC})
	 */
	private void resetButtonFontStyle(final Button button,
			final TableItem item, final int defaultStyle) {

		Display.getDefault().asyncExec(new Runnable() {

			public void run() {

				try {

					synchronized (items) {

						final Font font = button.getFont();
						final FontData data = font.getFontData()[0];

						if (defaultStyle == SWT.BOLD
							|| defaultStyle == SWT.NORMAL
							|| defaultStyle == SWT.ITALIC) {
							data.setStyle(defaultStyle);
						} else {
							data.setStyle(SWT.NORMAL);
						}

						button.setFont(new Font(Display.getDefault(), data));

						// Reset the item state to "Ready"
						itemIsUpdating.put(item, false);
					}
				} catch (final SWTException e) {
				}
			}
		});
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.itemis.yakindu.simulation.view.statemachine.presentation.utilities
	 * .ATableView #dispose()
	 */
	@Override
	public void dispose() {

		super.dispose();

		itemClearAll();
	}
}