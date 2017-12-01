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
public class BulterDialogueBlock1 implements IDialogueBlock {

    private NPC owner;
    int DialogueBlockState = 0;
    private ArrayList<String> options = new ArrayList<>();
    private HashMap<String, Integer> caseMapping = new HashMap<>();

    public BulterDialogueBlock1(INPC owner) {

        this.owner = (NPC) owner;
        caseMapping.put("Started with what?", 1);
        caseMapping.put("I can take care of myself, thankyou", 2);
        caseMapping.put("I'm no tax fraud!", 11);
        caseMapping.put("so, where do I find this archive?", 12);

    }

    public String dialogue(Player player) {

        switch (DialogueBlockState) {

            case 0:
                return this.getIntro();
            case 1:
                return this.case1();
            case 2:
                return this.case2();
            case 11:
                return this.case11();
            case 12:
                return this.case12(player);
        }
        return null;
    }

    
    public String getIntro() {

        String theString = "Hello my name is steve but everybody calls be Bulter!\n"
                + "I'm here to help you get started.\nAnswer Bulter with the following:";
        
        //Clean up
        this.options.clear();
        this.options.add("Started with what?");
        this.options.add("I can take care of myself, thankyou");
        
        return theString;

    }

    public String case1() {

        String theString = "The game of course!\nYou seem like a real tax-fraud"
                + "!\nThe rumor says that everyones Tax-papers are physically "
                + "stored in the archives.\n"
                + "If, for some wierd reason, a persons physical Tax-papers "
                + "should go missing from\nthe archives, that person will be "
                + "free of taxes for the rest of their live.\n"
                + "But you know, rumors are usually fake anyway. But what if "
                + "this one is true?\nAnswer Bulter:";
        
        //Clean
        this.options.clear();
        this.options.add("I'm no tax fraud!");
        this.options.add("so, where do I find this archive?");
        
        return theString;

    }
    
    public String case2() {
        
        String theString = "Bulter: Sure sure. I'll be here if you change your "
                + "mind.\nStopped talking to Bulter";
        
        //Clean up
        this.options.clear();
        
        return theString;
    }
    
    private String case11() {
        
        String theString = "Stopped talking to Bulter";
        
        //Clean up
        this.options.clear();
        
        return theString;
            
    }
    
    private String case12(Player player) {
        
        //Info
        String theString = "Wow, not so fast!\nInformation is not free. frankly "
                + "I've not had lunch yet and im feeling a little hungry. Please "
                + "go get me ma sandwich from the cafeteria.";
        
        //Logic
        System.out.println("Changing state, completing quest, setting quest");
        owner.changeState();
        owner.getQuest().setCompleted();
        player.setQuest(owner.getQuest());
        
        //Clean up
        this.options.clear();
        
        return theString;
                
    }

    public ArrayList<String> getOptions() {
        return this.options;
    }

    public void changeState(String i) {
        if(i != null) {
            this.DialogueBlockState = caseMapping.get(i);
        }
    }
}

