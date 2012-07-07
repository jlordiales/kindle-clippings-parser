package org.examples.kindleClippingsParser.writers;

import java.io.OutputStream;
import java.io.PrintStream;

public final class OutputWritters {
	private OutputWritters() {
	} // Private constructor to guarantee that this class does not get
		// instantiated

	public static OutputWritter getUnformmatedTextWritter(final OutputStream stream) {
		return new UnformattedTextWritter(new PrintStream(stream));
	}

	public static OutputWritter getHtmlWritter(final OutputStream stream) {
		return new HtmlOutputWritter(new PrintStream(stream));
	}

	public static OutputWritter getLatexWritter(final OutputStream stream) {
		return new LatexOutputWritter(new PrintStream(stream));
	}

}
