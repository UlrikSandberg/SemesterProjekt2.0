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
public class TalkingToiletDialogueBlock2 implements IDialogueBlock{
    
    private NPC owner;
    int DialogueBlockState = 0;
    private ArrayList<String> options = new ArrayList<>();
    private HashMap<String, Integer> caseMapping = new HashMap<>();

    public TalkingToiletDialogueBlock2(INPC owner) {

        this.owner = (NPC) owner;
        
    }
    
    public String getIntro(){
        String theString = "The toilet is all clogged up with your tax-papers\n"
                + "It doesn't seem to wanna talk to you anymore";
        
        this.options.clear();
        
        return theString;
    }
    @Override
    public String dialogue(Player player) {
        return this.getIntro();
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
