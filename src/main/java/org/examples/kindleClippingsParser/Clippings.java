package org.examples.kindleClippingsParser;

import java.util.Collection;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

public class Clippings {
	private final Multimap<Book,Clipping> clippings = ArrayListMultimap.create();
	
	public void addClipping(final Book book, final Clipping clipping) {
		clippings.put(book, clipping);
	}
	
	public Collection<Clipping> getClippingsForBook(final Book book){
		return clippings.get(book);
	}

}
