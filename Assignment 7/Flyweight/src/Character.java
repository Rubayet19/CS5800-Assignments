public class Character {
    private final char c;
    private final CharacterProperties properties;

    public Character(char c, CharacterProperties properties) {
        this.c = c;
        this.properties = properties;
    }

    public char getChar() {
        return c;
    }

    public CharacterProperties getProperties() {
        return properties;
    }
}