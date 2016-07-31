/**
 * Created by bsoimu on 7/30/2016.
 */

import java.util.Date;

public class Main {

    public static void main(String[] args) {

        Date date = new Date(94,7,15);
//      System.out.println(date.toString());
        Comment comment = new Comment("abcd", "abcd@sda", "casd", date);
        CommentWebServiceClientImpl commentClient = new CommentWebServiceClientImpl();
//      commentClient.save(comment);
    }
}
