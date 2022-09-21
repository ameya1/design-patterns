package org;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;

@Log4j2
public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();

        students.add(Student.builder().id("GH675").name("Jake").dept("Science").grade(75.32).build());
        students.add(Student.builder().id("JDN56").name("Rebecca").dept("Science").grade(89.32).build());
        students.add(Student.builder().id("LMN89").name("Rose").dept("Arts").grade(70.32).build());
        students.add(Student.builder().id("HBC45").name("Foster").dept("Arts").grade(62.32).build());

        //ScienceClassIdentifier sc = student ->

        Function<Integer, String> str = num -> num.toString();

        /*Function<Student, Class> artsClassIdentifier = student -> student.grade > 70 ? Class.DISTINCTION : student.grade > 50 ? Class.FIRST_CLASS : student.grade > 40 ? Class.SECOND_CLASS : Class.FAIL;
        Function<Student, Class> scienceClassIdentifier = student -> student.grade > 80 ? Class.DISTINCTION : student.grade > 60 ? Class.FIRST_CLASS : student.grade > 50 ? Class.SECOND_CLASS : Class.FAIL;*/

        ClassIdentifier scienceClassIdentifier = new ScienceClassIdentifier();
        ClassIdentifier artsClassIdentifier = new ArtsClassIdentifier();


        students.stream()
                .filter(student -> student.dept.equals("Science"))
                .map(student -> updateClass(student, scienceClassIdentifier))
                .forEach(student -> log.info(student));

        students.stream()
                .filter(student -> student.dept.equals("Arts"))
                .map(student -> updateClass(student, artsClassIdentifier))
                .forEach(student -> log.info(student));

    }

    public static Student updateClass(Student student, ClassIdentifier classIdentifier) {
        student.setClasz(classIdentifier.grade(student));
        return student;
    }
}

@Data
@Builder
@ToString
class Student {
    String name;
    String id;
    Double grade;
    String dept;
    Class clasz;

}

enum Class {
    DISTINCTION,
    FIRST_CLASS,
    SECOND_CLASS,
    FAIL;
}


interface ClassIdentifier {
    Class grade(Student student);
}

class ArtsClassIdentifier implements ClassIdentifier {

    @Override
    public Class grade(Student student) {
        Double grade = student.grade;
        return grade > 70 ? Class.DISTINCTION : grade > 50 ? Class.FIRST_CLASS : grade > 40 ? Class.SECOND_CLASS : Class.FAIL;
    }
}

class ScienceClassIdentifier implements ClassIdentifier {

    @Override
    public Class grade(Student student) {
        Double grade = student.grade;
        return grade > 80 ? Class.DISTINCTION : grade > 60 ? Class.FIRST_CLASS : grade > 50 ? Class.SECOND_CLASS : Class.FAIL;
    }
}



