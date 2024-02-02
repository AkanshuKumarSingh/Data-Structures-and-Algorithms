package DP;

import java.util.Scanner;

public class Buy_And_Sell_Stocks_Infinite_Transactions_Allowed {

	public static int stocksTabulation(int price[]) {

		int profit = 0;
		int bd = 0;
		int sd = 0;

		for (int day = 1; day < price.length; day++) {
			// profit += (price[day] - price[day-1]); direct ans
			if (price[day] > price[day - 1]) {
				sd = day;
			}else {
				profit += (price[sd] - price[bd]);
				sd = day;
				bd = day;
			}
		}
		
		profit += (price[sd] - price[bd]);
		
		return profit;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scan.nextInt();
		}
		System.out.println(stocksTabulation(arr));
	}

}
