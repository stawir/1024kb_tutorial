package service;

import entity.Boots;
import entity.Cloth;
import entity.Product;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceTest {


    @Test
    public void testGetAllProductsPositive() {
        List<Product> products = new ArrayList<Product>();
        products.add(new Cloth(1l, "T-SHIRT", 35.0f, 0.3f, "Black", 4, "XL", "COTTON"));
        products.add(new Boots(1l, "T-SHIRT", 35.0f, 0.3f, "Black", 4, 38, true));

        ProductServiceImpl userService = new ProductServiceImpl(products);
        List<Product> listFromTestClass = userService.getAllProducts();

        Assert.assertEquals(products, listFromTestClass);
    }

    @Test
    public void testGetAllProductsNegative() {
        List<Product> products = new ArrayList<Product>();
        products.add(new Cloth(1l, "T-SHIRT", 35.0f, 0.3f, "Black", 4, "XL", "COTTON"));
        products.add(new Boots(2l, "Boots", 35.0f, 0.3f, "Black", 4, 38, true));

        //new ArrayList<Product>(products) - utworzenie kopii listy, więcej o kopiowaniu i adresach w 4 tygodniu
        //dzieki wykonaniu kopii mamy dwa różne obiekty zamiast jedngo
        //jeden siedzi w productService, drugi w naszym tescie
        ProductServiceImpl productService = new ProductServiceImpl(new ArrayList<Product>(products));
        products.add(new Cloth(3l, "Spodnie", 44.f, 0.f, "White", 3, "S", "COTTON"));
        List<Product> listFromTestClass = productService.getAllProducts();

        Assert.assertNotEquals(products, listFromTestClass);
    }

    @Test
    public void testGetCountProductsWithProducts() {
        List<Product> products = new ArrayList<Product>();
        products.add(new Cloth(1l, "T-SHIRT", 35.0f, 0.3f, "Black", 4, "XL", "COTTON"));
        products.add(new Boots(2l, "Boots", 35.0f, 0.3f, "Black", 4, 38, true));

        ProductServiceImpl productService = new ProductServiceImpl(products);
        final int result = productService.getCountProducts();

        Assert.assertEquals(2, result);
    }


    @Test
    public void testGetCountProductsWithoutProducts() {
        ProductServiceImpl productService = new ProductServiceImpl();

        final int result = productService.getCountProducts();

        Assert.assertEquals(0, result);
    }

    @Test
    public void testGetProductByProductNameWhenExist() {
        List<Product> products = new ArrayList<Product>();
        Product cloth = new Cloth(1l, "T-SHIRT", 35.0f, 0.3f, "Black", 4, "XL", "COTTON");
        products.add(cloth);
        products.add(new Boots(2l, "Boots", 35.0f, 0.3f, "Black", 4, 38, true));

        ProductServiceImpl productService = new ProductServiceImpl(products);
        final Product product = productService.getProductByProductName("T-SHIRT");

        Assert.assertEquals(cloth, product);
    }

    @Test
    public void testGetProductByProductNameWhenNoExist() {
        List<Product> products = new ArrayList<Product>();
        Product cloth = new Cloth(1l, "T-SHIRT", 35.0f, 0.3f, "Black", 4, "XL", "COTTON");
        products.add(cloth);
        products.add(new Boots(2l, "Boots", 35.0f, 0.3f, "Black", 4, 38, true));

        ProductServiceImpl productService = new ProductServiceImpl(products);
        final Product product = productService.getProductByProductName("JAKIS-PRODUKT");

        Assert.assertEquals(null, product);
    }

    @Test
    public void testIsProductOnWareHouseWhenIs() {
        List<Product> products = new ArrayList<Product>();
        products.add(new Boots(2l, "Boots", 35.0f, 0.3f, "Black", 4, 38, true));

        ProductServiceImpl productService = new ProductServiceImpl(products);
        final boolean isProductOnWareHouse = productService.isProductOnWarehouse("Boots");

        Assert.assertTrue(isProductOnWareHouse);
    }


    @Test
    public void testIsProductOnWareHouseWhenIsNot() {
        List<Product> products = new ArrayList<Product>();
        products.add(new Boots(2l, "Boots", 35.0f, 0.3f, "Black", 0, 38, true));

        ProductServiceImpl productService = new ProductServiceImpl(products);
        final boolean isProductOnWareHouse = productService.isProductOnWarehouse("Boots");

        Assert.assertFalse(isProductOnWareHouse);
    }

    @Test
    public void testIsProductExistByNameWhenExist() {
        List<Product> products = new ArrayList<Product>();
        products.add(new Boots(2l, "Boots", 35.0f, 0.3f, "Black", 0, 38, true));

        ProductServiceImpl productService = new ProductServiceImpl(products);
        final boolean isProductExist = productService.isProductExist("Boots");

        Assert.assertTrue(isProductExist);
    }

    @Test
    public void testIsProductExistByNameWhenNoExist() {
        List<Product> products = new ArrayList<Product>();
        products.add(new Boots(2l, "Boots", 35.0f, 0.3f, "Black", 0, 38, true));

        ProductServiceImpl productService = new ProductServiceImpl(products);
        final boolean isProductExist = productService.isProductExist("Inny produkt");

        Assert.assertFalse(isProductExist);
    }

    @Test
    public void testIsProductExistByIdWhenExist() {
        List<Product> products = new ArrayList<Product>();
        products.add(new Boots(2l, "Boots", 35.0f, 0.3f, "Black", 0, 38, true));

        ProductServiceImpl productService = new ProductServiceImpl(products);
        final boolean isProductExist = productService.isProductExist(2l);

        Assert.assertTrue(isProductExist);
    }

    @Test
    public void testIsProductExistByIdWhenNoExist() {
        List<Product> products = new ArrayList<Product>();
        products.add(new Boots(2l, "Boots", 35.0f, 0.3f, "Black", 0, 38, true));

        ProductServiceImpl productService = new ProductServiceImpl(products);
        final boolean isProductExist = productService.isProductExist(5l);

        Assert.assertFalse(isProductExist);
    }


}