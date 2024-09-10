package services;

import models.Student;
import repositories.StudentRepository;

import java.util.List;

import static forms.StudentForm.initForm;

public class StudentService implements StudentRepository {

    public StudentService() {}

    @Override
    public void saveStudent(String file) {
        initForm(file);
    }

    @Override
    public Student getStudentById(String file) {
        return null;
    }

    @Override
    public Student getStudentByLogin(String file) {
        return null;
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

}
