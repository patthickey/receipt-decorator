
package Coupons;

// @author patthickey

import BestBuy.*;



public class Save_10 extends ReceiptDecorator{

    public Save_10(ReceiptComponent rc) {
        super(rc);
    }
    

    public void print()
    {   
        myTrailer.print();        
        System.out.println("COUPON: Bring this back to save $10 on your next order");      
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

        if(subTotal > 100)
            return true;
        return false;
   }
}