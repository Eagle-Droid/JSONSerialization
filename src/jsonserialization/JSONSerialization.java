package jsonserialization;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException; 
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONSerialization {
    public static void main(String[] args) throws IOException, ParseException {
        
        Person person = new Person("John Deen", 33, "313/AB"); 
        JSONObject json = new JSONObject();
        json.put("name", person.getName());
        json.put("age", person.getAge());
        json.put("pid", person.getPid());
        
        FileWriter file = new FileWriter("person.json");
        file.write(json.toJSONString());
        file.close();
        
        JSONParser parser = new JSONParser();
        JSONObject loadedObject = (JSONObject)parser.parse(new FileReader("person.json"));
        Person loadedPerson = new Person(
                loadedObject.get("name").toString(), 
                Integer.parseInt(loadedObject.get("age").toString()),
                loadedObject.get("pid").toString()
        );
        
        System.out.println("############ Loaded person ##########");
        System.out.println("Name: "+loadedPerson.getName());
        System.out.println("Age:"+loadedPerson.getAge());
        System.out.println("Pid:"+loadedPerson.getPid());
        
    }
}
