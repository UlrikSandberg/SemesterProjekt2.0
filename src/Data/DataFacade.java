/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Acquintance.IData;
import Acquintance.IDataTransfer;
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

    
    
    
    
    
    
    
    
}
