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
package com.yakindu.simulation.launch;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.mda4e.simulation.controller.ISimulationController;
import org.mda4e.simulation.controller.event.ControllerEvent;
import org.mda4e.simulation.core.ISimulationEngine;
import org.mda4e.simulation.core.ISimulationParameterSet;
import org.mda4e.simulation.core.SimulationException;
import org.mda4e.simulation.core.event.EventDispatcher;
import org.mda4e.simulation.core.event.IEvent;
import org.mda4e.simulation.core.event.IEventListener;
import org.mda4e.simulation.core.event.SimulationEvent;
import org.mda4e.simulation.core.event.SimulationEvent.SimulationEventTypes;

import com.yakindu.simulation.launch.debug.DebugTarget;

/**
 * The <code>YakinduSimulationLauncher</code> manages the environment for a
 * simulation. The chosen {@link ISimulationEngine} which realizes the engine to
 * simulate the given system and all {@link ISimulationController}s are be
 * instantiated and initialized. An instance of {@link SimulationControlWindow}
 * realizes the user interface to control the simulation engine and provides
 * informations about the simulation.
 * 
 * @author Markus M�hlbrandt, Philipp Richter
 * @author Benjamin Schwertfeger
 */
public class YakinduSimulationLauncher extends EventDispatcher implements Runnable {

	/**
	 * Contains all currently registered simulation controller.
	 */
	private List<ISimulationController> simulationControllerList;

	/**
	 * Allows to marks the simulation as disposed and signals eclipse that the
	 * environment can be disposed.
	 */
	private IProgressMonitor monitor;
	// private boolean isStopped=true;

	/**
	 * Defines the simulation engine which is chosen to simulate the given
	 * system.
	 */
	private ISimulationEngine simulationEngine = null;

	/**
	 * The constructor allows to create a list of all registered controller, the
	 * control window and the simulation engine with the given simulation
	 * parameters.
	 * 
	 * @param simulationParameterSet
	 *            defines the specific simulation parameters
	 * @param engineIndex
	 *            defines the chosen engine for the simulation
	 * @param launch
	 *            defines the <code>ILaunch</code> instance
	 * @param monitor
	 *            defines the <code>IProgressMonitor</code> instance
	 */
	public YakinduSimulationLauncher(final DebugTarget target,
			final ISimulationParameterSet simulationParameterSet, final int engineIndex,
			final IProgressMonitor monitor) {
		this.monitor = monitor;
		IExtensionRegistry reg = Platform.getExtensionRegistry();
		IConfigurationElement[] engineExtensionList = reg
				.getConfigurationElementsFor(ISimulationEngine.ENGINE_EXTENSION_POINT);
		IConfigurationElement[] serviceExtensionList = reg
				.getConfigurationElementsFor(ISimulationController.CONTROLLER_EXTENSION_POINT);

		// Defining all controllers who are registered.
		simulationControllerList = createSimulationServices(
				serviceExtensionList, engineExtensionList, engineIndex);

		// Register all controllers. Thus, controllers receive the engine
		// created event, if an
		// simulation engine is instantiated.
		simulationControllerList.add(target);
		this.addEventListener(target);
		for (ISimulationController controller : simulationControllerList) {
			addEventListener(controller);
		}

		// Instantiate the engine
		createEngine(engineExtensionList, engineIndex, simulationParameterSet);
	}

