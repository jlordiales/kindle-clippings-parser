package org.examples.kindleClippingsParser.writers;

public final class OutputWritters {
	private OutputWritters(){} //Private constructor to guarantee that this class does not get instantiated
	
	public static OutputWritter getConsoleWritter() {
		return new ConsoleOutputWritter();
	}

}
