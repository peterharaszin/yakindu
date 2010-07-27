/**
 * Copyright (c) 2010 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package com.yakindu.statechart.codegenerator.java.test;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Set;

import com.yakindu.statechart.CompoundState;
import com.yakindu.statechart.Node;
import com.yakindu.statechart.Region;
import com.yakindu.statechart.State;
import com.yakindu.statechart.AbstractStatechart;

import junit.framework.TestCase;

public abstract class AbstractStatechartTest extends TestCase {

	public AbstractStatechartTest() {
		super();
	}

	public AbstractStatechartTest(String name) {
		super(name);
	}

	protected Region getNestedRegionById(AbstractStatechart statechart, String regionId)
			throws Exception {
				List<Region> nestedRegions = (List<Region>) getFieldValue(statechart,
						"regions");
				for (Region region : nestedRegions) {
					if (((String) getFieldValue(region, "id")).equals(regionId)) {
						return region;
					}
				}
				return null;
			}

	protected Region getNestedRegionById(CompoundState state, String regionId)
			throws Exception {
				List<Region> nestedRegions = (List<Region>) getFieldValue(state,
						"regions");
				for (Region region : nestedRegions) {
					if (((String) getFieldValue(region, "id")).equals(regionId)) {
						return region;
					}
				}
				return null;
			}

	protected State getStateById(Region region, String stateId) throws Exception {
		Set<Node> nodes = (Set<Node>) getFieldValue(region, "nodes");
		for (Node node : nodes) {
			if (node instanceof State
					&& ((String) getFieldValue(node, "id")).equals(stateId)) {
				return (State) node;
			}
		}
		return null;
	
	}

	protected Object getFieldValue(Object instance, String name) throws Exception {
		Class c = instance.getClass();
	
		Field field = null;
		while (field == null && c != null) {
			Field[] fields = c.getDeclaredFields();
			for (int i = 0; i < fields.length && field == null; i++) {
				if (fields[i].getName().equals(name)) {
					field = fields[i];
				}
			}
			c = c.getSuperclass();
	
		}
		if (field != null) {
			field.setAccessible(true);
			return field.get(instance);
		}
		throw new IllegalArgumentException("unknown field");
	}

}