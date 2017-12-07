/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acquintance;

import Bussiness.Item;
import Bussiness.Player;
import Bussiness.Quest;
import Bussiness.Room;
import java.util.ArrayList;
import javafx.scene.image.Image;

/**
 *
 * @author ulriksandberg
 */
public interface INPC {
    
    public String getName();
    public void setQuest(Quest quest);
    public void setCriteria(Quest quest);
    public void setItem(Item item);
    public void setItemCriteria(Item item);
    public IDialogueBlock dialogue(Player player);
    public Image getImage();
    
    public Room relocateGuard(ArrayList<Room> guardRooms, Room guardRoom);
    
}
