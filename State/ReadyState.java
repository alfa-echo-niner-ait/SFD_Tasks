public class ReadyState extends State {

    public ReadyState(AudioPlayer player) {
        super(player);
    }
    
    public void clickLock() {
        System.out.println("[>>] Player locked!");
        player.changeState(new LockedState(player));
    }

    public void clickPlay() {
        player.startPlayback();
        player.changeState(new PlayingState(player));
    }

    public void clickNext() {
        player.nextSong();
    }

    public void clickPrevious() {
        player.previousSong();
    }
}
