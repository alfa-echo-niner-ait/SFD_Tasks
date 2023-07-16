public class EmailAlertsListener implements EventListeners {

    private String email;

    public EmailAlertsListener(String Email) {
        this.email = Email;
    }

    public void update(String eventType, String filename) {
        System.out.println("Notifed: " + email + " -> " + eventType + ": " + filename + "\n");
    }
}
