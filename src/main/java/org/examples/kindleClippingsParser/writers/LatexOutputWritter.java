package org.examples.kindleClippingsParser.writers;

import java.util.Collection;

import org.examples.kindleClippingsParser.types.Clipping;
import org.examples.kindleClippingsParser.types.Clippings;

public class LatexOutputWritter implements OutputWritter {
	
	public LatexOutputWritter() {
		super();
	}

	@Override
	public void write(Clippings clippings) {
		Collection<String> bookTitles = clippings.getAllBookTitles();
		for (String each : bookTitles) {
			writeClippingsForBook(each, clippings);
		}

	}
	
	private void writeClippingsForBook(String bookTitle, Clippings clippings) {
		final Collection<Clipping> bookClippings = clippings.getClippingsForBookWithTitle(bookTitle);
	}

}
