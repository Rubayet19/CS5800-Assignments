import java.util.List;

public class Driver {
    public static void main(String[] args) {
        SongService realService = new RealSongService();
        SongService proxyService = new SongServiceProxy(realService);

        Song song1 = new Song("Bohemian Rhapsody", "Queen", "A Night at the Opera", 354);
        Song song2 = new Song("Stairway to Heaven", "Led Zeppelin", "Led Zeppelin IV", 482);
        Song song3 = new Song("Hotel California", "Eagles", "Hotel California", 390);
        Song song4 = new Song("Smells Like Teen Spirit", "Nirvana", "Nevermind", 302);
        Song song5 = new Song("Sweet Child O' Mine", "Guns N' Roses", "Appetite for Destruction", 356);

        List<Song> searchResults;

        searchResults = proxyService.searchByTitle(song3.getTitle());
        System.out.println(searchResults);

        searchResults = proxyService.searchByAlbum("Nevermind");
        System.out.println(searchResults);

        searchResults = proxyService.searchByTitle("Bohemian Rhapsody");
        System.out.println(searchResults);
/* 
        searchResults = (List<Song>) proxyService.searchById(song4.getId());
        System.out.println(searchResults);

        searchResults = (List<Song>) proxyService.searchById(song5.getId());
        System.out.println(searchResults);
*/
        searchResults = proxyService.searchByAlbum("Nevermind");
        System.out.println(searchResults);

        searchResults = proxyService.searchByTitle(song5.getTitle());
        System.out.println(searchResults);

        searchResults = proxyService.searchByTitle(song4.getTitle());
        System.out.println(searchResults);

        searchResults = proxyService.searchByTitle(song4.getTitle());
        System.out.println(searchResults);
    }
}