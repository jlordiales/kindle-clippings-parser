package org.examples.kindleClippingsParser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.examples.kindleClippingsParser.parser.ClippingParsers;
import org.examples.kindleClippingsParser.parser.ClippingsParser;
import org.examples.kindleClippingsParser.writers.OutputWritter;
import org.examples.kindleClippingsParser.writers.OutputWritters;

public class ParserLauncher {

	/**
	 * @param args
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	public static void main(final String[] args) throws FileNotFoundException, IOException {
		final OutputWritter writter = OutputWritters.getLatexWritter(new FileOutputStream(new File("/home/jose/reviews.lyx")));
		final ClippingsParser parser = ClippingParsers.createSequentialParser(writter);

		parser.parseClippingFile("/home/jose/Documents/clippings.txt");
		System.out.println("Parsing finished");

	}

}
