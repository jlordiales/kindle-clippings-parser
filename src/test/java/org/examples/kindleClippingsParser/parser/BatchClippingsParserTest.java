package org.examples.kindleClippingsParser.parser;

import org.examples.kindleClippingsParser.parser.AbstractClippingsParser;
import org.examples.kindleClippingsParser.parser.BatchClippingsParser;

public class BatchClippingsParserTest extends AbstractClippingsParserTest{

    @Override
    protected AbstractClippingsParser getParser() {
        return new BatchClippingsParser(getWritter());
    }
}
