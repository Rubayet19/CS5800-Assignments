import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SongServiceProxy implements SongService {
    private final SongService realService;
    private final Map<Integer, Song> songCache;

    public SongServiceProxy(SongService realService) {
        this.realService = realService;
        this.songCache = new HashMap<>();
    }

    @Override
    public Song searchById(Integer songID) {
        long startTime = System.nanoTime();
        Song song = songCache.get(songID);
        if (song == null) {
            song = realService.searchById(songID);
            songCache.put(songID, song);
        }
        long endTime = System.nanoTime();
        long responseTime = endTime - startTime;
        System.out.println("Response time for searchById: " + responseTime + " nanoseconds");
        return song;
    }

    @Override
    public List<Song> searchByTitle(String title) {
        long startTime = System.nanoTime();
        List<Song> songs = realService.searchByTitle(title);
        long endTime = System.nanoTime();
        long responseTime = endTime - startTime;
        System.out.println("Response time for searchByTitle: " + responseTime + " nanoseconds");
        return songs;
    }

    @Override
    public List<Song> searchByAlbum(String album) {
        long startTime = System.nanoTime();
        List<Song> songs = realService.searchByAlbum(album);
        long endTime = System.nanoTime();
        long responseTime = endTime - startTime;
        System.out.println("Response time for searchByAlbum: " + responseTime + " nanoseconds");
        return songs;
    }
}