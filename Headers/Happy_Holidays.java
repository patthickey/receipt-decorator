/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Headers;
import BestBuy.*;
/**
 *
 * @author patthickey
 */
public class Happy_Holidays extends ReceiptDecorator{

    public Happy_Holidays(ReceiptComponent rc) {
        super(rc);
    }
        
    public void print()
    {
        myTrailer.print();        
        System.out.println("Happy Holidays!");
    }

    
    public boolean applies(Receipt order) {
        return true;
    }
}
