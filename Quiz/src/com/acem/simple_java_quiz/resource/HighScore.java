package com.acem.simple_java_quiz.resource;

import java.util.ArrayList;

public class HighScore {

    ArrayList<String> highscores = new ArrayList<String>();

    public void add_score(String player_name, Integer score) {

        highscores.add(score + "\t" + player_name);
    }

    public void show_highscore() {
        java.util.Collections.sort(highscores);
        System.out.println("\n\n\t\tHighScores");
        for (String string : highscores) {
            System.out.println(string);
        }
    }
}
