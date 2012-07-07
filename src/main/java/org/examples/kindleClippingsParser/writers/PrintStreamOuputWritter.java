package org.examples.kindleClippingsParser.writers;

import java.io.IOException;
import java.io.PrintStream;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.examples.kindleClippingsParser.types.Clipping;
import org.examples.kindleClippingsParser.types.Clippings;

import com.google.common.collect.Lists;

public abstract class PrintStreamOuputWritter implements OutputWritter {
	private final PrintStream stream;

	public PrintStreamOuputWritter(final PrintStream stream) {
		super();
		this.stream = stream;
	}

	void printLine(final String line) {
		stream.println(line);
	}

	@Override
	public final void write(final Clippings clippings) {
		final Collection<String> titles = clippings.getAllBookTitles();
		try {
			writeHeaders();
			for (final String each : titles) {
				final List<Clipping> clippingsForBookWithTitle = Lists.newArrayList(clippings
						.getClippingsForBookWithTitle(each));
				Collections.sort(clippingsForBookWithTitle);
				writeBookClippings(each, clippingsForBookWithTitle);
			}
			writeFooters();
		} catch (final IOException e) {
			e.printStackTrace();
		} finally {
			stream.flush();
			stream.close();
		}
	}

	protected abstract void writeHeaders() throws IOException;

	protected abstract void writeBookClippings(String title, Collection<Clipping> bookClippings) throws IOException;

	protected abstract void writeFooters() throws IOException;

}
