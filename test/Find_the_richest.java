package test;

import java.util.Scanner;

public class Find_the_richest {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int mat[][] = new int[n][m];
        int ans = -1;
        int max = 0;
        for(int i = 0 ; i < n ; i++){
            int moneyOfI = 0;
            for(int j = 0 ; j < m; j++){
                moneyOfI += scan.nextInt();
            }
            if(moneyOfI > max){
                max = moneyOfI;
                ans = i;
            }
        }
        System.out.println(ans);
    }
}