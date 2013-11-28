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

import java.util.Arrays;

import org.apache.log4j.Logger;
import org.eclipse.jface.action.IAction;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.part.ViewPart;

import com.yakindu.simulation.view.statemachine.nls.Messages;

/**
 * The class <code>ATableView</code> is a simple <code>ViewPart</code>, which
 * allows the visualization of one or more items with a name and value in a
 * simple table. Furthermore, it provides an simple editor for the values of the
 * items.
 * 
 * @author Philipp Richter
 */
public abstract class ATableView extends ViewPart {

	/** Defines the instance to log informations and errors. */
	private static final Logger log = Logger.getLogger(ATableView.class);

	/** Defines the space between the text and the cell border. */
	private static final int TEXT_SPACE = 5;

	/** Defines the background color of the editor. */
	protected static final Color EDITOR_BACK =
			new Color(Display.getDefault(), 240, 255, 255);
	/**
	 * Defines the background color of the editor, if the verification of the
	 * value was negative.
	 */
	protected static final Color EDITOR_ERROR =
			new Color(Display.getDefault(), 255, 0, 0);
	/**
	 * Defines the cell color, if an value was updated and the value is unequal
	 * to 0.
	 */
	protected static final Color TABLE_UPDATE_NOT_ZERO =
			new Color(Display.getDefault(), 106, 255, 106);
	/**
	 * Defines the cell color, if an value was updated and the value is unequal
	 * to 0.
	 */
	protected static final Color TABLE_UPDATE_ZERO =
			new Color(Display.getDefault(), 255, 255, 106);
	/** The duration to show <code>TABLE_UPDATE</code> color. */
	protected static final long SHOW_COLOR_TIME = 500;
	/** Defines the color of the category "input". */
	protected static final Color ITEM_INPUT_COLOR =
			new Color(Display.getDefault(), 0, 100, 0);
	/** Defines the color of the category "event". */
	protected static final Color ITEM_EVENT_COLOR =
			new Color(Display.getDefault(), 0, 0, 105);
	/** Defines the color of the category "local". */
	protected static final Color ITEM_LOCAL_COLOR =
			new Color(Display.getDefault(), 120, 0, 0);
	/** Defines the color of the category "output". */
	protected static final Color ITEM_OUTPUT_COLOR =
			new Color(Display.getDefault(), 0, 0, 0);

	/** Defines the height of the table rows. */
	protected int tableRowHeight = 25;

	/** Defines the combo who contains all running simulation engines. */
	private Combo cChoice = null;

	/** The table to manage the items of the specific statemachine. */
	private Table tItems = null;

	/** Defines the name of the first column. */
	/** The editor to edit the items within the table. */
	private TableEditor editor = null;

	/**
	 * Creates an instance of the <code>ATableView</code>.
	 */
	public ATableView() {

		if (getColumns() == null) {
			throw new NullPointerException("The columns must not be \"null\"!");
		}

		if (getColumnAlign() == null) {
			throw new NullPointerException(
				"The column alignment definition must not be \"null\"!");
		}

		if (getColumnAlign().length != getColumns().length) {
			throw new IllegalArgumentException(
				"The number of columns and the number of column alignment definitions are not equal!");
		}
	}

	/**
	 * This is a callback that will allow us to create the viewer and initialize
	 * it.
	 * 
	 * @param parent defines the parent <code>Composite</code>
	 */
	@Override
	public void createPartControl(final Composite parent) {

		initialize(parent);
	}

	/**
	 * Initializes the view and create all needed controls.
	 * 
	 * @param parent defines the parent <code>Composite</code> which contains
	 *            all controls
	 */
	private void initialize(final Composite parent) {

		parent.setLayout(new GridLayout(1, false));

		// GridData for combo
		final GridData gridData = new GridData();
		gridData.horizontalAlignment = SWT.FILL;
		gridData.grabExcessHorizontalSpace = true;
		gridData.verticalAlignment = SWT.FILL;

		// GridData for table
		final GridData gridData2 = new GridData();
		gridData2.horizontalAlignment = SWT.FILL;
		gridData2.grabExcessHorizontalSpace = true;
		gridData2.verticalAlignment = SWT.FILL;
		gridData2.grabExcessVerticalSpace = true;

		initializeCombo(parent, gridData);
		initializeTable(parent, gridData2);
		initializeTableEditor(tItems);
	}

