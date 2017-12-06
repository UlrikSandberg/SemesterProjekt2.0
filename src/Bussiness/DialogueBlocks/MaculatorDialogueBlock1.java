/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bussiness.DialogueBlocks;

import Acquintance.IDialogueBlock;
import Acquintance.INPC;
import Bussiness.IDialogue;
import Bussiness.NPC;
import Bussiness.Player;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Justus
 */
public class MaculatorDialogueBlock1 implements IDialogueBlock {
    
    private NPC owner;
    int DialogueBlockState = 0;
    private ArrayList<String> options = new ArrayList<>();
    private HashMap<String, Integer> caseMapping = new HashMap<>();

    public MaculatorDialogueBlock1(INPC owner) {

        this.owner = (NPC) owner;
        caseMapping.put("Maculate papers", 1);
        caseMapping.put("Leave", 2);

    }
    
    public String getIntro(Player player){
        
        if(player.getQuest().contains(owner.getCriteria())){
        String theString = "Beep Boop Beep!";
        
        this.options.clear();
        this.options.add("Maculate papers");
        this.options.add("Leave");
        
        return theString;
        }
        String theString = "Beep Boop Beep!";
        
        return theString;
    }
    
    public String case1(Player player){
        
        if(player.getInventory().inventoryDoesContain(owner.getItemCriteria())){
            owner.getCriteria().setCompleted();
            String theString = "The papers are gone \n Magic...";
            owner.changeState();
            this.options.clear();
            return theString;
        } else{
            String theString = "You dont have the right papers";
            this.options.clear();
            return theString;
        }
        
    }
    
    public String case2(){
        String theString = "You left";
        
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
        if(answer != null) {
            this.DialogueBlockState = caseMapping.get(answer);
        }
    }
    
}
