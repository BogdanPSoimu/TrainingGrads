/**
 * Created by bsoimu on 7/30/2016.
 */

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.List;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;

public class CommentWebServiceClientImpl implements CommentWebServiceClient {

    URL url;
    HttpURLConnection connection;
    ObjectMapper mapper = new ObjectMapper();

    public Comment save(Comment comment) {
        try {
            url = new URL("http://localhost:8080/restful/comment");
            connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");

            String jsonString = mapper.writeValueAsString(comment);
            OutputStream os = connection.getOutputStream();
            os.write(jsonString.getBytes());

            if (connection.getResponseCode() != HttpURLConnection.HTTP_CREATED) {
                throw new RuntimeException("Failed: HTTP error code: " + connection.getResponseCode());
            }

            connection.disconnect();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return comment;
    }

    public Comment update(Comment comment, Long commentId) {

        try {
            url = new URL("http://localhost:8080/restfulapis/comment/" + commentId);
            connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setRequestMethod("PUT");
            connection.setRequestProperty("Content-Type", "application/json");
            String jsonInString = mapper.writeValueAsString(comment);
            OutputStream os = connection.getOutputStream();
            os.write(jsonInString.getBytes());
            os.flush();
            os.close();

            if (connection.getResponseCode() != HttpURLConnection.HTTP_CREATED) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + connection.getResponseCode());
            }

            connection.getInputStream();
            connection.disconnect();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Comment findById(Long commentId) {
        Comment comment = null;
        try {
            url = new URL("http://localhost:8080/restful/comment/" + commentId);

            comment = mapper.readValue(url, Comment.class);

        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return comment;
    }

    public List<Comment> findAll() {
        List<Comment> comments = null;
        try {
            url = new URL("http://localhost:8080/restful/comment/");
            mapper.configure(DeserializationConfig.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
            comments = mapper.readValue(url, mapper.getTypeFactory().constructType(List.class, Comment.class));

        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return comments;
    }

    public void delete(Long commentId) {
        try {
            url = new URL("http://localhost:8080/restful/comment/" + commentId);
            connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setRequestMethod("DELETE");
            connection.getResponseCode();

        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}