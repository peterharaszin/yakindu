package org.eclipselabs.damos.mscript.ui.autoedit;

import org.eclipse.jface.text.IDocument;
import org.eclipse.xtext.ui.editor.autoedit.DefaultAutoEditStrategyProvider;
import org.eclipse.xtext.ui.editor.model.TerminalsTokenTypeToPartitionMapper;

public class MscriptAutoEditStrategyProvider extends DefaultAutoEditStrategyProvider {

	@Override
	protected void configureStringLiteral(IEditStrategyAcceptor acceptor) {
		acceptor.accept(partitionInsert.newInstance("\"\"\"", "\"\"\""), IDocument.DEFAULT_CONTENT_TYPE);
		acceptor.accept(partitionDeletion.newInstance("\"\"\"", "\"\"\""), IDocument.DEFAULT_CONTENT_TYPE);

		acceptor.accept(partitionInsert.newInstance("\"", "\""), IDocument.DEFAULT_CONTENT_TYPE);
		acceptor.accept(partitionDeletion.newInstance("\"", "\""), IDocument.DEFAULT_CONTENT_TYPE);
		acceptor.accept(partitionEndSkippingEditStrategy.get(), TerminalsTokenTypeToPartitionMapper.STRING_LITERAL_PARTITION);
	}

}
