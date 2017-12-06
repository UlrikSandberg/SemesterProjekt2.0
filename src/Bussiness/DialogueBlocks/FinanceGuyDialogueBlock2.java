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
public class FinanceGuyDialogueBlock2 implements IDialogueBlock{
    
    private NPC owner;
    int DialogueBlockState = 0;
    private ArrayList<String> options = new ArrayList<>();
    private HashMap<String, Integer> caseMapping = new HashMap<>();

    public FinanceGuyDialogueBlock2(INPC owner) {

        this.owner = (NPC) owner;
        
     }
    
    public String getIntro(){
        String theString = "He is still just standing there. "
                + "He might be retarded. That would explain a lot";
        
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
    public void changeState(String i) {
        if(i != null){
            this.DialogueBlockState = caseMapping.get(i);
        }
    }
    
}
