package com.tutorial.jaskson;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

import java.io.IOException;

public class Driver {
    public static void main(String[] args) throws IOException {
        Car car=new Car();
        car.createJsonToFile();
        car.jsonToObject();
        car.jsonToJsonNode();
        car.jsonArrayToJavaList();

        //using custom serializer
        ObjectMapper mapper = new ObjectMapper();
        SimpleModule module =
                new SimpleModule("CustomCarSerializer", new Version(1, 0, 0, null, null, null));
        module.addSerializer(Car.class, new CustomCarSerializer());
        mapper.registerModule(module);
        Car car1 = new Car("yellow", "renault");
        String carJson = mapper.writeValueAsString(car1);

        System.out.println(carJson);


        //using custom deserializer to deserialize the above serialized json
        ObjectMapper mapper1 = new ObjectMapper();
        SimpleModule module1 =
                new SimpleModule("CustomCarDeserializer", new Version(1, 0, 0, null, null, null));
        module1.addDeserializer(Car.class, new CustomCarDeserializer());
        mapper1.registerModule(module1);
        //mapper1.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        Car car2 = mapper1.readValue(carJson, Car.class);
        System.out.println(car2.getModel()+" : "+car2.getColor());

    }
}
