package unit11;

public class BeatThat {
    
    private int dice1;
    private int dice2;

    private int marcSum;
    private int frankSum;

    public void Roll(){
        dice1 = (int)(Math.random()*6)+1;
        dice2 = (int)(Math.random()*6)+1;
    }

    public int sum(){
        int sum = 0;
        if ( dice1 > dice2 ){
            sum = dice1*10 + dice2;
        }
        else sum = dice2*10 + dice1;
        return sum;
    }

    private boolean Winner(){
        System.out.println();
        Roll();
        int temp1 = sum();
        System.out.println("Frank's Roll = " +  temp1);
        Roll();
        int temp2 = sum();
        System.out.println("Marc's Roll = " + temp2);
        if ( temp1 > temp2 ){
            System.out.println("Point for Frank ");
            return true;
        }
        else if ( temp2 > temp1 ){
            System.out.println("Point for Marc ");
            return false;
        }
        else if ( temp2 == temp1 ){
            System.out.println("Draw ");
            Winner();
        }
        return false;
    }

    private boolean Game(){
        while ( marcSum < 5 || frankSum < 5){
            if(Winner()){
                frankSum++;
            }
            else marcSum++;
        }
        if ( frankSum > marcSum){
            return true;
        }
        else return false;
    }

    public static void main (String Args[] ){
        BeatThat simulation = new BeatThat();
        if(simulation.Game()){
            System.out.println("Frank Wins!");
        }
        else System.out.println("Marc Wins!");
    }
}
