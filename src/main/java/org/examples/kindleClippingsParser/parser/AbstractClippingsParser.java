package org.examples.kindleClippingsParser.parser;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collection;

import org.examples.kindleClippingsParser.types.Clipping;
import org.examples.kindleClippingsParser.types.Clippings;
import org.examples.kindleClippingsParser.writers.OutputWritter;

public abstract class AbstractClippingsParser implements ClippingsParser {
	private static final String ASCII_REGEX = "[^\\x00-\\x7F]";
	protected final static String SEPARATING_STRING = "==========";
	private final OutputWritter writter;

	public AbstractClippingsParser(final OutputWritter writter) {
		super();
		this.writter = writter;
	}

	@Override
	public final void parseClippingFile(final String clippingPath) throws FileNotFoundException, IOException {
		writter.write(getClippings(clippingPath));
	}

	private Clippings getClippings(final String clippingPath) throws FileNotFoundException, IOException {
		final Collection<String> clippingsStrings = getClippingsAsString(clippingPath);
		final Clippings ret = new Clippings();
		for (final String each : clippingsStrings) {
			final Clipping clipping = new Clipping(removeNonAsciiCharacters(each));
			ret.addClipping(clipping.getBookTitle(), clipping);
		}
		return ret;
	}

	protected abstract Collection<String> getClippingsAsString(String clippingPath) throws FileNotFoundException,
			IOException;

	String removeNonAsciiCharacters(final String stream) {
		return stream.replaceAll(ASCII_REGEX, "");
	}

}
