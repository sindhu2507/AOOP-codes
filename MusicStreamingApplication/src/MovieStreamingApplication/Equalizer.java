package MovieStreamingApplication;

public class Equalizer extends MusicSourceDecorator{

	public Equalizer(MusicSource musicSource) {
		super(musicSource);
		// TODO Auto-generated constructor stub
	}
		public void play() {
	        super.play();
	        System.out.println("Applying equalizer settings.");
	    }
	

}
