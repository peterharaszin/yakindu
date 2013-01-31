/**
 * Copyright (c) 2012 itemis AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * 	itemis AG - initial API and implementation
 * 
 */
package org.yakindu.base.types;

import java.util.Collection;
import java.util.List;

/**
 * @author Andreas Mülder - Initial contribution and API
 * @author Alexander Nyßen - Refactorings to support extensible type systems
 * 
 */
public interface ITypeSystemAccess {

	public List<EnumerationType> getEnumerationTypes();
	
	public List<PrimitiveType> getPrimitiveTypes();

	public List<DataType> getDataTypes();

	public List<Type> getTypes();
	
	public boolean isVoid(Type type);

	public boolean isBoolean(Type type);

	public boolean isInteger(Type type);

	public boolean isReal(Type type);

	public boolean isString(Type type);
	
	public List<PrimitiveType> getVoidTypes(Collection<? extends Type> types);

	public List<PrimitiveType> getStringTypes(Collection<? extends Type> types);

	public List<PrimitiveType> getIntegerTypes(Collection<? extends Type> types);

	public List<PrimitiveType> getRealTypes(Collection<? extends Type> types);

	public List<PrimitiveType> getBooleanTypes(Collection<? extends Type> types);
	

	/**
	 * TODO: Refactor this
	 * 
	 * Returns the target language specific type name
	 * 
	 * @param type
	 * @return
	 */
	public String getTargetLanguageTypeName(Type type);
	
}
