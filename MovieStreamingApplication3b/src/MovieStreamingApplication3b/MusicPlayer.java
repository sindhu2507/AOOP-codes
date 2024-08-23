package MovieStreamingApplication3b;

abstract class MusicPlayer {
	protected MusicSource musicSource;

    public MusicPlayer(MusicSource musicSource) {
        this.musicSource = musicSource;
    }

    public abstract void playMusic();
}
