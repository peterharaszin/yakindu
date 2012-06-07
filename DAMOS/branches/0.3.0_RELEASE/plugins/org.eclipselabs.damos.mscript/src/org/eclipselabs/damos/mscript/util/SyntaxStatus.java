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

package org.eclipselabs.damos.mscript.util;

import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipselabs.damos.mscript.internal.MscriptPlugin;

/**
 * @author Andreas Unger
 *
 */
public class SyntaxStatus extends Status implements ISyntaxStatus {

	private EObject syntaxElement;
	
	private EStructuralFeature syntaxFeature;
	
	public SyntaxStatus(int severity, String pluginId, int code, String message, EObject syntaxElement) {
		this(severity, pluginId, code, message, syntaxElement, null);
	}
	
	public SyntaxStatus(int severity, String pluginId, int code, String message, EObject syntaxElement, EStructuralFeature syntaxFeature) {
		super(severity, pluginId, code, message, null);
		this.syntaxElement = syntaxElement;
		this.syntaxFeature = syntaxFeature;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.util.ILanguageStatus#getSyntaxElement()
	 */
	public EObject getSyntaxElement() {
		return syntaxElement;
	}
	
	public EStructuralFeature getSyntaxFeature() {
		return syntaxFeature;
	}

	public static void addAllSyntaxStatusesToDiagnostics(IStatus status, DiagnosticChain diagnostics) {
		if (diagnostics != null) {
			for (StatusTreeIterator it = new StatusTreeIterator(status, true); it.hasNext();) {
				IStatus next = it.next();
				if (next instanceof ISyntaxStatus) {
					ISyntaxStatus syntaxStatus = (ISyntaxStatus) next;
					Object[] data;
					if (syntaxStatus.getSyntaxFeature() != null) {
						data = new Object[] {
							syntaxStatus.getSyntaxElement(),
							syntaxStatus.getSyntaxFeature()
						};
					} else {
						data = new Object[] {
							syntaxStatus.getSyntaxElement()
						};
					}
					diagnostics.add(new BasicDiagnostic(
							status.getSeverity(),
							MscriptPlugin.PLUGIN_ID,
							0,
							syntaxStatus.getMessage(),
							data));
				}
			}
		}
	}
	
	public static IStatus toStatus(Diagnostic diagnostic) {
		MultiStatus multiStatus = new MultiStatus(MscriptPlugin.PLUGIN_ID, 0, "", null);
		for (Diagnostic child : diagnostic.getChildren()) {
			List<?> data = child.getData();
			if (data != null && !data.isEmpty() && data.get(0) instanceof EObject) {
				EObject syntaxElement = (EObject) data.get(0);
				
				EStructuralFeature syntaxFeature = null;
				if (data.size() > 1 && data.get(1) instanceof EStructuralFeature) {
					syntaxFeature = (EStructuralFeature) data.get(1);
				}
				
				multiStatus.add(new SyntaxStatus(diagnostic.getSeverity(), MscriptPlugin.PLUGIN_ID, 0, child.getMessage(), syntaxElement, syntaxFeature));
			}
		}
		return multiStatus;
	}

}
