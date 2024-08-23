package MovieStreamingApplication3b;

public class Equalizer extends MusicPlayerDecorator{

	public Equalizer(MusicPlayer musicPlayer) {
        super(musicPlayer);
    }

    public void playMusic() {
        super.playMusic();
        System.out.println("Applying equalizer settings.");
    }

}
