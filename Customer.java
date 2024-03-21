import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;

public class Customer implements Serializable{
    private String name;
    private int customerID;

    // getters and setters
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getCustomerID() {
        return customerID;
    }
    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }
    public String getName(int customerID) {
        return name;
    }

    // constructor
    public Customer (String name) throws IOException {
        this.name = name;
    }

    public static String getCustomer(String customerName) throws IOException {
        HashMap<Integer, Customer> customers = CustomerDatabase.loadCustomers();
        for (Customer customer : customers.values()) {
            if (customer.getName().equals(customerName)) {
                return customerName;
            }
        }
        return null; // Return null if the customer with the given name is not found
    }
    
    public static void registerCustomer(Customer customer) throws IOException {
        HashMap<Integer, Customer> customers = new HashMap<>();
        customers = CustomerDatabase.loadCustomers();
        customers.put(ID.getNewID(), customer);
        CustomerDatabase.saveCustomers(customers); 
    }   
}