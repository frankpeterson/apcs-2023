public class frank {

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

    public static void main(String[] args) {
        // System.out.println(pi(0.0, 1, true));
        System.out.println(pi(4, 1, true));

    }
}