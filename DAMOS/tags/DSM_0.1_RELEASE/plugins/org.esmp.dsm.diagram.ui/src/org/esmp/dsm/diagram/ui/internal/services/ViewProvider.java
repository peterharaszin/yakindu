/****************************************************************************
 * Copyright (c) 2008, 2009 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.esmp.dsm.diagram.ui.internal.services;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.core.providers.AbstractViewProvider;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.View;
import org.esmp.dsm.diagram.core.internal.type.IBlockElementType;
import org.esmp.dsm.diagram.ui.view.SemanticHints;
import org.esmp.dsm.diagram.ui.view.factories.BlockDiagramViewFactory;
import org.esmp.dsm.diagram.ui.view.factories.BlockNameViewFactory;
import org.esmp.dsm.diagram.ui.view.factories.BlockViewFactory;
import org.esmp.dsm.diagram.ui.view.factories.ConnectionViewFactory;
import org.esmp.dsm.diagram.ui.view.factories.PortViewFactory;
import org.esmp.dsm.semantic.blockdiagram.BlockDiagramPackage;
import org.esmp.dsm.semantic.blockdiagram.Input;
import org.esmp.dsm.semantic.blockdiagram.InputPort;
import org.esmp.dsm.semantic.blockdiagram.Output;
import org.esmp.dsm.semantic.blockdiagram.OutputPort;

public class ViewProvider extends AbstractViewProvider {

	protected Class<?> getDiagramViewClass(IAdaptable semanticAdapter, String diagramKind) {
		if (BlockDiagramPackage.Literals.BLOCK_DIAGRAM.isSuperTypeOf(getSemanticEClass(semanticAdapter))) {
			return BlockDiagramViewFactory.class;
		}
		return super.getDiagramViewClass(semanticAdapter, diagramKind);
	}
	
	protected Class<?> getNodeViewClass(IAdaptable semanticAdapter, View containerView, String semanticHint) {
		EClass eClass = getSemanticEClass(semanticAdapter);
		
		if (BlockDiagramPackage.eINSTANCE.getInputPort().isSuperTypeOf(eClass)) {
			EObject element = getSemanticElement(semanticAdapter);
			if (element instanceof InputPort) {
				Input input = ((InputPort) element).getInput();
				Class<?> clazz = ViewFactoryMappingService.getInstance().getInputClass(
						input.getSpecification().eResource().getURI(), input.getSpecification().getName());
				if (clazz != null) {
					return clazz;
				}
			}
			return PortViewFactory.class;
		}
		
		if (BlockDiagramPackage.eINSTANCE.getOutputPort().isSuperTypeOf(eClass)) {
			EObject element = getSemanticElement(semanticAdapter);
			if (element instanceof OutputPort) {
				Output output = ((OutputPort) element).getOutput();
				Class<?> clazz = ViewFactoryMappingService.getInstance().getOutputClass(
						output.getSpecification().eResource().getURI(), output.getSpecification().getName());
				if (clazz != null) {
					return clazz;
				}
			}
			return PortViewFactory.class;
		}

		if (BlockDiagramPackage.eINSTANCE.getBlock().isSuperTypeOf(eClass)) {
			if (SemanticHints.BLOCK_NAME.equals(semanticHint)) {
				return BlockNameViewFactory.class;
			}
			IElementType elementType = (IElementType) semanticAdapter.getAdapter(IElementType.class);
			if (elementType instanceof IBlockElementType) {
				URI uri = ((IBlockElementType) elementType).getBlockTypeURI();
				if (semanticHint != null && semanticHint.length() != 0) {
					Class<?> clazz = ViewFactoryMappingService.getInstance().getContentClass(uri, semanticHint);
					if (clazz != null) {
						return clazz;
					}
				} else {
					Class<?> clazz = ViewFactoryMappingService.getInstance().getClazz(uri);
					if (clazz != null) {
						return clazz;
					}
				}
			}
			return BlockViewFactory.class;
		}
		
		return null;
	}
	
	protected Class<?> getEdgeViewClass(IAdaptable semanticAdapter, View containerView, String semanticHint) {
		if (BlockDiagramPackage.Literals.CONNECTION.isSuperTypeOf(getSemanticEClass(semanticAdapter))) {
			return ConnectionViewFactory.class;
		}
		return super.getEdgeViewClass(semanticAdapter, containerView, semanticHint);
	}
	
}
