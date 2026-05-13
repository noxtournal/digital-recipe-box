// RecipeBox class
import java.util.*;


public class RecipeBox {
  private List<Recipe> recipes;
  private List<Recipe> favorites; 

  public RecipeBox() {
    this.recipes = new ArrayList<>();
    this.favorites = new ArrayList<>();
  }

  public void addRecipe(Recipe recipe) {
    recipes.add(recipe);  
  }

  public void removeRecipe(Recipe recipe) {
    recipes.remove(recipe);
  }

 public void favoriteRecipe(Recipe recipe) {
    if (!favorites.contains(recipe)) {
      System.out.println(recipe.getRecipeName() + " was successfully added to favorites!");
      favorites.add(recipe);
    } else {
      System.out.println("Recipe was already favorited!");
    }
}
//implement display favorites method 

  public void searchIngredients(String ingredient) {
    List<Recipe> piesWithIng = new ArrayList<>();
    for (Recipe r : recipes) {

      if (r.getIngredients().contains(ingredient)) {
        piesWithIng.add(r);
      }
    }
    System.out.println("Full list of recipes with " + ingredient + ":");
    System.out.println(piesWithIng); 
    //CONSIDER CHANGING OUTPUT TO FOR LOOP SO EACH RECIPIE IS PRINTED CUTE AND INDIVIDUALLY?!??!?!??!?!?!?
}

  public void searchCategory(String category) {
    List<Recipe> piesInCategory = new ArrayList<>();

    for (Recipe r : recipes){
      if( r.getCategory().equals(category)){
        piesInCategory.add(r);
      }
    }
    System.out.println("Full list of recipes in the " + category + " category :");
    System.out.println(piesInCategory); 
    //CONSIDER CHANGING OUTPUT TO FOR LOOP SO EACH RECIPIE IS PRINTED CUTE AND INDIVIDUALLY?!??!?!??!?!?!?
  }

  public void searchCookMethod(String method) {
    List<Recipe> piesWithCkMethod = new ArrayList<>();

    for( Recipe r : recipes){
      if ( r.getCookMethod().equals(method)){
        piesWithCkMethod.add(r);
      }
    }

    System.out.println("Full list of recipes cooked by " + method + ":");
    System.out.println(piesWithCkMethod); 
    //CONSIDER CHANGING OUTPUT TO FOR LOOP SO EACH RECIPIE IS PRINTED CUTE AND INDIVIDUALLY?!??!?!??!?!?!?

  }

  public void searchTimeSlot(String length){
    List<Recipe> short = new ArrayList();
    List<Recipe> med = new ArrayList();
    List<Recipe> long = new ArrayList();

    for(Recipe r: recipes){

        if (r.getCookTime() <= 30.0){
            short.add(r);
        } else if (r.getCookTime > 30 && r.getcookTime() < 60.0){
            med.add(r);
        } else {
            long.add(r);
        }
    }

    if (length.equalsIgnoreCase("short")){
        System.out.println("Full list of recipes cooked by " + method + ":");
        System.out.println(piesWithCkMethod);

    }


  }

  //left to implement: cook with me method , search by cook time method 
  //idk how to add new files so for rn i just threw everything in here im sorry :sob: 
  //im so discord
}