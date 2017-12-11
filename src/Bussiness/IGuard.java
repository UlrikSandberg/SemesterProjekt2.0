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
 * @author ulriksandberg
 */
public interface IGuard {
    
    Room relocateGuard(ArrayList<IRoom> guardRooms, Room guardRoom);
}
