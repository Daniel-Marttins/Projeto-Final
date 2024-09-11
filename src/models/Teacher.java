package models;

import java.util.List;

public class Teacher {

    private Long id;
    private String name;
    private String email;
    private String path;
    private String password;
    private List<Room> roomList;

    public Teacher() {}

    public Teacher(Long id, String name, String email, String path, String password, List<Room> roomList) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.path = path;
        this.password = password;
        this.roomList = roomList;
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

    public void setEmail(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Room> getRoomList() {
        return roomList;
    }

    public void setRoomList(List<Room> roomList) {
        this.roomList = roomList;
    }

    @Override
    public String toString() {
        return "[BASIC INFO] \n" +
                "ID=" + id + "\n" +
                "NAME=" + name + "\n" +
                "EMAIL=" + email + "\n" +
                "PATH=" + path + "\n" +
                "PASSWORD=" + password + "\n\n" +
                "[ROOMS] \n" +
                "QUANTITY=0"
        ;
    }
}
