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
public class ToiletDialogueBlock2 implements IDialogueBlock{
    
    private NPC owner;
    int DialogueBlockState = 0;
    private ArrayList<String> options = new ArrayList<>();
    private HashMap<String, Integer> caseMapping = new HashMap<>();

    public ToiletDialogueBlock2(INPC owner) {

        this.owner = (NPC) owner;
        caseMapping.put("Take water", 1);
        caseMapping.put("Ew no", 2);
        
        
    }
    
    public String getIntro(){
        String theString = "The toilet is clogged"
                + "\n Do you want to take some water from the toilet?";
        
        this.options.clear();
        this.options.add("Take water");
        this.options.add("Ew no");
        
        return theString;
    }
    
    public String case1(Player player){
        String theString = "You took water from the toilet "
                + "and added it to your inventory";
        
        player.getInventory().addToInventory(owner.getItem());
        owner.changeState();
        
        this.options.clear();
        
        return theString;
    }
    
    public String case2(){
        String theString = "No water was taken from the toilet";
        
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
