/**
 * Copyright (c) 2012 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.generator.c.types

import org.yakindu.base.types.Type
import org.yakindu.sct.model.stext.types.DefaultTypeSystemAccess

/**
 * @author andreas muelder
 * @author Alexander Nyßen - Adopted to type system changes
 */
class CTypeSystemAccess extends DefaultTypeSystemAccess {
	
	override getTargetLanguageTypeName(Type type) {
		switch (type) {
			case type == null || isVoid(type): 'void'
			case isInteger(type): 'sc_integer'
			case isReal(type)	: 'sc_real'
			case isBoolean(type): 'sc_boolean'
			case isString(type)	: 'sc_string'
		}
	}
	
}
