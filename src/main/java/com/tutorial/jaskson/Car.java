package com.tutorial.jaskson;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;
import org.json.simple.JSONObject;

import javax.json.Json;
import javax.json.JsonObject;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class Car {

    private String model;

    private String color;


    public Car() {
    }

    public Car(String model, String color) {
        this.model = model;
        this.color = color;
    }

    public void createJsonToFile() throws IOException {
        ObjectMapper objectMapper=new ObjectMapper();
        Car car=new Car("Renault","yellow");
        System.out.println("json as string :"+objectMapper.writeValueAsString(car));
        System.out.println("json as byte :"+objectMapper.writeValueAsBytes(car));
        objectMapper.writeValue(new File("target/car.json"), car);

    }
    public void jsonToObject() throws IOException {
        ObjectMapper objectMapper=new ObjectMapper();

        JsonObject jsonObject=Json.createObjectBuilder()
                .add("model","audi" )
                .add("color","red" )
                .build();
        //String json="{\"model\":\"audi\",\"color\":\"red\"}";
        //using string
        Car car=objectMapper.readValue(jsonObject.toString(),Car.class);
        //using file
        Car car1=objectMapper.readValue(new File("target/car.json"),Car.class);
        //using url
        Car car2=objectMapper.readValue(new URL("file:///home/symoh/workspace/stripesJacksonTutorial/target/car.json"),Car.class);

        System.out.println(car.getModel() +":"+car.getColor());
        System.out.println(car1.getModel() +":"+car1.getColor());
        System.out.println(car2.getModel() +":"+car2.getColor());
    }

    public void jsonToJsonNode () throws IOException {
        ObjectMapper objectMapper=new ObjectMapper();
        String json="{\"model\":\"tesla\",\"color\":\"white\"}";
        JsonNode jsonNode=objectMapper.readTree(json);
        System.out.println(jsonNode.get("model").asText()+" : "+jsonNode.get("color").asText());
    }
    public void jsonArrayToJavaList () throws IOException {
        ObjectMapper objectMapper=new ObjectMapper();
        String jsonArray="[{\"model\":\"tesla\",\"color\":\"white\"},{\"model\":\"audi\",\"color\":\"red\"},{\"model\":\"fiat\",\"color\":\"black\"}]";
        List<Car> carList=objectMapper
                .readValue(jsonArray,
                        new TypeReference<List<Car>>(){});
        //method one
        List<Car> myObjects = objectMapper
                .readValue(jsonArray,
                        objectMapper
                                .getTypeFactory()
                                .constructCollectionType(List.class, Car.class));
        //method two
        for(Car i:carList){
            System.out.println(i.getModel()+" : "+i.getColor());
        }
        //List<Car> myObject = Arrays.asList(ObjectMapper.readValue(jsonArray, Car[].class));

        // converting to a map
        String json="{\"model\":\"tesla\",\"color\":\"white\"}";
        Map<String, String> map = objectMapper.readValue(json, new TypeReference<Map<String,String>>(){});
        System.out.println(map.toString());

    }
}
