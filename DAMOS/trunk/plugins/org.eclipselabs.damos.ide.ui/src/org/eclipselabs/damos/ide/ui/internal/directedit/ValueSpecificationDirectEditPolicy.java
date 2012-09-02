package org.eclipselabs.damos.ide.ui.internal.directedit;

import java.io.StringReader;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.requests.DirectEditRequest;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipselabs.damos.diagram.ui.editparts.ITextualContentEditPart;
import org.eclipselabs.damos.dscript.parser.antlr.ValueSpecificationParser;

import com.google.inject.Inject;

public class ValueSpecificationDirectEditPolicy extends org.eclipse.gef.editpolicies.DirectEditPolicy {

	@Inject
	private ValueSpecificationParser parser;

	/* (non-Javadoc)
	 * @see org.eclipse.gef.editpolicies.DirectEditPolicy#getDirectEditCommand(org.eclipse.gef.requests.DirectEditRequest)
	 */
	@Override
	protected Command getDirectEditCommand(DirectEditRequest request) {
		String value = (String) request.getCellEditor().getValue();
		IParseResult result = parser.parse(new StringReader((String) value));
		if (result.hasSyntaxErrors()) {
			return UnexecutableCommand.INSTANCE;
		}
		SetRequest setRequest = new SetRequest(getHost().getEditingDomain(), getHost().getContentElement(), getHost()
				.getContentFeature(), result.getRootASTElement());
		SetValueCommand setValueCommand = new SetValueCommand(setRequest);
		return new ICommandProxy(setValueCommand);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gef.editpolicies.DirectEditPolicy#showCurrentEditValue(org.eclipse.gef.requests.DirectEditRequest)
	 */
	@Override
	protected void showCurrentEditValue(DirectEditRequest request) {
		String value = (String) request.getCellEditor().getValue();
		getHost().setContentText(value);
	}

	@Override
	public ITextualContentEditPart getHost() {
		return (ITextualContentEditPart) super.getHost();
	}

}
