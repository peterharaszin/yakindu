/*
* generated by Xtext
*/
package org.yakindu.sct.generator.genmodel.parser.antlr;

import java.io.InputStream;
import org.eclipse.xtext.parser.antlr.IAntlrTokenFileProvider;

public class SGenAntlrTokenFileProvider implements IAntlrTokenFileProvider {
	
	public InputStream getAntlrTokenFile() {
		ClassLoader classLoader = getClass().getClassLoader();
    	return classLoader.getResourceAsStream("org/yakindu/sct/generator/genmodel/parser/antlr/internal/InternalSGen.tokens");
	}
}
