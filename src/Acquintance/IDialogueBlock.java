/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acquintance;

import Bussiness.Player;
import java.util.ArrayList;

/**
 *
 * @author ulriksandberg
 */
public interface IDialogueBlock {
    
    public String dialogue(Player player);
    public ArrayList<String> getOptions();
    public void changeState(String answer);
    
    
    
}
