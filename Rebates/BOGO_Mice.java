
package Rebates;

// @author patthickey

import BestBuy.*;


public class BOGO_Mice extends ReceiptDecorator{

    public BOGO_Mice(ReceiptComponent rc) {
        super(rc);
    }
    

    public void print()
    {
        myTrailer.print();    
        System.out.println("REBATE: Mail this in to get cost of the second mouse back");       
    } 

   public boolean applies(Receipt order)          
   {
        PurchaseItems temp;
        for(int i = 0; i < order.getOrder().size(); i++)
        {
            temp = (PurchaseItems)order.getOrder().get(i);
            if(temp.getName().equals("mouse"))
                return true;
        }
        return false;
   }
    
}
