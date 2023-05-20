package tech.shiftmc.lib

import net.kyori.adventure.text.Component
import org.bukkit.plugin.java.JavaPlugin

class ShiftMcLib(
    plugin: JavaPlugin,
    prefix: Component,
    debug: Boolean,
) {
    companion object {
        lateinit var instance: JavaPlugin
        var prefix: Component = Component.empty()
        var debug: Boolean = false
    }
    
    init {
        instance = plugin
        ShiftMcLib.debug = debug
        ShiftMcLib.prefix = prefix
    }
}