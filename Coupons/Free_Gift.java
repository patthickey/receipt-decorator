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
public class Free_Gift extends ReceiptDecorator{

    public Free_Gift(ReceiptComponent rc) {
        super(rc);
    }
    
    public void print()
    {
        myTrailer.print();        
        System.out.println("COUPON: Bring this to customer service for a free gift");       
    } 

   public boolean applies(Receipt order)          
   {
       
        float subTotal = 0;
        PurchaseItems temp;
        for(int i = 0; i < order.getOrder().size(); i++)
        {
            temp = (PurchaseItems)order.getOrder().get(i);
            subTotal = subTotal + temp.getPrice();
        }

        if(subTotal > 1000)
            return true;
        
        return false;
   }
   
}