	/**
	 * This method allows the definition of all services (controllers) in form
	 * of <code>ISimulationController</code> instances. The services are
	 * informed, if an simulation engine is created and can register a listener.
	 * Thus, they can react, if the engine sends an event.
	 * 
	 * @param serviceExtensionList
	 *            defines all stand-alone services
	 * @param engineExtensionList
	 *            defines the services of the instantiated engine
	 * @param index
	 *            defines the index of the control service in the
	 *            <code>engineExtensionList</code>
	 * 
	 * @return The list of all services.
	 */
	private List<ISimulationController> createSimulationServices(
			final IConfigurationElement[] serviceExtensionList,
			final IConfigurationElement[] engineExtensionList, final int index) {

		List<ISimulationController> simulationServiceList = new ArrayList<ISimulationController>();

		// ISimulationController[] simulationServiceList = new
		// ISimulationController[serviceExtensionList.length+1];

		// Gets the controls of the current engine himself
		//ISimulationController engineCon = getEngineControls(
		//		engineExtensionList, index);

//		if (engineCon != null) {
//			simulationServiceList.add(engineCon);
//			engineCon.addEventListener(getSimulationListener());
//		}

		// Defining all other controllers who are registered.
		try {

			for (int i = 0; i < serviceExtensionList.length; i++) {

				ISimulationController controller = (ISimulationController) serviceExtensionList[i]
						.createExecutableExtension("Class");

				if (controller != null) {
					simulationServiceList.add(controller);
					controller.addEventListener(getSimulationListener());
				}

			} // for

		} catch (CoreException e) {

			showCoreException(e);

		} // try/catch

		return simulationServiceList;
	}

//	/**
//	 * This method helps to get the engine specific controls of the engine. In
//	 * this way the engine can deliver her own controls with special functions.
//	 * 
//	 * @param engineExtensionList
//	 *            defines the list of configuration elements
//	 * @param index
//	 *            specifies the index of the element of which the controls shall
//	 *            be loaded
//	 * 
//	 * @return The result is the instance of the type
//	 *         <code>ISimulationController</code> which contains the controls of
//	 *         the given engine.
//	 */
//	private ISimulationController getEngineControls(
//			final IConfigurationElement[] engineExtensionList, final int index) {
//
//		ISimulationController simulationController = null;
//
//		if (index < engineExtensionList.length) {
//			IConfigurationElement element = engineExtensionList[index];
//			if (element.getAttribute("EngineControls") != null) {
//				try {
//					// Instantiate the simulation controls of the engine itself.
//					simulationController = (ISimulationController) element
//							.createExecutableExtension("EngineControls");
//				} catch (CoreException e) {
//					showCoreException(e);
//				}
//			}
//		}
//		return simulationController;
//	}

	/**
	 * The method instantiates a new object of the given engine and sets the
	 * simulation parameters. Then, the engine created event is sent.
	 * 
	 * @param engineExtensionList
	 *            defines the list of engine extensions
	 * @param index
	 *            indicates the index of the engine instance in the engine
	 *            extension list
	 * @param simulationParameters
	 *            defines the simulation parameters
	 */
	private void createEngine(final IConfigurationElement[] engineExtensionList,
			final int index, final ISimulationParameterSet simulationParameters) {

		if (index < engineExtensionList.length) {
			IConfigurationElement element = engineExtensionList[index];
			if (element.getAttribute("Class") != null) {

				// >>> 1. Create the instance of the engine
				try {

					simulationEngine = (ISimulationEngine) element
							.createExecutableExtension("Class");

					// >>> 2. Set the simulation parameters
					try {

						simulationEngine
								.setSimulationParameters(simulationParameters);

						// Inform all simulation controllers about the new
						// engine instance
						fireEvent(new SimulationEvent(
								SimulationEvent.SimulationEventTypes.EngineCreated,
								simulationEngine));

						// Add the listener to the engine
						simulationEngine
								.addEventListener(getSimulationListener());

						// >>> 3. Initialize the simulation engine
						try {

							simulationEngine.initializeEngine();

							// Inform all simulation controllers about the
							// initialized engine
							fireEvent(new SimulationEvent(
									SimulationEventTypes.EngineInitialized,
									simulationEngine));

						} catch (SimulationException e) {

							// simulation engine could not be initialized
							disposeEngine(simulationEngine);

							fireEvent(new SimulationEvent(
									SimulationEventTypes.EngineDisposed,
									simulationEngine));

							showException(simulationEngine.getEngineName(), e);
							simulationEngine = null;
						}

					} catch (SimulationException e) {

						// Simulation parameters could not be set
						disposeEngine(simulationEngine);

						showException(simulationEngine.getEngineName(), e);
						simulationEngine = null;
					}

				} catch (CoreException e) {
					simulationEngine = null;
					showCoreException(e);
				}
			}
		}
	}

