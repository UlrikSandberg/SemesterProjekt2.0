/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acquintance;

import Bussiness.PlayerScore;
import java.util.ArrayList;

/**
 *
 * @author Markb
 */
public interface IHighScore {
    
    ArrayList<IScore> getScores();
    boolean viableForHighScore(PlayerScore playerscore);
}
