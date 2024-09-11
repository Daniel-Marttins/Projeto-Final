package services;

import models.Student;
import models.Teacher;
import org.modelmapper.ModelMapper;
import repositories.TeacherRepository;

import java.util.List;

import static forms.TeacherForm.initFormLogin;
import static forms.TeacherForm.initForm;

public class TeacherService implements TeacherRepository {

    public TeacherService() {}

    private final ModelMapper modelMapper = new ModelMapper();

    private Teacher teacher;

    @Override
    public void saveTeacher(String file) {
        initForm(file);
    }

    @Override
    public Teacher getTeacherById(String file) {
        return null;
    }

    @Override
    public void getTeacherByLogin(String file) {
        Teacher object = initFormLogin(file);
        if(object != null) teacher = modelMapper.map(object, Teacher.class);
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
    public void deleteTeacher(String email, String password) {}

    public Teacher getTeacher() {
        return teacher;
    }
}
