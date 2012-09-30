package org.eclipselabs.damos.mscript.validation;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.validation.DiagnosticConverterImpl;
import org.eclipselabs.damos.mscript.MscriptPackage;
import org.eclipselabs.damos.mscript.StandardFunctionDeclaration;

/**
 * @author Andreas Unger
 *
 */
public class MscriptDiagnosticConverter extends DiagnosticConverterImpl {

	/* (non-Javadoc)
	 * @see org.eclipse.xtext.validation.DiagnosticConverterImpl#getLocationData(org.eclipse.emf.ecore.EObject, org.eclipse.emf.ecore.EStructuralFeature, int)
	 */
	@Override
	protected IssueLocation getLocationData(EObject obj, EStructuralFeature structuralFeature, int index) {
		if (obj instanceof StandardFunctionDeclaration && structuralFeature == null) {
			return super.getLocationData(obj, MscriptPackage.eINSTANCE.getStandardFunctionDeclaration_Name(), index);
		}
		return super.getLocationData(obj, structuralFeature, index);
	}
	
}
