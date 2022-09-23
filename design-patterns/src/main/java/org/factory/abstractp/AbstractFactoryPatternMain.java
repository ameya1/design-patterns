package org.factory.abstractp;

public class AbstractFactoryPatternMain {
    public static void main(String[] args) {
        AnimalFactory catFactory = new CatAnimalFactory();
        Lion lion = (Lion) catFactory.create();
        lion.display();

        AnimalFactory dogFactory = new DogAnimalFactory();
        Wolf wolf = (Wolf) dogFactory.create();
        wolf.display();

    }


}

interface Animal {
    void display();
}

interface Dog extends Animal {}

interface Cat extends Animal {}

class Wolf implements Dog {

    public Wolf() {
        System.out.println("Wolf created");
    }

    @Override
    public void display() {
        System.out.println("Wolf info");
    }
}

class Lion implements Cat {

    public Lion() {
        System.out.println("Lion created");
    }

    @Override
    public void display() {
        System.out.println("Lion info");
    }
}

abstract class AnimalFactory {
    abstract Animal create();
}

class DogAnimalFactory extends AnimalFactory{

    @Override
    Animal create() {
        return new Wolf();
    }
}

class CatAnimalFactory extends AnimalFactory{

    @Override
    Animal create() {
        return new Lion();
    }
}

/*
* Animal
*   Dog
*   Cat
*
* AnimalFactory
*   WildAnimalFactory
*   DomesticAnimalFactory
*
* Dog
*   Wolf
* Cat
*   Lion
*
* */