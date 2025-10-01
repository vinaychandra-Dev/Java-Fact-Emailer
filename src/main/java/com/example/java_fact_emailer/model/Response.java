package com.example.java_fact_emailer.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class Response {
    @JsonProperty("response_code")
    private int responseCode;

    @JsonProperty("results")
    private List<Result> results;

    public int getResponseCode() { return responseCode; }
    public void setResponseCode(int responseCode) { this.responseCode = responseCode; }
    public List<Result> getResults() { return results; }
    public void setResults(List<Result> results) { this.results = results; }
}
