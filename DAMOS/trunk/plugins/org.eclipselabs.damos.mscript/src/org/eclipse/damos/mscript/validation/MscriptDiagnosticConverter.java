package org.eclipse.damos.mscript.validation;

import org.eclipse.damos.mscript.MscriptPackage;
import org.eclipse.damos.mscript.StandardFunctionDeclaration;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.validation.DiagnosticConverterImpl;

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
