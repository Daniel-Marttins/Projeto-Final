import inicialization.InitClass;
import views.Menu;

public class Main {
    public static void main(String[] args) {
        InitClass.InitMenu().startMenu(
                Configuration.getConfig().APP_PATH,
                Configuration.getConfig().APP_DB_PATH
        );
    }
}