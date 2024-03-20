import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class POS {
    private String cashierName;
    private String branch;
    private String customerName;
    private List<GroceryItem> itemList;
    private LocalDateTime dateTime;

    // Constructor
    public POS(String cashierName, String branch, String customerName) {
        this.cashierName = cashierName;
        this.branch = branch;
        this.customerName = customerName;
        this.itemList = new ArrayList<>();
        this.dateTime = LocalDateTime.now();
    }

    // Method to get item details
    public GroceryItem getItemDetails() throws NumberFormatException, ItemCodeNotFound {
        GroceryItem item = null;
        InputStreamReader r = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(r);
        try {
            System.out.print("Enter item code: ");
            String itemCode = br.readLine();
            item = new GroceryItem(parseInt(itemCode));
            itemList.add(item); // Add item to itemList
        } catch (IOException e) {
            System.err.println("Error reading input.");
        }

        return item;
    }

    public void addItemToBill(GroceryItem item, int quantity,Bill bill) {

        double newTotal = bill.getCurrentTotal() + item.getPrice()* quantity * (1 -item.getDiscount());
        bill.setCurrentTotal(newTotal);
        bill.getCurrentItems().add(item);

    }

    public void printBill(Bill bill) {
        System.out.println("Cashier: " + cashierName);
        System.out.println("Branch: " + branch);
        System.out.println("Customer: " + customerName);
        System.out.println("Date: " + dateTime.toLocalDate());
        System.out.println("Time: " + dateTime.toLocalTime());

        System.out.println("Item List:");
        for (GroceryItem item : itemList) {
            System.out.println("Code: " + item.getItemCode() + ", Name: " + item.getItemName() + ", Price: Rs." + item.getPrice());
        }

        System.out.println("Total Price: Rs." + bill.getCurrentTotal());
    }

    public static void main(String[] args) throws IOException, NumberFormatException, ItemCodeNotFound {
        System.out.println("Enter cashier's ID");
        Scanner scn = new Scanner(System.in);
        //Getting Cashier
        int cashierID = parseInt(scn.nextLine());
        Cashier cashier = new Cashier(cashierID);
        //Getting Branch
        System.out.println("Enter Branch");
        String branch = scn.nextLine();

        POS pos = new POS(cashier.getName(), branch, "Thimira sahan");

        System.out.println("Enter the name of the customer");
        Scanner sc = new Scanner(System.in);
        String customerName = sc.nextLine();
        Customer customer = new Customer(customerName);
        if (!customerName.equals(Customer.getCustomer(customerName))){
            System.out.println("Do you want to register as a new customer? Yes/No ");
            String reg = sc.nextLine();
            if (reg.equalsIgnoreCase("Yes")) {
                try {
                    Customer.registerCustomer(customer);
                } catch (IOException e) {
                    System.err.println("Error registering customer: " + e.getMessage());
                }
            }
        }    

        System.out.println("01. New bill");
        System.out.println("02. Pending bill");
        int billChoice = parseInt(scn.nextLine());
        Bill bill;
        if(billChoice == 1){
            bill = new Bill();
        }else{
            System.out.println("Enter BillID");
            int billID = parseInt(scn.nextLine());
            try {
                bill = BillDatabase.getPendingBills().get(billID);
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

        while(true){
           
                System.out.println("01. Add new item");
                System.out.println("02. Add to pending Bills");
                System.out.println("03. End bill");
                int choice = parseInt(scn.nextLine());
                if(choice == 1){
                    GroceryItem item = pos.getItemDetails();
                    System.out.println("Enter quantity");
                    int quantity = parseInt(scn.nextLine());
                    pos.addItemToBill(item,quantity,bill);
                }else if(choice ==2 ){
                    try {
                        BillDatabase.addToPendingBill(bill);
                        System.out.println("BillID: "+bill.getBillID());
                        break;
                    } catch (IOException e) {
                        System.out.println(e.getMessage());
                    } catch (ClassNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                }else{
                    break;
                }
            }
            
        

        pos.printBill(bill);
    }
}
