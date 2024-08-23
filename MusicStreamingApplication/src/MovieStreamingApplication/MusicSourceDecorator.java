package MovieStreamingApplication;

abstract class MusicSourceDecorator implements MusicSource{
	protected MusicSource decoratedMusicSource;

    public MusicSourceDecorator(MusicSource musicSource) {
        this.decoratedMusicSource = musicSource;
    }

    public void play() {
        decoratedMusicSource.play();
    }
}
