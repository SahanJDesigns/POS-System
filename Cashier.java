public class Cashier {
    private String name;
    private int cashierID;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getcashierID() {
        return cashierID;
    }
    public void setcashierID(int cashierID) {
        this.cashierID = cashierID;
    }

    Cashier (int cashierID){
        this.cashierID = cashierID;
        switch (cashierID) {
            case 1:
                name = "Jack Sparrow";
                break;
            case 2:
                name = "Harry Potter";
            default:
                break;
        }
    }

}