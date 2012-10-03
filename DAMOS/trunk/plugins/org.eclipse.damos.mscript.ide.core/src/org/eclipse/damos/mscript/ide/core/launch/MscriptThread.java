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

package org.eclipse.damos.mscript.ide.core.launch;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.damos.mscript.ide.core.IDECorePlugin;
import org.eclipse.damos.mscript.interpreter.IFunctionObject;
import org.eclipse.damos.mscript.interpreter.IInterpreterContext;

/**
 * @author Andreas Unger
 *
 */
public class MscriptThread extends Thread {

	private IInterpreterContext interpreterContext;
//	private IFunctionObject functionObject;
//	private IFile inputFile;
//	private IFile outputFile;
	
	private List<IMscriptExecutionListener> listeners = new ArrayList<IMscriptExecutionListener>();

	/**
	 * 
	 */
	public MscriptThread(IInterpreterContext interpreterContext, IFunctionObject functionObject, IFile inputFile, IFile outputFile) {
		super("Mscript Application");
		this.interpreterContext = interpreterContext;
//		this.functionObject = functionObject;
//		this.inputFile = inputFile;
//		this.outputFile = outputFile;
	}
	
	/**
	 * @return the interpreterContext
	 */
	public IInterpreterContext getInterpreterContext() {
		return interpreterContext;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Thread#run()
	 */
	@Override
	public void run() {
		try {
//			IInterpreter interpreter = new Interpreter();
//			interpreter.initialize(interpreterContext, functionObject);
//			
//			BufferedReader reader = new BufferedReader(new InputStreamReader(inputFile.getContents()));
//			while (!interpreterContext.isCanceled() && reader.ready()) {
//				List<IValue> inputValues = ParseUtil.parseValues(interpreterContext, reader.readLine());
//				StringBuilder sb = new StringBuilder();
//				List<IValue> outputValues = interpreter.execute(interpreterContext, functionObject, inputValues);
//				for (IValue outputValue : outputValues) {
//					if (sb.length() > 0) {
//						sb.append(",");
//					}
//					if (outputValue instanceof ISimpleNumericValue) {
//						ISimpleNumericValue numericValue = (ISimpleNumericValue) outputValue;
//						sb.append(numericValue.doubleValue());
//					} else if (outputValue instanceof IBooleanValue) {
//						IBooleanValue booleanValue = (IBooleanValue) outputValue;
//						sb.append(booleanValue.booleanValue());
//					} else {
//						sb.append("INVALID");
//					}
//				}
//				sb.append("\n");
//				outputFile.appendContents(new StringInputStream(sb.toString()), false, false, new NullProgressMonitor());
//				functionObject.incrementStepIndex();
//			}
		} catch (Exception e) {
			fireMscriptExecutionListener(new MscriptExecutionEvent(this, new Status(IStatus.ERROR, IDECorePlugin.PLUGIN_ID, e.getMessage(), e)));
		}
		fireMscriptExecutionListener(new MscriptExecutionEvent(this, Status.OK_STATUS));
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.damos.simulation.ISimulationMonitor#addSimulationListener(org.eclipse.damos.simulation.ISimulationListener)
	 */
	public void addExecutionListener(IMscriptExecutionListener l) {
		synchronized (listeners) {
			if (!listeners.contains(l)) {
				listeners.add(l);
			}
		}
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.damos.simulation.ISimulationMonitor#removeSimulationListener(org.eclipse.damos.simulation.ISimulationListener)
	 */
	public void removeExecutionListener(IMscriptExecutionListener l) {
		synchronized (listeners) {
			listeners.remove(l);
		}
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.damos.simulation.ISimulationMonitor#fireSimulationListener(org.eclipse.damos.simulation.SimulationEvent)
	 */
	public void fireMscriptExecutionListener(MscriptExecutionEvent event) {
		IMscriptExecutionListener[] ls;
		synchronized (listeners) {
			ls = listeners.toArray(new IMscriptExecutionListener[listeners.size()]);
		}
		for (IMscriptExecutionListener l : ls) {
			l.handleSimulationEvent(event);
		}
	}

}
