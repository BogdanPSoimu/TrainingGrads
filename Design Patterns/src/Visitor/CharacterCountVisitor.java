package Visitor;

/**
 * Created by bsoimu on 7/31/2016.
 */
public class CharacterCountVisitor implements Visitor {

    @Override
    public int visit(Document document) {
        int characterCounter = 0;

        for (int i = 0; i < document.getDocumentLines().size(); i++) {
            String line = document.getDocumentLines().get(i);
            String[] splitter = line.split(" ");
            for (int j = 0; j < splitter.length; j++)
                characterCounter = characterCounter + splitter[j].length();
        }
        return characterCounter;
    }

}
