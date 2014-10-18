package org.examples.kindleClippingsParser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;

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
	public static void main(final String[] args) throws FileNotFoundException, IOException, URISyntaxException {
        File clippingsFile = new File(Thread.currentThread().getContextClassLoader().getResource(
            "clippings.txt").toURI());
        final OutputWritter writter = OutputWritters.getLatexWritter(
            new FileOutputStream(new File("clippings.lyx")));

        final ClippingsParser parser = ClippingParsers.createSequentialParser(writter);

        parser.parseClippingFile(clippingsFile.getAbsolutePath());
        System.out.println("Parsing finished");

    }

}
