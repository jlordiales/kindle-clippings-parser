package org.examples.kindleClippingsParser.common;

import org.apache.commons.lang3.StringUtils;
import org.mockito.ArgumentMatcher;

public final class ContainsMatcher extends ArgumentMatcher<String> {
	private final String stringToCheck;

	public ContainsMatcher(final String stringToCheck) {
		super();
		this.stringToCheck = stringToCheck;
	}

	@Override
	public boolean matches(final Object argument) {
		return StringUtils.containsIgnoreCase(argument.toString(), stringToCheck);
	}
}
