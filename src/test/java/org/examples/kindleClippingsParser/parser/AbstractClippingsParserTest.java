package org.examples.kindleClippingsParser.parser;

import static org.mockito.Mockito.verify;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.examples.kindleClippingsParser.exception.InvalidFormatException;
import org.examples.kindleClippingsParser.types.Book;
import org.examples.kindleClippingsParser.types.Clipping;
import org.examples.kindleClippingsParser.types.Clippings;
import org.examples.kindleClippingsParser.writers.OutputWritter;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public abstract class AbstractClippingsParserTest {
	@Mock
	private OutputWritter writter;
	private AbstractClippingsParser parser;

	@Before
	public void setUp() throws Exception {
		parser = getParser();
	}

	public OutputWritter getWritter() {
		return writter;
	}

	protected abstract AbstractClippingsParser getParser();

	@Test
	public void parseClippingFileWhenStandardFileShouldProcessClippings() throws FileNotFoundException, IOException {
		parser.parseClippingFile("src/test/resources/standard.txt");

		verify(writter).write(getExpectedClippingsForStandardFile());
	}

	private Clippings getExpectedClippingsForStandardFile() {
		final Clippings clippings = new Clippings();
		final String wondersTitle = "Wonders of the Universe";
		final String restTitle = "REST in Practice: Hypermedia and Systems Architecture";
		final String effectiveJavaTitle = "Effective Java";

		final Book wondersOfTheUniverse = new Book(wondersTitle, "Andrew Cohen and Professor Brian Cox");
		final Book restInPractice = new Book(restTitle, "Jim Webber, Savas Parastatidis and Ian Robinson");
		final Book effectiveJava = new Book(effectiveJavaTitle, "Joshua Bloch");

		clippings
				.addClipping(
						wondersTitle,
						new Clipping(
								wondersOfTheUniverse,
								0,
								parser.removeNonAsciiCharacters("The scientific project is ultimately modest: it doesn’t seek universal truths and it doesn’t seek absolutes, it simply seeks to understand – and therein lies its power and value.")));
		clippings
				.addClipping(
						restTitle,
						new Clipping(
								restInPractice,
								31,
								parser.removeNonAsciiCharacters("REST describes the Web as a distributed hypermedia application whose linked resources communicate by exchanging representations of resource state.")));
		clippings
				.addClipping(
						restTitle,
						new Clipping(
								restInPractice,
								32,
								parser.removeNonAsciiCharacters("The idea is simple, and yet very powerful. A distributed application makes forward progress by transitioning from one state to another, just like a state machine. The difference from traditional state machines, however, is that the possible states and the transitions between them are not known in advance. Instead, as the application reaches a new state, the next possible transitions are discovered. It’s like a treasure hunt.")));
		clippings
				.addClipping(
						effectiveJavaTitle,
						new Clipping(
								effectiveJava,
								89,
								parser.removeNonAsciiCharacters("Therefore, if you override the clone method in a nonfinal class, you should return an object obtained by invoking super.clone. If all of a class’s superclasses obey this rule, then invoking super.clone will eventually invoke Object’s clone method, creating an instance of the right class.")));
		return clippings;
	}

	@Test(expected = FileNotFoundException.class)
	public void parseClippingFileWhenInvalidPathShouldThrowFileNotFoundException() throws FileNotFoundException,
			IOException {
		parser.parseClippingFile("invalidPath.txt");
	}

	@Test
	public void parseClippingFileWhenDuplicatedHighlightsOnDifferentPagesShouldOnlyConsiderTheFirst()
			throws FileNotFoundException, IOException {
		parser.parseClippingFile("src/test/resources/duplicates.txt");

		final Clippings expectedClippings = getExpectedClippingsForStandardFile();
		verify(writter).write(expectedClippings);
	}

	@Test(expected = InvalidFormatException.class)
	public void parseClippingFileWhenInvalidFormatFileShouldThrowInvalidFormatException() throws FileNotFoundException,
			IOException {
		parser.parseClippingFile("src/test/resources/invalidFormat.txt");
	}

}
