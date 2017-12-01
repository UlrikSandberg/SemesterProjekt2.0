/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bussiness;

/**
 *
 * @author ulriksandberg
 */


/* Starting class - Once we run public class StartGame we will execute the main 
** method which instantiate the game class, from which we can call the 
** play.method to start the game.
*/
public class StartGame {
    
    //Main method which init the game by instantiating game class.
    public static void main(String[] args) {
        
        Game game;
        game = new Game();
        //After the game has been constructed see Game.java for information we
        //execute play.method in Game class
        game.play();
  
    }
}
