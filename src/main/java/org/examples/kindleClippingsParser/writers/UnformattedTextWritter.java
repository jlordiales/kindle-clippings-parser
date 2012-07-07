package org.examples.kindleClippingsParser.writers;

import java.io.IOException;
import java.io.PrintStream;
import java.util.Collection;

import org.examples.kindleClippingsParser.types.Clipping;

class UnformattedTextWritter extends PrintStreamOuputWritter {

	public UnformattedTextWritter(final PrintStream stream) {
		super(stream);
	}

	@Override
	protected void writeHeaders() throws IOException {
	}

	@Override
	protected void writeBookClippings(final String title, final Collection<Clipping> bookClippings) throws IOException {
		printLine("Clippings for book: " + title);
		for (final Clipping each : bookClippings) {
			printLine("\tPage number: " + each.getPageNumber());
			printLine("\t" + each.getHighlight());
		}
	}

	@Override
	protected void writeFooters() throws IOException {
	}

}
