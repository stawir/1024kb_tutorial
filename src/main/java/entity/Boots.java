package entity;

public class Boots extends Product {
    private int size;
    private boolean isNaturalSkin;

    public Boots(Long id, String productName, double price, double weight, String color, int productCount, int size, boolean isNaturalSkin) {
        super(id, productName, price, weight, color, productCount);
        this.size = size;
        this.isNaturalSkin = isNaturalSkin;
    }

    @Override
    public String toString() {
        return "Boots{" +
                "size=" + size +
                ", isNaturalSkin=" + isNaturalSkin +
                '}';
    }
}
