package utils;

import javax.swing.*;
import java.io.File;

public class SystemUtils {

    public static String validAndCreatePath(String path) {
        File directory = new File(path);
        if (!directory.exists()) {
            if (directory.mkdirs()) {
                return "created";
            } else {
                return "error";
            }
        } else {
            return "exists";
        }
    }

    public static String validExistPath(String path) {
        File file = new File(path);
        if (file.exists()) {
            return "exists";
        } else {
            return "not exists";
        }
    }

    public static Long countFilesInDirectory(String directoryPath) {
        File directory = new File(directoryPath);

        if (!directory.exists() || !directory.isDirectory()) {
            JOptionPane.showMessageDialog(
                    null,
                    "O caminho fornecido não é um diretório válido.",
                    "Erro",
                    JOptionPane.ERROR_MESSAGE
            );
            return 0L;
        }

        File[] files = directory.listFiles();
        if (files == null) {
            return 0L;
        }

        int count = 0;
        for (File file : files) {
            if (file.isFile()) {
                count++;
            }
        }

        return (long) count;
    }

}
