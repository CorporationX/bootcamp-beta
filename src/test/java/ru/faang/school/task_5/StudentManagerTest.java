package ru.faang.school.task_5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StudentManagerTest {

    private StudentManager studentManager;
    private List<Student> students;

    @BeforeEach
    void setUp() {
        students = new ArrayList<>();
        students.add(new Student("John Doe", "Computer Science", "1st year"));
        students.add(new Student("John Smith", "Computer Science", "1st year"));
        students.add(new Student("Petter Parker", "Information Science", "1st year"));
        students.add(new Student("Bruce Banner", "Information Science", "3rd year"));
        students.add(new Student("Tony Stark", "Information Science", "3rd year"));

        studentManager = new StudentManager(students);
    }

    @Test
    void testSortStudentsByFacultyAndYear() {
        Map<String, List<Student>> sortedStudents = studentManager.sortStudentsByFacultyAndYear(students);

        List<Student> computerScience1stYear = Arrays.asList(
                new Student("John Doe", "Computer Science", "1st year"),
                new Student("John Smith", "Computer Science", "1st year")
        );

        List<Student> informationScience1stYear = Collections.singletonList(
                new Student("Petter Parker", "Information Science", "1st year")
        );

        List<Student> informationScience3rdYear = Arrays.asList(
                new Student("Bruce Banner", "Information Science", "3rd year"),
                new Student("Tony Stark", "Information Science", "3rd year")
        );

        assertEquals(3, sortedStudents.size());
        assertTrue(sortedStudents.containsKey("1st year Computer Science"));
        assertTrue(sortedStudents.containsKey("1st year Information Science"));
        assertTrue(sortedStudents.containsKey("3rd year Information Science"));

        assertEquals(computerScience1stYear, sortedStudents.get("1st year Computer Science"));
        assertEquals(informationScience1stYear, sortedStudents.get("1st year Information Science"));
        assertEquals(informationScience3rdYear, sortedStudents.get("3rd year Information Science"));
    }

    @Test
    void testAddStudent() {
        Student pinkyBrown = new Student("Pinky Brown", "Computer Science", "2nd year");
        studentManager.addStudent(pinkyBrown);

        assertTrue(studentManager.getStudents().contains(pinkyBrown));
    }

    @Test
    void testRemoveStudentByName() {
        String nameToRemove = "John Doe";
        studentManager.removeStudentByName(nameToRemove);

        assertTrue(studentManager.getStudents().stream()
                .noneMatch(student -> student.getName().equals(nameToRemove)));
    }

    @Test
    void tesGetClassmates() {
        List<Student> actualClassMates = studentManager.getClassmates("Computer Science", "1st year");
        List<Student> expectedClassMates = Arrays.asList(
                new Student("John Doe", "Computer Science", "1st year"),
                new Student("John Smith", "Computer Science", "1st year")
        );

        assertEquals(expectedClassMates, actualClassMates);
    }
}
