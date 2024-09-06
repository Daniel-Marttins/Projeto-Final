package repositories;

import models.Student;

import java.util.List;

public interface StudentRepository {

    public void saveStudent(String file);
    public Student getStudentById(String file);
    public Student getStudentByLogin(String file);
    public List<Student> getAllStudents(String filePath);
    public Student updateStudent(String file);
    public void deleteStudent(String email, String password);
    public void deleteStudentTeacher(String file);

}
