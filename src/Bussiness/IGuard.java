/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bussiness;
import java.util.ArrayList;

/**
 *
 * @author ulriksandberg
 */
public interface IGuard {
    
    Room relocateGuard(ArrayList<Room> guardRooms, Room guardRoom);
}
