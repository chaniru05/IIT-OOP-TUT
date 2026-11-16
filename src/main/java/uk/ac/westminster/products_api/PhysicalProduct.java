// A PhysicalProduct IS-A Product because it can be used anywhere a Product is expected: it has an id, name and price, and only adds shipping details like weight and dimensions.
// A ShoppingCart would NOT pass this test because it is not a kind of product; it HAS-A collection of products (HAS-A relationship), so it should hold Products as a field instead of extending Product.

package uk.ac.westminster.products_api;

public class PhysicalProduct extends Product {
    private double weightKg;
    private String dimensions;

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
}
