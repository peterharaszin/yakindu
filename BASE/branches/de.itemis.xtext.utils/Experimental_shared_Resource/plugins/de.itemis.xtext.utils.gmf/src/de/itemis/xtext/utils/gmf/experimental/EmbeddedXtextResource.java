package de.itemis.xtext.utils.gmf.experimental;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gmf.runtime.emf.core.resources.GMFResource;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.XtextFactory;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.linking.ILinker;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parser.IParser;
import org.eclipse.xtext.resource.XtextSyntaxDiagnostic;
import org.eclipse.xtext.resource.impl.ListBasedDiagnosticConsumer;

/**
 * Implementation of {@link Resource} that handles Xtext mixins.
 * 
 * @author andreas muelder
 * 
 */
public class EmbeddedXtextResource extends GMFResource {

	/**
	 * Marker Annotation for Objects that are refined with Xtext
	 */
	private static final String EMBEDDED_XTEXT = "EmbeddedXtext";

	private IParser parser;

	private ILinker linker;

	public EmbeddedXtextResource(URI uri) {
		super(uri);
	}

	@Override
	public void doLoad(InputStream inputStream, Map<?, ?> options)
			throws IOException {
		super.doLoad(inputStream, options);
		// Iterate over the loaded content and load all embedded Xtext parts.
		TreeIterator<EObject> iter = getAllContents();
		while (iter.hasNext()) {
			EObject currentObject = iter.next();
			EAnnotation eAnnotation = currentObject.eClass().getEAnnotation(
					EMBEDDED_XTEXT);
			if (eAnnotation != null) {
				AnnotationWrapper wrapper = new AnnotationWrapper(eAnnotation);
				loadEmbeddedXtextPart(currentObject, wrapper);
			}
		}
	}

	private void loadEmbeddedXtextPart(final EObject currentObject,
			final AnnotationWrapper wrapper) {

		currentObject.eAdapters().add(
				new ReparseAdapter(currentObject, wrapper));

		EObject rootAst = parse(currentObject, wrapper);
		if (rootAst != null) {
			String targetProperty = wrapper.getTargetProperty();
			EStructuralFeature feature = currentObject.eClass()
					.getEStructuralFeature(targetProperty);
			if (feature.isMany()) {
				throw new IllegalStateException(
						"0..* target features not supported");
			}
			currentObject.eUnset(feature);
			currentObject.eSet(feature, rootAst);
			doLinking(rootAst);
		}
	}

	private EObject parse(EObject object, AnnotationWrapper wrapper) {
		String expression = getExpression(object, wrapper);
		if (expression != null && expression.length() > 0) {
			ParserRule parserRule = XtextFactory.eINSTANCE.createParserRule();
			parserRule.setName(wrapper.getParserRule());
			IParseResult result = parser.parse(parserRule, new StringReader(
					expression));
			addSyntaxErrors(result);
			return result.getRootASTElement();
		}
		return null;
	}

	private void addSyntaxErrors(IParseResult result) {
		System.out.println("Syntax errors " + result.hasSyntaxErrors());
		for (INode error : result.getSyntaxErrors()) {
			System.out.println("Adding syntax error " + error.getText());
			getErrors().add(new XtextSyntaxDiagnostic(error));
		}
	}

	private String getExpression(EObject object, AnnotationWrapper wrapper) {
		EStructuralFeature expressionFeature = object.eClass()
				.getEStructuralFeature(wrapper.getSourceProperty());
		if (expressionFeature.getEType() != EcorePackage.Literals.ESTRING) {
			throw new IllegalStateException(
					"'SourceProperty' feature is not of type 'EString'!");
		}
		return (String) object.eGet(expressionFeature);
	}

	protected void doLinking(EObject rootAst) {
		final ListBasedDiagnosticConsumer consumer = new ListBasedDiagnosticConsumer();
		linker.linkModel(rootAst, consumer);
		System.out.println("Linker errors " + consumer.getResult(Severity.ERROR));
		System.out.println("Linker warnings " + consumer.getResult(Severity.WARNING));
		getErrors().addAll(consumer.getResult(Severity.ERROR));
		getWarnings().addAll(consumer.getResult(Severity.WARNING));
	}

	public void setParser(IParser parser) {
		this.parser = parser;
	}

	public void setLinker(ILinker linker) {
		this.linker = linker;

	}

	/**
	 * ReparseAdapter listens for PROPERTY_SOURCE changes and reloads the
	 * textual part
	 * 
	 * @author andreas muelder
	 * 
	 */
	private final class ReparseAdapter extends AdapterImpl {
		private final EStructuralFeature expressionFeature;
		private final EObject currentObject;
		private final AnnotationWrapper wrapper;

		private ReparseAdapter(EObject currentObject, AnnotationWrapper wrapper) {
			this.currentObject = currentObject;
			this.wrapper = wrapper;
			expressionFeature = currentObject.eClass().getEStructuralFeature(
					wrapper.getSourceProperty());
		}

		@Override
		public void notifyChanged(Notification msg) {
			if (msg.getFeature() == expressionFeature) {
				loadEmbeddedXtextPart(currentObject, wrapper);
			}
		}

	}

	/**
	 * Accessor to values stored in the {@link EAnnotation}s.
	 * 
	 * @author andreas muelder
	 * 
	 */
	private static final class AnnotationWrapper {

		private static final String SOURCE_PROPERTY = "SourceProperty";

		private static final String PARSER_RULE = "ParserRule";

		private static final String TARGET_PROPERTY = "TargetProperty";

		private final EAnnotation annotation;

		public AnnotationWrapper(EAnnotation annotation) {
			this.annotation = annotation;
		}

		public String getParserRule() {
			return annotation.getDetails().get(PARSER_RULE);
		}

		public String getSourceProperty() {
			return annotation.getDetails().get(SOURCE_PROPERTY);
		}

		public String getTargetProperty() {
			return annotation.getDetails().get(TARGET_PROPERTY);
		}
	}

}