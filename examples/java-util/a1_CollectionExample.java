package a2_java.util;

import java.util.*;

public class a1_CollectionExample {

    private Collection<String> fruits; // Collection to hold fruit names  
    private Scanner scanner; // Scanner for user input  

    public a1_CollectionExample() {
        fruits = new ArrayList<>(); // Initializing the Collection with ArrayList  
        // Creating a Scanner object for user input 
        scanner = new Scanner(System.in);
    }

    public static void main(String[] args) {
        a1_CollectionExample example = new a1_CollectionExample();
        // Start the menu-driven program 
        example.run();
    }

    public void run() {
        boolean running = true;
        while (running) {
            // Display the menu options  
            System.out.println("\nFruit Collection Menu:");
            System.out.println("1. Add Fruit");
            System.out.println("2. Remove Fruit");
            System.out.println("3. Check if Fruit Exists");
            System.out.println("4. Display All Fruits");
            System.out.println("5. Get Collection Size");
            System.out.println("6. Check if Collection is Empty");
            System.out.println("7. Clear Collection");
            System.out.println("8. Convert Collection to Array");
            System.out.println("9. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt(); // Read user input  
            scanner.nextLine(); // Consume the newline character left by nextInt  

            switch (choice) {
                case 1:
                    addFruit(); // Call method to add a fruit  
                    break;
                case 2:
                    removeFruit(); // Call method to remove a fruit  
                    break;
                case 3:
                    checkFruitExists(); // Call method to check if a fruit exists  
                    break;
                case 4:
                    displayFruits(); // Call method to display all fruits  
                    break;
                case 5:
                    getCollectionSize(); // Call method to get size of the collection  
                    break;
                case 6:
                    checkIfEmpty(); // Call method to check if collection is empty  
                    break;
                case 7:
                    clearCollection(); // Call method to clear the collection  
                    break;
                case 8:
                    convertToArray(); // Call method to convert collection to array  
                    break;
                case 9:
                    running = false; // Exit the loop to terminate the program  
                    System.out.println("Exiting the program. Thank you!");
                    break;
                default:
                    System.out.println("Invalid option. Please select again.");
            }
        }
        // Close the scanner to prevent resource leaks 
        scanner.close();
    }

    // Method to add a fruit to the collection (Method 1: add)  
    private void addFruit() {
        System.out.print("Enter the name of the fruit to add: ");
        String fruit = scanner.nextLine();
        if (fruits.add(fruit)) { // Adds the fruit and checks if successful  
            System.out.println(fruit + " has been added to the collection.");
        } else {
            System.out.println(fruit + " could not be added.");
        }
    }

    // Method to remove a fruit from the collection (Method 10: remove)  
    private void removeFruit() {
        System.out.print("Enter the name of the fruit to remove: ");
        String fruit = scanner.nextLine();
        if (fruits.remove(fruit)) { // Removes the fruit and checks if it was present  
            System.out.println(fruit + " has been removed from the collection.");
        } else {
            System.out.println(fruit + " not found in the collection.");
        }
    }

    // Method to check if a fruit exists in the collection (Method 4: contains)  
    private void checkFruitExists() {
        System.out.print("Enter the name of the fruit to check: ");
        String fruit = scanner.nextLine();
        if (fruits.contains(fruit)) { // Returns true if the fruit is found  
            System.out.println(fruit + " is in the collection.");
        } else {
            System.out.println(fruit + " is not in the collection.");
        }
    }

    // Method to display all fruits in the collection (Method 9: iterator)  
    private void displayFruits() {
        if (fruits.isEmpty()) { // Checking if the collection is empty (Method 8)  
            System.out.println("The collection is empty.");
        } else {
            System.out.println("Fruits in the collection: ");
            Iterator<String> iterator = fruits.iterator(); // Gets an iterator for the collection (Method 9)  
            while (iterator.hasNext()) {
                System.out.print(iterator.next() + " "); // Print each fruit  
            }
            System.out.println(); // New line after listing all fruits  
        }
    }

    // Method to get the size of the collection (Method 13: size)  
    private void getCollectionSize() {
        // Display the size 
        System.out.println("Number of fruits in the collection: " + fruits.size());
    }

    // Method to check if the collection is empty (Method 8: isEmpty)  
    private void checkIfEmpty() {
        if (fruits.isEmpty()) {
            System.out.println("The collection is empty.");
        } else {
            System.out.println("The collection contains fruits.");
        }
    }

    // Method to clear the collection (Method 3: clear)  
    private void clearCollection() {
        fruits.clear(); // Clears all elements from the collection  
        System.out.println("The collection has been cleared.");
    }

    // Method to convert the collection to an array (Method 19: toArray)  
    private void convertToArray() {
        Object[] fruitArray = fruits.toArray(); // Convert the collection to an array  
        System.out.print("Fruits as an array: ");
        for (Object fruit : fruitArray) {
            // Print each fruit in the array 
            System.out.print(fruit + " ");
        }
        // New line after listing array contents 
        System.out.println();
    }
}