	/**
	 * Initializes the <code>Combo</code> with the given <code>GridData</code>.
	 * 
	 * @param parent defines the parent which contains the <code>Combo</code>
	 * @param gridData defines the properties of the <code>Combo</code>
	 */
	private void initializeCombo(final Composite parent, final GridData gridData) {

		cChoice = new Combo(parent, SWT.DOUBLE_BUFFERED | SWT.READ_ONLY);
		cChoice.setEnabled(false);
		cChoice.setLayoutData(gridData);
		cChoice.addSelectionListener(new SelectionListener() {

			public void widgetDefaultSelected(final SelectionEvent e) {

				sessionSelected(cChoice.getSelectionIndex());
			}

			public void widgetSelected(final SelectionEvent e) {

				sessionSelected(cChoice.getSelectionIndex());
			}

		});
	}

	/**
	 * Is called, if the section of the <code>Combo</code> was changed.
	 * 
	 * @param selectionIndex indicates the selection index
	 */
	protected void sessionSelected(final int selectionIndex) {

		// Default implementation.
	}

	/**
	 * Initializes the table and sets all required properties.
	 * 
	 * @param parent defines the parent composite of the <code>Table</code>
	 * @param gridData defines the properties of the <code>Table</code>
	 */
	private void initializeTable(final Composite parent, final GridData gridData) {

		tItems = new Table(parent, SWT.BORDER | SWT.DOUBLE_BUFFERED);
		tItems.setLayoutData(gridData);
		tItems.setHeaderVisible(true);
		tItems.setLinesVisible(true);
		tItems.setToolTipText(getToolTip());
		tItems.setEnabled(false);

		defineTableItemHeight();

		// Define the row height (table item)
		tItems.addListener(SWT.MeasureItem, new Listener() {

			public void handleEvent(final Event event) {

				event.height = tableRowHeight;
			}
		});

		if (getColumns() != null) {

			TableColumn column = null;

			for (int index = 0; index < getColumns().length; index++) {

				column = new TableColumn(tItems, SWT.DEFAULT);
				column.setAlignment(getColumnAlign()[index]);
				column
					.setText(getColumns()[index] != null ? (getColumns()[index])
							: String.valueOf(index));
				column.setMoveable(true);
				column.pack();
				column.setWidth(column.getWidth() + 20);
			}
		}
	}

	/**
	 * Defines the table item height with the help of temporary instantiated
	 * <code>Button</code>.
	 */
	private void defineTableItemHeight() {

		Button tempButton = new Button(tItems, SWT.TOGGLE);
		tempButton.setFont(tItems.getFont());
		tempButton.setText("SET HEIGHT");
		tempButton.pack();
		tableRowHeight = tempButton.getSize().y - 6;
		tempButton.dispose();
		tempButton = null;
	}

	
	protected void setUpTextControl(TableItem item, int col) {
		if (editor.getEditor() != null) return;

		Text textEditor = new Text(item.getParent(), SWT.BORDER);
		textEditor.setBackground(EDITOR_BACK);

		addTextEditorListener(textEditor, item, col);
		textEditor.setText(item.getText(col));

		editor.setEditor(textEditor, item, col);
	
		textEditor.selectAll();
		textEditor.setFocus();
	}

