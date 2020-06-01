package api;

import entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();
    int getNumberOfProducts();
    Product getProductName(String productName);
    boolean isProductAvailable(String productName);
    boolean isProductAvailable(int id);

}
