package net.tinnuadan.colouredelytra.event;

import net.tinnuadan.colouredelytra.ColouredElytra;
import net.tinnuadan.colouredelytra.RecipeManager;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.PrepareAnvilEvent;
import org.bukkit.event.inventory.PrepareSmithingEvent;
import org.bukkit.inventory.AnvilInventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.SmithingInventory;
import org.bukkit.inventory.meta.ItemMeta;

public class SmithingTableListener implements Listener
{


  @EventHandler
  void onSmithingTableEvent2(PrepareSmithingEvent event) {
    SmithingInventory inventory = event.getInventory();

    ItemStack elytra = inventory.getItem(0);
    ItemStack dye = inventory.getItem(1);

    if(elytra == null || dye == null) {
      return;
    }

    ItemStack result = ColouredElytra.recipeManager.alterItem(elytra, dye, RecipeManager.AlteringSource.SmithingTable);
    if(result == null) {
      return;
    }
    event.setResult(result);
  }

}
