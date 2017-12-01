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
public class BulterDialogueBlock3 implements IDialogueBlock {

    private NPC owner;
    int DialogueBlockState = 0;
    private ArrayList<String> options = new ArrayList<>();
    private HashMap<String, Integer> caseMapping = new HashMap<>();
    
    
    public BulterDialogueBlock3(INPC owner) {
        
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

    @Override
    public ArrayList<String> getOptions() {
        return this.options;
    }

    @Override
    public void changeState(String answer) {
        DialogueBlockState = caseMapping.get(answer);
    }
    
    
    public String case0(Player player) {
        
        String theString = "I dont wanna talk to you, tax-fraud!";
        
        //Clean up
        this.options.clear();
        
        return theString;
        
    }
    
}
