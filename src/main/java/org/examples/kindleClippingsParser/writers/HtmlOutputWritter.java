package org.examples.kindleClippingsParser.writers;

import java.io.IOException;
import java.io.PrintStream;
import java.util.Collection;

import org.examples.kindleClippingsParser.types.Clipping;

class HtmlOutputWritter extends PrintStreamOuputWritter {

	public HtmlOutputWritter(final PrintStream stream) {
		super(stream);
	}

	@Override
	protected void writeHeaders() throws IOException {
		printLine("<!DOCTYPE html>");
		printLine("<html>");
		printLine("<body>");
	}

	@Override
	protected void writeBookClippings(final String title, final Collection<Clipping> bookClippings) throws IOException {
		printLine("<h1>" + title + "</h1>");
		printLine("<ul>");
		for (final Clipping clipping : bookClippings) {
			printLine("\t<li> Page " + clipping.getPageNumber() + ": " + clipping.getHighlight() + "</li>");
		}
		printLine("</ul>");
	}

	@Override
	protected void writeFooters() throws IOException {
		printLine("</body>");
		printLine("</html>");
	}

}
