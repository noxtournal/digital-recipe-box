// Import java packages
import java.util.*;

// Recipe class

public class Recipe {

  private String recipeName;
  private List<String> ingredients;
  private String category;
  private String cookMethod;
  private double cookTime;
  private List<String> instructions;

  //private String instructions;

  public Recipe(String recipeName, List<String> ingredients, String category, String cookMethod, double cookTime, List<String> instructions) {
    this.recipeName = recipeName;
    this.ingredients = ingredients;
    this.category = category;
    this.cookMethod = cookMethod;
    this.cookTime = cookTime; 
    this.instructions = instructions;

    //this.instructions = instructions;
  }

  public String getRecipeName() {
    return recipeName;
  }

  public List<String> getIngredients() {
    return ingredients;
  }
  public String getCategory() {
    return category;
  }
  public String getCookMethod() {
    return cookMethod;
  }
  public double getCookTime(){
    return cookTime;
  }
  public List<String> getInstructions() {
    return instructions;
}

}

