package musicPlaylistUsingLinkedList;

public class Main {
	public static void main(String[] args) {
        MusicPlaylist playlist = new MusicPlaylist();
        playlist.addSong("Song 1");
        playlist.addSong("Song 2");
        playlist.displayPlaylist();
        
        playlist.moveSong(0, 1);
        playlist.displayPlaylist();
        
        playlist.removeSong("Song 2");
        playlist.displayPlaylist();
    }
}
