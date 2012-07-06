package org.examples.kindleClippingsParser.parser;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface ClippingsParser {
	void parseClippingFile(String clippingPath) throws FileNotFoundException, IOException;

}
