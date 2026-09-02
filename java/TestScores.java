import java.util.Scanner;
public class TestScores {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Challenge 1: Calculate 5 test scores

        int scores[] = {0,0,0,0,0};
        int sum = 0;
        int greatest = 0;
        int least = 100;

        for(int i=0;i<5;i++){

            System.out.println("Enter a test score: ");
            int score = sc.nextInt();
            if (score < 0 ){
                System.err.println("Score cannot be negative.");
                break;
            }
            scores[i]=score;
            sum+=score;
            
            if(score > greatest){
                greatest = score;
            }

            if(score < least){
                least = score;
            }
            
        }

        sc.close();
        System.out.println();
        
        System.out.println("total: "+sum);
        System.out.println("avg: "+(sum/5));
        System.out.println("highest: "+greatest);
        System.out.println("lowest: "+least);




    }
}
