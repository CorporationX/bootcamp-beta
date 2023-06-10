package ru.faang.school.hashmap.task_3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();

        addStudent(students, "John", "Faculty1", 1);
        addStudent(students, "Emma", "Faculty2", 2);
        addStudent(students, "Michael", "Faculty2", 2);
        addStudent(students, "Sophia", "Faculty3", 3);
        addStudent(students, "Daniel", "Faculty1", 1);

        removeStudent(students, "Sophia", "Faculty3", 3);

        List<Student> searchResult = findStudentsByFacultyAndYear(students, "Faculty1", 1);
        printStudentList(searchResult);

        Map<String, Map<Integer, List<Student>>> groupedStudents = groupStudentsByFacultyAndYear(students);
        printGroupedStudents(groupedStudents);
    }


    public static void addStudent(List<Student> studentList, String name, String faculty, int year) {
        Student student = new Student(name, faculty, year);
        studentList.add(student);
    }

    public static void removeStudent(List<Student> students, String name, String faculty, int year) {
        students.removeIf(getFilter(name, faculty, year));
    }

    private static Predicate<Student> getFilter(String name, String faculty, int year) {
        return student -> student.getName().equalsIgnoreCase(name)
                && student.getFaculty().equalsIgnoreCase(faculty)
                && student.getYear() == year;
    }


    public static List<Student> findStudentsByFacultyAndYear(List<Student> studentList, String faculty, int year) {
        List<Student> result = new ArrayList<>();
        for (Student student : studentList) {
            if (student.getFaculty().equalsIgnoreCase(faculty) && student.getYear() == year) {
                result.add(student);
            }
        }
        return result;
    }

    public static void printStudentList(List<Student> students) {
        if (!students.isEmpty()) {
            for (Student student : students) {
                System.out.println("Name: " + student.getName() + ", Faculty: " + student.getFaculty() +
                        ", Year: " + student.getYear());
            }
        } else {
            System.out.println("Students not found.");
        }
        System.out.println();
    }


    public static Map<String, Map<Integer, List<Student>>> groupStudentsByFacultyAndYear(List<Student> studentList) {
        Map<String, Map<Integer, List<Student>>> groupedStudents = new HashMap<>();
        for (Student student : studentList) {
            String faculty = student.getFaculty();
            int year = student.getYear();

            groupedStudents.putIfAbsent(faculty, new HashMap<>());
            Map<Integer, List<Student>> yearMap = groupedStudents.get(faculty);

            yearMap.putIfAbsent(year, new ArrayList<>());
            List<Student> students = yearMap.get(year);

            students.add(student);
        }
        return groupedStudents;
    }

    public static void printGroupedStudents(Map<String, Map<Integer, List<Student>>> groupedStudents) {
        for (var facultyEntry : groupedStudents.entrySet()) {
            String faculty = facultyEntry.getKey();
            Map<Integer, List<Student>> yearMap = facultyEntry.getValue();

            System.out.println("Faculty: " + faculty);
            for (var yearEntry : yearMap.entrySet()) {
                int year = yearEntry.getKey();
                List<Student> students = yearEntry.getValue();

                System.out.println("Year: " + year);
                for (Student student : students) {
                    System.out.println("Name: " + student.getName());
                }
            }
        }
    }
}
