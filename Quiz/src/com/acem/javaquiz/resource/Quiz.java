package com.acem.javaquiz.resource;
import java.util.Scanner;

public class Quiz {
    Scanner scanner = new Scanner(System.in);
    Integer current_score = 0;
    //String player_name;

    public String askPlayerName() {
        System.out.println("Enter name for new player: ");
        return scanner.nextLine();
    } 

    public Integer start_game(String player_name) {
        System.out.println("\n\nthe game is starting");
        Questions questions = new Questions();
        Answers answers = new Answers();
        int no_of_ques = questions.getNoOfQuestions();
        for (int i = 0; i < no_of_ques; i++) {
            //System.out.println("\nlevel %d",i);
            System.out.format("\nlevel {%d}\n",i+1);
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
