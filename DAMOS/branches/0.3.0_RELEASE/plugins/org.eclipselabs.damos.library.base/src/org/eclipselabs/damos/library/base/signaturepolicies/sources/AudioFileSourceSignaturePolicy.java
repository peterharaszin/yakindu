/****************************************************************************
 * Copyright (c) 2008, 2010 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipselabs.damos.library.base.signaturepolicies.sources;

import java.util.Map;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipselabs.damos.dml.Block;
import org.eclipselabs.damos.dml.Component;
import org.eclipselabs.damos.dml.InputPort;
import org.eclipselabs.damos.dml.OutputPort;
import org.eclipselabs.damos.execution.datatype.AbstractComponentSignaturePolicy;
import org.eclipselabs.damos.execution.datatype.ComponentSignature;
import org.eclipselabs.damos.execution.datatype.ComponentSignatureEvaluationResult;
import org.eclipselabs.damos.execution.datatype.IComponentSignatureEvaluationResult;
import org.eclipselabs.damos.library.base.LibraryBasePlugin;
import org.eclipselabs.damos.library.base.util.audio.AudioFileUtil;
import org.eclipselabs.damos.mscript.DataType;
import org.eclipselabs.damos.mscript.util.TypeUtil;

/**
 * @author Andreas Unger
 *
 */
public class AudioFileSourceSignaturePolicy extends AbstractComponentSignaturePolicy {
	
	@Override
	public IComponentSignatureEvaluationResult evaluateSignature(Component component, Map<InputPort, DataType> incomingDataTypes) {
		Block block = (Block) component;
		
		MultiStatus status = new MultiStatus(LibraryBasePlugin.PLUGIN_ID, 0, "", null);
		
		IStatus fileURIStatus = AudioFileUtil.checkFileURI(block);
		if (!fileURIStatus.isOK()) {
			status.add(fileURIStatus);
		}
		
		ComponentSignature signature = new ComponentSignature(incomingDataTypes);
		for (OutputPort outputPort : component.getPrimaryOutputPorts()) {
			signature.getOutputDataTypes().put(outputPort, TypeUtil.createRealType());
		}
		return new ComponentSignatureEvaluationResult(signature, status);
	}

}
