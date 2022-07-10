package com.acem.simple_java_quiz.resource;

import java.util.Scanner;

public class Play {
    Scanner scanner = new Scanner(System.in);
    Integer current_score = 0;
    //String player_name;

    public String ask_for_player_name() {
        System.out.println("Enter name: ");
        return scanner.nextLine();
    }

    public Integer start_game(String player_name) {
        System.out.println("\n\nthe game is starting");
        Questions questions = new Questions();
        Answers answers = new Answers();
        int no_of_ques = questions.get_no_of_questions();
        for (int i = 0; i < no_of_ques; i++) {
            System.out.println("\n");
            System.out.println(questions.getQuestion(i));
            char ans = scanner.next().charAt(0);
            if (ans == answers.getAnswer(i)) {
                System.out.println("right answer");
                current_score++;
            } else {
                System.out.println("wrong answer");
                break;
            }

            System.out.println(player_name + "\tscore:" + current_score);

        }
        System.out.println("end of for loop play.startgame()");
        return current_score;
    }
}
