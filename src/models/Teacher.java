package models;

import java.util.List;

public class Teacher {

    private Long id;
    private String name;
    private String email;
    private String password;
    private List<Room> roomList;

    public Teacher() {}

    public Teacher(Long id, String name, String email, String password, List<Room> roomList) {
        this.id = id;
        this.name = name;
        this.email = email;
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

    public void setEmail(String email) {
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
        return "Teacher {" +
                "id = " + id +
                ", name = '" + name + '\'' +
                ", email = '" + email + '\'' +
                ", password = '" + password + '\'' +
                ", roomList = " + roomList +
                '}'
        ;
    }
}
