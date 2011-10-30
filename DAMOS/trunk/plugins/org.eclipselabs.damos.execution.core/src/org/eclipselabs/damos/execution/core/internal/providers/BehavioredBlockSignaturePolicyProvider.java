package org.eclipselabs.damos.execution.core.internal.providers;

import org.eclipselabs.damos.dml.Block;
import org.eclipselabs.damos.dml.Component;
import org.eclipselabs.damos.dmltext.MscriptBehaviorSpecification;
import org.eclipselabs.damos.execution.core.IComponentSignaturePolicy;
import org.eclipselabs.damos.execution.core.IComponentSignaturePolicyProvider;
import org.eclipselabs.damos.execution.core.internal.signaturepolicies.BehavioredBlockSignaturePolicy;

public class BehavioredBlockSignaturePolicyProvider implements IComponentSignaturePolicyProvider {

	public IComponentSignaturePolicy createPolicy(Component component) {
		if (component instanceof Block) {
			Block block = (Block) component;
			if (block.getType().getBehavior() instanceof MscriptBehaviorSpecification) {
				return new BehavioredBlockSignaturePolicy();
			}
		}
		return null;
	}

}
