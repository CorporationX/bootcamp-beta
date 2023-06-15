package ru.faang.school.task_5;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor
public class StudentManager {

    private List<Student> students = new ArrayList<>();

    public Map<String, List<Student>> sortStudentsByFacultyAndYear(List<Student> students) {
        return students.stream()
                .collect(Collectors.groupingBy(student -> student.getYear() + " " + student.getFaculty()));
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeStudentByName(String name) {
        students.removeIf(student -> student.getName().equals(name));
    }

    public List<Student> getClassmates(String faculty, String year) {
        return students.stream()
                .filter(student -> student.getFaculty().equals(faculty) && student.getYear().equals(year))
                .collect(Collectors.toList());
    }
}
