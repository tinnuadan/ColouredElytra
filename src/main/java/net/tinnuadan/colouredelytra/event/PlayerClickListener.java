package net.tinnuadan.colouredelytra.event;

import net.tinnuadan.colouredelytra.Colour;
import net.tinnuadan.colouredelytra.ColouredElytra;
import net.tinnuadan.colouredelytra.RecipeManager;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.data.Levelled;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class PlayerClickListener implements Listener
{
  @EventHandler
  public void onClick(PlayerInteractEvent event)
  {
    if(event.getAction() != Action.RIGHT_CLICK_BLOCK) {
      return;
    }
    Block clickedBlock = event.getClickedBlock();
    if(clickedBlock == null || clickedBlock.getType() != Material.CAULDRON) {
      return;
    }
    Levelled cauldronData = (Levelled) clickedBlock.getBlockData();
    if(cauldronData.getLevel() == 0) {
      return;
    }

    Player p = event.getPlayer();
    EntityEquipment equipment = p.getEquipment();
    if(equipment == null) {
      return;
    }
    ItemStack item = equipment.getItemInMainHand();
    if(item.getType() != Material.ELYTRA) {
      return;
    }
    ItemMeta meta = item.getItemMeta();
    if(meta == null || !meta.hasCustomModelData()) {
      return;
    }
    int customModelData = meta.getCustomModelData();
    boolean validCustomModelData = false;
    for(int i=1; i<=16; i++) {
      if(customModelData == Colour.fromCode(i).getCustemModelData()) {
        validCustomModelData = true;
        break;
      }
    }
    if(!validCustomModelData) {
      return;
    }

    //coloured elytra found
    cauldronData.setLevel(cauldronData.getLevel()-1);
    clickedBlock.setBlockData(cauldronData);
//    meta.setCustomModelData(null);
//    item.setItemMeta(meta);
    ColouredElytra.recipeManager.alterItem(item, null, RecipeManager.AlteringSource.Cauldron);
//    equipment.setItemInMainHand(item);
    event.setCancelled(true);
  }
}
