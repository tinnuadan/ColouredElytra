package net.tinnuadan.colouredelytra;

import net.tinnuadan.colouredelytra.event.PlayerClickListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class ColouredElytra extends JavaPlugin
{
  private PlayerClickListener playerClickListener;

  @Override
  public void onEnable() {
    Bukkit.addRecipe(Recipe.createRecipe(this, Colour.Black));
    Bukkit.addRecipe(Recipe.createRecipe(this, Colour.Blue));
    Bukkit.addRecipe(Recipe.createRecipe(this, Colour.Brown));
    Bukkit.addRecipe(Recipe.createRecipe(this, Colour.Cyan));
    Bukkit.addRecipe(Recipe.createRecipe(this, Colour.Gray));
    Bukkit.addRecipe(Recipe.createRecipe(this, Colour.Green));
    Bukkit.addRecipe(Recipe.createRecipe(this, Colour.LightBlue));
    Bukkit.addRecipe(Recipe.createRecipe(this, Colour.LightGray));
    Bukkit.addRecipe(Recipe.createRecipe(this, Colour.Lime));
    Bukkit.addRecipe(Recipe.createRecipe(this, Colour.Magenta));
    Bukkit.addRecipe(Recipe.createRecipe(this, Colour.Orange));
    Bukkit.addRecipe(Recipe.createRecipe(this, Colour.Pink));
    Bukkit.addRecipe(Recipe.createRecipe(this, Colour.Purple));
    Bukkit.addRecipe(Recipe.createRecipe(this, Colour.Red));
    Bukkit.addRecipe(Recipe.createRecipe(this, Colour.White));
    Bukkit.addRecipe(Recipe.createRecipe(this, Colour.Yellow));

    playerClickListener = new PlayerClickListener();
    getServer().getPluginManager().registerEvents(playerClickListener, this);

    getLogger().info("Custom Elytra Recipes added");
  }
}