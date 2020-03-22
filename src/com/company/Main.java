package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ArrayList<Product> shoppingCart = new ArrayList<>();

        //Create 5 items
        Product item1 = new Product(1, "pair of shoes", "Something you wear", 25.00);
        Product item2 = new Product(2, "jacket", "Something you wear", 45.00);
        Product item3 = new Product(3, "shirt", "Something you wear", 30.00);
        Product item4 = new Product(4, "pair of pants", "Something you wear", 40.00);
        Product item5 = new Product(5, "pair of socks", "Something you wear", 5.00);

        //add quantity to inventory
        item1.quantity = 50;
        item2.quantity = 50;
        item3.quantity = 50;
        item4.quantity = 50;
        item5.quantity = 50;

        Product[] productsList = {item1, item2, item3, item4, item5};


        System.out.println("Welcome to the store front. Here is a list of our products.");

        System.out.println();

        for (Product product : productsList) {
            System.out.printf("Item Number: %s%n", product.id);
            System.out.printf("Item Name: %s%n", product.name);
            System.out.printf("Item Description: %s%n", product.description);
            System.out.printf("Item Price: %.2f%n", product.price);
            System.out.println("");
        }

        while (true) {

            System.out.println("Use the item number to choose an item to add to your cart.");
            Scanner scanner = new Scanner(System.in);

            int userItemNumberSelection = scanner.nextInt();

//TODO Make it so that the item added to cart is more specific
            switch (userItemNumberSelection) {
                case 1:
                    int quantity1 = GetQuantity(shoppingCart, item1, scanner);

                    System.out.printf("%2$s %s has been added to your cart.%n", item1.name, quantity1);
                    break;
                case 2:
                    int quantity2 = GetQuantity(shoppingCart, item2, scanner);
                    System.out.printf("%2$s %s has been added to your cart.%n", item2.name, quantity2);
                    break;
                case 3:
                    int quantity3 = GetQuantity(shoppingCart, item3, scanner);
                    System.out.printf("%2$s %s has been added to your cart.%n", item3.name, quantity3);
                    break;
                case 4:
                    int quantity4 = GetQuantity(shoppingCart, item4, scanner);
                    System.out.printf("%2$s %s has been added to your cart.%n", item4.name, quantity4);
                    break;
                case 5:
                    int quantity5 = GetQuantity(shoppingCart, item5, scanner);
                    System.out.printf("%2$s %s has been added to your cart.%n", item5.name, quantity5);
                    break;
                default:
                    System.out.println("That is not a correct entry.");
            }

            System.out.printf("Your current %s", CartTotal(shoppingCart));
            System.out.println("Would you like to add another item to your cart? y/n");
            scanner = new Scanner(System.in);
            String addAnotherItem = scanner.nextLine();

            if (addAnotherItem.equalsIgnoreCase("y")) {
                continue;
            } else {
                break;
            }

        }

        System.out.printf("Your final %s", CartTotal(shoppingCart));

    }



    //Methods
    private static String CartTotal(ArrayList<Product> shoppingCart) {
        System.out.println("These are the current items in your cart.");

        for (Product shoppingCartItem : shoppingCart
        ) {
            System.out.printf("Item: %s and it costs %.2f%n", shoppingCartItem.name, shoppingCartItem.price);
        }


        double totalCost = 0;
        for (Product item : shoppingCart) {
            totalCost += item.price;
        }
// Using string format to denote a float number to two decimal spaces
        return String.format(" total is %.2f%n", totalCost);

    }

    private static int GetQuantity(ArrayList<Product> shoppingCart, Product product, Scanner scanner) {
        System.out.printf("How many of item %s would you like to add to your shopping cart?%n", product.name);
        int quantity = scanner.nextInt();
        product.quantity = quantity;
        for (int i = 0; i < quantity; i++) {
            shoppingCart.add(product);
        }
        return quantity;
    }


}
