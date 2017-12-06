/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bussiness;

import Bussiness.DialogueBlocks.BulterDialogueBlock1;
import Acquintance.IDialogueBlock;
import Bussiness.DialogueBlocks.BulterDialogueBlock2;
import Bussiness.DialogueBlocks.BulterDialogueBlock3;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author ulriksandberg
 */
public class Bulter extends NPC {

    Bulter(String name) {
        super(name);
    }

    public void changeState() {
        super.changeState();
    }
    
   @Override
    public IDialogueBlock firstContact(Player player) {
        
        
        return new BulterDialogueBlock1(this);
        
        /*
        Scanner input = new Scanner(System.in);
        
        System.out.println("Hello my name is steve but everybody calls be Bulter!");
        System.out.println("I'm here to help you get started.");
        System.out.println("Answer Bulter with the following:");
        System.out.println("1. Started with what?");
        System.out.println("2. I can take care of myself, thankyou");
        switch(input.nextInt()) {
        
            case 1:
                
                System.out.println("The game of course!");
                System.out.println("You seem like a real tax-fraud!");
                System.out.println("The rumor says that everyones Tax-papers are physically stored in the archives.");
                System.out.println("If, for some wierd reason, a persons physical Tax-papers should go missing from");
                System.out.println("the archives, that person will be free of taxes for the rest of their live.");
                System.out.println("But you know, rumors are usually fake anyway. But what if this one is true?");
                System.out.println("Answer Bulter:");
                System.out.println("1. I'm no tax fraud!");
                System.out.println("2. so, where do I find this archive?");
                switch(input.nextInt()) {
                    
                    case 1:
                        //Nothing happens
                        System.out.println("Stopped talking to Bulter");
                        break; //Ending conversation.
                    case 2:
                        super.changeState();
                        
                        System.out.println("Wow, not so fast!");
                        System.out.println("Information is not free. frankly I've not had lunch yet and im feeling");
                        System.out.println("a little hungry. Please go get me ma sandwich from the cafeteria.");
                        
                        //Assign quest to player!
                        super.getQuest().setCompleted();
                        player.setQuest(super.getQuest());
                        

                        System.out.println("You accepted the quest!");
                        break;
                }
                  
                break;
            case 2:
                System.out.println("Bulter: Sure sure. I'll be here if you change your mind.");
                System.out.println("Stopped talking to Bulter");
                break;
        }
*/
    }

    @Override
    public IDialogueBlock secondContact(Player player) {
        /*
        Scanner input = new Scanner(System.in);
        
        System.out.println("So, do you have my sandwitch?");
        System.out.println("Answer Bulter:");
        System.out.println("1. No, I don't know where to get it.");
        System.out.println("2. Of course! Now where is the archive?");
        switch(input.nextInt()) {
            case 1:
                
                System.out.println("I don't see this as a hard task. A sandwitch is found in the cafeteria...");
                System.out.println("I'm not telling you anything before I've had something to eat.");
                break;
            case 2:
                
                if(player.getQuest().contains(super.getCriteria()) == true) {
                    
                    if(super.getCriteria().questCriteriaIsMet(player) == true) {
                        super.changeState();
                        System.out.println("I just love tuna sandwitches!");
                        System.out.println("As for the archive. I don't know where exactly it is but it's somewhere in this building.");
                        System.out.println("Someone in the office might know something");
                        System.out.println("Hope it helps!");
                    
                    break;
                    }
                }
                System.out.println("as long as you don't have the sandwich for me me, you don't get any info!");
                break;
                
                
        }
*/
        return new BulterDialogueBlock2(this);
    }

    @Override
    public IDialogueBlock thirdContact(Player player) {
        
        //System.out.println("I dont wanna talk to you, tax-fraud!"); 
        //super.changeState();
        
        return new BulterDialogueBlock3(this);
    }

    @Override
    public Room relocateGuard(ArrayList<Room> guardRooms, Room guardRoom) {
        return guardRoom;
    }

    
   

    
}
