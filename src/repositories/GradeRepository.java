package repositories;

import models.Room;

import java.util.List;

public interface GradeRepository {

    public void saveGrade(String file);
    public Room getGradeById(String file);
    public Room getGradeByLogin(String file);
    public List<Room> getAllGrades(String filePath);
    public Room updateGrade(String file);
    public void deleteGrade(String email, String password);

}
