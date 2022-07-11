package com.acem.simple_java_quiz.resource;

public class Answers{
    char[] answers = {
        'a', 'a' , 'c' ,'d' , 'b'
    };

    public char getAnswer(int i)
    {   
        return answers[i];
    }
}