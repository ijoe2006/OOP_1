package campus_cafe;
import java.math.BigDecimal; //better than double, float for better accuracy 

public abstract class Product { //cannot create objects within asbtract class //abstract == blueprint, create objects in an inherited
    private String id;
    private String name;
    private BigDecimal basePrice;
    private int quality;

    public Product(String id, String name, BigDecimal basePrice) {
        this.id = id;
        this.name = name;
        this.basePrice = basePrice; //same as self.var = var in py
    }


    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    } 

    public BigDecimal getBasePrice() { //public all functions, no void since returning something dataType functionName
        return this.basePrice;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }

    public int getQuality() {
        return quality;
    }

    public abstract BigDecimal price();
}