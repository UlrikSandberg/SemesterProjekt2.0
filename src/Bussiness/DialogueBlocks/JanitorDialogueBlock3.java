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
public class JanitorDialogueBlock3 implements IDialogueBlock{
    
    private NPC owner;
    int DialogueBlockState = 0;
    private ArrayList<String> options = new ArrayList<>();
    private HashMap<String, Integer> caseMapping = new HashMap<>();

    public JanitorDialogueBlock3(INPC owner) {

        this.owner = (NPC) owner;
        
    }
    
    public String getIntro(Player player){
        String theString = null;
        
        if(player.isQuestComplete(owner.getCriteria())){
            
            if(owner.getCriteria().questCriteriaIsMet(player)){
                theString = "Thank you. That drink made me able to breathe again \n"
                        + "Take this dress";
                
                this.options.clear();
                
                return theString;
                
                
                
            } else{
                theString = "Criteria not met";
                
                return theString;
            }
        } else {
            theString = "Criteria not met";
            
            return theString;
        }
        
    }

    @Override
    public String dialogue(Player player) {
        return this.getIntro(player);
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
