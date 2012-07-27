package org.examples.kindleClippingsParser.writers;

import static org.mockito.Matchers.argThat;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.verify;

import java.io.PrintStream;

import org.examples.kindleClippingsParser.common.ContainsMatcher;
import org.examples.kindleClippingsParser.types.Book;
import org.examples.kindleClippingsParser.types.Clipping;
import org.examples.kindleClippingsParser.types.Clippings;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public abstract class PrintStreamOuputWritterTest {
	@Mock
	private PrintStream stream;
	private PrintStreamOuputWritter writter;

	protected final PrintStream getStream() {
		return stream;
	}

	protected abstract PrintStreamOuputWritter getConcreteWritter();

	@Before
	public final void setUp() {
		writter = getConcreteWritter();
	}

	private Clippings getClippings() {
		final Clippings clippings = new Clippings();

		final Book book1 = new Book("book1", "author1");
		final Book book2 = new Book("book2", "author2");

		clippings.addClipping(book1.getTitle(), new Clipping(book1, 30,15, "highlight1b1"));
		clippings.addClipping(book1.getTitle(), new Clipping(book1, 2,30, "highlight2b1"));
		clippings.addClipping(book1.getTitle(), new Clipping(book1, 30,12, "highlight3b1"));
		clippings.addClipping(book2.getTitle(), new Clipping(book2, 22,5, "highlight1b2"));
		return clippings;
	}

	@Test
	public final void writeWhen2BooksShouldWriteTwoTitles() {
		writeClippings();
		verify(getStream()).println(containing("book1"));
		verify(getStream()).println(containing("book2"));
	}

	protected final void writeClippings() {
		writter.write(getClippings());
	}

	protected final String containing(final String stringToCheck) {
		return argThat(new ContainsMatcher(stringToCheck));
	}

	@Test
	public final void writeShouldWriteHighlightsOrderedByPageNumber() {
		writeClippings();

		final InOrder inOrder = inOrder(getStream());
		inOrder.verify(getStream()).println(containing("highlight2b1"));
		inOrder.verify(getStream()).println(containing("highlight3b1"));
		inOrder.verify(getStream()).println(containing("highlight1b1"));
	}
}
