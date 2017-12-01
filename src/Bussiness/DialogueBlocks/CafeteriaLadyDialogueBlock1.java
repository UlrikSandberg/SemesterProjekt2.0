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
public class CafeteriaLadyDialogueBlock1 implements IDialogueBlock {

    private NPC owner;
    int DialogueBlockState = 0;
    private ArrayList<String> options = new ArrayList<>();
    private HashMap<String, Integer> caseMapping = new HashMap<>();

    public CafeteriaLadyDialogueBlock1(INPC owner) {

        this.owner = (NPC) owner;
        caseMapping.put("The guy in the lobby aksed me to get a sandwich. Do you have one?", 1);
        caseMapping.put("I don't need anything right now.", 2);

    }

    @Override
    public String dialogue(Player player) {

        switch (DialogueBlockState) {

            case 0:
                return case0(player);
            case 1:
                return case1(player);
            case 2:
                return case2(player);

        }
        return null;
    }

    public String case0(Player player) {

        String theString = "I am the cafeteria lady!";
        if (player.isQuestComplete(owner.getCriteria()) == true) {
            theString += "\nWhat can I help you with?\nAnswer the cafeteriaLady";
            //Clean up
            this.options.clear();
            this.options.add("The guy in the lobby aksed me to get a sandwich. Do you have one?");
            this.options.add("I don't need anything right now.");
        } else {
            //Clean up
            this.options.clear();
            theString += "You are not permitted to buy from me";
        }

        
        

        return theString;
    }

    public String case1(Player player) {

        String theString = "sure! Here you go. I'll jut put it on his tap.";

        owner.changeState();
        player.getInventory().addToInventory(owner.getItem());
        owner.getQuest().setInitialized();
        player.setQuest(owner.getQuest());

        theString += "\nYou just recieved a sandwich.";

        //Clean up
        this.options.clear();

        return theString;
    }

    public String case2(Player player) {
        String theString = "Oh, okay. Then why would you talk to me?";
        
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


