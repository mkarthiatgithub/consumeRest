package com.job.restapitest;

import com.job.restapitest.domain.CommentTest;

import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import java.util.List;

public class App {
    public static void main(String[] args) {
        ConsumeService consumeService = new ConsumeService();
        Response postResponse = consumeService.postService();
        Response getResponse = consumeService.getForecast("London");
        final List<CommentTest> result = getResponse.readEntity(new GenericType<List<CommentTest>>() {
        });
        result.stream().forEach(s -> System.out.println(s));

        try {
            if (postResponse.getStatus() != 201) {
                throw new RuntimeException("Failed with HTTP error code : " + postResponse.getStatus());
            }
            System.out.println("Successfully got result: " + postResponse.toString());

            System.out.println("Successfully got result: " + postResponse.readEntity(CommentTest.class).toString());
        } finally {
            postResponse.close();
        }
    }
}
