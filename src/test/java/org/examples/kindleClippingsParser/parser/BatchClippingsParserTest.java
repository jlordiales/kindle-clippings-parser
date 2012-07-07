package org.examples.kindleClippingsParser.parser;

public class BatchClippingsParserTest extends AbstractClippingsParserTest {

	@Override
	protected AbstractClippingsParser getParser() {
		return new BatchClippingsParser(getWritter());
	}
}
