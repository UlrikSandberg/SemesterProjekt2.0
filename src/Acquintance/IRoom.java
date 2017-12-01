/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acquintance;

import Bussiness.NPC;
import java.util.ArrayList;

/**
 *
 * @author ulriksandberg
 */
public interface IRoom {
    
    
    ArrayList<DirectionType> getExits();
    String getShortDescription();

    public ArrayList<IItem> getItems();
    public void addItemToRoom(IItem item);
    public ArrayList<INPC> getRoomNPCS();
    public void setInhabitant(String subjectname, INPC npc);

    public void setExitBlock(DirectionType direction, INPC exitBlock);     
    
    
}
