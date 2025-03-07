import java.util.ArrayList;
import java.util.Scanner;

class Item {
    private String id;
    private String name;
    private String description;

    public Item(String id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Description: " + description;
    }
}

public class CRUDApp {
    private static ArrayList<Item> items = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nCRUD Operations Menu:");
            System.out.println("1. Create Item");
            System.out.println("2. Read Item");
            System.out.println("3. Update Item");
            System.out.println("4. Delete Item");
            System.out.println("5. List All Items");
            System.out.println("6. Exit");
            System.out.println("Enter your choice");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    createItem();
                    break;
                case 2:
                    readItem();
                    break;
                case 3:
                    updateItem();
                    break;
                case 4:
                    deleteItem();
                    break;
                case 5:
                    listAllItems();
                    break;
                case 6:
                    System.out.println("Existing application.");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");

            }
        }
    }

    private static void createItem() {
        System.out.println("Enter Item ID: ");
        String id = scanner.nextLine();
        System.out.println("Enter Item Name: ");
        String name = scanner.nextLine();
        System.out.println("Enter Item Description: ");
        String description = scanner.nextLine();

        Item newItem = new Item(id, name, description);
        items.add(newItem);
        System.out.println("Item created successfully.");
    }

    private static void readItem() {
        System.out.println("Enter Item ID to read: ");
        String id = scanner.nextLine();
        for (Item item : items) {
            if (item.getId().equals(id)) {
                System.out.println(item);
                return;
            }
        }
    }

    private static  void updateItem() {
        System.out.println("Enter Item ID to update: ");
        String id = scanner.nextLine();
        for (Item item : items ) {
            if (item.getId().equals(id)) {
                System.out.println("Enter new Item Name: ");
                String newName = scanner.nextLine();
                System.out.println("Enter new Item Description: ");
                String newDescription = scanner.nextLine();

                item.setName(newName);
                item.setDescription(newDescription);
                System.out.println("Item updated successfully.");
                return;
            }
        }
        System.out.println("Item not found.");
    }


    private static void deleteItem() {
        System.out.println("Enter Item ID to delete: ");
        String id = scanner.nextLine();
        items.removeIf(item -> item.getId().equals(id));
        System.out.println("Item deleted successfully.");
    }

    private static void listAllItems() {
        if (items.isEmpty()) {
            System.out.println("No items found.");
            return;
        }
        for (Item item: items ) {
            System.out.println(item);
        }
    }

}