	protected void tearDownTextControl() {
		if (editor.getEditor() != null) {
			editor.getEditor().dispose();
			editor.setEditor(null);
		}
	}

	
	/**
	 * Initializes the table editor.
	 * 
	 * @param table defines the table which shall be editable.
	 */
	private void initializeTableEditor(final Table table) {

		
		editor = new TableEditor(table);
		editor.horizontalAlignment = SWT.RIGHT;
		editor.grabHorizontal = true;
		editor.grabVertical = true;

		table.addListener(SWT.MouseDown, new Listener() {

			public void handleEvent(final Event event) {

				synchronized (tItems) {

					final Rectangle clientArea = table.getClientArea();

					// Position of the cursor
					final Point cursor = new Point(event.x, event.y);

					int curIndex = table.getTopIndex();

					while (curIndex < table.getItemCount()) {

						boolean visible = false;
						final TableItem curItem = table.getItem(curIndex);

						if (curItem != null && !curItem.isDisposed()) {

							for (int col = 0; col < table.getColumnCount(); col++) {

								final Rectangle cellArea =
										curItem.getBounds(col);

								if (getColumnEditable(tItems
									.getColumn(col)
									.getText())
									&& cellArea.contains(cursor)) {

									if (tItems.isEnabled()
										&& getRowEditable(curItem)) {

										setUpTextControl(curItem, col);
										return;
									}
								}

								// Is the cell visible at all or is she
								// concealed?
								if (!visible && cellArea.intersects(clientArea)) {
									visible = true;
								}
							}

							if (!visible) {
								// The selected cell is not visible for the
								// user!
								return;
							}

							curIndex++;
						}
					}
				}
			}
		});
	}

	/**
	 * Adds the listener to the given editor with the
	 * 
	 * @param editor defines the text field
	 * @param item defines the corresponding <code>TableItem</code>
	 * @param curCol defines the current selected column of the
	 *            <code>item</code>
	 */
	private void addTextEditorListener(final Text editor, final TableItem item,
			final int curCol) {

		// Add focus listener
		editor.addListener(SWT.FocusOut, new Listener() {

			public void handleEvent(final Event event) {

				editor.setEditable(false);

				final String message =
						verifyInput(item, curCol, editor.getText());

				if (message == null) {

					startItemUpdate(item, curCol, editor.getText());

					tearDownTextControl();
					// textEditor.dispose();

				} else {

					tearDownTextControl();
					// textEditor.dispose();
					event.doit = false;

					showErrorMessageBox(
						Messages.TableView_valueiswrong,
						message);
				}

			}
		});

		// Add traverse listener
		editor.addListener(SWT.Traverse, new Listener() {

			public void handleEvent(final Event event) {

				if (event.detail == SWT.TRAVERSE_RETURN) {

					editor.setEditable(false);

					final String message =
							verifyInput(item, curCol, editor.getText());

					if (message == null) {

						startItemUpdate(item, curCol, editor.getText());
						tearDownTextControl();

					} else {

						if (ATableView.this.editor.getEditor() != null) {
							ATableView.this.editor.getEditor().setBackground(EDITOR_ERROR);
						}
						event.doit = false;
					}
				}
				// The text edit was aborted.
				else if (event.detail == SWT.TRAVERSE_ESCAPE) {

					tearDownTextControl();
					event.doit = false;
				}
			}
		});
	}

	/**
	 * Starts the update of the given item asynchronous and displays an error
	 * message if required.
	 * 
	 * @param item defines the <code>TableItem</code> to update
	 * @param curCol defines the column which shall be updated
	 * @param text defines the new value
	 */
	private void startItemUpdate(final TableItem item, final int curCol,
			final String text) {

		Display.getDefault().asyncExec(new Runnable() {

			public void run() {

				try {
					final String result = itemUpdated(item, curCol, text);

					if (result != null) {
						throw new Exception(Messages.TableView_changeerror);
					}
				} catch (final Exception e) {
					showErrorMessageBox(Messages.TableView_valuechangeerror, e
						.getMessage());
				}
			}

		});
	}

	/**
	 * Is called if a cell of a <code>TableItem</code> was updated. This method
	 * is only called, if the method
	 * {@link #verifyInput(TableItem, int, String)} verifies the new value
	 * successfully.
	 * 
	 * @param item defines the affected <code>TableItem</code>
	 * @param curCol defines the currently selected column of the item
	 * @param text defines the new value of the cell
	 * 
	 * @return The result is not <code>null</code>, if the update was failed. In
	 *         this case the result contains the error message why the update
	 *         was not successful.
	 */
	protected String itemUpdated(final TableItem item, final int curCol,
			final String text) {

		// Default implementation.
		if (log.isDebugEnabled()) {
			log.debug("Default implementation called!");
		}
		return null;
	}

