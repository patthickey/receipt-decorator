
package BestBuy;

 // @author patthickey

public class StoreHeader {
    
    final private String storename = "BEST BUY";
     String stateCode;
     String address;
     String phone;
     int store_number;
    
    public StoreHeader(String a, String b, String c, int d)
    {
        stateCode = a;
        address = b;
        phone = c;
        store_number = d;
    }
    
    public String getAddress()
    {
        return address;
    }
    
    
    public String getHeader()
    {
        return (storename + "\n" + 
                "Address : " + address + "\n" + 
                "Phone : " + phone + "\n" + 
                "Store : " + store_number);
    }


}
