package org.eclipselabs.damos.execution.internal.providers;

import org.eclipselabs.damos.dml.Block;
import org.eclipselabs.damos.dml.Component;
import org.eclipselabs.damos.dscript.DscriptBlockType;
import org.eclipselabs.damos.execution.datatype.IComponentSignaturePolicy;
import org.eclipselabs.damos.execution.datatype.IComponentSignaturePolicyProvider;
import org.eclipselabs.damos.execution.internal.signaturepolicies.DscriptBlockSignaturePolicy;

public class DscriptBlockSignaturePolicyProvider implements IComponentSignaturePolicyProvider {

	public IComponentSignaturePolicy createPolicy(Component component) {
		if (component instanceof Block) {
			Block block = (Block) component;
			if (block.getType() instanceof DscriptBlockType) {
				DscriptBlockType blockType = (DscriptBlockType) block.getType();
				if (blockType.getBehavior() != null) {
					return new DscriptBlockSignaturePolicy();
				}
			}
		}
		return null;
	}

}
