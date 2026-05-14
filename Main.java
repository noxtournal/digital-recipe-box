// Import java packages
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

// Main class

public class Main {

    // Create scanner and running
    private static Scanner scanner = new Scanner(System.in);
    private static boolean running = true;

    private static RecipeBox recipeBox = new RecipeBox();

    public static void main(String[] args) {

        // Add in recipe box objects

        // 1. Classic Breakfast Waffles
        recipeBox.addRecipe(new Recipe(
            "Classic Waffles", 
            Arrays.asList("Flour", "Sugar", "Baking Powder", "Eggs", "Milk", "Butter"), 
            "Breakfast", "Waffle Iron", 15.0,Arrays.asList(
        "Mix flour sugar baking powder eggs milk and melted butter",
           "Pour batter into waffle iron and cook until golden",
           "Remove waffle and serve warm")));

        // 2. Quick Spicy Ramen
        recipeBox.addRecipe(new Recipe(
            "Spicy Ramen", 
            Arrays.asList("Ramen Noodles", "Sriracha", "Egg", "Green Onions", "Soy Sauce"), 
            "Lunch", "Stovetop", 10.0,
            Arrays.asList(
         "Boil water and cook ramen noodles until tender",
            "Drain most water then add seasoning soy sauce and sriracha",
            "Top with egg and green onions and serve") ));

        // 3. Garlic Butter Salmon
        recipeBox.addRecipe(new Recipe(
            "Garlic Butter Salmon", 
            Arrays.asList("Salmon Fillet", "Garlic", "Butter", "Lemon", "Parsley"), 
            "Dinner", "Oven", 20.0, Arrays.asList(
        "Preheat oven and season salmon with salt pepper and garlic",
            "Place salmon on tray and add butter and lemon slices",
            "Bake until salmon is flaky and cooked through")));

        // 4. Avocado Toast
        recipeBox.addRecipe(new Recipe(
            "Avocado Toast", 
            Arrays.asList("Sourdough Bread", "Avocado", "Red Pepper Flakes", "Lemon Juice"), 
            "Snack", "Toaster", 5.0, Arrays.asList(
        "Toast sourdough bread until crispy",
             "Mash avocado with lemon juice and spread on toast",
             "Sprinkle red pepper flakes and serve immediately")));

        // Print initial main menu
        printMainMenu();

        while (running) {
            showMainMenu();
        }
    }

    // Main menu interface method
    private static void showMainMenu() {
        
        System.out.print("Enter Selection [1-9]: ");

        // Wrap input in try-catch to handle non-integer inputs
        try {
            int choice = scanner.nextInt();
            scanner.nextLine();
            handleMenuChoice(choice);
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter a number between 1 and 9.");
            scanner.nextLine(); // Clear the invalid input
        }
    }


    // Method to print the main menu
    public static void printMainMenu() {

            System.out.println("\n/---------- DIGICIPIE v1.0 ----------\\");
            System.out.println("|                                    |");
            System.out.println("|  1. Add a Recipe                   |");
            System.out.println("|  2. Remove a Recipe                |");
            System.out.println("|  3. Favorite a Recipe              |");
            System.out.println("|  4. Show all Recipes               |");
            System.out.println("|  5. Search for Recipes             |");
            System.out.println("|  6. Cook With Me!                  |");
            System.out.println("|  7. View a Recipe                  |");
            System.out.println("|  8. View Favorite Recipes          |");
            System.out.println("|  9. Exit                           |");
            System.out.println("|                                    |");
            System.out.println("\\------------------------------------/");

        }

