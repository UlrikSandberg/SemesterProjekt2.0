/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bussiness;

import Acquintance.IScore;
import java.io.Serializable;



/**
 *
 * @author Markb
 */
public class PlayerScore implements IScore, Serializable{
    
    private String name;
    private double score;

    
    PlayerScore(String name, double score){
        this.name = name;
        this.score = score;
    }
    
    public double getScore(){
        return score;
    }
    
    public String getName(){
        return name;
    }
    
    @Override
    public String toString(){
        return name + " " + score;
    }

    
}
