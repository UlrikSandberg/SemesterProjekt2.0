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
public class OfficeGuyDialogueBlock3 implements IDialogueBlock{

    private NPC owner;
    int DialogueBlockState = 0;
    private ArrayList<String> options = new ArrayList<>();
    private HashMap<String, Integer> caseMapping = new HashMap<>();

    public OfficeGuyDialogueBlock3(INPC owner) {

        this.owner = (NPC) owner;
        caseMapping.put("Yeah the door is locked", 1);
        caseMapping.put("No i've just been wandering around...", 2);
    }
    
    public String getIntro(){
        String theString = "Did you check those archives for your tax papers?\n";
        
        this.options.clear();
        this.options.add("Yeah the door is locked");
        this.options.add("No i've just been wandering around...");
        
        return theString;
    }
    
    public String case1(){
        String theString = "Oh it was locked? You'll need a keycard then\n"
                + "I bet you can find a keycard somewhere around here...";
        
        this.options.clear();
        
        return theString;
    }
    
    public String case2(){
        String theString = "You should definitely go find those archives";
        
        this.options.clear();
        
        return theString;
    }
    
    @Override
    public String dialogue(Player player) {
        
        switch(DialogueBlockState){
            
            case 0:
                return this.getIntro();
            case 1:
                return this.case1();
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
    public void changeState(String i) {
        if(i != null){
            this.DialogueBlockState = caseMapping.get(i);
        }
    }
    
}
