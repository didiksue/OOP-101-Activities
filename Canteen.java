import java.util.Scanner;

public class Canteen {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int itemNumber;
        int quantity;
        char student;
        char orderAgain = 'Y';

        double price = 0;
        double subtotal;
        double discount;
        double orderTotal;

        int totalItems = 0;
        double totalBeforeDiscount = 0;
        double totalDiscount = 0;

        while (orderAgain == 'Y') {

            System.out.println("\n===== MENU =====");
            System.out.println("1. Burger - $80.00");
            System.out.println("2. Pizza - $120.00");
            System.out.println("3. Pasta - $100.00");
            System.out.println("4. Sandwich - $70.00");
            System.out.println("5. Milk Tea - $90.00");

            System.out.print("\nEnter item number: ");
            itemNumber = input.nextInt();

            System.out.print("Enter quantity: ");
            quantity = input.nextInt();

            System.out.print("Are you a student? (Y/N): ");
            student = input.next().toUpperCase().charAt(0);

            if (itemNumber < 1 || itemNumber > 5 ||
                quantity < 1 || quantity > 10 ||
                (student != 'Y' && student != 'N')) {

                System.out.println("\nInvalid order!");

                continue;
            }

            if (itemNumber == 1) {
                price = 80.00;
            }
            else if (itemNumber == 2) {
                price = 120.00;
            }
            else if (itemNumber == 3) {
                price = 100.00;
            }
            else if (itemNumber == 4) {
                price = 70.00;
            }
            else if (itemNumber == 5) {
                price = 90.00;
            }

            subtotal = price * quantity;

            if (student == 'Y' && subtotal >= 500) {
                discount = subtotal * 0.15;
            }
            else if (student == 'Y') {
                discount = subtotal * 0.10;
            }
            else if (subtotal >= 500) {
                discount = subtotal * 0.05;
            }
            else {
                discount = 0;
            }

            orderTotal = subtotal - discount;

            System.out.printf("\nSubtotal: $%.2f%n", subtotal);
            System.out.printf("Discount: $%.2f%n", discount);
            System.out.printf("Order total: $%.2f%n", orderTotal);

            totalItems = totalItems + quantity;
            totalBeforeDiscount = totalBeforeDiscount + subtotal;
            totalDiscount = totalDiscount + discount;

            System.out.print("\nDo you want to order again? (Y/N): ");
            orderAgain = input.next().toUpperCase().charAt(0);
        }

        double finalAmount = totalBeforeDiscount - totalDiscount;

        System.out.println("\n===== ORDER SUMMARY =====");
        System.out.println("Total items: " + totalItems);
        System.out.printf("Total before discount: $%.2f%n",
                totalBeforeDiscount);
        System.out.printf("Total discount: $%.2f%n",
                totalDiscount);
        System.out.printf("Final amount: $%.2f%n",
                finalAmount);

        System.out.println("Thank you for ordering!");

        input.close();
    }
}