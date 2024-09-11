package models;

import java.util.ArrayList;
import java.util.List;

public class Room {

    private Long id;
    private String name;
    private int average;
    private Teacher teacher;
    private List<Student> students;
    private List<Grade> grades;

    public Room() {}

    public Room(Long id, String name, int average, Teacher teacher, List<Student> students, List<Grade> grades) {
        this.id = id;
        this.name = name;
        this.average = average;
        this.teacher = teacher;
        this.students = students;
        this.grades = grades;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAverage() {
        return average;
    }

    public void setAverage(int average) {
        this.average = average;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Grade> getGrades() {
        return grades;
    }

    public void setGrades(List<Grade> grades) {
        this.grades = grades;
    }

    @Override
    public String toString() {
        return "[ROOMS." + name + "] \n" +
                "ID=" + id + "\n" +
                "NAME=" + name + "\n" +
                "AVERAGE=" + average
        ;
    }
}
