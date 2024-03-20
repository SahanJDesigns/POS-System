import java.io.*;
import java.util.HashMap;

public class BillDatabase {
    static File pendingBillDatabase = new File("PendingBillDatabase.ser");
    static File completedBillDatabase = new File("CompletedBillDatabase.ser");

    public static HashMap<Integer, Bill> getPendingBills() throws IOException, ClassNotFoundException {
        HashMap<Integer, Bill> data;
        try (ObjectInputStream databaseReader = new ObjectInputStream(new FileInputStream(pendingBillDatabase))) {
            data = (HashMap<Integer, Bill>) databaseReader.readObject();
        } catch (FileNotFoundException e) {
            data = new HashMap<>();
            savePendingBills(data);
        }
        return data;
    }

    public static void addToPendingBill(Bill bill) throws IOException, ClassNotFoundException {
        HashMap<Integer, Bill> data = getPendingBills();
        data.put(ID.getNewID(), bill);
        savePendingBills(data);
    }

    private static void savePendingBills(HashMap<Integer, Bill> data) throws IOException {
        try (ObjectOutputStream databaseWriter = new ObjectOutputStream(new FileOutputStream(pendingBillDatabase))) {
            databaseWriter.writeObject(data);
        }
    }
}
