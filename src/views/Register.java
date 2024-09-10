package views;

import inicialization.InitClass;
import javax.swing.*;

import static inicialization.InitClass.InitStudentService;
import static utils.SystemUtils.validAndCreatePath;

public class Register {

    public Register () {}

    public void selectRegisterType(String databasePath) {
        Object[] options = {
                "Cadastrar Estudante",
                "Cadastrar Professor",
                "Voltar"
        };

        while (true) {
            int menuOption = JOptionPane.showOptionDialog(
                    null,
                    "Qual tipo de cadastro deseja realizar?",
                    "Cadastros",
                    JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    options,
                    null
            );

            if(menuOption == 0) registerStudent(databasePath);
            else if( menuOption == 1) registerTeacher(databasePath);
            else if(menuOption == 2) break;

        }

    }

    public void registerStudent(String databasePath) {
        String pathStudents = databasePath + "\\students";
        String createPath = validAndCreatePath(pathStudents);
        switch (createPath) {
            case "ok", "exists" -> InitStudentService().saveStudent(pathStudents);
            case "error" -> JOptionPane.showMessageDialog(
                    null,
                    "Erro ao pasta de estudantes",
                    "Erro ao criar pasta",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    public void registerTeacher(String databasePath) {
        String pathTeachers = databasePath + "\\teachers";
        String createPath = validAndCreatePath(pathTeachers);
    }


}
