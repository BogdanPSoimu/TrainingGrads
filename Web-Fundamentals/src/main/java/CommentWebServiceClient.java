/**
 * Created by bsoimu on 7/30/2016.
 */

import java.util.List;

public interface CommentWebServiceClient {

    Comment save(Comment comment);

    Comment update(Comment comment,Long commentId);

    Comment findById(Long commentId);

    List<Comment> findAll();

    void delete(Long commentId);
}
