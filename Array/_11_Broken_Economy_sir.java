package Array;

import java.util.Scanner;

public class _11_Broken_Economy_sir {
//	In a country of novice government, the economic system is changed where only coins are used that too of various denominations. Whenever a foreigner visits this country, they visit a money exchanger to get the currency of the same country. As the foreigner is unaware of the denomination of the country, the money exchange prefers to tell them the denomination which is the nearest maximum and nearest minimum to the denomination mentioned by the foreigner. In case they get the correct guess of the denomination, they are told the same denomination. The denominations are always quoted in ascending order.
//
//	Example 1: In a country, 8 given denominations are as follows
//	[5, 10, 15, 22, 33, 40, 42, 55]
//
//	The foreigner asks for denomination 25.
//	The money exchange tells them that denominations of 33 and 22 are available.
//
//	Example 2: 
//	In a country, 5 given denominations are as follows
//	[7, 14, 18, 25, 30]
//
//	The foreigner asks for the denomination of 18.
//
//	The money exchange tells them a denomination of 18 is available.  


	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();

		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scan.nextInt();
		}

		int no = scan.nextInt();

		int start = 0, end = n - 1,mid = 0;
		int floor = Integer.MIN_VALUE;
		int ceil = Integer.MAX_VALUE;

		while (start <= end) {
			mid = start + (end - start) / 2;
			if (arr[mid] == no) {
				floor = arr[mid];
				ceil = arr[mid];
				break;
			} else if (arr[mid] < no) {
				floor = arr[mid];
				start = mid + 1;
				
			} else {
				ceil = arr[mid];
				end = mid - 1;
			}
		}
		
		System.out.println(ceil + "\n" + floor);
		
//	    boolean found = false;
//	    int next = Integer.MAX_VALUE, prev = Integer.MIN_VALUE;
//	    for(int i = 0 ; i < n ; i++){
//	        if(arr[i] == no){
//	            found = true;
//	            break;
//	        }else{
//	            if(prev < arr[i] && arr[i] < no){
//	                prev = arr[i];
//	            }else{
//	                next = arr[i];
//	                break;
//	            }
//	        }
//	    }
//	    System.out.println(next + "\n" + prev);
//	    
		
//	python code
//	start = 0
//	end = n - 1
//	mid = 0
//	floor = float('-inf')
//	ceil = float('inf')
//
//	# Binary search to find floor and ceil values
//	while start <= end:
//	    mid = start + (end - start) // 2
//	    if arr[mid] == no:
//	        floor = arr[mid]
//	        ceil = arr[mid]
//	        break
//	    elif arr[mid] < no:
//	        floor = arr[mid]
//	        start = mid + 1
//	    else:
//	        ceil = arr[mid]
//	        end = mid - 1
	}

	
}
