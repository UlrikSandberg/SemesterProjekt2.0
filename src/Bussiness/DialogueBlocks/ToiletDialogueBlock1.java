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
public class ToiletDialogueBlock1 implements IDialogueBlock {
    
    private NPC owner;
    int DialogueBlockState = 0;
    private ArrayList<String> options = new ArrayList<>();
    private HashMap<String, Integer> caseMapping = new HashMap<>();

    public ToiletDialogueBlock1(INPC owner) {

        this.owner = (NPC) owner;
        caseMapping.put("Flush a paper down the toilet", 1);
        caseMapping.put("Use the toilet like it was meant to be used", 2);
        caseMapping.put("Leave the toilet", 3);
        
    }
    
    public String getIntro(){
        String theString = "This toilet seems like it would have great flusing";
        
        this.options.clear();
        this.options.add("Flush a paper own the toilet");
        this.options.add("Use the toilet like it was meant to be used");
        this.options.add("Leave the toilet");
        
        return theString;
        
    }
    
    public String case1(){
        String theString = "You flush a paper"
                + "\n The toilet is now clogged";
        
        this.options.clear();
        owner.getItem().setAmount(owner.getItem().getAmount() - 1);
        owner.changeState();
        
        return theString;
    }

    @Override
    public String dialogue(Player player) {
        switch(DialogueBlockState){
            case 0:
                return this.getIntro();
            case 1: 
                return this.case1();
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
