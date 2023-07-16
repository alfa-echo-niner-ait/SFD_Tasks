abstract class State {
    
    protected AudioPlayer player;

    public State(AudioPlayer player) {
        this.player = player;
    }

    public abstract void clickLock();

    public abstract void clickPlay();

    public abstract void clickNext();

    public abstract void clickPrevious();
}