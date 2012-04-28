/****************************************************************************
 * Copyright (c) 2008, 2012 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipselabs.damos.dconfig.internal.operations;

import java.util.Iterator;

import org.eclipselabs.damos.common.util.NumberedList;
import org.eclipselabs.damos.dconfig.Binding;
import org.eclipselabs.damos.dconfig.BindingResourceReference;
import org.eclipselabs.damos.dconfig.ComponentConfiguration;
import org.eclipselabs.damos.dconfig.ComponentReference;
import org.eclipselabs.damos.dconfig.ComputationProperty;
import org.eclipselabs.damos.dconfig.Configuration;
import org.eclipselabs.damos.dconfig.FragmentConfiguration;
import org.eclipselabs.damos.dconfig.Property;
import org.eclipselabs.damos.dconfig.PropertyContainer;
import org.eclipselabs.damos.dconfig.RootSystemConfiguration;
import org.eclipselabs.damos.dconfig.SelectionProperty;
import org.eclipselabs.damos.dconfig.SelectionPropertyBody;
import org.eclipselabs.damos.dconfig.SimpleProperty;
import org.eclipselabs.damos.dconfig.SubsystemConfiguration;
import org.eclipselabs.damos.dconfig.SystemConfiguration;
import org.eclipselabs.damos.dconfig.util.PropertyPath;
import org.eclipselabs.damos.dconfig.util.PropertyPath.Segment;
import org.eclipselabs.damos.dml.Component;
import org.eclipselabs.damos.dml.Fragment;
import org.eclipselabs.damos.dml.Subsystem;
import org.eclipselabs.damos.dml.SubsystemRealization;
import org.eclipselabs.damos.dml.util.DMLUtil;
import org.eclipselabs.damos.dml.util.SystemPath;
import org.eclipselabs.damos.mscript.Expression;
import org.eclipselabs.damos.mscript.computationmodel.ComputationModel;

/**
 * @author Andreas Unger
 *
 */
public class ConfigurationOperations {
	
	private static final PropertyPath COMPUTATION_PROPERTY_PATH = PropertyPath.create("computation");

	public static Fragment getContextFragment(Configuration configuration) {
		Configuration c = configuration;
		while (c != null) {
			RootSystemConfiguration rootSystemConfiguration = c.getRootSystemConfiguration();
			if (rootSystemConfiguration != null) {
				return rootSystemConfiguration.getContextFragment();
			}
			c = c.getBaseConfiguration();
			if (c == configuration) {
				// Break cycle
				return null;
			}
		}
		return null;
	}

	public static Expression getPropertyValue(Configuration configuration, PropertyPath propertyPath) {
		NumberedList<Property> properties = getConfigurationProperties(configuration, propertyPath);
		if (properties.isEmpty()) {
			return null;
		}
		Property property = properties.getFirst();
		if (property instanceof SimpleProperty) {
			return ((SimpleProperty) property).getValue();
		}
		return null;
	}

	public static Expression getPropertyValue(Configuration configuration, SystemPath systemPath, PropertyPath propertyPath) {
		NumberedList<Property> properties = getProperties(configuration, systemPath, propertyPath);
		if (properties.isEmpty()) {
			return null;
		}
		Property property = properties.getFirst();
		if (property instanceof SimpleProperty) {
			return ((SimpleProperty) property).getValue();
		}
		return null;
	}

	public static String getPropertySelectionName(Configuration configuration, PropertyPath propertyPath) {
		NumberedList<Property> properties = getConfigurationProperties(configuration, propertyPath);
		if (properties.isEmpty()) {
			return null;
		}
		Property property = properties.getFirst();
		if (property instanceof SelectionProperty) {
			return ((SelectionProperty) property).getSelection().getQualifiedName();
		}
		return null;
	}

	public static String getPropertySelectionName(Configuration configuration, SystemPath systemPath, PropertyPath propertyPath) {
		NumberedList<Property> properties = getProperties(configuration, systemPath, propertyPath);
		if (properties.isEmpty()) {
			return null;
		}
		Property property = properties.getFirst();
		if (property instanceof SelectionProperty) {
			return ((SelectionProperty) property).getSelection().getQualifiedName();
		}
		return null;
	}
	
	public static NumberedList<String> getPropertySelectionNames(Configuration configuration, PropertyPath propertyPath) {
		NumberedList<String> names = new NumberedList<String>();
		for (NumberedList.Entry<Property> entry : getConfigurationProperties(configuration, propertyPath.wildcard()).entries()) {
			if (entry.getValue() instanceof SelectionProperty) {
				names.put(entry.getNumber(), ((SelectionProperty) entry.getValue()).getSelection().getQualifiedName());
			}
		}
		return names;
	}

