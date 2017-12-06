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
 * @author Justus
 */
public class FinanceGuyDialogueBlock1 implements IDialogueBlock {
    
    private NPC owner;
    int DialogueBlockState = 0;
    private ArrayList<String> options = new ArrayList<>();
    private HashMap<String, Integer> caseMapping = new HashMap<>();

    public FinanceGuyDialogueBlock1(INPC owner) {

        this.owner = (NPC) owner;
        caseMapping.put("Steal the keycard", 1);
        caseMapping.put("Leave him alone with his starring", 2);
     }
    
    public String getIntro(){
        String theString = "He just keeps starring at the fire."
        + "He doesn't seem to be affected by your presence."
        + "You see a keycard hanging out of his backpocket";
        
        this.options.clear();
        this.options.add("Steal the keycard");
        this.options.add("Leave him alone with his starring");
        
        return theString;
    }
    
    public String case1(Player player){
        
        if(player.getInventory().addToInventory(owner.getItem())){
            String theString = "You grab the keycard without him noticing or caring"
            + "\n Key added to inventory";
            
            owner.changeState();
            this.options.clear();
            
            return theString;
        } else {
            String theString = "You dont have enough space for the key";
            
            this.options.clear();
            return theString;
        }
    }
    
    public String case2(Player player){
        String theString = "He keeps standing there senselesly starring into the fire";
        
        this.options.clear();
        return theString;
    }

    @Override
    public String dialogue(Player player) {
        switch(DialogueBlockState){
            case 0:
                return this.getIntro();
            case 1: 
                return this.case1(player);
            case 2: 
                return this.case2(player);
        }
        return null;
    }

    @Override
    public ArrayList<String> getOptions() {
        return this.options;
    }

    @Override
    public void changeState(String i) {
        if(i != null){
            this.DialogueBlockState = caseMapping.get(i);
        }
    }
    
}
