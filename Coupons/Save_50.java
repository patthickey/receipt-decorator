/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Coupons;

import BestBuy.*;

/**
 *
 * @author patthickey
 */
public class Save_50 extends ReceiptDecorator{

    public Save_50(ReceiptComponent rc) {
        super(rc);
    }

    public void print()
    {
        myTrailer.print();        
        System.out.println("COUPON: Bring this back to save $50 on your next order");      
    } 

   public boolean applies(Receipt order)          
   {
        if(order.getOrder().size() >= 3)
            return true;
        return false;
   }    
}
