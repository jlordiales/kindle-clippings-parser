package org.examples.kindleClippingsParser.writers;

import java.io.IOException;
import java.io.PrintStream;
import java.util.Collection;

import org.examples.kindleClippingsParser.types.Clipping;

class LatexOutputWritter extends PrintStreamOuputWritter {

	public LatexOutputWritter(final PrintStream stream) {
		super(stream);
	}

	@Override
	protected void writeHeaders() throws IOException {
		printLine("\\lyxformat 413");
		printLine("\\begin_document");
		printLine("\\begin_header");
		printLine("\\textclass article");
		printLine("\\begin_preamble");
		printLine("\\usepackage{a4wide}");
		printLine("\\end_preamble");
		printLine("\\use_default_options true");
		printLine("\\maintain_unincluded_children false");
		printLine("\\language english");
		printLine("\\language_package default");
		printLine("\\inputencoding auto");
		printLine("\\fontencoding global");
		printLine("\\font_roman default");
		printLine("\\font_sans default");
		printLine("\\font_typewriter default");
		printLine("\\font_default_family default");
		printLine("\\use_non_tex_fonts false");
		printLine("\\font_sc false");
		printLine("\\font_osf false");
		printLine("\\font_sf_scale 100");
		printLine("\\font_tt_scale 100");
		printLine("\\graphics default");
		printLine("\\default_output_format default");
		printLine("\\output_sync 0");
		printLine("\\bibtex_command default");
		printLine("\\index_command default");
		printLine("\\paperfontsize default");
		printLine("\\spacing single");
		printLine("\\use_hyperref false");
		printLine("\\papersize default");
		printLine("\\use_geometry false");
		printLine("\\use_amsmath 1");
		printLine("\\use_esint 1");
		printLine("\\use_mhchem 1");
		printLine("\\use_mathdots 1");
		printLine("\\cite_engine basic");
		printLine("\\use_bibtopic false");
		printLine("\\use_indices false");
		printLine("\\paperorientation portrait");
		printLine("\\suppress_date false");
		printLine("\\use_refstyle 1");
		printLine("\\index Index");
		printLine("\\shortcut idx");
		printLine("\\color #008000");
		printLine("\\end_index");
		printLine("\\secnumdepth 3");
		printLine("\\tocdepth 3");
		printLine("\\paragraph_separation indent");
		printLine("\\paragraph_indentation default");
		printLine("\\quotes_language english");
		printLine("\\papercolumns 1");
		printLine("\\papersides 1");
		printLine("\\paperpagestyle default");
		printLine("\\tracking_changes false");
		printLine("\\output_changes false");
		printLine("\\html_math_output 0");
		printLine("\\html_css_as_file 0");
		printLine("\\html_be_strict false");
		printLine("\\end_header");
		printLine("\\begin_body");
	}

	@Override
	protected void writeBookClippings(final String title, final Collection<Clipping> bookClippings) throws IOException {
		printLine("\\begin_layout Title");
		printLine(title);
		printLine("\\end_layout");
		for (final Clipping clipping : bookClippings) {
			printLine("\\begin_layout Itemize");
			printLine("Page " + clipping.getPageNumber() + ": " + clipping.getHighlight());
			printLine("\\end_layout");
		}

	}

	@Override
	protected void writeFooters() throws IOException {
		printLine("\\end_body");
		printLine("\\end_document");
	}

}
