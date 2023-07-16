public class AudioPlayer {
    protected State state;
    protected boolean playing;

    public AudioPlayer() {
        this.state = new ReadyState(this);
        playing = true;
    }

    public boolean isPlaying() {
        return playing;
    }

    public void changeState(State state) {
        this.state = state;
    }

    public void clickLock() {
        state.clickLock();
    }

    public void clickPlay() {
        state.clickPlay();
    }

    public void clickNext() {
        state.clickNext();
    }

    public void clickPrevious() {
        state.clickPrevious();
    }

    public void startPlayback() {
        if(playing) {
            this.stopPlayback();
        }
        else {
            this.playing = true;
            System.out.println("[>>] Playback started!");
        }
    }
    
    public void stopPlayback() {
        if(!playing) {
            this.startPlayback();
        }
        else {
            this.playing = false;
            System.out.println("[>>] Playback stopped!");
        }
    }

    public void nextSong() {
        playing = true;
        System.out.println("[>>] Switching to next song!");
    }

    public void previousSong() {
        playing = true;
        System.out.println("[>>] Switching to previous song!");
    }
}