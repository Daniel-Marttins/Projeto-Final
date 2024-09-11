package services;

import models.Student;
import repositories.StudentRepository;

import java.util.List;
import org.modelmapper.ModelMapper;

import static forms.StudentForm.initFormLogin;
import static forms.StudentForm.initFormRegister;

public class StudentService implements StudentRepository {

    public StudentService() {}

    private final ModelMapper modelMapper = new ModelMapper();

    private Student student;

    @Override
    public void saveStudent(String file) {
        initFormRegister(file);
    }

    @Override
    public Student getStudentById(String file) {
        return null;
    }

    @Override
    public void getStudentByLogin(String file) {
        Student object = initFormLogin(file);
        if(object != null) student = modelMapper.map(object, Student.class);
    }

    @Override
    public List<Student> getAllStudents(String filePath) {
        return null;
    }

    @Override
    public Student updateStudent(String file) {
        return null;
    }

    @Override
    public void deleteStudent(String email, String password) {}

    @Override
    public void deleteStudentTeacher(String file) {}

    public Student getStudent() {
        return student;
    }
}
