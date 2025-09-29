package campus_cafe;
import java.math.BigDecimal;

public class Food extends Product {
    private boolean extraCheese;

    public Food(String id, String name, BigDecimal basePrice, boolean extraCheese) {
        super(id, name, basePrice);
        this.extraCheese = extraCheese;
    }

    public boolean hasExtraCheese() {
        return extraCheese;
    }

    public void setExtraCheese(boolean extraCheese) {
        this.extraCheese = extraCheese;
    }

    @Override
    public BigDecimal price() {
        BigDecimal price = this.getBasePrice();
        if (extraCheese) {
            price = price.add(BigDecimal.valueOf(1.00)); // add $1 for cheese
        }
        return price;
    }
}