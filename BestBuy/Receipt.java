
package BestBuy;

import StateTax.*;
import java.util.Date;
import java.util.LinkedList;

 // @author patthickey
 
public class Receipt implements ReceiptComponent{
    
    Date date;
    StoreHeader header;
    LinkedList order = new LinkedList();
    float total = 0;
    float subTotal = 0;        
    
    
    public Receipt(StoreHeader header, LinkedList items)
    {
        this.header = header;
        date = new Date();
        PurchaseItems temp;
        for(int i = 0; i < items.size(); i++)
        {
            temp = (PurchaseItems)items.get(i);
            subTotal = subTotal + temp.getPrice();
            order.add(temp);
        }
        getAmountDue(header, items);
        
        
        
    }
    
    public void print()
    {
        PurchaseItems temp;
        System.out.println(header.getHeader());
        System.out.println(date.toString());
        System.out.println("Your purchases:");
        for(int i = 0; i < order.size(); i++)
        {
            temp = (PurchaseItems)order.get(i);
            System.out.println(temp.getInfo());
        }        
        System.out.println("Subtotal : " + subTotal);
        System.out.println("Total after tax : " + total);
        
    }
 

    public void getAmountDue(StoreHeader header, LinkedList items)
    {
        String state = header.getAddress();
        int month = date.getMonth();
        int day = date.getDay();
        boolean holiday = false;
            if( (state.equals("MD")|state.equals("GE")) & month==8 & (day==1|day==2) )
            {
                holiday = true;
            }
        
        switch(state)
        {
            case "MD" : if(holiday)
                            total = (float) (subTotal + Maryland.getHoliday(items));
                        else
                            total = subTotal + subTotal*Maryland.SALESTAX;
                        break;
                
            case "DE" : total = subTotal;
                        break;
                
            case "GA" : if(holiday)
                            total = (float) (subTotal + Georgia.getHoliday(items));
                        else
                            total = subTotal + subTotal*Georgia.SALESTAX;
                        break;
                
            case "CA" : total = subTotal + subTotal*California.SALESTAX;
                        break;           
        }       
    }
    
    public LinkedList getOrder()
    {
        return order;
    }
    
    public Date getDate()
    {
        return date;
    }    
    
}

