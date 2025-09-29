package campus_cafe;
import java.math.BigDecimal;

public class Drinks extends Product {
    private Size size;

    public Beverage(String id, String name, BigDecimal basePrice, Size size) {
        super(id, name, basePrice);
        this.size = size;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    @Override
    public BigDecimal price() {
        return this.getBasePrice().multiply(BigDecimal.valueOf(size.getMultiplier()));
    }
}