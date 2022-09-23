package org.factory.method;

public class FactoryMethodPattern {
    public static void main(String[] args) {
        ShapeFactory factory = new CircleFactory();
        factory.createAndDisplay("Red");

        factory = new SquareFactory();
        factory.createAndDisplay("Blue");
    }
}

/*
I Shape
	behaviour

C Circle => Shape
    behavior

C Square => Shape
    behavior

A C ShapeFactory
    createAndDisplay()
    create()

    abstract create(String color)

C CircleFactory => ShapeFactory
    create(String color)

C SquareFactory => ShapeFactory
    create(String color)*/


interface Shape {
    public void behavior();
}

class Circle implements Shape {

    public Circle() {
        System.out.println("Circle created");
    }

    public Circle(String color) {
        this();
        System.out.println("with color " + color);
    }

    @Override
    public void behavior() {
        System.out.println("Its round and does not have angle");
    }
}

class Square implements Shape {

    public Square() {
        System.out.println("Square created ");
    }


    public Square(String color) {
        this();
        System.out.println("with color " + color);
    }

    @Override
    public void behavior() {
        System.out.println("Its a block and have 4 90 degree angles");
    }
}

abstract class ShapeFactory {
    public void createAndDisplay(String color) {
        create(color).behavior();
    }

    public abstract Shape create(String color);
}

class CircleFactory extends ShapeFactory {

    @Override
    public Shape create(String color) {
        return new Circle(color);
    }
}

class SquareFactory extends ShapeFactory {

    @Override
    public Shape create(String color) {
        return new Square(color);
    }
}