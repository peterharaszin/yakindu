/**
 * 
 */
package com.yakindu.simulation.launch.test

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.junit.Test;
import com.yakindu.simulation.ui.launch.YakinduLaunchConfigurationDelegate;
import com.yakindu.simulation.launch.YakinduSimulationLauncher;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.mda4e.simulation.core.AbstractSimulationParameterSet;
import org.eclipse.core.runtime.spi.IRegistryProvider
import org.mda4e.simulation.controller.ISimulationController
import org.mda4e.simulation.core.ISimulationEngine
import com.yakindu.simulation.ui.launch.tabs.YakinduMainTab;

import groovy.mock.interceptor.MockFor
import groovy.mock.interceptor.StubFor

import static org.junit.Assert.*

/**
 * @author schwertfeger
 *
 */
public class YakinduLaunchConfigurationDelegateTest{
	@Test
	public void testLaunch() {
//		def run=false
		def baseParamSet = false
		def extParamSet = false
		def debugTargetSet = false;
	
		def controller = [addEventListener: {}] as ISimulationController
		def mockParamSet = [setEngineBaseParameters:{baseParamSet=true}, setEngineSpecificParameters:{extParamSet=true}] as AbstractSimulationParameterSet
		def confElement = [createExecutableExtension: {mockParamSet}, getAttribute : {null}] as IConfigurationElement
		def engineExtensionList = [getAttribute:{null},
		                           createExecutableExtension: {mockParamSet}, 
		                           getConfigurationElementsFor : {name-> "ParameterSet".equals(name)?mockParamSet:
		                           {def a=new IConfigurationElement[1] ; a[0]=confElement; return a}}] as IConfigurationElement
		def serviceConfElement  = [
		                           createExecutableExtension: {null}, 
		                           getAttribute : {}] as IConfigurationElement
		def reg = [ getConfigurationElementsFor : {name-> def a=new IConfigurationElement[1]; if (ISimulationEngine.ENGINE_EXTENSION_POINT.equals(name))
		                    	  a[0]=engineExtensionList; else a[0]=serviceConfElement; return a}] as IExtensionRegistry
		
		def provider = [getRegistry: {reg}] as IRegistryProvider
		org.eclipse.core.internal.registry.RegistryProviderFactory.releaseDefault()
		org.eclipse.core.internal.registry.RegistryProviderFactory.setDefault(provider)
//		def mockPlatform = new MockFor(org.eclipse.core.internal.runtime.InternalPlatform)
//		mockPlatform.demand.getRegistry(extRegistry)
//		mockPlatform.use {
	//Platform.metaClass.'static'.getExtensionRegistry = {extRegistry}
		def monitor = [getChildren:{}] as IProgressMonitor
		def config = [getAttribute: {name, pos->name.equals(YakinduMainTab.SELECTED_ENGINE)?0:"test"}] as ILaunchConfiguration
		def launch = [getChildren:{}, addDebugTarget: {debugTargetSet=true}] as ILaunch
//		def mockLaunch = new MockFor(YakinduSimulationLauncher)
//		mockLaunch.demand.run{ run=true }
//		mockLaunch.demand.createSimulationServices{[controller]}
//		mockLaunch.use {
				YakinduLaunchConfigurationDelegate instance =  new YakinduLaunchConfigurationDelegate();
				instance.launch(config, "run", launch, monitor)
//		}
//		}
//		assertTrue run
        assertTrue debugTargetSet
		assertTrue baseParamSet
		assertTrue extParamSet
	}
}
