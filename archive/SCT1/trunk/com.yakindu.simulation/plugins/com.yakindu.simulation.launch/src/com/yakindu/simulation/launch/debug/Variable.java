/**
 * Copyright (c) 2010 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package com.yakindu.simulation.launch.debug;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.core.model.IValue;
import org.eclipse.debug.core.model.IVariable;

public class Variable implements IVariable {

    public String getName() throws DebugException {
        // TODO Auto-generated method stub
        return null;
    }

    public String getReferenceTypeName() throws DebugException {
        // TODO Auto-generated method stub
        return null;
    }

    public IValue getValue() throws DebugException {
        // TODO Auto-generated method stub
        return null;
    }

    public boolean hasValueChanged() throws DebugException {
        // TODO Auto-generated method stub
        return false;
    }

    public IDebugTarget getDebugTarget() {
        // TODO Auto-generated method stub
        return null;
    }

    public ILaunch getLaunch() {
        // TODO Auto-generated method stub
        return null;
    }

    public String getModelIdentifier() {
        // TODO Auto-generated method stub
        return null;
    }

    public Object getAdapter(final Class adapter) {
        // TODO Auto-generated method stub
        return null;
    }

    public void setValue(final String expression) throws DebugException {
        // TODO Auto-generated method stub

    }

    public void setValue(final IValue value) throws DebugException {
        // TODO Auto-generated method stub

    }

    public boolean supportsValueModification() {
        // TODO Auto-generated method stub
        return false;
    }

    public boolean verifyValue(final String expression) throws DebugException {
        // TODO Auto-generated method stub
        return false;
    }

    public boolean verifyValue(final IValue value) throws DebugException {
        // TODO Auto-generated method stub
        return false;
    }

}
