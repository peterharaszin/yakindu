package org.eclipselabs.damos.ide.core.internal.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipselabs.damos.dml.DMLPackage;
import org.eclipselabs.damos.dml.SynchronousTimingConstraint;
import org.eclipselabs.damos.dml.util.IElementInitializer;
import org.eclipselabs.damos.dmltext.DMLTextFactory;
import org.eclipselabs.damos.dmltext.MscriptValueSpecification;
import org.eclipselabs.damos.dmltext.util.DMLTextUtil;
import org.eclipselabs.damos.mscript.IntegerLiteral;
import org.eclipselabs.damos.mscript.MscriptFactory;
import org.eclipselabs.damos.mscript.util.TypeUtil;

public class ElementInitializer implements IElementInitializer {

	public boolean initialize(EObject element, EStructuralFeature feature, Object hint) {
		if (element instanceof SynchronousTimingConstraint
				&& feature == DMLPackage.eINSTANCE.getSynchronousTimingConstraint_SampleTime()) {
			SynchronousTimingConstraint stc = (SynchronousTimingConstraint) element;
			MscriptValueSpecification value = DMLTextFactory.eINSTANCE.createMscriptValueSpecification();
			IntegerLiteral integerLiteral = MscriptFactory.eINSTANCE.createIntegerLiteral();
			integerLiteral.setValue(1);
			integerLiteral.setUnit(TypeUtil.createUnit("s"));
			value.setExpression(integerLiteral);
			DMLTextUtil.setText(value, "1");
			stc.setSampleTime(value);
			return true;
		}
		return false;
	}

}
