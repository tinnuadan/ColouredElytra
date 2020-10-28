package net.tinnuadan.colouredelytra;

import net.tinnuadan.colouredelytra.event.PlayerClickListener;
import net.tinnuadan.colouredelytra.event.SmithingTableListener;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.SmithingRecipe;
import org.bukkit.plugin.java.JavaPlugin;

public class ColouredElytra extends JavaPlugin
{
  private PlayerClickListener playerClickListener;
  private SmithingTableListener smithingTableListener;
  public static RecipeManager recipeManager = new RecipeManager();

  @Override
  public void onEnable() {
    recipeManager.addColour(Colour.Black);
    recipeManager.addColour(Colour.Blue);
    recipeManager.addColour(Colour.Brown);
    recipeManager.addColour(Colour.Cyan);
    recipeManager.addColour(Colour.Gray);
    recipeManager.addColour(Colour.Green);
    recipeManager.addColour(Colour.LightBlue);
    recipeManager.addColour(Colour.LightGray);
    recipeManager.addColour(Colour.Lime);
    recipeManager.addColour(Colour.Magenta);
    recipeManager.addColour(Colour.Orange);
    recipeManager.addColour(Colour.Pink);
    recipeManager.addColour(Colour.Purple);
    recipeManager.addColour(Colour.Red);
    recipeManager.addColour(Colour.White);
    recipeManager.addColour(Colour.Yellow);

    SmithingRecipe recipe = new SmithingRecipe(new NamespacedKey(this, "test"),
      new ItemStack(Material.AIR),
      new RecipeChoice.MaterialChoice(Material.IRON_SHOVEL),
      new RecipeChoice.MaterialChoice(Material.DIAMOND)
      );
    Bukkit.addRecipe(recipe);

    playerClickListener = new PlayerClickListener();
    getServer().getPluginManager().registerEvents(playerClickListener, this);
    smithingTableListener = new SmithingTableListener();
    getServer().getPluginManager().registerEvents(smithingTableListener, this);

    getLogger().info("Custom Elytra Recipes added");
  }
}