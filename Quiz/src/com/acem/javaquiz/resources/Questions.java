package com.acem.javaquiz.resources;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Questions {
    // String[] questions = {
    // "what is the capital of Nepal\na. Kathmandu \tb. Pokhara \tc. Birjung \td.
    // Biratnagar",
    // "Who was the first person in space?\na. Yuri Gagarinl \tb. Neil Armstrong
    // \tc. Buzz Aldrien \td. John Young",
    // "Which of the following is not an international organisation?\na. FIFA \tb.
    // NATO \tc. FBI \td. ASEAN",
    // "What is the speed of sound?\na. 700 km/h \tb. 120 km/h \tc. 400 km/h \td.
    // 1,200 km/h",
    // "Which is the easiest way to tell the age of many trees?\na. To measure the
    // width of the tree \tb. To count the rings on the trunk\tc. To count the
    // number of leaves\td. To measure the height of the tree",
    // };
    List<String> questions = new ArrayList<String>();
    List<String> answers = new ArrayList<String>();

    // public Questions() {
    //     String file = "src/com/acem/javaquiz/resources/Questions.txt";
    //     String temp = " ";
    //     try {
    //         Scanner scanner = new Scanner(new File(file));
    //         scanner.useDelimiter("::");
    //         int j = 1;
    //         while (scanner.hasNext()) {

    //             String next = scanner.next();
    //             temp += next;
    //             System.out.println("\nnow temp is: " + temp);
    //             // System.out.println(j+ " = " + next);
    //             if (j % 6 == 0) {
    //                 // System.out.println(j + "divisible by 6\n");
    //                 questions.add(temp);
    //                 answers.add(next);
    //                 System.out.println(next + " added in answers\n");
    //                 temp = " ";
    //             }
    //             j++;
    //         }

    //     } catch (Exception ex) {
    //         System.out.println(ex.toString());
    //     }
    // }

    public static void loadQuestions()
    {
        String file = "src/com/acem/javaquiz/resources/Questions.txt";
        String temp = " ";
        try {
            Scanner scanner = new Scanner(new File(file));
            scanner.useDelimiter("::");
            int j = 1;
            while (scanner.hasNext()) {

                String next = scanner.next();
                temp += next;
                System.out.println("\nnow temp is: " + temp);
                // System.out.println(j+ " = " + next);
                if (j % 6 == 0) {
                    // System.out.println(j + "divisible by 6\n");
                    questions.add(temp);
                    answers.add(next);
                    System.out.println(next + " added in answers\n");
                    temp = " ";
                }
                j++;

            }

        } catch (Exception ex) {
            System.out.println(ex.toString());
        }       
    }

    public int getNoOfQuestions() {
        return questions.size();
    }

    public String getQuestion(int i) {
        return questions.get(i);
    }

}