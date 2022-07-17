package com.acem.javaquiz.resource;

import java.util.List;

import java.util.ArrayList;

public class HighScore {

    List<String> highscores = new ArrayList<String>();

    public void addScore(String player_name, Integer score) {

        highscores.add(score + "\t" + player_name);
    }
    
    public void showHighscore() {
        java.util.Collections.reverse(highscores);
        System.out.println("\n\n\t\tHighScores");
        int size = highscores.size();
        if(size ==0)
        {
            System.out.println("No highscore made yet. Be the first one.");
            return;
        }
        if(size <= 5)
        {
            for (String string : highscores) {
                System.out.println(string);
            }
        }
        else
            showTop5Highscore();
    }

    public void showTop5Highscore() {
        System.out.println("\n\n\t\tHighScores");
        for(int i=0; i<5; i++){
            System.out.println(highscores.get(i));
        }
    }
}
