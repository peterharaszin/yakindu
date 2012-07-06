package org.eclipselabs.damos.dmltext.validation;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

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
import org.eclipselabs.damos.dml.BlockType;
import org.eclipselabs.damos.dml.DMLPackage;
import org.eclipselabs.damos.dml.Fragment;
import org.eclipselabs.damos.dml.InoutputDefinition;
import org.eclipselabs.damos.dml.InputDefinition;
import org.eclipselabs.damos.dml.OutputDefinition;
import org.eclipselabs.damos.dml.Parameter;
import org.eclipselabs.damos.dml.TimingKind;
import org.eclipselabs.damos.dml.util.DMLUtil;
import org.eclipselabs.damos.dmltext.MscriptBlockType;
import org.eclipselabs.damos.mscript.Declaration;
import org.eclipselabs.damos.mscript.FunctionDeclaration;
import org.eclipselabs.damos.mscript.FunctionKind;
import org.eclipselabs.damos.mscript.MscriptPackage;
import org.eclipselabs.damos.mscript.StaticParameterDeclaration;

import com.google.inject.Inject;

public class DMLTextJavaValidator extends AbstractDMLTextJavaValidator {
	
	@Inject
	private ResourceDescriptionsProvider resourceDescriptionsProvider;
	
	@Inject
	private IContainer.Manager containerManager;
	
	@Inject
	private IQualifiedNameProvider qualifiedNameProvider;

	private static final Set<String> GLOBAL_STATIC_PARAMETERS = new HashSet<String>();
	
	static {
		GLOBAL_STATIC_PARAMETERS.add("Ts");
		GLOBAL_STATIC_PARAMETERS.add("fs");
	}
	
	/**
	 * 
	 */
	private static final String MAIN_FUNCTION_NAME = "main";
	
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
	public void checkMainFunction(MscriptBlockType blockType) {
		if (blockType.getDeclarations().isEmpty()) {
			return;
		}
		for (Declaration declaration : blockType.getDeclarations()) {
			if (declaration instanceof FunctionDeclaration) {
				FunctionDeclaration functionDeclaration = (FunctionDeclaration) declaration;
				if (MAIN_FUNCTION_NAME.equals(functionDeclaration.getName())) {
					return;
				}
			}
		}
		error("No main function declared", blockType, DMLPackage.eINSTANCE.getQualifiedElement_Name(), -1);
	}

	@Check
	public void checkMainFunctionParameters(FunctionDeclaration functionDeclaration) {
		if (!MAIN_FUNCTION_NAME.equals(functionDeclaration.getName())) {
			return;
		}
		
		BlockType blockType = DMLUtil.getOwner(functionDeclaration, BlockType.class);
		if (blockType == null) {
			return;
		}
		
		int inputParameterCount = computeInoutputParameterCount(blockType.getInputDefinitions());
		if (inputParameterCount != functionDeclaration.getInputParameterDeclarations().size()) {
			error("Expecting " + inputParameterCount + " input parameter" + (inputParameterCount > 1 ? "s" : ""), MscriptPackage.eINSTANCE.getDeclaration_Name());
		}

		int outputParameterCount = computeInoutputParameterCount(blockType.getOutputDefinitions());
		if (outputParameterCount != functionDeclaration.getOutputParameterDeclarations().size()) {
			error("Expecting " + outputParameterCount + " output parameter" + (outputParameterCount > 1 ? "s" : ""), MscriptPackage.eINSTANCE.getDeclaration_Name());
		}
		
		Map<String, Parameter> blockTypeParameters = getBlockTypeParameters(blockType);
		Set<String> staticParameterNames = new HashSet<String>();
		for (StaticParameterDeclaration staticParameterDeclaration : functionDeclaration.getStaticParameterDeclarations()) {
			String name = staticParameterDeclaration.getName();
			if (!blockTypeParameters.containsKey(name) && !GLOBAL_STATIC_PARAMETERS.contains(name)) {
				error("No block type parameter found for template parameter " + name, staticParameterDeclaration, null, -1);
			}
			staticParameterNames.add(name);
		}
		
		for (Entry<String, Parameter> entry : blockTypeParameters.entrySet()) {
			if (!staticParameterNames.contains(entry.getKey())) {
				warning("Unused parameter " + entry.getKey(), entry.getValue(), DMLPackage.eINSTANCE.getParameter_Name(), -1);
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
			}
			++count;
		}
		if (hasSockets) {
			++count;
		}
		return count;
	}
	
}
