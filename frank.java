public class frank{

    public static int power(int a, int b){
        if (b == 1) {
            return a;
        } else {
            int nextPower = power(a,b/2);
            if(b % 2 == 0){
                return nextPower * nextPower;
            }
            else {return nextPower*nextPower*a;
            }
    }
    }
        
    
    public static void main(String[] args) {
        System.out.println(power(4,8));
        System.out.println(power(4,7));
    }
}