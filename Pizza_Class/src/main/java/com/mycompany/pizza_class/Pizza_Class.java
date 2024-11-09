/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.pizza_class;

/**
 *
 * @author bapti
 */
import javax.swing.JOptionPane;

public class Pizza_Class {
    // Step 1: Create private variables
    private String size;
    private int cheeseToppings;
    private int pepperoniToppings;
    private int hamToppings;

    // Step 2: Constructor to set pizza details
    public Pizza_Class(String size, int cheese, int pepperoni, int ham) {
        this.size = size;
        this.cheeseToppings = cheese;
        this.pepperoniToppings = pepperoni;
        this.hamToppings = ham;
    }

    // Step 3: Method to calculate pizza cost
    public double calcCost() {
        int basePrice = 0;
        if (size.equals("small")) {
            basePrice = 10;
        } else if (size.equals("medium")) {
            basePrice = 12;
        } else if (size.equals("large")) {
            basePrice = 14;
        }
        return basePrice + 2 * (cheeseToppings + pepperoniToppings + hamToppings);
    }

    // Step 4: Method to return pizza details
    public String getDescription() {
        return "Size: " + size + ", Cheese: " + cheeseToppings + ", Pepperoni: " + pepperoniToppings + ", Ham: " + hamToppings + 
               ", Cost: $" + calcCost();
    }

    public static void main(String[] args) {
        double totalCost = 0;
        int orderMore;

        do {
            // Get user input for pizza details
            String size = JOptionPane.showInputDialog("Enter pizza size (small, medium, large):");
            int cheese = Integer.parseInt(JOptionPane.showInputDialog("Enter number of cheese toppings:"));
            int pepperoni = Integer.parseInt(JOptionPane.showInputDialog("Enter number of pepperoni toppings:"));
            int ham = Integer.parseInt(JOptionPane.showInputDialog("Enter number of ham toppings:"));

            // Create a Pizza_Class object and show description
            Pizza_Class pizza = new Pizza_Class(size, cheese, pepperoni, ham);
            JOptionPane.showMessageDialog(null, pizza.getDescription());

            // Add to total cost
            totalCost += pizza.calcCost();

            // Ask if the user wants to order more
            orderMore = JOptionPane.showConfirmDialog(null, "Do you want to order another pizza?");
        } while (orderMore == JOptionPane.YES_OPTION);

        // Show total cost
        JOptionPane.showMessageDialog(null, "Total cost of all pizzas: $" + totalCost);
    }
}