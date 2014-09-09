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

import org.yakindu.base.types.Boolean
import org.yakindu.base.types.Integer
import org.yakindu.base.types.Real
import org.yakindu.base.types.String
import org.yakindu.base.types.Type
import org.yakindu.base.types.Void
import org.yakindu.sct.generator.core.types.ICodegenTypeSystemAccess

/**
 * @author andreas muelder
 * @author Alexander Nyßen - Adopted to type system changes
 */
class OldJavaTypeSystemAccess implements ICodegenTypeSystemAccess {

	override getTargetLanguageName(Type it) {
		switch (it) {
			Void: 'void'
			Integer: 'int'
			Real: 'double'
			Boolean: 'boolean'
			String: 'String'
		}
	}
}
