package views;

import dtos.RoomDTO;
import models.Room;
import models.Teacher;
import org.ini4j.Wini;

import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
            else if(menuOption == 1) viewRoom(teacher);
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

            iniReader.store();

            room = new Room(
                    Long.parseLong(getRoomsQuantity + 1),
                    name,
                    Integer.parseInt(average),
                    null,
                    null,
                    null
            );

            fileWriter = new FileWriter(teacher.getPath(), true);
            writer = new PrintWriter(fileWriter);
            writer.print("");
            writer.println(room);

            writer.close();

            JOptionPane.showMessageDialog(
                    null,
                    "Sala criada com sucesso!",
                    "Sucesso",
                    JOptionPane.INFORMATION_MESSAGE
            );

        } catch (IOException e) {
            JOptionPane.showMessageDialog(
                    null,
                    "Erro ao acessar ou criar o arquivo: \n" + e.getMessage(),
                    "Erro",
                    JOptionPane.ERROR_MESSAGE
            );
        }

    }

    public void viewRoom(Teacher teacher) {
        try {
            iniFile = new File(teacher.getPath());
            iniReader = new Wini(iniFile);

            List<RoomDTO> roomsList = new ArrayList<>();

            String validExistsRoom = iniReader.get("ROOMS", "QUANTITY", String.class);
            if (Integer.parseInt(validExistsRoom) > 0) {
                for (String sectionName : iniReader.keySet()) {
                    if (sectionName.startsWith("ROOMS.")) {
                        String roomName = sectionName.substring("ROOMS.".length());

                        Map<String, String> keys = iniReader.get(sectionName);

                        RoomDTO room = new RoomDTO(
                                Long.parseLong(keys.get("ID")),
                                keys.get("NAME"),
                                keys.get("AVERAGE")
                        );

                        roomsList.add(room);

                    }
                }

                StringBuilder sb = new StringBuilder();
                for (RoomDTO room : roomsList) {
                    sb.append(room.toString()).append("\n");
                }

                JOptionPane.showMessageDialog(null, sb.toString(), "Salas Encontradas", JOptionPane.INFORMATION_MESSAGE);

                return;
            }

            JOptionPane.showMessageDialog(
                    null,
                    "Nenhuma sala encontrada, cadastre algumas para visualizar",
                    "Salas não encontradas",
                    JOptionPane.ERROR_MESSAGE
            );

        } catch (IOException e) {
            JOptionPane.showMessageDialog(
                    null,
                    "Erro ao acessar o arquivo: \n" + e.getMessage(),
                    "Erro",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

}
