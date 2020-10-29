package net.tinnuadan.colouredelytra;

import net.tinnuadan.colouredelytra.event.PlayerClickListener;
import net.tinnuadan.colouredelytra.event.SmithingTableListener;
import org.bukkit.plugin.java.JavaPlugin;

public class ColouredElytra extends JavaPlugin
{
  private PlayerClickListener playerClickListener;
  private SmithingTableListener smithingTableListener;
  static public RecipeManager recipeManager = new RecipeManager();

  @Override
  public void onEnable() {
    recipeManager.addRecipeForColour(this, Colour.Black);
    recipeManager.addRecipeForColour(this, Colour.Blue);
    recipeManager.addRecipeForColour(this, Colour.Brown);
    recipeManager.addRecipeForColour(this, Colour.Cyan);
    recipeManager.addRecipeForColour(this, Colour.Gray);
    recipeManager.addRecipeForColour(this, Colour.Green);
    recipeManager.addRecipeForColour(this, Colour.LightBlue);
    recipeManager.addRecipeForColour(this, Colour.LightGray);
    recipeManager.addRecipeForColour(this, Colour.Lime);
    recipeManager.addRecipeForColour(this, Colour.Magenta);
    recipeManager.addRecipeForColour(this, Colour.Orange);
    recipeManager.addRecipeForColour(this, Colour.Pink);
    recipeManager.addRecipeForColour(this, Colour.Purple);
    recipeManager.addRecipeForColour(this, Colour.Red);
    recipeManager.addRecipeForColour(this, Colour.White);
    recipeManager.addRecipeForColour(this, Colour.Yellow);


    playerClickListener = new PlayerClickListener();
    getServer().getPluginManager().registerEvents(playerClickListener, this);
    smithingTableListener = new SmithingTableListener();
    getServer().getPluginManager().registerEvents(smithingTableListener, this);

    getLogger().info("Custom Elytra Recipes added");
  }
}