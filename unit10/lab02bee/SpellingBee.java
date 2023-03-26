import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SpellingBee {

    private char[] letters;
    private char mustUse;

    public SpellingBee(char[] l, char m) {
        letters = l;
        mustUse = m;
    }

    public boolean checkWord(String word) {
        boolean must = false;
        boolean allChar = true;
        char[] x = word.toCharArray();
        for (int i = 0; i < x.length - 1; i++) {
            if (x[i] == mustUse) {
                must = true;
            }
            for (int b = 0; b < letters.length - 1; b++)
                while (x[i] != letters[b]) {
                    allChar = false;
                }
                

        }

        if (allChar == true && must == true) {
            return true;
        } else
            return false;
    }

    public void printList(String[] word) {
        for (int ia = 0; ia < 9894; ia++) {
            if (checkWord(word[ia]) == true) {
                System.out.println(word[ia]);
            }
        }
    }

    /**
     * Loads the contents of file "filename" as a String.
     * 
     * @param filename the file to load
     * @return the contents of file "filename"
     */
    public static String loadFile(String filename) {
        String contents = "";
        Path path = Paths.get(filename);
        try {
            path = Path.of(ClassLoader.getSystemResource(filename).toURI());
            contents = Files.readString(path);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return contents;
    }

    public static void main(String[] args) {
        String[] words = loadFile("words_dropped.txt").split("\n");
        System.out.println("Loaded " + words.length + " words");
        // TODO solve me!
         SpellingBee bee = new SpellingBee("ranglty".toCharArray(), 'y');
         bee.printList(words);

        // // TODO sort words!

        // // TODO what position in the sorted list is the word "search" ?
        // linear search
        
    }
}
