import java.io.Serializable;
import java.util.ArrayList;

public class Bill implements Serializable {
    private int billID;
    private double currentTotal=0;
    private ArrayList<GroceryItem> currentItems = new ArrayList<GroceryItem>();
    private double totalDiscount;

    public int getBillID() {
        return billID;
    }

    public void setBillID(int billID) {
        this.billID = billID;
    }

    public ArrayList<GroceryItem> getCurrentItems() {
        return currentItems;
    }
    public void setCurrentItems(ArrayList<GroceryItem> currentItems) {
        this.currentItems = currentItems;
    }

    public double getCurrentTotal() {
        return currentTotal;
    }

    public void setCurrentTotal(double currentTotal) {
        this.currentTotal = currentTotal;
    }

    public double getTotalDiscount() {
        return totalDiscount;
    }

    public void setTotalDiscount(double totalDiscount) {
        this.totalDiscount = totalDiscount;
    }

    public Bill(){
        billID = ID.getNewID();
    }
    
}
