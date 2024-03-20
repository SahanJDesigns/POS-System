import java.io.Serializable;

class GroceryItem implements Serializable{
    // Variables to store item information
    private String itemName;
    private int itemCode;
    private double price;
    private double weight;
    private String manufactureDate;
    private String expireDate;
    private String manufactureName;
    private double discount;

    // Constructor
    public GroceryItem(int itemCode, String itemName, double price, double weight, String manufactureDate, String expireDate) {
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.price = price;
        this.weight = weight;
        this.manufactureDate = manufactureDate;
        this.expireDate = expireDate;
    }

    // Constructor to create an object of the GroceryItem when the item code is given
    public GroceryItem(int itemCode) throws ItemCodeNotFound {

        // Creating an object according to the item code
        switch (itemCode) {
            case 1001:
                this.itemCode = itemCode;
                itemName = "Bread";
                price = 120.0;
                weight = 450.0;
                manufactureDate = "20/03/2024";
                expireDate = "21/03/2024";
                manufactureName = "Ransara Bakery";
                discount = 0;
                break;

            case 1002:
                this.itemCode = itemCode;
                itemName = "Egg";
                price = 50.0;
                weight = 50.0;
                manufactureDate = "19/03/2024";
                expireDate = "29/03/2024";
                manufactureName = "A&B Farm";
                discount = 0;
                break;

            case 1003:
                this.itemCode = itemCode;
                itemName = "Cheese";
                price = 420.0;
                weight = 200.0;
                manufactureDate = "19/03/2024";
                expireDate = "20/05/2024";
                manufactureName = "A&B Farm";
                discount = 0.1;
                break;

            case 1004:
                this.itemCode = itemCode;
                itemName = "Butter";
                price = 420.0;
                weight = 200.0;
                manufactureDate = "19/03/2024";
                expireDate = "20/05/2024";
                manufactureName = "A&B Farm";
                discount = 0;
                break;

            case 1005:
                this.itemCode = itemCode;
                itemName = "Chicken";
                price = 1200.0;
                weight = 1000.0;
                manufactureDate = "19/03/2024";
                expireDate = "20/04/2024";
                manufactureName = "A&B Farm";
                discount = 0;
                break;

            case 1006:
                this.itemCode = itemCode;
                itemName = "Fresh Milk";
                price = 480.0;
                weight = 180.0;
                manufactureDate = "19/03/2024";
                expireDate = "27/03/2024";
                manufactureName = "A&B Farm";
                discount = 0;
                break;

            case 1007:
                this.itemCode = itemCode;
                itemName = "Soap";
                price = 150.0;
                weight = 70.0;
                manufactureDate = "18/02/2024";
                expireDate = "18/02/2025";
                manufactureName = "Baby Cheramy";
                discount = 0.02;
                break;

            case 1008:
                this.itemCode = itemCode;
                itemName = "Detergent Powder";
                price = 450.0;
                weight = 1000.0;
                manufactureDate = "11/01/2024";
                expireDate = "11/01/2025";
                manufactureName = "Sunlight";
                discount = 0;
                break;

            case 1009:
                this.itemCode = itemCode;
                itemName = "Dishwash Liquid";
                price = 450.0;
                weight = 500.0;
                manufactureDate = "15/02/2024";
                expireDate = "15/02/2025";
                manufactureName = "Vim";
                discount = 0;
                break;

            case 1010:
                this.itemCode = itemCode;
                itemName = "Toothpaste";
                price = 240.0;
                weight = 120.0;
                manufactureDate = "20/01/2024";
                expireDate = "21/01/2025";
                manufactureName = "Signal";
                discount = 0;
                break;

            case 1011:
                this.itemCode = itemCode;
                itemName = "Milo";
                price = 100.0;
                weight = 450.0;
                manufactureDate = "13/01/2024";
                expireDate = "13/0/2025";
                manufactureName = "Nestle";
                discount = 0;
                break;

            case 1012:
                this.itemCode = itemCode;
                itemName = "Milk pouder";
                price = 1045.0;
                weight = 400.0;
                manufactureDate = "17/02/2024";
                expireDate = "15/08/2024";
                manufactureName = "Pelawaththa";
                discount = 0.40;
                break;

            case 1013:
                this.itemCode = itemCode;
                itemName = "Ginger Beer";
                price = 300.0;
                weight = 500.0;
                manufactureDate = "22/01/2024";
                expireDate = "21/01/2025";
                manufactureName = "Elephant house";
                discount = 0;
                break;
            
            case 1014:
                this.itemCode = itemCode;
                itemName = "Sampoo";
                price = 450.0;
                weight = 300.0;
                manufactureDate = "14/01/2024";
                expireDate = "21/02/2026";
                manufactureName = "Sunsilk";
                discount = 0.03;
              break;
    
            case 1015:
                this.itemCode = itemCode;
                itemName = "Cream cracker";
                price = 300.0;
                weight = 450.0;
                manufactureDate = "02/04/2024";
                expireDate = "10/10/2025";
                manufactureName = "Munchee";
                discount = 0.1;
                break;
    
    
            case 1016:
                this.itemCode = itemCode;
                itemName = "Fish";
                price = 600.0;
                weight = 500.0;
                manufactureDate = "22/01/2024";
                expireDate = "21/01/2025";
                manufactureName = "Sayura Fish";
                discount = 0;
              break;
    
    
            case 1017:
                this.itemCode = itemCode;
                itemName = "Book";
                price = 245.0;
                weight = 400.0;
                manufactureDate = "12/05/2024";
                expireDate = "12/05/2027";
                manufactureName = "Richard";
                discount = 0.25;
                break;
    
            case 1018:
                this.itemCode = itemCode;
                itemName = "Dhal";
                price = 110.0;
                weight = 500.0;
                manufactureDate = "18/03/2024";
                expireDate = "15/04/2024";
                manufactureName = "Mysoor Dhal";
                discount = 0;
              break;
    
            case 1019:
                this.itemCode = itemCode;
                itemName = "tea";
                price = 500.0;
                weight = 500.0;
                manufactureDate = "25/03/2024";
                expireDate = "01/03/2025";
                manufactureName = "Watawala";
                discount = 0.15;
                break;

            case 1020:
                this.itemCode = itemCode;
                itemName = "Salmon";
                price = 350.0;
                weight = 425.0;
                manufactureDate = "20/01/2024";
                expireDate = "20/07/2024";
                manufactureName = "Diamond";
                discount = 0.1;
                break;
            
            case 1021:
                this.itemCode = itemCode;
                itemName = "Tomato Sause";
                price = 399.0;
                weight = 400.0;
                manufactureDate = "20/01/2024";
                expireDate = "21/01/2025";
                manufactureName = "MD";
                discount = 0.05;
                break;
            
            
            case 1022:
                this.itemCode = itemCode;
                itemName = "Baby Cologne";
                price = 575.0;
                weight = 100.0;
                manufactureDate = "07/05/2023";
                expireDate = "07/05/2026";
                manufactureName = "Baby Cheramy";
                discount = 0.1;
                break;
            
            case 1023:
                this.itemCode = itemCode;
                itemName = "Baby Talc";
                price = 330.0;
                weight = 100.0;
                manufactureDate = "08/06/2023";
                expireDate = "08/01/2025";
                manufactureName = "Panda Baby";
                discount = 0.1;
                break;
            
            
            case 1024:
                this.itemCode = itemCode;
                itemName = "Carrot";
                price = 500.0;
                weight = 1000.0;
                manufactureDate = "18/03/2024";
                expireDate = "25/03/2024";
                manufactureName = "Kandurata Vegetables";
                discount = 0;
                break;
            
            case 1025:
                this.itemCode = itemCode;
                itemName = "Leeks";
                price = 650.0;
                weight = 1000.0;
                manufactureDate = "18/03/2024";
                expireDate = "25/03/2024";
                manufactureName = "Kandurata Vegetables";
                discount = 0;
                break;
            
            case 1026:
                this.itemCode = itemCode;
                itemName = "Banana";
                price = 450.0;
                weight = 1000.0;
                manufactureDate = "20/03/2024";
                expireDate = "27/03/2024";
                manufactureName = "Fresh Fruit";
                discount = 0;
                break;
            
            case 1027:
                this.itemCode = itemCode;
                itemName = "Apple";
                price = 250.0;
                weight = 100.0;
                manufactureDate = "14/03/2024";
                expireDate = "24/03/2024";
                manufactureName = "Fresh Fruit";
                discount = 0;
                break;


            default:
                throw new ItemCodeNotFound();
        }
    }

    // getters and setters
    public String getItemName() {
        return itemName;
    }
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
    public int getItemCode() {
        return itemCode;
    }
    public void setItemCode(int itemCode) {
        this.itemCode = itemCode;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public double getWeight() {
        return weight;
    }
    public void setWeight(double weight) {
        this.weight = weight;
    }
    public String getManufactureDate() {
        return manufactureDate;
    }
    public void setManufactureDate(String manufactureDate) {
        this.manufactureDate = manufactureDate;
    }
    public String getExpireDate() {
        return expireDate;
    }
    public void setExpireDate(String expireDate) {
        this.expireDate = expireDate;
    }
    public String getManufactureName() {
        return manufactureName;
    }
    public void setManufactureName(String manufactureName) {
        this.manufactureName = manufactureName;
    }
    public double getDiscount() {
        return discount;
    }
    public void setDiscount(double discount) {
        this.discount = discount;
    }
}