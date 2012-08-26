package org.eclipselabs.damos.dconfig.validation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.validation.CheckType;
import org.eclipselabs.damos.dconfig.Binding;
import org.eclipselabs.damos.dconfig.BindingResourceSubscript;
import org.eclipselabs.damos.dconfig.ComponentReference;
import org.eclipselabs.damos.dconfig.ComputationProperty;
import org.eclipselabs.damos.dconfig.Configuration;
import org.eclipselabs.damos.dconfig.DconfigPackage;
import org.eclipselabs.damos.dconfig.Property;
import org.eclipselabs.damos.dconfig.PropertyContainer;
import org.eclipselabs.damos.dconfig.SelectionProperty;
import org.eclipselabs.damos.dconfig.SelectionPropertyBody;
import org.eclipselabs.damos.dconfig.SimpleProperty;
import org.eclipselabs.damos.dconfig.SystemConfiguration;
import org.eclipselabs.damos.dconfig.SystemConfigurationBody;
import org.eclipselabs.damos.dml.Component;
import org.eclipselabs.damos.dml.util.DMLUtil;
import org.eclipselabs.damos.mscript.IntegerType;
import org.eclipselabs.damos.mscript.Type;
import org.eclipselabs.damos.mscript.computation.ComputationPackage;
import org.eclipselabs.damos.mscript.computation.FixedPointFormat;
import org.eclipselabs.damos.mscript.computation.FloatingPointFormat;
import org.eclipselabs.damos.mscript.computation.NumberFormat;
import org.eclipselabs.damos.mscript.computation.NumberFormatMapping;
import org.eclipselabs.damos.mscript.interpreter.ExpressionEvaluator;
import org.eclipselabs.damos.mscript.interpreter.IStaticEvaluationResult;
import org.eclipselabs.damos.mscript.interpreter.StaticEvaluationResult;
import org.eclipselabs.damos.mscript.interpreter.StaticExpressionEvaluationContext;
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
			if (property instanceof SelectionProperty) {
				continue;
			}
			String id = property.getId();
			if (id != null) {
				Property existing = identifiers.put(id, property);
				if (existing != null) {
					if (duplicates.add(id)) {
						propertyUniquenessError(existing);
					}
					propertyUniquenessError(property);
				}
			}
		}
	}
	
	@Check
	public void checkSelectionProperties(PropertyContainer propertyContainer) {
		Set<List<Object>> declarations = new HashSet<List<Object>>();
		for (Property property : propertyContainer.getProperties()) {
			if (!(property instanceof SelectionProperty)) {
				continue;
			}
			
			SelectionProperty selectionProperty = (SelectionProperty) property;
			
			if (DMLUtil.isResolved(selectionProperty.getDeclaration())) {
				int count = selectionProperty.getDeclaration().getCount();
				int index = selectionProperty.getIndex();
				
				if (index >= 0) {
					if (count == 1) {
						error("Subscript must not be specified", selectionProperty, DconfigPackage.eINSTANCE.getSelectionProperty_Declaration(), -1);
					} else if (count > 0 && index >= count) {
						error("Maximum " + count + " selectable elements exceeded", selectionProperty, DconfigPackage.eINSTANCE.getSelectionProperty_Declaration(), -1);
					}
				} else if (count != 1) {
					error("Missing property subscript", selectionProperty, DconfigPackage.eINSTANCE.getSelectionProperty_Declaration(), -1);
				}
				
				List<Object> declaration = new ArrayList<Object>(2);
				declaration.add(selectionProperty.getDeclaration());
				if (index >= 0) {
					declaration.add(index);
				}
				if (!declarations.add(declaration)) {
					error("Duplicate property", selectionProperty, DconfigPackage.eINSTANCE.getSelectionProperty_Declaration(), -1);
				}
			}
		}
	}

	private void propertyUniquenessError(Property property) {
		EStructuralFeature feature = null;
		if (property instanceof SimpleProperty) {
			feature = DconfigPackage.eINSTANCE.getSimpleProperty_Declaration();
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
		
		Type type = property.getDeclaration().getTypeSpecifier().getType();
		if (type == null) {
			return;
		}

		IStaticEvaluationResult result = new StaticEvaluationResult();
		IValue value = new ExpressionEvaluator().evaluate(new StaticExpressionEvaluationContext(result), property.getValue());
		if (result.getStatus().getSeverity() > IStatus.WARNING) {
			SyntaxStatus.addAllSyntaxStatusesToDiagnostics(result.getStatus(), getChain());
			return;
		}
		
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
	
	@Check
	public void checkIntegerNumberFormat(NumberFormatMapping numberFormatMapping) {
		if (numberFormatMapping.getTypeSpecifier().getType() instanceof IntegerType) {
			NumberFormat numberFormat = numberFormatMapping.getNumberFormat();
			if (numberFormat instanceof FloatingPointFormat) {
				warning("Floating point format specified for integers", ComputationPackage.eINSTANCE.getNumberFormatMapping_NumberFormat(), -1);
			} else if (numberFormat instanceof FixedPointFormat) {
				FixedPointFormat fixedPointFormat = (FixedPointFormat) numberFormat;
				if (fixedPointFormat.getFractionLength() != 0) {
					warning("Fixed point format with fractional part specified for integers", ComputationPackage.eINSTANCE.getNumberFormatMapping_NumberFormat(), -1);
				}
				if (fixedPointFormat.getSlope() < 1) {
					warning("Fixed point format with slope less than 1 specified for integers", ComputationPackage.eINSTANCE.getNumberFormatMapping_NumberFormat(), -1);
				}
			}
		}
	}

	@Check
	public void checkFloatingPointFormat(FloatingPointFormat floatingPointFormat) {
		switch (floatingPointFormat.getKind()) {
		case BINARY32:
		case BINARY64:
			break;
		default:
			error("Floating point format must be binary32 or binary64", ComputationPackage.eINSTANCE.getFloatingPointFormat_Kind(), -1);
			break;
		}
	}

	@Check
	public void checkFixedPointFormat(FixedPointFormat fixedPointFormat) {
		if (fixedPointFormat.getIntegerLength() < 1) {
			error("Integer length must be greater than or equal to 1", ComputationPackage.eINSTANCE.getFixedPointFormat_IntegerLength(), -1);
		} else {
			switch (fixedPointFormat.getWordSize()) {
			case 8:
			case 16:
			case 32:
			case 64:
				break;
			default:
				error("Word size must be 8, 16, 32, or 64 bit", null);
				break;
			}
		}
	}
	
	@Check
	public void checkFixedPointFormatSlope(FixedPointFormat fixedPointFormat) {
		if (fixedPointFormat.getSlope() <= 0) {
			error("Slope must be greater than 0", ComputationPackage.eINSTANCE.getFixedPointFormat_Slope(), -1);
		}
	}
	
	@Check
	public void checkBindingComponentReference(Binding binding) {
		if (DMLUtil.isResolved(binding.getSource()) && DMLUtil.isResolved(binding.getSource().getComponent()) && !binding.getSource().getComponent().isBoundary()) {
			EList<ComponentReference> references = binding.getSource().getReferences();
			error("Bound component must be boundary component", references.get(references.size() - 1), DconfigPackage.eINSTANCE.getComponentReference_Component(), -1);
		}
	}

	@Check
	public void checkBindingInGlobalSelectionProperty(Binding binding) {
		if (DMLUtil.getOwner(binding, SystemConfiguration.class) != null) {
			error("Bindings must not be located within system configurations", null);
		}
	}
	
	@Check
	public void checkBindings(SelectionPropertyBody selectionPropertyBody) {
		Set<List<Component>> sources = new HashSet<List<Component>>();
		Set<List<Object>> targets = new HashSet<List<Object>>();
		for (Binding binding : selectionPropertyBody.getBindings()) {
			if (DMLUtil.isResolved(binding.getSource().getComponent())) {
				EList<ComponentReference> references = binding.getSource().getReferences();
				List<Component> source = new ArrayList<Component>(references.size());
				for (ComponentReference reference : references) {
					source.add(reference.getComponent());
				}
				if (!sources.add(source)) {
					error("Duplicate binding", binding.getSource(), null, -1);
				}
			}

			if (DMLUtil.isResolved(binding.getTarget().getResourceDeclaration())) {
				int resourceCount = binding.getTarget().getResourceDeclaration().getCount();
				int resourceIndex = 0;
				
				BindingResourceSubscript subscript = binding.getTarget().getSubscript();
				
				if (subscript != null) {
					if (resourceCount == 1) {
						error("Subscript must not be specified", binding.getTarget(), null, -1);
					} else {
						resourceIndex = subscript.getIndex();
						if (resourceIndex < 0) {
							error("Binding subscript must not be negative", binding.getTarget(), null, -1);
						} else if (resourceIndex >= resourceCount) {
							error("Maximum " + resourceCount + " available resources exceeded", binding.getTarget(), null, -1);
						}
					}
				} else if (resourceCount > 1) {
					error("Missing binding subscript", binding.getTarget(), null, -1);
				}
				
				List<Object> target = new ArrayList<Object>(2);
				target.add(binding.getTarget().getResourceDeclaration());
				target.add(resourceIndex);
				if (!targets.add(target)) {
					error("Duplicate binding", binding.getTarget(), null, -1);
				}
			}
		}
	}

}
