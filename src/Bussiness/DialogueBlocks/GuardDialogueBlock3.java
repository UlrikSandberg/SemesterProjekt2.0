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
 * @author phillip
 */
public class GuardDialogueBlock3 implements IDialogueBlock {

    private NPC owner;
    int DialogueBlockState = 0;
    private ArrayList<String> options = new ArrayList<>();
    private HashMap<String, Integer> caseMapping = new HashMap<>();

    public GuardDialogueBlock3(INPC owner) {

        this.owner = (NPC) owner;

    }

    public String dialogue(Player player) {

        switch (DialogueBlockState) {

            case 0:
                return this.getIntro();
        }
        return null;
    }

    public String getIntro() {

        //Info
        String theString = "He ponders whether it's worthwhile asking questions ... ";

        //Clean up
        this.options.clear();

        return theString;

    }

    public ArrayList<String> getOptions() {
        return this.options;
    }

    public void changeState(String i) {
        if (i != null) {
            this.DialogueBlockState = caseMapping.get(i);
        }
    }
}
