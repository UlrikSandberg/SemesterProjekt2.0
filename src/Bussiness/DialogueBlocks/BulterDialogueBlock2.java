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
public class BulterDialogueBlock2 implements IDialogueBlock {

    private NPC owner;
    int DialogueBlockState = 0;
    private ArrayList<String> options = new ArrayList<>();
    private HashMap<String, Integer> caseMapping = new HashMap<>();

    public BulterDialogueBlock2(INPC owner) {

        this.owner = (NPC) owner;
        caseMapping.put("No, I don't know where to get it.", 1);
        caseMapping.put("Of course! Now where is the archive?", 2);

    }

    @Override
    public String dialogue(Player player) {

        switch (DialogueBlockState) {

            case 0:
                return getIntro(player);

            case 1:
                return case1();
            case 2:
                return case2(player);

        }

        return null;
    }

    public String getIntro(Player player) {

        String theString = "So, do you have my sandwitch?\nAnswer Bulter:";

        //Clean
        this.options.clear();
        this.options.add("No, I don't know where to get it.");
        this.options.add("Of course! Now where is the archive?");

        return theString;
    }

    private String case1() {

        String theString = "I don't see this as a hard task. A sandwitch is found in the cafeteria...\n"
                + "I'm not telling you anything before I've had something to eat.";

        //Clean
        this.options.clear();

        return theString;

    }

    private String case2(Player player) {

        String theString = null;

        if (player.getQuest().contains(owner.getCriteria()) == true) {

            if(owner.getCriteria().questCriteriaIsMet(player) == true) {
                player.getInventory().removeFromInventory(owner.getItemCriteria());
                owner.changeState();
                theString = "I just love tuna sandwitches!\nAs for the archive. "
                        + "I don't know where exactly it is but it's somewhere "
                        + "in this building.\nSomeone in the office might know "
                        + "something\nHope it helps!";
                
                   
            }
        } else {
            theString = "as long as you don't have the sandwich for me me, you don't get any info!";
        }
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
        if (answer != null) {
            this.DialogueBlockState = caseMapping.get(answer);
        }
    }
}