	public static NumberedList<String> getPropertySelectionNames(Configuration configuration, SystemPath systemPath, PropertyPath propertyPath) {
		NumberedList<String> names = new NumberedList<String>();
		for (NumberedList.Entry<Property> entry : getProperties(configuration, systemPath, propertyPath.wildcard()).entries()) {
			if (entry.getValue() instanceof SelectionProperty) {
				names.put(entry.getNumber(), ((SelectionProperty) entry.getValue()).getSelection().getQualifiedName());
			}
		}
		return names;
	}

	public static BindingResourceReference getBindingTarget(Configuration configuration, PropertyPath propertyPath, SystemPath sourcePath) {
		NumberedList<Property> properties = getConfigurationProperties(configuration, propertyPath);
		if (properties.isEmpty()) {
			return null;
		}
		Property property = properties.getFirst();
		if (property instanceof SelectionProperty) {
			Binding binding = getBinding(((SelectionProperty) property).getBody(), sourcePath);
			if (binding != null) {
				return binding.getTarget();
			}
		}
		return null;
	}

	public static ComputationModel getComputationModel(Configuration configuration, SystemPath systemPath) {
		NumberedList<Property> properties = getProperties(configuration, systemPath, COMPUTATION_PROPERTY_PATH);
		if (properties.isEmpty()) {
			return null;
		}
		Property property = properties.getFirst();
		if (property instanceof ComputationProperty) {
			return ((ComputationProperty) property).getComputationModel();
		}
		return null;
	}

	private static NumberedList<Property> getConfigurationProperties(Configuration configuration, PropertyPath propertyPath) {
		NumberedList<Property> properties = new NumberedList<Property>();
		collectConfigurationProperties(configuration, configuration, propertyPath, properties);
		return properties;
	}
	
	private static void collectConfigurationProperties(Configuration configuration, Configuration currentConfiguration, PropertyPath propertyPath, NumberedList<Property> properties) {
		Configuration baseConfiguration = currentConfiguration.getBaseConfiguration();
		// Break cycle
		if (baseConfiguration == configuration) {
			return;
		}

		if (baseConfiguration != null) {
			collectConfigurationProperties(configuration, baseConfiguration, propertyPath, properties);
		}
		
		properties.putAll(getAllProperties(currentConfiguration, propertyPath));
	}

	private static NumberedList<Property> getProperties(Configuration configuration, SystemPath path, PropertyPath propertyPath) {
		NumberedList<Property> properties = new NumberedList<Property>();
		
		collectSystemConfigurationProperties(configuration, configuration, path, propertyPath, properties);
		if (path.isComponentPath()) {
			collectFragmentConfigurationProperties(configuration, configuration, path, propertyPath, properties);
			collectComponentConfigurationProperties(configuration, configuration, path, propertyPath, properties);
		}
		
		return properties;
	}
	
	private static void collectComponentConfigurationProperties(Configuration configuration, Configuration currentConfiguration, SystemPath path, PropertyPath propertyPath, NumberedList<Property> properties) {
		Configuration baseConfiguration = currentConfiguration.getBaseConfiguration();
		// Break cycle
		if (baseConfiguration == configuration) {
			return;
		}

		if (baseConfiguration != null) {
			collectComponentConfigurationProperties(configuration, baseConfiguration, path, propertyPath, properties);
		}
		
		ComponentConfiguration componentConfiguration = getComponentConfiguration(currentConfiguration, path);
		if (componentConfiguration != null && componentConfiguration.getBody() != null) {
			properties.putAll(getAllProperties(componentConfiguration.getBody(), propertyPath));
		}
	}

	private static ComponentConfiguration getComponentConfiguration(Configuration configuration, SystemPath path) {
		SystemConfiguration systemConfiguration = getSystemConfiguration(configuration, path);
		if (systemConfiguration != null && systemConfiguration.getBody() != null) {
			for (ComponentConfiguration componentConfiguration : systemConfiguration.getBody().getComponentConfigurations()) {
				if (componentConfiguration.getComponent() == path.getComponent()) {
					return componentConfiguration;
				}
			}
		}
		return null;
	}

	private static void collectFragmentConfigurationProperties(Configuration configuration, Configuration currentConfiguration, SystemPath path, PropertyPath propertyPath, NumberedList<Property> properties) {
		Configuration baseConfiguration = currentConfiguration.getBaseConfiguration();
		// Break cycle
		if (baseConfiguration == configuration) {
			return;
		}

		if (baseConfiguration != null) {
			collectFragmentConfigurationProperties(configuration, baseConfiguration, path, propertyPath, properties);
		}
		
		FragmentConfiguration fragmentConfiguration = getFragmentConfiguration(currentConfiguration, path);
		if (fragmentConfiguration != null && fragmentConfiguration.getBody() != null) {
			properties.putAll(getAllProperties(fragmentConfiguration.getBody(), propertyPath));
		}
	}

