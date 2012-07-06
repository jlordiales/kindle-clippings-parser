package org.examples.kindleClippingsParser;

import java.io.FileNotFoundException;
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
	public static void main(String[] args) throws FileNotFoundException, IOException {
		final OutputWritter writter = OutputWritters.getHtmlWritter();
		final ClippingsParser parser = ClippingParsers.createSequentialParser(writter);
		
		parser.parseClippingFile("src/test/resources/duplicates.txt");

	}

}
