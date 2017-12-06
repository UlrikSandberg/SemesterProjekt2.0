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
import Bussiness.Score;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Justus
 */
public class TaxManDialogueBlock1 implements IDialogueBlock{
    
    private NPC owner;
    int DialogueBlockState = 0;
    private ArrayList<String> options = new ArrayList<>();
    private HashMap<String, Integer> caseMapping = new HashMap<>();

    public TaxManDialogueBlock1(INPC owner) {

        this.owner = (NPC) owner;
        caseMapping.put("How do i get my tax papers?", 1);
        caseMapping.put("Yes", 11);
        caseMapping.put("No", 12);
        caseMapping.put("The amount of hairs on your head", 111);
        caseMapping.put("The amount of taxes you pay", 112);
        caseMapping.put("The amount of hairs on your head", 121);
        caseMapping.put("The amount of taxes you pay", 122);
        caseMapping.put("The amount of hairs on your head", 131);
        caseMapping.put("The amount of taxes you pay", 132);

    } 
    
    public String getIntro(Player player){
        String theString = "Why hello there young traveller. I am the master of taxes"
                + " and this is my humble abode \n I have lived for many centuries, and"
                + " have seen al corners of the world. \n I have chosen, from all the "
                + " places in the world, to live in these archives at SKAT. \n"
                + " It is from here i rob the people of their money through manipulating "
                + " your government and making you pay me money \n Much like your monarchs."
                + "\n How may i help you?";
       
        this.options.clear();
        this.options.add("How do i get my tax papers?");
        
        return theString;
        
    }
    
    public String case1(){
        String theString = "It is true. I hold all tax-papers of the people "
                + "of your country."
                + "I can give you yours, but in order for me to do so. You will have to"
                + " answer me some riddles"
                + "If you can give me the right answer i give you your papers. If not, "
                + "you'll probably just lose some score"
                + "Do you accept?";
        
        this.options.clear();
        this.options.add("Yes");
        this.options.add("No");
        
        return theString;
               
    }
    
    public String case11(Player player){
        String theString = "Nope..."
                + "You receive a penalty of 50 points"
                + "What increases in value, and never decreases?";
                
                
        //Penalty of -50 points from score since your answer was wrong
        player.getScore().decrementScore(50);
        
        this.options.clear();
        this.options.add("The amount of hairs on your head");
        this.options.add("The amount of taxes you pay");
        
        return theString;
    }
    
    public String case111(Player player){
        String theString = "No.. I'm quite sure you lose hair during your life."
                + "You receive a penalty of 50 points"
                + "Anywho.. I can't be bothered with any more riddles."
                + "My ancient brain is getting tired of your nonsense."
                + "Take your papers and leave me"
                + "You receive " + owner.getItem().getAmount() + " tax papers"
                + "Maybe someone in this building can help you get rid of them";
                
                
        //Penalty of -50 points from score since the answer was wrong
        player.getScore().decrementScore(50);
        //add 5 papers to players inventory
        player.getInventory().addToInventory(owner.getItem());
        //Change state to SecondContact
        owner.changeState();
        
        this.options.clear();
        
        return theString;
    }
    
    public String case112(Player player){
        String theString = "Myeeees... That's exactly correct!"
                + "You can have your papers. Here you go"
                + "You recieve 5 tax papers."
                + "Maybe someone in this building can help you get rid of them" ;
                
                
        //Add 5 papers to inventory
        player.getInventory().addToInventory(owner.getItem());
        //Change state to secondContact
        owner.changeState();  
        
        this.options.clear();
        
        return theString;
    }
    
    public String case12(){
        String theString = "That's exactly correct! Next riddle..."
                + " "
                + "What increases in value, and never decreases?";
                
        
        this.options.clear();
        this.options.add("The amount of hairs on your head");
        this.options.add("The amount of taxes you pay");
        
        return theString;
    }
    
    public String case121(Player player){
        String theString ="No.. I'm quite sure you lose hair during your life."
                + "You receive a penalty of 50 points"
                + "Anywho.. I can't be bothered with any more riddles."
                + "My ancient brain is getting tired of your nonsense."
                + "Take your papers and leave me"
                + "You receive 5 tax papers"
                + "Maybe someone in this building can help you get rid of them";
                
        //Penalty of -50 points from score since the answer was wrong
        player.getScore().decrementScore(50);
        //add 5 papers to players inventory
        player.getInventory().addToInventory(owner.getItem());
        //Change state to SecondContact
        owner.changeState();
        
        this.options.clear();
        
        return theString;
    }
    
    public String case122(Player player){
        String theString ="Myeeees... That's exactly correct!"
                + "You can have your papers. Here you go"
                + "You recieve 5 tax papers."
                + "Maybe someone in this building can help you get rid of them";
        

        //Add 5 papers to inventory
        player.getInventory().addToInventory(owner.getItem());
        //Change state to secondContact
        owner.changeState();
        
        this.options.clear();
        
        return theString;
    
    }
    
    public String case13(Player player){
        String theString = "Nope..."
                + "You receive a penalty of 50 points"
                + "What increases in value, and never decreases?";
                
                
        player.getScore().decrementScore(50);
        
        this.options.clear();
        this.options.add("The amount of hairs on your head");
        this.options.add("The amount of taxes you pay");
        
        return theString;
    }
    
    public String case131(Player player){
        String theString = "No.. I'm quite sure you lose hair during your life."
                + "You receive a penalty of 50 points"
                + "Anywho.. I can't be bothered with any more riddles."
                + "My ancient brain is getting tired of your nonsense."
                + "Take your papers and leave me"
                + "You receive 5 tax papers"
                + "Maybe someone in this building can help you get rid of them";
        //Penalty of -50 points from score since the answer was wrong
        player.getScore().decrementScore(50);
        //add 5 papers to players inventory
        player.getInventory().addToInventory(owner.getItem());
        //Change state to SecondContact
        owner.changeState();
        
        this.options.clear();
        
        return theString;
    }
    
    public String case132(Player player){
        String theString = "Myeeees... That's exactly correct!"
                + "You can have your papers. Here you go"
                + "You recieve 5 tax papers."
                + "Maybe someone in this building can help you get rid of them";
        

        //Add 5 papers to inventory
        player.getInventory().addToInventory(owner.getItem());
        //Change state to secondContact
        owner.changeState();
      
        this.options.clear();
        
        return theString;
        
    }
    
    public String case2(){
        String theString = "Oh usually people accept. Come back if you change your mind";
        
        this.options.clear();
        
        return theString;
    }

    @Override
    public String dialogue(Player player) {
        
        switch(DialogueBlockState){
            case 0:
                return this.getIntro(player);
            case 1:
                return this.case1();
            case 2: 
                return this.case2();
            case 11: 
                return this.case11(player);
            case 12:
                return this.case12();
            case 13:
                return this.case13(player);
            case 111:
                return this.case111(player);
            case 112:
                return this.case112(player);
            case 121:
                return this.case121(player);
            case 122:
                return this.case122(player);
            case 131: 
                return this.case131(player);
            case 132:
                return this.case132(player);
                
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
