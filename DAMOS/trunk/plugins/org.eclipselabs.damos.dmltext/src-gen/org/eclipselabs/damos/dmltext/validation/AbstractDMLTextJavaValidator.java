package org.eclipselabs.damos.dmltext.validation;
 
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EPackage;
import org.eclipselabs.mscript.language.validation.MscriptJavaValidator;
import org.eclipse.xtext.validation.ComposedChecks;

@ComposedChecks(validators= {org.eclipse.xtext.validation.ImportUriValidator.class, org.eclipse.xtext.validation.NamesAreUniqueValidator.class})
public class AbstractDMLTextJavaValidator extends MscriptJavaValidator {

	@Override
	protected List<EPackage> getEPackages() {
	    List<EPackage> result = new ArrayList<EPackage>();
	    result.add(EPackage.Registry.INSTANCE.getEPackage("http://www.eclipselabs.org/damos/DML/1.0.0"));
	    result.add(EPackage.Registry.INSTANCE.getEPackage("http://www.eclipselabs.org/damos/DMLText/1.0.0"));
	    result.add(EPackage.Registry.INSTANCE.getEPackage("http://www.eclipselabs.org/mscript/AST/1.0.0"));
	    result.add(EPackage.Registry.INSTANCE.getEPackage("http://www.eclipselabs.org/mscript/TypeSystem/1.0.0"));
		return result;
	}

}
