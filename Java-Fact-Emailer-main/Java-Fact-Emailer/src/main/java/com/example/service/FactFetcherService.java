package com.example.service;


import com.example.model.Response;
import com.example.model.Result;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.stereotype.Service;
import java.util.Random;

import org.slf4j.Logger;


@Service
public class FactFetcherService {
    private static final Logger logger = (Logger) LoggerFactory.getLogger(FactFetcherService.class);
    private final RestTemplate restTemplate =  new RestTemplate();
    private final Random random = new Random();
    private final String[] intros = {
            "Did you know?",
            "Fun Java Fact:",
            "Here's a Java tidbit:",
            "Java Insight:",
            "Interesting Java Fact:"
    };
    private final String[] explanations = {
            "Isn't that fascinating?",
            "Pretty cool, right?"    ,
            "Java never ceases to amaze!",
            "Keep this in mind!",
            "Thought you'd find this interesting!"
    };
    private final String[] contexts = {
            "This is especially relevant for developers working with Java.",
            "A great fact to share with your fellow Java enthusiasts.",
            "Perfect for your next Java trivia night!",
            "A must-know for anyone diving into Java programming.",
            "An interesting piece of information for your coding journey."
    };

    public  String FetchJavaFacts() {

            String url = "https://opentdb.com/api.php?amount=1&category=18&type=multiple";
            Response response ;
            try {
                response = restTemplate.getForObject(url, Response.class);
                logger.info("API response: {}", response);
            }catch (RestClientException e){
                logger.error("API call failed : {}", e.getMessage());
                System.err.println("API call failed : "+e.getMessage());
                return  "Fact : Unable to fetch fact\nExplanation: API is down, try again later.";
            }

            if(response == null || response.getResults() == null || response.getResults().isEmpty()) {
                return "Fact: No fact available\nExplanation: API returned no results.";

            }
            if(response.getResponseCode() != 0){
                return "Fact: API error\nExplanation: Error code"+response.getResponseCode();
            }

            Result result = (Result) response.getResults().get(0);
            String question = result.getQuestion() != null ? result.getQuestion() : "No question available";
            String answer = result.getCorrectAnswer() != null ? result.getCorrectAnswer() : "No answer available";

            // Combining question and answer into a single fact string
             String fact = question.startsWith("In Java")
                     ? question + " It is " + answer + "."
                        : "In Java, " + question.toLowerCase() + "  is " + answer + ".";

            //Simulating AI by adding dynamic intros, explanations, and contexts
            String intro = intros[random.nextInt(intros.length)];
            String context = contexts[random.nextInt(contexts.length)];
            String explanation = String.format(explanations[random.nextInt(explanations.length)],context);
            return  intro + fact + "\nExplanation: "+ explanation;

    }
}
