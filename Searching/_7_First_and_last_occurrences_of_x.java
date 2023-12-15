package Searching;

import java.util.ArrayList;

public class _7_First_and_last_occurrences_of_x {

    int firstIndex(int arr[], int n, int x){
        int st = 0, ed = n-1, ans = -1;
        while(st <= ed){
            int md = st + (ed-st)/2;
            if(arr[md] == x){
                ans = md;
                ed = md-1;
            }else if(arr[md] > x){
                ed = md-1;
            }else{
                st = md+1;
            }
        }
        
        return ans;
    }
    
    int lastIndex(int arr[], int n, int x){
        int st = 0, ed = n-1, ans = -1;
        while(st <= ed){
            int md = st + (ed-st)/2;
            if(arr[md] == x){
                ans = md;
                st = md+1;
            }else if(arr[md] > x){
                ed = md-1;
            }else{
                st = md+1;
            }
        }
        
        return ans;
    }
    
    ArrayList<Integer> find(int arr[], int n, int x)
    {
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(firstIndex(arr, n, x));
        ans.add(lastIndex(arr, n, x));
        return ans;
    }
	
}
