import java.util.Arrays;

public class March22 {

    public static String[] sort(String[] a, int b) {
        // for (int i = a.length; i > 0; i--){
        // b = 0;
        if (b < a.length - 1) {
            String string1 = a[b];
            String string2 = a[b + 1];
            int c = string1.compareTo(string2);
            if (c > 0) {
                a[b] = string2;
                a[b + 1] = string1;
            }
            b++;
            return sort(a, b);
        }

        // }
        return a;
    }

    public static Object[] fishyate(Object[] m) {
        for (int i = m.length - 1; i >= 0; i--) {
            int random = (int) (Math.random() * i);
            Object temp = m[random];
            m[random] = m[i];
            m[i] = temp;
        }
        return (m);
    }

    public static void main(String[] args) {
        Object[] aoeu = new String[] { "o", "j", "g", "h", "c", "a", "i", "p", "d", "l", "b", "n", "e", "m", "k", "f" };
        Object[] htns = new Integer[] { 0, 3, 7, 8, 3, 91, 3 };
        System.out.println(Arrays.toString(fishyate(aoeu)));
        System.out.println(Arrays.toString(fishyate(htns)));
        // System.out.println(Arrays.toString(sort(aoeu, 0)));
        // System.out.println(Arrays.toString(sort(aoeu, 0)));
        // System.out.println(Arrays.toString(sort(aoeu, 0)));
        // System.out.println(Arrays.toString(sort(aoeu, 0)));
        // System.out.println(Arrays.toString(sort(aoeu, 0)));
        // System.out.println(Arrays.toString(sort(aoeu, 0)));
        // System.out.println(Arrays.toString(sort(aoeu, 0)));
        // System.out.println(Arrays.toString(sort(aoeu, 0)));
        // System.out.println(Arrays.toString(sort(aoeu, 0)));
        // System.out.println(Arrays.toString(sort(aoeu, 0)));
        // System.out.println(Arrays.toString(sort(aoeu, 0)));
        // System.out.println(Arrays.toString(sort(aoeu, 0)));

    }

}