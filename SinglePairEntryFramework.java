import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SinglePairEntryFramework {
    private final Map<String, String> keyValueStore;

    // Constructor
    public SinglePairEntryFramework() {
        keyValueStore = new HashMap<>();
    }

    // Method to add a key-value pair
    public boolean addEntry(String key, String value) {
        if (validateKey(key) && validateValue(value)) {
            if (!keyValueStore.containsKey(key)) {
                keyValueStore.put(key, value);
                System.out.println("Entry added successfully!");
                return true;
            } else {
                System.out.println("Error: Key already exists.");
            }
        }
        return false;
    }

    // Method to retrieve a value by key
    public String getEntry(String key) {
        return keyValueStore.getOrDefault(key, "Key not found.");
    }

    // Method to validate key
    private boolean validateKey(String key) {
        if (key == null || key.trim().isEmpty()) {
            System.out.println("Invalid key: Key cannot be null or empty.");
            return false;
        }
        return true;
    }

    // Method to validate value
    private boolean validateValue(String value) {
        if (value == null || value.trim().isEmpty()) {
            System.out.println("Invalid value: Value cannot be null or empty.");
            return false;
        }
        return true;
    }

    // Method to display all entries
    public void displayAllEntries() {
        if (keyValueStore.isEmpty()) {
            System.out.println("No entries found.");
        } else {
            System.out.println("All Entries:");
            keyValueStore.forEach((key, value) -> System.out.println(key + ": " + value));
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        SinglePairEntryFramework framework = new SinglePairEntryFramework();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("Single Pair Entry Framework");
        while (running) {
            System.out.println("\nMenu:");
            System.out.println("1. Add Entry");
            System.out.println("2. Retrieve Entry");
            System.out.println("3. Display All Entries");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter key: ");
                    String key = scanner.nextLine();
                    System.out.print("Enter value: ");
                    String value = scanner.nextLine();
                    framework.addEntry(key, value);
                }
                case 2 -> {
                    System.out.print("Enter key to retrieve: ");
                    String key = scanner.nextLine();
                    System.out.println("Value: " + framework.getEntry(key));
                }
                case 3 -> framework.displayAllEntries();
                case 4 -> {
                    System.out.println("Exiting... Goodbye!");
                    running = false;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }
}
