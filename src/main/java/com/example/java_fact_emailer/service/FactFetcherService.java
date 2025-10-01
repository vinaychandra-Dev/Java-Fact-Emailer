package com.example.java_fact_emailer.service;

import com.example.java_fact_emailer.model.Response;
import com.example.java_fact_emailer.model.Result;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import java.util.Random;

@Service
public class FactFetcherService {
    private final RestTemplate restTemplate = new RestTemplate();
    private final Random random = new Random();
    private final String[] intros = {"Did you know? ", "Fun Java Fact: "};
    private final String[] explanations = {"This highlights Java's strength in %s!", "Java excels in %s."};
    private final String[] contexts = {"enterprise apps", "web development"};

    public String fetchAndFormatFact() {
        String url = "https://opentdb.com/api.php?amount=1&category=18&type=multiple";
        Response response;
        try {
            response = restTemplate.getForObject(url, Response.class);
        } catch (RestClientException e) {
            System.err.println("API call failed: " + e.getMessage());
            return "Fact: Unable to fetch fact\nExplanation: API is down, try again later.";
        }
        if (response == null || response.getResults() == null || response.getResults().isEmpty()) {
            return "Fact: No fact available\nExplanation: API returned no results.";
        }
        if (response.getResponseCode() != 0) {
            return "Fact: API error\nExplanation: Error code " + response.getResponseCode();
        }
        Result result = response.getResults().get(0);
        String question = result.getQuestion() != null ? result.getQuestion() : "No question available";
        String answer = result.getCorrectAnswer() != null ? result.getCorrectAnswer() : "No answer available";
        String fact = question.startsWith("In Java")
                ? question + " It is " + answer + "."
                : "In Java, " + question.toLowerCase() + " is " + answer + ".";
        String intro = intros[random.nextInt(intros.length)];
        String context = contexts[random.nextInt(contexts.length)];
        String explanation = String.format(explanations[random.nextInt(explanations.length)], context);
        return intro + fact + "\nExplanation: " + explanation;
    }
}