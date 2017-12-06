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
public class TalkingToiletDialogueBlock1 implements IDialogueBlock{
    
    private NPC owner;
    int DialogueBlockState = 0;
    private ArrayList<String> options = new ArrayList<>();
    private HashMap<String, Integer> caseMapping = new HashMap<>();

    public TalkingToiletDialogueBlock1(INPC owner) {

        this.owner = (NPC) owner;
        caseMapping.put("Shut that toilet. (Stick a paper down its throat", 1);
        caseMapping.put("You feel like doing some manly toilet-stuff", 2);
        caseMapping.put("Fart", 3);
        caseMapping.put("Burp",  4);

    }
    
    public String getIntro(Player player){
        
        String theString = null;
            
            if(player.getInventory().inventoryDoesContain(owner.getItem())){
                theString = "The toilet flushes, and it smells like flowers..."
                        + "Hello miss. Welcome back to the magical and "
                        + "wonderful realm of women's toilets"
                        + "Would you like a massage for todays treatment?";
                
            this.options.clear();
            this.options.add("Shut that toilet. (Stick a paper down its throat");
            this.options.add("You feel like doing some manly toilet-stuff");
            
            return theString; 
            
        }else 
            theString = "Welcome to the magical realm of womens toilets";
            
            this.options.clear();
            this.options.add("Fart");
            this.options.add("Burp");
            
            return theString;
     }
    
    
    
    public String case1(Player player){
        String theString = "*You stick a paper own the toilet"
                + "What *mrrlgrlm* are you doing?!"
                + "You're no *mrgmlrg* woman!";
        
        owner.getItem().setAmount(owner.getItem().getAmount() - 1);
        owner.changeState();
        
        this.options.clear();
        
        return theString;
    }
    
    public String case2(){
        String theString = "Phew it smells in here...";
        
        this.options.clear();
        
        return theString;
    }
    
    public String case3(){
        String theString = "You make a humongous fart\n "
                + "The talking toilet is speechless";
        
        this.options.clear();
        
        return theString;
    }
    
    public String case4(){
        String theString = "You burp in the womens toilet. Take that, women";
        
        this.options.clear();
        
        return theString;
    }

    @Override
    public String dialogue(Player player) {
        
        switch(DialogueBlockState){
            case 0:
                return this.getIntro(player);
            case 1:
                return this.case1(player);
            case 2:
                return this.case2();
            case 3:
                return this.case3();
            case 4: 
                return this.case4();
        }
        return null;
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