	private static FragmentConfiguration getFragmentConfiguration(Configuration configuration, SystemPath path) {
		SystemConfiguration systemConfiguration = getSystemConfiguration(configuration, path);
		if (systemConfiguration != null && systemConfiguration.getBody() != null) {
			for (FragmentConfiguration fragmentConfiguration : systemConfiguration.getBody().getFragmentConfigurations()) {
				Fragment startFragment = fragmentConfiguration.getStartFragment();
				Fragment endFragment = fragmentConfiguration.getEndFragment();
				Fragment componentFragment = path.getComponent().getEnclosingFragment();
				
				if ((startFragment == null || DMLUtil.isSameOrChildFragment(startFragment, componentFragment))
						&& (endFragment == null || DMLUtil.isSameOrChildFragment(componentFragment, endFragment))) {
					return fragmentConfiguration;
				}
			}
		}
		return null;
	}

	private static void collectSystemConfigurationProperties(Configuration configuration, Configuration currentConfiguration, SystemPath path, PropertyPath propertyPath, NumberedList<Property> properties) {
		Configuration baseConfiguration = currentConfiguration.getBaseConfiguration();
		// Break cycle
		if (baseConfiguration == configuration) {
			return;
		}

		if (baseConfiguration != null) {
			collectSystemConfigurationProperties(configuration, baseConfiguration, path, propertyPath, properties);
		}
		
		properties.putAll(getSystemConfigurationProperties(currentConfiguration, path, propertyPath));
	}

	private static NumberedList<Property> getSystemConfigurationProperties(Configuration configuration, SystemPath path, PropertyPath propertyPath) {
		PropertiesSystemConfigurationVisitor visitor = new PropertiesSystemConfigurationVisitor(path, propertyPath);
		getSystemConfiguration(configuration, path, visitor);
		return visitor.getProperties();
	}

	private static SystemConfiguration getSystemConfiguration(Configuration configuration, SystemPath path) {
		return getSystemConfiguration(configuration, path, null);
	}
	
	private static SystemConfiguration getSystemConfiguration(Configuration configuration, SystemPath path, ISystemConfigurationVisitor visitor) {
		RootSystemConfiguration rootSystemConfiguration = configuration.getRootSystemConfiguration();
		if (rootSystemConfiguration == null) {
			return null;
		}
		
		Fragment contextFragment = rootSystemConfiguration.getContextFragment();
		Fragment pathContextFragment = path.getContextFragment();
		
		Iterator<Subsystem> pathIt = path.getSubsystems().iterator();

		boolean locked = false;

		while (!(locked = DMLUtil.areFragmentsRelated(contextFragment, pathContextFragment)) && pathIt.hasNext()) {
			pathContextFragment = getRealizingFragment(pathIt.next(), pathContextFragment);
			if (pathContextFragment == null) {
				return null;
			}
		}
		
		if (!locked) {
			return null;
		}
		
		SystemConfiguration systemConfiguration = rootSystemConfiguration;
		
		if (visitor != null) {
			visitor.visit(systemConfiguration, contextFragment, pathContextFragment, !pathIt.hasNext());
		}

		while (pathIt.hasNext()) {
			Subsystem pathSubsystem = pathIt.next();

			contextFragment = getRealizingFragment(pathSubsystem, contextFragment);
			if (contextFragment == null) {
				return null;
			}

			pathContextFragment = getRealizingFragment(pathSubsystem, pathContextFragment);
			if (pathContextFragment == null) {
				return null;
			}
			
			if (!DMLUtil.areFragmentsRelated(contextFragment, pathContextFragment)) {
				return null;
			}
			
			if (systemConfiguration != null) {
				boolean found = false;
				if (systemConfiguration.getBody() != null) {
					for (SubsystemConfiguration subsystemConfiguration : systemConfiguration.getBody().getSubsystemConfigurations()) {
						if (subsystemConfiguration.getSubsystem() == pathSubsystem) {
							systemConfiguration = subsystemConfiguration;
							found = true;
							break;
						}
					}
				}
				if (!found) {
					if (visitor == null) {
						return null;
					}
					systemConfiguration = null;
				}
			}
			
			if (visitor != null) {
				visitor.visit(systemConfiguration, contextFragment, pathContextFragment, !pathIt.hasNext());
			}
		}

		Component component = path.getComponent();
		if (component != null && !DMLUtil.isSameOrChildFragment(contextFragment, component.getEnclosingFragment())) {
			return null;
		}

		return systemConfiguration;
	}

