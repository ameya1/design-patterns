package org.prototype;


import lombok.*;

public class PrototypeMain {
    public static void main(String[] args) throws CloneNotSupportedException {
        Car ferrari = new Ferrari(2005, 1000_000D);
        System.out.println(ferrari);
        Car ferrari2 = ferrari.clone();
        ferrari2.setPrice(1_200_000D);
        System.out.println(ferrari + " " + ferrari2);

        Car bmw = new BMW(2010, 200_000D);
        System.out.println(bmw);
        Car bmw2 = bmw.clone();
        bmw2.setYear(2015);
        System.out.println(bmw + " " + bmw2);
    }
}

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
abstract class Car implements Cloneable {

    protected Integer year;
    protected Double price;

    public Car clone() throws CloneNotSupportedException {
        return (Car) super.clone();
    }
}

@AllArgsConstructor
class Ferrari extends Car {

    public Ferrari(Integer year, Double price) {
        super(year, price);
    }

    public Ferrari clone() throws CloneNotSupportedException {
        return (Ferrari) super.clone();
    }
}

@AllArgsConstructor
class BMW extends Car {

    public BMW(Integer year, Double price) {
        super(year, price);
    }

    public BMW clone() throws CloneNotSupportedException {
        return (BMW) super.clone();
    }
}