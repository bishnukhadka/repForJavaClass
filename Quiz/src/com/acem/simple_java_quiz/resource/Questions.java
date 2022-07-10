package com.acem.simple_java_quiz.resource;

public class Questions{
    String[] questions = {
        "what is the capital of Nepal\na. Kathmandu \tb. Pokhara \tc. Birjung \td. Biratnagar",
        "what is the capital of Nepal\na. Kathmandu \tb. Pokhara \tc. Birjung \td. Biratnagar",
        "what is the capital of Nepal\na. Kathmandu \tb. Pokhara \tc. Birjung \td. Biratnagar",
        "what is the capital of Nepal\na. Kathmandu \tb. Pokhara \tc. Birjung \td. Biratnagar",
        "what is the capital of Nepal\na. Kathmandu \tb. Pokhara \tc. Birjung \td. Biratnagar",
    };
    public int get_no_of_questions()
    {
        return questions.length;
    }
    public String getQuestion(int i)
    {
        return questions[i];
    }

    
}