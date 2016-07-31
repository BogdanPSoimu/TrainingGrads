/**
 * Created by bsoimu on 7/30/2016.
 */

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;


@JsonIgnoreProperties(ignoreUnknown = true)
public class CommentList {

    private List<Comment> comments;

    public List<Comment> getComments() {
        return comments;
    }

}

