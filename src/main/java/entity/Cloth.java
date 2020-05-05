package entity;

public class Cloth extends Product {
    private String size;
    private String material;

    public Cloth(int id, String productName, double price, double weight, String color, int productCount, String size, String material) {
        super(id, productName, price, weight, color, productCount);
        this.size = size;
        this.material = material;
    }

    @Override
    public String toString() {
        return "Cloth{" +
                "size='" + size + '\'' +
                ", material='" + material + '\'' +
                '}';
    }
}
