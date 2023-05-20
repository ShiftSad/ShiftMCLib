package tech.shiftmc.lib

import org.bukkit.event.Event
import org.bukkit.event.EventPriority
import org.bukkit.event.Listener
import org.bukkit.plugin.java.JavaPlugin
import tech.shiftmc.lib.ShiftMcLib.Companion.instance

/**
 * Credits: @hazae41
 */

/**
 * Use this method to provide your own JavaPlugin
 * instance.
 */
inline fun <reified T : Event> JavaPlugin.listen(
    priority: EventPriority = EventPriority.NORMAL,
    ignoreCancelled: Boolean = false,
    crossinline callback: (T) -> Unit
) = listen(instance, priority, ignoreCancelled, callback)

/**
 * Use this method to use the JavaPlugin provided
 * in the ShiftMCLib class.
 */
inline fun <reified T : Event> listen(
    instance: JavaPlugin,
    priority: EventPriority = EventPriority.NORMAL,
    ignoreCancelled: Boolean = false,
    crossinline callback: (T) -> Unit
) = instance.server.pluginManager.registerEvent(
    T::class.java, object : Listener {},
    priority, { _, it -> if (it is T) callback(it) },
    instance, ignoreCancelled
)
