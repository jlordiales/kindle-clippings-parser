package org.examples.kindleClippingsParser.writers;

import static org.mockito.Mockito.inOrder;

import org.junit.Test;
import org.mockito.InOrder;

public class HtmlOuputWritterTest extends PrintStreamOuputWritterTest {

	@Override
	protected PrintStreamOuputWritter getConcreteWritter() {
		return new HtmlOutputWritter(getStream());
	}

	@Test
	public void shouldWriteHtmlHeaders() {
		writeClippings();
		final InOrder inOrder = inOrder(getStream());
		inOrder.verify(getStream()).println(containing("<!DOCTYPE html>"));
		inOrder.verify(getStream()).println(containing("<html>"));
		inOrder.verify(getStream()).println(containing("<body>"));
		inOrder.verify(getStream()).println(containing("</body>"));
		inOrder.verify(getStream()).println(containing("</html>"));
	}

}
