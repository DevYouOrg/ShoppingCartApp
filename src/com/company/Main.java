package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ArrayList<Product> shoppingCart = new ArrayList<>();

        //Create 5 items
        Product item1 = new Product(1, "shoes", "Something you wear", 25.00);
        Product item2 = new Product(2, "jacket", "Something you wear", 45.00);
        Product item3 = new Product(3, "shirt", "Something you wear", 30.00);
        Product item4 = new Product(4, "pants", "Something you wear", 40.00);
        Product item5 = new Product(5, "socks", "Something you wear", 5.00);

        Product[] productsList = {item1, item2, item3, item4, item5};


        System.out.println("Welcome to the store front. Here is a list of our products.");

        for (Product product : productsList) {
            System.out.printf("Item Number: %s%n", product.id);
            System.out.printf("Item Name: %s%n", product.productName);
            System.out.printf("Item Description: %s%n", product.productDescription);
            System.out.printf("Item Price: %.2f%n", product.productPrice);
            System.out.println("");
        }

        while (true) {

            System.out.println("Use the item number to choose an item to add to your cart.");
            Scanner scanner = new Scanner(System.in);

            int userItemNumberSelection = scanner.nextInt();


            switch (userItemNumberSelection) {
                case 1:
                    shoppingCart.add(item1);
                    System.out.println("Item has been added to your cart.");
                    break;
                case 2:
                    shoppingCart.add(item2);
                    System.out.println("Item has been added to your cart.");
                    break;
                case 3:
                    shoppingCart.add(item3);
                    System.out.println("Item has been added to your cart.");
                    break;
                case 4:
                    shoppingCart.add(item4);
                    System.out.println("Item has been added to your cart.");
                    break;
                case 5:
                    shoppingCart.add(item5);
                    System.out.println("Item has been added to your cart.");
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

    private static String CartTotal(ArrayList<Product> shoppingCart) {
        System.out.println("These are the current items in your cart.");

        for (Product shoppingCartItem : shoppingCart
        ) {
            System.out.printf("Item: %s and it costs %.2f%n", shoppingCartItem.productName, shoppingCartItem.productPrice);
        }


        double totalCost = 0;
        for (Product item : shoppingCart) {
            totalCost += item.productPrice;
        }
// Using string format to denote a float number to two decimal spaces
        return String.format(" total is %.2f%n", totalCost);

    }


}
