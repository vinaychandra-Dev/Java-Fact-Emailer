package com.example.model;

import com.fasterxml.jackson.annotation.JsonProperty;


public class Result {

    @JsonProperty("question")
    private  String question;

    @JsonProperty("correct_answer")
    private String correctAnswer;


    public String getQuestion(){ return question;}
    public void setQuestion(String question){ this.question = question;}
    public String getCorrectAnswer(){ return  correctAnswer;}
    public void setCorrectAnswer(String correctAnswer) { this.correctAnswer = correctAnswer;}


}

