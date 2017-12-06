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
public class JanitorDialogueBlock1 implements IDialogueBlock {
    
    private NPC owner;
    int DialogueBlockState = 0;
    private ArrayList<String> options = new ArrayList<>();
    private HashMap<String, Integer> caseMapping = new HashMap<>();

    public JanitorDialogueBlock1(INPC owner) {

        this.owner = (NPC) owner;
        caseMapping.put("You can eat it if you want to???", 1);
        caseMapping.put("You are weird", 2);
        caseMapping.put("Sure thing", 11);
        caseMapping.put("Nah", 12);
    }
    
    public String getIntro(Player player){
        String theString = null;
        
        if(player.getInventory().inventoryDoesContain(owner.getItemCriteria())){
            theString = "Hello i am the janitor of this place"
                    + "Grrr i see you have that yummy paper";
            
            this.options.clear();
            this.options.add("You can eat it if you want to???");
            this.options.add("You are weird");
            
            return theString; 
        }else{
            theString = "Hello i am the janitor of this place";
            
            this.options.clear();
            
            return theString;
        }
    }
    
    public String case1(Player player){
        String theString = "Munch munch gulp gulp"
                + "\n That paper really made my throat dry. \n"
                + "Could you get me drink?";
        
        owner.getItemCriteria().setAmount(owner.getItemCriteria().getAmount() - 1);
        this.options.clear();
        this.options.add("Sure thing");
        this.options.add("Nah");
        
        return theString;
    }
    
    public String case11(Player player){
        String theString = "You accepted the quest!";
        
        owner.getQuest().setInitialized();
        player.setQuest(owner.getQuest());
        owner.changeState();
        
        this.options.clear();
        
        return theString;
    }
    
    public String case12(){
        String theString = "I might die then... but whatever";
        
        this.options.clear();
        
        return theString;
    }
    
    

    @Override
    public String dialogue(Player player) {
        
        switch(DialogueBlockState){
            case 0:
                return this.getIntro(player);
            case 1:
                return this.case1(player);
            case 11:
                return this.case11(player);
            case 12:
                return this.case12();
        }
        return null;
    }

    @Override
    public ArrayList<String> getOptions() {
        return this.options;
    }

    @Override
    public void changeState(String answer) {
        if (answer != null) {
            this.DialogueBlockState = caseMapping.get(answer);
        }
    }
    
}
