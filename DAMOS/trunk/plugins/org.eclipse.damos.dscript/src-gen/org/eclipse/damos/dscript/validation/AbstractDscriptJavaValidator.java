package org.eclipse.damos.dscript.validation;
 
import java.util.ArrayList;
import java.util.List;

import org.eclipse.damos.mscript.validation.MscriptJavaValidator;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.validation.ComposedChecks;

@ComposedChecks(validators= {org.eclipse.xtext.validation.ImportUriValidator.class})
public class AbstractDscriptJavaValidator extends MscriptJavaValidator {

	@Override
	protected List<EPackage> getEPackages() {
	    List<EPackage> result = new ArrayList<EPackage>();
	    result.add(EPackage.Registry.INSTANCE.getEPackage("http://www.eclipse.org/damos/2011/Dscript"));
	    result.add(EPackage.Registry.INSTANCE.getEPackage("http://www.eclipse.org/damos/2011/DML"));
	    result.add(EPackage.Registry.INSTANCE.getEPackage("http://www.eclipse.org/damos/mscript/2011/Mscript"));
		return result;
	}

}
