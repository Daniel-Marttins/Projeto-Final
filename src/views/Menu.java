package views;

import inicialization.InitClass;
import models.Student;
import models.Teacher;

import javax.swing.*;

public class Menu {

    public Menu() { }

    public void startMenu(String rootPath, String databasePath){
        Object[] options = {
                "Entrar Como Estudante",
                "Entrar Como Professor",
                "Cadastros",
                "Sobre o Sistema",
                "Sair"
        };

        while (true) {
            int menuOption = JOptionPane.showOptionDialog(
                    null,
                    "Realizar Login",
                    "Projeto Final",
                    JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    options,
                    null
            );
            switch (menuOption) {
                case 0 -> InitClass.initLogin().loginStudent(databasePath);
                case 1 -> InitClass.initLogin().loginTeacher(databasePath);
                case 2 -> InitClass.initRegister().selectRegisterType(databasePath);
                case 3 -> System.out.println("Sobre o sistema...");
                case 4 -> {
                    System.out.println("Sair...");
                    System.exit(0);
                }
            }
        }

    }

    public void mainMenuStudent(Student student) {
        Object[] options = {
                "Visualizar notas",
                "Minhas matérias",
                "Avaliações Disponiveis",
                "Atualizar minhas informações",
                "Apagar minha conta",
                "Sair"
        };

        while (true) {
            int menuOption = JOptionPane.showOptionDialog(
                    null,
                    "Seja bem vindo(a) " + student.getName(),
                    "Projeto Final",
                    JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    options,
                    null
            );

            if(menuOption == 0) System.out.println("Notas");
            else if(menuOption == 1) System.out.println("Matérias");
            else if(menuOption == 2) System.out.println("Avaliações");
            else if(menuOption == 3) System.out.println("Atualizar");
            else if(menuOption == 4) System.out.println("Deletar");
            else if(menuOption == 5) break;

        }

    }

    public void mainMenuTeacher(Teacher teacher) {
        Object[] options = {
                "Salas",
                "Matérias",
                "Avaliações",
                "Atualizar minhas informações",
                "Apagar minha conta",
                "Sair"
        };

        while (true) {
            int menuOption = JOptionPane.showOptionDialog(
                    null,
                    "Seja bem vindo(a) " + teacher.getName(),
                    "Projeto Final",
                    JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    options,
                    null
            );

            if(menuOption == 0) System.out.println("Salas");
            else if(menuOption == 1) System.out.println("Matérias");
            else if(menuOption == 2) System.out.println("Avaliações");
            else if(menuOption == 3) System.out.println("Atualizar");
            else if(menuOption == 4) System.out.println("Deletar");
            else if(menuOption == 5) break;

        }

    }

}
