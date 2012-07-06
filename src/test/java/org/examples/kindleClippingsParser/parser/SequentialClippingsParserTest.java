package org.examples.kindleClippingsParser.parser;

import org.examples.kindleClippingsParser.parser.AbstractClippingsParser;
import org.examples.kindleClippingsParser.parser.SequentialClippingsParser;

public class SequentialClippingsParserTest extends AbstractClippingsParserTest {

    @Override
    protected AbstractClippingsParser getParser() {
        return new SequentialClippingsParser(getWritter());
    }

}
