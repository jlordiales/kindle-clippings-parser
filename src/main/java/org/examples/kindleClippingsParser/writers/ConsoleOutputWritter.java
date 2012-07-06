package org.examples.kindleClippingsParser.writers;

import java.util.Collection;

import org.examples.kindleClippingsParser.types.Clipping;
import org.examples.kindleClippingsParser.types.Clippings;

class ConsoleOutputWritter implements OutputWritter {

	public void write(Clippings clippings) {
		Collection<String> bookTitles = clippings.getAllBookTitles();
		for (String each : bookTitles) {
			System.out.println("Clippings for book: " + each);
			printClippingsForBook(each,clippings);
		}

	}

	private void printClippingsForBook(String title,Clippings clippings) {
		Collection<Clipping> clippingsForBook = clippings.getClippingsForBookWithTitle(title);
		for (Clipping each : clippingsForBook) {
			System.out.println("\tPage number: " + each.getPageNumber());
			System.out.println("\t" + each.getHighlight());
		}
		
	}

}
