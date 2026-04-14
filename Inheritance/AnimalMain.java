class Animal {
    public void makeSound(){
        System.out.println("Some animal sound!");
    }
}

class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Woof woof woof!");
    }
}

class Cat extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Meow meow meow!");
    }
}

public class AnimalMain {
    public static void main(String[] args) {
        Animal[] animals = {
            new Dog(),
            new Cat(),
            new Animal()
        };
        for (Animal a : animals) {
            a.makeSound();
        }
    }
}
