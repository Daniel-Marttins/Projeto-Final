package dtos;

public class RoomDTO {

    private Long id;
    private String name;
    private String average;

    public RoomDTO() {}

    public RoomDTO(Long id, String name, String average) {
        this.id = id;
        this.name = name;
        this.average = average;
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

    public String getAverage() {
        return average;
    }

    public void setAverage(String average) {
        this.average = average;
    }

    @Override
    public String toString() {
        return "ID = " + id + "\n" +
               "NOME = " + name + "\n" +
               "MÉDIA = " + average + "\n" +
               "---------------------------" + "\n"
        ;
    }
}
