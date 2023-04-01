package unit10.lab02bee;

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

            int b = letters.length - 1;
            while (b >= 0) {
                if (x[i] == letters[b])
                    thisLetter = true;
                b--;
            }
            if (!thisLetter)
                allChar = false;
        }

        return (allChar && must && x.length >= 4);
    }

    public void printList(String[] words) {
        for (int ia = 0; ia < words.length; ia++) {
            if (checkWord(words[ia])) {
                System.out.println(words[ia]);
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
        // https://stackoverflow.com/questions/2163045/how-to-remove-line-breaks-from-a-file-in-java
        String[] words = loadFile("unit10/lab02bee/words_dropped.txt").split(System.getProperty("line.separator"));
        System.out.println("Loaded " + words.length + " words");
        // TODO solve me!
        SpellingBee bee = new SpellingBee("ranglty".toCharArray(), 'y');
        bee.printList(words);

        // // TODO sort words!

        // // TODO what position in the sorted list is the word "search" ?
        // linear search

    }
}
