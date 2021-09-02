package org.example.vnbot.rest;

import org.example.vnbot.model.Humor;
import org.springframework.web.client.RestTemplate;

public class Joke {
    public static String jokeMain() {
        String uri = "https://geek-jokes.sameerkumar.website/api?format=json";
        return (new RestTemplate().getForObject(uri, Humor.class)).getJoke();
    }
}
