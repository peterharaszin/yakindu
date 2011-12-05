/**
 * Copyright (c) 2011 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.runtime.java.test_parallelregions;

public interface DefaultInterface {

	public enum Events {
		Event1, Event2, Event3, Event4, Event5, Event6,
	}

	public void raiseEvent1();
	public void raiseEvent2();
	public void raiseEvent3();
	public void raiseEvent4();
	public void raiseEvent5();
	public void raiseEvent6();

}
