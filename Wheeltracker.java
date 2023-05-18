import java.util.ArrayList;

public class Wheeltracker {
    
    private String ticker;
    private double avgprice;
    private int count;
    
    
    public Wheeltracker(String s, double d, int c) {
        ticker = s;
        avgprice = d;
        count = c;
    }

    public Wheeltracker(String s){
        ticker = s;
        avgprice = 0;
    }

    public void setPrice(double d){
        avgprice = d;
    }

    public void wheel(double sell, double buy){
        double dif = sell-buy;
        double totalprice = (double)avgprice * count;
        totalprice -= dif;
        avgprice = totalprice/count;
    }
    
    public void exercised(int c, double optionPrice, double strikePrice){
        int tempcount = count;
        count += c*100;
        avgprice = (c*100*strikePrice + tempcount*avgprice)/count;
        wheel(optionPrice,0);
    } 

    public String toString(){
        return "You have " + count + " shares of " + ticker + " with an average price of " + avgprice;
    }

    public static void main (String args[]){
        Wheeltracker nio = new Wheeltracker("NIO", 15.00, 200);
        System.out.println(nio.avgprice);
        nio.wheel(37.71, 19.99);
        System.out.println(nio.avgprice);
        nio.exercised(2, 64.00, 13.5 );
        System.out.println(nio.toString());
    }

}


