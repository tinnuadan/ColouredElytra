package net.tinnuadan.colouredelytra;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;

public class RecipeManager
{
  final private HashMap<Material, Colour> colours;

  RecipeManager() {
    colours = new HashMap<>();
  }

  public void addColour(Colour colour) {
    colours.put(colour.getDye(), colour);
  }

  public ItemStack alterItem(ItemStack elytra, ItemStack dye) {
    if(elytra.getType() != Material.ELYTRA) {
      return null;
    }
    if(!colours.containsKey(dye.getType())) {
      return null;
    }
    Colour colour = colours.get(dye.getType());
    ItemStack item = elytra.clone();
    ItemMeta meta = item.getItemMeta();
    assert meta != null;
    // TODO: better renaming
    meta.setDisplayName(String.format("%s Elytra", colour.toString()));
    meta.setCustomModelData(colour.getCustemModelData());
    item.setItemMeta(meta);

    return item;
  }
}