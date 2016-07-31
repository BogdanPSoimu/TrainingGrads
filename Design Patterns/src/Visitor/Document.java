package Visitor;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by bsoimu on 7/31/2016.
 */
public class Document implements Element {

    private List<String> documentLines = new ArrayList<>();

    public Document() {
        this.documentLines = readDocument();
    }

    public List<String> getDocumentLines() {
        return documentLines;
    }

    public void setDocumentLines(List<String> documentLines) {
        this.documentLines = documentLines;
    }

    public List<String> readDocument() {
        List<String> documentLines = null;

        try {
            BufferedReader bufferedReader =
                    new BufferedReader(new FileReader("D:/workspace/TrainingGrads/Design Patterns/DesignPatterns.txt"));
            String data;
            documentLines = new ArrayList<>();

            while ((data = bufferedReader.readLine()) != null) {
                documentLines.add(data);
            }

        } catch (FileNotFoundException e) {
            System.out.println("The file is missing: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("I/O exception at the file: " + e.getMessage());
        }

        return documentLines;
    }

    public int accept(Visitor visitor) {
        return visitor.visit(this);
    }

}
