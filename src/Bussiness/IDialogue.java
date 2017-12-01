/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bussiness;

import Acquintance.IDialogueBlock;

/**
 *
 * @author ulriksandberg
 */
public interface IDialogue {
    
    IDialogueBlock firstContact(Player player);
    IDialogueBlock secondContact(Player player);
    IDialogueBlock thirdContact(Player player);
}
