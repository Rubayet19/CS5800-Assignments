import java.io.*;
import java.util.*;

public class Driver {
    public static void main(String[] args) throws IOException{
        FlyweightFactory factory = new FlyweightFactory();
        Document editor = new Document(factory);
        editor.addCharacter('l', "Calibri", "Blue", 74);
        editor.addCharacter('o', "Arial", "Red", 12);
        editor.addCharacter('W', "Calibri", "Blue", 43);


        try {
            editor.saveToFile("document.txt");
            Document loadedDocument = new Document(factory);
            loadedDocument.loadFromFile("document.txt", factory);
            List<Character> characters = loadedDocument.getCharacters();
            for (Character character : characters) {
                System.out.println(character.getChar() + " - Font: " + character.getProperties().getFont() + ", Color: " + character.getProperties().getColor() + ", Size: " + character.getProperties().getSize());
            }
        } catch (IOException e) {
            System.out.println("An error occurred while saving/loading the document: " + e.getMessage());
        }

        try {
            editor.saveToFile("example.txt");
            Document loadedDocument = new Document(factory);
            loadedDocument.loadFromFile("document.txt", factory);
            List<Character> characters = loadedDocument.getCharacters();
            for (Character character : characters) {
                System.out.println(character.getChar() + " - Font: " + character.getProperties().getFont() + ", Color: " + character.getProperties().getColor() + ", Size: " + character.getProperties().getSize());
            }
        } catch (IOException e) {
            System.out.println("An error occurred while saving/loading the document: " + e.getMessage());
        }

        

        Document document = new Document(factory);
        document.addCharacter('H', "Arial", "Red", 12);
        document.addCharacter('e', "Arial", "Red", 02);
        document.addCharacter('l', "Verdana", "Black", 16);
        document.addCharacter('l', "Calibri", "Blue", 74);
        document.addCharacter('o', "Arial", "Red", 12);
        document.addCharacter('W', "Calibri", "Blue", 43);
        document.addCharacter('o', "Arial", "Red", 12);
        document.addCharacter('r',"Verdana", "Black", 26);
        document.addCharacter('l', "Arial", "Red", 12);
        document.addCharacter('d', "Calibri", "Red", 54);
        document.addCharacter('5', "Calibri", "Blue", 14);
        document.addCharacter('8', "Verdana", "Black", 40);
        document.addCharacter('0', "Calibri", "Blue", 14);
        document.addCharacter('0', "Arial", "Green", 24);

        try {
            document.saveToFile("document.txt");
            Document loadedDocument = new Document(factory);
            loadedDocument.loadFromFile("document.txt", factory);
            List<Character> characters = loadedDocument.getCharacters();
            for (Character character : characters) {
                System.out.println(character.getChar() + " - Font: " + character.getProperties().getFont() + ", Color: " + character.getProperties().getColor() + ", Size: " + character.getProperties().getSize());
            }
        } catch (IOException e) {
            System.out.println("An error occurred while saving/loading the document: " + e.getMessage());
        }
    }
}

