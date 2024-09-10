package repositories;

import models.Teacher;

import java.util.List;

public interface TeacherRepository {

    public void saveTeacher(String file);
    public Teacher getTeacherById(String file);
    public Teacher getTeacherByLogin(String file);
    public List<Teacher> getAllTeacher(String filePath);
    public Teacher updateTeacher(String file);
    public void deleteTeacher(String email, String password);


}
