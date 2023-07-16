public class Editor {
    private EventManager eventManager;
    private EventListeners listener;
    private String file;

    public Editor() {
        eventManager = new EventManager();
    }

    public void openFile(String path, EventListeners listener) {
        this.file = path;
        this.listener = listener;
        eventManager.subscribe("open", listener);
        eventManager.notify("open", file);
    }

    public void saveFile() {
        eventManager.subscribe("save", listener);
        eventManager.notify("save", file);
    }
}
