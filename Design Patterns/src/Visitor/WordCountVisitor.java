package Visitor;

/**
 * Created by bsoimu on 7/31/2016.
 */
public class WordCountVisitor implements Visitor {

    @Override
    public int visit(Document document) {
        int wordCounter = 0;

        for (int i = 0; i < document.getDocumentLines().size(); i++) {
            String line = document.getDocumentLines().get(i);
            String[] splitter = line.split(" ");
            wordCounter = wordCounter + splitter.length;
        }
        return wordCounter;
    }

}
