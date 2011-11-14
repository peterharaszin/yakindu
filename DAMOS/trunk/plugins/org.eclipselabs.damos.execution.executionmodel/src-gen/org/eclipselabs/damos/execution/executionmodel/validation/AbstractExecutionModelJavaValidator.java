package org.eclipselabs.damos.execution.executionmodel.validation;
 
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EPackage;
import org.eclipselabs.damos.mscript.validation.MscriptJavaValidator;
import org.eclipse.xtext.validation.ComposedChecks;

@ComposedChecks(validators= {org.eclipse.xtext.validation.ImportUriValidator.class, org.eclipse.xtext.validation.NamesAreUniqueValidator.class})
public class AbstractExecutionModelJavaValidator extends MscriptJavaValidator {

	@Override
	protected List<EPackage> getEPackages() {
	    List<EPackage> result = new ArrayList<EPackage>();
	    result.add(EPackage.Registry.INSTANCE.getEPackage("http://www.eclipselabs.org/damos/2011/ExecutionModel"));
	    result.add(EPackage.Registry.INSTANCE.getEPackage("http://www.eclipselabs.org/damos/mscript/2011/Mscript"));
		return result;
	}

}
