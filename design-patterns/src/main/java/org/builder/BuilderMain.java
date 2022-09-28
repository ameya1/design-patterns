package org.builder;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

public class BuilderMain {
    public static void main(String[] args) {
        Employee employee = Employee
                .builder()
                .id(3456L)
                .employeeId("FGV455")
                .joinDate(LocalDate.now())
                .salary(12_00_000D)
                .firstName("Tess")
                .middleName("Jordan")
                .lastName("Sherry")
                .build();
        System.out.println(employee);
    }
}

@Setter
@Getter
@ToString
class Employee {
    private Long id;
    private String firstName;
    private String middleName;
    private String lastName;
    private Double salary;
    private LocalDate joinDate;
    private String employeeId;

    public static EmployeeBuilder builder() {
        return new EmployeeBuilder();
    }

    static class EmployeeBuilder {

        private Employee employee;

        private EmployeeBuilder() {
            this.employee = new Employee();
        }

        public EmployeeBuilder id(Long id) {
            this.employee.setId(id);
            return this;
        }

        public EmployeeBuilder firstName(String firstName) {
            this.employee.setFirstName(firstName);
            return this;
        }

        public EmployeeBuilder lastName(String lastName) {
            this.employee.setLastName(lastName);
            return this;
        }

        public EmployeeBuilder middleName(String middleName) {
            this.employee.setMiddleName(middleName);
            return this;
        }

        public EmployeeBuilder employeeId(String employeeId) {
            this.employee.setEmployeeId(employeeId);
            return this;
        }

        public EmployeeBuilder salary(Double salary) {
            this.employee.setSalary(salary);
            return this;
        }

        public EmployeeBuilder joinDate(LocalDate joinDate) {
            this.employee.setJoinDate(joinDate);
            return this;
        }

        public Employee build() {
            return this.employee;
        }
    }
}




/*interface Builder {
    public
}*/
