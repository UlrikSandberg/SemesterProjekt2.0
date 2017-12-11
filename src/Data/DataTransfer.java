/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Acquintance.IDataTransfer;
import Acquintance.IPlayer;
import Acquintance.IRoom;
import java.io.Serializable;
import java.util.HashMap;

/**
 *
 * @author ulriksandberg
 */
public class DataTransfer implements IDataTransfer, Serializable{
    
    private HashMap<String, IRoom> rooms;
    private IRoom currentRoom;
    private IPlayer player;
    private IRoom guardRoom;
    
    
    DataTransfer(IPlayer player, IRoom room, HashMap<String, IRoom> rooms, IRoom guardRoom) {
        this.currentRoom = room;
        this.player = player;
        this.rooms = rooms;
        this.guardRoom = guardRoom;
    }

    @Override
    public IPlayer getPlayer() {
        return this.player;
    }

    @Override
    public HashMap<String, IRoom> getRooms() {
        return this.rooms;
    }

    @Override
    public IRoom getCurrentRoom() {
        return this.currentRoom;
    }

    @Override
    public IRoom getGuardRoom() {
        return this.guardRoom;
    }

}
