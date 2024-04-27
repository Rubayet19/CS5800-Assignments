import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Document {
    private final List<Character> characters;
    private final FlyweightFactory flyweightFactory;

    public Document(FlyweightFactory flyweightFactory) {
        characters = new ArrayList<>();
        this.flyweightFactory = flyweightFactory;
    }

    public void addCharacter(char c, String font, String color, int size) {
        CharacterProperties properties = flyweightFactory.getProperties(font, color, size);
        characters.add(new Character(c, properties));
    }

    public List<Character> getCharacters() {
        return characters;
    }

    public void saveToFile(String filename) throws IOException {
        try (PrintWriter writer = new PrintWriter(filename)) {
            for (Character character : characters) {
                writer.print(character.getChar());
                writer.print(",");
                writer.print(character.getProperties().getFont());
                writer.print(",");
                writer.print(character.getProperties().getColor());
                writer.print(",");
                writer.print(character.getProperties().getSize());
                writer.println();
            }
            writer.close();
        }
    }

    public Document loadFromFile(String filename, FlyweightFactory flyweightFactory) throws IOException {
        Document document = new Document(flyweightFactory);
        try (Scanner scanner = new Scanner(new File(filename))) {
            scanner.useDelimiter(",|\\R");
            while (scanner.hasNext()) {
                char c = scanner.next().charAt(0);
                String font = scanner.next();
                String color = scanner.next();
                int size = scanner.nextInt();
                document.addCharacter(c, font, color, size);
            }
            
        }
        catch(InputMismatchException e){
            // System.out.println("Error!");
            // Scanner scanner2 = new Scanner(new File(filename));
            // scanner2.reset();
            e.printStackTrace();
        }
        return document;
    }
}