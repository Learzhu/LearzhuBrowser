package com.learzhu.browser.test.json;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * JacksonTest.java是液多多的类。
 *
 * @author Learzhu
 * @version 2019-12-27 13:09
 * @update Learzhu 2019-12-27 13:09
 * @updateDes
 * @include {@link }
 * @used {@link }
 */
public class JacksonTest {
    public static void main(String args[]) {
        ObjectMapper objectMapper = new ObjectMapper();
        String carJson =
//                "{ \"brand\" : \"Mercedes\", \"doors\" : 5 }";
                "{ \"brand\" : \"Mercedes\", \"doors\" : \" 5 - 3\" }";
        try {
            Car car = objectMapper.readValue(carJson, Car.class);
            System.out.println("car brand = " + car.getBrand());
            System.out.println("car doors = " + car.getDoors());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

