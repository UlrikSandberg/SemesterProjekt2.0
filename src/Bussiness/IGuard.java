/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bussiness;
import Acquintance.IRoom;
import java.util.ArrayList;

/**
 *
 * @author phillipgeisler
 */
public interface IGuard {
    
    /**
     * This method represents movement of NPC's, it's a method that contains 
     * code such that it returns a Room differently from NPC to NPC using the 
     * parameters. 
     * @param guardRooms is the list of Room's that any NPC is supposed to be 
     * able to travel to, it can be manipulated to change the available rooms 
     * for a given NPC. 
     * @param guardRoom is the Room the NPC used to call this method is located. 
     * @return returns a room meant to be used to relocate the NPC used to 
     * call this method. 
     */
    Room relocateGuard(ArrayList<IRoom> guardRooms, Room guardRoom);
}
