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
public class OfficeGuyDialogueBlock2 implements IDialogueBlock {
    
    private NPC owner;
    int DialogueBlockState = 0;
    private ArrayList<String> options = new ArrayList<>();
    private HashMap<String, Integer> caseMapping = new HashMap<>();
    
    
    public OfficeGuyDialogueBlock2(INPC owner) {

        this.owner = (NPC) owner;
        //caseMapping.put("", DialogueBlockState);

    }
    
    public String getIntro(Player player){
        System.out.println("We are allso here?");
        String theString;
        if(player.isQuestComplete(owner.getQuest()) == true){
            theString = "Thanks for helping me out with those papers.\n"
                    + " Not many people know this, but there's an archive\n"
                    + "containing all people's tax-papers in the west end og the building.\n"
                    + "If yours were to disappear, i guess you technically wouldnt have to \n"
                    + "pay your taxes..."
                    + "If anybody asks dont mention my name!"
                    + "Oh wait... you dont know my name. Bye bye";
            
            this.options.clear();
            owner.changeState();
            return theString;
            
            
            
        } else {
            theString = "How did it go with those papers?"
                    + "Complete the quest before returning to officeGuy";
            
            this.options.clear();
            return theString;
        }
    }
    
    

    @Override
    public String dialogue(Player player) {
        
        switch(DialogueBlockState){
            
            case 0:
                return getIntro(player);
        }
        
        return null;
    }
    
    

    @Override
    public ArrayList<String> getOptions() {
        return this.options;
    }

    @Override
    public void changeState(String answer) {
        if(answer != null){
            this.DialogueBlockState = caseMapping.get(answer);
        }
    }
    
}
