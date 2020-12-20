package com.nanoplugins.blockhelper;

import com.nanoplugins.blockhelper.listener.BlockPlaceListener;
import org.bukkit.plugin.java.JavaPlugin;

public class BlockHelper extends JavaPlugin {

    @Override
    public void onEnable() {
        new BlockPlaceListener(this);
    }


}
