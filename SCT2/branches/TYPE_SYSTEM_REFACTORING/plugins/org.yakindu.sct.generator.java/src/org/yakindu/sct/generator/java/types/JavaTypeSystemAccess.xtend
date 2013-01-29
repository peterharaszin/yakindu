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
package org.yakindu.sct.generator.java.types

import org.yakindu.base.types.Type
import org.yakindu.sct.model.stext.types.DefaultTypeSystemAccess

/**
 * @author andreas muelder
 * @author Alexander Nyßen - Adopted to type system changes
 */
class JavaTypeSystemAccess extends DefaultTypeSystemAccess {
	
	override getTargetLanguageTypeName(Type type) {
		switch (type) {
			case type == null || isVoid(type): "void"
			case isReal(type) : "double"
			case isInteger(type) : "int"
			case isBoolean(type) : "boolean"
			case isString(type) : "String"
			default : "//"+this
		};
	}
	
}
