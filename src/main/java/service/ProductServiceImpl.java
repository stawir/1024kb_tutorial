package service;

import api.ProductService;
import entity.Product;

import java.util.List;

public class ProductServiceImpl implements ProductService {
    List<Product> products;

    public ProductServiceImpl(List<Product> products) {
        this.products = products;
    }

    @Override
    public List<Product> getAllProducts() {
        return products;
    }

    @Override
    public int getNumberOfProducts() {
        return products.size();
    }

    @Override
    public Product getProductName(String productName) {
        for (Product product : products) {
            if (product.getProductName() == productName) {
                return product;
            }
        }
        return null;
    }

    @Override
    public boolean isProductAvailable(String productName) {
        for (Product product : products) {
            if (product.getProductName() == productName) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isProductAvailable(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return true;
            }
        }
        return false;
    }
}
