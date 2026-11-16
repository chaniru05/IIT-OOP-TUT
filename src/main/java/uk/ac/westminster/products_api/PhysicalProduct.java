// A PhysicalProduct IS-A Product because it can be used anywhere a Product is expected: it has an id, name and price, and only adds shipping details like weight and dimensions.
// A ShoppingCart would NOT pass this test because it is not a kind of product; it HAS-A collection of products (HAS-A relationship), so it should hold Products as a field instead of extending Product.

package uk.ac.westminster.products_api;

public class PhysicalProduct extends Product implements Discountable {
    private double weightKg;
    private String dimensions;
    private double discountPrice;

    public PhysicalProduct() {}

    public PhysicalProduct(Long id, String name, double price, double weightKg, String dimensions) {
        super(id, name, price);
        this.weightKg = weightKg;
        this.dimensions = dimensions;
    }

    public double getWeightKg() {
        return weightKg;
    }

    public String getDimensions() {
        return dimensions;
    }

    @Override
    public String getSummary(){
        return getName() + "->" + getWeightKg() + "kg, " + getDimensions();
    }

    @Override
    public void applyDiscount(double rate) {
       double capped= Math.min(rate, 0.20);
       discountPrice = getPrice() * (1 - capped);
    }

    @Override
    public double getDiscountPrice() {
        return discountPrice;
    }
}
