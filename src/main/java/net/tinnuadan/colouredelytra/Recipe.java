package net.tinnuadan.colouredelytra;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

public class Recipe
{
  static ShapelessRecipe createRecipe(JavaPlugin parent, Colour colour)
  {
    assert colour!=Colour.None;
    ItemStack item = new ItemStack(Material.ELYTRA);
    ItemMeta meta = item.getItemMeta();
    assert meta != null;
    meta.setCustomModelData(colour.getCustemModelData());
    item.setItemMeta(meta);

    NamespacedKey key = new NamespacedKey(parent, String.format("%s_elytra", colour.toString().toLowerCase()));
    ShapelessRecipe recipe = new ShapelessRecipe(key, item);

    recipe.addIngredient(Material.ELYTRA);
    recipe.addIngredient(colour.getDye());

    return recipe;
  }
}