package org.examples.kindleClippingsParser.parser;

import org.examples.kindleClippingsParser.writers.OutputWritter;

public final class ClippingParsers {
    private ClippingParsers() {}
    
    public static ClippingsParser createSequentialParser(final OutputWritter writter) {
        return new SequentialClippingsParser(writter);
    }
    
    public static ClippingsParser createBatchParser(final OutputWritter writter) {
        return new BatchClippingsParser(writter);
    }

}
