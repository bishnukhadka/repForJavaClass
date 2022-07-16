package com.acem.javaquiz.resource;

public  class Questions{
    String[] questions = {
        "what is the capital of Nepal\na. Kathmandu \tb. Pokhara \tc. Birjung \td. Biratnagar",
        "Who was the first person in space?\na. Yuri Gagarinl \tb. Neil Armstrong \tc. Buzz Aldrien \td. John Young",
        "Which of the following is not an international organisation?\na. FIFA \tb. NATO \tc. FBI \td. ASEAN",
        "What is the speed of sound?\na. 700 km/h \tb. 120 km/h \tc. 400 km/h \td. 1,200 km/h",
        "Which is the easiest way to tell the age of many trees?\na. To measure the width of the tree \tb. To count the rings on the trunk\tc. To count the number of leaves\td. To measure the height of the tree",
    };
    public int getNoOfQuestions()
    {
        return questions.length;
    }
    public String getQuestion(int i)
    {
        return questions[i];
    }

    
}