package org.yakindu.sct.simulation.core.module;

import com.google.inject.AbstractModule;
import com.google.inject.Module;

public interface IModuleProvider {

	Module getModule();

	public class NullImpl implements IModuleProvider {

		public AbstractModule getModule() {
			return new AbstractModule() {
				@Override
				protected void configure() {
				}
			};
		}
	}
}
