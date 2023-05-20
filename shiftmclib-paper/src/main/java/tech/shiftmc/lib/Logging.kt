package tech.shiftmc.lib

import net.kyori.adventure.text.Component
import org.bukkit.Bukkit
import tech.shiftmc.lib.ShiftMcLib.Companion.debug
import tech.shiftmc.lib.ShiftMcLib.Companion.prefix

// Component methods
// -----------------
fun info(message: Component) = Bukkit.getConsoleSender().sendMessage {
    "<white>[Info]</white> ".asMini()
        .append(prefix)
        .append(message)
}

fun warn(message: Component) = Bukkit.getConsoleSender().sendMessage {
    "<yellow>[Warn]</yellow> ".asMini()
        .append(prefix)
        .append(message)
}

fun error(message: Component) = Bukkit.getConsoleSender().sendMessage {
    "<red>[Error]</red> ".asMini()
        .append(prefix)
        .append(message)
}

fun debug(message: Component) = if (debug) Bukkit.getConsoleSender().sendMessage {
    "<gray>[Debug]</gray> ".asMini()
        .append(prefix)
        .append(message)
} else Unit

// String methods
// --------------

fun info(message: String) = info(message.asMini())
fun warn(message: String) = warn(message.asMini())
fun error(message: String) = error(message.asMini())
fun debug(message: String) = debug(message.asMini())

// Other methods
// -------------

fun info(message: () -> Component) = info(message())
fun warn(message: () -> Component) = warn(message())
fun error(message: () -> Component) = error(message())
fun debug(message: () -> Component) = debug(message())

fun info(message: () -> String) = info(message().asMini())
fun warn(message: () -> String) = warn(message().asMini())
fun error(message: () -> String) = error(message().asMini())
fun debug(message: () -> String) = debug(message().asMini())