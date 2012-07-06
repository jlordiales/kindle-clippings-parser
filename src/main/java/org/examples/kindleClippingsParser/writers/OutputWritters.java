package org.examples.kindleClippingsParser.writers;

import java.io.IOException;

public final class OutputWritters {
	private OutputWritters(){} //Private constructor to guarantee that this class does not get instantiated
	
	public static OutputWritter getConsoleWritter() {
		return new ConsoleOutputWritter();
	}
	
	public static OutputWritter getHtmlWritter() throws IOException {
	    return new HtmlOutputWritter();
	}

}
