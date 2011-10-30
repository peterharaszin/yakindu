/****************************************************************************
 * Copyright (c) 2008, 2011 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipselabs.damos.dmltext.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipselabs.damos.dmltext.DMLTextFactory;
import org.eclipselabs.damos.dmltext.MscriptValueSpecification;
import org.eclipselabs.damos.dmltext.internal.util.TextAdapter;
import org.eclipselabs.damos.mscript.BooleanLiteral;
import org.eclipselabs.damos.mscript.IntegerLiteral;
import org.eclipselabs.damos.mscript.MscriptFactory;
import org.eclipselabs.damos.mscript.RealLiteral;
import org.eclipselabs.damos.mscript.Unit;
import org.eclipselabs.damos.mscript.util.TypeUtil;

/**
 * @author Andreas Unger
 *
 */
public class DMLTextUtil {

	public static MscriptValueSpecification createValueSpecification(double value) {
		return createValueSpecification(value, TypeUtil.createUnit());
	}
	
	public static MscriptValueSpecification createValueSpecification(double value, Unit unit) {
		MscriptValueSpecification valueSpecification = DMLTextFactory.eINSTANCE.createMscriptValueSpecification();
		RealLiteral realLiteral = MscriptFactory.eINSTANCE.createRealLiteral();
		realLiteral.setValue(value);
		realLiteral.setUnit(unit);
		valueSpecification.setExpression(realLiteral);
		DMLTextUtil.setText(valueSpecification, Double.toString(value));
		return valueSpecification;
	}
	
	public static MscriptValueSpecification createValueSpecification(long value) {
		return createValueSpecification(value, TypeUtil.createUnit());
	}
	
	public static MscriptValueSpecification createValueSpecification(long value, Unit unit) {
		MscriptValueSpecification valueSpecification = DMLTextFactory.eINSTANCE.createMscriptValueSpecification();
		IntegerLiteral integerLiteral = MscriptFactory.eINSTANCE.createIntegerLiteral();
		integerLiteral.setValue(value);
		integerLiteral.setUnit(unit);
		valueSpecification.setExpression(integerLiteral);
		DMLTextUtil.setText(valueSpecification, Long.toString(value));
		return valueSpecification;
	}

	public static MscriptValueSpecification createValueSpecification(boolean value) {
		MscriptValueSpecification valueSpecification = DMLTextFactory.eINSTANCE.createMscriptValueSpecification();
		BooleanLiteral booleanLiteral = MscriptFactory.eINSTANCE.createBooleanLiteral();
		booleanLiteral.setTrue(value);
		valueSpecification.setExpression(booleanLiteral);
		DMLTextUtil.setText(valueSpecification, Boolean.toString(value));
		return valueSpecification;
	}

	public static String getText(EObject eObject) {
		TextAdapter adapter = (TextAdapter) EcoreUtil.getAdapter(eObject.eAdapters(), TextAdapter.class);
		if (adapter != null) {
			return adapter.getText();
		}
		INode node = NodeModelUtils.findActualNodeFor(eObject);
		if (node != null) {
			return node.getText().trim();
		}
		return null;
	}

	public static void setText(EObject eObject, String text) {
		TextAdapter adapter = (TextAdapter) EcoreUtil.getAdapter(eObject.eAdapters(), TextAdapter.class);
		if (adapter != null) {
			adapter.setText(text);
		} else {
			eObject.eAdapters().add(new TextAdapter(text));
		}
	}

}
