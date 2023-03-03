package DataReader;

import org.json.simple.JSONObject;

import java.util.Map;

import static APIToBeUsed.UsefulApi.*;
import static ConfigFiles.Factory.ConfigFactory.getConfig;

public class EnvConfig {
    public static String jsonFileType;
    public static JSONObject dataToBeUsed;
    private static final  String PathToFile = "/src/main/java/DataFiles/";
    public static String randomEmailToBeUsed = "";
    public static String randomPasswordToBeUsed = "Auto@1234";
    public static String randomUserNameToBeUsed = "";

    // Data Objects
    public static Map<String, String> LoginValidData;
    public static Map<String, String> LoginInValidData;
    public static Map<String, String> FacebookData;
    public static Map<String, String> CreateAccountInValidData;
    public static Map<String, String> CreateAccountExistingData;
    public static Map<String, String> UnregisteredAccountDetails;

    public static Map<String, String> InvalidEmailAccountDetails;

    public static Map<String, String> LoginValidData_2;

    public static void loadTestDataFile() {
        getDataBeforeSuite();
        try {
        String envFile = "";
        if(getConfig().EnvironmentType().toString().toLowerCase().equals("dev")){
            envFile = "staging";
        }
        else if(getConfig().EnvironmentType().toString().toLowerCase().equals("staging")){
            envFile = "staging";
        }
        else if(getConfig().EnvironmentType().toString().toLowerCase().equals("qa")){
            envFile = "staging";
        }
        else{
            envFile = "staging";
        }
        String fileName = envFile + "Data.json";
        jsonFileType = System.getProperty("user.dir")+ PathToFile + fileName;
        dataToBeUsed = JsonReader.getJSONDataURL(EnvConfig.jsonFileType);
        LoginValidData = JsonReader.getDataAsMap(dataToBeUsed,"LoginCredentials", "ValidAccountDetails");
        LoginInValidData = JsonReader.getDataAsMap(dataToBeUsed,"LoginCredentials", "InValidAccountDetails");
        LoginValidData_2 = JsonReader.getDataAsMap(dataToBeUsed,"LoginCredentials","ValidLoginDetails");
        UnregisteredAccountDetails = JsonReader.getDataAsMap(dataToBeUsed,"LoginCredentials","UnregisteredAccountDetails");
        InvalidEmailAccountDetails = JsonReader.getDataAsMap(dataToBeUsed,"LoginCredentials","InvalidEmailAccountDetails");
        FacebookData = JsonReader.getDataAsMap(dataToBeUsed,"CreateAccount", "FacebookAccountDetails");
        CreateAccountInValidData = JsonReader.getDataAsMap(dataToBeUsed,"CreateAccount", "InValidData");
        CreateAccountExistingData = JsonReader.getDataAsMap(dataToBeUsed,"CreateAccount", "ExistingData");
        //System.out.println(LoginValidData.get("Email"));
        }
        catch (Exception ex){
            System.out.println("Exception File Not Found");
        }
    }
    public static String getTestDataAsString(String mainObject, String identifier, String value){
        return JsonReader.fetchDataJsonObjectArrayObject(dataToBeUsed,mainObject, identifier, value);
    }
}
