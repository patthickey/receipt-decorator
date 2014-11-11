
package BestBuy;

import java.util.LinkedList;
import java.util.Scanner;


//@author patthickey
 
public class Client {

    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);
        
        LinkedList order = new LinkedList();
        StoreHeader header;
        
        /*
        testItems(order); // for testing purposes
        header = testStoreInfo(); // for testing purposes
        */
        
        header = makeHeader(console);        
        makeOrder(order, console);
        
                
        ReceiptFactory rf = new ReceiptFactory(header, order);        
        rf.getReceipt();
    }
    
   
    public static StoreHeader makeHeader(Scanner console)
    {
        String stateCode, address, phone;
        int number;
            System.out.println("What is the state code (MD, CA, GA, DE)");
            stateCode = console.nextLine();
            System.out.println("What is the address?");
            address = console.nextLine();
            System.out.println("What is the phone number");
            phone = console.nextLine();
            System.out.println("What is the store number?");
            number = console.nextInt(); console.nextLine();
            return new StoreHeader(stateCode, address, phone, number);
    }

    public static void makeOrder(LinkedList order, Scanner console)
    {
        boolean more = true;
        int itemNum, cost, quantity;
        String name, ans;

        while(more)
        {
            System.out.println("What is the item number?");
            itemNum = console.nextInt(); console.nextLine();
            System.out.println("What is the item name?");
            name = console.nextLine();
            System.out.println("What is the item cost?");
            cost = console.nextInt(); console.nextLine();
            System.out.println("How many?");
            quantity = console.nextInt(); console.nextLine();
            order.add(new PurchaseItems(itemNum, name, cost, quantity));
            System.out.println("Any more items? (y / n)");
            ans = console.nextLine();
            if(ans.equals("n"))
                more = false;
        }
    }
 

 // for testing purposes only   
    
    public static void testItems(LinkedList order)
    {
        order.add(new PurchaseItems(0, "mouse", 15, 2));
        order.add(new PurchaseItems(1, "windows", 1000, 1));        
        order.add(new PurchaseItems(2, "mac", 1500, 1));        
        order.add(new PurchaseItems(3, "speakers", 25, 1));        
        order.add(new PurchaseItems(4, "flashdrive", 10, 2));  
        order.add(new PurchaseItems(5, "case", 30, 1));        
        order.add(new PurchaseItems(6, "cable", 5, 1)); 
        order.add(new PurchaseItems(7, "scanner", 50, 1)); 
        order.add(new PurchaseItems(8, "webcam", 20, 1));
        order.add(new PurchaseItems(9, "keyboard", 20, 1)); 
    }
    
    public static StoreHeader testStoreInfo()
    {
        return new StoreHeader("MD", "123 cool road", "123-456-7890", 123);
    }
 
}
