/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bussiness.DialogueBlocks;

import Acquintance.IDialogueBlock;
import Acquintance.INPC;
import Bussiness.NPC;
import Bussiness.Player;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author ulriksandberg
 */
public class FireDialogueBlock2 implements IDialogueBlock{

    private NPC owner;
    int DialogueBlockState = 0;
    private ArrayList<String> options = new ArrayList<>();
    private HashMap<String, Integer> caseMapping = new HashMap<>();

    public FireDialogueBlock2(INPC owner) {

        this.owner = (NPC) owner;
        
    }
    
    
    
    @Override
    public String dialogue(Player player) {
        
        switch(DialogueBlockState) {
            case 0:
                return case0(player);
        }
        
        return null;
        
    }

    
    public String case0(Player player) {
        
        String theString = null;
        
        theString = "The fire is only ashes, and you leave it be";
        //Clean up
        this.options.clear();
        
        return theString;
        
    }
    
    
    @Override
    public ArrayList<String> getOptions() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void changeState(String answer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    
    
}
