package deinplugin.deinplugin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import static java.lang.Math.sqrt;

public final class deinplugin extends JavaPlugin implements Listener, CommandExecutor {

    public java.util.List<Player> p = new ArrayList<Player>();
    public java.util.List<Player> gmp = new ArrayList<Player>();
    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this,this);
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "리로드 플러그인이 활성화되었습니다.");
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "제작자 : 준이(ckrgksskawk0@naver.com");

        //command
        getCommand("reloadplugin").setExecutor(this);
    }


    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (args.length != 1) {
            sender.sendMessage("Usage: /reloadplugin <plugin name>");
            return true;
        }

        String pluginName = args[0];
        PluginManager pluginManager = Bukkit.getPluginManager();
        Plugin targetPlugin = pluginManager.getPlugin(pluginName);

        if (targetPlugin == null) {
            sender.sendMessage("플러그인을 찾을 수 없습니다.: " + pluginName);
            return true;
        }

        pluginManager.disablePlugin(targetPlugin);
        pluginManager.enablePlugin(targetPlugin);

        sender.sendMessage("플러그인 리로드: " + pluginName);

        return true;

    }

}
