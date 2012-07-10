/****************************************************************************
 * Copyright (c) 2008, 2012 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipselabs.damos.mscript.codegen.c.codefragments

import com.google.inject.Inject
import java.util.Collection
import java.util.Collections
import org.eclipse.core.runtime.IProgressMonitor
import org.eclipselabs.damos.mscript.codegen.c.AbstractCodeFragment
import org.eclipselabs.damos.mscript.codegen.c.ICodeFragmentCollector
import org.eclipselabs.damos.mscript.codegen.c.ICodeFragmentContext
import org.eclipselabs.damos.mscript.codegen.c.Include

import static org.eclipselabs.damos.mscript.codegen.c.ICodeFragment.*

/**
 * @author Andreas Unger
 *
 */
class StringIteratorNextFunction extends AbstractCodeFragment {

	String name
	String statePrefix
	
	String stringTableName
	
	CharSequence functionSignature
	
	@Inject
	new() {
	}
	
	/**
	 * @return the name
	 */
	def String getName() {
		return name
	}
	
	override void initialize(ICodeFragmentContext context, IProgressMonitor monitor) {
		addDependency(FORWARD_DECLARATION_DEPENDS_ON, [it instanceof StringIteratorDeclaration])
		addDependency(IMPLEMENTATION_DEPENDS_ON, [it instanceof StringTable])

		val codeFragmentCollector = context.codeFragmentCollector
		val stringTable = codeFragmentCollector.addCodeFragment(new StringTable(), monitor)

		name = context.globalNameProvider.newGlobalName("StringIterator_next")
		statePrefix = context.globalNameProvider.newGlobalName("StringIteratorState")
		stringTableName = stringTable.name
		
		functionSignature = generateFunctionSignature(codeFragmentCollector)
	}
	
	override boolean contributesInternalForwardDeclaration() {
		return false
	}
	
	override CharSequence generateForwardDeclaration(boolean internal) '''
		«IF internal»static «ENDIF»«functionSignature»;
	'''
	
	override boolean contributesImplementation() {
		return true
	}
	
	override Collection<Include> getImplementationIncludes() {
		return Collections::singletonList(new Include("stdlib.h"));
	}

	override CharSequence generateImplementation(boolean internal) '''
		enum {
			«statePrefix»_InString,
			«statePrefix»_InString_InIndentation,
			«statePrefix»_InString_InIndentationStringTable,
			«statePrefix»_InStringTable,
			«statePrefix»_InStringTable_InIndentation,
			«statePrefix»_InStringTable_InIndentationStringTable
		};
		
		«IF internal»static «ENDIF»«functionSignature» {
			char c;
			for (;;) {
				switch (self->state) {
				case «statePrefix»_InString:
					c = *self->pos++;
					if (c == 0x03) {
						if (self->previous == '\n') {
							c = *self->pos;
							if (c & 0x80) {
								int index = c & 0x3f;
								const char *pos = «stringTableName»[index];
								if (*pos == '\f') {
									++self->pos;
									self->stringTablePos = pos + 1;
									self->state = «statePrefix»_InStringTable;
								}
							}
						}
						continue;
					}
					if (c & 0x80) {
						int index = c & 0x3f;
						const char *pos = «stringTableName»[index];
						if (*pos == 0x02) {
							if (self->indentationEnd != self->indentationBufferEnd) {
								*self->indentationEnd++ = index;
							}
						} else {
							self->stringTablePos = pos;
							self->state = «statePrefix»_InStringTable;
						}
						continue;
					}
					if (*self->pos == 0x03) {
						if (self->indentationEnd != self->indentationBuffer) {
							--self->indentationEnd;
						}
					}
					if (c == '\n' && self->indentationBuffer != self->indentationEnd) {
						self->indentationPos = self->indentationBuffer;
						self->state = «statePrefix»_InString_InIndentation;
					}
					self->previous = c;
					break;
				case «statePrefix»_InString_InIndentation:
					if (self->indentationPos == self->indentationEnd) {
						self->state = «statePrefix»_InString;
						continue;
					}
					self->indentationStringTablePos = «stringTableName»[*self->indentationPos++] + 1;
					self->state = «statePrefix»_InString_InIndentationStringTable;
					/* Fall through */
				case «statePrefix»_InString_InIndentationStringTable:
					c = *self->indentationStringTablePos;
					
					if (c == '\0') {
						self->state = «statePrefix»_InString_InIndentation;
						continue;
					}
					
					++self->indentationStringTablePos;
					break;
				case «statePrefix»_InStringTable:
					c = *self->stringTablePos;
					if (c == '\0') {
						self->state = «statePrefix»_InString;
						continue;
					}
					++self->stringTablePos;
					if (c == '\f') {
						c = '\n';
					}
					if (*self->stringTablePos == '\0' && *self->pos == 0x03) {
						if (self->indentationEnd != self->indentationBuffer) {
							--self->indentationEnd;
						}
					}
					if (c == '\n' && self->indentationBuffer != self->indentationEnd) {
						self->indentationPos = self->indentationBuffer;
						self->state = «statePrefix»_InStringTable_InIndentation;
					}
					self->previous = c;
					break;
				case «statePrefix»_InStringTable_InIndentation:
					if (self->indentationPos == self->indentationEnd) {
						self->state = «statePrefix»_InStringTable;
						continue;
					}
					self->indentationStringTablePos = «stringTableName»[*self->indentationPos++] + 1;
					self->state = «statePrefix»_InStringTable_InIndentationStringTable;
					/* Fall through */
				case «statePrefix»_InStringTable_InIndentationStringTable:
					c = *self->indentationStringTablePos;
					
					if (c == '\0') {
						self->state = «statePrefix»_InStringTable_InIndentation;
						continue;
					}
					
					++self->indentationStringTablePos;
					break;
				default:
					c = '\0';
					break;
				}
				
				return c;
			}
		}
	'''
	
	def private CharSequence generateFunctionSignature(ICodeFragmentCollector codeFragmentCollector) '''
		char «name»(Damos_StringIterator *self)'''
	
	override int hashCode() {
		return ^class.hashCode
	}
	
	override boolean equals(Object obj) {
		if (obj instanceof StringIteratorNextFunction) {
			return true
		}
		return false
	}
	
}