    // Method for handling menu choices
    private static void handleMenuChoice(int choice) {
        switch (choice) {
            case 1:
                // Add recipe code
                System.out.println("\n--- ADD A RECIPE ---\n");

                String recipeName;
                while (true) {
                    System.out.print("Enter the name of the recipe: ");
                    recipeName = scanner.nextLine().trim();

                    if (recipeName.isEmpty()) {
                        System.out.println("Recipe name cannot be empty. Please enter a name.");
                        continue;
                    }

                    if (recipeBox.recipeExists(recipeName)) {
                        System.out.println("A recipe named \"" + recipeName + "\" already exists. Please choose a different name.");
                        continue;
                    }
                    printMainMenu();

                    break;
                }

                System.out.print("Enter the ingredients (comma-separated): ");
                String ingredientsInput = scanner.nextLine(); 
                String[] ingredients = ingredientsInput.split(",");
                System.out.println("Breakfast | Lunch | Dinner | Snack | etc.");
                System.out.print("Enter the category: "); 
                String category = scanner.nextLine(); 
                System.out.println("Oven | Stovetop | Microwave | No-Cook | etc.");
                System.out.print("Enter the cook method: ");
                String cookMethod = scanner.nextLine();
                System.out.print("Enter the cook time (in minutes): ");
                double cookTime = scanner.nextDouble();
                scanner.nextLine(); 
                System.out.println("Enter cooking instructions.");
                System.out.println("Separate each step with a period '.'");
                String instructionInput = scanner.nextLine();
                List<String> instructions = Arrays.asList(instructionInput.split("\\s*\\.\\s*"));

                Recipe newRecipe = new Recipe(recipeName, Arrays.asList(ingredients), category, cookMethod, cookTime, instructions);
                recipeBox.addRecipe(newRecipe);

                // Confirmation message!
                System.out.println("\nAdding " + recipeName + " to your recipe box...");
                System.out.println("Done! Returning to main menu...");

                scanner.nextLine(); // Clear the newline character

                printMainMenu();
                break;
            case 2:
                // Remove recipe code
                System.out.println("\n--- REMOVE A RECIPE ---\n");
                System.out.print("Enter the name of the recipe you want to remove: ");
                String recipeToRemove = scanner.nextLine();
        
                recipeBox.removeRecipe(recipeToRemove);

                // Print main menu again after removing recipe
                System.out.println("Done! Returning to main menu...");
                printMainMenu(); 
                break;
            case 3:
              //code to favorite a recipe
              System.out.println("What recipe would you like to favorite?");
              String userFav = scanner.nextLine();
              recipeBox.favoriteRecipe(userFav);
              printMainMenu();
              break;
            case 4:
                // code to show all recipes
                recipeBox.shortList();
                printMainMenu();
                break;
            case 5:
                // code for search features
                System.out.println("\n/--------------------------------\\");
                System.out.println("|                                |");
                System.out.println("|  1. Search by Ingredients      |");
                System.out.println("|  2. Search by Category         |"); 
                System.out.println("|  3. Search by Cooking Method   |");
                System.out.println("|  4. Search by Cook Time        |");
                System.out.println("|                                |");
                System.out.println("/--------------------------------\\");

                int searchMethod = scanner.nextInt();
                scanner.nextLine();

                if (searchMethod == 1){
                  System.out.println("Enter the ingredient you would like to search for");
                  String userIngredient = scanner.nextLine();
                  recipeBox.searchIngredients(userIngredient);
                } else if (searchMethod == 2){
                  System.out.println("Enter the category you would like to search for");
                  String userCategory = scanner.nextLine();
                  recipeBox.searchCategory(userCategory);
                } else if (searchMethod == 3){
                  System.out.println("Enter the cooking method you would like to search for");
                  String userMethod = scanner.nextLine();
                  recipeBox.searchCookMethod(userMethod);
                } else if (searchMethod == 4){
                  System.out.println("How much time do you have? Please enter either short, medium, or long for your time slot.");
                  String userTime = scanner.nextLine();
                  recipeBox.searchTimeSlot(userTime);
                } else {
                  System.out.println("Invalid input!");
                }
                printMainMenu();

                break;
            case 6:
              // code for cook with me feature
              System.out.print("Enter recipe name: ");
              String name = scanner.nextLine();
              Recipe r = recipeBox.getRecipe(name);
              recipeBox.cookWithMe(r, scanner);
              printMainMenu();
              break;
            case 7:
              // code to view a recipe
              System.out.println("Enter the recipe name you would like to view:");
              String recipeToView = scanner.nextLine();
              recipeBox.viewRecipe(recipeToView);
              printMainMenu();

              break;
            case 8:
                // code to view favorite recipes
                System.out.println("Full List of your favorited recipes:");
                recipeBox.getFavorites();
                printMainMenu();
                break;
            case 9:
                System.out.println("Thank you for using Digi-Cipie! Goodbye!");
                running = false;
                break;

            // Invalid number outside of 1-9
            default:
                System.out.println("Invalid option. Please try again.");
        }
    }
    
}