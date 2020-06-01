package service;

import entity.Product;
import entity.User;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceTest {

    @Test
    public void testGetAllProducts() {
        //is
        List<Product> products = new ArrayList<Product>();
        products.add(new Product(1, "spodnie", 15.99, 2.5, "red",10));
        products.add(new Product(2, "spodnica", 20.99, 1.4, "pink", 15));

        //then
        ProductServiceImpl productService = new ProductServiceImpl(products);
        List<Product> productsFromTestClass = productService.getAllProducts();

        //expected
        Assert.assertEquals(products, productsFromTestClass);

    }
}
