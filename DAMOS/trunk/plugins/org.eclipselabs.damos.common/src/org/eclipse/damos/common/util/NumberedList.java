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

package org.eclipse.damos.common.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public class NumberedList<V> {

	private static final NumberedList<Object> EMPTY_LIST = new NumberedList<Object>() {
		
		public Object put(int number, Object value) {
			throw new UnsupportedOperationException();
		}
		
		public Object remove(int number) {
			throw new UnsupportedOperationException();
		}
		
	};
	
	private NavigableMap<Integer, V> map;

	public NumberedList() {
		map = new TreeMap<Integer, V>();
	}
	
	@SuppressWarnings("unchecked")
	public static <V> NumberedList<V> emptyList() {
		return (NumberedList<V>) EMPTY_LIST;
	}

	public V put(int number, V value) {
		return map.put(number, value);
	}
	
	public void putAll(NumberedList<? extends V> list) {
		map.putAll(list.map);
	}

	public V remove(int number) {
		return map.remove(number);
	}

	public V get(int number) {
		return map.get(number);
	}
	
	public V getFirst() {
		return map.firstEntry().getValue();
	}

	public boolean containsNumber(int number) {
		return map.containsKey(number);
	}

	public boolean containsValue(V value) {
		return map.containsValue(value);
	}

	public int size() {
		return map.size();
	}
	
	public boolean isEmpty() {
		return map.isEmpty();
	}
	
	public int[] numbers() {
		int[] keys = new int[size()];
		int i = 0;
		for (Integer key : map.keySet()) {
			keys[i++] = key;
		}
		return keys;
	}
	
	public Collection<V> values() {
		return map.values();
	}
	
	public void clear() {
		map.clear();
	}
	
	public Collection<Entry<V>> entries() {
		List<Entry<V>> entries = new ArrayList<NumberedList.Entry<V>>();
		for (Map.Entry<Integer, V> entry : map.entrySet()) {
			entries.add(new Entry<V>(entry.getKey(), entry.getValue()));
		}
		return entries;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return map.hashCode();
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		return map.equals(obj);
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return map.toString();
	}
	
	public static class Entry<V> {
		
		private final int number;
		private final V value;
		
		/**
		 * 
		 */
		Entry(int number, V value) {
			this.number = number;
			this.value = value;
		}
		
		/**
		 * @return the number
		 */
		public int getNumber() {
			return number;
		}
		
		/**
		 * @return the value
		 */
		public V getValue() {
			return value;
		}
		
	}
	
}
