public class PlayingState extends State {
    
    public PlayingState(AudioPlayer player) {
        super(player);
    }

    public void clickLock() {
        System.out.println("[>>] Player locked!");
        player.changeState(new LockedState(player));
    }

    public void clickPlay() {
        player.stopPlayback();
        player.changeState(new ReadyState(player));
    }

    public void clickNext() {
        player.nextSong();
    }

    public void clickPrevious() {
        player.previousSong();
    }
}
