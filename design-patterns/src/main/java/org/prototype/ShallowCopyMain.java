package org.prototype;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

public class ShallowCopyMain {

    public static void main(String[] args) throws CloneNotSupportedException {

        System.out.println("Shallow Copy");
        Name name = new Name("Jane", "jake", "Miller");
        Employee emp = new Employee(123l, LocalDate.now(), name);
        System.out.println(emp);

        Employee emp2 = emp.clone();
        emp2.setId(231l);
        emp2.setDate(LocalDate.of(2021, 12, 21));
        emp2.getName().setFirstName("Rose");
        emp2.getName().setLastName("Frost");

        System.out.println(emp);
        System.out.println(emp2);
        System.out.println("Deep Copy");

        Name name1 = new Name("Jane", "jake", "Miller");
        Employee emp3 = new Employee(123l, LocalDate.now(), name1);
        System.out.println(emp3);

        Employee emp4 = new Employee(emp3);
        emp4.setId(231l);
        emp4.setDate(LocalDate.of(2021, 12, 21));
        emp4.getName().setFirstName("Rose");
        emp4.getName().setLastName("Frost");

        System.out.println(emp3);
        System.out.println(emp4);
    }




}

@AllArgsConstructor
@ToString
@Setter
@Getter
class Employee implements Cloneable {
    private Long id;
    private LocalDate date;
    private Name name;

    // deep copy constructor
    public Employee(Employee employee) throws CloneNotSupportedException {
        this(employee.id, employee.date, employee.getName().clone());
    }

    public Employee clone() throws CloneNotSupportedException {
        return (Employee) super.clone();
    }
}

@AllArgsConstructor
@Setter
@Getter
@ToString
class Name implements Cloneable{
    private String firstName;
    private String lastName;
    private String middleName;

    public Name clone() throws CloneNotSupportedException {
        return (Name) super.clone();
    }
}
