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
    private List<GroceryItem> itemList;
    private LocalDateTime dateTime;

    // Constructor
    public POS(String cashierName, String branch, String customerName) {
        this.cashierName = cashierName;
        this.branch = branch;
        //this.customerName = customerName;
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
        double newDiscount = bill.getTotalDiscount() + item.getPrice()*quantity*item.getDiscount();
        bill.setCurrentTotal(newTotal);
        bill.getCurrentItems().add(item);
        bill.setTotalDiscount(newDiscount);
    }

    public void printBill(Bill bill) {
        System.out.println("\nCashier\t: " + cashierName);
        System.out.println("Branch\t: " + branch);
        System.out.println("Date\t: " + dateTime.toLocalDate());
        System.out.println("Time\t: " + dateTime.toLocalTime());

        System.out.println("\nItem List:");
        for (GroceryItem item : itemList) {
            System.out.println("\tCode: " + item.getItemCode() + "\t Item: " + item.getItemName() + "\t Price: Rs." + item.getPrice());
        }

        System.out.println("\nTotal Discount:"+bill.getTotalDiscount()+"\nTotal Price: Rs." + bill.getCurrentTotal());
        System.out.println("\nThank You! Come Again\n\n");
    }

    public void printBill(Bill bill, String name) {
        System.out.println("\nCashier\t: " + cashierName);
        System.out.println("Branch\t: " + branch);
        System.out.println("Customer: " + name);
        System.out.println("Date\t: " + dateTime.toLocalDate());
        System.out.println("Time\t: " + dateTime.toLocalTime());

        System.out.println("\nItem List:");
        for (GroceryItem item : itemList) {
            System.out.println("\tCode: " + item.getItemCode() + "\t Item: " + item.getItemName() + "\t Price: Rs." + item.getPrice());
        }

        System.out.println("\nTotal Discount:"+bill.getTotalDiscount()+"\nTotal Price: Rs." + bill.getCurrentTotal());
        System.out.println("\nThank You! Come Again\n\n");
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

        while(true){   
            System.out.println("01. New bill");
            System.out.println("02. Pending bill");
            System.out.println("03. Exit");
            int billChoice = parseInt(scn.nextLine());
            Bill bill;
            if(billChoice == 1){
                bill = new Bill();
            }
            else if(billChoice == 2){
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
            else{
                break;
            }

            System.out.println("Enter the name of the customer");
            String customerName = scn.nextLine();
            Customer customer = new Customer(customerName);
            String regCustomer = "";
            if (!customerName.equals(Customer.getCustomer(customerName))){
                System.out.println("Do you want to register as a new customer? Yes/No ");
                String reg = scn.nextLine();
                if (reg.equalsIgnoreCase("Yes")) {
                    try {
                        Customer.registerCustomer(customer);
                    } catch (IOException e) {
                        System.err.println("Error registering customer: " + e.getMessage());
                    }
                }
            }   
            else{
                regCustomer = customerName;
            } 

            POS pos = new POS(cashier.getName(), branch, customerName);
            

            while(true){
                System.out.println("01. Add new item");
                System.out.println("02. Add to pending Bills");
                System.out.println("03. Next bill");
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
            
            if (regCustomer!=""){
                pos.printBill(bill,regCustomer);
            }
            else {
                pos.printBill(bill);
            }
        }

    }
}
