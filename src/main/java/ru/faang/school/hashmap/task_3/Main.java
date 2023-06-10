package ru.faang.school.hashmap.task_3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();

        addStudent(studentList, "John", "Faculty1", 1);
        addStudent(studentList, "Emma", "Faculty2", 2);
        addStudent(studentList, "Michael", "Faculty2", 2);
        addStudent(studentList, "Sophia", "Faculty3", 3);
        addStudent(studentList, "Daniel", "Faculty1", 1);

        removeStudent(studentList, "Sophia", "Faculty3", 3);

        List<Student> searchResult = findStudentsByFacultyAndYear(studentList, "Faculty1", 1);
        printStudentList(searchResult);

        Map<String, Map<Integer, List<Student>>> groupedStudents = groupStudentsByFacultyAndYear(studentList);
        printGroupedStudents(groupedStudents);
    }


    public static void addStudent(List<Student> studentList, String name, String faculty, int year) {
        Student student = new Student(name, faculty, year);
        studentList.add(student);
    }

    public static void removeStudent(List<Student> studentList, String name, String faculty, int year) {
        studentList.removeIf(student -> student.getName().equals(name)
                && student.getFaculty().equals(faculty)
                && student.getYear() == year);
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

    public static void printStudentList(List<Student> studentList) {
        if (!studentList.isEmpty()) {
            for (Student student : studentList) {
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
