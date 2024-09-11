package forms;

import models.Grade;
import models.Room;
import models.Student;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import org.ini4j.Wini;
import java.io.File;
import java.io.IOException;

import static utils.SystemUtils.countFilesInDirectory;
import static utils.SystemUtils.validExistPath;

public class StudentForm {

    private static File iniFile;
    private static Wini iniReader;

    public static Student initFormRegister(String studentPath) {
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

        String studentFile = studentPath + "\\" + email + ".ini";
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
            JOptionPane.showMessageDialog(
                    null,
                    e.getMessage(),
                    "Erro ao criar usuário: [ ERROR ]",
                    JOptionPane.ERROR_MESSAGE
            );
        }

        return student;
    }

    public static Student initFormLogin(String studentPath) {
        String email = JOptionPane.showInputDialog(null, "Email: ");
        JPasswordField passwordField = new JPasswordField();
        JOptionPane.showConfirmDialog(null, new Object[]{"Senha: ", passwordField}, "Senha", 0);
        String studentFile = studentPath + "\\" + email + ".ini";

        if(validExistPath(studentFile).equals("exists")) {
            try {
                iniFile = new File(studentFile);
                iniReader = new Wini(iniFile);

                String getPassword = iniReader.get("BASIC INFO", "PASSWORD", String.class);

                if(getPassword.equals(new String(passwordField.getPassword()))) {
                    return new Student(
                            Long.parseLong(iniReader.get("BASIC INFO", "ID", String.class)),
                            iniReader.get("BASIC INFO", "NAME", String.class),
                            iniReader.get("BASIC INFO", "EMAIL", String.class),
                            iniReader.get("BASIC INFO", "PASSWORD", String.class),
                            null,
                            null
                    );
                }

                JOptionPane.showMessageDialog(
                        null,
                        "Senha ou email incorretos",
                        "Credências Inválidas",
                        JOptionPane.ERROR_MESSAGE
                );

                return null;

            } catch (IOException | SecurityException e) {
                JOptionPane.showMessageDialog(
                        null,
                        "Erro ao acessar o arquivo: \n" + e.getMessage(),
                        "Erro",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        }

        JOptionPane.showMessageDialog(
                null,
                "Usuário não encontrado, verifique o email ou realize o cadastro!",
                "Falha ao buscar usuário",
                JOptionPane.ERROR_MESSAGE
        );

        return null;
    }

}
