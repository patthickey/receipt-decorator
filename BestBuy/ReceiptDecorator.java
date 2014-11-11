
package BestBuy;
import Coupons.*;
import Headers.*;
import Rebates.*;

 // @author patthickey

public abstract class ReceiptDecorator implements ReceiptComponent{
       
    protected ReceiptComponent myTrailer;
    
    public ReceiptDecorator(ReceiptComponent rc)
    {
        myTrailer = rc;
    }
        
    public void callTrailer()
    {
        myTrailer.print();
    }
    
    public abstract void print();
    
    public abstract boolean applies(Receipt order);
        
}
