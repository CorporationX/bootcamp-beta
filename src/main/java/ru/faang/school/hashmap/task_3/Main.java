package ru.faang.school.hashmap.task_3;


import ru.faang.school.hashmap.task_3.student.Grup;
import ru.faang.school.hashmap.task_3.student.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final List<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        addStudent("pavel", "kiber", 5);
        addStudent("alexei", "kiber", 1);
        addStudent("sasha", "kiber", 4);
        addStudent("stepan", "freza", 1);
        addStudent("dima", "freza", 3);
        addStudent("ilia", "freza", 3);

        deleteStudent("ilia", "freza", 3);

        searchAllStudent("freza", 3).forEach(System.out::println);

        allStudent();
    }

    private static void addStudent(String name, String faculty, int course) {
        try {
            students.add(new Student(name, faculty, course));
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
    }

    private static void deleteStudent(String name, String faculty, int course) {
        students.remove(new Student(name, faculty, course));
    }

    private static List<Student> searchAllStudent(String faculty, int course) {
        Grup grup = new Grup(faculty, course);
        Map<Grup, List<Student>> students = getStudentPerGroups();
        return students.get(grup);
    }

    private static void allStudent() {
        getStudentPerGroups().forEach((key, value) -> {
            System.out.println(key.toString());
            for (Student student : value) {
                System.out.printf("%s \n", student.toString());
            }
        });
    }

    private static Map<Grup, List<Student>> getStudentPerGroups() {
        Map<Grup, List<Student>> mapGrupFacultyYear = new HashMap<>();
        for (Student student : students) {
            Grup grup = student.getFacultyYear();
            if (!mapGrupFacultyYear.containsKey(grup)) {
                mapGrupFacultyYear.put(grup, new ArrayList<>());
                mapGrupFacultyYear.get(grup).add(student);
            } else {
                mapGrupFacultyYear.get(grup).add(student);
            }
        }
        return mapGrupFacultyYear;
    }
}
