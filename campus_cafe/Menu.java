package campus_cafe;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Menu {
    private List<Product> items = new ArrayList<>();

    public Menu() {
        // build your menu here
        items.add(new Drinks("B01", "Coffee", BigDecimal.valueOf(2.50), Size.SMALL));
        items.add(new Drinks("B02", "Tea", BigDecimal.valueOf(3.50), Size.SMALL));
        items.add(new food("F01", "pizza slice", BigDecimal.valueOf(5.00), false));
        items.add(new food("F02", "burger", BigDecimal.valueOf(4.00), true));
    }

    // Show the menu
    public void displayMenu() {
        System.out.println("\nWelcome to CAMPUS CAFE");
        System.out.println("\nPlease select from the following items...\n");
        for (Product item : items) {
            System.out.printf("%s -- %s: $%.2f%n", item.getId(), item.getName(), item.getBasePrice());
        }
    }

    // Get product by ID
    public Product getMenuItem(String id) {
        for (Product item : items) {
            if (item.getId().equalsIgnoreCase(id)) {
                return item;
            }
        }
        return null; // not found
    }
}