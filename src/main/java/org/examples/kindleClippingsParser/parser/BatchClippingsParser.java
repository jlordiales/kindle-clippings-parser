package org.examples.kindleClippingsParser.parser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collection;

import org.examples.kindleClippingsParser.writers.OutputWritter;

import com.google.common.base.Charsets;
import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import com.google.common.io.CharStreams;
import com.google.common.io.Files;

class BatchClippingsParser extends AbstractClippingsParser {

	public BatchClippingsParser(final OutputWritter writter) {
		super(writter);
	}

	@Override
	protected Collection<String> getClippingsAsString(final String clippingPath) throws FileNotFoundException,
			IOException {
		final File clippingFile = new File(clippingPath);
		final Readable clippingReadable = Files.newReader(clippingFile, Charsets.UTF_8);
		final String fileAsString = CharStreams.toString(clippingReadable);
		return Lists.newArrayList(Splitter.on(SEPARATING_STRING).omitEmptyStrings().trimResults().split(fileAsString));
	}

}
