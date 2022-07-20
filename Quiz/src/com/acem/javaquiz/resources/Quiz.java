package com.acem.javaquiz.resources;
import java.util.Scanner;
import java.time.LocalTime;

public class Quiz {
    Scanner scanner = new Scanner(System.in);
    Integer currentScore = 0;
    //String player_name;

    public String askPlayerName() {
        System.out.println("Enter name for new player: ");
        return scanner.nextLine();
    } 

    public Integer start_game(String player_name) {
        System.out.println("\n\nthe game is starting");
        //Answers answers = new Answers();
        int no_of_ques = Questions.getNoOfQuestions();
        for (int i = 0; i < no_of_ques; i++) {
            //System.out.println("\nlevel %d",i);
            System.out.format("\n\nlevel {%d}\n",i+1);
            // System.out.println(Questions.getQuestion());
            int j = Questions.getQuestion();
            System.out.print("Your Ans: ");
            String ans = scanner.nextLine();
            LocalTime nowTime = LocalTime.now();
            if (ans.equals(Questions.getAnswer(j))) {
                System.out.println("right answer");
                currentScore = calculateScore(currentScore, nowTime);
            } else {
                System.out.println("wrong answer");
                break;
            }
            System.out.println(player_name + ":\tscore:" + currentScore);
        }
        return currentScore;
    }
    private int calculateScore(int currentScore, LocalTime nowTime)
    {
        return ++currentScore;
    }
}
