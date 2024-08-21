import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

//Grocery contents
class GroceryItem {
    private String itemCode;
    private String itemName;
    private double price;
    private double weight;
    private String manufacturerName;
    private LocalDateTime dateOfManufacturing;
    private LocalDateTime expiryDate;
    private double discount;    

    public GroceryItem(String itemCode, String itemName, double price, double weight,
                       String manufacturerName, LocalDateTime dateOfManufacturing,
                       LocalDateTime expiryDate, double discount) {
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.price = price;
        this.weight = weight;
        this.manufacturerName = manufacturerName;
        this.dateOfManufacturing = dateOfManufacturing;
        this.expiryDate = expiryDate;
        this.discount = discount;
    }
    
    //Get the name of the product 
    public String getName() {
        return itemName;
    }

    //Get the code of the product 
    public String getCode() {
        return itemCode;
    }
    
    //Get the price of the product 
    public double getUnitPrice() {
        return price;
    }

    //Get the weight of the product 
    public double getWeight() {
        return weight;
    }

    //Get the discount of the product 
    public double getDiscount() {
        return discount;
    }
    
    //Get the manufacturing date of the product 
    public LocalDateTime getMfgDate() {
        return dateOfManufacturing;
    }
   
    //Get the expiry date of the product 
    public LocalDateTime getExpDate() {
        return expiryDate;
    }
   
    //Get the name of the product manufacturer
    public String getManufacturer() {
        return manufacturerName;
    }
}

//when code of the item not found
class ItemCodeNotFoundException extends Exception {
    public ItemCodeNotFoundException(String message) {
        super(message);
    }
}


class POS {
    private final String cashierName;
    private final String branch;
    private final List<GroceryItem> items;
    private final LocalDateTime dateTime;
    
    //Cahier details with their branch
    public POS(String cashierName, String branch) {
        this.cashierName = cashierName;
        this.branch = branch;
        this.items = new ArrayList<>();
        this.dateTime = LocalDateTime.now();
    }
    
    //Add item to the bill 
    public void addItem() {
        //Scan the code for getting details of the items
        try {
            InputStreamReader r = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(r);
           

            while (true) {
                System.out.print("Enter item code: ");
                String itemCode = br.readLine();

                try {
                    GroceryItem item = getItemDetails(itemCode);
                    items.add(item);
                    System.out.println(item.getName() + " added to cart.");
                } catch (ItemCodeNotFoundException e) {
                    System.out.println(e.getMessage());
                    System.out.print("Do you want to re-enter the item code? (y/n): ");
                    String choice = br.readLine();

                    if (!choice.equalsIgnoreCase("y")) {
                        break;
                    }
                }
            }

            br.close();
            r.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
   
    private GroceryItem getItemDetails(String itemCode) throws ItemCodeNotFoundException {
        // Fetch item details from the database
        // hardcoded data for demonstration purposes
        switch (itemCode) {
            case "001":
                return new GroceryItem(itemCode, "Milk", 2.99, 1.0,
                        "ABC Dairy", LocalDateTime.of(2023, 5, 1, 0, 0),
                        LocalDateTime.of(2023, 5, 15, 0, 0), 0.0);
            case "002":
                return new GroceryItem(itemCode, "Bread", 1.5, 0.5,
                        "XYZ Bakery", LocalDateTime.of(2023, 5, 1, 0, 0),
                        LocalDateTime.of(2023, 5, 8, 0, 0), 10.0);
            case "003":
                return new GroceryItem(itemCode, "Apple", 0.5, 0.2,
                        "PQR Farms", LocalDateTime.of(2023, 5, 1, 0, 0),
                        LocalDateTime.of(2023, 5, 10, 0, 0), 20.0);
            default:
                throw new ItemCodeNotFoundException("Item code not found: " + itemCode);
        }
    }
    
    //Print bill
    public void printBill(String customerName) {
        System.out.println("Cashier: " + cashierName);
        System.out.println("Branch: " + branch);
        System.out.println("Date: " + dateTime.toLocalDate());
        System.out.println("Time: " + dateTime.toLocalTime());

        if (customerName != null && !customerName.isEmpty()) {
            System.out.println("Customer: " + customerName);
        }

        System.out.println("Item list:");
        double totalDiscount = 0.0;
        double totalPrice = 0.0;

        for (GroceryItem item : items) {
            double netPrice = item.getUnitPrice() * item.getWeight() * (1 - item.getDiscount() / 100);
            totalDiscount += item.getDiscount() * item.getUnitPrice() * item.getWeight() / 100;
            totalPrice += netPrice;

            System.out.printf("%-10s %-20s $%.2f x %.1fg -%.0f%% = $%.2f\n",
                    item.getCode(), item.getName(), item.getUnitPrice(), item.getWeight (), item.getDiscount(), netPrice);
    }

    System.out.println("Total discount: $" + String.format("%.2f", totalDiscount));
    System.out.println("Total price: $" + String.format("%.2f", totalPrice));
}
}

public class POSSystemDemo {
public static void main(String[] args) {
POS pos = new POS("John Doe", "Super-Saving West");

    // add items to cart
    System.out.println("Adding items to cart...");
    pos.addItem();

    // print bill
    pos.printBill(null);
}
}