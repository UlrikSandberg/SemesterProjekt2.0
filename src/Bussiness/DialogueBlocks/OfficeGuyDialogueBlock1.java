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
public class OfficeGuyDialogueBlock1 implements IDialogueBlock {
    
    private NPC owner;
    int DialogueBlockState = 0;
    private ArrayList<String> options = new ArrayList<>();
    private HashMap<String, Integer> caseMapping = new HashMap<>();

    public OfficeGuyDialogueBlock1(INPC owner) {

        this.owner = (NPC) owner;
        caseMapping.put("Sure thing, office guy! (Accept quest)", 1);
        caseMapping.put("This seems like something you should figure out for yourself", 2);
        caseMapping.put("What kind of papers are these?", 3);
        caseMapping.put("I could probably help you out", 31);
        caseMapping.put("Sounds like you got a problem, guy", 32);

    }

    public String getIntro(){
        String theString = "Hello mr. \n" 
                + "You look like a man who wants to help a fella out\n"
                + "I got these papers from by boss. I need them destroyed\n"
                + "Could you help me out?";
        
        this.options.clear();
        this.options.add("Sure thing, office guy! (Accept quest)");
        this.options.add("This seems like something you should figure out for yourself");
        this.options.add("What kind of papers are these?");
        
        return theString;
    }
    
    public String case1(Player player){
        String theString = "You accepted the quest!";
        
        
        System.out.println("Chaning state and setting quest to player");
        owner.changeState();
        player.setQuest(owner.getQuest());
        
        this.options.clear();
        
        return theString;
    }
    
    public String case2(){
        String theString = "You rejected office guys quest";
        
        this.options.clear();
        
        return theString;
    }
    
    public String case3(){
        String theString = "Ehhrmm... I would tell you\n"
                + "But it's confidential.\n"
                + "Will yo help me?";
        
        this.options.clear();
        this.options.add("I could probably help you out");
        this.options.add("Sounds like you got a problem, guy");
        
        return theString;
    }
    
    public String case31(Player player){
        String theString = "You accepted the quest";
        
        System.out.println("Player accepted quest from OfficeGuy");
        
        this.options.clear();
        
        owner.changeState();
        player.setQuest(owner.getQuest());
        
        return theString;
    }
    
    public String case32(){
        String theString = "You rejected the quest";
        
        System.out.println("Player rejected quest");
        
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
            case 3: 
                return this.case3();
            case 31:
                return this.case31(player);
            case 32: 
                return this.case32();
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
