package org.examples.kindleClippingsParser.parser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

import org.examples.kindleClippingsParser.exception.InvalidFormatException;
import org.examples.kindleClippingsParser.writers.OutputWritter;

import com.google.common.base.Charsets;
import com.google.common.collect.Lists;
import com.google.common.io.Files;

class SequentialClippingsParser extends AbstractClippingsParser {

    public SequentialClippingsParser(OutputWritter writter) {
        super(writter);
    }

    @Override
    protected Collection<String> getClippingsAsString(String clippingPath) throws FileNotFoundException, IOException {
        final BufferedReader reader = Files.newReader(new File(clippingPath), Charsets.UTF_8);
        final List<String> clippingsList = Lists.newArrayList();
        StringBuilder builder = new StringBuilder();
        String currentLine;
        
        while ((currentLine = reader.readLine()) != null) {
            if (currentLine.equals(AbstractClippingsParser.SEPARATING_STRING)) {
                clippingsList.add(builder.toString());
                builder = new StringBuilder();
            } else {
                builder.append(currentLine);
                builder.append("\r\n");
            }            
        }
        reader.close();
        if (clippingsList.isEmpty()) {
            throw new InvalidFormatException();
        }
        return clippingsList;        
    }


}
