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

        for (int i = 0; i < x.length; i++) {
            if (x[i] == mustUse) {
                must = true;
            }
            boolean thisLetter = false;
            for (int b = 0; b < letters.length; b++) {
                if (x[i] == letters[b])
                    thisLetter = true;
            }
            // int b = letters.length - 1;
            // while (b >= 0) {

            // b--;
            // }
            if (!thisLetter)
                allChar = false;
        }

        return (allChar && must && x.length >= 4);
    }

    public void printList(String[] word) {
        System.out.println("hi");

        for (int ia = 0; ia < 9894; ia++) {
            // System.out.println(word[ia]);
            if (checkWord(word[ia])) {
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
        System.out.println("array:" + bee.checkWord("array"));

        // // TODO sort words!

        // // TODO what position in the sorted list is the word "search" ?
        // linear search

    }
}
