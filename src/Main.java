import inicialization.InitClass;

import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.UIManager;

public class Main {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (Exception e) {
            e.printStackTrace();
        }

        InitClass.initMenu().startMenu(
                Configuration.getConfig().APP_PATH,
                Configuration.getConfig().APP_DB_PATH
        );
    }
}