package org.yakindu.sct.ui.editor.editor;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;

import de.itemis.xtext.utils.gmf.resource.InjectMembersResource;

public class LinkingCommand extends AbstractTransactionalCommand {

	private final InjectMembersResource resource;

	public LinkingCommand(InjectMembersResource resource) {
		super(TransactionUtil.getEditingDomain(resource), "", null);
		this.resource = resource;
	}

	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor,
			IAdaptable info) throws ExecutionException {
		System.out.println("Executing link cmd");
		resource.doLinking();
		return CommandResult.newOKCommandResult();
	}

}
