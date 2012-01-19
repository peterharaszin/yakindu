package org.eclipselabs.damos.dconfig.validation;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.validation.CheckType;
import org.eclipselabs.damos.dconfig.ComputationProperty;
import org.eclipselabs.damos.dconfig.Configuration;
import org.eclipselabs.damos.dconfig.DconfigPackage;
import org.eclipselabs.damos.dconfig.Property;
import org.eclipselabs.damos.dconfig.PropertyContainer;
import org.eclipselabs.damos.dconfig.SelectionProperty;
import org.eclipselabs.damos.dconfig.SimpleProperty;
import org.eclipselabs.damos.dconfig.SystemConfigurationBody;
import org.eclipselabs.damos.mscript.DataType;
import org.eclipselabs.damos.mscript.interpreter.IStaticEvaluationContext;
import org.eclipselabs.damos.mscript.interpreter.StaticEvaluationContext;
import org.eclipselabs.damos.mscript.interpreter.StaticExpressionEvaluator;
import org.eclipselabs.damos.mscript.interpreter.value.IValue;
import org.eclipselabs.damos.mscript.interpreter.value.InvalidValue;
import org.eclipselabs.damos.mscript.util.SyntaxStatus;
 

public class DconfigJavaValidator extends AbstractDconfigJavaValidator {

	@Check
	public void checkExtendsItself(Configuration configuration) {
		if (configuration.getBaseConfiguration() == configuration) {
			error("Configuration " + configuration.getName() + " cannot extend itself", DconfigPackage.eINSTANCE.getConfiguration_BaseConfiguration());
		}
	}

	@Check(CheckType.NORMAL)
	public void checkExtendsCyclic(Configuration configuration) {
		Configuration c = configuration.getBaseConfiguration();
		while (c != null) {
			c = c.getBaseConfiguration();
			if (c == configuration) {
				error("Cycle detected in configuration hierarchy of configuration " + configuration.getName(), DconfigPackage.eINSTANCE.getConfiguration_BaseConfiguration());
				return;
			}
		}
	}
	
	@Check
	public void checkPropertyUniqueness(PropertyContainer propertyContainer) {
		Map<String, Property> identifiers = new HashMap<String, Property>();
		Set<String> duplicates = new HashSet<String>();
		for (Property property : propertyContainer.getProperties()) {
			Property existing = identifiers.put(property.getId(), property);
			if (existing != null) {
				if (duplicates.add(property.getId())) {
					propertyUniquenessError(existing);
				}
				propertyUniquenessError(property);
			}
		}
	}
	
	private void propertyUniquenessError(Property property) {
		EStructuralFeature feature = null;
		if (property instanceof SimpleProperty) {
			feature = DconfigPackage.eINSTANCE.getSimpleProperty_Declaration();
		} else if (property instanceof SelectionProperty) {
			feature = DconfigPackage.eINSTANCE.getSelectionProperty_Declaration();
		} else if (property instanceof ComputationProperty) {
			feature = DconfigPackage.eINSTANCE.getComputationProperty_ComputationModel();
		}
		error("Duplicate property " + property.getId(), property, feature, -1);
	}
	
	@Check
	public void checkDataType(SimpleProperty property) {
		if (property.getDeclaration() == null) {
			return;
		}
		
		if (property.getDeclaration().getTypeSpecifier() == null) {
			return;
		}
		
		DataType type = property.getDeclaration().getTypeSpecifier().getType();
		if (type == null) {
			return;
		}

		IStaticEvaluationContext context = new StaticEvaluationContext();
		IStatus status = new StaticExpressionEvaluator().evaluate(context, property.getValue());
		if (status.getSeverity() > IStatus.WARNING) {
			SyntaxStatus.addAllSyntaxStatusesToDiagnostics(status, getChain());
			return;
		}
		
		IValue value = context.getValue(property.getValue());
		if (value == null || value instanceof InvalidValue || value.getDataType() == null) {
			return;
		}
		
		if (!type.isAssignableFrom(value.getDataType())) {
			error("Property value of " + property.getId() + " has invalid data type", DconfigPackage.eINSTANCE.getSimpleProperty_Value());
		}
	}
	
	@Check
	public void checkPropagate(Property property) {
		if (property.isPropagate() && !(property.eContainer() instanceof SystemConfigurationBody)) {
			error("Propagate modifier can only be used on properties within system configurations", DconfigPackage.eINSTANCE.getProperty_Propagate());
		}
	}

}
