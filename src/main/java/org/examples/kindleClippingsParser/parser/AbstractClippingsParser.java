package org.examples.kindleClippingsParser.parser;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collection;

import org.examples.kindleClippingsParser.types.Clipping;
import org.examples.kindleClippingsParser.types.Clippings;
import org.examples.kindleClippingsParser.writers.OutputWritter;

abstract class AbstractClippingsParser implements ClippingsParser {
    protected final static String SEPARATING_STRING = "==========";
    private final OutputWritter writter;
    

    public AbstractClippingsParser(OutputWritter writter) {
        super();
        this.writter = writter;
    }


    @Override
    public final void parseClippingFile(String clippingPath) throws FileNotFoundException, IOException {
        writter.write(getClippings(clippingPath));
    }


    private Clippings getClippings(String clippingPath) throws FileNotFoundException,IOException {
        Collection<String> clippingsStrings = getClippingsAsString(clippingPath);
        Clippings ret = new Clippings();
        for (String each : clippingsStrings) {
            final Clipping clipping = new Clipping(removeNonAsciiCharacters(each));
            ret.addClipping(clipping.getBookTitle(), clipping);
        }
        return ret;
    }


    protected abstract Collection<String> getClippingsAsString(String clippingPath) throws FileNotFoundException,IOException;
    
    String removeNonAsciiCharacters(final String stream) {
        return stream.replaceAll("[^\\x00-\\x7F]", "");
    }

}
