/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acquintance;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author ulriksandberg
 */
public interface IDataTransfer {
    
    
    IPlayer getPlayer();
    HashMap<String, IRoom> getRooms();
    IRoom getCurrentRoom();
    IRoom getGuardRoom();
    ArrayList<IRoom> getGuardrooms();
    
}

