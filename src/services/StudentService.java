package services;

import models.Student;
import repositories.StudentRepository;

import java.util.List;

public class StudentService implements StudentRepository {

    @Override
    public void saveStudent(String file) {

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
    public void deleteStudent(String email, String password) {

    }

    @Override
    public void deleteStudentTeacher(String file) {

    }
}
