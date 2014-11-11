/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package BestBuy;
import java.util.LinkedList;
import Headers.*;
import Rebates.*;
import Coupons.*;

/**
 *
 * @author patthickey
 */
public class ReceiptFactory {
    
    Receipt receipt;
    ReceiptComponent everything;
    ReceiptDecorator[] added = new ReceiptDecorator[7];
    
    
    
    int count = 0;
    
    public ReceiptFactory(StoreHeader header,LinkedList order)
    {
        receipt = new Receipt(header, order);
        //Decorate();
        
        added[0] = new Happy_Holidays(everything);
        added[1] = new Free_Gift(everything);
        added[2] = new Save_10(everything);
        added[3] = new Save_50(everything);
        added[4] = new BOGO_Mice(everything);
        added[5] = new Keyboard_Webcam(everything);
        added[6] = new New_Computer(everything);
        
        everything = receipt;
        
        everything = new Happy_Holidays(everything);
        
        if(added[1].applies(receipt))
        {
            everything = new Free_Gift(everything);
        }
        
        if(added[2].applies(receipt))
        {
            everything = new Save_10(everything);
        }
        if(added[3].applies(receipt))
        {
            everything = new Save_50(everything);
        }        
        if(added[4].applies(receipt))
        {
            everything = new BOGO_Mice(everything);
        }        
        if(added[5].applies(receipt))
        {
            everything = new Keyboard_Webcam(everything);
        }            
        if(added[6].applies(receipt))
        {
            everything = new New_Computer(everything);
        }         

    }
    
    public void getReceipt()
    {
        everything.print();
    }

 

    
}
