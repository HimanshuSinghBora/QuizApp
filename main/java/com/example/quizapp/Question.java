package com.example.quizapp;

public class Question {
    private int answerResId;

    // answerTrue will store correct answer
    // of the question provided
    private char answerTrue;

    public Question(int answerResId, char answerTrue)
    {
        // setting the values through
        // arguments passed in constructor
        this.answerResId = answerResId;
        this.answerTrue = answerTrue;
    }

    // returning the question passed
    public int getAnswerResId()
    {
        return answerResId;
    }

    // setting the question passed
    public void setAnswerResId(int answerResId)
    {
        this.answerResId = answerResId;
    }

    // returning the correct answer
    // of question
    public char isAnswerTrue()
    {
        return answerTrue;
    }

    // setting the correct
    // ans of question
    public void setAnswerTrue(char answerTrue)
    {
        this.answerTrue = answerTrue;
    }
}
