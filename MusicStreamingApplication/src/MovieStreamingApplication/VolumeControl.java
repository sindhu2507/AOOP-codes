package MovieStreamingApplication;

public class VolumeControl extends MusicSourceDecorator{

	public VolumeControl(MusicSource musicSource) {
		super(musicSource);
		// TODO Auto-generated constructor stub
	}
	public void play() {
        super.play();
        System.out.println("Adjusting volume.");
    }

}
