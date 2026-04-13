class Laptop {
    private String brand;
    private String model;
    private double price;

    public Laptop() {
        this("Unknown", "Unknown", 0.0);
    }

    public Laptop(String brand, String model, double price) {
        this.brand = brand;
        this.model = model;
        this.price = price;
    }

    public void print() {
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Price: $" + price);
        System.out.println();
    }
}

public class LaptopMain {
    public static void main(String[] args) {
        Laptop lap1 = new Laptop();
        lap1.print();
        Laptop lap2 = new Laptop("Dell", "XPS 13", 1299.99);
        lap2.print();
    }
}
