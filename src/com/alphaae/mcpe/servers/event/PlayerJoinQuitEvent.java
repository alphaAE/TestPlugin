package com.alphaae.mcpe.servers.event;

import cn.nukkit.event.EventHandler;
import cn.nukkit.event.EventPriority;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerJoinEvent;
import cn.nukkit.event.player.PlayerQuitEvent;
import com.alphaae.mcpe.servers.event.block.joinquit.JoinQuitEventBlock;
import com.alphaae.mcpe.servers.event.block.joinquit.JoinWindowBlock;
import com.alphaae.mcpe.servers.event.block.joinquit.LoadPlayerDataBlock;

import java.util.ArrayList;
import java.util.List;

public class PlayerJoinQuitEvent implements Listener {

    private static List<JoinQuitEventBlock> eventBlockList;

    static {
        eventBlockList = new ArrayList<>();
        eventBlockList.add(new JoinWindowBlock());
        eventBlockList.add(new LoadPlayerDataBlock());
    }

    //玩家加入事件
    @EventHandler(ignoreCancelled = true, priority = EventPriority.NORMAL)
    public void onPlayerJoin(PlayerJoinEvent event) {
        for (JoinQuitEventBlock eventBlock : eventBlockList) {
            eventBlock.onPlayerJoin(event);
        }
    }

    //玩家退出事件
    @EventHandler(ignoreCancelled = true, priority = EventPriority.NORMAL)
    public void onPlayerQuit(PlayerQuitEvent event) {
        for (JoinQuitEventBlock eventBlock : eventBlockList) {
            eventBlock.onPlayerQuit(event);
        }
    }

}
