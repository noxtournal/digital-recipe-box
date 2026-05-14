// RecipeBox class
import java.util.*;


public class RecipeBox {
  private List<Recipe> recipes;
  private List<Recipe> favorites; 

  public RecipeBox() {
    this.recipes = new ArrayList<>();
    this.favorites = new ArrayList<>();
  }

  // Add a recipe to the recipe box
  public void addRecipe(Recipe recipe) {
    recipes.add(recipe);  
  }

  // View a full recipe
  public void viewRecipe(String recipeName) {
    for (Recipe r : recipes) {
        if (r.getRecipeName().equalsIgnoreCase(recipeName)) {
            System.out.println("Name: " + r.getRecipeName());
            System.out.println("Category: " + r.getCategory());
            System.out.println("Cook Method: " + r.getCookMethod());
            System.out.println("Cook Time: " + r.getCookTime() + " mins");
            System.out.println("\nIngredients:");
            for (String ingredient : r.getIngredients()) {
              System.out.println("  » " + ingredient);
            }
            return;
        }
    }
    System.out.println("Recipe not found!");
}    

  // Check whether a recipe already exists by name, using normalized lower-case comparison
  public boolean recipeExists(String recipeName) {
    if (recipeName == null) {
      return false;
    }

    String normalizedName = recipeName.trim().toLowerCase();
    for (Recipe r : recipes) {
      if (r.getRecipeName().trim().toLowerCase().equals(normalizedName)) {
        return true;
      }
    }
    return false;
  }

  // Remove a recipe from the recipe box
  public void removeRecipe(String recipe) {
    for (Recipe r : recipes) {
      if (r.getRecipeName().equalsIgnoreCase(recipe)) {
        recipes.remove(r);
        System.out.println(recipe + " was successfully removed from your recipe box!");
        return;
      }
    }
    System.out.println(recipe + " was not found in your recipe box.");
  }

// Favorite a recipe and add it to the favorites list
public void favoriteRecipe(String recipeName) {
    for (Recipe r : recipes) {
      if (r.getRecipeName().equalsIgnoreCase(recipeName)) {
        if (!favorites.contains(r)) {
          favorites.add(r);
          System.out.println(r.getRecipeName() + " was successfully added to favorites!");
        } else {
          System.out.println("Recipe was already favorited!");
        }
        return;
      }
    }
    System.out.println("Recipe not found!");
}

  // Get favorite recipes
  public void getFavorites(){
    for (Recipe r: favorites){
      System.out.println("   *   " + r.getRecipeName());
    }
  }

  // Search for recipes by ingredient
  public void searchIngredients(String ingredient) {
    List<Recipe> piesWithIng = new ArrayList<>();
        for (Recipe r : recipes) {
          for (String ing : r.getIngredients()) {
            if (ing.toLowerCase().equals(ingredient.toLowerCase())) {
                piesWithIng.add(r);
                break;
            }
        }
    }

    System.out.println("Full list of recipes with " + ingredient + ":");
    for ( Recipe r : piesWithIng){
      System.out.println("  »  " + r.getRecipeName());
    }
}

  // Search by category
  public void searchCategory(String category) {
    List<Recipe> piesInCategory = new ArrayList<>();

    for (Recipe r : recipes){
      if( r.getCategory().equalsIgnoreCase(category)){
        piesInCategory.add(r);
      }
    }
    System.out.println("Full list of recipes in the " + category + " category :");
    for ( Recipe r : piesInCategory){
      System.out.println("  »  " + r.getRecipeName());
    }
  }

  // Search by cook method
  public void searchCookMethod(String method) {
    List<Recipe> piesWithCkMethod = new ArrayList<>();

    for( Recipe r : recipes){
      if ( r.getCookMethod().equalsIgnoreCase(method)){
        piesWithCkMethod.add(r);
      }
    }

    System.out.println("Full list of recipes cooked by " + method + ":");
    for ( Recipe r : piesWithCkMethod){
      System.out.println("  »  " + r.getRecipeName());
    }
  }
  
  //Search by cook time
  public void searchTimeSlot(String length){
    List<Recipe> shortPie = new ArrayList<>();
    List<Recipe> medPie = new ArrayList<>();
    List<Recipe> longPie = new ArrayList<>();

    for(Recipe r: recipes){

        if (r.getCookTime() <= 30.0){
            shortPie.add(r);
        } else if (r.getCookTime() > 30 && r.getCookTime() < 60.0){
            medPie.add(r);
        } else {
            longPie.add(r);
        }
    }

    if (length.equalsIgnoreCase("short")){
        System.out.println("Full list of recipes within short time:");
        for ( Recipe r : shortPie){
          System.out.println("  »  " + r.getRecipeName());
        }
    } else if (length.equalsIgnoreCase("medium")){
        System.out.println("Full list of recipes within medium time:");
        for ( Recipe r : medPie){
          System.out.println("  »  " + r.getRecipeName());
        }
    } else if (length.equalsIgnoreCase("long")){
        System.out.println("Full list of recipes within long time:");
        for ( Recipe r : longPie){
          System.out.println("  »  " + r.getRecipeName());
        }
    }
  }

//display shorthand of all recipes
  public void shortList() {
    System.out.println("\n--- BROWSE RECIPES ---\n");
    
    for (int i = 0; i < recipes.size(); i++) {
        Recipe r = recipes.get(i);
        // Using the "Clean Minimal" style you liked
        System.out.println("   (" + (i + 1) + ") " + r.getRecipeName());
        System.out.println("       " + r.getCategory() + " | " + r.getCookTime() + " mins\n");
    }
    
    System.out.println("----------------------");
  }

  public void cookWithMe(Recipe r, Scanner scanner) {
    if (r == null) {
        System.out.println("Recipe not found!");
        return;
    }
    List<String> steps = r.getInstructions();
    int i = 0;
    while (true) {
        System.out.println("\nStep " + (i + 1) + ": " + steps.get(i));
        System.out.println("1. Next");
        System.out.println("2. Back");
        System.out.println("3. Exit");
        int choice = scanner.nextInt();
        scanner.nextLine();
        if (choice == 1) {
            if (i < steps.size() - 1) i++;
            else System.out.println("Last step already.");
        }
        else if (choice == 2) {
            if (i > 0) i--;
            else System.out.println("First step already.");
        }
        else if (choice == 3) {
            break;
        }
        else {
            System.out.println("Invalid choice.");
        }
    }
}
  //method to get recipe object 
  public Recipe getRecipe(String name) {
      for (Recipe r : recipes) {
          if (r.getRecipeName().equalsIgnoreCase(name)) {
              return r;
          }
      }
      return null;
  }
}

