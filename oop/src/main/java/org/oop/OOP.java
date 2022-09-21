package org.oop;

import java.util.LinkedList;
import java.util.List;

public class OOP {

    // Upper Bounded wildcard
    public static void constructUpper(List<? extends Vehicle> vehicles) {
        vehicles.stream().forEach(v -> System.out.println(v));
    }

    //lower bounded wildcard
    public static void constructLower(List<? super Bus> vehicles) {
        vehicles.stream().forEach(v -> System.out.println(v));
    }

    public static void main(String[] args) {
        List<Vehicle> list = new LinkedList<>();
        list.add(new Vehicle());
        list.add(new Car());
        list.add(new Bus());
        constructUpper(list);

        List<Bus> buses = new LinkedList<>();
        buses.add(new Bus());
        buses.add(new Bus());
        buses.add(new Bus());
        buses.add(new Bus());
        constructUpper(buses);

        constructLower(buses);
        //constructLower(list);



    }
}

class Vehicle {
    public String type() {
        return this.getClass().getName();
    }


}

class Bus extends Vehicle {}

class Car extends Vehicle {}