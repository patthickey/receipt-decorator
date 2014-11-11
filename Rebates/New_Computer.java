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
public class New_Computer extends ReceiptDecorator{

    public New_Computer(ReceiptComponent rc) {
        super(rc);
    }

    public void print()
    {
        myTrailer.print();        
        System.out.println("REBATE: Mail this in to get $100 back for buying a new computer");        
    }        

   public boolean applies(Receipt order)          
   {
        PurchaseItems temp;
        for(int i = 0; i < order.getOrder().size(); i++)
        {
            temp = (PurchaseItems)order.getOrder().get(i);
            if(temp.getName().equals("windows") | temp.getName().equals("mac"))
                return true;
        }
        return false;
   }  
    
    
}
