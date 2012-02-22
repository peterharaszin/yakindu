package org.eclipselabs.damos.dconfig.ui.syntaxcoloring;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightedPositionAcceptor;
import org.eclipselabs.damos.dconfig.ComponentReference;
import org.eclipselabs.damos.dconfig.BindingResourceReference;
import org.eclipselabs.damos.dconfig.ComponentConfiguration;
import org.eclipselabs.damos.dconfig.DconfigPackage;
import org.eclipselabs.damos.dconfig.FragmentConfiguration;
import org.eclipselabs.damos.dconfig.RootSystemConfiguration;
import org.eclipselabs.damos.dconfig.SelectionProperty;
import org.eclipselabs.damos.dconfig.SubsystemConfiguration;
import org.eclipselabs.damos.mscript.ui.syntaxcoloring.MscriptSemanticHighlightingCalculator;

/**
 * @author Andreas Unger
 *
 */
public class DconfigSemanticHighlightingCalculator extends MscriptSemanticHighlightingCalculator {

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.mscript.ui.syntaxcoloring.MscriptSemanticHighlightingCalculator#provideHighlightingFor(org.eclipse.emf.ecore.EObject, org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightedPositionAcceptor)
	 */
	@Override
	protected boolean provideHighlightingFor(EObject eObject, IHighlightedPositionAcceptor acceptor) {
		if (eObject instanceof SelectionProperty) {
			List<INode> nodes = NodeModelUtils.findNodesForFeature(eObject, DconfigPackage.eINSTANCE.getSelectionProperty_Declaration());
			for (INode node : nodes) {
				acceptor.addPosition(node.getOffset(), node.getLength(), DconfigHighlightingConfiguration.SELECTION_PROPERTY_ID);
			}
		} else if (eObject instanceof RootSystemConfiguration) {
			provideHighlightingForModelElement(eObject, DconfigPackage.eINSTANCE.getRootSystemConfiguration_ContextFragment(), acceptor);
		} else if (eObject instanceof SubsystemConfiguration) {
			provideHighlightingForModelElement(eObject, DconfigPackage.eINSTANCE.getSubsystemConfiguration_Subsystem(), acceptor);
		} else if (eObject instanceof FragmentConfiguration) {
			provideHighlightingForModelElement(eObject, DconfigPackage.eINSTANCE.getFragmentConfiguration_StartFragment(), acceptor);
			provideHighlightingForModelElement(eObject, DconfigPackage.eINSTANCE.getFragmentConfiguration_EndFragment(), acceptor);
		} else if (eObject instanceof ComponentConfiguration) {
			provideHighlightingForModelElement(eObject, DconfigPackage.eINSTANCE.getComponentConfiguration_Component(), acceptor);
		} else if (eObject instanceof ComponentReference) {
			provideHighlightingForModelElement(eObject, DconfigPackage.eINSTANCE.getComponentReference_Component(), acceptor);
		} else if (eObject instanceof BindingResourceReference) {
			List<INode> nodes = NodeModelUtils.findNodesForFeature(eObject, DconfigPackage.eINSTANCE.getBindingResourceReference_ResourceDeclaration());
			for (INode node : nodes) {
				acceptor.addPosition(node.getOffset(), node.getLength(), DconfigHighlightingConfiguration.RESOURCE_ID);
			}
		} else {
			return super.provideHighlightingFor(eObject, acceptor);
		}
		return true;
	}
	
	private void provideHighlightingForModelElement(EObject eObject, EStructuralFeature feature, IHighlightedPositionAcceptor acceptor) {
		List<INode> nodes = NodeModelUtils.findNodesForFeature(eObject, feature);
		for (INode node : nodes) {
			acceptor.addPosition(node.getOffset(), node.getLength(), DconfigHighlightingConfiguration.MODEL_ELEMENT_ID);
		}
	}

}
