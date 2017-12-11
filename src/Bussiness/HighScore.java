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
        
//        PlayerScore score1 = new PlayerScore("jon", 1);
//        PlayerScore score2 = new PlayerScore("Mike", 2);
//        PlayerScore score3 = new PlayerScore("Harrold", 3);
//        PlayerScore score4 = new PlayerScore("James", 4);
//        
//        scores.add(score1);
//        scores.add(score2);
//        scores.add(score3);
//        scores.add(score4);
    }
    
    public boolean viableForHighScore(PlayerScore score){
        
        scores.add(score);
        
        Collections.sort(scores, (a, b) -> a.getScore() > b.getScore() ? -1 : a.getScore() == b.getScore() ? 0 : 1);
        while(scores.size() >= 5){
            scores.remove(4);
        }
        
        for(IScore p: scores){
            System.out.println(p.getName() + " " + p.getScore());
        }
        if(scores.contains(score)){
            System.out.println("You don't suck, congratz");
            return true;
        }else{
            return false;
        }
    }

    
    public ArrayList<IScore> getScores() {
        return this.scores;
    }
    
}
    

