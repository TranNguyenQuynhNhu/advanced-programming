class Vehicle {
    private String brand;
    private int year;

    public Vehicle(String brand, int year) {
        this.brand = brand;
        this.year = year;
    }

    public String getBrand() {
        return brand;
    }

    public int getYear() {
        return year;
    }

    public void print() {
        System.out.println("Brand: " + brand);
        System.out.println("Year: " + year);
        System.out.println();
    }
}

class Car extends Vehicle {
    private String model;

    public Car(String brand, int year, String model) {
        super(brand, year);
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    @Override
    public void print() {
        System.out.println("Brand: " + getBrand());
        System.out.println("Year: " + getYear());
        System.out.println("Model: " + model);
        System.out.println();
    }
}

public class VehicleCar {
    public static void main(String[] args) {
        Vehicle v = new Vehicle("Toyota", 2020);
        Car c = new Car("Honda", 2023, "Civic");
        v.print();
        c.print();
    }
}