	/**
	 * Calls the dispose method of the given <code>ISimulationEngine</code>.
	 * 
	 * @param engine
	 *            defines the engine which shall be disposed
	 */
	private void disposeEngine(final ISimulationEngine engine) {

		if (engine != null) {

			try {
				engine.disposeEngine();
			} catch (SimulationException e) {
				showException(engine.getEngineName(), e);
			}
			fireEvent(new SimulationEvent(SimulationEventTypes.EngineDisposed, engine));
		}
	}

	/**
	 * Uses a <code>MessageDialog</code> to inform the user about the given
	 * simulation exception. Additionally, the exception stack trace will be
	 * printed to the default output.
	 * 
	 * @param source
	 *            defines the name of the object which is the source of the
	 *            exception
	 * @param exception
	 *            defines the occurred simulation exception
	 */
	private void showException(String source, final Exception exception) {

		exception.printStackTrace();

		if (source == null || source.equals("")) {
			source = "Yakindu Simulation";
		}

		final String sourceName = source;

		Display.getDefault().asyncExec(new Runnable() {

			public void run() {

				MessageDialog.openError(Display.getDefault().getActiveShell(),
						sourceName, exception.getMessage());
			}
		});
	}

	/**
	 * Uses a <code>MessageDialog</code> to inform the user about the given
	 * simulation warning.
	 * 
	 * @param source
	 *            defines the name of the object which is the source of the
	 *            exception
	 * @param exception
	 *            defines the occurred simulation warning
	 */
	private void showWarning(String source, final Exception exception) {

		if (source == null || source.equals("")) {
			source = "Yakindu Simulation";
		}

		final String sourceName = source;

		Display.getDefault().asyncExec(new Runnable() {

			public void run() {

				MessageDialog.openWarning(Display.getDefault().getActiveShell(),
						sourceName, exception.getMessage());
			}
		});
	}
	
	/**
	 * Uses a <code>MessageDialog</code> to inform the user about the given core
	 * exception of eclipse. Additionally, the exception stack trace will be
	 * printed to the default output.
	 * 
	 * @param exception
	 *            defines the occurred core exception
	 */
	private void showCoreException(final CoreException exception) {

		exception.printStackTrace();

		Display.getDefault().asyncExec(new Runnable() {

			public void run() {

				MessageDialog.openError(Display.getDefault().getActiveShell(),
						"Eclipse core error",
						"The following core exception of eclipse is occured:\n\n"
								+ exception.getMessage());
			}
		});
	}

	/**
	 * Defines a listener which check, if the
	 * <code>SimulationEventTypes.SimStop</code> event was fired.
	 * 
	 * @return The created listener.
	 */
	protected IEventListener getSimulationListener() {

		return new IEventListener() {

			public void receiveEvent(final IEvent event) {
				if (event instanceof SimulationEvent) {

					SimulationEvent simulationEvent = (SimulationEvent) event;
					ISimulationEngine engine = simulationEvent.getSource();

					if (simulationEvent.getEventType() == SimulationEventTypes.SimError) {
						showException(engine.getEngineName(), simulationEvent
								.getException());
					} else if (simulationEvent.getEventType() == SimulationEventTypes.SimWarn) {
						showWarning(engine.getEngineName(), simulationEvent
							.getException());
					}
				} else if (event instanceof ControllerEvent) {

					ControllerEvent controllerEvent = (ControllerEvent) event;
					final ISimulationController source = (ISimulationController) controllerEvent
							.getSource();

					switch (controllerEvent.getEventType()) {

					case ConWarn:
						showException(source.getControllerName(),
								controllerEvent.getException());
						break;
					case ConError:
						simulationEngine.removeEventListener(source);

						// To avoid dead locks a new runnable is executed
						Display.getDefault().asyncExec(new Runnable() {
							public void run() {
								simulationControllerList.remove(source);
							}
						});

						showException(source.getControllerName(),
								controllerEvent.getException());

						break;
					default:
						break;
					}
				}
			}
		};
	}

	/**
	 * Shows the simulation control window and will exit if the simulation is
	 * stopped and the window was closed.
	 */
	public void run() {

		if (simulationEngine != null) {

			while (!monitor.isCanceled()) {

				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			disposeEngine(simulationEngine);
		}
	}
}