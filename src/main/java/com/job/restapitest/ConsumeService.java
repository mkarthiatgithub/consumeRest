package com.job.restapitest;

import com.job.restapitest.domain.CommentTest;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.Properties;

import static com.job.restapitest.PropertiesLoader.loadProperties;

public class ConsumeService {
    Properties properties;
    WebTarget target;

    {
        try {
            properties = loadProperties("key.properties");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    WebTarget initialCall() {
        Client client = ClientBuilder.newClient();
//        target = client.target(
//                "http://api.openweathermap.org/data/2.5/forecast/daily").queryParam("cnt", "10")
//                .queryParam("mode", "json")
//                .queryParam("units", "metric")
//                .queryParam("appid", "62730eb801029234f1076b40e4e8f95b");

        target = client.target(
                "https://my-json-server.typicode.com/typicode/demo/comments");
        return target;
    }

    public Response postService() {
        CommentTest comment = new CommentTest();
        return initialCall().request(MediaType.APPLICATION_JSON).post(Entity.entity(comment, MediaType.APPLICATION_JSON));
    }

    public Response getForecast(String place) {
        return initialCall().request(MediaType.TEXT_HTML).get();

    }
}
