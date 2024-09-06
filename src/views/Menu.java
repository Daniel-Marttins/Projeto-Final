package views;

import javax.swing.*;

public class Menu {

    public Menu() { }

    public void startMenu(){
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
                    0
            );

            switch (menuOption) {
                case 0 -> System.out.println("Login estudante...");
                case 1 -> System.out.println("Login professor...");
                case 2 -> System.out.println("Cadastros...");
                case 3 -> System.out.println("Sobre o sistema...");
                case 4 -> {
                    System.out.println("Sair...");
                    System.exit(0);
                }
            }
        }

    }

}
