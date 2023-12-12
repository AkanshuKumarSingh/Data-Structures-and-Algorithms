package test;

import java.util.Scanner;

public class All_indices_of_array {


    public static int[] findIndices(int arr[], int i, int dtf, int cnt){
        if(arr.length == i){
            return new int[cnt];
        }
        
        if(dtf == arr[i]){
            cnt++;
        }
        
        int rres[] = findIndices(arr,i+1,dtf,cnt);
        
        if(dtf == arr[i]){
            rres[cnt-1] = i;
        }
        return rres;
    }
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int arr[] = new int[n];
        for(int i = 0 ; i < n ; i++){
            arr[i] = scan.nextInt();
        }
        int x = scan.nextInt();
        int ans[] = findIndices(arr,0,x,0);
        if(ans.length == 0) {
        	System.out.println("[]");
        	return;
        }
        String s = "[";
        for(int i = 0 ; i < ans.length ; i++){
            if(i < ans.length-1)
                s += (ans[i] + ",");
            else
                s += (ans[i] + "]");
        }
        System.out.println(s);
    }
}