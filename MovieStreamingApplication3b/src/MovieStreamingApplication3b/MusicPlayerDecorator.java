package MovieStreamingApplication3b;

public abstract class MusicPlayerDecorator extends MusicPlayer{
	protected MusicPlayer decoratedMusicPlayer;

	public MusicPlayerDecorator(MusicPlayer musicPlayer) {
		super(musicPlayer.musicSource);
		// TODO Auto-generated constructor stub
		this.decoratedMusicPlayer = musicPlayer;
	}
	public void playMusic() {
        decoratedMusicPlayer.playMusic();
    }

}
