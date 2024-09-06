public class Configuration {
    public String APP_PATH = "";
    public String APP_DB_PATH = "";

    private Configuration() {
        final String DIR = System.getProperty("user.dir");
        APP_PATH = DIR;
        APP_DB_PATH = DIR + "\\src\\database\\";
    }

    private static class SingletonHolder {
        private static final Configuration config = new Configuration();
    }

    public static Configuration getConfig() {
        return SingletonHolder.config;
    }

}
