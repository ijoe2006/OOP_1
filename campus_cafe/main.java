package campus_cafe;

import java.util.Scanner;

public class Main {   
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        Menu menu = new Menu(); //bringing the menu file and everything in it into this main
        String menuOption = "";

        do {
            menu.displayMenu(); //menu class has a displayMenu function
            System.out.println("\nPlease make selection: ");
            menuOption = sc.nextLine();
            Product item = menu.getMenuItem(menuOption);

            if (item == null) {
                System.out.println("\nYour selection is invalid"); 
                continue; // go back to menu
            }

            int quality = 2; // example hardcoded value
            item.setQuality(quality);

            System.out.println(String.format(
                "\nYou selected: %s -- %s -- %.2f -- total price: %.2f", 
                item.getId(), item.getName(), item.getBasePrice(), item.price()
            ));

        } while (!menuOption.equals("end")); // <-- closes the loop correctly
    }
}