package forms;

import models.Grade;
import models.Room;
import models.Student;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import static utils.SystemUtils.countFilesInDirectory;
import static utils.SystemUtils.validExistPath;

public class StudentForm {

    public static Student initForm(String studentPath) {
        Long id = countFilesInDirectory(studentPath) + 1;
        String name = JOptionPane.showInputDialog(null, "Informe seu nome: ");
        String email = JOptionPane.showInputDialog(null, "Informe um email: ");
        JPasswordField passwordField = new JPasswordField();
        JOptionPane.showConfirmDialog(null, new Object[]{"Informe uma senha: ", passwordField}, "Senha", 0);
        List<Room> rooms = new ArrayList<>();
        List<Grade> grades = new ArrayList<>();

        Student student = new Student(
                id,
                name,
                email,
                new String(passwordField.getPassword()),
                rooms,
                grades
        );

        PrintWriter writer;

        String studentFile = studentPath + "\\" + email + ".txt";
        if(validExistPath(studentFile).equals("exists")) {
            JOptionPane.showMessageDialog(
                    null,
                    "O usuário [ " + email + " ] já existe, tente fazer o login!",
                    "Cadastro encontrado",
                    JOptionPane.INFORMATION_MESSAGE
            );
            return null;
        }

        try {
            writer = new PrintWriter(studentFile);
            writer.println(student);
            writer.close();
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        }

        return student;
    }

}
