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
package com.yakindu.simulation.perspective;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IProjectNature;
import org.eclipse.core.runtime.CoreException;

public class YakinduNature implements IProjectNature {

	private IProject project;
	public static String ID="com.yakindu.simulation.perspective.nature";
	
	public void setProject(IProject project) {
		this.project = project;
	}

	public void configure() throws CoreException {
		// Add builder here 
	}

	public IProject getProject() {
		return project;
	}

	public static void addNature(IProject project){
		if (!project.isOpen()){
			return;
		}
		
		IProjectDescription projectDescription;
		try {
			projectDescription = project.getDescription();
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
		
		List<String> newIDs = new ArrayList<String>();
		newIDs.addAll(Arrays.asList(projectDescription.getNatureIds()));
		int index = newIDs.indexOf(YakinduNature.ID);
		if (index != -1)
			return;
		
		newIDs.add(YakinduNature.ID);
		projectDescription.setNatureIds(newIDs.toArray(new String[newIDs.size()]));
		
		try {
			project.setDescription(projectDescription, null);
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static boolean hasNature(IProject project){
		try {
			return project.isOpen() && project.hasNature(YakinduNature.ID);
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public void deconfigure() throws CoreException {
		// TODO Auto-generated method stub
		
	}

	public static void removeNature(IProject project){
		if (!project.isOpen())
			return;
		IProjectDescription projectDescription;
		try {
			projectDescription = project.getDescription();
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
		
		List<String> newIDs = new ArrayList<String>();
		newIDs.addAll(Arrays.asList(projectDescription.getNatureIds()));
		int index = newIDs.indexOf(YakinduNature.ID);
		if (index == -1)
			return;
		
		newIDs.remove(index);
		projectDescription.setNatureIds(newIDs.toArray(new String[newIDs.size()]));
		
		try {
			project.setDescription(projectDescription, null);
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
