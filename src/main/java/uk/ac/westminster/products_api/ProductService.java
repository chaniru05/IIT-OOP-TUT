package uk.ac.westminster.products_api;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private List<Product> products= new ArrayList<>();
    private Long nextId=1L;

    public List<Product> getAllProducts() {
        return products;
    }

    public Product addProduct(Product product) {
        product = new Product(nextId++, product.getName(), product.getPrice()) {
            @Override
            public String getSummary() {
                return "";
            }
        };
        products.add(product);
        products.add(new DigitalProduct(10L, "Java eBook", 14.99, "ikman.lk", 56.55));
        products.add(new PhysicalProduct(11L, "Mechanical Keyboard", 89.50, 0.9, "44x14x4 cm"));
        return product;
    }

    public Optional<Product> getProductById(Long id){
        return products.stream().filter(p -> p.getId().equals(id)).findFirst();
    }

    public void deleteProductById(Long id){
        products.removeIf(p -> p.getId().equals(id));
    }

    public List<Product> findByName(String name){
        return products.stream().filter(p -> p.getName().contains(name)).toList();
    }

    public List<String> getProductSummaries() {
        List<String> productSummaries = new ArrayList<>();

        for (Product product : products) {
            productSummaries.add(product.getSummary());
        }
        return productSummaries;
    }
}
