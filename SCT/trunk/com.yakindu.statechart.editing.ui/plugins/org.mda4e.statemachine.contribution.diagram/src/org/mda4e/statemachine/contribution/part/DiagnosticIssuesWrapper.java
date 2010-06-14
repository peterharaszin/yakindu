/**
 * Copyright (c) 2006-2009 committers of mda4e and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of mda4e (http://www.mda4e.org/) - initial API and implementation
 *
 */
package org.mda4e.statemachine.contribution.part;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.mwe.core.issues.MWEDiagnostic;

public class DiagnosticIssuesWrapper extends BasicDiagnostic {

	public DiagnosticIssuesWrapper(org.eclipse.emf.mwe.core.issues.Issues issues) {
		MWEDiagnostic[] errors = issues.getErrors();
		MWEDiagnostic[] warnings = issues.getWarnings();
		for (int i = 0; i < errors.length; i++) {
			add(new BasicDiagnostic(Diagnostic.ERROR, "User check", 0, errors[i]
					.getMessage(),
					new Object[] { errors[i].getElement(), null }));
		}
		for (int i = 0; i < warnings.length; i++) {
			add(new BasicDiagnostic(Diagnostic.WARNING, "User check", 0, warnings[i]
					.getMessage(),
					new Object[] { warnings[i].getElement(), null }));
		}
	}
}
