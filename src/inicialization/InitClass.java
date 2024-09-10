package inicialization;

import services.StudentService;
import views.Menu;
import views.Register;

import javax.sql.DataSource;

public class InitClass {

    private static class SingletonMenu {
        private static final Menu menu = new Menu();
    }
    public static Menu InitMenu() {
        return SingletonMenu.menu;
    }

    private static class SingletonRegister {
        private static final Register register = new Register();
    }
    public static Register InitRegister() {
        return SingletonRegister.register;
    }

    private static class SingletonStudentService {
        private static final StudentService service = new StudentService();
    }
    public static StudentService InitStudentService() {
        return SingletonStudentService.service;
    }


}
