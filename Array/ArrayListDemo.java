package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ArrayListDemo {
    public static void main(String[] args) {
        // 1. Create ArrayList
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(10, 20, 30));
        System.out.println("Original List: " + list); // [10, 20, 30]

        // 2. Add elements
        list.add(40);                          // Append
        list.add(0, 5);                        // Insert at index 0
        list.addAll(Arrays.asList(50, 60));    // Add multiple
        System.out.println("After adding: " + list); // [5, 10, 20, 30, 40, 50, 60]

        // 3. Access elements
        int first = list.get(0);               // Get first
        int last = list.get(list.size() - 1);  // Get last
        System.out.println("First: " + first + ", Last: " + last); // 5, 60

        // 4. Remove elements
        list.remove(list.size()-1);                        // Remove by index
        list.remove(Integer.valueOf(30));      // Remove by value
        System.out.println("After removal: " + list); // [10, 20, 40, 50, 60]

        // 5. Check existence and size
        boolean has20 = list.contains(20);     // Check if 20 exists
        int size = list.size();                // Get size
        System.out.println("Contains 20? " + has20 + ", Size: " + size); // true, 5

        // 6. Find index
        int indexOf50 = list.indexOf(50);      // First occurrence
        System.out.println("Index of 50: " + indexOf50); // 3

        // 7. Sort and reverse
        Collections.sort(list);                // Sort ascending
        System.out.println("Sorted: " + list); // [10, 20, 40, 50, 60]
        Collections.reverse(list);             // Reverse
        System.out.println("Reversed: " + list); // [60, 50, 40, 20, 10]

        // 8. Sublist (slicing equivalent)
        ArrayList<Integer> subList = new ArrayList<>(list.subList(1, 4));
        System.out.println("Sublist [1:4]: " + subList); // [50, 40, 20]

        // 9. Copy list
        ArrayList<Integer> copy = new ArrayList<>(list);
        System.out.println("Copied List: " + copy); // [60, 50, 40, 20, 10]

        // 10. Clear list
        list.clear();
        System.out.println("After clear: " + list); // []
    }

//     def list_operations():
//     # 1. Create list
//     lst = [10, 20, 30]
//     print("Original List:", lst)  # [10, 20, 30]

//     # 2. Add elements
//     lst.append(40)          # Append
//     lst.insert(0, 5)        # Insert at index 0
//     lst.extend([50, 60])     # Add multiple
//     print("After adding:", lst)  # [5, 10, 20, 30, 40, 50, 60]

//     # 3. Access elements
//     first = lst[0]          # Get first
//     last = lst[-1]          # Get last
//     print(f"First: {first}, Last: {last}")  # 5, 60

//     # 4. Remove elements
//     lst.pop(0)              # Remove by index
//     lst.remove(30)          # Remove by value
//     print("After removal:", lst)  # [10, 20, 40, 50, 60]

//     # 5. Check existence and size
//     has_20 = 20 in lst      # Check if 20 exists
//     size = len(lst)         # Get size
//     print(f"Contains 20? {has_20}, Size: {size}")  # True, 5

//     # 6. Find index
//     index_of_50 = lst.index(50)  # First occurrence
//     print("Index of 50:", index_of_50)  # 3

//     # 7. Sort and reverse
//     lst.sort()              # Sort ascending
//     print("Sorted:", lst)   # [10, 20, 40, 50, 60]
//     lst.reverse()           # Reverse
//     print("Reversed:", lst) # [60, 50, 40, 20, 10]

//     # 8. Slicing (sub-list)
//     sub_list = lst[1:4]     # Get [50, 40, 20]
//     print("Sublist [1:4]:", sub_list)

//     # 9. Copy list
//     lst_copy = lst.copy()
//     print("Copied List:", lst_copy)  # [60, 50, 40, 20, 10]

//     # 10. Clear list
//     lst.clear()
//     print("After clear:", lst)  # []

// list_operations()
}
