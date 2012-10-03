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

package org.eclipse.damos.dconfig.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

/**
 * @author Andreas Unger
 *
 */
public final class PropertyPath {
	
	private static final Pattern SEGMENT_DELIMITER_PATTERN = Pattern.compile("/");
	private static final Pattern SEGMENT_PART_DELIMITER_PATTERN = Pattern.compile(":");

	private final List<Segment> segments;
	
	private PropertyPath(List<Segment> segments) {
		if (segments.isEmpty()) {
			throw new IllegalArgumentException("Segments must not be empty");
		}
		this.segments = segments;
	}
	
	/**
	 * @return the segments
	 */
	public List<Segment> getSegments() {
		return segments;
	}
	
	public PropertyPath append(String name) {
		return append(name, -1);
	}
	
	public PropertyPath append(String name, int index) {
		if (isWildcard()) {
			throw new IllegalStateException("New elements must not be added to wildcard property path");
		}
		List<Segment> segments = new ArrayList<Segment>(this.segments);
		segments.add(new Segment(name, index));
		return new PropertyPath(Collections.unmodifiableList(segments));
	}
	
	public PropertyPath wildcard() {
		if (isWildcard()) {
			return this;
		}
		return setIndex(Integer.MAX_VALUE);
	}
	
	public boolean isWildcard() {
		return segments.get(segments.size() - 1).index == Integer.MAX_VALUE;
	}
	
	public PropertyPath setIndex(int index) {
		List<Segment> segments = new ArrayList<Segment>(this.segments);
		int lastIndex = segments.size() - 1;
		Segment segment = segments.get(lastIndex);
		segments.set(lastIndex, new Segment(segment.name, index));
		return new PropertyPath(Collections.unmodifiableList(segments));
	}
	
	public static PropertyPath create(String path) throws NumberFormatException {
		List<Segment> segments = new ArrayList<PropertyPath.Segment>();
		for (String segment : SEGMENT_DELIMITER_PATTERN.split(path)) {
			String[] parts = SEGMENT_PART_DELIMITER_PATTERN.split(segment);
			
			String name = parts[0];
			int index = -1;
			if (parts.length > 1) {
				index = Integer.parseInt(parts[1]);
			}
			
			segments.add(new Segment(name, index));
		}
		return new PropertyPath(Collections.unmodifiableList(segments));
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return segments.hashCode();
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof PropertyPath) {
			PropertyPath other = (PropertyPath) obj;
			return other.segments.equals(segments);
		}
		return false;
	}
	
	public static final class Segment {
		
		private final String name;
		private final int index;
		
		private Segment(String name, int index) {
			if (name == null) {
				throw new NullPointerException();
			}
			this.name = name;
			this.index = index;
		}
		
		/**
		 * @return the name
		 */
		public String getName() {
			return name;
		}
		
		/**
		 * @return the index
		 */
		public int getIndex() {
			return index;
		}
		
		/* (non-Javadoc)
		 * @see java.lang.Object#hashCode()
		 */
		@Override
		public int hashCode() {
			return name.hashCode() ^ index;
		}
		
		/* (non-Javadoc)
		 * @see java.lang.Object#equals(java.lang.Object)
		 */
		@Override
		public boolean equals(Object obj) {
			if (obj instanceof Segment) {
				Segment other = (Segment) obj;
				return other.name.equals(name) && other.index == index;
			}
			return false;
		}
		
	}
	
}
