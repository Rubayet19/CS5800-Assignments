import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SongIdGenerator {
    private final Random random;
    private final List<Integer> usedIds;
    private final int minId;
    private final int maxId;

    public SongIdGenerator(int minId, int maxId) {
        this.minId = minId;
        this.maxId = maxId;
        this.random = new Random();
        this.usedIds = new ArrayList<>();
    }

    public int generateId() {
        int id;
        do {
            id = random.nextInt(maxId - minId + 1) + minId;
        } while (usedIds.contains(id));
        usedIds.add(id);
        return id;
    }
}