package ru.faang.school.task_5;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class StudentTest {

    @Test
    void testValidStudent() {
        String name = "John Doe";
        String faculty = "Computer Science";
        String year = "1st year";
        Student student = new Student(name, faculty, year);

        assertEquals(name, student.getName());
        assertEquals(faculty, student.getFaculty());
        assertEquals(year, student.getYear());
    }

    @Test
    void testIfNameIsEmpty() {
        String name = "";
        String faculty = "Computer Science";
        String year = "1st year";

        assertThrows(NoSuchElementException.class, () -> new Student(name, faculty, year));
    }

    @Test
    void testInvalidYear() {
        String name = "John Doe";
        String faculty = "Computer Science";
        String year = "4th year";

        assertThrows(NoSuchElementException.class, () -> new Student(name, faculty, year));
    }

    @Test
    void testInvalidFaculty() {
        String name = "John Doe";
        String faculty = "Physics";
        String year = "1st year";

        assertThrows(NoSuchElementException.class, () -> new Student(name, faculty, year));
    }
}
