/****************************************************************************
 * Copyright (c) 2008, 2012 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipselabs.damos.ide.ui.internal.quickfix;

import java.util.Map;
import java.util.regex.Pattern;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.RunnableWithResult;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.swt.graphics.Image;
import org.eclipselabs.damos.dml.Component;
import org.eclipselabs.damos.dml.util.DMLUtil;
import org.eclipselabs.damos.ide.core.validation.Problem;
import org.eclipselabs.damos.ide.ui.IDEUIPlugin;
import org.eclipselabs.damos.ide.ui.internal.util.ProblemUtil;
import org.eclipselabs.damos.ide.ui.quickfix.AbstractQuickFix;

/**
 * @author Andreas Unger
 *
 */
public class ComponentNameQuickFix extends AbstractQuickFix implements IStatefulQuickFix {

	private static final Pattern INVALID_CHARACTER_PATTERN = Pattern.compile("\\W+|__+");
	
	private String label;
	private String newName;
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.ide.ui.quickfix.IQuickFix#getDescription()
	 */
	public String getDescription() {
		return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.ide.ui.quickfix.IQuickFix#getImage()
	 */
	public Image getImage() {
		return IDEUIPlugin.getDefault().getImageRegistry().get(IDEUIPlugin.IMAGE_CORRECTION_RENAME);
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.ide.ui.quickfix.IQuickFix#getLabel()
	 */
	public String getLabel() {
		return label;
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.ide.ui.internal.quickfix.IStatefulQuickFix#initialize(org.eclipselabs.damos.ide.core.validation.Problem, org.eclipse.emf.transaction.TransactionalEditingDomain)
	 */
	public boolean initialize(final Problem problem, final TransactionalEditingDomain editingDomain) {
		RunnableWithResult.Impl<Boolean> runnable = new RunnableWithResult.Impl<Boolean>() {
			
			public void run() {
				setResult(doInitialize(problem, editingDomain));
			}
			
		};

		try {
			editingDomain.runExclusive(runnable);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			return false;
		}
		
		return runnable.getResult();
	}

	private boolean doInitialize(Problem problem, TransactionalEditingDomain editingDomain) {
		Component component = getComponent(problem, editingDomain);
		if (component == null) {
			return false;
		}
		
		String name = INVALID_CHARACTER_PATTERN.matcher(component.getName()).replaceAll("_");
		StringBuilder sb = new StringBuilder();
		
		boolean upper = true;
		for (int i = 0; i < name.length(); ++i) {
			char c = name.charAt(i);
			if (c == '_') {
				upper = true;
			} else {
				sb.append(upper ? Character.toUpperCase(c) : c);
				upper = false;
			}
		}
		
		name = sb.toString();
		newName = name;
		
		Map<String, Component> components = DMLUtil.getComponentMap(component.getEnclosingFragment(), Component.class);
		int i = 2;
		while (components.containsKey(newName)) {
			newName = name + i++;
		}
		
		label = "Rename to " + newName;
		
		return true;
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.ide.ui.quickfix.AbstractQuickFix#run(org.eclipselabs.damos.ide.core.validation.Problem, org.eclipse.emf.transaction.TransactionalEditingDomain)
	 */
	@Override
	protected void run(final Problem problem, final TransactionalEditingDomain editingDomain) {
		editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain, "Change Name") {
			
			@Override
			protected void doExecute() {
				Component component = getComponent(problem, editingDomain);
				if (component != null) {
					component.setName(newName);
				}
			}
			
		});
	}

	/**
	 * @param problem
	 * @param editingDomain
	 * @return
	 */
	private Component getComponent(Problem problem, TransactionalEditingDomain editingDomain) {
		URI uri = ProblemUtil.getPlatformResourceElementURI(problem);
		if (uri == null) {
			return null;
		}
		
		EObject eObject = editingDomain.getResourceSet().getEObject(uri, true);
		if (eObject instanceof Component) {
			return (Component) eObject;
		}
		
		return null;
	}

}
