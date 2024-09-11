package inicialization;

import services.StudentService;
import services.TeacherService;
import views.Login;
import views.Menu;
import views.Register;

public class InitClass {

    // MENU
    private static class SingletonMenu {
        private static final Menu menu = new Menu();
    }
    public static Menu initMenu() {
        return SingletonMenu.menu;
    }

    // REGISTER
    private static class SingletonRegister {
        private static final Register register = new Register();
    }
    public static Register initRegister() {
        return SingletonRegister.register;
    }

    // LOGIN
    private static class SingletonLogin {
        private static final Login login = new Login();
    }
    public static Login initLogin() {
        return SingletonLogin.login;
    }

    // STUDENT SERVICE
    private static class SingletonStudentService {
        private static final StudentService service = new StudentService();
    }
    public static StudentService initStudentService() {
        return SingletonStudentService.service;
    }

    // TEACHER SERVICE
    private static class SingletonTeacherService {
        private static final TeacherService service = new TeacherService();
    }
    public static TeacherService initTeacherService() {
        return SingletonTeacherService.service;
    }


}
