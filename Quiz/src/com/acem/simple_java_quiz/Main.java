package com.acem.simple_java_quiz;
import java.util.Scanner;

import com.acem.simple_java_quiz.resource.Mainmenu;
import com.acem.simple_java_quiz.resource.HighScore;
import com.acem.simple_java_quiz.resource.Play;
import com.acem.simple_java_quiz.resource.Questions;

public class Main {
    public static void main(String[] args) {
        Mainmenu mainmenu = new Mainmenu();
        HighScore highscore = new HighScore();
        Questions questions = new Questions();
        Play play = new Play();
        String player_name;
        Integer score;
        mainmenu.show_main_menu();

        Scanner scanner = new Scanner(System.in);
        char choice = scanner.next().charAt(0);

        if (choice == 'a' || choice == 'A') {
            while(true){
                //debug
            System.out.println("/////////start of while loop////////");
            
            player_name = play.ask_for_player_name();
            score = play.start_game(player_name);
            highscore.add_score(player_name, score);
            highscore.show_highscore();
            

            System.out.println("\nPress p to play again and other to exit.");
            char a=scanner.next().charAt(0);
            
            if(a != 'p')
            {
                System.out.println("insde while if clause");
                break;
            }

            }
            if (score == questions.get_no_of_questions())
                System.out.println("\n\nCongratulations you have reached the end.");
        } else if (choice == 'b' || choice == 'B') {
            highscore.show_highscore();
        } else if (choice == 'e') {
            System.out.println("end");
        } else {
            System.out.println("invalid choice. press again.");
        }

        scanner.close();
    }

}

/*problem
 * 
 * while starting the game for 2nd time, scanner does not input 
 * the player name, instead takes "return key" or "null" as 
 * its input.
 */