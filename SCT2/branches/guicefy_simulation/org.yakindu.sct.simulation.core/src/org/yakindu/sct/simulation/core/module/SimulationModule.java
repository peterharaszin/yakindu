package org.yakindu.sct.simulation.core.module;

import org.yakindu.sct.simulation.core.runtime.DefaultExecutionContainerFactory;
import org.yakindu.sct.simulation.core.runtime.IExecutionContainerFactory;
import org.yakindu.sct.simulation.core.sruntime.RuntimeContext;
import org.yakindu.sct.simulation.core.sruntime.impl.RuntimeContextImpl;

import com.google.inject.AbstractModule;

public class SimulationModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(RuntimeContext.class).to(RuntimeContextImpl.class).asEagerSingleton();
		bind(IExecutionContainerFactory.class).to(DefaultExecutionContainerFactory.class);
	}

}
