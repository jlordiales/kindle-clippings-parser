package org.examples.kindleClippingsParser.parser;

public class SequentialClippingsParserTest extends AbstractClippingsParserTest {

	@Override
	protected AbstractClippingsParser getParser() {
		return new SequentialClippingsParser(getWritter());
	}

}
