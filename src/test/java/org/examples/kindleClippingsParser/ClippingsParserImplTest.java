package org.examples.kindleClippingsParser;

import static org.fest.assertions.Assertions.assertThat;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class ClippingsParserImplTest {
	private ClippingsParserImpl parser = new ClippingsParserImpl();

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testParseClippingFile() throws FileNotFoundException, IOException {
		List<Clipping> clippings = parser.parseClippingFile("src/test/resources/clippings.txt");
		
		assertThat(clippings).hasSize(8);
		
		assertThat(clippings.get(0).getPageNumber()).isZero();
		final String title = clippings.get(0).getBook().getTitle().substring(1);
		assertThat(title).isEqualTo("Wonders of the Universe");
		
		assertThat(clippings.get(3).getPageNumber()).isEqualTo(32);
		assertThat(clippings.get(3).getBook().getTitle()).isEqualTo("REST in Practice: Hypermedia and Systems Architecture");
		
		assertThat(clippings.get(6).getPageNumber()).isEqualTo(95);
		assertThat(clippings.get(6).getBook().getTitle()).isEqualTo("Effective Java");
	}

}
