package org.examples.kindleClippingsParser.writers;

import static org.mockito.Mockito.inOrder;

import org.junit.Test;
import org.mockito.InOrder;

public class LatexOuputWritterTest extends PrintStreamOuputWritterTest {

	@Override
	protected PrintStreamOuputWritter getConcreteWritter() {
		return new LatexOutputWritter(getStream());
	}

	@Test
	public void shouldWriteDocumentAndBodyHeaders() {
		writeClippings();
		final InOrder inOrder = inOrder(getStream());
		inOrder.verify(getStream()).println(containing("\\begin_document"));
		inOrder.verify(getStream()).println(containing("\\begin_body"));
		inOrder.verify(getStream()).println(containing("\\end_body"));
		inOrder.verify(getStream()).println(containing("\\end_document"));
	}

}
