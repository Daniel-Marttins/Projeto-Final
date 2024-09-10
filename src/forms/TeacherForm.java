package forms;

import models.Room;
import models.Student;
import models.Teacher;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import static utils.SystemUtils.countFilesInDirectory;
import static utils.SystemUtils.validExistPath;

public class TeacherForm {

    public static Teacher initForm(String teacherPath) {
        Long id = countFilesInDirectory(teacherPath) + 1;
        String name = JOptionPane.showInputDialog(null, "Informe seu nome: ");
        String email = JOptionPane.showInputDialog(null, "Informe um email: ");
        JPasswordField passwordField = new JPasswordField();
        JOptionPane.showConfirmDialog(null, new Object[]{"Informe uma senha: ", passwordField}, "Senha", 0);
        List<Room> rooms = new ArrayList<>();

        Teacher teacher = new Teacher(
                id,
                name,
                email,
                new String(passwordField.getPassword()),
                rooms
        );

        PrintWriter writer;

        String studentFile = teacherPath + "\\" + email + ".ini";
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
            writer.println(teacher);
            writer.close();
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
            JOptionPane.showMessageDialog(
                    null,
                    e.getMessage(),
                    "Erro ao criar usuário: [ ERROR ]",
                    JOptionPane.ERROR_MESSAGE
            );
        }

        return teacher;
    }

}
