package ru.faang.school.hashmap.task_3.student;

import java.util.Objects;

public class Student {
    private String name;
    private String faculty;
    private int course;

    public Student(String name, String faculty, int course) {
        this.name = name;
        this.faculty = faculty;
        checkCourse(course);
        this.course = course;
    }

    private void checkCourse(int course) {
        if (course < 1 || course > 4) {
            throw new IllegalArgumentException("Не допустимое значение курса студента. Студент может учиться на курсе 1-4");
        }
    }

    public Grup getFacultyYear() {
        return new Grup(faculty, course);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public int getYear() {
        return course;
    }

    public void setYear(int course) {
        checkCourse(course);
        this.course = course;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return course == student.course && Objects.equals(name, student.name) && Objects.equals(faculty, student.faculty);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, faculty, course);
    }

    @Override
    public String toString() {
        return "Student: " + name + " faculty: " + faculty + " Курс: " + course;
    }
}
