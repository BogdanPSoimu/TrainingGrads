package Visitor;

/**
 * Created by bsoimu on 7/31/2016.
 */
public class MainVisitor {

    public static void main(String[] args) {

        Document document = new Document();
        Visitor characterCountVisitor = new CharacterCountVisitor();
        Visitor wordCountVisitor = new WordCountVisitor();

        System.out.println(characterCountVisitor.visit(document));
        System.out.println(wordCountVisitor.visit(document));

    }
}
