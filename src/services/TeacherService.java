package services;

import models.Teacher;
import repositories.TeacherRepository;

import java.util.List;

import static forms.TeacherForm.initForm;

public class TeacherService implements TeacherRepository {

    @Override
    public void saveTeacher(String file) {
        initForm(file);
    }

    @Override
    public Teacher getTeacherById(String file) {
        return null;
    }

    @Override
    public Teacher getTeacherByLogin(String file) {
        return null;
    }

    @Override
    public List<Teacher> getAllTeacher(String filePath) {
        return null;
    }

    @Override
    public Teacher updateTeacher(String file) {
        return null;
    }

    @Override
    public void deleteTeacher(String email, String password) {

    }
}
