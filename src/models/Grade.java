package models;

public class Grade {

    private Long id;
    private String module;
    private Student student;
    private Room room;
    private double grade;

    public Grade() {}

    public Grade(Long id, String module, Student student, Room room, double grade) {
        this.id = id;
        this.module = module;
        this.student = student;
        this.room = room;
        this.grade = grade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "[" + module + "] [\n" +
                    "ID=" + id + "\n" +
                    "MODULE=" + module + "\n" +
                    "GRADE=" + grade + "\n" +
                "]"
        ;
    }
}
