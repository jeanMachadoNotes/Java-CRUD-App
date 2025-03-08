import java.util.Scanner;


public class Runner
{
    public static void run()
    {
        ItemList itemList = new ItemList( new Scanner( System.in ) );

        while (true) {
            System.out.println("\nCRUD Operations Menu:");
            System.out.println("1. Create Item");
            System.out.println("2. Read Item");
            System.out.println("3. Update Item");
            System.out.println("4. Delete Item");
            System.out.println("5. List All Items");
            System.out.println("6. Exit");
            System.out.println("Enter your choice");

            int choice = itemList.getScanner().nextInt();
            itemList.getScanner().nextLine();

            switch (choice) {
                case 1:
                    itemList.createItem();
                    break;
                case 2:
                    itemList.readItem();
                    break;
                case 3:
                    itemList.updateItem();
                    break;
                case 4:
                    itemList.deleteItem();
                    break;
                case 5:
                    itemList.listAllItems();
                    break;
                case 6:
                    System.out.println("Exiting application.");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");

            }
        }
    }
}
