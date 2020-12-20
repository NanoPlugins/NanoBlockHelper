package com.nanoplugins.blockhelper.listener;

import com.nanoplugins.blockhelper.BlockHelper;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;

public class BlockPlaceListener implements Listener {

    public BlockPlaceListener(BlockHelper plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {

        Player player = event.getPlayer();
        ItemStack itemInHand = player.getItemInHand();

        if (itemInHand.getAmount() != 1) return;


        for (int i = 0; i <= player.getInventory().getSize(); i++) {
            if (i == player.getInventory().getHeldItemSlot()) continue;
            ItemStack item = player.getInventory().getItem(i);

            if (item == null) return;

            if (item.getType() != itemInHand.getType()) return;

            player.setItemInHand(item);
            player.getInventory().setItem(i, null);
            break;
        }

    }

}
