package MovieStreamingApplication;

public class MusicStreamingApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MusicSource localFile = new LocalFilePlayer();
        MusicSource localFileWithFeatures = new VolumeControl(new Equalizer(localFile));
        localFileWithFeatures.play();

        MusicSource onlineStream = new OnlineStreamingPlayer();
        MusicSource onlineStreamWithFeatures = new Equalizer(onlineStream);
        onlineStreamWithFeatures.play();

        MusicSource radio = new RadioStationPlayer();
        radio.play(); 

	}

}