	private static Fragment getRealizingFragment(Subsystem subsystem, Fragment contextFragment) {
		SubsystemRealization realization = subsystem.getRealization(contextFragment);
		if (realization == null) {
			return null;
		}
		return realization.getRealizingFragment();
	}
	
	private static NumberedList<Property> getAllProperties(PropertyContainer propertyContainer, PropertyPath propertyPath) {
		int index = 0;
		boolean found;
		do {
			found = false;
			Segment segment = propertyPath.getSegments().get(index);

			// Check if this is the last segment.
			if (propertyPath.getSegments().size() == index + 1) {
				NumberedList<Property> properties = new NumberedList<Property>();
				for (Property property : propertyContainer.getProperties()) {
					if (segment.getName().equals(property.getId())) {
						if (property instanceof SelectionProperty) {
							SelectionProperty selectionProperty = (SelectionProperty) property;
							if (propertyPath.isWildcard()) {
								properties.put(selectionProperty.getIndex(), property);
							} else if (selectionProperty.getIndex() == segment.getIndex()) {
								properties.put(selectionProperty.getIndex(), property);
								break;
							}
						} else if (segment.getIndex() == -1) {
							properties.put(segment.getIndex(), property);
							break;
						}
					}
				}
				return properties;
			}

			for (Property property : propertyContainer.getProperties()) {
				if (segment.getName().equals(property.getId())) {
					if (property instanceof SelectionProperty) {
						SelectionProperty selectionProperty = (SelectionProperty) property;
						if (selectionProperty.getIndex() == segment.getIndex()) {
							if (selectionProperty.getBody() != null) {
								propertyContainer = selectionProperty.getBody();
								++index;
								found = true;
								break;
							} else {
								return NumberedList.emptyList();
							}
						}
					} else {
						return NumberedList.emptyList();
					}
				}
			}
		} while (found);
		
		return NumberedList.emptyList();
	}

	private static Binding getBinding(SelectionPropertyBody selectionPropertyBody, SystemPath sourcePath) {
		if (!sourcePath.isComponentPath()) {
			return null;
		}
		
		for (Binding binding : selectionPropertyBody.getBindings()) {
			if (binding.getSource() == null) {
				continue;
			}
			
			Iterator<ComponentReference> it = binding.getSource().getReferences().iterator();
			
			boolean equals = true;
			for (Subsystem subsystem : sourcePath.getSubsystems()) {
				if (!it.hasNext()) {
					break;
				}
				if (it.next().getComponent() != subsystem) {
					equals = false;
					break;
				}
			}
			
			if (equals && it.hasNext() && it.next().getComponent() == sourcePath.getComponent()) {
				return binding;
			}
		}
		
		return null;
	}
	
	private static interface ISystemConfigurationVisitor {
		
		void visit(SystemConfiguration systemConfiguration, Fragment contextFragment, Fragment pathContextFragment, boolean last);
		
	}
	
	private static class PropertiesSystemConfigurationVisitor implements ISystemConfigurationVisitor {

		private SystemPath systemPath;
		private PropertyPath propertyPath;
		private NumberedList<Property> properties = new NumberedList<Property>();
		
		/**
		 * @param systemPath
		 * @param propertyPath
		 */
		public PropertiesSystemConfigurationVisitor(SystemPath systemPath, PropertyPath propertyPath) {
			this.systemPath = systemPath;
			this.propertyPath = propertyPath;
		}
		
		/**
		 * @return the properties
		 */
		public NumberedList<Property> getProperties() {
			return properties;
		}

		/* (non-Javadoc)
		 * @see org.eclipselabs.damos.dconfig.internal.operations.ConfigurationOperations.ISystemConfigurationVisitor#visit(org.eclipselabs.damos.dconfig.SystemConfiguration, org.eclipselabs.damos.dml.Fragment, org.eclipselabs.damos.dml.Fragment)
		 */
		public void visit(SystemConfiguration systemConfiguration, Fragment contextFragment,
				Fragment pathContextFragment, boolean last) {
			if (systemConfiguration != null && systemConfiguration.getBody() != null) {
				NumberedList<Property> properties = getAllProperties(systemConfiguration.getBody(), propertyPath);
				for (NumberedList.Entry<Property> entry : properties.entries()) {
					if (last || entry.getValue().isPropagate()) {
						this.properties.put(entry.getNumber(), entry.getValue());
					}
				}
			}
			if (last && !properties.isEmpty()) {
				Component component = systemPath.getComponent();
				if (component != null && !DMLUtil.isSameOrChildFragment(contextFragment, component.getEnclosingFragment())) {
					properties.clear();
				}
			}
		}
		
	}

}
