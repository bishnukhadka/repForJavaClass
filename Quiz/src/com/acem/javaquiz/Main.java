package com.acem.javaquiz;

import java.util.Scanner;

import com.acem.javaquiz.resource.Mainmenu;
import com.acem.javaquiz.resource.HighScore;
import com.acem.javaquiz.resource.Quiz;
import com.acem.javaquiz.resource.Questions;

public class Main {
    public static void main(String[] args) {
        HighScore highscore = new HighScore();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            Mainmenu.showMainMenu();
            char choice = scanner.next().charAt(0);
            if (choice == 'a' || choice == 'A') {
            playGame();
                

            } else if (choice == 'b' || choice == 'B') {
                highscore.showHighscore();
            } else if (choice == 'c') {
                System.out.println("end");
                System.exit(0);
            } else {
                System.out.println("invalid choice. press again.");

            }
        }
        
    }

    public static void playGame() {
        HighScore highscore = new HighScore();
        Questions questions = new Questions();
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            Quiz play = new Quiz();
            String playerName = play.askPlayerName();
            Integer score = play.start_game(playerName);
            highscore.addScore(playerName, score);
            highscore.showHighscore();
            if (score == questions.getNoOfQuestions()) {
                System.out.println("\n\nCongratulations you have reached the end.");
            }
            System.out.println("\nPress p to play again and other to exit.");
            char a = scanner.next().charAt(0);

                if (a != 'p') {
                    System.out.println("ending game.");
                    System.exit(0);
                }

        }
        
        
    }
}