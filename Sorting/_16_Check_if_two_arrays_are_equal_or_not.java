 package Sorting;

import java.util.HashMap;

public class _16_Check_if_two_arrays_are_equal_or_not {

    public static boolean check(long A[],long B[],int N)
    {
        HashMap<Long, Integer> map = new HashMap<>();
        for(long no: A){
            map.put(no, map.getOrDefault(no, 0)+1);
        }
        
        for(long no: B){
            int cnt = map.getOrDefault(no, 0);
            if(cnt != 0){
                map.put(no, cnt-1);
            }else{
                return false;
            }
        }
        
        return true;
    }

//    from collections import defaultdict
//
//    def check(A, B, N):
//        freq_map = defaultdict(int)
//
//        for num in A:
//            freq_map[num] += 1
//
//        for num in B:
//            if freq_map[num] == 0:
//                return False
//            freq_map[num] -= 1
//
//        return True

    
}
