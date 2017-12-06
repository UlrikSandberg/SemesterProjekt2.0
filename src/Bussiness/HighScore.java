/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bussiness;

import Acquintance.IHighScore;
import Acquintance.IScore;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Markb
 */
public class HighScore implements IHighScore, Serializable {
    
    ArrayList<IScore> scores;
        
    HighScore(){
        
        scores = new ArrayList<>();
        
        PlayerScore score1 = new PlayerScore("jon", 87);
        PlayerScore score2 = new PlayerScore("Mike", 6451);
        PlayerScore score3 = new PlayerScore("Harrold", 999);
        PlayerScore score4 = new PlayerScore("James", 5246);
        
        scores.add(score1);
        scores.add(score2);
        scores.add(score3);
        scores.add(score4);
    }
    
    public void viableForHighscore(PlayerScore score){
        
        scores.add(score);
        
        Collections.sort(scores, (a, b) -> a.getScore() > b.getScore() ? -1 : a.getScore() == b.getScore() ? 0 : 1);
        if(scores.size() == 5){
            scores.remove(4);
        }
        
        
        if(scores.contains(score)){
            System.out.println("You don't suck, congratz");
        }
        for(IScore p: scores){
            System.out.println(p.getName() + " " + p.getScore());
        }
        
    }

    @Override
    public ArrayList<IScore> getScores() {
        return this.scores;
    }
    
}
    

