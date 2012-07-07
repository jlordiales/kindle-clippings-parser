package org.examples.kindleClippingsParser.writers;

public class UnformattedTextWritterTest extends PrintStreamOuputWritterTest {

	@Override
	protected PrintStreamOuputWritter getConcreteWritter() {
		return new UnformattedTextWritter(getStream());
	}

}
