package MovieStreamingApplication3b;

public class MusicStreamingApp {
	public static void main(String[] args) {
        MusicSource localFile = new LocalFilePlayer();
        MusicPlayer player = new BasicMusicPlayer(localFile);

        // Add features using decorators
        player = new VolumeControl(new Equalizer(player));
        player.playMusic();

        // Play from online streaming service with the same features
        MusicSource onlineStream = new OnlineStreamingPlayer();
        player = new VolumeControl(new Equalizer(new BasicMusicPlayer(onlineStream)));
        player.playMusic();

        // Play from radio station without extra features
        MusicSource radio = new RadioStationPlayer();
        player = new BasicMusicPlayer(radio);
        player.playMusic();
    }
}
