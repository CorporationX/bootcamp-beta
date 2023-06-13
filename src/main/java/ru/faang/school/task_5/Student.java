package ru.faang.school.task_5;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

@Getter
@EqualsAndHashCode
public class Student {

    private static final List<String> FACULTY_LIST = Arrays.asList("Computer Science","Computer Engineering", "Information Systems", "Information Science");
    private static final List<String> UNIVERSITY_YEARS = Arrays.asList("1st year","2nd year","3rd year");
    private String name;
    private String faculty;
    private String year;

    public Student(String name, String faculty, String year) {
        validateInput(name,faculty,year);

        this.name = name;
        this.faculty = faculty;
        this.year = year;
    }

    private void validateInput(String name,String faculty,String year){
        if(name.isBlank()){
            throw new NoSuchElementException("Name can't be empty");
        }

        if(!FACULTY_LIST.contains(faculty)){
            throw new NoSuchElementException("University doesn't have this faculty");
        }

        if(!UNIVERSITY_YEARS.contains(year)){
            throw new NoSuchElementException("There years are in range from 1 to 3");
        }
    }
}
