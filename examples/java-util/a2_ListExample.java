package a2_java.util;

import java.util.*;

public class a2_ListExample {

    private List<String> fruits; // Declare a list to hold fruit names   

    // Constructor to initialize the fruit list   
    public a2_ListExample() {
        // Initialize the list upon object creation
        fruits = new ArrayList<>();
    }

    public static void main(String[] args) {
        a2_ListExample example = new a2_ListExample(); // Create an instance   
        // Start the interactive program 
        example.run();
    }

    // Method to run the interactive menu   
    public void run() {
        Scanner scanner = new Scanner(System.in); // Scanner for user input   
        boolean running = true;
        while (running) {
            showMenu(); // Display menu options   
            int choice = getValidInteger(scanner, "Choose an option: ", 1, 11); // Input validation   

            switch (choice) {
                case 1:
                    addFruit(scanner);
                    break;
                case 2:
                    insertFruit(scanner);
                    break;
                case 3:
                    getFirstFruit();
                    break;
                case 4:
                    checkFruitExists(scanner);
                    break;
                case 5:
                    removeFruitByIndex(scanner);
                    break;
                case 6:
                    removeSpecificFruit(scanner);
                    break;
                case 7:
                    sortFruits();
                    break;
                case 8:
                    displayFruits();
                    break;
                case 9:
                    clearFruits();
                    break;
                case 10:
                    findFruitIndex(scanner);
                    break;
                case 11:
                    running = false; // Exit the loop   
                    System.out.println("Exiting the program. Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        // Close the scanner to prevent resource leaks 
        scanner.close();
    }

    // Method to display the menu   
    private void showMenu() {
        System.out.println("\nMenu:");
        System.out.println("1. Add a fruit");
        System.out.println("2. Insert a fruit at a specified index");
        System.out.println("3. Get the first fruit");
        System.out.println("4. Check if a fruit exists");
        System.out.println("5. Remove a fruit by index");
        System.out.println("6. Remove a specific fruit");
        System.out.println("7. Sort fruits");
        System.out.println("8. View the list of fruits");
        System.out.println("9. Clear the list");
        System.out.println("10. Find the index of a fruit");
        System.out.println("11. Exit");
    }

    // Method to add a fruit   
    private void addFruit(Scanner scanner) {
        System.out.print("Enter the name of the fruit to add: ");
        String fruit = scanner.nextLine().trim();
        if (!fruit.isEmpty()) {
            fruits.add(fruit); // Adds the fruit to the list (Method 2: add)  
            System.out.println(fruit + " has been added to the list.");
        } else {
            System.out.println("Fruit name cannot be empty!");
        }
    }

    // Method to insert a fruit at a specific index   
    private void insertFruit(Scanner scanner) {
        System.out.print("Enter the fruit name to insert: ");
        String fruit = scanner.nextLine().trim();
        if (!fruit.isEmpty()) {
            int index = getValidInteger(scanner, "Enter the index at which to insert: ", 0, fruits.size());
            fruits.add(index, fruit); // Inserts fruit at the specified index (1: add(int index, E element))  
            System.out.println(fruit + " has been inserted at index " + index + ".");
        } else {
            System.out.println("Fruit name cannot be empty!");
        }
    }

    // Method to get and display the first fruit   
    private void getFirstFruit() {
        if (!fruits.isEmpty()) {
            String firstFruit = fruits.get(0); // Gets the first fruit (Method 9: get)  
            System.out.println("The first fruit in the list is: " + firstFruit);
        } else {
            System.out.println("The list is empty.");
        }
    }

    // Method to check if a specific fruit exists   
    private void checkFruitExists(Scanner scanner) {
        System.out.print("Enter the name of the fruit to check: ");
        String fruit = scanner.nextLine().trim();
        boolean exists = fruits.contains(fruit); // Checks existence of the fruit (6: contains)  
        if (exists) {
            System.out.println(fruit + " exists in the list.");
        } else {
            System.out.println(fruit + " does not exist in the list.");
        }
    }

    // Method to remove a fruit by index   
    private void removeFruitByIndex(Scanner scanner) {
        if (!fruits.isEmpty()) {
            int index = getValidInteger(scanner, "Enter the index of the fruit to remove: ", 0, fruits.size() - 1);
            String removedFruit = fruits.remove(index); // Removes fruit at the specified index (Method 17: remove(int index))  
            System.out.println(removedFruit + " has been removed from the list.");
        } else {
            System.out.println("The list is empty.");
        }
    }

    // Method to remove a specific fruit   
    private void removeSpecificFruit(Scanner scanner) {
        System.out.print("Enter the name of the fruit to remove: ");
        String fruit = scanner.nextLine().trim();
        boolean removed = fruits.remove(fruit); // Removes the specified fruit (18: remove(Object o))  
        if (removed) {
            System.out.println(fruit + " has been removed from the list.");
        } else {
            System.out.println(fruit + " does not exist in the list.");
        }
    }

    // Method to sort the list of fruits   
    private void sortFruits() {
        fruits.sort(Comparator.naturalOrder()); // Sorts the list alphabetically (Method 26: sort)  
        System.out.println("The list of fruits has been sorted.");
    }

    // Method to display the list of fruits   
    private void displayFruits() {
        if (fruits.isEmpty()) {
            System.out.println("The list is empty.");
        } else {
            System.out.println("Fruits in the list: " + fruits); // Displays all fruits   
            System.out.print("Iterating through the list: ");
            for (String fruit : fruits) {
                System.out.print(fruit + " "); // Lists all fruits   
            }
            System.out.println();
        }
    }

    // Method to clear the list   
    private void clearFruits() {
        fruits.clear(); // Clears all elements from the list (Method 5: clear)   
        System.out.println("All fruits have been removed from the list.");
    }

    // Method to find the index of a specific fruit   
    private void findFruitIndex(Scanner scanner) {
        System.out.print("Enter the name of the fruit to find: ");
        String fruit = scanner.nextLine().trim();
        int index = fruits.indexOf(fruit); // Finds the index of the fruit (Method 11: indexOf)   
        if (index != -1) {
            System.out.println("The index of " + fruit + " is: " + index);
        } else {
            System.out.println(fruit + " is not found in the list.");
        }
    }

    // Helper method to get a valid integer input from the user  
    private int getValidInteger(Scanner scanner, String prompt, int min, int max) {
        while (true) {
            System.out.print(prompt);
            try {
                int value = Integer.parseInt(scanner.nextLine()); // Read and try to parse integer input   
                if (value >= min && value <= max) {
                    return value; // Return the valid input   
                } else {
                    System.out.println("Input must be between " + min + " and " + max + ".");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid integer.");
            }
        }
    }
}
