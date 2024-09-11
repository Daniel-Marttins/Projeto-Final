package views;

import models.Room;
import models.Teacher;
import org.ini4j.Wini;

import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class TeacherView {

    public TeacherView() {}

    Room room;

    static File iniFile;
    static Wini iniReader;

    FileWriter fileWriter;
    PrintWriter writer;

    public void teacherRooms(Teacher teacher) {
        Object[] options = {
                "Criar sala",
                "Ver salas",
                "Apagar sala",
                "Voltar"
        };

        while (true) {
            int menuOption = JOptionPane.showOptionDialog(
                    null,
                    "Menu Salas",
                    "Projeto Final",
                    JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    options,
                    null
            );

            if(menuOption == 0) createRoom(teacher);
            else if(menuOption == 1) System.out.println("Ver");
            else if(menuOption == 2) System.out.println("Deletar");
            else if(menuOption == 3) break;
        }

    }

    public void createRoom(Teacher teacher) {
        try {
            iniFile = new File(teacher.getPath());
            iniReader = new Wini(iniFile);

            String name = JOptionPane.showInputDialog(null, "Nome da Sala: ");
            String validExistsRoom = iniReader.get("ROOMS." + name, "NAME", String.class);
            if (validExistsRoom != null) {
                JOptionPane.showMessageDialog(
                        null,
                        "Sala já existe",
                        "Sala encontrada",
                        JOptionPane.WARNING_MESSAGE
                );
                return;
            }

            String average = JOptionPane.showInputDialog(null, "Média da Sala: ");

            String getRoomsQuantity = iniReader.get("ROOMS", "QUANTITY", String.class);
            iniReader.put("ROOMS", "QUANTITY", Integer.parseInt(getRoomsQuantity + 1));

            room = new Room(
                    Long.parseLong(getRoomsQuantity),
                    name,
                    Integer.parseInt(average),
                    null,
                    null,
                    null
            );

            JOptionPane.showMessageDialog(
                    null,
                    "Sala criada com sucesso!",
                    "Sucesso",
                    JOptionPane.INFORMATION_MESSAGE
            );

            iniReader.store();

        } catch (IOException e) {
            JOptionPane.showMessageDialog(
                    null,
                    "Erro ao acessar ou criar o arquivo: \n" + e.getMessage(),
                    "Erro",
                    JOptionPane.ERROR_MESSAGE
            );
        }

    }

}
