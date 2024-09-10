package models;

import java.util.List;

public class Student {

    private Long id;
    private String name;
    private String email;
    private String password;
    private List<Room> rooms;
    private List<Grade> grades;

    public Student() {}

    public Student(Long id, String name, String email, String password, List<Room> rooms, List<Grade> grades) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.rooms = rooms;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    public List<Grade> getGrades() {
        return grades;
    }

    public void setGrades(List<Grade> grades) {
        this.grades = grades;
    }

    @Override
    public String toString() {
        return "[BASIC INFO] \n" +
                "ID=" + id + "\n" +
                "NAME=" + name + "\n" +
                "EMAIL=" + email + "\n" +
                "PASSWORD=" + password
        ;
    }
}
