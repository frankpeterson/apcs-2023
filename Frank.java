import java.util.Arrays;

public class Frank {

    public static int power(int a, int b) {
        if (b == 1) {
            return a;
        } else {
            int nextPower = power(a, b / 2);
            if (b % 2 == 0) {
                return nextPower * nextPower;
            } else {
                return nextPower * nextPower * a;
            }
        }
    }


    public static float pi(float p, int n, boolean subtract) {
        if (n < 1000) {
            if (subtract == true) {
                p -= (4.0 / (n + 2));
            } else {
                p += (4.0 / (n + 2));
            }
            n += 2;
            subtract = !subtract;
            return pi(p, n, subtract);
        } else
            return p;
    }
    
//     To shuffle an array a of n elements (indices 0..n-1):
// for i from n−1 downto 1 do
//      j ← random integer such that 0 ≤ j ≤ i
//      exchange a[j] and a[i]

    public static String[] fishyate(String[] m){
        for(int i = m.length-1; i >= 0; i--){
            int random = (int)(Math.random()*i);
            String temp = m[random];
            m[random] = m[i];
            m[i] = temp;
        }
        return (m);
    }

    public static void main(String[] args) {
        // System.out.println(pi(0.0, 1, true));
        // System.out.println(pi(4, 1, true));
        String[] aoeu = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p"};
        System.out.println(Arrays.toString(fishyate(aoeu)));

    }
}