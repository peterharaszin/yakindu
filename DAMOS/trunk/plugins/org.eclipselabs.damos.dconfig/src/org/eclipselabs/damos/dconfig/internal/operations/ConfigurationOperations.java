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
import java.util.regex.Pattern;

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
	
	private static final Pattern PROPERTY_ID_DELIMITER_PATTERN = Pattern.compile("/");
	
	private static final String[] COMPUTATION_PROPERTY_ID_SEGMENTS = { "computation" };

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

	public static Expression getPropertyValue(Configuration configuration, String propertyId) {
		Property property = getConfigurationProperty(configuration, PROPERTY_ID_DELIMITER_PATTERN.split(propertyId));
		if (property instanceof SimpleProperty) {
			return ((SimpleProperty) property).getValue();
		}
		return null;
	}

	public static Expression getPropertyValue(Configuration configuration, SystemPath path, String propertyId) {
		Property property = getProperty(configuration, path, PROPERTY_ID_DELIMITER_PATTERN.split(propertyId));
		if (property instanceof SimpleProperty) {
			return ((SimpleProperty) property).getValue();
		}
		return null;
	}

	public static String getPropertySelectionName(Configuration configuration, String propertyId) {
		Property property = getConfigurationProperty(configuration, PROPERTY_ID_DELIMITER_PATTERN.split(propertyId));
		if (property instanceof SelectionProperty) {
			return ((SelectionProperty) property).getSelection().getQualifiedName();
		}
		return null;
	}

	public static String getPropertySelectionName(Configuration configuration, SystemPath path, String propertyId) {
		Property property = getProperty(configuration, path, PROPERTY_ID_DELIMITER_PATTERN.split(propertyId));
		if (property instanceof SelectionProperty) {
			return ((SelectionProperty) property).getSelection().getQualifiedName();
		}
		return null;
	}
	
	public static BindingResourceReference getBindingTarget(Configuration configuration, String propertyId, SystemPath sourcePath) {
		Property property = getConfigurationProperty(configuration, PROPERTY_ID_DELIMITER_PATTERN.split(propertyId));
		if (property instanceof SelectionProperty) {
			Binding binding = getBinding(((SelectionProperty) property).getBody(), sourcePath);
			if (binding != null) {
				return binding.getTarget();
			}
		}
		return null;
	}

	public static ComputationModel getComputationModel(Configuration configuration, SystemPath path) {
		Property property = getProperty(configuration, path, COMPUTATION_PROPERTY_ID_SEGMENTS);
		if (property instanceof ComputationProperty) {
			return ((ComputationProperty) property).getComputationModel();
		}
		return null;
	}

	private static Property getConfigurationProperty(Configuration configuration, String[] propertyIdentifierSegments) {
		Configuration c = configuration;
		while (c != null) {
			Property property = getProperty(c, propertyIdentifierSegments);
			if (property != null) {
				return property;
			}
			c = c.getBaseConfiguration();
			if (c == configuration) {
				// Break cycle
				return null;
			}
		}
		return null;
	}
	
	private static Property getProperty(Configuration configuration, SystemPath path, String[] propertyIdentifierSegments) {
		Configuration c;
		
		if (path.isComponentPath()) {
			c = configuration;
			while (c != null) {
				ComponentConfiguration componentConfiguration = getComponentConfiguration(c, path);
				if (componentConfiguration != null && componentConfiguration.getBody() != null) {
					Property property = getProperty(componentConfiguration.getBody(), propertyIdentifierSegments);
					if (property != null) {
						return property;
					}
				}
				c = c.getBaseConfiguration();
				if (c == configuration) {
					// Break cycle
					return null;
				}
			}

			c = configuration;
			while (c != null) {
				FragmentConfiguration fragmentConfiguration = getFragmentConfiguration(c, path);
				if (fragmentConfiguration != null && fragmentConfiguration.getBody() != null) {
					Property property = getProperty(fragmentConfiguration.getBody(), propertyIdentifierSegments);
					if (property != null) {
						return property;
					}
				}
				c = c.getBaseConfiguration();
				if (c == configuration) {
					// Break cycle
					return null;
				}
			}
		}
		
		c = configuration;
		while (c != null) {
			Property property = getSystemConfigurationProperty(c, path, propertyIdentifierSegments);
			if (property != null) {
				return property;
			}
			c = c.getBaseConfiguration();
			if (c == configuration) {
				// Break cycle
				return null;
			}
		}
		
		return null;
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

	private static Property getSystemConfigurationProperty(Configuration configuration, SystemPath path, String[] propertyIdentifierSegments) {
		PropertiesSystemConfigurationVisitor visitor = new PropertiesSystemConfigurationVisitor(path, propertyIdentifierSegments);
		getSystemConfiguration(configuration, path, visitor);
		return visitor.property;
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
	
	private static Property getProperty(PropertyContainer propertyContainer, String[] propertyIdentifierSegments) {
		int index = 0;
		boolean found;
		do {
			found = false;
			for (Property property : propertyContainer.getProperties()) {
				if (propertyIdentifierSegments[index].equals(property.getId())) {
					// Check if this is the last segment.
					if (propertyIdentifierSegments.length == index + 1) {
						return property;
					}
					if (property instanceof SelectionProperty) {
						SelectionProperty selectionProperty = (SelectionProperty) property;
						if (selectionProperty.getBody() != null) {
							propertyContainer = selectionProperty.getBody();
							++index;
							found = true;
							break;
						}
					}
					// There are more segments, but we have no child properties left.
					return null;
				}
			}
		} while (found);
		return null;
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
		private String[] propertyIdentifierSegments;
		private Property property;
		
		/**
		 * @param systemPath
		 * @param propertyIdentifierSegments
		 */
		public PropertiesSystemConfigurationVisitor(SystemPath systemPath, String[] propertyIdentifierSegments) {
			this.systemPath = systemPath;
			this.propertyIdentifierSegments = propertyIdentifierSegments;
		}

		/* (non-Javadoc)
		 * @see org.eclipselabs.damos.dconfig.internal.operations.ConfigurationOperations.ISystemConfigurationVisitor#visit(org.eclipselabs.damos.dconfig.SystemConfiguration, org.eclipselabs.damos.dml.Fragment, org.eclipselabs.damos.dml.Fragment)
		 */
		public void visit(SystemConfiguration systemConfiguration, Fragment contextFragment,
				Fragment pathContextFragment, boolean last) {
			if (systemConfiguration != null && systemConfiguration.getBody() != null) {
				Property property = getProperty(systemConfiguration.getBody(), propertyIdentifierSegments);
				if (property != null && (last || property.isPropagate())) {
					this.property = property;
				}
			}
			if (last && this.property != null) {
				Component component = systemPath.getComponent();
				if (component != null && !DMLUtil.isSameOrChildFragment(contextFragment, component.getEnclosingFragment())) {
					this.property = null;
				}
			}
		}
		
	}

}
