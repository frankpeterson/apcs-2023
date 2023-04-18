package unit11;

// 2021 FRQ #1
// https://apcentral.collegeboard.org/media/pdf/ap21-frq-computer-science-a.pdf#page=3
public class WordMatch {
    private String secret;

    public WordMatch(String word) {
        this.secret = word;
    }

    public int scoreGuess(String guess) {
        int count = 0;
        int guessLength = guess.length();
        for ( int i = 0; i < secret.length()-guessLength+1; i++){
            if ( secret.substring(i, i+guessLength).equals(guess)){
                count++;
            }
        }
        int ans = guessLength * guessLength * count;
        return ans;
    }

    public String findBetterGuess(String guess1, String guess2) {
        int one = scoreGuess(guess1);
        int two = scoreGuess(guess2);
        if ( one > two ){
            return guess1;
        }
        else if ( two > one){
            return guess2;
        }
        else if ( two == one){
            if ( guess1.compareTo(guess2) > 0){
                return guess1;
            }
            else return guess2;
        }
        return "";
    }

    public static void parta1() {
        WordMatch game = new WordMatch("mississippi");
        check(game.scoreGuess("i") == 4);
        check(game.scoreGuess("iss") == 18);
        check(game.scoreGuess("issipp") == 36);
        check(game.scoreGuess("mississippi") == 121);
    }

    public static void parta2() {
        WordMatch game = new WordMatch("aaaabb");
        check(game.scoreGuess("a") == 4);
        check(game.scoreGuess("aa") == 12);
        check(game.scoreGuess("aaa") == 18);
        check(game.scoreGuess("aabb") == 16);
        check(game.scoreGuess("c") == 0);
    }

    public static void partb1() {
        WordMatch game = new WordMatch("concatenation");
        check(game.scoreGuess("ten") == 9);
        check(game.scoreGuess("nation") == 36);
        check(game.findBetterGuess("ten", "nation") == "nation");
    }

    public static void partb2() {
        WordMatch game = new WordMatch("concatenation");
        check(game.scoreGuess("cat") == 9);
        check(game.scoreGuess("con") == 9);
        check(game.findBetterGuess("cat", "con") == "con");
        check(game.findBetterGuess("con", "cat") == "con");
    }

    public static void check(boolean test) throws AssertionError {
        if (!test)
            throw new AssertionError("sad panda");
    }

    public static void main(String[] args) {
        parta1();
        parta2();
        partb1();
        partb2();

        System.out.println("Happy Panda! \uD83D\uDC3C");
    }

}
