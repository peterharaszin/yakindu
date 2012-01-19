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

import org.eclipselabs.damos.dconfig.ComponentConfiguration;
import org.eclipselabs.damos.dconfig.ComputationProperty;
import org.eclipselabs.damos.dconfig.Configuration;
import org.eclipselabs.damos.dconfig.FragmentConfiguration;
import org.eclipselabs.damos.dconfig.Property;
import org.eclipselabs.damos.dconfig.PropertyContainer;
import org.eclipselabs.damos.dconfig.RootSystemConfiguration;
import org.eclipselabs.damos.dconfig.SelectionProperty;
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
		Property property = getProperty(configuration, PROPERTY_ID_DELIMITER_PATTERN.split(propertyId));
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
		Property property = getProperty(configuration, PROPERTY_ID_DELIMITER_PATTERN.split(propertyId));
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
	
	public static ComputationModel getComputationModel(Configuration configuration, SystemPath path) {
		Property property = getProperty(configuration, path, COMPUTATION_PROPERTY_ID_SEGMENTS);
		if (property instanceof ComputationProperty) {
			return ((ComputationProperty) property).getComputationModel();
		}
		return null;
	}

	private static Property getProperty(Configuration configuration, String[] propertyIdentifierSegments) {
		Configuration c = configuration;
		while (c != null) {
			Property property = getProperty(c, propertyIdentifierSegments, 0);
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
					Property property = getProperty(componentConfiguration.getBody(), propertyIdentifierSegments, 0);
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
					Property property = getProperty(fragmentConfiguration.getBody(), propertyIdentifierSegments, 0);
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
			SystemConfiguration systemConfiguration = getSystemConfiguration(c, path);
			if (systemConfiguration != null && systemConfiguration.getBody() != null) {
				Property property = getProperty(systemConfiguration.getBody(), propertyIdentifierSegments, 0);
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

	private static SystemConfiguration getSystemConfiguration(Configuration configuration, SystemPath path) {
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

		while (pathIt.hasNext() && locked) {
			Subsystem pathSubsystem = pathIt.next();

			pathContextFragment = getRealizingFragment(pathSubsystem, pathContextFragment);
			if (pathContextFragment == null) {
				return null;
			}
			
			if (systemConfiguration.getBody() != null) {
				for (SubsystemConfiguration subsystemConfiguration : systemConfiguration.getBody().getSubsystemConfigurations()) {
					if (subsystemConfiguration.getSubsystem() == pathSubsystem) {
						contextFragment = getRealizingFragment(subsystemConfiguration.getSubsystem(),contextFragment);
						if (contextFragment == null) {
							return null;
						}
						break;
					}
				}
			}
			
			locked = DMLUtil.areFragmentsRelated(contextFragment, pathContextFragment);
		}

		if (!locked) {
			return null;
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
	
	private static Property getProperty(PropertyContainer propertyContainer, String[] propertyIdentifierSegments, int index) {
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
						propertyContainer = ((SelectionProperty) property).getBody();
						if (propertyContainer != null) {
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

}
