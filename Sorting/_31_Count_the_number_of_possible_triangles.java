package Sorting;

import java.util.Arrays;

public class _31_Count_the_number_of_possible_triangles {

    static int findNumberOfTriangles1(int arr[], int n)
    {
        Arrays.sort(arr);
        int ans = 0;
        
        for(int i = 0; i < n-2; i++){
            int f = i, s = i+1, l = i+2;
            while(l < n){
                if(arr[f] + arr[s] <= arr[l]){
                    s++;
                }else{
                    ans += (l-s); // if second is 2nd idx and last is 5idx then second can also be 3rd and 4th idx think!!
                    l++;
                }
                if(s == l){
                    l++;
                }
            }
        }
        return ans;
    }
	
//    def find_number_of_triangles(arr):
//        arr.sort()
//        n = len(arr)
//        count = 0
//
//        for i in range(n - 2):
//            f = i
//            s = i + 1
//            l = i + 2
//
//            while l < n:
//                if arr[f] + arr[s] <= arr[l]:
//                    s += 1
//                else:
//                    count += (l - s)
//                    l += 1
//                if s == l:
//                    l += 1
//
//        return count
    
    static int findNumberOfTriangles(int arr[], int n)
    {
        Arrays.sort(arr);
        int ans = 0;
        
        for(int i = 2; i < n; i++){
            int st = 0, ed = i-1;
            while(st < ed){
                if(arr[st] + arr[ed] <= arr[i]){
                    st++;
                }else{
                    ans += (ed-st);
                    ed--;
                }
            }
        }
        return ans;
    }
	
}