	/**
	 * Is called before a cell of a <code>TableItem</code> is updated and allows
	 * to verify the new value of the cell.
	 * 
	 * @param item defines the affected <code>TableItem</code>
	 * @param curCol defines the currently selected column of the
	 *            <code>item</code>
	 * @param text defines the new value of the cell
	 * 
	 * @return The result is <code>null</code>, if the value is valid, otherwise
	 *         the result contains the message which describes why the value is
	 *         not valid.
	 */
	protected String verifyInput(final TableItem item, final int curCol,
			final String text) {

		// Default implementation.
		if (log.isDebugEnabled()) {
			log.debug("Default implementation called!");
		}
		return null;
	}

	/**
	 * Provides the editable state of the the given <code>TableItem</code>.
	 * 
	 * @param item defines the affected <code>TableItem</code>
	 * 
	 * @return The result is <code>true</code> if the <code>item</code> is
	 *         editable.
	 */
	protected boolean getRowEditable(final TableItem item) {

		// Default implementation
		if (log.isDebugEnabled()) {
			log.debug("Default implementation called!");
		}
		return false;
	}

	/**
	 * Provides the editable state of the given column, specified by the column
	 * name.
	 * 
	 * @param columnName defines the name of the column
	 * 
	 * @return The result is <code>true</code>, if the column is editable.
	 */
	protected boolean getColumnEditable(final String columnName) {

		// Default implementation
		if (log.isDebugEnabled()) {
			log.debug("Default implementation called!");
		}
		return false;
	}

	/**
	 * Shows a <code>MessageBox</code> with the given title and message and
	 * returns after the box is closed by the user.
	 * 
	 * @param title defines the message box title
	 * @param message defines the message which describes the problem
	 */
	public void showErrorMessageBox(final String title, final String message) {

		final MessageBox box =
				new MessageBox(tItems.getShell(), SWT.ICON_ERROR);
		box.setText(title);
		box.setMessage(message);
		box.open();

	}

	/**
	 * Allows to add a string to the combo.
	 * 
	 * @param text defines the text
	 */
	protected void comboAdd(final String text) {

		synchronized (cChoice) {

			if (!cChoice.isEnabled()) {
				cChoice.removeAll();
				cChoice.setEnabled(true);
			}

			cChoice.add(text);
		}
	}

	/**
	 * Allows to select an entry of the <code>Combo</code>.
	 * 
	 * @param index defines the index of the entry which shall be selected
	 * 
	 * @return The result is <code>true</code> if the entry could be selected.
	 *         If the index is out of bounds the result is <code>false</code>.
	 */
	protected boolean comboSelectEntry(final int index) {

		boolean result = false;

		synchronized (cChoice) {

			if (index > -1 && index < cChoice.getItemCount()) {

				cChoice.select(index);
				result = true;
			}
		}

		return result;
	}

	/**
	 * Removes all entries of the <code>Combo</code> and set the given message
	 * as info text, that no item is currently in the <code>Combo</code>.
	 * 
	 * @param message defines the message which indicates that no entry is
	 *            available
	 */
	protected void comboShowNoEntry(final String message) {

		synchronized (cChoice) {

			comboRemoveAll();
			cChoice.setEnabled(false);
			cChoice.add(message);
			cChoice.select(0);
		}
	}

	/**
	 * Allows to remove a specific item of the combo.
	 * 
	 * @param entryIndex defines the index of the item which shall be removed
	 * 
	 * @return The result is <code>true</code>, if the index is valid and the
	 *         entry is removed.
	 */
	protected boolean comboRemove(final int entryIndex) {

		boolean result = false;

		synchronized (cChoice) {

			if (entryIndex >= 0 && entryIndex < cChoice.getItemCount()
				&& cChoice.isEnabled()) {

				cChoice.remove(entryIndex);
				result = true;
			}

			return result;
		}
	}

	/**
	 * Removes all entries of the <code>Combo</code>.
	 */
	protected void comboRemoveAll() {

		synchronized (cChoice) {

			if (!cChoice.isDisposed() && cChoice.isEnabled()) {

				cChoice.removeAll();
			}
		}
	}

