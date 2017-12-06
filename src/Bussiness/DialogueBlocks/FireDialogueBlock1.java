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
public class FireDialogueBlock1 implements IDialogueBlock {
    
    private NPC owner;
    int DialogueBlockState = 0;
    private ArrayList<String> options = new ArrayList<>();
    private HashMap<String, Integer> caseMapping = new HashMap<>();

    public FireDialogueBlock1(INPC owner) {

        this.owner = (NPC) owner;
        caseMapping.put("Throw a paper into the flames", 1);
        caseMapping.put("Do nothing", 2);
        

    }

    @Override
    public String dialogue(Player player) {

        switch (DialogueBlockState) {

            case 0:
                return case0(player);
            case 1:
                return case1(player);
            case 2:
                return case2(player);

        }
        return null;
    }

    public String case0(Player player) {

        String theString = "The pile of money is ablaze";
 
        //Clean up
        this.options.clear();
        this.options.add("Throw a paper into the flames");
        this.options.add("Do nothing");
        
        
        return theString;
    }

    private String case1(Player player) {

        String theString = null;
        
        if(player.getInventory().inventoryDoesContain(owner.getItem())) {
            theString = "The paper goes up into flames, and the fire burns out";
            owner.getItem().decrementAmount(player);
            owner.changeState();
            
        } else {
            theString = "You got no paper to burn";
        }
        
        //Clean up
        this.options.clear();

        return theString;
    }

    private String case2(Player player) {
        
        String theString = null;
        
        theString = "The fire keeps burning";
        
        //Clean up
        this.options.clear();
        
        return theString;
        
    }

    @Override
    public ArrayList<String> getOptions() {
        return this.options;
    }

    @Override
    public void changeState(String answer) {
        if(answer != null) {
            this.DialogueBlockState = caseMapping.get(answer);
        }
    }
    
    
    
}
