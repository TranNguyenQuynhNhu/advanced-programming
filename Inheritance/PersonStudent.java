class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println();
    }
}

class Student extends Person {
    private String studentId;

    public Student(String name, int age, String studentId) {
        super(name, age);
        this.studentId = studentId;
    }

    public String getStudentId() {
        return studentId;
    }

    @Override
    public void displayInfo() {
        System.out.println("Name: " + getName());
        System.out.println("Age: " + getAge());
        System.out.println("Student ID: " + studentId);
        System.out.println();
    }
}

public class PersonStudent {
    public static void main(String[] args) {
        Person p = new Person("An", 30);
        Student s = new Student("Nhu", 19, "S12345");
        Person k = new Student("Hung", 19, "2452930");
        p.displayInfo();
        s.displayInfo();
        k.displayInfo();
    }
}
