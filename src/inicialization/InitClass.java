package inicialization;

import views.Menu;

public class InitClass {

    private static class SingletonMenu {
        private static final Menu menu = new Menu();
    }

    public static Menu InitMenu() {
        return SingletonMenu.menu;
    }


}
