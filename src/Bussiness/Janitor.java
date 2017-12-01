/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bussiness;
import Bussiness.DialogueBlocks.BulterDialogueBlock1;
import Acquintance.IDialogueBlock;
import java.util.ArrayList;
import java.util.Scanner;
import Bussiness.NPC;
import Bussiness.Player;
import Bussiness.Room;


/**
 *
 * @author Christian
 * 
 **/
public class Janitor extends NPC {

    Janitor(String name) {
        super(name);
    }
    
        
    
    @Override
    public IDialogueBlock firstContact(Player player) {
        
        
        Scanner input = new Scanner(System.in);
        System.out.println("Hello i am the Janitor of this place");
        // CHECK FOR PAPER INSTEAD
        if(player.getInventory().inventoryDoesContain(super.getItemCriteria()) == true) {
            
            System.out.println("Grrrr i see you have that yummy paper");
            System.out.println("1. You can eat it if you want to???");
            System.out.println("2. You are a weirdo");
            switch(input.nextInt()) {
                
                case 1: 
                    
                    System.out.println(" *Munch Munch* *gulp*");
                    super.getItemCriteria().setAmount(super.getItemCriteria().getAmount() - 1);
                    
                    System.out.println("That paper really made my throat dry, could you get me someting to drink?");
                    System.out.println("Answer Janitor:");
                    System.out.println("1. Definitely! Do not worry i got you");
                    System.out.println("2. Nah");
                    switch(input.nextInt()) {

                    case 1:

                        System.out.println("You accepted the quest!");
                        super.getQuest().setInitialized();
                        player.setQuest(super.getQuest());
                        super.changeState();
                        break;
                    case 2:
                        
                        System.out.println("I might die then... but whatever");
                        break;
        }           
                    
                break;
                    
                case 2:
                    System.out.println("You are wrong");
                break;
            
                
        }
        }
        return new BulterDialogueBlock1(this);
    }    

    @Override
    public IDialogueBlock secondContact(Player player) {
        
        Scanner input = new Scanner(System.in);
        
        if(player.getQuest().contains(super.getQuest()) == true) {
            
            if(super.getQuest().questCriteriaIsMet(player) == true) {
                
                System.out.println("How bout dat drink?");
                System.out.println("1. Give drink");
                System.out.println("2. Keep drink");
                 switch(input.nextInt()) {
                    case 1:
                        player.getInventory().removeFromInventory(super.getQuest().getCriteria()); // DRinken skal instantieres gennem "toilet"
                        super.getQuest().setCompleted();
                        super.changeState();
                        System.out.println("Thank you, that drink made me able to breath again, take this dress");
                        //player.getInventory().addToInventory(dress); //add dress to inventory
                        //player.super.getQuest(super.getQuest());
                        break;
                    case 2:
                        
                        System.out.println("");
                        
                        break;
                }        
            } else {
                System.out.println("My mouth is still dry, fuck off!"); 
            }  
        }
        return new BulterDialogueBlock1(this);
    }
    @Override
    public IDialogueBlock thirdContact(Player player) {
                    
        if(player.isQuestComplete(super.getCriteria()) == true) {
            
            
            if(super.getCriteria().questCriteriaIsMet(player) == true) {
                        
                //
                System.out.println("Thank you, that drink made me able to breath again, take this dress");
                
                if(player.getInventory().addToInventory(super.getItem()) != true) {
                    
                    
                }
            } else {
                        
                        
                        //
                        System.out.println("Criteria not met");
                        
                    } 
                
        }
        return new BulterDialogueBlock1(this);
        }

    @Override
    public Room relocateGuard(ArrayList<Room> guardRooms, Room guardRoom) {
        return guardRoom; //To change body of generated methods, choose Tools | Templates.
    }
    
}
