/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acquintance;

/**
 *
 * @author ulriksandberg
 */
public interface IItem {
 
    String toString();
    String getName();
    String getDescription();
    int getAmount();
    void printAmount();
    
    
}
