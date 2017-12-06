/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Acquintance.IData;
import Acquintance.IDataTransfer;
import Acquintance.IHighScore;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author ulriksandberg
 */
public class DataFacade implements IData {

    IDataTransfer transfer;
    
    @Override
    public IDataTransfer loadGame() throws FileNotFoundException, IOException, ClassNotFoundException{
        ObjectInputStream transferIn = new ObjectInputStream(new FileInputStream("save.txt"));
        transfer = (IDataTransfer) transferIn.readObject();
        return transfer;
    }

    @Override
    public void saveGame(IDataTransfer transfer) throws FileNotFoundException, IOException, ClassNotFoundException{
        this.transfer = transfer;
        ObjectOutputStream transferOut = new ObjectOutputStream(new FileOutputStream("save.txt"));
        transferOut.writeObject(transfer);
    }

    @Override
    public IHighScore loadHighScore() throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectInputStream scoresIn = new ObjectInputStream(new FileInputStream("scores.txt"));
        return (IHighScore) scoresIn;
    }

    @Override
    public void saveHighScore(IHighScore highscore) throws FileNotFoundException, IOException, ClassNotFoundException{
        ObjectOutputStream scoresOut = new ObjectOutputStream(new FileOutputStream("scores.txt"));
        scoresOut.writeObject(highscore);
    }

    
    
    
    
    
    
    
    
}
