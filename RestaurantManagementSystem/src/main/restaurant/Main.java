package main.restaurant;

import java.sql.Timestamp;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        OrderManager orderManager = new OrderManager();
        ReservationManager reservationManager = new ReservationManager();
        InventoryManager inventoryManager = new InventoryManager();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Restaurant Management System");
            System.out.println("1. Manage Orders");
            System.out.println("2. Manage Reservations");
            System.out.println("3. Manage Inventory");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    manageOrders(scanner, orderManager);
                    break;
                case 2:
                    manageReservations(scanner, reservationManager);
                    break;
                case 3:
                    manageInventory(scanner, inventoryManager);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void manageOrders(Scanner scanner, OrderManager orderManager) {
        while (true) {
            System.out.println("Order Management");
            System.out.println("1. Create Order");
            System.out.println("2. Update Order Status");
            System.out.println("3. Delete Order");
            System.out.println("4. List Orders");
            System.out.println("5. Back to Main Menu");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter table number: ");
                    int tableNumber = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    System.out.print("Enter items (comma separated): ");
                    String items = scanner.nextLine();
                    orderManager.createOrder(tableNumber, items);
                    break;
                case 2:
                    System.out.print("Enter order ID: ");
                    int orderId = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    System.out.print("Enter new status: ");
                    String status = scanner.nextLine();
                    orderManager.updateOrderStatus(orderId, status);
                    break;
                case 3:
                    System.out.print("Enter order ID: ");
                    orderId = scanner.nextInt();
                    orderManager.deleteOrder(orderId);
                    break;
                case 4:
                    orderManager.listOrders();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void manageReservations(Scanner scanner, ReservationManager reservationManager) {
        while (true) {
            System.out.println("Reservation Management");
            System.out.println("1. Create Reservation");
            System.out.println("2. Cancel Reservation");
            System.out.println("3. List Reservations");
            System.out.println("4. Back to Main Menu");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter customer name: ");
                    scanner.nextLine();  // Consume newline
                    String customerName = scanner.nextLine();
                    System.out.print("Enter table number: ");
                    int tableNumber = scanner.nextInt();
                    System.out.print("Enter reservation time (YYYY-MM-DD HH:MM:SS): ");
                    scanner.nextLine();  // Consume newline
                    String reservationTimeStr = scanner.nextLine();
                    Timestamp reservationTime = Timestamp.valueOf(reservationTimeStr);
                    reservationManager.createReservation(customerName, tableNumber, reservationTime);
                    break;
                case 2:
                    System.out.print("Enter reservation ID: ");
                    int reservationId = scanner.nextInt();
                    reservationManager.cancelReservation(reservationId);
                    break;
                case 3:
                    reservationManager.listReservations();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void manageInventory(Scanner scanner, InventoryManager inventoryManager) {
        while (true) {
            System.out.println("Inventory Management");
            System.out.println("1. Add Item");
            System.out.println("2. Update Item Quantity");
            System.out.println("3. Delete Item");
            System.out.println("4. List Items");
            System.out.println("5. Back to Main Menu");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter item name: ");
                    scanner.nextLine();  // Consume newline
                    String itemName = scanner.nextLine();
                    System.out.print("Enter quantity: ");
                    int quantity = scanner.nextInt();
                    inventoryManager.addItem(itemName, quantity);
                    break;
                case 2:
                    System.out.print("Enter item ID: ");
                    int itemId = scanner.nextInt();
                    System.out.print("Enter new quantity: ");
                    quantity = scanner.nextInt();
                    inventoryManager.updateItemQuantity(itemId, quantity);
                    break;
                case 3:
                    System.out.print("Enter item ID: ");
                    itemId = scanner.nextInt();
                    inventoryManager.deleteItem(itemId);
                    break;
                case 4:
                    inventoryManager.listItems();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
