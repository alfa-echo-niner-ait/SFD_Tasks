import java.util.HashMap;

public class EventManager {
    // Hashmap of Events and Listeners Type
    private HashMap<String, EventListeners> listeners = new HashMap<String, EventListeners>();

    public void subscribe(String eventType, EventListeners listener) {
        listeners.put(eventType, listener);
    }

    public void unsubscribe(String eventType, EventListeners listener) {
        listeners.remove(eventType, listener);
    }

    public void notify(String eventType, String file) {
        listeners.get(eventType).update(eventType, file);
    }
}
