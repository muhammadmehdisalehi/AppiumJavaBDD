package DataReader;


import com.google.gson.JsonArray;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;
import org.json.simple.parser.ParseException;
import org.json.simple.JSONArray;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Map;

public class JsonReader {
    static JSONParser parser = new JSONParser();
    /**
     * @param filePath
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     * @throws ParseException
     */
    public static JSONObject getJSONDataURL(String filePath) throws FileNotFoundException, IOException, ParseException {
        Object obj = parser.parse(new FileReader(filePath));
        JSONObject jsonObject = (JSONObject) obj;
        return jsonObject;
    }

    public static String fetchDataJsonObjectArrayObject(JSONObject jsonObject, String textValue, String Identifier, String Datadesc) {
        try {
            jsonObject = (JSONObject) jsonObject.get(textValue);
            jsonObject = (JSONObject) jsonObject.get(Identifier);
            return (String) jsonObject.get(Datadesc);
        }
        catch (Exception ex){
            System.out.println(ex);
            return ex.toString();
        }
    }
    public static Map<String, String> getDataAsMap(JSONObject jsonObject,String textValue, String Identifier) {
        try {
            jsonObject = (JSONObject) jsonObject.get(textValue);
            jsonObject = (JSONObject) jsonObject.get(Identifier);
            return jsonObject;
        }
        catch (Exception ex){
        return null;
        }
    }
    public static int getSizeofJsonArray(String fileName,String jsonElement){
        try {
            fileName = System.getProperty("user.dir")+"/src/test/java/com/jogo/automation/outputDataFiles/"+fileName+".json";
            Object obj = parser.parse(new FileReader(fileName));
            JSONObject jsonObject = (JSONObject) obj;
            JSONArray arrayJson = (JSONArray) jsonObject.get(jsonElement);
            int lengthOfArray = arrayJson.size();
            System.out.println(lengthOfArray);
            return lengthOfArray;
        }
        catch (Exception ex){
            System.out.println(ex);
            return 0;
        }
    }
    public static int getSizeofRecords(String fileName,String jsonElement){
        try {
            fileName = System.getProperty("user.dir")+"/src/test/java/com/jogo/automation/outputDataFiles/"+fileName+".json";
            Object obj = parser.parse(new FileReader(fileName));
            JSONObject jsonObject = (JSONObject) obj;
            JSONObject objJson = (JSONObject) jsonObject.get(jsonElement);
            int objJsonLength = Integer.parseInt(objJson.get("total_records").toString());
            return objJsonLength;
        }
        catch (Exception ex){
            System.out.println(ex);
            return 0;
        }
    }
    public static JSONArray getJsonArray(String fileName, String jsonElement,String arrayName){
        JSONArray arrayJson = null;
        try {
            fileName = System.getProperty("user.dir")+"/src/test/java/com/jogo/automation/outputDataFiles/"+fileName+".json";
            Object obj = parser.parse(new FileReader(fileName));
            JSONObject jsonObject = (JSONObject) obj;
            jsonObject = (JSONObject) jsonObject.get(jsonElement);
            arrayJson = (JSONArray) jsonObject.get(arrayName);
            return arrayJson;
        }
        catch (Exception ex){
            System.out.println(ex);
            return arrayJson;
        }
    }
    public static JSONObject getContent(String fileName, String jsonElement){
        JSONObject objJson = null;
        try {
            fileName = System.getProperty("user.dir")+"/src/test/java/com/jogo/automation/outputDataFiles/"+fileName+".json";
            Object obj = parser.parse(new FileReader(fileName));
            JSONObject jsonObject = (JSONObject) obj;
            JSONArray arrayJson = (JSONArray) jsonObject.get(jsonElement);
            return objJson;
        }
        catch (Exception ex){
            System.out.println(ex);
            return objJson;
        }
    }
public static int getSizeofObject(String fileName,String jsonElement,String element){
        try {
            fileName = System.getProperty("user.dir")+"/src/test/java/com/jogo/automation/outputDataFiles/"+fileName+".json";
            Object obj = parser.parse(new FileReader(fileName));
            JSONObject jsonObject = (JSONObject) obj;
            JSONObject objJson = (JSONObject) jsonObject.get(jsonElement);
            int objJsonLength = Integer.parseInt(objJson.get(element).toString());
            return objJsonLength;
        }
        catch (Exception ex){
            System.out.println(ex);
            return 0;
        }
    }
}
