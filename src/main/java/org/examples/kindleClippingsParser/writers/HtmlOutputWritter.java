package org.examples.kindleClippingsParser.writers;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;

import org.examples.kindleClippingsParser.types.Clipping;
import org.examples.kindleClippingsParser.types.Clippings;

class HtmlOutputWritter implements OutputWritter {
    private final BufferedWriter writer;
    

    public HtmlOutputWritter() throws IOException {
        super();
        this.writer = new BufferedWriter(new FileWriter(new File("clippings.html")));
    }


    @Override
    public void write(Clippings clippings) {
        Collection<String> titles = clippings.getAllBookTitles();
        try {
            writeHtmlHeaders();
            for (String string : titles) {
                writeHtmlTitle(string);
                writeHtmlEnumeration(clippings.getClippingsForBookWithTitle(string));
            }
            writeHtmlFooters();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                writer.flush();
                writer.close();  
            } catch (IOException e) {
                e.printStackTrace();
            }
                      
        }
        

    }
    
    private void writeHtmlHeaders() throws IOException {
        writer.write("<!DOCTYPE html>");
        writer.newLine();
        writer.write("<html>");
        writer.newLine();
        writer.write("<body>");
        writer.newLine();
    }
    
    private void writeHtmlTitle(final String title) throws IOException {
        writer.write("<h1>"+title+"</h1>");
        writer.newLine();
    }
    
    private void writeHtmlEnumeration(final Collection<Clipping> clippings) throws IOException {
        writer.write("<ul>");
        writer.newLine();
        for (Clipping clipping : clippings) {
            writer.write("\t<li> Page " + clipping.getPageNumber() + ": " + clipping.getHighlight() + "</li>");
            writer.newLine();
        }
        writer.write("</ul>");
    }
    
    private void writeHtmlFooters() throws IOException {
        writer.write("</body>");
        writer.write("</html>");
    }

}
