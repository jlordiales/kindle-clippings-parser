package org.examples.kindleClippingsParser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import com.google.common.base.Charsets;
import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import com.google.common.io.CharStreams;
import com.google.common.io.Files;

public class ClippingsParserImpl implements ClippingsParser {
	private static String SEPARATING_STRING = "==========";

	public List<Clipping> parseClippingFile(String clippingPath) throws FileNotFoundException,IOException {
		File clippingFile = new File(clippingPath);
		Readable clippingReadable = Files.newReader(clippingFile, Charsets.UTF_8);
		final String clippingString = CharStreams.toString(clippingReadable);
		Iterable<String> iterableClippings = Splitter.on(SEPARATING_STRING).omitEmptyStrings().trimResults().split(clippingString);
		List<Clipping> ret = Lists.newArrayList();
		for (String each : iterableClippings) {
			ret.add(new Clipping(each));
		}
		return ret;
	}

}