	/**
	 * Returns a new <code>TableItem</code>.
	 * 
	 * @param style defines the style of the table item.
	 * 
	 * @return A new instance of <code>TableItem</code> which is a child of this
	 *         table.
	 */
	protected TableItem tableGetNewItem(final int style) {

		synchronized (tItems) {
			return new TableItem(tItems, SWT.DEFAULT);
		}
	}

	/**
	 * Creates a new <code>TableEditor</code> instance.
	 * 
	 * @return The new <code>TableEditor</code> instance of this table.
	 */
	protected TableEditor tableGetNewItemEditor() {

		synchronized (tItems) {
			return new TableEditor(tItems);
		}
	}

	/**
	 * Calculates a new width for the given column which is at least equal to
	 * <code>minWidth</code> + {@link #TEXT_SPACE}.
	 * 
	 * @param columnName defines the name of the column
	 * @param minWidth defines the minimum width
	 */
	protected void tableSetColWidth(final String columnName, final int minWidth) {

		for (final TableColumn column : tItems.getColumns()) {

			if (column.getText().equals(columnName)
				&& column.getWidth() < minWidth + TEXT_SPACE) {

				column.setWidth(minWidth + TEXT_SPACE);
			}
		}
	}

	/**
	 * Disables the table and disposes the text editor control.
	 */
	protected void tableDeactivate() {

		synchronized (tItems) {

			tearDownTextControl();
//			// Dispose the text editor control
//			if (textEditor != null && !textEditor.isDisposed()) {
//				textEditor.dispose();
//			}

			if (!tItems.isDisposed()) {
				tItems.setEnabled(false);
			}
		}
	}

	/**
	 * Enables the table.
	 */
	protected void tableActivate() {

		synchronized (tItems) {

			if (!tItems.isDisposed()) {
				tItems.setEnabled(true);
			}
		}
	}

	/**
	 * Removes the given <code>TableItem</code>.
	 * 
	 * @param tableItem defines the <code>TableItem</code> to remove
	 */
	protected void tableRemove(TableItem tableItem) {

		if (tItems != null) {

			if (tableItem != null) {

				synchronized (tItems) {

					if (editor.getItem() != null
						&& editor.getItem().equals(tableItem)) {
						disposeEditor();
					}

					if (!tableItem.isDisposed()) {
						tableItem.dispose();
					}
				}
			}
		}
	}

	/**
	 * Resets the controls of the view.
	 */
	protected void tableRemoveAll() {

		if (tItems != null) {

			synchronized (tItems) {

				if (!tItems.isDisposed()) {
					for (final TableItem item : tItems.getItems()) {
						if (!item.isDisposed()) {
							item.dispose();
						}
					}
				}

				disposeEditor();
			}
		}
	}

	/**
	 * Disposes table editor.
	 */
	private void disposeEditor() {

		if (editor != null) {

			tearDownTextControl();
		}
	}

	/**
	 * Defines the alignment of the columns.
	 * 
	 * @return An array with the alignment of each column.
	 */
	protected int[] getColumnAlign() {

		final int[] align = new int[getColumns().length];
		Arrays.fill(align, SWT.LEFT);
		return align;
	}

	/**
	 * Provides a tool tip message.
	 * 
	 * @return The tool tip message for this view.
	 */
	protected String getToolTip() {

		return "";
	}

	/**
	 * Provides the instance of the <code>Table</code>.
	 * 
	 * @return The <code>Table</code> instance.
	 */
	protected Table getTable() {

		return tItems;
	}

	/**
	 * Adds the given action to the tool bar of the view.
	 * 
	 * @param action defines the <code>IAction</code> to add
	 * 
	 * @return The result is <code>true</code> if the action was added
	 *         successful.
	 */
	protected boolean toolBarAddAction(final IAction action) {

		boolean result = true;

		if (action != null) {
			getViewSite().getActionBars().getToolBarManager().add(action);
		} else {
			result = false;
		}

		return result;
	}

	/**
	 * Returns the column names in the right order which shall be added to the
	 * table.
	 * 
	 * @return All columns for the table.
	 */
	protected abstract String[] getColumns();

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.part.WorkbenchPart#dispose()
	 */
	@Override
	public void dispose() {

		comboRemoveAll();
		tableRemoveAll();

		tearDownTextControl();
		
		editor.dispose();
		editor = null;

	}
}