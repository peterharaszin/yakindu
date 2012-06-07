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

package org.eclipselabs.damos.ide.core.validation;

import org.eclipse.core.resources.IMarker;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EValidator;
import org.eclipselabs.damos.common.markers.IMarkerConstants;

/**
 * @author Andreas Unger
 *
 */
public class Problem {

	private final int severity;
	private final String source;
	private final int code;
	private final URI fragmentURI;
	private final URI elementURI;
	private final String location;
	private final String message;

	private Problem(int severity, String source, int code, URI fragmentURI, URI elementURI, String location, String message) {
		this.severity = severity;
		this.source = source;
		this.code = code;
		this.fragmentURI = fragmentURI;
		this.elementURI = elementURI;
		this.location = location;
		this.message = message;
	}
	
	public static Problem create(int severity, String source, int code, URI fragmentURI, URI elementURI, String location, String message) {
		if (source == null) {
			source = "";
		}
		return new Problem(severity, source, code, fragmentURI, elementURI, location, message);
	}

	public static Problem create(IMarker marker) {
		int severity = marker.getAttribute(IMarker.SEVERITY, IMarker.SEVERITY_INFO);
		String source = marker.getAttribute(IMarkerConstants.SOURCE, "");
		int code = marker.getAttribute(IMarkerConstants.CODE, 0);
		String fragmentURIString = marker.getAttribute(IMarkerConstants.ATTRIBUTE__FRAGMENT_URI, null);
		String elementURIString = marker.getAttribute(EValidator.URI_ATTRIBUTE, null);
		String location = marker.getAttribute(IMarker.LOCATION, null);
		String message = marker.getAttribute(IMarker.MESSAGE, null);
		
		URI fragmentURI = null;
		URI elementURI = null;

		if (fragmentURIString != null) {
			try {
				fragmentURI = URI.createURI(fragmentURIString);
			} catch (RuntimeException e) {
				// Ignore invalid URI
			}
		}
		if (elementURIString != null) {
			try {
				elementURI = URI.createURI(elementURIString);
			} catch (RuntimeException e) {
				// Ignore invalid URI
			}
		}

		return new Problem(severity, source, code, fragmentURI, elementURI, location, message);
	}

	/**
	 * @return the severity
	 */
	public int getSeverity() {
		return severity;
	}
	
	/**
	 * @return the source
	 */
	public String getSource() {
		return source;
	}
	
	/**
	 * @return the code
	 */
	public int getCode() {
		return code;
	}

	/**
	 * @return the fragmentURI
	 */
	public URI getFragmentURI() {
		return fragmentURI;
	}

	/**
	 * @return the elementURI
	 */
	public URI getElementURI() {
		return elementURI;
	}

	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		int hashCode = severity ^ code;
		if (source != null) {
			hashCode ^= source.hashCode();
		}
		if (fragmentURI != null) {
			hashCode ^= fragmentURI.hashCode();
		}
		if (elementURI != null) {
			hashCode ^= elementURI.hashCode();
		}
		if (location != null) {
			hashCode ^= location.hashCode();
		}
		if (message != null) {
			hashCode ^= message.hashCode();
		}
		return hashCode;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (obj instanceof Problem) {
			Problem other = (Problem) obj;
			return other.severity == severity && other.code == code && other.source.equals(source)
					&& safeEquals(other.fragmentURI, fragmentURI) && safeEquals(other.elementURI, elementURI)
					&& safeEquals(other.location, location) && safeEquals(other.message, message);
		}
		return false;
	}
	
	private static boolean safeEquals(Object o1, Object o2) {
		if (o1 == o2) {
			return true;
		}
		if (o1 == null || o2 == null) {
			return false;
		}
		return o1.equals(o2);
	}

}
