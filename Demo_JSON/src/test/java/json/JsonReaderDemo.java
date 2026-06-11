package json;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.JSONArray;
import org.json.JSONObject;

public class JsonReaderDemo {

    public static void main(String[] args) throws Exception {

        String content =
                new String(Files.readAllBytes(Paths.get("users.json")));

        JSONArray array = new JSONArray(content);

        for (int i = 0; i < array.length(); i++) {

            JSONObject obj = array.getJSONObject(i);

            System.out.println(obj.getString("username"));
            System.out.println(obj.getString("password"));
        }
    }
}