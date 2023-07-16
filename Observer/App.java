public class App {
    public static void main(String[] args) {
        String file = "./files/somefile";
        Editor editor = new Editor();
        // Notify Logger
        LoggingListener logger = new LoggingListener(file);
        editor.openFile(file, logger);
        editor.saveFile();
        // Notify Email
        EmailAlertsListener emailAlerts = new EmailAlertsListener("admin@mail.com");
        editor.openFile(file, emailAlerts);
        editor.saveFile();
    }
}
