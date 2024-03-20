import java.io.*;
import java.util.HashMap;

public class CustomerDatabase {
    static File customerDatabaseFile = new File("Customers.ser");

    @SuppressWarnings("unchecked")
    public static HashMap<Integer, Customer> loadCustomers() throws IOException {
        // Creating a new hashmap to store the customers in the database
        HashMap<Integer, Customer> customers = new HashMap<>();

        if (customerDatabaseFile.exists() && customerDatabaseFile.length() > 0) {
            try (ObjectInputStream databaseReader = new ObjectInputStream(new FileInputStream(customerDatabaseFile))) {
                // Reading from the database and storing it in a variable
                customers = (HashMap<Integer, Customer>) databaseReader.readObject();
            } catch (ClassNotFoundException e) {
                e.printStackTrace(); // Handle the case where Customer class is not found
            }
        } else {
            saveCustomers(customers); // If the file doesn't exist or is empty, create an empty HashMap file
        }
        return customers;
    }

    public static void saveCustomers(HashMap<Integer, Customer> data) throws IOException {
        // Saving the customer database
        try (ObjectOutputStream databaseWriter = new ObjectOutputStream(new FileOutputStream(customerDatabaseFile))) {
            databaseWriter.writeObject(data);
        }
    }
}