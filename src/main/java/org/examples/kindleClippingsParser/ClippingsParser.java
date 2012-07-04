package org.examples.kindleClippingsParser;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface ClippingsParser {
	List<Clipping> parseClippingFile(String clippingPath) throws FileNotFoundException, IOException;

}
