public class LockedState extends State {
    
    public LockedState(AudioPlayer player) {
        super(player);
    }

    public void clickLock() {
        System.out.println("[>>] Player unlocked!");
        if(player.playing) {
            player.changeState(new PlayingState(player));
        }
        else {
            player.changeState(new ReadyState(player));
        }
    }

    public void clickPlay() {
        // Locked, so do nothing
        System.out.println("[>>] Can't play, Player locked!");
    }

    public void clickNext() {
        // Locked, so do nothing
        System.out.println("[>>] Can't play next, Player locked!");
    }

    public void clickPrevious() {
        // Locked, so do nothing
        System.out.println("[>>] Can't play previous, Player locked!");
    }

}
