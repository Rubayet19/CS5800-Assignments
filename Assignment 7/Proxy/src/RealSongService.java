import java.util.ArrayList;
import java.util.List;

public class RealSongService implements SongService{
    private final List<Song> songsList;
    private final SongIdGenerator idGenerator;

    public RealSongService() {
        this.songsList = new ArrayList<>();
        this.idGenerator = new SongIdGenerator(100000, 999999);
        addSong(new Song("Bohemian Rhapsody", "Queen", "A Night at the Opera", 354));
        addSong(new Song("Stairway to Heaven", "Led Zeppelin", "Led Zeppelin IV", 482));
        addSong(new Song("Hotel California", "Eagles", "Hotel California", 390));
        addSong(new Song("Smells Like Teen Spirit", "Nirvana", "Nevermind", 302));
        addSong(new Song("Sweet Child O' Mine", "Guns N' Roses", "Appetite for Destruction", 356));
    }

    private void addSong(Song song) {
        song.setId(idGenerator.generateId());
        songsList.add(song);
    }

    @Override
    public Song searchById(Integer songID) {
        try {
            Thread.sleep(1000);
        } catch (Exception e) {}
        for (Song song : songsList) {
            if (song.getId().equals(songID)) {
                return song;
             }
        }
        return null;
    }
    @Override
    public List<Song> searchByTitle(String title) {
        try {
             Thread.sleep(1000);
        } catch (Exception e) {}
        List<Song> result = new ArrayList<>();
        for (Song song : songsList) {
            if (song.getTitle().equals(title)) {
               result.add(song);
            }
         }
         return result;
    }
    @Override
    public List<Song> searchByAlbum(String album) {
         try {
              Thread.sleep(1000);
         } catch (Exception e) {}
         List<Song> result = new ArrayList<>();
         for (Song song : songsList) {
             if (song.getAlbum().equals(album)) {
                 result.add(song);
             }
         }
         return result;
    }
}
