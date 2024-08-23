package MovieStreamingApplication3b;

public class VolumeControl extends MusicPlayerDecorator {

	public VolumeControl(MusicPlayer musicPlayer) {
        super(musicPlayer);
    }

    public void playMusic() {
        super.playMusic();
        System.out.println("Adjusting volume.");
    }

}
