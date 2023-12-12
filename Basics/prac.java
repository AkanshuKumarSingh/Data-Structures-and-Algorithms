package Basics;

import java.util.*;


public class prac {

	public static void main(String[] args) {
		
        // Create an array of integers
        Integer[] integerArray = {1, 2, 3, 4, 5};

        // Convert the array to a list using Arrays.asList()
        List<Integer> integerList = Arrays.asList(integerArray);
        
        System.out.println(integerList);
        
		ArrayList<Integer> numbers = new ArrayList<>();
		
		numbers.addAll(Collections.nCopies(5, 2));
		
		System.out.println(Collections.nCopies(5, 2));
        // Adding elements
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);

        // Accessing elements
        System.out.println("Element at index 1: " + numbers.get(1)); // Output: 20
        
        
        // Modifying elements
        numbers.set(2, 35);
        System.out.println("Modified list: " + numbers); // Output: [10, 20, 35]

        // Removing elements
        numbers.remove(0);
        System.out.println("List after removing element at index 0: " + numbers); // Output: [20, 35]

        // Checking the size and state
        System.out.println("Size of the list: " + numbers.size()); // Output: 2
        System.out.println("Is the list empty? " + numbers.isEmpty()); // Output: false
        System.out.println("Does the list contain 20? " + numbers.contains(20)); // Output: true

        // Iterating through the ArrayList using for-each loop
        for (int number : numbers) {
            System.out.print(number + " "); // Output: 20 35
        }

        // Clearing the ArrayList
        numbers.clear();
        System.out.println("\nList after clearing: " + numbers); // Output: []
		
	}

}
