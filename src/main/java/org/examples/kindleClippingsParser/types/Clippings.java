package org.examples.kindleClippingsParser.types;

import java.util.Collection;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;

public class Clippings {
	private final Multimap<String, Clipping> clippings = HashMultimap.create();

	public void addClipping(final String bookTitle, final Clipping clipping) {
		clippings.put(bookTitle, clipping);
	}

	public Collection<Clipping> getClippingsForBookWithTitle(final String bookTitle) {
		return clippings.get(bookTitle);
	}

	public Collection<String> getAllBookTitles() {
		return clippings.keySet();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (clippings == null ? 0 : clippings.hashCode());
		return result;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Clippings)) {
			return false;
		}
		final Clippings other = (Clippings) obj;
		if (clippings == null) {
			if (other.clippings != null) {
				return false;
			}
		} else if (!clippings.equals(other.clippings)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Clippings [clippings=" + clippings + "]";
	}

}
