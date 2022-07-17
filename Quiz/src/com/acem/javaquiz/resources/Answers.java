package com.acem.javaquiz.resources;

public class Answers{
    char[] answers = {
        'a', 'a' , 'c' ,'d' , 'b'
    };

    public char getAnswer(int i)
    {   
        return answers[i];
    }
}