import java.util.ArrayList;
import java.util.Scanner;


public class ItemList
{
    private ArrayList<Item> items;
    private final Scanner scanner;


    public ItemList( Scanner scanner ) // later might want to pass pre-set items for more expansion
    {
        this.scanner = scanner;
        items = new ArrayList<>();
    }



    /** --------------
     *  Helper methods
     * ---------------
     */
    void createItem() {
        System.out.println("Enter Item ID: ");
        String id = getScanner().nextLine();
        System.out.println("Enter Item Name: ");
        String name = getScanner().nextLine();
        System.out.println("Enter Item Description: ");
        String description = getScanner().nextLine();

        Item newItem = new Item(id, name, description);
        getItems().add(newItem);
        System.out.println("Item created successfully.");
    }

    void readItem() {
        System.out.println("Enter Item ID to read: ");
        String id = getScanner().nextLine();
        for (Item item : getItems()) {
            if (item.getId().equals(id)) {
                System.out.println(item);
                return;
            }
        }
    }

    void updateItem() {
        System.out.println("Enter Item ID to update: ");
        String id = getScanner().nextLine();
        for (Item item : getItems() ) {
            if (item.getId().equals(id)) {
                System.out.println("Enter new Item Name: ");
                String newName = getScanner().nextLine();
                System.out.println("Enter new Item Description: ");
                String newDescription = getScanner().nextLine();

                item.setName(newName);
                item.setDescription(newDescription);
                System.out.println("Item updated successfully.");
                return;
            }
        }
        System.out.println("Item not found.");
    }

    void deleteItem() {
        System.out.println("Enter Item ID to delete: ");
        String id = getScanner().nextLine();
        getItems().removeIf(item -> item.getId().equals(id));
        System.out.println("Item deleted successfully.");
    }

    void listAllItems() {
        if (getItems().isEmpty()) {
            System.out.println("No items found.");
            return;
        }
        for (Item item: getItems() ) {
            System.out.println(item);
        }
    }

    public Scanner getScanner()
    {
        return scanner;
    }

    public ArrayList<Item> getItems()
    {
        return items;
    }

    public void setItems( ArrayList<Item> someItems ) // later might want to set many items at once
    {
        this.items = someItems;
    }

}
