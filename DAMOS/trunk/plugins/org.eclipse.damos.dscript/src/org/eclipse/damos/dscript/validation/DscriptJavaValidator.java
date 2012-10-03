package org.eclipse.damos.dscript.validation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.damos.dml.BlockType;
import org.eclipse.damos.dml.DMLPackage;
import org.eclipse.damos.dml.Fragment;
import org.eclipse.damos.dml.InoutputDefinition;
import org.eclipse.damos.dml.InputDefinition;
import org.eclipse.damos.dml.OutputDefinition;
import org.eclipse.damos.dml.Parameter;
import org.eclipse.damos.dml.TimingKind;
import org.eclipse.damos.dml.util.DMLUtil;
import org.eclipse.damos.dscript.validation.AbstractDscriptJavaValidator;
import org.eclipse.damos.mscript.FunctionDeclaration;
import org.eclipse.damos.mscript.FunctionKind;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IContainer;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsProvider;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.validation.CheckType;

import com.google.inject.Inject;

public class DscriptJavaValidator extends AbstractDscriptJavaValidator {
	
	@Inject
	private ResourceDescriptionsProvider resourceDescriptionsProvider;
	
	@Inject
	private IContainer.Manager containerManager;
	
	@Inject
	private IQualifiedNameProvider qualifiedNameProvider;

	@Override
	protected boolean isResponsible(Map<Object, Object> context, EObject eObject) {
		if (eObject instanceof Fragment) {
			return true;
		}
		return super.isResponsible(context, eObject);
	}
	
	// TODO: This has to be reworked
	@Check(CheckType.NORMAL)
	public void checkUniqueFragment(Fragment fragment) {
		QualifiedName qualifiedName = qualifiedNameProvider.getFullyQualifiedName(fragment);
		if (qualifiedName != null) {
			IResourceDescriptions resourceDescriptions = resourceDescriptionsProvider.getResourceDescriptions(fragment.eResource());
			IResourceDescription resourceDescription = resourceDescriptions.getResourceDescription(fragment.eResource().getURI());
			for (IContainer container : containerManager.getVisibleContainers(resourceDescription, resourceDescriptions)) {
				for (IEObjectDescription eObjectDescription : container.getExportedObjectsByType(DMLPackage.eINSTANCE.getFragment())) {
					if (!eObjectDescription.getEObjectURI().equals(EcoreUtil.getURI(fragment)) && qualifiedName.equals(eObjectDescription.getQualifiedName())) {
						error("Duplicate fragment " + qualifiedName, null);
					}
				}
			}
		}
	}

	@Check
	public void checkContinuousFunctionDeclarationInContinuousBlockType(FunctionDeclaration functionDeclaration) {
		if (functionDeclaration.getKind() == FunctionKind.CONTINUOUS) {
			BlockType blockType = DMLUtil.getOwner(functionDeclaration, BlockType.class);
			if (blockType != null && blockType.getTiming() != TimingKind.CONTINUOUS) {
				error("Block types containing continuous function declarations must itself be declared continuous", blockType, DMLPackage.eINSTANCE.getQualifiedElement_Name(), -1);
			}
		}
	}

	protected Map<String, Parameter> getBlockTypeParameters(BlockType blockType) {
		Map<String, Parameter> parameters = new HashMap<String, Parameter>();
		for (Parameter parameter : blockType.getParameters()) {
			parameters.put(parameter.getName(), parameter);
		}
		for (InputDefinition inputDefinition : blockType.getInputDefinitions()) {
			for (Parameter parameter : inputDefinition.getParameters()) {
				parameters.put(parameter.getName(), parameter);
			}
		}
		for (OutputDefinition outputDefinition : blockType.getOutputDefinitions()) {
			for (Parameter parameter : outputDefinition.getParameters()) {
				parameters.put(parameter.getName(), parameter);
			}
		}
		return parameters;
	}

	protected int computeInoutputParameterCount(List<? extends InoutputDefinition> inoutputDefinitions) {
		int count = 0;
		boolean hasSockets = false;
		for (InoutputDefinition inoutputDefinition : inoutputDefinitions) {
			if (inoutputDefinition.isSocket()) {
				hasSockets = true;
			} else {
				++count;
			}
		}
		if (hasSockets) {
			++count;
		}
		return count;
	}
	
}
