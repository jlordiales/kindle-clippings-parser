package org.examples.kindleClippingsParser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.examples.kindleClippingsParser.types.Clipping;
import org.examples.kindleClippingsParser.types.Clippings;
import org.examples.kindleClippingsParser.writers.OutputWritter;

import com.google.common.base.Charsets;
import com.google.common.base.Splitter;
import com.google.common.io.CharStreams;
import com.google.common.io.Files;

public class ClippingsParserImpl implements ClippingsParser {
	private static String SEPARATING_STRING = "==========";
	private final OutputWritter writter;
	
	public ClippingsParserImpl(OutputWritter writter) {
		super();
		this.writter = writter;
	}

	public void parseClippingFile(String clippingPath) throws FileNotFoundException,IOException {
		final String clippingString = removeNonAsciiCharacters(clippingFileToString(clippingPath));
		writter.write(getClippings(clippingString));
	}

	private Clippings getClippings(final String clippingString) {
		Iterable<String> iterableClippings = Splitter.on(SEPARATING_STRING).omitEmptyStrings().trimResults().split(clippingString);
		Clippings ret = new Clippings();
		for (String each : iterableClippings) {
			final Clipping clipping = new Clipping(each);
			ret.addClipping(clipping.getBookTitle(), clipping);
		}
		return ret;
	}

	private String clippingFileToString(String clippingPath) throws FileNotFoundException,IOException {
		File clippingFile = new File(clippingPath);
		Readable clippingReadable = Files.newReader(clippingFile, Charsets.UTF_8);
		return CharStreams.toString(clippingReadable);
	}
	
	String removeNonAsciiCharacters(final String stream) {
		return stream.replaceAll("[^\\x00-\\x7F]", "");
	}

}
