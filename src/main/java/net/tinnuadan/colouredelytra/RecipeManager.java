package net.tinnuadan.colouredelytra;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.SmithingRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;

public class RecipeManager
{
  public enum AlteringSource {
    SmithingTable,
    Cauldron
  }
  final private HashMap<Material, Colour> colours;

  RecipeManager() {
    colours = new HashMap<>();
  }

  public void addRecipeForColour(JavaPlugin plugin, Colour colour) {
    Material dye = colour.getDye();
    SmithingRecipe recipe = new SmithingRecipe(new NamespacedKey(plugin, String.format("%s_elytra", colour.toString().toLowerCase())),
      new ItemStack(Material.ELYTRA), // result, overwritten in alter item
      new RecipeChoice.MaterialChoice(Material.ELYTRA), // base
      new RecipeChoice.MaterialChoice(dye) // addition
    );
    Bukkit.addRecipe(recipe);
    colours.put(dye, colour);
  }

  public ItemStack alterItem(ItemStack elytra, @Nullable ItemStack dye, AlteringSource source) {
    if(elytra.getType() != Material.ELYTRA) {
      return null;
    }
    // washing in cauldron -> no dye
    if(source == AlteringSource.Cauldron && dye != null ) {
      return null;
    }
    boolean validColour = dye != null && colours.containsKey(dye.getType());
    if(source == AlteringSource.SmithingTable && !validColour) {
      return null;
    }
    Colour colour = dye == null ? Colour.None : colours.get(dye.getType());
    ItemStack item = source == AlteringSource.Cauldron ? elytra : elytra.clone();
    ItemMeta meta = item.getItemMeta();
    assert meta != null;
    String newName = getItemName(item, colour);
    if(newName != null) {
      meta.setDisplayName(newName);
    }
    meta.setCustomModelData(colour.getCustemModelData());
    item.setItemMeta(meta);

    return item;
  }

  private String getItemName(ItemStack item, Colour newColour) {
    ItemMeta meta = item.getItemMeta();
    assert meta != null;
    Colour currentColour = meta.hasCustomModelData() ? Colour.fromCustomModelData(meta.getCustomModelData()) : Colour.None;

    String currentNameCalculated = calculateName(currentColour);
    String currentName = meta.getDisplayName();
    if(!currentName.equals(currentNameCalculated)) { // Name changed by user, not messing with that
      return null;
    }

    return calculateName(newColour);
  }

  private String calculateName(Colour colour) {
    return colour == Colour.None ? null : String.format("%s Elytra", colour.humanReadableName());
  }
}