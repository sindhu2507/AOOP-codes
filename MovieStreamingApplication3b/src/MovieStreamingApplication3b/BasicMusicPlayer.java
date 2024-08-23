package MovieStreamingApplication3b;

public class BasicMusicPlayer extends MusicPlayer{

	public BasicMusicPlayer(MusicSource musicSource) {
		super(musicSource);
		// TODO Auto-generated constructor stub
	}
	public void playMusic() {
        musicSource.play();
    }

}
