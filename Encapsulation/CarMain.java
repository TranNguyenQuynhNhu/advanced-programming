class Car {
    private String brand;
    private String model;
    private int year;

    public Car() {
        brand = "unknown";
        model = "unknown";
        year = 2000;
    }

    public Car(String brand, String model, int year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void print() {
        System.out.println("Brand: " + brand);
        System.out.println("Model " + model);
        System.out.println("Year: " + year);
        System.out.println();
    }
};

public class CarMain {
    public static void main(String[] args) {
        Car car1 = new Car();
        car1.print();
        Car car2 = new Car("Toyota", "Camry", 2022);
        car2.print();
        car1.setBrand("Honda");
        car1.setModel("Civic");
        car1.setYear(2020);
        car1.print();
    }
}
