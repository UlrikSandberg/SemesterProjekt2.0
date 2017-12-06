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
public class JanitorDialogueBlock2 implements IDialogueBlock{
    
    private NPC owner;
    int DialogueBlockState = 0;
    private ArrayList<String> options = new ArrayList<>();
    private HashMap<String, Integer> caseMapping = new HashMap<>();

    public JanitorDialogueBlock2(INPC owner) {

        this.owner = (NPC) owner;
        caseMapping.put("Give drink", 1);
        caseMapping.put("Keep drink", 2);
        
    }
    
    public String getIntro(Player player){
        String theString = null;
        
        if(player.getQuest().contains(owner.getQuest())){
            
            if(owner.getQuest().questCriteriaIsMet(player)){
                theString = "How bout that drink";
                
                this.options.clear();
                this.options.add("Give drink");
                this.options.add("Keep drink");
                
                return theString;
                
            } else{
                theString = "My mouth is still dry, piss off!";
                
            }
               
            
        } else {
            theString = "";
        }
        return theString;
        
    }
    
    public String case1(Player player){
        String theString = "Thank you. That drink made me able to"
                + " breathe again. \n"
                + " Take this dress ";
        
        player.getInventory().removeFromInventory(owner.getQuest().getCriteria());
        owner.getQuest().setCompleted();
        owner.changeState();
        
        this.options.clear();
        
        return theString;
        
    }
    
    public String case2(){
        String theString = "";
        
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
            case 2:
                return this.case2();
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
