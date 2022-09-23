package org.factory.simple;

public class SimpleFactoryMain {
    public static void main(String[] args) {
        Animal animal = AnimalFactory.getAnimal(AnimalType.DOG);
        animal.behaviour();
        animal = AnimalFactory.getAnimal(AnimalType.TIGER);
        animal.behaviour();
        animal = AnimalFactory.getAnimal(AnimalType.CAT);
        animal.behaviour();
    }
}

interface Animal {
    void behaviour();
}

class Dog implements Animal {

    public Dog() {
        System.out.println("Dog is created");
    }

    @Override
    public void behaviour() {
        System.out.println("It barks");
    }
}

class Tiger implements Animal {

    public Tiger() {
        System.out.println("Tiger is created");
    }

    @Override
    public void behaviour() {
        System.out.println("It roars");
    }
}

class AnimalFactory {
    public static Animal getAnimal(AnimalType type) {
        switch (type) {
            case DOG:
                return new Dog();
            case TIGER:
                return new Tiger();
            default:
                return null;
        }
    }
}

enum AnimalType {
    DOG, TIGER, CAT
}

