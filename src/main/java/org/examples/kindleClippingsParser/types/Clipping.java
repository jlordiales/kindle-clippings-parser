package org.examples.kindleClippingsParser.types;

import java.util.List;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.examples.kindleClippingsParser.exception.InvalidFormatException;

import com.google.common.base.Splitter;
import com.google.common.collect.Lists;

public class Clipping {
	private final Book book;
	private final int pageNumber;
	private final String highlight;
	
	public Clipping(String clippingBlock) {
		super();
		List<String> clippingSections = Lists.newArrayList(Splitter.on("\r\n").omitEmptyStrings().trimResults().split(clippingBlock));
		if (clippingSections.size() < 3) {
			throw new InvalidFormatException("The clipping file has an invalid format");
		}
		this.book = getBookFromClippingLine(clippingSections.get(0));
		this.pageNumber = getPageFromClippingLine(clippingSections.get(1));
		this.highlight = clippingSections.get(2); 
	}
	
	public Clipping(Book book, int pageNumber, String highlight) {
		super();
		this.book = book;
		this.pageNumber = pageNumber;
		this.highlight = highlight;
	}

	private Book getBookFromClippingLine(final String bookLine) {
		List<String> bookSections = Lists.newArrayList(Splitter.on('(').trimResults().split(bookLine));
		final String bookTitleSection = bookSections.get(0);
		final String authorSection = bookSections.get(1);
		return new Book(bookTitleSection.trim(), authorSection.substring(0, authorSection.length()-1).trim());
	}
	
	private int getPageFromClippingLine(final String pageLine) {
		List<String> lineSections = Lists.newArrayList(Splitter.on('|').trimResults().split(pageLine));
		final String pageNumberSection = lineSections.get(0);
		final int pagePosition = pageNumberSection.indexOf("Page");
		if (pagePosition != -1) {
			return Integer.valueOf(pageNumberSection.substring(pagePosition+5));
		}
		return 0;
	}
	
	public Book getBook() {
		return book;
	}

	public String getBookTitle() {
		return book.getTitle();
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public String getHighlight() {
		return highlight;
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(this.book).append(this.highlight).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Clipping)) {
			return false;
		}
		Clipping other = (Clipping) obj;
		return new EqualsBuilder().append(this.book, other.getBook())
				.append(this.highlight, other.getHighlight()).isEquals();
	}

}