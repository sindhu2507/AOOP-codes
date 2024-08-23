package musicPlaylistUsingLinkedList;
import java.util.LinkedList;
public class MusicPlaylist {
	private LinkedList<String> playlist = new LinkedList<>();

    public void addSong(String song) {
        playlist.add(song);
    }

    public void removeSong(String song) {
        if (playlist.remove(song)) {
            System.out.println("Removed: " + song);
        } else {
            System.out.println("Song not found in playlist.");
        }
    }

    public void moveSong(int oldIndex, int newIndex) {
        if (oldIndex >= 0 && oldIndex < playlist.size() && newIndex >= 0 && newIndex < playlist.size()) {
            String song = playlist.remove(oldIndex);
            playlist.add(newIndex, song);
            System.out.println("Moved song to position: " + (newIndex + 1));
        } else {
            System.out.println("Invalid index.");
        }
    }

    public void displayPlaylist() {
        System.out.println("Playlist:");
        for (int i = 0; i < playlist.size(); i++) {
            System.out.println((i + 1) + ". " + playlist.get(i));
        }
    }
}
