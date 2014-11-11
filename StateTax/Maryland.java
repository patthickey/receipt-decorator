
package StateTax;

//@author patthickey

import BestBuy.PurchaseItems;
import java.util.LinkedList;

 
public class Maryland {
    
    //sales tax is 6%
    //has sales tax holiday, but does not include hardware or computers
    /*
    There is a sales tax holiday on the first Friday/Saturday that includes clothing, school supplies, 
    and computers (also computer accessories and software).    In 2014, the dates of the sales tax 
    holiday were August 1-2. Computer-related items are tax free up to $1,000 per item (info).
    */    
    
    public final static float SALESTAX = (float) .06;

    public static double getHoliday(LinkedList items)
    {
        float tax = 0;
        float cost = 0;
        PurchaseItems temp;
        for(int i = 0; i < items.size(); i++)
        {
            temp = (PurchaseItems)items.get(i);
            cost = temp.getPrice();
            if(cost>1000)
                tax = tax + cost*SALESTAX;
        }
        System.out.println("Holiday sales tax");
        return tax;
    }
    
}
