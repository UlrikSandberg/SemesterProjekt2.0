/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bussiness;

import Bussiness.DialogueBlocks.BulterDialogueBlock1;
import Acquintance.IDialogueBlock;
import Acquintance.IRoom;
import Bussiness.DialogueBlocks.TaxManDialogueBlock1;
import Bussiness.DialogueBlocks.TaxManDialogueBlock2;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Justus
 */
public class TaxMan extends NPC {

    TaxMan(String name, String filePath) {
        super(name, filePath);
    }
    
    
    //Initializing firstContact based on IDialogue interface
    @Override
    public IDialogueBlock firstContact(Player player) {
        /*
        Scanner input = new Scanner(System.in);
        
        System.out.println("Why hello there, young traveller. I am the master of taxes and this is my humble abode.");
        System.out.println("I have lived for many centuries, and have seen all corners of the world. ");
        System.out.println("I have chosen, from all the places in the world, to live in this archives cellar at SKAT.");
        System.out.println("It is from here, that i take your money through manipulating you government and draining you tax-money.");
        System.out.println("Much like your monarchs");
        System.out.println("How may i help you?");
        System.out.println("1. I've heard that i could get my tax papers down here and not pay taxes if i get rid of them");
        //Switch statement for conversation through input
        switch(input.nextInt()){
            case 1: 
                System.out.println("It is true. I hold all tax-papers of the people of your country.");
                System.out.println("I can give you yours, but in order for me to do so. You will have to answer me some riddles");
                System.out.println("If you can give me the right answer i give you your papers. If not, you'll probably just lose some score");
                System.out.println("Do you accept?");
                System.out.println("1. Yes");
                System.out.println("2. No");
                
                //The input decides which scenario happens
                switch(input.nextInt()){
                    case 1: 
                        System.out.println("Perfect...");
                        System.out.println("What is the easiest way to double your money?");
                        System.out.println("1. Work double as much");
                        System.out.println("2. Put it in front of the mirror, of course!");
                        System.out.println("3. Steal it from someone else");
                        
                        switch(input.nextInt()){
                            case 1:
                                System.out.println("Nope...");
                                System.out.println("You receive a penalty of 50 points");
                                //Penalty of -50 points from score since your answer was wrong
                                player.getScore().decrementScore(50);
                                System.out.println("What increases in value, and never decreases?");
                                System.out.println("1. The amount of hair on your head ");
                                System.out.println("2. The amount of taxes you pay");
                                switch(input.nextInt()){
                                    case 1:
                                        System.out.println("No.. I'm quite sure you lose hair during your life.");
                                        System.out.println("You receive a penalty of 50 points");
                                        //Penalty of -50 points from score since the answer was wrong
                                        player.getScore().decrementScore(50);
                                        System.out.println("Anywho.. I can't be bothered with any more riddles.");
                                        System.out.println("My ancient brain is getting tired of your nonsense.");
                                        System.out.println("Take your papers and leave me");
                                        System.out.println("You receive " + super.getItem().getAmount() + " tax papers");
                                        System.out.println("Maybe someone in this building can help you get rid of them");
                                        //add 5 papers to players inventory
                                        player.getInventory().addToInventory(super.getItem());
                                        //Change state to SecondContact
                                        super.changeState();
                                        break;
                                    case 2: 
                                        System.out.println("Myeeees... That's exactly correct!");
                                        System.out.println("You can have your papers. Here you go");
                                        System.out.println("You recieve 5 tax papers.");
                                        System.out.println("Maybe someone in this building can help you get rid of them");
                                        //Add 5 papers to inventory
                                        player.getInventory().addToInventory(super.getItem());
                                        //Change state to secondContact
                                        super.changeState();
                                        break;
                                }
                                break;
                            case 2:
                                System.out.println("That's exactly correct! Next riddle...");
                                System.out.println(" ");
                                System.out.println("What increases in value, and never decreases?");
                                System.out.println("1. The amount of hair on your head ");
                                System.out.println("2. The amount of taxes you pay");
                                
                                switch(input.nextInt()){
                                    case 1: 
                                        System.out.println("No.. I'm quite sure you lose hair during your life.");
                                        System.out.println("You receive a penalty of 50 points");
                                        //Penalty of -50 points from score since the answer was wrong
                                        player.getScore().decrementScore(50);
                                        System.out.println("Anywho.. I can't be bothered with any more riddles.");
                                        System.out.println("My ancient brain is getting tired of your nonsense.");
                                        System.out.println("Take your papers and leave me");
                                        System.out.println("You receive 5 tax papers");
                                        System.out.println("Maybe someone in this building can help you get rid of them");
                                        //add 5 papers to players inventory
                                        player.getInventory().addToInventory(super.getItem());
                                        //Change state to SecondContact
                                        super.changeState();
                                        break;
                                    case 2: 
                                        System.out.println("Myeeees... That's exactly correct!");
                                        System.out.println("You can have your papers. Here you go");
                                        System.out.println("You recieve 5 tax papers.");
                                        System.out.println("Maybe someone in this building can help you get rid of them");
                                        //Add 5 papers to inventory
                                        player.getInventory().addToInventory(super.getItem());
                                        //Change state to secondContact
                                        super.changeState();
                                        break;
                                }
                                break;
                            case 3: 
                                System.out.println("Nope...");
                                System.out.println("You receive a penalty of 50 points");
                                player.getScore().decrementScore(50);
                                System.out.println("What increases in value, and never decreases?");
                                System.out.println("1. The amount of hair on your head ");
                                System.out.println("2. The amount of taxes you pay");
                                switch(input.nextInt()){
                                    case 1:
                                    System.out.println("No.. I'm quite sure you lose hair during your life.");
                                        System.out.println("You receive a penalty of 50 points");
                                        //Penalty of -50 points from score since the answer was wrong
                                        player.getScore().decrementScore(50);
                                        System.out.println("Anywho.. I can't be bothered with any more riddles.");
                                        System.out.println("My ancient brain is getting tired of your nonsense.");
                                        System.out.println("Take your papers and leave me");
                                        System.out.println("You receive 5 tax papers");
                                        System.out.println("Maybe someone in this building can help you get rid of them");
                                        //add 5 papers to players inventory
                                        player.getInventory().addToInventory(super.getItem());
                                        //Change state to SecondContact
                                        super.changeState();
                                        break;
                                    case 2: 
                                        System.out.println("Myeeees... That's exactly correct!");
                                        System.out.println("You can have your papers. Here you go");
                                        System.out.println("You recieve 5 tax papers.");
                                        System.out.println("Maybe someone in this building can help you get rid of them");
                                        //Add 5 papers to inventory
                                        player.getInventory().addToInventory(super.getItem());
                                        //Change state to secondContact
                                        super.changeState();
                                        break;
                                }
                                break;
                        }
                        break;
                        
                    case 2:
                        //Player doesnt accept the riddle-challenge
                        System.out.println("Oh... Usually people accept. Come back if you change your mind");
                        break;
                }
        }
*/
        return new TaxManDialogueBlock1(this);
    }
    
    @Override
    public IDialogueBlock secondContact(Player player) {
        System.out.println("You have gotten your papers. Now leave me");
        return new TaxManDialogueBlock2(this);
    }

    @Override
    public IDialogueBlock thirdContact(Player player) {
        return null;
        
    }

    @Override
    public Room relocateGuard(ArrayList<IRoom> guardRooms, Room guardRoom) {
        return guardRoom;
    }
    
}
