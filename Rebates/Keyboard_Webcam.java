/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Rebates;

import BestBuy.*;

/**
 *
 * @author patthickey
 */
public class Keyboard_Webcam extends ReceiptDecorator{

    public Keyboard_Webcam(ReceiptComponent rc) {
        super(rc);
    }
    
    public void print()
    {
        myTrailer.print();        
        System.out.println("REBATE: Mail this in to get $10 back for buying a webcam and keyboard");       
    }     

   public boolean applies(Receipt order)          
   {
        PurchaseItems temp;
        for(int i = 0; i < order.getOrder().size(); i++)
        {
            temp = (PurchaseItems)order.getOrder().get(i);
            if(temp.getName().equals("keyboard"))
            {
                for(int j = 0; i < order.getOrder().size(); j++)
                {
                    temp = (PurchaseItems)order.getOrder().get(j);
                            if(temp.getName().equals("webcam"))
                            {
                               return true;
                            }

                }                  
            }
                
        }
        return false;
   }    
    
}
