public class LoggingListener implements EventListeners {
    
    private String filename;

    public LoggingListener(String Filename) {
        this.filename = Filename;
    }

    public void update(String eventType, String Filename) {
        this.filename = Filename;
        System.out.println("\nNotified: Logger -> " + eventType + ": " + filename + "\n");
    }
}
