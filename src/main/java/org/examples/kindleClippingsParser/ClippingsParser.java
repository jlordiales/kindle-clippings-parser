package org.examples.kindleClippingsParser;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface ClippingsParser {
	void parseClippingFile(String clippingPath) throws FileNotFoundException, IOException;

}
