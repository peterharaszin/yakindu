/**
 * 
 */
package com.yakindu.simulation.launch.test

import org.junit.Test;
import org.junit.Before;
import com.yakindu.simulation.launch.YakinduSimulationLauncherimport org.mda4e.simulation.core.ISimulationParameterSet;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.core.runtime.spi.IRegistryProvider
import org.mda4e.simulation.controller.ISimulationController
import org.eclipse.core.runtime.IConfigurationElement;
import org.mda4e.simulation.core.AbstractSimulationParameterSet;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.NullProgressMonitor
import org.mda4e.simulation.core.ISimulationEngine
import org.mda4e.simulation.core.event.SimulationEvent
import org.mda4e.simulation.core.event.SimulationEvent.SimulationEventTypes
import static org.junit.Assert.*
import com.yakindu.simulation.launch.debug.DebugTarget
/**
 * @author schwertfeger
 *
 */
public class YakinduSimulationLauncherTest{
	
	private static engines
	private static services
	def simulationLauncher
	def monitor
	def state
	def states
	def simulationParameterSet
	
	private static final fail = new GroovyTestCase().&fail
	private static final shouldFail = new GroovyTestCase().&shouldFail

	@Before
	public void setup(){
		engines = new IConfigurationElement[0]
//		engines[0]=createEngineParameters()
		services = new IConfigurationElement[0]
//		services[0] = createServiceParameters()
		
		org.eclipse.core.internal.registry.RegistryProviderFactory.releaseDefault()
		def reg = [ getConfigurationElementsFor : {name-> 
			if (ISimulationEngine.ENGINE_EXTENSION_POINT.equals(name)) return engines; 
			else if (ISimulationController.CONTROLLER_EXTENSION_POINT.equals(name)) return services}] as IExtensionRegistry
		def provider = [getRegistry: {reg}] as IRegistryProvider
		org.eclipse.core.internal.registry.RegistryProviderFactory.setDefault(provider)
		simulationParameterSet = [toString: {"emptySet"}] as ISimulationParameterSet
		def target = new DebugTarget(null, null);
		monitor = new NullProgressMonitor();
		simulationLauncher = new YakinduSimulationLauncher(target, simulationParameterSet, 0, monitor)
		
	}
	
	private IConfigurationElement createEngineParameters(){
		
		def simController = [addEventListener:{null}, receiveEvent:{null} ] as ISimulationController
		def simEngine = [setSimulationParameters: {null}, 
		                 addEventListener: {null}, 
		                 initializeEngine: {null},
		                 getEngineName: {"TestEngine"}] as ISimulationEngine
		def engineParameter = [
			createExecutableExtension: {name -> if ("EngineControls".equals(name)) return simController else if ("Class".equals(name)) return simEngine},
			getAttribute: {"TestMachine"}
			] as IConfigurationElement
		return engineParameter
	}		
	private IConfigurationElement createServiceParameters(){
		def simController = [addEventListener: {null}, receiveEvent:{null}] as ISimulationController
		def serviceConfElement  = [
		                           createExecutableExtension: {simController}, 
		                           getAttribute : {}] as IConfigurationElement
		return serviceConfElement
	}
	
	@Test
	public void constructor(){
		engines = new IConfigurationElement[1]
		services = new IConfigurationElement[1]
		state = 0
		states = [ "CreateServiceExecutablesClass", 
		           "addServiceEventListener", 
		           "CreateExecutablesClass", 
		           "setSimulationParameters", 
		           //"fireEngineCreated", 
		           "engineAddEventListener", 
		           "initEngine", 
		           //"fireEngineInit", 
		           ]
		def simController = [addEventListener:{}, 
		    receiveEvent:{event -> 
		    	if (event.getEventType()==SimulationEvent.SimulationEventTypes.EngineCreated)check("fireEngineCreated",null)
		    	else if (event.getEventType()==SimulationEvent.SimulationEventTypes.EngineInitialized) check("fireEngineInit",null)
		    }] as ISimulationController
		def simEngine = [setSimulationParameters: {check("setSimulationParameters","SimulationParameters set at wrong position")}, 
		                 addEventListener: {check("engineAddEventListener",null)}, 
		                 initializeEngine: {check("initEngine","Engine initialized at wrong position")},
		                 ] as ISimulationEngine
		def engineParameter = [
			createExecutableExtension: {name -> 
				if ("EngineControls".equals(name)) return simController 
				else if ("Class".equals(name)) 
					return check("CreateExecutablesClass","Engine requested in wrong direction")?simEngine:null},
			getAttribute: {"TestMachine"}
			] as IConfigurationElement
		def service = [addEventListener: {check("addServiceEventListener",null)},
			receiveEvent: {}] as ISimulationController
		def serviceParameter = [
		    createExecutableExtension: {name -> 
		    	if ("Class".equals(name)) 
		    		return check("CreateServiceExecutablesClass","Service creation requested but not expected")?service:null},
		    ] as IConfigurationElement 
		engines[0]=engineParameter
		services[0]=serviceParameter
		def target = new DebugTarget(null, null);
		simulationLauncher = new YakinduSimulationLauncher(target, simulationParameterSet, 0, monitor)
		assertEquals states.size(), state
	}

	private boolean check(String description, String failure){
		if (states[state].equals(description)) {state++; return true} 
		else if (failure != null) {
			fail failure+" (Active state: "+state+")"
			return false;
		}
		
	}
	
	@Test
	public void run(){
		simulationLauncher.run()
	}
}
