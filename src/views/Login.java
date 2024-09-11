package views;

import models.Student;

import javax.swing.*;


import static inicialization.InitClass.initMenu;
import static inicialization.InitClass.initStudentService;
import static utils.SystemUtils.validAndCreatePath;

public class Login {

    public Login() {}

    public void loginStudent(String databasePath) {
        String pathStudents = databasePath + "\\students";
        String createPath = validAndCreatePath(pathStudents);
        switch (createPath) {
            case "ok", "exists" -> {
                initStudentService().getStudentByLogin(pathStudents);
                if(initStudentService().getStudent() != null) {
                   initMenu().mainMenuStudent(initStudentService().getStudent());
                }
            }
            case "error" -> JOptionPane.showMessageDialog(
                    null,
                    "Erro ao pasta de estudantes",
                    "Erro ao criar pasta",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    public void loginTeacher(String databasePath) {}

}
