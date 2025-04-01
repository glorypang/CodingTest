import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cost = sc.nextInt();
        cost = 1000 - cost;
        int count = 0;
        int coins[] = {500,100,50,10,5,1};
        for(int i = 0 ; i < coins.length; i++){
            count += cost / coins[i];
            cost = cost % coins[i];
        }
        System.out.println(count);
    }
}