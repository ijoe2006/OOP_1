package campus_cafe;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<LineItem> items = new ArrayList<>();
    private static final BigDecimal TAX_RATE = BigDecimal.valueOf(0.08); // 8%

    public void addItem(Product product, int qty) {
        items.add(new LineItem(product, qty));
    }

    public BigDecimal subtotal() {
        BigDecimal subtotal = BigDecimal.ZERO;
        for (LineItem item : items) {
            subtotal = subtotal.add(item.lineTotal());
        }
        return subtotal;
    }

    public BigDecimal tax() {
        return subtotal().multiply(TAX_RATE);
    }

    public BigDecimal total() {
        return subtotal().add(tax());
    }

    public void printReceipt() {
        System.out.println("\n===== RECEIPT =====");
        for (LineItem item : items) {
            System.out.printf("%s x%d = $%.2f%n",
                item.getProduct().getName(),
                item.getQuantity(),
                item.lineTotal());
        }
        System.out.printf("Subtotal: $%.2f%n", subtotal());
        System.out.printf("Tax: $%.2f%n", tax());
        System.out.printf("Total: $%.2f%n", total());
        System.out.println("===================");
    }
}