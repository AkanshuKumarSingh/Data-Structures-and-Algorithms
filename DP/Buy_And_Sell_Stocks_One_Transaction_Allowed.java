package DP;

import java.util.Scanner;

public class Buy_And_Sell_Stocks_One_Transaction_Allowed {

	public static int stocksTabulation(int price[]) {
		
		int bd = 0;
		int profit = 0;
		
		for(int day = 1; day < price.length; day++) {
			if(price[day] > price[day-1]) {
				profit = Math.max(profit, price[day] - price[bd]);
			}else if(price[day] < price[bd]) {
				bd = day;
			}
		}
		
		return profit;
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int arr[] = new int[n];
		for(int i = 0 ; i < n ; i++) {
			arr[i] = scan.nextInt();
		}
		System.out.println(stocksTabulation(arr));
	}

}
