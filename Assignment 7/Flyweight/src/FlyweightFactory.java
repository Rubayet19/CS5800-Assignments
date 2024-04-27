import java.util.HashMap;
import java.util.Map;

public class FlyweightFactory {
    private static Map<String, CharacterProperties> propertiesCache;

    public FlyweightFactory() {
        propertiesCache = new HashMap<>();
    }

    public CharacterProperties getProperties(String font, String color, int size) {
        String key = font + "_" + color + "_" + size;
        CharacterProperties properties = propertiesCache.get(key);
        if (properties == null) {
            properties = new CharacterProperties(font, color, size);
            propertiesCache.put(key, properties);
        }
        return properties;
    }
}