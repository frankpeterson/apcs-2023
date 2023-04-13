package unit11;

// 2018 FRQ #3
// https://secure-media.collegeboard.org/ap/pdf/ap18-frq-computer-science-a.pdf#page=12
interface StringChecker {
    /** Returns true if str is valid. */
    boolean isValid(String str);
}

public class CodeWordChecker implements StringChecker {

private int min; 
private int max;
private String notContaining;

    public CodeWordChecker(int mi, int ma, String nc){
        min = mi;
        max = ma;
        notContaining = nc;
    }

    public CodeWordChecker(String nc){
        max = 20;
        min = 6;
        notContaining = nc;
    }

    /** Returns true if str is valid. */
    public boolean isValid(String str) {
        boolean temp = false;
        //boolean temp2 = false;
       // int b = notContaining.length();

        if ( str.length() <= max && str.length() >= min){
            temp = true;
        }
        // for ( int i = 0; i < str.length()-b; i++){
        //     if (str.substring(i, i+b).equals(notContaining) && temp2 == true){
        //         temp2 = false;
        //     }
        // }

        if ( str.indexOf(notContaining) == -1 && temp == true){
            return true;
        }
       
        return false;
    }

    static boolean check(boolean test) throws AssertionError {
        if (!test)
            throw new AssertionError("sad panda");
        return test;
    }

    public static void main(String[] args) {
        // uncomment the following lines to test your code
        StringChecker sc1 = new CodeWordChecker(5, 8, "$");
        check(sc1.isValid("happy"));
        check(!sc1.isValid("happy$"));
        check(!sc1.isValid("Code"));
        check(!sc1.isValid("happyCode"));
        check(!sc1.isValid("happy$Code"));
        check(!sc1.isValid("Code$happy"));

        StringChecker sc2 = new CodeWordChecker("pass");
        check(sc2.isValid("MyPass"));
        check(!sc2.isValid("Mypassport"));
        check(!sc2.isValid("happy"));
        check(!sc2.isValid("1,000,000,000,000,000"));

        System.out.println("Happy Panda! \uD83D\uDC3C");
    }

}
