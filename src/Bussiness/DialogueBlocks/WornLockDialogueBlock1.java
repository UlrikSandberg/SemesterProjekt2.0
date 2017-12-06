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
import java.util.Scanner;

/**
 *
 * @author ulriksandberg
 */
public class WornLockDialogueBlock1 implements IDialogueBlock{
    
    private NPC owner;
    int DialogueBlockState = 0;
    private ArrayList<String> options = new ArrayList<>();
    private HashMap<String, Integer> caseMapping = new HashMap<>();

    public WornLockDialogueBlock1(INPC owner) {

        this.owner = (NPC) owner;
        
    }

    @Override
    public String dialogue(Player player) {
       
        switch(DialogueBlockState) {
            case 0:
                return case0(player);
            case 1:
                return case1(player);
        }
        
        
        return null;
    }

    private String case0(Player player) {
        
        String theString = null;
        
         
        
        if(player.getInventory().inventoryDoesContain(owner.getItem()) == false) {
            theString = "The door is locked and you dont have the key...";
            
            //Clean up
            this.options.clear();
            
        } else {
            
            theString = "You have the following options:";
            
            //Clean up
            this.options.clear();
            this.options.add("Unlock the door");
            this.options.add("Go Another way");
            
        }
         
        return theString;
             
    }
    
    private String case1(Player player) {
        
        String theString = null;
    
        //player.getInventory().removeFromInventory(owner.getItem());
        player.getCurrentRoom().removeExitBlock("west");
        theString = "The door is unlocked you can now go through";
        
        //Clean up
        this.options.clear();
        
        
        return theString;
    
    }
    
    private String case2(Player player) {
        
        String theString = null;
        
        theString = "You went away";
        
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
